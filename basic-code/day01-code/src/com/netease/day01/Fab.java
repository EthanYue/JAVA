public class Fab {
	public static void main(String[] args) {
		System.out.println(f(5));
	}
	public static long f(int n) {
	if (n == 1 || n == 2)
		return 1;
	long f1 = 1L;
	long f2 = 1L;
	long f = 0;
	for(int i=0; i<n-2; i++) {
		f = f1 + f2;
		f1 = f2;
		f2 = f;
	}
	return f;
	}
}