package prut.kth.se.Labb4.human;

public class Woman extends Human {
	protected Woman(String name, String pid) {
		super(name, pid);
	}
	public String toString() {
		return "Jag �r kvinna och heter " + super.name;
	}
}
