import java.awt.*;

import javax.swing.*;


public class Window extends JFrame {
	public static final int WIDTH = 380;
	public static final int HEIGHT = 580;
	public Panel main_panel = new Panel();
	
	public Window(Color theColor) {
		super("Tower of Hanoi");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(theColor);
		setLayout(new BorderLayout());
		JPanel panel_top = new JPanel();
		panel_top.setSize(230, 100);
		add(panel_top, BorderLayout.NORTH);
		
		JPanel panel_center = new JPanel();
		Monster a = new Monster(), b = new Monster(), c = new Monster(), d = new Monster(), e = new Monster();
		Health hp = new Health(a, b, c, d, e);
		panel_center.add(new JLabel(String.valueOf(hp.getHP())));
		//panel_center.add(new JLabel("hello"));
		panel_center.setSize(230, 10);
		add(panel_center, BorderLayout.CENTER);
		
		JPanel panel_down = new JPanel();
		//panel_down.setBounds(110, 0, 230, 300);
		panel_down.setLayout(new GridLayout(5, 6));
		JLabel label = null;
		
		//panel_down.setBounds(0, 230, 320, 250);
		//Panel main_panel = new Panel();
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 6; j++) {
				label = new JLabel();
				label.setOpaque(true);
				label.setIcon(new ImageIcon("juju/" + main_panel.panel[j][(4-i)].getAttr().toString() + ".png"));
				panel_down.add(label);
			}
		}
		panel_down.addMouseListener(new PanelListener(main_panel));
		panel_down.addMouseMotionListener(new PanelMouseMotionListener());
		//panel_down.setSize();
		add(panel_down, BorderLayout.SOUTH);
		
	}
	public void swap_juju(Juju j1, Juju j2) {
		Juju tmp = j1;
		j1 = j2;
		j2 = tmp;
	}
}
