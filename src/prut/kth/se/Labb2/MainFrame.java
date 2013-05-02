package prut.kth.se.Labb2;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	
	private BorderLayout mainFramLayout = new BorderLayout();
	
	public MainPanel mainPanel;
	
	private Dimension boardDimension  = new Dimension(400, 300);
	
	public MainFrame(){
		super("Fifteen Model or TicTacToe");
		this.setLayout(mainFramLayout);
		//this.setUndecorated(true);
		
		this.setPreferredSize(boardDimension);
		
		this.addWindowListener(new ExitListener());
		
		mainPanel = new MainPanel();
		this.add(mainPanel, BorderLayout.CENTER);
		
		//Size the frame
		this.pack();
		this.setVisible(true);
	}
}
