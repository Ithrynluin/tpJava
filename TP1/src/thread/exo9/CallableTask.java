package thread.exo9;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int cpt = 0;

		try {
			for (int i = 0; i < 10; i++) {
				Thread.sleep(1_000);
				cpt++;
			}
		} catch (InterruptedException e) {
			System.out.println("Interruption");
		}
		return new Integer(cpt);
	}

}
