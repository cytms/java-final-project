import java.util.Random;

public class Juju {
	private JujuType attr = null;
	private int up = 0;
	private int down = 0;
	private int left = 0;
	private int right = 0;

	Juju() {
		Random random = new Random();
		setAttr(JujuType.values()[random.nextInt(6)]);
	}

	Juju(Juju UP, Juju DOWN, Juju LEFT, Juju RIGHT) {
		Random random = new Random();
		setAttr(JujuType.values()[random.nextInt(6)]);
		if (UP != null && this.attr.equals(UP.getAttr())) {
			this.up = UP.up + 1;
		}
		if (DOWN != null && this.attr.equals(DOWN.getAttr())) {
			this.down = DOWN.down + 1;
		}
		if (LEFT != null && this.attr.equals(LEFT.getAttr())) {
			this.left = LEFT.left + 1;
		}
		if (RIGHT != null && this.attr.equals(RIGHT.getAttr())) {
			this.right = RIGHT.right + 1;
		}
	}

	public JujuType getAttr() {
		return attr;
	}

	public void setAttr(JujuType attr) {
		this.attr = attr;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}
	
}