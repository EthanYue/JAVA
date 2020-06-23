import java.io.*;
public class TestBuffer {
	public static void main(String[] args) {
		try {
			FileInputStream f = new FileInputStream("d:/JAVA_workspace/HW.java");
			BufferedInputStream bf = new BufferedInputStream(f);
			int c = 0;
			System.out.println((char)f.read());
			System.out.println((char)bf.read());
			bf.mark(100);
			for(int i=0; i<=10 && (c=bf.read())!=-1; i++) {
				System.out.print((char)c+" ");
			}
			System.out.println();
			bf.reset();
			for(int i=0; i<=10 && (c=bf.read())!=-1; i++) {
				System.out.print((char)c+" ");
			}
			bf.close();
			
			
			
			
			BufferedReader br = new BufferedReader(new FileReader("d:/JAVA_workspace/HelloWorld.java"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("d:/JAVA_workspace/HelloWorld.java"));
			String s = null;
			for(int i=0; i<=100; i++) {
				s = String.valueOf(Math.random());
				bw.write(s);
				bw.newLine();
			}
			bw.flush();
			while((s=br.readLine())!=null) {
				System.out.println(s);
			}
			bw.close();
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}