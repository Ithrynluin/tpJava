package pattern.exo3.visiteur;

import pattern.exo3.composite.ComposantSysteme;
import pattern.exo3.composite.Fichier;
import pattern.exo3.composite.Repertoire;

/**
 * Interface représentant un visiteur de ComposantSysteme.
 * @author Imbert / Jarrige
 *
 */
public interface Visiteur {

	/**
	 * Visite un fichier.
	 * @param fichier
	 * 		Fichier à visiter
	 */
	public void visit(Fichier fichier);
	
	/**
	 * Visite un répertoire.
	 * @param repertoire
	 * 		Répertoire à visiter.
	 */
	public void visit(Repertoire repertoire);
	
	/**
	 * Effectue une action sur un composantSystème avant d'être visiter.
	 * @param composantSysteme
	 * 		Le composant à vister.
	 */
	public void beforeVisit(ComposantSysteme composantSysteme);
	
	/**
	 * Effectue une action sur un composantSystème après être visiter.
	 * @param composantSysteme
	 * 		Le composant à vister.
	 */
	public void afterVisit(ComposantSysteme composantSysteme);
}
