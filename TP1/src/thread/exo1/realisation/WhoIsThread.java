package thread.exo1.realisation;

public class WhoIsThread implements Runnable{
	@Override
	public void run() {
		for(int i=0 ; i<20 ; i++) {
			try {
				Thread.sleep(500L);
				System.out.println(this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String toString() {
		return Thread.currentThread().getName();
	}
}
