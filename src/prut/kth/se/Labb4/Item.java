package prut.kth.se.Labb4;

public class Item {
	protected int weight; 
	protected String name;
	
	public Item(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	public int getWeight() {
		return weight;
	}
	public String toString() {
		return name;
	}
}
