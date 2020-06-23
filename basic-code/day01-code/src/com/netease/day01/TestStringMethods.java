public class TestStringMethods {
	public static void main(String[] args) {
		String s1 = "sun java";
		System.out.println(s1.charAt(1));
		System.out.println(s1.length());
		System.out.println(s1.indexOf("java"));
		System.out.println(s1.equalsIgnoreCase("sun Java"));
		String s2 = s1.replace("java", "python");
		System.out.println(s2);
		s.startsWith("python");
		s.endsWith("python");
		s.toLowerCase();
		s.toUpperCase();
		s.substring(5); // startIndex to end
		s.trim(); // strip space
		int j = 1234;
		String jNum = String.valueOf(j); // "1234"
		System.out.println("j is " + jNum.legnth());
		String s = "Mary,F,1994";
		String[] sp = s.split(","); // ["Mary", "F", "1994"]
	}
}