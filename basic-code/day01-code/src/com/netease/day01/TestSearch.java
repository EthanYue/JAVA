public class TestSearch {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int i = 7;
		System.out.println(binarySearch(a, i));
	}
	
	public static int search (int[] a, int num) {
		for(int i=0; i<a.length; i++) {
			if(a[i] == num) return i;
		}
		return -1;
	}
	
	public static int binarySearch(int[] a, int num) {
		if(a.length == 0) return -1;
		int start = 0;
		int end = a.length - 1;
		int middle = (start + end) / 2;
		while (start <= end) {
			if(a[middle] == num) return middle;
			if(a[middle] < num) {
				start = middle + 1;
			}
			if(a[middle] > num) {
				end = middle - 1;
			}
			middle = (start + end) / 2;
		}
		return -1;
	}
}