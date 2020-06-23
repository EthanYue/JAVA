class Person {
	private String name;
	private String location;
	
	Person(String name) {
		this.name = name;
		location = "Beijing";
	}
	
	Person(String name, String location) {
		this.name = name;
		this.location = location;
	}
	
	public String info() {
		return "name: " + name + " location: " + location;
	}
}


class Teacher extends Person {
	private String capital;
	
	Teacher(String name, String capital) {
		this(name, "Beijing", capital);
	}
	
	Teacher(String n, String l, String capital) {
		super(n, l);
		this.capital = capital;
	}
	
	public String info() {
		return super.info() + "capital" + capital;
	}
}


public class TestTeacher{
	public static void main(String[] args) {
		Teacher t1 = new Teacher("S1", "Professor");
		t1.info();
	}
}