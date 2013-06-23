import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;


public class PanelListener implements MouseListener {
	public Platform p = null;
	public Window w = null;
	
	public PanelListener(Window window) {
		p = window.main_panel;
		w = window;
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
		
		//w.removeAll();
		//w.remove();
		
		//w.removeAll();
		//w = new Window(p);
		//w.repaint();
		//w.setWindow();
		//w.setVisible(false);
		System.out.println("released");
		List<HashMap<JujuType, Integer>> tmp = p.update_juju();
		System.out.println(tmp.get(0).get(JujuType.AQUA));
		System.out.println(tmp.get(1).get(JujuType.AQUA));
		p.refill();
		Window w = new Window(p);
		
		w.setWindow();
		w.setVisible(true);
		this.w.dispose();
		//int counter = (Integer) tmp[0].get(JujuType.AQUA);
		//int num = (Integer) tmp[1].get(JujuType.AQUA);
		
		
	}

}
