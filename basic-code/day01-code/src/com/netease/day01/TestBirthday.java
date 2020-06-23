public class BirthDate {
	private int day;
	private int month;
	private int year;
	
	public BirthDate(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	public void setDay(int d) {
		day = d;
	}
	
	public void setMonth(int m) {
		month = m;
	}
	
	public void setYear(int y) {
		year = y;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void display () {
		System.out.println(day + "-" + month + "-" + year);
	}
}


public class TestBirthday {
	public void static main(String[] args) {
		TestBrithday tb = new TestBirthday();
		int date = 9;
		BirthDate d1 = new BirthDate(7, 7, 1970);
		BirthDate d1 = new BirthDate(1, 1, 2020);
		tb.change1(d1);
		tb.change2(d2);
		test.change3(d2);
		System.out.println("date=" + date);
		d1.display();
		d2.display();
	}
	
	public void change1(int i) {
		i = 1234;
	}
	
	public void change2(BirthDate b) {
		b = new BirthDate(22, 2, 2004);
	}
	
	public void change3(BirthDate b) {
		b.setDay(22);
	}
}













