public class BadMonster extends Monster {
	private final int cold_down;
	private int cold_down_now;

	public BadMonster(String name, int blood, int attack_power,
			int recover_power, JujuType monster_type, String imageDir,
			int cold_down) {
		super(name, blood, attack_power, recover_power, monster_type, imageDir);
		this.cold_down = cold_down;
		cold_down_now = cold_down;
	}

	public int get_cold_down() {
		return cold_down;
	}

	public int get_cold_down_now() {
		return cold_down_now;
	}

	public void Round_cold_down() {// use get_cold_down() to decide Attack or
									// not. Round_cold_down last
		if (cold_down_now > 1)
			cold_down_now = cold_down_now - 1;
		else if (cold_down_now == 1)
			cold_down_now = cold_down;
	}

}
