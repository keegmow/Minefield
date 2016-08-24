
public class Square {
	private boolean mine = false;
	private boolean covered = true;
	private boolean flag = false;
	public int locationRow = 0;
	public int locationColumn = 0;
	private int mineCount = 0;
	
	public Square(int r, int c) {
		locationRow = r;
		locationColumn = c;

	}
	
	public boolean getMine() {
		return mine;
	}
	public void setMine(boolean b) {
		mine = b;
	}
	
	public int getMineCount() {
		return mineCount;
	}
	public void setMineCount(int mc) {
		mineCount = mc;
	}
	
	
	public boolean getCovered() {
		return covered;
	}
	public void setCovered(boolean b) {
		covered = b;
	}
	
	public boolean getFlag() {
		return flag;
	}
	public void setFlag(boolean b) {
		flag = b;
	}
	
//Get/Set flag
//get/set cover
	
}
