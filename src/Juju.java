import java.awt.event.*;
import javax.swing.*;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Juju extends Draggable implements MouseListener, MouseMotionListener{
	private JujuType attr = null;
	private int down = 0;
	private int left = 0;
	
	private int right = 0;
	public boolean isPressed;
	//private Platform inPanel;
	private Window inWindow;

	/* Constructors */
	/** Default constructor */
	Juju(Window window) {
		Random random = new Random();
//		label = new Draggable();
		setAttr(JujuType.values()[random.nextInt(6)]);
		//inPanel = window.main_panel;
		inWindow = window;
	}
	/** copy constructor */
	Juju(Juju j){
//		this.label = new Draggable();
		setAttr(j.getAttr());
		this.isPressed = j.isPressed;
		//this.inPanel = j.inPanel;
		this.inWindow = j.inWindow;
	}
	Juju(boolean dump) {
	}

	Juju(Juju DOWN, Juju LEFT, Window window) {
		this(window);
		Random random = new Random();
		setAttr(JujuType.values()[random.nextInt(6)]);
		if (DOWN != null && this.attr.equals(DOWN.getAttr())) {
			this.down = DOWN.down + 1;
		}
		if (LEFT != null && this.attr.equals(LEFT.getAttr())) {
			this.left = LEFT.left + 1;
		}
	}
	/////////////////////////////////////////////////////////////////////
	//getter/setter//////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////
	public JujuType getAttr() {
		return attr;
	}

	/** setAttr: changes the value of attr(JujuType) and sets the icon for label */ 
	public void setAttr(JujuType attr) {
		this.attr = attr;
		setOpaque(true);
		if (attr!= null)
			setIcon(new ImageIcon("juju/" + attr.toString() + ".png"));
//		label.setText(getAttr().toString());
	}
	//public void setPanel(Platform pan){
		//inPanel = pan;
	//}

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
	public void setInWindow(Window inWindow) {
		this.inWindow = inWindow;
	}
	////////////////////////////////////////////////////////////
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Juju clone(){
		return new Juju(this); 
	}
	/** swapJ: exhange attributes with another Juju "rival" */
	private void swapJ(Juju rival){
		Juju temp = new Juju(rival);
		rival.setAll(this);
		this.setAll(temp);
	}
	/** setAll: set all attributes of j to this at one time */
	private void setAll(Juju j){
		setAttr(j.getAttr());
		this.isPressed = j.isPressed;
		this.inWindow = j.inWindow;
		//this.inPanel = j.inPanel;
		this.setIcon(new ImageIcon("juju/" + attr.toString() + ".png"));
	}
//////////////////////////////////////////////////////////////////////////////
//MouseMotionListener/////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent arg0) {}
//////////////////////////////////////////////////////////////////////////////
//MouseListener///////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
	public void mouseEntered(MouseEvent e){
		JujuPosition pos = inWindow.main_panel.getJujuPosition(this);
		Juju rival = null;
		if(pos.getX()-1 >= 0 && inWindow.main_panel.panel[pos.getX()-1][pos.getY()].isPressed){			
			rival = inWindow.main_panel.panel[pos.getX()-1][pos.getY()];
		}
		else if(pos.getX()+1 < 6 && inWindow.main_panel.panel[pos.getX()+1][pos.getY()].isPressed){
			rival = inWindow.main_panel.panel[pos.getX()+1][pos.getY()];
		}
		else if(pos.getY()-1 >= 0 && inWindow.main_panel.panel[pos.getX()][pos.getY()-1].isPressed){
			rival = inWindow.main_panel.panel[pos.getX()][pos.getY()-1];
		}
		else if(pos.getY()+1 < 5 && inWindow.main_panel.panel[pos.getX()][pos.getY()+1].isPressed){
			rival = inWindow.main_panel.panel[pos.getX()][pos.getY()+1];
		}
		
		if (rival != null){
			JujuPosition rpos = inWindow.main_panel.getJujuPosition(rival);
			System.out.println(pos + " & " + rpos);
			this.swapJ(rival);
			rival.isPressed = false;
			this.isPressed = true;
		}
	}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){
		this.isPressed = true;
		System.out.println("Juju is being Held.");
	}
	public void mouseClicked(MouseEvent e){	}
	public void mouseReleased(MouseEvent e){
		this.isPressed = false;
		System.out.println("Juju is released.");
		List<HashMap<JujuType, Integer>> tmp = inWindow.main_panel.update_juju();
		
		System.out.println(tmp);
		
		int attack = inWindow.monsters.a.Attack(tmp.get(0).get(JujuType.WOOD),0);
		attack += inWindow.monsters.b.Attack(tmp.get(0).get(JujuType.AQUA),0);
		attack += inWindow.monsters.c.Attack(tmp.get(0).get(JujuType.DARK),0);
		attack += inWindow.monsters.d.Attack(tmp.get(0).get(JujuType.LIGHT),0);
		attack += inWindow.monsters.e.Attack(tmp.get(0).get(JujuType.FIRE),0);
		inWindow.monsters.set_totalAttack(attack);
		
		inWindow.monsters.set_thisRecover((int)(tmp.get(0).get(JujuType.HEART)*inWindow.monsters.recovery()*0.3));
//		System.out.println(tmp.get(1).get(JujuType.AQUA));
		inWindow.main_panel.refill();
		Window w = new Window(inWindow.main_panel, inWindow.monsters);
		w.setWindow();
		w.setVisible(true);
		this.inWindow.dispose();
		inWindow.main_panel.release();
		
		
		
	}
//end of MouseMotionListener////////////////////////////////////////////////////////////////////		
}