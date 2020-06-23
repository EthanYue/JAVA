public class TestDeadLock2 implements Runnable {
	int b = 100;
	
	public synchronized void m1() throws Exception{ // only lock this method
		b = 1000;
		Thread.sleep(5000);
		System.out.println("b="+b);
	}
	
	public void m2() {
		System.out.println(b);
	}
	
	public synchronized void m3() throws Exception{
		Thread.sleep(2500);
		b = 2000;
	}
	
	public void run() {
		try {
			m1();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		TestDeadLock2 td = new TestDeadLock2();
		Thread t = new Thread(td);
		t.start();
		Thread.sleep(1000);
		//td.m2();
		td.m3();
	}
}