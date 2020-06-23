import java.io.*;
public class TestOutputStream {
	public static void main(String[] args) {
		int b = 0;
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("d:/JAVA_workspace/HelloWorld.java");
			out = new FileOutputStream("d:/JAVA_workspace/HW.java");
			while((b=in.read())!=-1) {
				out.write(b);
			}
			in.close();
			out.close();
		} catch(FileNotFoundException e) {
			System.out.println("file not found");
			System.exit(-1);
		} catch(IOException e) {
			System.out.println("file copy error");
			System.exit(-1);
		}
		System.out.println("file copy success");
	}
}