package fr.unilim.info;

/**
 * Classe représentant un animal
 * @author Imbert / Jarrige
 *
 */
public class Animal {
	private String espece;
	private boolean carnivore;
	private double poids;
	
	/**
	 * Constructeur par défaut
	 * @param espece
	 * 			le nom de l'espèce de l'animal
	 * @param carnivore
	 * 			true = carnivore
	 * 			false = herbivore
	 * @param poids
	 * 			le poids de l'animal en kg
	 */
	public Animal(String espece, boolean carnivore, double poids) {
		this.espece = espece;
		this.carnivore = carnivore;
		this.poids = poids;
	}
	
	/**
	 * Méthode permettant de connaitre la quantite de viande nécessaire pour nourrir
	 * l'animal
	 * (en kg)
	 * @return poids de viande
	 */
	public double calculerViandeHebdo() {
		double poidsViande = 0;
		
		if(this.carnivore) {
			poidsViande = this.poids/4;
		}
		return poidsViande;
	}

	/**
	 * Retourne le nom de l'espèce de l'animal
	 * @return le nom de l'espèce
	 */
	public String getEspece() {
		return espece;
	}

	/**
	 * Modifie le nom de l'espèce
	 * @param espece
	 * 			le nouveau nom de l'espèce
	 */
	public void setEspece(String espece) {
		this.espece = espece;
	}

	/**
	 * Indique si l'animal est un carnivore ou un herbivore
	 * @return true si l'animal est un carnivore, false si c'est un herbivore
	 */
	public boolean isCarnivore() {
		return carnivore;
	}

	/**
	 * Modifie le type d'alimentation de l'animal
	 * @param carnivore
	 * 				true = carnivore
	 * 				false = herbivore
	 */
	public void setCarnivore(boolean carnivore) {
		this.carnivore = carnivore;
	}

	/**
	 * Retourne le poids de l'animal en kg
	 * @return le poids de l'animal en kg
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * Modifie le poids de l'animal
	 * @param poids
	 * 			le nouveau poids de l'animal en kg
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}

	/**
	 * @see java.lang.Object#equals()
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (carnivore != other.carnivore)
			return false;
		if (espece == null) {
			if (other.espece != null)
				return false;
		} else if (!espece.equals(other.espece))
			return false;
		if (Double.doubleToLongBits(poids) != Double
				.doubleToLongBits(other.poids))
			return false;
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "espece=[" + espece + "], carnivore=[" + carnivore
				+ "], poids=[" + poids + "]";
	}
}
