package thread.exo7;

import java.util.List;

public class Producer implements Runnable {
	private List<String> strings;
	private int SIZE;

	public Producer(List<String> strings, int SIZE) {
		this.strings = strings;
		this.SIZE = SIZE;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1_000);
				produce();
				System.out.println("produce " + strings.size());
			}
		} catch (InterruptedException ie) {
			System.out
					.println(Thread.currentThread().getName() + " interrompu");
		}
	}

	public void produce() {
		synchronized(strings){
			while(strings.size() >= this.SIZE){
				try {
					strings.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String str = "azertyuiop";
			this.strings.add(str);
			strings.notifyAll();
		}
		
	}

}
