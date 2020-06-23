public class TestArgs {
	public static void main(String[] args) {
		if(args.length < 3) {
			System.out.println("usage: java Test n1 op n2;");
			System.exit(-1);
		}
		double d1 = Double.parseDouble(args[0]);
		double d2 = Double.parseDouble(args[2]);
		double d = 0;
		if(args[1].equals("+")) System.out.println(d1 + d2);
	}
	
}