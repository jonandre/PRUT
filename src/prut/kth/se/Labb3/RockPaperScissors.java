package prut.kth.se.Labb3;

public class RockPaperScissors implements Boardgame {
	
	private String currentMessage = "No message yet";
	private String[] status = new String[1000];  // spelplanen
	private boolean player = true;
	private int[] stats = new int[3]; 
	private Server server;
	/**
	 * 
	 */
	public RockPaperScissors() {
		server = new Server();
		server.write("Player");
		server.read();
		
		for (int i = 0; i < 3; i++)
			stats[i] = 0;
	}
	/**
	 * @return 
	 * 
	 */
	@Override
	public boolean move(int i) {
		String temp = null;
		if (i == 0)
		{
			server.write("STEN");
			temp = "STEN";
		}
		else if (i == 1)
		{
			server.write("SAX");
			temp = "SAX";
		}
		else if (i == 2)
		{
			server.write("PÅSE");
			temp = "PÅSE";
		}
		String read = server.read();
		int anser;
		if (read.equals("STEN"))
			anser = 0;
		else if (read.equals("SAX"))
			anser = 1;
		else
			anser = 2;
			
		if (i == anser)
		{
			currentMessage = " Even";
			stats[2] += 1;
		}
		else if (i == 0 && anser == 1 || i == 1 && anser == 2 || i == 2 && anser == 0)	
		{
			currentMessage = " Win";
			stats[0] += 1;
		}
		else
		{
			currentMessage = " Lose";
			stats[1] += 1;
		}
		
		status[Labb3.move] = "Player:" + temp + " Server:" + read + currentMessage;
		System.out.println(status[Labb3.move]);
		Labb3.move++;
		return player;
	}
	/**
	 * 
	 */
	@Override
	public String getStatus(int i) {
		return status[i];
	}
	/**
	 * 
	 */
	@Override
	public String getMessage() {
		return currentMessage;
	}
	@Override
	public int[] getStats() {
		return stats;
	}
}
