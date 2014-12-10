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
		afficher();
	}

	@Override
	public void visit(Repertoire repertoire) {
		afficher();
	}

	private void afficher() {
		boolean first = true;
		for(String nom : rep){
			if(first){
				System.out.print(nom);
				first = false;
			}else{
				System.out.print("\\" + nom);
			}
		}
		System.out.println();//Pour faire un saut de ligne.
	}

	@Override
	public void beforeVisit(ComposantSysteme composantSysteme) {
		rep.add(composantSysteme.getNom());
	}

	@Override
	public void afterVisit(ComposantSysteme composantSysteme) {
		rep.remove(composantSysteme.getNom());
	}

}
