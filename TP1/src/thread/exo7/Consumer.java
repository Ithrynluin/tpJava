package thread.exo7;

import java.util.List;

public class Consumer implements Runnable {
	private List<String> strings;

	public Consumer(List<String> strings){
		this.strings = strings;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(2_000);
				consume();
				System.out.println("consume " + strings.size());
			}
		} catch (InterruptedException ie) {
			System.out
					.println(Thread.currentThread().getName() + " interrompu");
		}
	}

	public void consume() {
		synchronized(strings){
			while(strings.size() == 0){
				try {
					strings.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(strings.get(0));
			strings.remove(0);
			strings.notifyAll();
		}
		
	}
	
	
}
