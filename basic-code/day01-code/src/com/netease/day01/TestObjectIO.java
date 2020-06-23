import java.io.*;
public class TestObjectIO {
	public static void main(String[] args) {
		T t = new T();
		t.k = 8;
		try {
			FileOutputStream fos = new FileOutputStream("d:/JAVA_workspace/print.log");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(t);
			oos.flush();
			oos.close();
			FileInputStream fis = new FileInputStream("d:/JAVA_workspace/print.log");
			ObjectInputStream ois = new ObjectInputStream(fis);
			try {
				T tr = (T)ois.readObject();
				System.out.println(tr.i+" "+tr.j+" "+tr.d+" "+tr.k);
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}


class T implements Serializable {
	int i = 0;
	int j = 9;
	double d = 2.3;
	transient int k = 0;
}