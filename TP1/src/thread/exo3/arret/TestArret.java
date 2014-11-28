package thread.exo3.arret;


public class TestArret {

	public static void main(String[] args) {
		Task task = new Task();
		new Thread(task).start();
		try {
			Thread.sleep(2_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		task.setStopped(true);
		System.out.println("Fin du main");
	}
//Si les points s'affiche toutes les 10_000ms on affiche un point alors que l'on ne
// devrait jamais rien afficher. 
}
