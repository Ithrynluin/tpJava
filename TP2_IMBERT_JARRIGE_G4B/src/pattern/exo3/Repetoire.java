package pattern.exo3;

import java.util.ArrayList;
import java.util.List;

public class Repetoire extends ComposantSysteme {

	private final String nom;
	private final List<ComposantSysteme> listComposantSystemes;

	/**
	 * @param nom
	 * @param listComposantSystemes
	 */
	public Repetoire(String nom) {
		this.nom = nom;
		this.listComposantSystemes = new ArrayList<ComposantSysteme>();
	}

	/**
	 * @return the nom
	 */
	@Override
	public String getNom() {
		return nom;
	}
	
	@Override
	public int getTaille(){
		int taille = 0;
		
		for(ComposantSysteme comp : listComposantSystemes){
			taille += comp.getTaille();
		}
		return taille;
	}
	
	@Override
	public void addComposantSysteme(ComposantSysteme composant) {
		if(composant == null){
			throw new NullPointerException("Le composant ne doit pas être null");
		}
		
		listComposantSystemes.add(composant);
	}
	
	@Override
	public void removecomposantSysteme(ComposantSysteme composant) {
		if(composant == null){
			throw new NullPointerException("Le composant ne doit pas être null");
		}
		listComposantSystemes.remove(composant);
	}
	
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
	
	
	
}
