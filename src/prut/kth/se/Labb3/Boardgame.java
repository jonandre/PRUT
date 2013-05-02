package prut.kth.se.Labb3;

public interface Boardgame {
	public boolean move(int i); //returnerar true om draget gick bra, annars false 
	public String getStatus(int i);
	public String getMessage();
	public int[] getStats();
}