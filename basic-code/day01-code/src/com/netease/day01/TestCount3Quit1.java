public class TestCount3Quit1 {
	public static void main(String[] args) {
		boolean[] arr = new boolean[500];
		for (int i=0; i<arr.length; i++) {
			arr[i] = true;
		}
		int leftCount = arr.length;
		int countNum = 0;
		int index = 0;
		while (leftCount > 1) {
			if(arr[index] == true) {
				countNum++;
				if(++countNum % 3 == 0) {
					arr[index] = false;
					leftCount--;
				}
			}
			index = ++ index % 500;
		}
		
		for (int i=0; i<arr.length; i++) {
			if(arr[i] == true) {
				System.out.println(i);
			}
		}
	}
}