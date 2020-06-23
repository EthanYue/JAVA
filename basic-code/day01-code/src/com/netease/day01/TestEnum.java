public class TestEnum {
	public enum MyColor {red, green, blue};
	
	public static void main(String[] args) {
		MyColor m = MyColor.red;
		switch(m) {
			case red:
				System.out.println("red");
				break;
			default:
				System.out.println("default");
		}
	}
}