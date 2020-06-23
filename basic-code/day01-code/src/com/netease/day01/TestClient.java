import java.net.*;
import java.io.*;
public class TestClient {
	public static void main(String[] args) throws Exception{
		Socket s = new Socket("127.0.0.1", 6666);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeUTF("hello");
		dos.flush();
		dos.close();
		s.close();
	}
}