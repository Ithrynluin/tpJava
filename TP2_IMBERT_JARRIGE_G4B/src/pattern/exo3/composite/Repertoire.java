package pattern.exo3.composite;

import java.util.ArrayList;
import java.util.List;

import pattern.exo3.visiteur.Visiteur;

/**
 * Classe fille de la classe ComposantSysteme, représentant un répertoire
 * @author Imbert / Jarrige
 *
 */
public class Repertoire extends ComposantSysteme {

	private final String nom;
	private final List<ComposantSysteme> listComposantSystemes;

	/**
	 * Constructeur par défaut
	 * @param nom
	 * 			le nom du répertoire
	 * @param listComposantSystemes
	 * 			l'ensemble des composants que contient le répertoire
	 */
	public Repertoire(String nom) {
		this.nom = nom;
		this.listComposantSystemes = new ArrayList<ComposantSysteme>();
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
	public int getTaille(){
		int taille = 0;
		
		for(ComposantSysteme comp : listComposantSystemes){
			taille += comp.getTaille();
		}
		return taille;
	}
	
	/**
	 * @see exo3.composite.ComposantSysteme#addComposantSysteme(ComposantSysteme composant)
	 */
	@Override
	public void addComposantSysteme(ComposantSysteme composant) {
		if(composant == null){
			throw new NullPointerException("Le composant ne doit pas être null");
		}
		
		listComposantSystemes.add(composant);
	}
	
	/**
	 * @see exo3.composite.ComposantSysteme#removeComposantSysteme(ComposantSysteme composant)
	 */
	@Override
	public void removeComposantSysteme(ComposantSysteme composant) {
		if(composant == null){
			throw new NullPointerException("Le composant ne doit pas être null");
		}
		listComposantSystemes.remove(composant);
	}
	
	/**
	 * @see exo3.composite.ComposantSysteme#getComposantSysteme(int index)
	 */
	@Override
	public ComposantSysteme getComposantSysteme(int index){
		return listComposantSystemes.get(index);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Repetoire [nom=");
		builder.append(nom);
		builder.append(", listComposantSystemes=");
		builder.append(listComposantSystemes);
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
		for (ComposantSysteme composantSysteme : listComposantSystemes) {
			composantSysteme.acceptVisiteur(visiteur);
		}
		visiteur.afterVisit(this);
	}
	
}
