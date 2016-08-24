
public class Minefield {
	Square[][] grid;
	String loss = "loss";
	String cont = "cont";
	String win = "win";
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
				grid[row][column].setCovered(true);
			} else {
				grid[row][column].setFlag(true);
				grid[row][column].setCovered(false);
			}
			return cont;
		} else if (grid[row][column].getMine()) {
			grid[row][column].setCovered(false);
			uncoverAllMines();
			return loss;
		} else if (!grid[row][column].getCovered()) {
			return cont;
		} else if (checkForWin()) {
			grid[row][column].setCovered(false);
			return win;
		} else 
			keepUncovering(row, column);
			return cont;
	}
		
	private void keepUncovering(int row, int column) {
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
				
					if ((column + 1) < columnTotal) {
						keepUncovering(row, column + 1);
					}
					
					if (((row - 1) >= 0 && (column - 1) >= 0) 
							&& !grid[row - 1][column].getCovered()
							&& !grid[row][column - 1].getCovered()) {
						keepUncovering(row - 1, column - 1);
					}
					
					if (((row - 1) >= 0 && (column + 1) < columnTotal) 
							&& !grid[row - 1][column].getCovered()
							&& !grid[row][column + 1].getCovered()) {
						keepUncovering(row - 1, column + 1);
					}
					
					if (((row + 1) < rowTotal && (column + 1) < columnTotal) 
							&& !grid[row + 1][column].getCovered()
							&& !grid[row][column + 1].getCovered()) {
						keepUncovering(row + 1, column + 1);
					}
					
					if (((row + 1) < rowTotal && (column - 1) >= 0) 
							&& !grid[row + 1][column].getCovered()
							&& !grid[row][column - 1].getCovered()) {
						keepUncovering(row + 1, column - 1);
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
		System.out.println();
		for (int row = -1; row < rowTotal; row++ ) {
			for (int column = -1; column < columnTotal; column++) {
				if (row == -1 && column == -1) {
					System.out.print("   ");
					continue;
				}
				
				if (row == -1 && column < 9) {
					System.out.print(" 0" + (column + 1) + " ");
					continue;
				} else if (row == -1) {
					System.out.print(" " + (column + 1) + " ");
					continue;
				}
				
				if (column == -1 && row < 9) {
					System.out.print("0" + (row + 1) + " ");
					continue;
				} else if (column == -1) {
					System.out.print((row + 1) + " ");
					continue;
				}
				
				if (grid[row][column].getCovered()) {
					System.out.print("[\u2588\u2588]");
				} else if (grid [row][column].getFlag()) {
					System.out.print("[!!]");
				} else if (grid [row][column].getMine()) {
					System.out.print("[XX]");
				} else if (grid [row][column].getMineCount() == 0) {
					System.out.print("[  ]");
				} else if (grid [row][column].getMineCount() != 0 ) {
					System.out.print("[ " + grid [row][column].getMineCount() + "]");
				}
			}	
			System.out.println();
		}
		System.out.println();
	}
	
	private boolean checkForWin() {
		int uncoveredCount = 0;
		int flagCount = 0;
		int maxSquares = (rowTotal * columnTotal) - mineTotal;
		for (int row = 0; row < rowTotal; row++) {
			for (int column = 0; column < columnTotal; column++) {
				if (!grid[row][column].getCovered() && !grid[row][column].getMine()) {
					uncoveredCount++;
				}
				if (grid[row][column].getFlag() && grid[row][column].getMine()) {
					flagCount++;
				}
			}
		}
		if (uncoveredCount == maxSquares || flagCount == mineTotal){
			return true;
		} else {
			return false;
		}
	}
	
	private void uncoverAllMines(){
		for (int row = 0; row < rowTotal; row++) {
			for(int column = 0; column < columnTotal; column++) {
				if (grid[row][column].getMine()) {
					grid[row][column].setCovered(false);
				}
			}
		}
	}
	
	
//	public void newPrintField() {
//		for (int row = 0; row < rowTotal; row++ ) {
//			for (int column = 0; column <= columnTotal; column++) {
//				if (column == 0 && row == 0) {
//					System.out.print("\u2554");
//				} else if (column == (columnTotal) && row == 0) {
//					System.out.print("\u2550" + "\u2557");
//					continue;
//				} else if (row == 0) {
//					System.out.print("\u2550" + "\u2566");
//				}
//				System.out.print("\u2551");
//				if (grid[row][column].getCovered()) {
//					System.out.print("\u2588");
//				} else if (grid [row][column].getFlag()) {
//					System.out.print("\u2020");
//				} else if (grid [row][column].getMine()) {
//					System.out.print("X");
//				} else if (grid [row][column].getMineCount() == 0) {
//					System.out.print(" ");
//				} else if (grid [row][column].getMineCount() != 0 ) {
//					System.out.print(grid [row][column].getMineCount());
//				}
//				if (column == (columnTotal) {
//					
//				}
//				
//				
//			}
//		}
//	}
	
}
	
	//print field
	//uncover method - continually uncover adjacent cells until it hits a cell with a count
	//show all mines
	//