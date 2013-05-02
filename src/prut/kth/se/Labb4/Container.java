package prut.kth.se.Labb4;

import java.util.Vector;

public class Container extends Item{
	
	protected Container parent;
	protected Vector<Item> items = new Vector<Item>(4);
	
	public Container(String name, int weight, Container parent) {
		super(name, weight);
		this.parent = parent;
	}
	public void add(Item item) {
		items.add(item);
	}
	public void remove(int index) {
		items.remove(index);
	}
	public Item[] getContent() {
		Item[] rc = new Item[items.size()];
		items.toArray(rc);
		return rc;
	}
	public int getWeight() {
		int rc = super.getWeight();
		for (int i = 0; i < items.size(); i++)
			rc += items.get(i).getWeight();
		return rc;
	}

	public String toString() {
		return name + " container";
	}
	public Container getParent() {
		return this.parent;
	}
}
