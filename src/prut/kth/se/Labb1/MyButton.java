package prut.kth.se.Labb1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MyButton extends JButton implements ActionListener {

	private Dimension buttonDimension = new Dimension(50, 50);

	private Color c1;
	private Color c2;
	private String s1;
	private String s2;
	
	private boolean active = true;
	
	public MyButton(Color c1, Color c2, String s1, String s2) {
		super(s1);
		setMinimumSize(buttonDimension);
        setSize(buttonDimension);
        
        this.c1 = c1;
        this.c2 = c2;
        this.s1 = s1;
        this.s2 = s2;

        this.setBackground(c1);
	}
	
	private void toggleState() {
		if (active)
		{
			active = false;
	        this.setBackground(c2);
	        this.setText(s2);
		}
		else
		{
			active = true;
	        this.setBackground(c1);
	        this.setText(s1);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.toggleState();
	}
}
