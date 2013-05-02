package prut.kth.se.Labb3;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GameButton extends JButton  implements ActionListener {

	private Dimension buttonDimension = new Dimension(80, 100);
	private boolean active = true;

	private ImageIcon blueIcon;
	private ImageIcon greenIcon;
	
	private int value;
	
	public GameButton(ImageIcon icon, ImageIcon icon2, int i) {
		this.setIcon(icon);
		
		this.blueIcon = icon;
		this.greenIcon = icon2;
		
		this.setMinimumSize(buttonDimension);
		this.setSize(buttonDimension);
        this.setPreferredSize(buttonDimension);

		this.setOpaque(false);
		
        this.value = i;
	}
	public void toggleState() {
		if (active)
		{
			active = false;
			this.setIcon(this.greenIcon);
		}
		else
		{
			active = true;
			this.setIcon(this.blueIcon);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Indata.push(this.value);
	}
}
