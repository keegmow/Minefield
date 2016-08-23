
public class Square {
	private boolean mine = false;
	public boolean covered = true;
	public boolean flag = false;
	public int locationRow = 0;
	public int locationColumn = 0;
	private int mineCount = 0;
	
	public Square(int r, int c, boolean mine) {
		locationRow = r;
		locationColumn = c;
		this.mine = mine;
	}
	
	public boolean getMine() {
		return mine;
	}
	
	public void setMine(boolean b) {
		mine = b;
	}
	
	public void setMineCount(int mc) {
		mineCount = mc;
	}
	
	public int getMineCount() {
		return mineCount;
	}
	
//Get/Set flag
//get/set cover
	
}
