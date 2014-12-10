package pattern.exo2.observateur;

/**
 * Interface qui représente un sujet à observer.
 * @author Imbert / Jarrige
 *
 */
public interface Sujet {
	/**
	 * Ajoute un observateur au sujet.
	 * @param observateur
	 * 		l'observateur à ajouter.
	 */
	public void ajouterObservateur(Observateur observateur);
	
	/**
	 * Supprime un observateur au sujet.
	 * @param observateur
	 * 		l'observateur à supprimer.
	 */
	public void retirerObservateur(Observateur observateur);
	
	/**
	 * Notifie tous les observateurs du sujet.
	 */
	public void notifierObservateurs();
}
