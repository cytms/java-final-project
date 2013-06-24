
public class MonsterData {
	public BadMonster Boss;
	public Monster a ;
	public Monster b ;
	public Monster c ;
	public Monster d ;
	public Monster e ;
	private int totalAttack;
	private int thisRecover;
	Health hp;
	
	 MonsterData(){
		  Boss = new BadMonster("Chuin", 5000000, 1800, 3,JujuType.LIGHT, "monster/CHUIN.jpg", 4);
		    a  = new Monster("Gumdam", 600, 150, 400, JujuType.WOOD,"monster/GUMDAM.jpg");
		    b  = new Monster("RockmanX", 1000, 255, 50, JujuType.AQUA,"monster/ROCKMANX.jpg");
			c  = new Monster("Rockman", 733, 200, 250, JujuType.DARK,"monster/ROXKMAN.jpg");
			d  = new Monster("Digidragon", 500, 700, 0, JujuType.LIGHT,"monster/DIGIDRAGON.jpg");
			e  = new Monster("Zero", 633, 540, 100, JujuType.FIRE,"monster/ZERO.jpg");
			totalAttack=0;
			thisRecover=0;
			health();
	 }
	 
	 public int recovery(){
		return a.get_recover_power()+b.get_recover_power()+
				c.get_recover_power()+d.get_recover_power()+e.get_recover_power();
	 }
	 
	 private void health(){
		  hp = new Health(a, b, c, d, e)	;
		 }
	 public int get_hp(){
		 int a = hp.getHP() ;
		 return a;
	 }
	 
	 public void set_totalAttack(int attack){
		 totalAttack=attack;
	 }
     public int get_totalAttack(){
		 int a = totalAttack;
		 return a;
	 }
     
     public void set_thisRecover(int recover){
    	 thisRecover=recover;
	 }
     public int get_thisRecover(){
		 int a = thisRecover;
		 return a;
	 }
     
     
     public void oneRound(){
    	System.out.println("ATTACK:"+get_totalAttack());
 		Boss.get_damage(get_totalAttack());
 		set_totalAttack(0);
 		
 		System.out.println("Boss blood:"+Boss.get_blood());
 		
 		hp.Recovery(get_thisRecover());
 		System.out.println("recovery"+get_thisRecover());
 		if(Boss.Round_cold_down()==Boss.get_cold_down())
 		hp.underAttack(Boss.get_attack_power());
 		
 		set_thisRecover(0);
 		System.out.println("Boss CD:"+Boss.get_cold_down_now());
 	}
}
