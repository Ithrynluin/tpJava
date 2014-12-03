package thread.exo9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutorService {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.submit(new Task());
		executor.submit(new Task());
		executor.submit(new Task());
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdownNow();
		
		ExecutorService executor2 = Executors.newFixedThreadPool(2);
		Future<Integer> result = executor2.submit(new CallableTask());
		try {
			Integer rt = result.get();
			System.out.println(rt);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor2.shutdown();
	}
}

// Si on soumet 3 Thread, les 2 premiers s'executent normalement,
// le troisième est mis en attente puis s'éxecute une fois que ces deux Threads se terminent.

//On utilise la méthode de ExecutorService shutdown 

//Avec Runnable la methode run ne peut retourner de résultat.

//Avec Callable :
//Pour récuperer le résultat : on récupère l'objet Future que retourne submit.
//On récupère l'objet contenu dans Future avec la méthode get qui attent que le
// Thread s'arrête.