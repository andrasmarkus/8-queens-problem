package hu.uszeged.inf.backtrack;

/**
 * This is csabe812's Queen problem
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
	private final int startColumn = 0;
	/**
	 * This is the table
	 */
	private int[][] table;

	/**
	 * Default constructor for initializing table, etc.
	 */
	public QueenCsabe812() {
		long startTime = System.nanoTime();
		table = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				table[i][j] = 0;
			}
		}
		run();
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Runtime in nanoseconds: " + totalTime);
	}

	/**
	 * Prints the given table
	 */
	public void printTable() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Putting a Queen to the given position: This is the main part of the program
	 * using a backtracking algorithm. If the column's number is bigger than the
	 * N-qeen (so it's done and we successfully put N-Queen) Otherwise: iterate
	 * through the columns and check if the position is valid. If so then put a
	 * Queen and continue with the next column using the current method recursively.
	 * If we cannot put a Queen to the given column (all rows with 0) --> recursive
	 * + backtracking <3
	 * 
	 * @param column the given column where we try to put a Queen
	 * @return
	 */
	public boolean putQueenTo(int column) {
		if (column >= N)
			return true;
		for (int i = 0; i < N; i++) {
			if (isQueenInValidPosition(i, column)) {
				table[i][column] = 1;
				if (putQueenTo(column + 1)) {
					return true;
				}
				table[i][column] = 0;
			}
		}
		return false;
	}

	/**
	 * Checking the Queen's position (which would like to take a new position)
	 * 
	 * @param x horizontal position
	 * @param y vertical position
	 * @return true if the Queen's position is valid
	 * 
	 */
	public boolean isQueenInValidPosition(int x, int y) {
		return isHorizontalValid(x, y) && isDiagonalValid(x, y);
	}

	/**
	 * Vertical validation.
	 * 
	 * @param row    The given row
	 * @param column The given column
	 * @return true, if vertical valid
	 */
	public boolean isVerticalValid(int row, int column) {
		for (int i = 0; i < N; i++) {
			if (table[i][column] != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Horizontal validation
	 * 
	 * @param row    The given row
	 * @param column The given column
	 * @return true, if horizontal valid
	 */
	public boolean isHorizontalValid(int row, int column) {
		for (int j = 0; j < column; j++) {
			if (table[row][j] != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Diagonal validation: Note: we only check those diagonals where a Queen might
	 * have already been put
	 * 
	 * @param row    The given row
	 * @param column The given column
	 * @return true, if diagonal valid
	 */
	public boolean isDiagonalValid(int row, int column) {
		int i = row;
		int j = column;
		while (i >= 0 && j >= 0) {
			if (table[i][j] != 0) {
				return false;
			}
			i--;
			j--;
		}
		i = row;
		j = column;
		while (i < N && j >= 0) {
			if (table[i][j] != 0) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	/**
	 * 
	 * Runs the problem Putting a Queen to the first column (random row)
	 * 
	 */
	public void run() {
		putQueenTo(startColumn);
		printTable();
	}
}
