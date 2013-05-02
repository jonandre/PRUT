package prut.kth.se.Labb4.human;

public class Man extends Human {
	protected Man(String name, String pid) {
		super(name, pid);
	}
	public String toString() {
		return "Jag är man och heter " + super.name;
	}
}
