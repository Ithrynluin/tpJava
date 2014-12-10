package pattern.exo3.visiteur;

import java.util.ArrayList;
import java.util.List;

import pattern.exo3.composite.ComposantSysteme;
import pattern.exo3.composite.Fichier;
import pattern.exo3.composite.Repertoire;

/**
 * Classe affichant le nom global des ComposantSystème.
 * Cette classe est un Visiteur.
 * @author Imbert / Jarrige
 *
 */
public class GlobalNameVisiteur implements Visiteur {

	List<String> rep;
	
	/**
	 * Constructeur par défaut
	 */
	public GlobalNameVisiteur() {
		rep = new ArrayList<String>();
	}
	
	/**
	 * @see pattern.exo3.visiteur.Visiteur#visit(Fichier)
	 */
	@Override
	public void visit(Fichier fichier) {
		afficher();
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#visit(Repertoire)
	 */
	@Override
	public void visit(Repertoire repertoire) {
		afficher();
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#beforeVisit(ComposantSysteme)
	 */
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

	/**
	 * @see pattern.exo3.visiteur.Visiteur#afterVisit(ComposantSysteme)
	 */
	@Override
	public void beforeVisit(ComposantSysteme composantSysteme) {
		rep.add(composantSysteme.getNom());
	}

	@Override
	public void afterVisit(ComposantSysteme composantSysteme) {
		rep.remove(composantSysteme.getNom());
	}

}
