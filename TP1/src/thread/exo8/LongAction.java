package thread.exo8;

import javax.swing.SwingWorker;

public class LongAction implements Runnable {
	
	@Override
	public void run() {
		this.traitementLong();
	}

	public void traitementLong() {
		for(int i = 0; i < 100; i++){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(".");
		}
	}

}
