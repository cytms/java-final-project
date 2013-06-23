import java.util.Random;

public class Juju {
	private JujuType attr = null;
	private int down = 0;
	private int left = 0;

	Juju() {
		Random random = new Random();
		setAttr(JujuType.values()[random.nextInt(6)]);
	}
	Juju(boolean dump) {
	}
	Juju(Juju DOWN, Juju LEFT) {
		Random random = new Random();
		setAttr(JujuType.values()[random.nextInt(6)]);
		if (DOWN != null && this.attr.equals(DOWN.getAttr())) {
			this.down = DOWN.down + 1;
		}
		if (LEFT != null && this.attr.equals(LEFT.getAttr())) {
			this.left = LEFT.left + 1;
		}
	}

	public JujuType getAttr() {
		return attr;
	}

	public void setAttr(JujuType attr) {
		this.attr = attr;
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
}