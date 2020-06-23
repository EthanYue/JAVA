import java.util.*;
public class TestBaseContainer {
	public static void main(String[] args) {
		Collection c = new HashSet(); 
		c.add("hello");
		c.add(new Name("ethan", "yue"));
		c.add(new Integer(100));
		c.remove("hello");  //true
		c.remove(new Integer(100));  //true
		c.remove(new Name("ethan", "yue")); 
		c.add(new Name("ethan", "yue"));
		c.add(new Name("ethan", "yue1"));

		Iterator i = c.iterator();
		while(i.hasNext()) {
			Name n = (Name)i.next();
			System.out.println(n);
		}
		for(Iterator i1=c.iterator(); i1.hasNext();) {
			Name name = (Name)i1.next();
			if(name.getFirstName().length()<3)
				i1.remove();
		}
		c.add(new Name("ethan", "yue"));
		c.add(new Integer(100));
		c.add(new Name("ethan", "yue"));
		c.add(new Integer(100));
		System.out.println(c);
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		s1.add("a");
		s1.add("b");
		s2.add("b");
		s2.add("c");
		Set sn = new HashSet(s1);
		sn.retainAll(s2);
		System.out.println(sn); //[b]
		Set su = new HashSet(s1);
		su.addAll(s2);
		System.out.println(su); //[a, b, c]
		
		List l1 = new LinkedList();
		for(int j=0; j<=5; j++) {
			l1.add("a"+j);
		}
		System.out.println(l1);
		l1.add(3, "a100");
		l1.set(6, "a200");
		l1.remove(1);
		System.out.println(l1.get(3));
		l1.indexOf("a3");
		
		List l2 = new LinkedList();
		List l3 = new LinkedList();
		for(int j=0; j<=9; j++) l2.add("a"+j);
		System.out.println(l2);
		Collections.shuffle(l2);
		System.out.println(l2);
		Collections.reverse(l2);
		System.out.println(l2);
		Collections.sort(l2); // overwrited compareTo method
		System.out.println(l2);
		System.out.println(Collections.binarySearch(l2, "a5"));
		
	}
}


class Name implements Comparable{
	private String firstName, lastName;
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String toString() {
		return firstName + "" + lastName;
	}
	public boolean equals(Object obj) {
		if (obj instanceof Name) {
			Name name = (Name) obj;
			return (firstName == name.firstName) && (lastName == name.lastName);
		}
		return super.equals(obj);
	}
	public int hashCode() {
		return firstName.hashCode();
	}
	
	public int compareTo(Object o) {
		Name n = (Name)o;
		int lastCmp = lastName.compareTo(n.lastName);
		return (lastCmp != 0 ? lastCmp : firstName.compareTo(n.firstName));
	}
}