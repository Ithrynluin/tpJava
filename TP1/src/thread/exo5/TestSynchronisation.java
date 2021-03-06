package thread.exo5;

public class TestSynchronisation {

	private static class ConcurrentThread extends Thread{
		
		private Compteur compteur;
		
		public ConcurrentThread(Compteur compteur){
			this.compteur = compteur;
		}
		
		@Override
		public void run(){
			for(int i = 0; i < 1_000_000; i++){
				System.out.println(this.getName());
				compteur.next();
			}
		}
	}
	
	public static void main(String[] args) {
		final Compteur compteur = new Compteur();
		
		final ConcurrentThread threads[] = new ConcurrentThread[10];
		
		for(int i = 0; i < 10; i++){
			threads[i] = new ConcurrentThread(compteur);
		}
		
		for(ConcurrentThread t : threads){
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(compteur.getL());
	}
	//Il faut joindre les Thread pour afficher le résultat une fois que tous les thread au finit leur execution
	//Ce programme n'est pas thread safe car les threads ne s'executent pas en même temps.
	//Pour corriger cela on peut utiliser les notifications (exo 6).
	
}
