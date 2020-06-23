public class TestAccess {}


class T {
	private int i = 0;
	        int j = 0;
	protected int k = 0;
	public int m = 0;
}

class TT extends T {
	public void m() {
		T t = new TT();
		System.out.println(t.k);
	}
}