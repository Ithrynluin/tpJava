package pattern.exo3.visiteur;

import java.util.ArrayList;
import java.util.List;

import pattern.exo3.composite.ComposantSysteme;
import pattern.exo3.composite.Fichier;
import pattern.exo3.composite.Repertoire;

public class FichierVisiteur implements Visiteur {
	
	List<Fichier> fichiers;
	
	public FichierVisiteur() {
		this.fichiers = new ArrayList<Fichier>();
	}

	@Override
	public void visit(Fichier fichier) {
		fichiers.add(fichier);
	}

	@Override
	public void visit(Repertoire repertoire) {
	}

	@Override
	public void beforeVisit(ComposantSysteme composantSysteme) {
	}

	@Override
	public void afterVisit(ComposantSysteme composantSysteme) {
	}
	
	public List<Fichier> getListFichier(){
		return fichiers;
	}

}
