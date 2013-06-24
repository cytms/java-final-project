import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;


public class PanelListener implements MouseListener {
	public Platform p = null;
	public Window w = null;
	Juju in;
	Juju ref;
	
	public PanelListener(Window window,Juju inJuju, Juju token) {
		this(window);
		in = inJuju;
		ref = token;
	}
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
		//isPress = true;
		ref = in;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//isPress = false;
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
		//if (isPress) {
		//if (in == ref && in.getAttr() != null) {
			//System.out.println("released " + in.getAttr() + " " + ref.getAttr());
			List<HashMap<JujuType, Integer>> tmp = p.update_juju();
			System.out.println(tmp.get(0).get(JujuType.AQUA));
			System.out.println(tmp.get(1).get(JujuType.AQUA));
			p.refill();
			
			Window win = new Window(p);
			
			win.setWindow();
			win.setVisible(true);
			this.w.dispose();

			//this.w.removeAll();
						
		//}
		//this.w.removeAll();
		
		//int counter = (Integer) tmp[0].get(JujuType.AQUA);
		//int num = (Integer) tmp[1].get(JujuType.AQUA);
		
		//}
	}

}
