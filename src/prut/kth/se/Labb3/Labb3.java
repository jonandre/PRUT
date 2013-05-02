package prut.kth.se.Labb3;

public class Labb3 {
	private static MainFrame frame;
	private static Boardgame thegame;
	public static int move = 0;

	private static String currentMessage = "No message yet";
	
	/**
	 * This is the main method.
	 * @param u
	 */
	public static void main(String[] u) {
		setThegame(new RockPaperScissors());
		
		createAndShowGUI();

		currentMessage = "Press one of the buttons!";
		MainPanel.setMessage(currentMessage);
		System.out.println("0: STEN");
		System.out.println("1: SAX");
		System.out.println("2: PÅSE");
		System.out.println("Select one of the above!");
		int in = Indata.nextInt();
		
		while (true)
		{
			currentMessage = "1! Press one of the buttons again!";
			MainPanel.setMessage(currentMessage);
			System.out.println(currentMessage);
			System.out.println("0: STEN");
			System.out.println("1: SAX");
			System.out.println("2: PÅSE");
			System.out.println("Select one of the again!");
			int in2 = Indata.nextInt();
			currentMessage = "2! Press one of the buttons again!";
			MainPanel.setMessage(currentMessage);
			System.out.println(currentMessage);
			System.out.println("0: STEN");
			System.out.println("1: SAX");
			System.out.println("2: PÅSE");
			System.out.println("Select one of the again!");
			int in3 = Indata.nextInt();
			for (int i = 0; i < 3; i++) 
				if (in3 == i)
					ViewControl.buttons[i].toggleState();
			
			getThegame().move(in3);
			frame.mainPanel.update();
			currentMessage = "<html>Text color: <font color='red'>" + getThegame().getMessage() + "</font>, Press one of the buttons!</html>";
			MainPanel.setMessage(currentMessage);
			System.out.println("0: STEN");
			System.out.println("1: SAX");
			System.out.println("2: PÅSE");
			System.out.println("Select one of the above!");
			int in4 = Indata.nextInt();
			ViewControl.buttons[in3].toggleState();
		}
	}
	private static void createAndShowGUI() {
		setFrame(new MainFrame());
	}
	public static MainFrame getFrame() {
		return frame;
	}
	private static void setFrame(MainFrame frame) {
		Labb3.frame = frame;
	}
	public static Boardgame getThegame() {
		return thegame;
	}
	public static void setThegame(Boardgame thegame) {
		Labb3.thegame = thegame;
	}
}
