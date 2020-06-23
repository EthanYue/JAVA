public class TestInterger {
	public static void main(String[] args) {
		Integer i = new Integer(100);
		Double d = new Double("123.123");
		int j = i.intValue() + d.intValue();
		float f = i.floatValue() + d.floatValue();
		System.out.println(j);
		System.out.println(f);
		double pi = Double.parseDouble("3.1415926535");
		double r = Double.valueOf("2.0");
		double s = pi * r * r;
		System.out.println(s);
		try {
			int k = Integer.parseInt("1.25");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(Integer.toBinaryString(123) + 'B');

	}
}