
public class Monster {
	String name = null;
	private int blood;
	private int attack_power;
	private int recover_power;
	
	/*
	 * 怪獸屬性
	 * */
	JujuType monster_type = null; //怪物屬性 
	private String imageDir; //怪物圖片路徑
	
	public Monster(){
		this.blood= 0;
		this.attack_power = 0;
		this.recover_power =  0;
	}
	public Monster(String name, int blood, int attack_power,
	               int recover_power, JujuType monster_type,String imageDir){
		this.name = name;
		this.blood= blood;
		this.attack_power = attack_power;
		this.recover_power =  recover_power;
		this.monster_type = monster_type;
		this.imageDir = imageDir;
	}
	
	
	public int get_blood() {
		return blood;
	}
	public void set_blood(int blood) {
		this.blood = blood;
	}
	public int get_attack_power() {
		return attack_power;
	}
	public void set_attack_power(int attack_power) {
		this.attack_power = attack_power;
	}
	public int get_recover_power() {
		return recover_power;
	}
	public void set_recover_power(int recover_power) {
		this.recover_power = recover_power;
	}
	/*
	 * 怪獸屬性set跟get
	 * */
	public void set_type(JujuType type) {
		this.monster_type = type;
	}
	
	public JujuType get_type() {
		return monster_type;
	}
	
	public String get_imageDir() {
		return imageDir;
	}
	public void set_imageDir(String imageDir) {
		this.imageDir = imageDir ;
	}
	
	
	
	public void set_monater_name(String name) {
		this.name = name;
	}
	
	public String get_monater_name() {
		return name;
	}
	
	public int Attack(int beads_number, int frequency) {//輸入消去的次數以及個數計算攻擊數據
		
		return (int) ((beads_number + frequency ) *  this.attack_power * 0.25) ;
	}
	
	
	
}
