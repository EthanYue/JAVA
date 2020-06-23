public class TestArrCopy {
	public static void main(String[] args) {
		String[] s = {"a", "b", "c"};
		String[] sBak = new String[6];
		System.arraycopy(s, 0, sBak, 0, s.length);
		for(int i=0; i<sBak.length; i++) {
			System.out.print(sBak[i] + ", ");
		}
		System.out.println();
		int[][] intArr = {{1, 2}, {1, 2, 3}, {3, 5}};
		int[][] intArrBak = new int[3][];
		System.arraycopy(intArr, 0, intArrBak, 0, intArr.length);
		
		for(int i=0; i<intArrBak.length; i++) {
			for(int j=0; j<intArrBak[i].length; j++) {
				System.out.println(intArrBak[i][j] + ", ");
			}
			System.out.println();
		}
		
		intArrBak[2][1] = 100;
		for(int i=0; i<intArr.length; i++) {
			for(int j=0; j<intArr[i].length; j++) {
				System.out.println(intArr[i][j] + ", ");
			}
			System.out.println();
		}
	}
}