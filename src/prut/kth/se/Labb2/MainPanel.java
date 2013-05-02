package prut.kth.se.Labb2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainPanel extends JPanel implements ActionListener{
	static ViewControl viewControl;
    public static JLabel mess = new JLabel("Select a game!");
    private static GameButton TicTacToeButton;
    private static GameButton FifteenGameButton;
    private static JTextField inputTextFeild;
    private static GameButton OKButton;
    
	public MainPanel(){	
		this.setLayout(new BorderLayout());
		inputTextFeild = new JTextField();
		TicTacToeButton = new GameButton("TicTacToe", 2);
		FifteenGameButton = new GameButton("FifteenGameButton", 1);
		OKButton = new GameButton("Start!", 3);
		
		getMess().setLocation(new Point(140, 200));
		inputTextFeild.setLocation(new Point(140, 100));
		
		getMess().setSize(new Dimension(100, 50));
		inputTextFeild.setSize(new Dimension(100, 50));
		
		TicTacToeButton.addActionListener(this);
		FifteenGameButton.addActionListener(this);
		OKButton.addActionListener(this);
		
		inputTextFeild.setMaximumSize(new Dimension(100, 50));
		inputTextFeild.setMaximumSize(new Dimension(100, 50));
		
		inputTextFeild.setVisible(false);
		
		char[] chars = {'?', '\\', '/', '*', '<',':', '>', '"', '|', '_', 
						'-', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
						'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 
						't', 'u', 'v', 'w', 'x', 'y', 'z', 'å', 'ä', 'ö', 
						'*', '[', ']', '{', '}', '&', '%', '¤', '#', '"', 
						'!', '½', '§', '@', '£', '$', '+', '^', '¨', '~', 
						'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
						'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
						'U', 'V', 'W', 'X', 'Y', 'Z', 'Å', 'Ä', 'Ö', '.', 
						',', ' '};

		inputTextFeild.addKeyListener(new InvalidCharListener(chars));

		
		this.add(inputTextFeild);
		this.add(TicTacToeButton, BorderLayout.EAST);
		this.add(FifteenGameButton, BorderLayout.WEST);
		this.add(getMess(), BorderLayout.SOUTH);

		OKButton.setVisible(false);
	}
	
	public static void startGame(JPanel MainPanel) {
		inputTextFeild.setVisible(false);
		TicTacToeButton.setVisible(false);
		FifteenGameButton.setVisible(false);
		OKButton.setVisible(false);
		
		viewControl = new ViewControl();
		viewControl.setLocation(new Point(0, 0));
		viewControl.setSize(new Dimension(500, 500));
		
		viewControl.setVisible(true);
		MainPanel.add(viewControl);
		
	}
	public static void tilesInputTextFeild(JPanel MainPanel) {
		TicTacToeButton.setVisible(false);
		FifteenGameButton.setVisible(false);
		inputTextFeild.setVisible(true);
		OKButton.setVisible(true);
		MainPanel.add(OKButton, BorderLayout.EAST);
	}
	public JLabel getMess() {
		return mess;
	}

	public static void setMess(String mess) {
		MainPanel.mess.setText("<html>" + mess + "</html>");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (((GameButton)(e.getSource())).value == 3)
			Indata.push(Integer.valueOf(inputTextFeild.getText()));
		else
			Indata.push(((GameButton)(e.getSource())).value);
	}	
}
