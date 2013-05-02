package prut.kth.se.Labb3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server {
	private String server = "gru-ld03.csc.kth.se";
	private int serverIP = 4713;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter ut;
	
	/**
	 * Initializes a server
	 */
	public Server() {
		try {
			socket = new Socket(server, serverIP);
		    in = new BufferedReader
		    		(new InputStreamReader(socket.getInputStream()));
		    ut = new PrintWriter(socket.getOutputStream());
		    
		} catch (Exception e) {
			// No connection with the server!
		}
	}

	/**
	 * The strings should be sent to the server 
	 *  "STEN", "SAX", "PÅSE", "", or the name of the user;
	 * @param text
	 */
	public void write(String text) {
	    ut.println(text); 
	    ut.flush();
	}
	
	/**
	 * Reads from server
	 * @return
	 */
	public String read() {
		try {
			return in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
