package thread.exo3.arret;

public class Task implements Runnable{

	private boolean stopped;
	
	public Task(){
		this.stopped = false;
	}
	
	public synchronized void setStopped(boolean stopped){
		this.stopped = stopped;
	}
	
	public synchronized boolean isStopped(){
		return this.stopped;
	}
	
	@Override
	public void run() {
		
		while(!this.isStopped()){
			try {
				Thread.sleep(10_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("Fin run");
	}
	
}
