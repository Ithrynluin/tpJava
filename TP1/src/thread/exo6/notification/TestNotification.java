package thread.exo6.notification;
import thread.exo6.notification.Printer.Parite;

public class TestNotification {

	public static void main(String[] args) {
		final Compteur compteur = new Compteur();
		
		new Thread(new Printer(compteur, Parite.Pair)).start();
		new Thread(new Printer(compteur, Parite.Impair)).start();
	}

}
