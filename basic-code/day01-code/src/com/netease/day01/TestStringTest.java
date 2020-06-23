public class TestStringTest {
	public static void main(String[] args) {
		/*
		String s = "SASLDHlskajdlaksjdaALSKDNLASkjdsf(*Q&(W&Q^RQ&R";
		String lowerCase = "";
		String upperCase = "";
		String notWord = "";
		for(int i=0; i<s.length(); i++) {
			char _s = s.charAt(i);
			if(Character.isAlphabetic(_s)) {
				if (Character.isLowerCase(_s)) lowerCase += _s;
				else upperCase += _s; 
			} else notWord += _s;
		}
		System.out.println(lowerCase);
		System.out.println(upperCase);
		System.out.println(notWord);
		*/
		String s = "sunjavapjasdjavajajajavasadfjava";
		int index = 0;
		int cnt = 0;
		while (true) {
			index = s.indexOf("java", index) + 4;
			if (index > 4) cnt++; 
			else break;
		}
		System.out.println(cnt);
	}
}