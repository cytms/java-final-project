public class Health {
	private int HP = 0;
	private int HPS;
	
	Health(Monster a, Monster b, Monster c, Monster d, Monster e) {
		this.setHP(a.get_blood() + b.get_blood() + c.get_blood()
				+ d.get_blood() + e.get_blood());
		HPS = this.getHP();
	}

	public void underAttack(int damage) {
		this.setHP(this.getHP() - damage);
	}

	public void Recovery(int blood) {
		int temp =this.getHP() + blood;
		if(temp>HPS)
		HP=HPS;
		else
		this.setHP(this.getHP() + blood);
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}
}