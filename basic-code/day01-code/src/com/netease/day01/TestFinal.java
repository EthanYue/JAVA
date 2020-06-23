public class TestFinal {
	public static void main(String[] args) {
		T t = new T();
		t.i = 9;
	}
}


final class T {
	final int i = 8;
	//public void m(final int j) {j = 9;}
	public final void m(){}
}


class TT extends T {
	public void m(){}
}