package prut.kth.se.Labb4;

import java.util.Scanner;

import prut.kth.se.Labb4.human.*;

/**
 * 
 * @author Jonas
 *
 */
public class Labb4 {
	protected static Scanner scan;
	protected static Container bag = new Container("Bag", 10, null);
	
	protected static Container openContainer = bag;
	
	public static void main(String[] u) {

		scan = new Scanner(System.in);
		System.out.println("Hi and welcome to the bag packing program!");
		System.out.println("You have an empty bag right now!");
		while (true)
		{
			System.out.println("What would you like to do?");

			System.out.println("1: add a contianer");
			System.out.println("2: add an item");
			System.out.println("3: remove an item");
			System.out.println("4: get weights");
			System.out.println("5: open container");
			if (openContainer != bag)
				System.out.println("6: go to previus contianer");
			System.out.println("7: Quit");
				
			int indata = scan.nextInt();
			if (indata == 1)
			{
				System.out.println("What type of container would you like to add?");
				String name = scan.next();
				System.out.println("How much does this container weight in mg?");
				int weigth = scan.nextInt();
				System.out.println(0 + ": " + openContainer.toString());
				int i = 1;
				for (Item item : openContainer.getContent())
				{
					System.out.println(i + ": " + item.toString());
					i++;
				}
				System.out.println("To what container would you like to add this item to?");
				int place = scan.nextInt();
				if (place == 0)
					openContainer.add(new Container(name, weigth, openContainer));
				else
				{
					Item container = openContainer.getContent()[place]; 
					if (container instanceof Container)
						((Container)(container)).add(new Container(name, weigth, openContainer));
					else
						System.out.println(container.toString() + " is not a container.");
				}

				int j = 1;
				System.out.println(openContainer.toString());
				for (Item item : openContainer.getContent())
				{
					System.out.println(j + ": " + item.toString());
					j++;
				}
			}
			else if (indata == 2)
			{
				System.out.println("What type of item would you like to add?");
				String name = scan.next();
				System.out.println("How much does this item weight in mg?");
				int weigth = scan.nextInt();
				System.out.println(0 + ": " + openContainer.toString());
				int i = 1;
				for (Item item : openContainer.getContent())
				{
					System.out.println(i + ": " + item.toString());
					i++;
				}
				System.out.println("To what container would you like to add this item to?");
				int place = scan.nextInt();
				if (place == 0)
					openContainer.add(new Item(name, weigth));
				else
				{
					Item container = openContainer.getContent()[place - 1]; 
					if (container instanceof Container)
						((Container)(container)).add(new Item(name, weigth));
					else
						System.out.println(container.toString() + " is not a container.");
				}

				int j = 1;
				System.out.println(openContainer.toString());
				for (Item item : openContainer.getContent())
				{
					System.out.println(j + ": " + item.toString());
					j++;
				}
			}
			else if (indata == 3)
			{
				int i = 1;
				for (Item item : openContainer.getContent())
				{
					System.out.println(i + ": " + item.toString());
					i++;
				}
				
				if (openContainer.getContent().length == 0)
					System.out.println("You have no items to remove!");
				else
				{
					System.out.println("What item would you like to remove?");
					int item = scan.nextInt();
					openContainer.remove(item - 1);
				}

				int j = 1;
				System.out.println(openContainer.toString());
				for (Item item : openContainer.getContent())
				{
					System.out.println(j + ": " + item.toString());
					j++;
				}
			}
			else if (indata == 4)
			{
				int i = 1;
				System.out.println(openContainer.toString() + " : "  + openContainer.getWeight());
				for (Item item : openContainer.getContent())
				{
					System.out.println(i + ": " + item.toString() + " : " + item.getWeight());
					i++;
				}
			}
			else if (indata == 5)
			{
				int i = 1;
				for (Item item : openContainer.getContent())
				{
					System.out.println(i + ": " + item.toString());
					i++;
				}
				int place = scan.nextInt();
				Item container = openContainer.getContent()[place - 1]; 
				if (container instanceof Container)
					openContainer = (Container) openContainer.getContent()[place - 1]; 
				else
					System.out.println(container.toString() + " is not a container so you cant open it.");
				
				
				int j = 1;
				System.out.println(openContainer.toString());
				for (Item item : openContainer.getContent())
				{
					System.out.println(j + ": " + item.toString());
					j++;
				}
			}
			else if (indata == 6)
			{
				if (openContainer.getParent() != null)
					openContainer = openContainer.getParent(); 
				
				int j = 1;
				System.out.println(openContainer.toString());
				for (Item item : openContainer.getContent())
				{
					System.out.println(j + ": " + item.toString());
					j++;
				}
			}
			else if (indata == 7)
			{
				break;
			}
			
		}
		
	    Human anna = Human.create("Anna", "xxxxxx-012x");
	    Human magnus = Human.create("Magnus","xxxxxx-011x");
	    System.out.println(anna);
	    System.out.println(magnus);
	    
	    //Man man = new Man("kl", "2626262610");
	    
	}
}