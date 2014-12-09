package pattern.exo3.visiteur;

import java.util.List;

import pattern.exo3.composite.ComposantSysteme;
import pattern.exo3.composite.Fichier;
import pattern.exo3.composite.Repertoire;

public class HierarchiqueVisiteur implements Visiteur {
	
	public HierarchiqueVisiteur() {
	}

	@Override
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom());
	}

	@Override
	public void visit(Repertoire repertoire) {
		System.out.println(repertoire.getNom());
	}

	@Override
	public void beforeVisit(ComposantSysteme composantSysteme) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterVisit(ComposantSysteme composantSysteme) {
		// TODO Auto-generated method stub

	}

}
