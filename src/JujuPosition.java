
public class JujuPosition {
	private int x;
	private int y;
	public JujuPosition(int a, int b){
		this.x = a;
		this.y = b;
	}
	public void setIndex(int a, int b){
		this.x = a; this.y = b;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	public String toString(){
		return "("+x+", "+y+")";
	}
}
