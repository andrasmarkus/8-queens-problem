package hu.uszeged.inf.backtrack;

import java.util.Random;

/**
 * This is csabe812's qeen problem
 * 
 * @author csabe812
 * @version 1.0
 *
 */
public class QueenCsabe812 {

	/**
	 * This constant will be used to represent the chess (like a chess) table
	 */
	private final int N = 8;
	private final int startRow = 0;
	private final int startColumn = 0;
	private int prevQueenRow = 0;
	private int prevQueenColumn = 0;
	private int numberOfQueens = 0;
	/**
	 * This is the table
	 */
	private int[][] table;

	public QueenCsabe812() {
		table = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				table[i][j] = 0;
			}
		}
		run();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void putOneQueen(int x, int y) {
		table[x][y] = 1;
		numberOfQueens++;
	}

	/**
	 * Putting a Queen to the given position
	 * 
	 * @param x horizontal position
	 * @param y vertical position
	 */
	public void putQueenTo(int x, int y) {
		if (numberOfQueens == N || x == N || y == N)
			return;
		if (isQueenInValidPosition(x, y)) {
			putOneQueen(x, y);
			putQueenTo(0, y + 1);
		} else {
			movePreviousQueen(x, y-1);
		}
	}

	public void movePreviousQueen(int row, int column) {
		if (column < 0)
			return;
		if(row < 0 && !(column < 0))
			table[prevQueenRow][prevQueenColumn] = 0;
			movePreviousQueen(0, column-1);
			
		//Findig previous queen's position	
		findPreviousQueen(column);
		if (prevQueenRow - 1 >= 0 && isQueenInValidPosition(prevQueenRow - 1, prevQueenColumn)) {
			table[prevQueenRow][prevQueenColumn] = 0;
			numberOfQueens--;
			putOneQueen(prevQueenRow - 1, prevQueenColumn);
		} else if (prevQueenRow - 1 == 0 && !isQueenInValidPosition(prevQueenRow - 1, prevQueenColumn)){
			table[prevQueenRow][prevQueenColumn] = 0;
			numberOfQueens--;
			putOneQueen(prevQueenRow - 1, prevQueenColumn);
			movePreviousQueen(0, prevQueenColumn);
		} else {
			
		}
	}

	
	public void findPreviousQueen(int column) {
		prevQueenRow = -1;
		prevQueenColumn = -1;
		for(int i = 0; i < N ; i++) {
			if(table[i][column] == 1) {
				prevQueenRow = i;
				prevQueenColumn = column;
			}
		}
	}
	
	/**
	 * Checking the Queen's position (which would like to take a new position)
	 * 
	 * @param x horizontal position
	 * @param y vertical posistion
	 * @return true if the Queen's position is valid
	 * 
	 */
	public boolean isQueenInValidPosition(int x, int y) {
		System.out.println("Verti: " + isVerticalValid(x, y));
		return isVerticalValid(x, y) && isHorizontalValid(x, y) && isDiagonalValid(x, y);
	}

	public boolean isVerticalValid(int row, int column) {
		for (int i = 0; i < N; i++) {
			if (table[i][column] != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isHorizontalValid(int row, int column) {
		for (int j = 0; j < N; j++) {
			if (table[row][j] != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean isDiagonalValid(int row, int column) {
		// example row 2 colum 4
		int tempRow = row;
		int tempColum = column;
		System.out.println("ROW_COL: " + row + " " + column + " N: " + N);
		while (tempRow < N - 1 && tempColum < N - 1) {
			if (table[tempRow][tempColum] != 0) {
				return false;
			}
			tempRow++;
			tempColum++;
		}
		tempRow = row;
		tempColum = column;
		while (tempRow >= 0 && tempColum >= 0) {
			if (table[tempRow][tempColum] != 0) {
				return false;
			}
			tempRow--;
			tempColum--;
		}
		tempRow = row;
		tempColum = column;
		while (tempRow >= 0 && tempColum < N-1) {
			if (table[tempRow][tempColum] != 0) {
				return false;
			}
			tempRow--;
			tempColum++;
		}
		tempRow = row;
		tempColum = column;
		while (tempRow < N-1 && tempColum >= 0) {
			if (table[tempRow][tempColum] != 0) {
				return false;
			}
			tempRow++;
			tempColum--;
		}
		return true;
	}

	/**
	 * 
	 * Runs the problem Putting a Queen to the first column (random row)
	 * 
	 */
	public void run() {
		putQueenTo(startRow, startColumn);
	}

	public static void main(String[] args) {
		new QueenCsabe812();
	}

}
