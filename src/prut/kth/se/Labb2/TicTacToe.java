package prut.kth.se.Labb2;

public class TicTacToe  implements Boardgame {
	
	private String currentMessage = "No message yet";
	private String[][] status = new String[Labb2.getnTile()][Labb2.getnTile()];  // spelplanen
	private boolean player = true;
	
	public TicTacToe() {
		creatGameBoard();
	}
	private void creatGameBoard() {
		for (int x = 0; x < Labb2.getnTile(); x++)
            for (int y = 0; y < Labb2.getnTile(); y++)
            	status[x][y] = "";
	}
	
	@Override
	public boolean move(int x, int y) {
		if (getStatus(x, y).equals(""))
		{
			if (player)
			{
				status[x][y] = "X";
				currentMessage = "It is player 2:s turn!";
				player = false;
				MainPanel.setMess(currentMessage);
			}
			else
			{
				status[x][y] = "O";
				currentMessage = "It is player 1:s turn!";
				player = true;
				MainPanel.setMess(currentMessage);
			}
			gameDone();
			return true;
		}
		else
			return false;
	}

	@Override
	public String getStatus(int x, int y) {
		return status[x][y];
	}

	@Override
	public String getMessage() {
		return currentMessage;
	}
	

	/**
	 * Cheeks if game is done!
	 */
	public boolean gameDone(){
        for (int y = 0; y < Labb2.getnTile(); y++)
        {
			if (status[0][y] == "X")
	    		if (status[1][y] == "X")
	        		if (status[2][y] == "X")
	        	    {
	        	        currentMessage = "Player X Won!";
	        			return true;
	        	    }
		    if (status[0][y] == "O")
	    	    if (status[1][y] == "O")
	        	    if (status[2][y] == "O")
	        	    {
	        	        currentMessage = "Player O Won!";
	        			return true;
	        	    }
	    }
    	for (int x = 0; x < Labb2.getnTile(); x++)
    	{
    		if (status[x][0] == "X")
        		if (status[x][1] == "X")
            		if (status[x][2] == "X")
            	    {
            	        currentMessage = "Player X Won!";
            			return true;
            	    }
    		
    	    if (status[x][0] == "O")
        	    if (status[x][1] == "O")
            	    if (status[x][2] == "O")
            	    {
            	        currentMessage = "Player O Won!";
            			return true;
            	    }
    	}

		if (status[0][0] == "X")
    		if (status[1][1] == "X")
        		if (status[2][2] == "X")
        	    {
        	        currentMessage = "Player X Won!";
        			return true;
        	    }

	    if (status[0][0] == "O")
    	    if (status[1][1] == "O")
        	    if (status[2][2] == "O")
        	    {
        	        currentMessage = "Player O Won!";
        			return true;
        	    }

		if (status[2][0] == "X")
    		if (status[1][1] == "X")
        		if (status[0][2] == "X")
        	    {
        	        currentMessage = "Player X Won!";
        			return true;
        	    }
	    if (status[2][0] == "O")
    	    if (status[1][1] == "O")
        	    if (status[0][2] == "O")
        	    {
        	        currentMessage = "Player O Won!";
        			return true;
        	    }
		            	
		return false;
	}
}
