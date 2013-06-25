import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/** the game result window
 *  with two endings: winning or losing
 * @author cytms
 */

public class FinalWindow extends JFrame {
	private static final int WIDTH = 380;
	private static final int HEIGHT = 580;
	public FinalWindow(boolean isWin) {
		super("Tower of Hanoi");
		setSize(WIDTH, HEIGHT);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label, label_img = null;
		if (isWin) {
			label = new JLabel("congratuations!");
			label_img = new JLabel("");
			label_img.setIcon(new ImageIcon("win.png"));
		} else {
			label = new JLabel("GG QQ");
			label_img = new JLabel("");
			label_img.setIcon(new ImageIcon("gg.png"));
		}
		label.setFont(new Font("", Font.BOLD, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label_img.setHorizontalAlignment(SwingConstants.CENTER);
		add(label, BorderLayout.NORTH);
		add(label_img, BorderLayout.CENTER);
		
	}

}
