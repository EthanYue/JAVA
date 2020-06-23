import java.io.*;
public class TestFileTree {
	public static void main(String[] args) {
		File f = new File("D:/JAVA_workspace");
		fileTree(f, 0);
	}
	
	public static void fileTree(File f, int level) {
		String preStr = "";
		for (int i=0; i<level; i++) {
			preStr += "-";
		}
		File[] list = f.listFiles();
		for(int i=0; i<list.length; i++) {
			System.out.println(preStr + list[i].getName());
			if (list[i].isDirectory()) {
				fileTree(list[i], level+1);
			}
		}
	}
}