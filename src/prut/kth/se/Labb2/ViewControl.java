package prut.kth.se.Labb2;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ViewControl extends JPanel implements ActionListener {
	private static Square[][] board;        // Square är subklass till JButton
    
    public ViewControl() {
    	this.setLayout(null);
    	board = new Square[Labb2.getnTile()][Labb2.getnTile()];

    	for (int x = 0; x < board.length; x++)
    		for (int y = 0; y < board[x].length; y++)
    		{
    			board[x][y] = new Square(Labb2.getThegame().getStatus(x, y), x, y);
    			board[x][y].addActionListener(this);
    		}
    	
    	int h = board[0][0].getSize().height;
    	int w = board[0][0].getSize().width;
    	this.setPreferredSize(new Dimension(board[0].length * w, board.length * h));
    	
    	for (int x = 0; x < board.length; x++)
    		for (int y = 0; y < board[x].length; y++)
    		{
    			board[x][y].setLocation(new Point(x * w, y * h));
    			board[x][y].setVisible(true);
    			this.add(board[x][y]);
    		}
    }
    
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (!Labb2.getThegame().getMessage().equals("Game Won!") && 
			!Labb2.getThegame().getMessage().equals("Player X Won!") && 
			!Labb2.getThegame().getMessage().equals("Player O Won!") )
		{
			Indata.push((((Square)(arg0.getSource())).x + 1));
			Indata.push((((Square)(arg0.getSource())).y + 1));
		}
	}
	/**
	 * 
	 */
	public static void update() {
		updateButtons();
		if (Labb2.getThegame().getMessage().equals("Game Won!"))
            MainPanel.mess.setText("<html><font color = rgb(0,200,0)>" + Labb2.getThegame().getMessage() + "</font></html>");	     // getMessage
	}
	
	/**
	 * Update GUI
	 */
	private static void updateButtons(){
		for (int x = 0; x < board.length; x++)
    		for (int y = 0; y < board[x].length; y++)
    			board[x][y].setText(Labb2.getThegame().getStatus(x, y));
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				board[0][0].getParent().getParent().repaint();
			}
		});
	}
}
