package pattern.exo2.observateur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Cette est classe représente un capteur météorologique.
 * Elle génère des données toutes les 500 millisecondes.
 * 
 * Cette classe est un Sujet.
 * 
 * @author Imbert / Jarrige
 *
 */
public class Capteur implements Runnable, Sujet {

	private final List<Observateur> observateurs;
	private Donnee donnee;
	private int compteur;
	
	/**
	 * Constructeur par défaut.
	 */
	public Capteur() {
		this.observateurs = new ArrayList<Observateur>();
		this.donnee = null;
		this.compteur = 0;
	}
	
	/**
	 * Génère des données tous les 500 ms.
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try{
			while(!Thread.currentThread().isInterrupted()){
				Thread.sleep(500L);
				this.donnee = new Donnee(ThreadLocalRandom.current().nextDouble(-30, 40),
									ThreadLocalRandom.current().nextDouble(0, 100),
									ThreadLocalRandom.current().nextDouble(800, 1_200));
				this.notifierObservateurs();
			}
		}catch(InterruptedException Ie){
			System.out.println("Interruption : " + Thread.currentThread().getName());
		}
	}

	/**
	 * @see pattern.exo2.observateur.Sujet#ajouterObservateur(Observateur)
	 */
	@Override
	public void ajouterObservateur(Observateur observateur) {
		if(observateur == null){
			throw new NullPointerException("L'observateur ne doit pas être null.");
		}
		this.observateurs.add(observateur);
	}

	/**
	 * @see pattern.exo2.observateur.Sujet#retirerObservateur(Observateur)
	 */
	@Override
	public void retirerObservateur(Observateur observateur) {
		if(observateur == null){
			throw new NullPointerException("L'observateur ne doit pas être null.");
		}
		this.observateurs.remove(observateur);
	}

	/**
	 * @see pattern.exo2.observateur.Sujet#notifierObservateurs()
	 */
	@Override
	public void notifierObservateurs() {
		for(Observateur obs : observateurs){
			obs.modifier(this.donnee);
		}
	}

}
