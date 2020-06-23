import java.io.*;
public class TestFileReader {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter wr = null;
		int c = 0;
		try {
			fr = new FileReader("d:/JAVA_workspace/HelloWorld.java");
			wr = new FileWriter("d:/JAVA_workspace/HelloWorld.java");
			int ln = 0;
			while((c=fr.read())!=-1) {
				System.out.println((char)c);
				wr.write(c);
			}
			fr.close();
			wr.close();
		} catch(FileNotFoundException e) {
			System.out.println("file not found");
		} catch(IOException e) {
			System.out.println("file read error");
		}
	}
}