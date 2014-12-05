package thread.exo4.interruption;

public class TestInterruption {

	public static void main(String[] args) {
		final Task task = new Task();
		Thread thread = new Thread(task);
		
		thread.start();
		try {
			Thread.sleep(2000);
			thread.interrupt();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
	
	//Si les points s'affichent toutes les 10_000 ms, le programme se terminant
	//au bout de 2_000 ms, il s'arrêtera sans afficher aucun point.

}
