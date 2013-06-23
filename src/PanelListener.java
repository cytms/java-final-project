import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PanelListener implements MouseListener {
	public Panel p = null;
	
	public PanelListener(Panel panel) {
		p = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// do round works!
		System.out.println("released");
		p.update_juju();
		p.refill();
		
	}

}
