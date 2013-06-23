import java.awt.event.*;
import javax.swing.*;

import java.util.Random;

public class Juju extends Draggable implements MouseListener, MouseMotionListener{
	private JujuType attr = null;
	private int up = 0;
	private int down = 0;
	private int left = 0;
	private int right = 0;
	public boolean isPressed;
	private Platform inPanel;
//	Draggable label;
	
	/* Constructors */
	/** Default constructor */
	Juju(Platform panel) {
		Random random = new Random();
//		label = new Draggable();
		setAttr(JujuType.values()[random.nextInt(6)]);
		inPanel = panel;
	}
	/** copy constructor */
	Juju(Juju j){
//		this.label = new Draggable();
		setAttr(j.getAttr());
		this.isPressed = j.isPressed;
		this.inPanel = j.inPanel;
	}
	Juju(boolean dump) {
	}
	Juju(Juju UP, Juju DOWN, Juju LEFT, Juju RIGHT, Platform panel) {
		this(panel);
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
		setIcon(new ImageIcon("juju/" + attr.toString() + ".png"));
//		label.setText(getAttr().toString());
	}
	public void setPanel(Platform pan){
		inPanel = pan;
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
		this.inPanel = j.inPanel;
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
		JujuPosition pos = inPanel.getJujuPosition(this);
		Juju rival = null;
		if(pos.getX()-1 >= 0 && inPanel.panel[pos.getX()-1][pos.getY()].isPressed){			
			rival = inPanel.panel[pos.getX()-1][pos.getY()];
		}
		else if(pos.getX()+1 < 6 && inPanel.panel[pos.getX()+1][pos.getY()].isPressed){
			rival = inPanel.panel[pos.getX()+1][pos.getY()];
		}
		else if(pos.getY()-1 >= 0 && inPanel.panel[pos.getX()][pos.getY()-1].isPressed){
			rival = inPanel.panel[pos.getX()][pos.getY()-1];
		}
		else if(pos.getY()+1 < 5 && inPanel.panel[pos.getX()][pos.getY()+1].isPressed){
			rival = inPanel.panel[pos.getX()][pos.getY()+1];
		}
		
		if (rival != null){
			JujuPosition rpos = inPanel.getJujuPosition(rival);
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
		inPanel.release();
	}
//end of MouseMotionListener////////////////////////////////////////////////////////////////////		
}