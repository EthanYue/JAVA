public class TestDouble {
	public static void main(String[] args) {
		String s = "1,2;3,4;5,6";
		String[] s1 = s.split(";");
		double[][] d = new double[s1.length][];
		for(int i=0; i<s1.length; i++) {
			String[] s2 = s1[i].split(",");
			double[] d1 = new double[s2.length];
			for(int j=0; j<s2.length; j++) {
				System.out.println(Double.parseDouble(s2[j]));
				d1[j] = Double.parseDouble(s2[j]);
			}
			d[i] = d1;
		}
		for(int i=0; i<d.length; i++)
			for(int j=0; j<d[i].length; j++)
				System.out.println(d[i][j]);
	}
}