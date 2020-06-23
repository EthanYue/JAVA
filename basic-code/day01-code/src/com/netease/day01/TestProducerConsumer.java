
public class TestProducerConsumer {
	public static void main(String[] args) {
		SyncStack ss = new SyncStack();
		Producer p = new Producer(ss);
		Consumer c = new Consumer(ss);
		new Thread(p).start();
		new Thread(c).start();
	}
}



class Bread {
	int id;
	
	Bread(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Bread" + id;
	}
}


class SyncStack {
	int index = 0;
	Bread[] arr = new Bread[6];
	
	public synchronized void push(Bread b) {
		if(index == arr.length) {
			try {
				this.wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		arr[index] = b;
		index++;
	}
	
	public synchronized Bread pop() {
		if(index == 0) {
			try {
				this.wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.notify();
		index--;
		return arr[index];
	}
}


class Producer implements Runnable {
	SyncStack ss = null;
	
	Producer(SyncStack ss) {
		this.ss = ss;
	}
	
	public void run() {
		for(int i=0; i<20; i++) {
			Bread b = new Bread(i);
			ss.push(b);
			System.out.println("Product:" + b);
			try {
				Thread.sleep((int)(Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}



class Consumer implements Runnable {
	SyncStack ss = null;
	Consumer(SyncStack ss) {
		this.ss = ss;
	}
	
	public void run() {
		for(int i=0; i<20; i++) {
			Bread b = ss.pop();
			try {
				Thread.sleep((int)(Math.random() * 2000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Consume:" + b);
		}
	}
}