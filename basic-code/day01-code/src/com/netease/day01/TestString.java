public class TestString {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";
		String s3 = "hello";
		System.out.print(s1 == s3); // true
		
		s1 = new String("hello");
		s2 = new String("hello");
		System.out.println(s1 == s2); // false
		System.out.println(s1.equals(s2)); // true
		
		char c[] = {'a', 'b', 'c', 'd', 'e', 'f'};
		String s4 = new String(c); // abcdef
		String s5 = new String(c, 4, 2); // ef
		System.out.println(s4);
		System.out.println(s5);
	}
}