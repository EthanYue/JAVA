import java.util.*;
public class TestArgsWords {
	private static final Integer ONE = new Integer(1);
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		for(int i=0; i<args.length; i++) {
			if (m.containsKey(args[i])) {
				int _i = m.get(args[i]);
				m.put(args[i], _i == 0 ? ONE : _i + 1);
			} else m.put(args[i], ONE);
			
		}
		System.out.println(m.size() + " distinct words detected:");
		System.out.println(m);
	}
}