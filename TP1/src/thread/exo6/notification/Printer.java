package thread.exo6.notification;

public class Printer implements Runnable {
	public enum Parite {
		Pair, Impair
	}

	private final Compteur cpt;
	private final Parite parite;

	public Printer(Compteur cpt, Parite parite) {
		this.cpt = cpt;
		this.parite = parite;
	}

	@Override
	public void run() {
		long mod = 0;

		if (parite == Parite.Impair) {
			mod = 1;
		}

		while (true) {
			synchronized (cpt) {
				while (cpt.getL() % 2 != mod) {
					try {
						cpt.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (cpt) {
				while (cpt.getL() % 2 == mod) {

					System.out.println(parite + " " + cpt.getL());
					cpt.next();
					cpt.notifyAll();
				}
			}
		}

	}
}
