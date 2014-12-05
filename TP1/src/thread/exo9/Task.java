package thread.exo9;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task implements Runnable {

	@Override
	public void run() {
		Date date;
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		try {
			for (int i = 0; i < 10; i++) {

				Thread.sleep(1_000);

				date = new Date();
				System.out.println(Thread.currentThread().getName() + " "
						+ format.format(date));

			}
		} catch (InterruptedException e) {
			System.out.println("Interruption");
		}
	}

	
}
