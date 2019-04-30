package hu.uszeged.inf.backtrack;

import java.util.ArrayList;

public class Queen{
	public int x,y;
		
	Queen(int x,int y){
		this.x=x;
		this.y=y;
		map[this.x][this.y]=this;
		queenList.add(this);
	}
	
	public static ArrayList<Queen> queenList = new ArrayList<Queen>();
	public static Queen[][] map = new Queen[8][8]; 
	
	// checks how many queens can be seen in the given position
	public static int checkPosition(int x, int y) {
		int counter=0;
		
		// row and column check
		for(int i=0;i<8;i++) {
			// row
			if(map[i][y]!=null) {
				counter++;
				//System.out.println("a: "+i+":"+y);
			}
			// coloumn
			if(map[x][i]!=null) {
				counter++;
				//System.out.println("b: "+x+":"+i);
			}
		}
		
		// diagonal directions
		int j=y;
		int i=x;
		while(j>=0 && i>=0) {
			if(map[i][j]!=null) {
				counter++;
				//System.out.println("c: "+i+":"+j);
			}
			j--;
			i--;
		}
		j=y;
		i=x;
		while(j<=7 && i>=0) {
			if(map[i][j]!=null) {
				counter++;
				//System.out.println("d: "+i+":"+j);
			}
			j++;
			i--;
		}
		j=y;
		i=x;
		while(j<=7 && i<=7) {
			if(map[i][j]!=null) {
				counter++;
				//System.out.println("e: "+i+":"+j);
			}
			j++;
			i++;
		}
		j=y;
		i=x;
		while(j>=0 && i<=7) {
			if(map[i][j]!=null) {
				counter++;
				//System.out.println("f: "+i+":"+j);
			}
			j--;
			i++;
		}
		
		if(map[x][y]!=null) {
			counter-=5;
		}
		return counter;
	}
		
	// prints the map row-by-row
	public static void print() {
		for(int j=0;j<8;j++) {
			for(int i=0;i<8;i++) {
				if(map[i][j]!=null) {
					System.out.print("X ");
				}else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// checks if the actual placement fits
	public static boolean correctPlacement() {
		int counter = 0;
	
		for(int j=0;j<8;j++) {
			for(int i=0;i<8;i++) {
				if(map[i][j]!=null && checkPosition(i,j)==1 ) {
					counter++;
				}
			}
		}
		if(counter==8) {
			return true;
		}
		return false;
	}
	
	// moves a queen one step forward or to the beginning of the row
	public void step() {
		if(this.x==7) {
			map[this.x][this.y]=null;
			this.x=0;
			map[this.x][this.y]=this;
		}else {
			map[this.x][this.y]=null;
			this.x++;
			map[this.x][this.y]=this;
		}
	}
	
	public static boolean checkValidStep(Queen q) {
			
			if(checkPosition(q.x, q.y)==1) {
				return true;
			}else {
				
			}
		
		return false;
	}
	
	// the algorithm places the queens 
	public static void place() {
		int row = 0;
		boolean moved = false;
		while(!correctPlacement()) {
			
			if(queenList.size()==row && moved==false) {
				new Queen(0, row);
			}
			
			
			if(checkPosition(queenList.get(row).x,queenList.get(row).y)==1 && moved==false) {
				row++;

			}else{
				if(queenList.get(row).x==7) {
					map[queenList.get(row).x][queenList.get(row).y]=null;
					queenList.remove(row);
					row--;
					moved=true;
				}else {
					queenList.get(row).step();
					moved=false;
				}
			}
			
			
			print();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
        place();        
        print();
        // csabe812's solution
        new QueenCsabe812();
	}
}
