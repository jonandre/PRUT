package prut.kth.se.Labb3;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MainPanel extends JPanel{
    private static JLabel outputFeild = new JLabel("  Hej,");
    private static JLabel summeryFeild = new JLabel("Summary: 0 Wins, 0 Losses");
    private static JTextArea resultFeild = new JTextArea(" Results:");
    
    private ViewControl gamePanel = new ViewControl();
    
	public MainPanel(){	
		this.setLayout(new BorderLayout());
		
		JPanel textPanel = new JPanel(new BorderLayout());
		
		JScrollPane scrollV = new JScrollPane (resultFeild);
		scrollV.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		summeryFeild.setPreferredSize(new Dimension(200, 30));
		outputFeild.setPreferredSize(new Dimension(200, 30));
		textPanel.setPreferredSize(new Dimension(200, 0));
		resultFeild.setMaximumSize(new Dimension(200, 340));
		
		textPanel.add(outputFeild, BorderLayout.NORTH);
		textPanel.add(scrollV, BorderLayout.CENTER);
		textPanel.add(summeryFeild, BorderLayout.SOUTH);
		
		this.add(textPanel, BorderLayout.EAST);
		this.add(gamePanel, BorderLayout.CENTER);
	}
	
	public JLabel getMessage() {
		return outputFeild;
	}

	public static void setMessage(String mess) {
		MainPanel.outputFeild.setText("<html>" + mess + "</html>");
	}

	/**
	 * Update GUI
	 */
	public void update(){
		String temp = "";
		for(int i = 0; i < Labb3.move; i++)
			temp += Labb3.getThegame().getStatus(i) + "\n";
		resultFeild.setText(temp);
	    summeryFeild.setText("Summary: " + Labb3.getThegame().getStats()[0] + 
	    					 " Wins, " + Labb3.getThegame().getStats()[1] + 
	    					 " Loses, " + Labb3.getThegame().getStats()[2] + " Even");
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				Labb3.getFrame().repaint();
			}
		});
	}
}
