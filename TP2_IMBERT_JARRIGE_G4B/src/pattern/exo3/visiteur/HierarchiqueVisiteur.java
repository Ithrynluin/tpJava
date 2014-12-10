package pattern.exo3.visiteur;

import pattern.exo3.composite.ComposantSysteme;
import pattern.exo3.composite.Fichier;
import pattern.exo3.composite.Repertoire;

/**
 * Classe qui affiche sous forme d'arbre une arborescence de COmposantSystème.
 * Cette classe est un Visiteur.
 * @author Imbert / Jarrige
 *
 */
public class HierarchiqueVisiteur implements Visiteur {

	int profondeur;

	/**
	 * Constructeur par défaut.
	 */
	public HierarchiqueVisiteur() {
		this.profondeur = 0;
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#visit(Fichier)
	 */
	@Override
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom() + "   " + fichier.getTaille());
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#visit(Repertoire)
	 */
	@Override
	public void visit(Repertoire repertoire) {
		System.out.println(repertoire.getNom());
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#beforeVisit(ComposantSysteme)
	 */
	@Override
	public void beforeVisit(ComposantSysteme composantSysteme) {
		for (int i = 1; i < profondeur; i++) {
			System.out.print("\t");
		}
		if (profondeur != 0) {
			System.out.print("\\------ ");
		}
		profondeur++;
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#afterVisit(ComposantSysteme)
	 */
	@Override
	public void afterVisit(ComposantSysteme composantSysteme) {
		profondeur--;
	}

}
