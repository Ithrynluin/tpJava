package thread.exo2;

public class TestDemon {

	public static void main(String[] args) {
		new Demon().start();
		
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Arrêt " + Thread.currentThread().getName());
	}

}

//1 - L'application se termine mais le Thread continue à s'exécuter.
//2 - Quand l'application se termine le Thread s'arrête.