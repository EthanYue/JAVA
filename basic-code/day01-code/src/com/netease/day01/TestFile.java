import java.io.*;
public class TestFile {
	public static void main(String[] args) {
		String separator = File.separator;
		String filename = "my.txt";
		String directory = "com" + separator + "netease";
		File f = new File(directory, filename);
		if (f.exists()) {
			System.out.println("filename: " + f.getAbsolutePath());
			System.out.println("file size: " + f.length());
			System.out.println(f.getParentFile());
		} else {
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}