import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


public class Platform {
	public final int WIDTH = 6;
	public final int HEIGHT = 5;
	Window w;

	Juju[][] panel = new Juju[WIDTH][HEIGHT];
	/* constructor 
	 * random generation
	 * 不能有三連珠
	 */
	public Platform(Window w) {
		//不能有三連珠
		this.w = w;
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				set_juju(i, j);
				while(panel[i][j].getDown() == 2 || panel[i][j].getLeft() == 2)
					set_juju(i,j);
			}
		}
	}
	public List<HashMap<JujuType, Integer>> update_juju(){
		setNeighbors();
		HashMap<JujuType, Integer> counter = new HashMap<JujuType, Integer>();
		HashMap<JujuType, Integer> num = new HashMap<JujuType, Integer>();
		for (JujuType e : JujuType.values()) {
			counter.put(e, 0);
			num.put(e, 0);
		}
		List<HashMap<JujuType, Integer>> result = new ArrayList<HashMap<JujuType, Integer>>();
		for (int i = WIDTH-1; i >= 0; i--) {
			for (int j = HEIGHT-1; j >= 0; j--) {
				//System.out.println("i = " + i + "; j = " + j);
				if (panel[i][j].getDown() >= 2) {
					counter.put(panel[i][j-1].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
					counter.put(panel[i][j-1].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getDown() + 1);
					//System.out.println("get down = " + (j-panel[i][j].getDown()));
					int tmp = panel[i][j].getDown();
					for (int down = j; down >= (j - tmp); down--) {
						//System.out.println("down counter = " + down);
						//System.out.println(panel[i][j].getAttr().toString() + i + j + " down side = " + down);
						//System.out.println("clean panel[" + i + "][" + down + "] = " + panel[i][down].getDown() );
						panel[i][down].setAttr(null);
						panel[i][down].setDown(0);
					}
				} 
				if (panel[i][j].getLeft() >= 2) {
					counter.put(panel[i-1][j].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
					counter.put(panel[i-1][j].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getLeft() + 1);
					//System.out.println("get left = " + (i -panel[i][j].getLeft()));
					int tmp = panel[i][j].getLeft();
					for (int left = i; left >= (i - tmp); left--) {
						//System.out.println("left counter = " + left);
						//System.out.println(panel[i][j].getAttr().toString() + i + j + " left side = " + left);
						//System.out.println("clean panel[" + left + "][" + j + "] = " + panel[left][j].getLeft());
						panel[left][j].setAttr(null);
						panel[left][j].setLeft(0);
					}
				}
			}
		}
		result.add(counter);
		result.add(num);
		return result;
	}
	public void refill(){
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				panel[i][j].setDown(0);
				panel[i][j].setLeft(0);
				if (panel[i][j].getAttr() == null) {
					for (int s = j; s < HEIGHT-1; s++)
						panel[i][s].setAttr(panel[i][s+1].getAttr());
					panel[i][HEIGHT-1].setAttr(null);
				}
			}
		}
		setNeighbors();
		
	}
	public void setNeighbors () {
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (panel[i][j].getAttr() == null) {
					//System.out.println("set[" + i + "]["+ j + "]");
					panel[i][j].setAttr(JujuType.values()[new Random().nextInt(6)]);
				}
				if (j != 0 && panel[i][j-1].getAttr().equals(panel[i][j].getAttr()))
					panel[i][j].setDown(panel[i][j-1].getDown() + 1);
				if (i != 0 && panel[i-1][j].getAttr().equals(panel[i][j].getAttr()))
					panel[i][j].setLeft(panel[i-1][j].getLeft() + 1);
				//System.out.println("panel[" + i + "][" + j + "]\t" + panel[i][j].getLeft() + "\t" + panel[i][j].getDown());
			}
		}
	}
	public void set_juju(int i, int j) {
		Juju down = null;
		Juju left = null;
		
		if (i == 0)
			left = null;
		else
			left = panel[i-1][j];

		if (j == 0)
			down = null;
		else
			down = panel[i][j-1];
		
		
		panel[i][j] = new Juju(down, left, w);
	}
	/** release(): release all Jujus in the panel
	 * called when the mouse is released from one of the Jujus.
	 */
	public void release(){
		int countPressed = 0;
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (panel[i][j].isPressed) countPressed++; 
				panel[i][j].isPressed = false;
			}
		}	
		System.out.println(countPressed);
	}
	public JujuPosition getJujuPosition(Juju x){
		int a = 0;
		int b = 0;
		for (int i = 0 ; i < WIDTH; i++){
		    for(int j = 0 ; j < HEIGHT ; j++){
		         if ( panel[i][j] == x){
		        	 a = i;
		        	 b = j;
		             break;
		         }
		    }		
		}
		return new JujuPosition(a,b); 
	}	
}
