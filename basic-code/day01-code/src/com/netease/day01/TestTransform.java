import java.io.*;
public class TestTransform {
	public static void main(String[] args) {
		//writer();
		reader();
	}
	
	static void reader() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = null;
		try {
			s = br.readLine();
			while(s!=null) {
				if(s.equalsIgnoreCase("exit")) break;
				System.out.println(s.toUpperCase());
				s = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void writer() {
		try {
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:/JAVA_workspace/HelloWorld.java"));
			osw.write("asdfsadgafsdgdhgdfsghdsfgdsfg");
			System.out.println(osw.getEncoding());
			osw.close();
			osw = new OutputStreamWriter(
			new FileOutputStream("d:/JAVA_workspace/HelloWorld.java", true), // append
			"GBK"); 
			osw.write("asdfasdgvsvcdbfdghnfdgh");
			System.out.println(osw.getEncoding());
			osw.close();
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}