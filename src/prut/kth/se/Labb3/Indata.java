package prut.kth.se.Labb3;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Indata {
	
	public static final ArrayDeque<Integer> indata = new ArrayDeque<Integer>();
	private static Scanner scan;
	
	public static int nextInt() {
		synchronized (indata)
		{
			if (indata.isEmpty())
				try {
					indata.wait();
				} catch (InterruptedException ignore) {
					// will never happen
				}
			
			return indata.pollFirst().intValue();
		}
	}
	
	public static void push(int element) {
		synchronized (indata)
		{
			indata.addLast(new Integer(element));
			indata.notifyAll();
		}
	}
	
	static {
		Thread thread = new Thread("Standard input reader daemon"){
			public void run() {
				scan = new Scanner(System.in);
				while (true)
				{
					int in = scan.nextInt();
					synchronized(indata)
					{
						indata.addLast(new Integer(in));
						indata.notifyAll();
					}
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
	}
}
