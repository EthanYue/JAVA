public class TestArr {
	public static void main(String[] args) {
		int[] s;
		s = new int[5];
		for (int i=0; i<5; i++) {
			s[i] = i;
		}
		System.out.println(s);
		Date[] days;
		days = new Date[3];
		for (int i=0; i<3; i++) {
			days[i] = new Date(2005, 5, 5);
		}
	}
}


class Date {
	int year;
	int month;
	int day;
	Date(int y, int m, int d) {
		year = y;
		month = m;
		day = d;
	}
}