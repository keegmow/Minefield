
public class Minefield {
	Square[][] grid;
	
//	int row = 0;
//	int column = 0;
	
	public Minefield(int row, int column) {
		Square [][] grid = new Square[row][column];
		
	}
	
	public boolean checkMinefield(int r, int c) {
		return (grid[r][c].getMine());
	}
	
	public void countMine(int r, int c) {
		int mineCount = 0;
		
		if (grid[r-1][c-1].getMine())
			mineCount++;
		if (grid[r-1][c].getMine())
			mineCount++;
		if (grid[r-1][c+1].getMine())
			mineCount++;
		if (grid[r][c-1].getMine())
			mineCount++;
		if (grid[r][c+1].getMine())
			mineCount++;
		if (grid[r+1][c-1].getMine())
			mineCount++;
		if (grid[r+1][c].getMine())
			mineCount++;
		if (grid[r+1][c+1].getMine())
			mineCount++;
			
		grid[r][c].setMineCount(mineCount);
	}

	
}
