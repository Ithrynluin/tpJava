package pattern.exo3.visiteur;

import java.util.ArrayList;
import java.util.List;

import pattern.exo3.composite.ComposantSysteme;
import pattern.exo3.composite.Fichier;
import pattern.exo3.composite.Repertoire;

public class GlobalNameVisiteur implements Visiteur {

	List<String> rep;
	
	public GlobalNameVisiteur() {
		rep = new ArrayList<String>();
	}
	
	@Override
	public void visit(Fichier fichier) {
		for(String nom : rep){
			System.out.print(nom + "\\");
		}
		System.out.println();
		afterVisit(fichier);
	}

	@Override
	public void visit(Repertoire repertoire) {
		for(String nom : rep){
			System.out.print(nom + "\\");
		}
		System.out.println();
	}

	@Override
	public void beforeVisit(ComposantSysteme composantSysteme) {
		rep.add(composantSysteme.getNom());
	}

	@Override
	public void afterVisit(ComposantSysteme composantSysteme) {
		int size = rep.size();
		if(size > 0){
			rep.remove(size - 1);
		}
		
	}

}
