
public class Minefield {
	Square[][] grid;
	String loss = "loss";
	String cont = "cont";
	int rowTotal = 0;
	int columnTotal = 0;
	int mineTotal = 0;
	
	
	public Minefield(int rowTotal, int columnTotal, int mineTotal) {
		this.rowTotal = rowTotal;
		this.columnTotal = columnTotal;
		this.mineTotal = mineTotal;
		grid = new Square[rowTotal][columnTotal];
		for (int row = 0; row < rowTotal; row++) {
			for (int column = 0; column < columnTotal; column++) {
				grid [row][column] = new Square(row,column);
			}
		}
		randomizeMines();
		countMine();
	}
	
	public boolean checkMinefield(int row, int column) {
		return (grid[row][column].getMine());
	}
	
	private void countMine() {
		for (int row = 0; row < rowTotal; row++) {
			for (int column = 0; column < columnTotal; column++) {
				int mineCount = 0;
				try {
					if (grid[row - 1][column - 1].getMine())
						mineCount++;
				} catch (Exception e) {
					;
				}
				try {
					if (grid[row - 1][column].getMine())
						mineCount++;
				} catch (Exception e) {
					;
				}
				try {
					if (grid[row - 1][column + 1].getMine())
						mineCount++;
				} catch (Exception e) {
					;
				}
				try {
					if (grid[row][column - 1].getMine())
						mineCount++;
				} catch (Exception e) {
					;
				}
				try {
					if (grid[row][column + 1].getMine())
						mineCount++;
				} catch (Exception e) {
					;
				}
				try {
					if (grid[row + 1][column - 1].getMine())
						mineCount++;
				} catch (Exception e) {
					;
				}
				try {
					if (grid[row + 1][column].getMine())
						mineCount++;
				} catch (Exception e) {
					;
				}
				try {
					if (grid[row + 1][column + 1].getMine())
						mineCount++;
				} catch (Exception e) {
					;
				}
				grid[row][column].setMineCount(mineCount);
			}
		}
	}

	public String uncoverSquare(int row, int column, boolean flag) {
		
		if (flag) {
			if (grid[row][column].getFlag()) {
				grid[row][column].setFlag(false);
			} else {
				grid[row][column].setFlag(true);
				grid[row][column].setCovered(false);
			}
			return cont;
		} else if (grid[row][column].getMine()) {
			grid[row][column].setCovered(false);
			return loss;
		} else if (!grid[row][column].getCovered()) {
			return cont;
		} else 
			keepUncovering(row, column);
			return cont;
	}
		
	public void keepUncovering(int row, int column) {
		if (grid[row][column].getCovered()) {
			grid[row][column].setCovered(false);
			if (grid[row][column].getMineCount() == 0) {

					if ((row - 1) >= 0) {
						keepUncovering(row - 1, column);
					}
				
					if ((row + 1) < rowTotal) {
						keepUncovering(row + 1, column);
					}
				
					if ((column - 1) >= 0) {
						keepUncovering(row, column - 1);
					}
				
					if ((column + 1) <= columnTotal) {
						keepUncovering(row, column + 1);
					}
			} else
				return;
		} else
			return;

	}
	
	public void uncoverAllSquare() {
		for (int row = 0; row < rowTotal; row++) {
			for(int column = 0; column < columnTotal; column++) {
				grid[row][column].setCovered(false);
			}
		}
	}
	
	private void randomizeMines() {
		for (int i = 0; i < mineTotal; i++) {
			int rowRandom =(int) (Math.random() * rowTotal);
			int columnRandom = (int) (Math.random() * columnTotal);
			if (grid[rowRandom][columnRandom].getMine()){
				continue;
			} else {
				grid[rowRandom][columnRandom].setMine(true);
			}
		}
	}
	
	public void printField() {
		for (int row = 0; row < rowTotal; row++ ) {
			for (int column = 0; column < columnTotal; column++) {
				if (grid[row][column].getCovered()) {
					System.out.print("[\u2588]");
				} else if (grid [row][column].getFlag()) {
					System.out.print("[\u2020]");
				} else if (grid [row][column].getMine()) {
					System.out.print("[X]");
				} else if (grid [row][column].getMineCount() == 0) {
					System.out.print("[ ]");
				} else if (grid [row][column].getMineCount() != 0 ) {
					System.out.print("[" + grid [row][column].getMineCount() + "]");
				}
			}	
			System.out.println();
		}
	}
	
	//print field
	//uncover method - continually uncover adjacent cells until it hits a cell with a count
	//show all mines
	//
	
	
}
