package pattern.exo3.visiteur;

import java.util.ArrayList;
import java.util.List;

import pattern.exo3.composite.ComposantSysteme;
import pattern.exo3.composite.Fichier;
import pattern.exo3.composite.Repertoire;

/**
 * Classe ne collectant que les fichier d'un ComposantSystème.
 * Cette classe est un Visiteur.
 * @author Imbert / Jarrige
 *
 */
public class FichierVisiteur implements Visiteur {
	
	List<Fichier> fichiers;
	
	/**
	 * Constructeur par défaut.
	 */
	public FichierVisiteur() {
		this.fichiers = new ArrayList<Fichier>();
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#visit(Fichier)
	 */
	@Override
	public void visit(Fichier fichier) {
		fichiers.add(fichier);
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#visit(Repertoire)
	 */
	@Override
	public void visit(Repertoire repertoire) {
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#beforeVisit(ComposantSysteme)
	 */
	@Override
	public void beforeVisit(ComposantSysteme composantSysteme) {
	}

	/**
	 * @see pattern.exo3.visiteur.Visiteur#afterVisit(ComposantSysteme)
	 */
	@Override
	public void afterVisit(ComposantSysteme composantSysteme) {
	}
	
	/**
	 * Retourne la liste des fichiers visités.
	 * @return la liste des fichiers visités.
	 */
	public List<Fichier> getListFichier(){
		return fichiers;
	}

}
