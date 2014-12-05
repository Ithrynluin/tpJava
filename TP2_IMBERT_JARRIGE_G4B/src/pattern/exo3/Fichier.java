package pattern.exo3;

public class Fichier extends ComposantSysteme {
	
	private final String nom;
	private final int taille;
	
	public Fichier(String nom, int taille) {
		this.nom = nom;
		this.taille = taille;
	}

	/**
	 * @return the nom
	 */
	@Override
	public String getNom() {
		return nom;
	}

	/**
	 * @return the taille
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
	
	

}
