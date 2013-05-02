package prut.kth.se.Labb2;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Square extends JButton{

	private Dimension buttonDimension = new Dimension(50, 50);

	public final int x;
	public final int y;
	
	public Square(String text, int x, int y) {
		super(text);
		setMinimumSize(buttonDimension);
        setSize(buttonDimension);
        
        this.x = x;
        this.y = y;
	}
	
	public Square(ImageIcon icon, int x, int y){
        super(icon);

        this.x = x;
        this.y = y;
	}
}
