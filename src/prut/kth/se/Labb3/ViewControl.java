package prut.kth.se.Labb3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ViewControl extends JPanel {

	private static ImageIcon stenIcon = new ImageIcon("paper.png");
	private static ImageIcon saxIcon = new ImageIcon("rock.png");
	private static ImageIcon paseIcon = new ImageIcon("scissors.png");
	
	private static ImageIcon stenIcon2 = new ImageIcon("paperpressed.png");
	private static ImageIcon saxIcon2 = new ImageIcon("rockpressed.png");
	private static ImageIcon paseIcon2 = new ImageIcon("scissorspressed.png");
	
	public static GameButton[] buttons = new GameButton[3];
		
    public ViewControl() {
		this.setLayout(new BorderLayout());
		
		buttons[0] = new GameButton(stenIcon, stenIcon2, 0);
		buttons[1] = new GameButton(saxIcon, saxIcon2, 1);
		buttons[2] = new GameButton(paseIcon, paseIcon2, 2);
		
    	JPanel buttonContinerLeft = new JPanel();
    	JPanel buttonContinerCenter = new JPanel();
    	JPanel buttonContinerRight = new JPanel();
    	
    	buttons[0].addActionListener(buttons[0]);
    	buttons[1].addActionListener(buttons[1]);
    	buttons[2].addActionListener(buttons[2]);
    	    	
    	buttonContinerLeft.setPreferredSize(new Dimension(120, 400));
    	buttonContinerCenter.setPreferredSize(new Dimension(120, 400));
    	buttonContinerRight.setPreferredSize(new Dimension(120, 400));
    	
    	buttonContinerLeft.setLayout(null);
    	buttonContinerCenter.setLayout(null);
    	buttonContinerRight.setLayout(null);
    	
    	buttons[0].setLocation(new Point(22, 130));
    	buttons[1].setLocation(new Point(25, 130));
    	buttons[2].setLocation(new Point(22, 130));
    	
    	buttonContinerLeft.add(buttons[0]);
    	buttonContinerCenter.add(buttons[1]);
    	buttonContinerRight.add(buttons[2]);
    	
    	this.add(buttonContinerLeft, BorderLayout.WEST);
    	this.add(buttonContinerCenter, BorderLayout.CENTER);
    	this.add(buttonContinerRight, BorderLayout.EAST);
    }
}
