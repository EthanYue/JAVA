public class TestStatic {
	//private static int sid = 0;
	private int sid;
	private String name;
	int id;
	
	TestStatic(String name) {
		this.name = name;
		id = sid++;
	}
	
	public void info() {
		System.out.println("name is " + id);
	}
	
	public static void main(String[] args) {
		//TestStatic.sid = 100;
		TestStatic ts1 = new TestStatic("mimi");
		TestStatic ts2 = new TestStatic("pipi");
		ts1.info();
		ts2.info();
	}
}