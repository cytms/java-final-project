import java.awt.*;
import javax.swing.*;


public class Window extends JFrame {
	public static final int WIDTH = 380;
	public static final int HEIGHT = 580;
	public Platform main_panel;
	public Juju token = null;
	public Window() {
		super("Tower of Hanoi");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_panel = new Platform(this);
	}
	public Window(Platform p) {
		super("Tower of Hanoi");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_panel = p;
	}
	public void setWindow() {
		setLayout(new GridLayout(2,1));
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new GridLayout(2,1));
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(Integer.valueOf("FFCB00", 16)));
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(new GridLayout(3,1));
		JPanel panel_1_2_0 = new JPanel();
		panel_1_2_0.setBackground(new Color(Integer.valueOf("67E300", 16)));
		JPanel panel_1_2_1 = new JPanel();
		panel_1_2_1.setLayout(new GridLayout(1,5));
		panel_1_2_1.setBackground(new Color(Integer.valueOf("3D9200", 16)));
		JPanel panel_1_2_2 = new JPanel();

		BadMonster Boss = new BadMonster("Chuin", 5000000, 1800, 3,JujuType.LIGHT, "monster/CHUIN.jpg", 4);
		Monster a = new Monster("Gumdam", 600, 150, 400, JujuType.WOOD,"monster/GUMDAM.jpg");
		Monster b = new Monster("RockmanX", 1000, 255, 50, JujuType.AQUA,"monster/ROCKMANX.jpg");
		Monster c = new Monster("Rockman", 733, 200, 250, JujuType.DARK,"monster/ROXKMAN.jpg");
		Monster d = new Monster("Digidragon", 500, 700, 0, JujuType.LIGHT,"monster/DIGIDRAGON.jpg");
		Monster e = new Monster("Zero", 633, 540, 100, JujuType.FIRE,"monster/ZERO.jpg");
		JLabel Mlabel = null;
		String[] name = { a.name, b.name, c.name, d.name, e.name };
		for (int i = 0; i < 5; i++) {
			Mlabel = new JLabel();
			Mlabel.setIcon(new ImageIcon("monster/" + name[i] + ".png"));
			panel_1_2_1.add(Mlabel);
		}

		Health hp = new Health(a, b, c, d, e);
		Mlabel = new JLabel();
		Mlabel.setIcon(new ImageIcon("monster/" + Boss.name + ".png"));
		panel_1_1.add(Mlabel);
		JLabel HPlabel = new JLabel(String.valueOf(hp.getHP()));
		HPlabel.setFont(new Font("", Font.BOLD, 30));
		panel_1_2_2.setBackground(new Color(Integer.valueOf("E40045", 16)));
		panel_1_2_2.add(HPlabel);
		panel_1_2.add(panel_1_2_0);
		panel_1_2.add(panel_1_2_1);
		panel_1_2.add(panel_1_2_2);
		panel_1.add(panel_1_1);
		panel_1.add(panel_1_2);
		add(panel_1);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(5, 6));
		//panel_2.setBackground(new Color(Integer.valueOf("2E16B1", 16)));
		//main_panel = new Platform(this);
		//panel_2.addMouseListener(new PanelListener(this));
		PanelListener l = new PanelListener(this);
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 6; j++) {
				main_panel.panel[j][4-i].removeMouseListener(main_panel.panel[j][4-i]);
			}
		}
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 6; j++) {
				main_panel.panel[j][4-i].addMouseListener(main_panel.panel[j][4-i]);
				main_panel.panel[j][4-i].setBackground(new Color(Integer.valueOf("960028", 16)));
				//main_panel.panel[j][4-i].addMouseListener(new PanelListener(this, main_panel.panel[j][4-1], token));
				panel_2.add(main_panel.panel[j][4-i]); 
			}
		}
		//panel_2.addMouseListener(new PanelListener(this));
		//panel_2.addMouseMotionListener(new PanelMouseMotionListener());
		add(panel_2);
	}

}
