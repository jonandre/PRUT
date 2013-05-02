package prut.kth.se.Labb1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	private BorderLayout mainFramLayout = new BorderLayout();
	private Dimension boardDimension  = new Dimension(400, 300);
	private MyButton button1 = new MyButton(Color.white, Color.cyan, "On", "Off");
	private MyButton button2 = new MyButton(Color.green, Color.red, "Run", "Stop");
	
	public MainFrame(){
		super("Labb 1 Av: Jonas Andrée");
		this.setLayout(mainFramLayout);
		this.setPreferredSize(boardDimension);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel CenterPanel = new JPanel();
		
		CenterPanel.setBackground(Color.WHITE);
		
		button1.addActionListener(button1);
		button2.addActionListener(button2);
		
		this.add(button1, BorderLayout.EAST);
		this.add(button2, BorderLayout.WEST);
		this.add(CenterPanel, BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
	}
}
