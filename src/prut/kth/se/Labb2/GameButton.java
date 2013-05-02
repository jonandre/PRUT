package prut.kth.se.Labb2;

import java.awt.Dimension;

import javax.swing.JButton;

public class GameButton extends JButton{

	private Dimension buttonDimension = new Dimension(100, 100);
	
	int value;
	
	public GameButton(String text, int i) {
		super(text);
		setMinimumSize(buttonDimension);
        setSize(buttonDimension);
        
        this.value = i;
	}
}
