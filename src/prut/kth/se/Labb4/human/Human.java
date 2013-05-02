package prut.kth.se.Labb4.human;

public class Human {
	protected Human(String name, String pid)
	{
		this.name = name;
		this.pid = pid;
	}
	
	protected String name;
	protected String pid;
	
	public static Human create(String name, String pid) {
		if (((pid.charAt(9) - '0') % 2) == 0)
			return new Woman(name, pid);
		else
			return new Man(name, pid);
    }
}
