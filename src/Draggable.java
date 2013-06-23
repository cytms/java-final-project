import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Draggable extends JLabel{
	    private int draggedAtX, draggedAtY;

	    public Draggable(){
	        super();
//	        setDoubleBuffered(false);
//	        setMargin(new Insets(0, 0, 0, 0));
	        setSize(50, 50);
	        setPreferredSize(new Dimension(25, 25));

//	        addMouseListener(new MouseAdapter(){
//	            public void mousePressed(MouseEvent e){
//	                draggedAtX = e.getX();
//	                draggedAtY = e.getY();
//	            }
//	        });
//
//	        addMouseMotionListener(new MouseMotionAdapter(){
//	            public void mouseDragged(MouseEvent e){
//	                setLocation(e.getX() - draggedAtX + getLocation().x,
//	                        e.getY() - draggedAtY + getLocation().y);
//	            }
//	        });
	    }

//	    public static void main(String[] args){
//	        JFrame frame = new JFrame("DragButton");
//	        frame.setLayout(null);
//	        frame.getContentPane().add(new Draggable("1"));
//	        frame.getContentPane().add(new Draggable("2"));
//	        frame.getContentPane().add(new Draggable("3"));
//	        frame.setSize(300, 300);
//	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        frame.setLocationRelativeTo(null);
//	        frame.setVisible(true);
//	    }
}
