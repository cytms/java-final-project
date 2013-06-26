import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
	private static final int WIDTH = 380;
	private static final int HEIGHT = 580;
	public Platform main_panel;
	public MonsterData monsters;
	public JLabel BossHPlabel = null;
	public JLabel HPlabel = null;
	public MainWindow() {
		super("Tower of Hanoi");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_panel = new Platform(this);
		monsters = new MonsterData();
	}
	public MainWindow(Platform p , MonsterData monsters) {
		super("Tower of Hanoi");
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_panel = p;
		this.monsters = monsters;
		//monsters.oneRound();
	}
	public void setWindow() {
		/* create panels */
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
		/* set monsters */
		JLabel Mlabel = null;
		String[] name = { monsters.a.name, monsters.b.name, monsters.c.name, monsters.d.name, monsters.e.name };
		for (int i = 0; i < 5; i++) {
			Mlabel = new JLabel();
			Mlabel.setIcon(new ImageIcon("monster/" + name[i] + ".png"));
			panel_1_2_1.add(Mlabel);
		}
		/* set boss monster */
		Mlabel = new JLabel();
		Mlabel.setIcon(new ImageIcon("monster/" + monsters.Boss.name + ".png"));
		panel_1_1.add(Mlabel);
		/* set hp, cd labels */
		HPlabel = new JLabel("HP: " + String.valueOf(monsters.get_hp()));
		BossHPlabel = new JLabel(monsters.Boss.toString());
		Font f = new Font("", Font.BOLD, 30);
		HPlabel.setFont(f); BossHPlabel.setFont(f);
		panel_1_2_2.setBackground(new Color(Integer.valueOf("E40045", 16)));
		panel_1_2_2.add(HPlabel);
		panel_1_2_0.add(BossHPlabel);
		panel_1_2.add(panel_1_2_0);
		panel_1_2.add(panel_1_2_1);
		panel_1_2.add(panel_1_2_2);
		panel_1.add(panel_1_1);
		panel_1.add(panel_1_2);
		add(panel_1);
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new GridLayout(5, 6));
		/* remove each of the jujus' MouseListener of the previous state */
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 6; j++) {
				main_panel.getJuju(j, 4-i).removeMouseListener(main_panel.getJuju(j, 4-i));
			}
		}
		
		/* set 6x5 Jujus and their MouseListener */
		for (int i = 0; i < 5; i ++) {
			for (int j = 0; j < 6; j++) {
				//main_panel.panel[j][4-i].setInWindow(this);
				main_panel.getJuju(j, 4-i).addMouseListener(main_panel.getJuju(j, 4-i));
				main_panel.getJuju(j, 4-i).setBackground(new Color(Integer.valueOf("960028", 16)));
				panel_2.add(main_panel.getJuju(j, 4-i)); 
			}
		}
		add(panel_2);
	}
}
