package pattern.exo3.visiteur;

import pattern.exo3.composite.ComposantSysteme;
import pattern.exo3.composite.Fichier;
import pattern.exo3.composite.Repertoire;

public class HierarchiqueVisiteur implements Visiteur {

	int profondeur;

	public HierarchiqueVisiteur() {
		this.profondeur = 0;
	}

	@Override
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom() + "   " + fichier.getTaille());
	}

	@Override
	public void visit(Repertoire repertoire) {
		System.out.println(repertoire.getNom());
	}

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

	@Override
	public void afterVisit(ComposantSysteme composantSysteme) {
		profondeur--;
	}

}
