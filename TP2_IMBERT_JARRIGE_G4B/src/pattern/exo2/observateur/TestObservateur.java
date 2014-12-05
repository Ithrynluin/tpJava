package pattern.exo2.observateur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestObservateur implements Observateur{
	
	private int compteur = 0;
	private static ExecutorService executor;

	public static void main(String[] args) {
		final Capteur capteur = new Capteur();
		Meteo meteo = new Meteo();
		capteur.ajouterObservateur(meteo);
		
		executor = Executors.newSingleThreadExecutor();
		executor.submit(capteur);
		
		capteur.ajouterObservateur(new Statistique());
		
		try {
			Thread.sleep(3_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		capteur.retirerObservateur(meteo);
		capteur.ajouterObservateur(new Grapheur());
		capteur.ajouterObservateur(new TestObservateur());
		
		try {
			Thread.sleep(20_500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		executor.shutdownNow();
	}

	@Override
	public void modifier(Donnee donnee) {
		
		this.compteur ++;
		if(compteur >= 30){
			executor.shutdownNow();
		}
	}
	
	//Pour lancer le capteur, on creer un executorService et on 
	//lui soumet le Capteur instancier auparavant.
	
	
	//Pour montrer l'association dynamique des observateur au Sujet,
	//on ajoute un observateur à une moment donné, il doit alors s'executer.
	
}
