import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Platform {
	public final int WIDTH = 6;
	public final int HEIGHT = 5;

	Juju[][] panel = new Juju[WIDTH][HEIGHT];
	/* constructor 
	 * random generation
	 * 不能有三連珠
	 */
	public Platform() {
		//不能有三連珠
		
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				set_juju(i, j);
				while(panel[i][j].getUp() == 2 || panel[i][j].getDown() == 2 || panel[i][j].getLeft() == 2 || panel[i][j].getRight() == 2)
					set_juju(i,j);
			}
		}
	}
	public List<HashMap<JujuType, Integer>> update_juju(){
		HashMap<JujuType, Integer> counter = new HashMap<JujuType, Integer>();
		HashMap<JujuType, Integer> num = new HashMap<JujuType, Integer>();
		for (JujuType e : JujuType.values()) {
			counter.put(e, 0);
			counter.put(e, 0);
		}
		List<HashMap<JujuType, Integer>> result = new ArrayList<HashMap<JujuType, Integer>>();
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (panel[i][j] == null) {
					//do nothing
				} else if (panel[i][j].getUp() >=2 ) {
					
					counter.put(panel[i][j].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
					counter.put(panel[i][j].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getUp() + 1);
					for (int up = j ; up <= (j + panel[i][j].getUp()); up++) {
						System.out.println(panel[i][j].getAttr().toString() + i + j + " right side = " + up);
						panel[i][up] = new Juju(true);
					}
				} else if (panel[i][j].getDown() >= 2) {
					counter.put(panel[i][j].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
					counter.put(panel[i][j].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getDown() + 1);
					for (int down = j; down >= (j - panel[i][j].getDown()); down--) {
						System.out.println(panel[i][j].getAttr().toString() + i + j + " down side = " + down);
						panel[i][down] = new Juju(true);
					}
				} else if (panel[i][j].getRight() >=2) {
					counter.put(panel[i][j].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
					counter.put(panel[i][j].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getRight() + 1);
					for (int right = i; right <= (i + panel[i][j].getRight()); right++) {
						System.out.println(panel[i][j].getAttr().toString() + i + j + " right side = " + right);
						panel[right][j] = new Juju(true);
					}
				} else if (panel[i][j].getLeft() >= 2) {
					counter.put(panel[i][j].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
					counter.put(panel[i][j].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getLeft() + 1);
					for (int left = i; left >= (i - panel[i][j].getLeft()); left--) {
						System.out.println(panel[i][j].getAttr().toString() + i + j + "left side = " + left);
						panel[left][j] = new Juju(true);
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
				if (panel[i][j].getAttr() == null) {
					for (int s = j; s < HEIGHT-1; s++)
						panel[i][j] = panel[i][j+1];
				}
			}
		}
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (panel[i][j].getAttr() == null) {
					set_juju(i, j);
				}
			}
		}
	}
	
	public void set_juju(int i, int j) {
		Juju down = null;
		Juju left = null;
		Juju right = null;
		Juju top = null;
		
		if (i == 0)
			left = null;
		else
			left = panel[i-1][j];
		
		if (i == WIDTH-1)
			right = null;
		else 
			right = panel[i+1][j];
		
		if (j == 0)
			down = null;
		else
			down = panel[i][j-1];
		
		if (j == HEIGHT-1)
			top = null;
		else 
			top = panel[i][j+1];
		
		panel[i][j] = new Juju(top, down, left, right, this);
//		panel[i][j].setPanel(this);
	}
	/** release(): release all Jujus in the panel
	 * called when the mouse is released from one of the Jujus.
	 */
	public void release(){
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				panel[i][j].isPressed = false;
			}
		}		
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
