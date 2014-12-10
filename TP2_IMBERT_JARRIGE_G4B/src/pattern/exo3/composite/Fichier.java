package pattern.exo3.composite;

import pattern.exo3.visiteur.Visiteur;

/**
 * Classe fille de la classe ComposantSysteme, représentant un fichier
 * @author Imbert / Jarrige
 *
 */
public class Fichier extends ComposantSysteme {
	
	private final String nom;
	private final int taille;
	
	/**
	 * Constructeur par défaut
	 * @param nom
	 * 			le nom du fichier
	 * @param taille
	 * 			la taille du fichier
	 */
	public Fichier(String nom, int taille) {
		this.nom = nom;
		this.taille = taille;
	}

	/**
	 * @see exo3.composite.ComposantSysteme#getNom()
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * @see exo3.composite.ComposantSysteme#getTaille()
	 */
	@Override
	public int getTaille() {
		return taille;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fichier [nom=");
		builder.append(nom);
		builder.append(", taille=");
		builder.append(taille);
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * @see exo3.composite.ComposantSysteme#acceptVisiteur
	 */
	@Override
	public void acceptVisiteur(Visiteur visiteur) {
		visiteur.beforeVisit(this);
		visiteur.visit(this);
		visiteur.afterVisit(this);
	}
}
