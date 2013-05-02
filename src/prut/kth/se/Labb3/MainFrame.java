package prut.kth.se.Labb3;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import prut.kth.se.Labb2.ExitListener;

public class MainFrame extends JFrame {
	
	private BorderLayout mainFramLayout = new BorderLayout();
	
	public MainPanel mainPanel;
	
	private Dimension boardDimension  = new Dimension(570, 400);
	
	public MainFrame(){
		super("Rock Paper Scissors");
		this.setLayout(mainFramLayout);
		this.setMinimumSize(boardDimension);
		this.setPreferredSize(boardDimension);
		this.setResizable(false);
		
		this.addWindowListener(new ExitListener());
		
		mainPanel = new MainPanel();
		this.add(mainPanel, BorderLayout.CENTER);
		
		//Size the frame
		this.pack();
		this.setVisible(true);
	}
}
