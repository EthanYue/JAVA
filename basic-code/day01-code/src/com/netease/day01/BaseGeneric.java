import java.util.*;
public class BaseGeneric {
	public static void main(String[] args) {
		List<String> c = new ArrayList<String>();
		c.add("aaa");
		c.add("bbb");
		c.add("ccc");
		System.out.println(c);
		
		Collection<String> c2 = new HashSet<String>();
		c2.add("aaa");
		c2.add("bbb");
		for(Iterator<String> it = c2.iterator(); it.hasNext();) {
			String s = it.next();
			System.out.println(s);
		}
	}
}


class MyName implements Comparable<MyName> {
	int age;
	public int compareTo(MyName mn) {
		return this.age > mn.age ? 1 : this.age < mn.age ? -1 : 0;
	}
}