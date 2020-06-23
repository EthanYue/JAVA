import java.io.*;
import java.util.*;
public class TestPrintStream {
	public static void main(String[] args) {
		// stream1();
		// stream2(args[0]);
		stream3();
	}
	
	static void stream1() {
		PrintStream ps = null;
		try {
			FileOutputStream fos = new FileOutputStream("d:/JAVA_workspace/print.log");
			ps = new PrintStream(fos);
		} catch(IOException e) {
			e.printStackTrace();
		}
		if(ps != null) {
			System.setOut(ps);
		}
		int ln = 0;
		for(char c=0; c<=60000; c++) {
			System.out.print(c+" ");
			if(ln++ >= 100) { 
				System.out.println();
				ln = 0;
			}
		}
	}
	
	static void stream2(String arg) {
		String filename = arg;
		if(filename!=null) {
			list(filename, System.out);
		}
	}
	
	static void stream3() {
		String s = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			FileWriter fw = new FileWriter("d:/JAVA_workspace/print.log", true);
			PrintWriter log = new PrintWriter(fw);
			while((s=br.readLine())!=null) {
				if(s.equalsIgnoreCase("exit")) break;
				System.out.println(s.toUpperCase());
				log.println("---");
				log.println(s.toUpperCase());
				log.flush();
			}
			log.println("==="+new Date()+"===");
			log.flush();
			log.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void list(String f, PrintStream fs) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String s = null;
			while((s=br.readLine())!=null) {
				fs.println(s);
			}
			br.close();
		} catch(IOException e) {
			fs.println("can not read file");
		}
	}
}