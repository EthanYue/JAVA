class Person {
	private String name;
	private int age;
	public void setName(String name){this.name=name;}
	public void setAge(int age){this.age=age;}
	public String getName(){return name;}
	public int getAge(){return age;}
	public String getInfo() {
		return "Name: " + name + "\n" + "age: " + age;
	}
}


class Student extends Person {
	private String school;
	public String getSchool(){return school;}
	public void setSchool(String school){this.school=school;}
	public String getInfo() {
		return "Name: " + getName() + "\nage: " + getAge() + "\nschool: " + school;
	}
}


public class TestOverwrite {
	public static void main(String arg[]) {
		Student student = new Student();
		Person person = new Person();
		person.setName("john");
		person.setAge(19);
		student.setName("marry");
		student.setAge(20);
		student.setSchool("SCH");
		System.out.println(person.getInfo());
		System.out.println(student.getInfo());
	}
}