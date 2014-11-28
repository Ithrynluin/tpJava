package thread.exo4.interruption;

public class Task implements Runnable{
	@Override
	public void run() {
		
		try {
			while(true){
				Thread.sleep(10_000L);
				System.out.print(".");
			}
		} catch (InterruptedException e) {	
				System.out.println(Thread.currentThread()+" interrompu");
		}	
	}
}
