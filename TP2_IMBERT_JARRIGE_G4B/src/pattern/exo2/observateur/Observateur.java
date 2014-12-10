package pattern.exo2.observateur;

/**
 * Interface qui représente un Observateur.
 * @author Imbert / Jarrige
 *
 */
public interface Observateur {

	/**
	 * Prévient l'Observateur d'un changement.
	 * @param donnee
	 * 		la nouvelle donnée.
	 */
	public void modifier(final Donnee donnee);
}
