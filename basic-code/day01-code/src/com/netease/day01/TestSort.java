public class TestSort {
	public static void main(String[] args) {
		int[] arr = new int[args.length];
		for (int i=0; i<args.length; i++) {
			arr[i] = Integer.parseInt(args[i]);
		}
		bubleSort(arr);
		//selectionSort(arr);
		//insertSort(arr);
		print(arr);
		
	}
	
	private static void bubleSort(int[] arr) {
		for (int i=arr.length-1; i>=1; i--) {
			for (int j=0; j<=i-1; j++) {
				if (arr[j]>arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
	
	private static void selectionSort(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j] < arr[i]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	private static void insertSort(int[] arr) {
		int minIndex, tmp;
		for (int i=0; i<arr.length; i++) {
			minIndex = i;
			for (int j=i+1; j<arr.length; j++) {
				if (arr[j] < arr[i]) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				tmp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = tmp;
			}
		}
	}
	
	private static void print(int[] arr) {
		for (int i=0; i<arr.length; i++) System.out.print(arr[i] + ", ");
	}
}