package prut.kth.se.Labb2;

/**
 * Laboration 2
 * Main
 * 
 * Programutvecklingsteknik
 * DD2385
 * 
 * Vårterminen 2013
 * 
 * @author Jonas
 *
 */
public class Labb2 {
	private static MainFrame frame;
	private static Boardgame thegame;

	private static String currentMessage = "No message yet";
	
	// Number of tiles
	private static int nTile = 4;

	/**
	 * This is the main method.
	 * @param u
	 */
	public static void main(String[] u) {
		
		frame = new MainFrame();
		
		while (true)
		{
			currentMessage = "Select Game!";
			MainPanel.setMess(currentMessage);
			System.out.println(currentMessage);
			System.out.println("1: FifteenGame");
			System.out.println("2: TicTacToe");
			
			int in = Indata.nextInt();
			if ( in == 1)
			{
				while (true)
				{
					currentMessage = "How many tiles would like to play with?";
					System.out.println(currentMessage);
					MainPanel.setMess(currentMessage);
					System.out.println("Tiles n = ?, Game will be a square with (n)x(n) tiles");
					System.out.println("The number of tiles should not be more then 10 or less then 2.");
					MainPanel.tilesInputTextFeild(frame.mainPanel);
					
					int	numberOfTiles = Indata.nextInt();
					
					if (numberOfTiles < 10 && numberOfTiles > 1)
					{
						nTile = numberOfTiles;
						break;
					}
				}
				setThegame(new FifteenModel());
				MainPanel.startGame(frame.mainPanel);
				ViewControl.update();
				runFifteenGame();
				break;
			}
			else if (in == 2)
			{
				MainPanel.setMess("Player 1 starts!");
				nTile = 3;
				setThegame(new TicTacToe());
				MainPanel.startGame(frame.mainPanel);
				ViewControl.update();
				runTicTacToe();
				break;
			}
			else
			{
				System.out.println("You did not select the number 1 for FifteenModel game or 2 for the TicTacToe game!");
				System.out.println("");
				System.out.println("");
			}
		}
	}
	
	
	private static void runTicTacToe() {
		while(true) 
		{
			for (int y = 0; y < getnTile(); y++) {
                for (int x = 0; x < getnTile(); x++) {
                	if (getThegame().getStatus(x, y).equals(""))
                		System.out.print("| |"); // getStatus;
                	else
	                	if (getThegame().getStatus(x, y).equals("X"))
	                		System.out.print("|X|");
	                	else
	                		System.out.print("|O|");
                }
                System.out.println();
			}
            System.out.println();
            
            System.out.print("Ditt drag: ");
            int x = Indata.nextInt() - 1;
            int y = Indata.nextInt() - 1;
            getThegame().move(x, y);	                         // move
            ViewControl.update();
			MainPanel.setMess(getThegame().getMessage());
            System.out.println(getThegame().getMessage());	     // getMessage
		}
	}
	
	public static void runFifteenGame () {
		System.out.println("\nWelcome to the fifteen game!\n");
		
		while (true) 
		{
            // Skriv ut aktuell ställning7
            for (int y = 0; y < getnTile(); y++) {
                for (int x = 0; x < getnTile(); x++) {
                	if (getThegame().getStatus(x, y).equals(""))
                		System.out.print("    "); // getStatus;
                	else
	                	if (Integer.valueOf(getThegame().getStatus(x, y)) < 10)
	                		System.out.print("  " + getThegame().getStatus(x, y) + " "); // getStatus
	                	else
	                		System.out.print("  " + getThegame().getStatus(x, y)); // getStatus
                }
                System.out.println();
            }

            System.out.println();

            if (getThegame().getMessage().equals("Game Won!"))
            {
                System.out.println(getThegame().getMessage());	     // getMessage
           		break;
            }
            System.out.print("Ditt drag: ");
            int x = Indata.nextInt() - 1;
            int y = Indata.nextInt() - 1;
            getThegame().move(x,y);	                             // move
            ViewControl.update();
			MainPanel.setMess(getThegame().getMessage());
            System.out.println(getThegame().getMessage());	     // getMessage
		}
	}
	
	public static int getnTile() {
		return nTile;
	}
	public static void setnTile(int nTile) {
		Labb2.nTile = nTile;
	}
	public static Boardgame getThegame() {
		return thegame;
	}
	public static void setThegame(Boardgame thegame) {
		Labb2.thegame = thegame;
	}
}
