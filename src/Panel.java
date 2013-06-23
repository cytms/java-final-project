import java.util.HashMap;


public class Panel {
	public final int WIDTH = 6;
	public final int HEIGHT = 5;

	Juju[][] panel = new Juju[WIDTH][HEIGHT];
	/* constructor 
	 * random generation
	 * 不能有三連珠
	 */
	public Panel() {
		//不能有三連珠
		
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				set_juju(i, j);
				//while(panel[i][j].getUp() == 2 || panel[i][j].getDown() == 2 || panel[i][j].getLeft() == 2 || panel[i][j].getRight() == 2)
					//set_juju(i,j);
			}
		}
	}
	public HashMap[] update_juju(){
		HashMap<JujuType, Integer> counter = new HashMap<JujuType, Integer>(0);
		HashMap<String, Integer> num = new HashMap<String, Integer>(0);
		HashMap[] result = new HashMap[2];
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (panel[i][j] == null) {
					//do nothing
				} 
				else {
					System.out.println(panel[i][j].getLeft());
				}
//				else if (panel[i][j].getUp() >=2 ) {
//					counter.put(panel[i][i].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
//					counter.put(panel[i][i].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getUp() + 1);
//					for (int up = i ; up < panel[i][j].getUp(); up++)
//						panel[up][j] = null;
//				} else if (panel[i][j].getDown() >= 2) {
//					counter.put(panel[i][i].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
//					counter.put(panel[i][i].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getDown() + 1);
//					for (int down = i; down < panel[i][j].getDown(); down--)
//						panel[down][j] = null;
//				} else if (panel[i][j].getRight() >=2) {
//					counter.put(panel[i][i].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
//					counter.put(panel[i][i].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getRight() + 1);
//					for (int right = j; right < panel[i][j].getRight(); right++)
//						panel[i][right] = null;
//				} else if (panel[i][j].getLeft() >= 2) {
//					counter.put(panel[i][i].getAttr(), counter.get(panel[i][j].getAttr()) + 1);
//					counter.put(panel[i][i].getAttr(), counter.get(panel[i][j].getAttr()) + panel[i][j].getLeft() + 1);
//					for (int left = j; left < panel[i][j].getLeft(); left--)
//						panel[i][left] = null;
//					
//				}
			}
		}
		result[0] = counter;
		result[1] = num;
		return result;
	}
	public void refill(){
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (panel[i][j] == null) {
					for (int s = j; s < HEIGHT; s++)
						panel[i][j] = panel[i][j+1];
				}
			}
		}
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (panel[i][j] == null) {
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
		
		panel[i][j] = new Juju(top, down, left, right);
	}
	
	
}
