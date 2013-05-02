package prut.kth.se.Labb1;

import java.applet.Applet;
/**
 * Labboration 1 h
 * 
 * @author Jonas
 *
 */
public class Labb1 extends Applet{
	
	private static MainFrame frame;
	/**
	 * This is the main method.
	 * @param u
	 */
	public static void main(String[] u) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}
	private static void createAndShowGUI() {
		setFrame(new MainFrame());
	}
	public void init() {
		createAndShowGUI();
	}
	public static MainFrame getFrame() {
		return frame;
	}
	public static void setFrame(MainFrame frame) {
		Labb1.frame = frame;
	}
}
