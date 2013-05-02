package prut.kth.se.Labb2;

import java.util.Arrays;
import java.util.Collections;

class FifteenModel implements Boardgame {
	private String currentMessage = "No message yet";
	private String[][] status = new String[Labb2.getnTile()][Labb2.getnTile()];  // spelplanen
	private int xempty, yempty;                    // index till den tomma rutan
	
	/**
	 * The Game boards constructor 
	 * 
	 * Creates a game board with random numbers between max- height and with.
	 */
	public FifteenModel()
	{
		creatGameBoard();
	}
	/**
	 * Creates a game board with numbers from 1 to max (nTile * nTile)
	 * Calls shuffle game board  to shuffle the numbers. 
	 */
	private void creatGameBoard() {
		String[] tiles = new String[Labb2.getnTile() * Labb2.getnTile()];
		for (int i = 1; i <= Labb2.getnTile()*Labb2.getnTile(); i++) {
			tiles[i-1] = String.valueOf(i);
			if (i == (Labb2.getnTile()*Labb2.getnTile()))
				tiles[i-1] = null;
		}
		shuffleGameBoard(tiles);
	}
	
	/**
	 * Shuffle the values for the array.
	 * @param tiles
	 */
	private void shuffleGameBoard(String[] tiles) {
		Collections.shuffle(Arrays.asList(tiles));
		saveArray(tiles);
	}
	
	/**
	 * Saves the randomized array tiles.
	 * Also saves what position the empty string is on. 
	 * @param tiles
	 */
	private void saveArray(String[] tiles) {
		for (int x = 0; x < Labb2.getnTile(); x++) {
            for (int y = 0; y < Labb2.getnTile(); y++) {
                status[x][y] = tiles[Labb2.getnTile() * y + x];
                
                // Saves the position of the empty tile
                if (status[x][y] == null) {
                	status[x][y] = "";
                	xempty = x;
                    yempty = y;
                }
            }
        }
	}
	
	/**
	 * Moves the tile to the empty tile if empty tile is directly corresponding the the selected tile. 
	 * 
	 * @param i
	 * @param j
	 */
	@Override
	public boolean move(int x, int y) {
		if (((xempty - 1 <= x) && (x <= xempty + 1)) && ((yempty - 1 <= y) && (y <= yempty + 1)))
			if ((xempty == x) ^ (yempty == y)) 
			{
				currentMessage = "Tile : " + (1 + x) + "," + (1 + y) + " has been moved to: " + (xempty + 1) + "," + (yempty + 1);
				status[xempty][yempty] = status[x][y];
				status[x][y] = "";
				xempty = x;
				yempty = y;
				gameDone();
				return true;
			}
		currentMessage = "You did not select a valid tile!";
		return false;
	}
	
	/**
	 * Returns the value corresponding to the input of i and j.
	 * This value will be between 1 and nTiles * nTiles - 1 and an empty string  
	 * 
	 * @param i
	 * @param j
	 */
	@Override
	public String getStatus(int x, int y) {
		return status[x][y];
	}
	
	/**
	 * 
	 */
	@Override
	public String getMessage() {
		return currentMessage;
	}
	
	/**
	 * Cheeks if game is done!
	 */
	public boolean gameDone(){
        for (int y = 0; y < Labb2.getnTile(); y++)
        	for (int x = 0; x < Labb2.getnTile(); x++)
	            try { 
	            	if (Integer.valueOf(getStatus(x, y)) == (y * 4 + x + 1))
	            		if ((y * 4 + x + 1) == (Labb2.getnTile() * Labb2.getnTile() - 1))
		            	{
		            		currentMessage = "Game Won!";
		            		return true;
		            	}
	            } catch (Exception e) {
	            }
		return false;
	}
}