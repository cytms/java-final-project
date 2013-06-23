import java.awt.*;

import javax.swing.*;


public class Window extends JFrame {
	public static final int WIDTH = 380;
	public static final int HEIGHT = 580;
	public Platform main_panel = new Platform();
	
	public Window(Color theColor) {
		super("Tower of Hanoi");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(theColor);
		setLayout(new GridLayout(2,1));
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(2,1));
			JPanel panel_1_1 = new JPanel();
			JPanel panel_1_2 = new JPanel();
			panel_1_2.setLayout(new GridLayout(2,1));
				JPanel panel_1_2_1 = new JPanel();
				panel_1_2_1.setLayout(new GridLayout(1,5));
				JPanel panel_1_2_2 = new JPanel();
				Monster a = new Monster(), b = new Monster(), c = new Monster(), d = new Monster(), e = new Monster();
				Health hp = new Health(a, b, c, d, e);
				panel_1_2_2.add(new JLabel(String.valueOf(hp.getHP())));
			panel_1_2.add(panel_1_2_1);
			panel_1_2.add(panel_1_2_2);
		panel_1.add(panel_1_1);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		//panel_down.setBounds(110, 0, 230, 300);
		panel_2.setLayout(new GridLayout(5, 6));
		JLabel label = null;
		
		//panel_down.setBounds(0, 230, 320, 250);
		//Panel main_panel = new Panel();
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 6; j++) {
				label = new JLabel();
				label.setOpaque(true);
				label.setIcon(new ImageIcon("juju/" + main_panel.panel[j][(4-i)].getAttr().toString() + ".png"));
				panel_2.add(label);
			}
		}
		panel_2.addMouseListener(new PanelListener(main_panel));
		panel_2.addMouseMotionListener(new PanelMouseMotionListener());
		//panel_down.setSize();
		add(panel_2);
		
	}
	public void swap_juju(Juju j1, Juju j2) {
		Juju tmp = j1;
		j1 = j2;
		j2 = tmp;
	}
}
