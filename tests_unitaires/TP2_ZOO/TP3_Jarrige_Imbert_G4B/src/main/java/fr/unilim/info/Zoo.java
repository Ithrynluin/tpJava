package fr.unilim.info;

import java.util.ArrayList;

/**
 * Classe permettant la création d'une liste d'animaux ainsi que sa gestion
 * @author Imbert / Jarrige
 *
 */
public class Zoo {
	private ArrayList<Animal> listeAnimaux;

	/**
	 * Constructeur par défaut
	 */
	public Zoo() {
		this.listeAnimaux = new ArrayList<Animal>();
	}
	
	/**
	 * Méthode permettant d'ajouter un animal à la liste
	 * @param animal
	 * 			l'animal à ajouter
	 */
	public void ajouterAnimal(Animal animal) {
		if(animal == null) {
			throw new IllegalArgumentException("Il n'y pas d'animal");
		}
		this.listeAnimaux.add(animal);
	}
	
	/**
	 * Méthode permettant d'enlever un animal à la liste
	 * @param animal
	 * 			l'animal à retirer
	 */
	public void retirerAnimal(Animal animal) {
		if(!listeAnimaux.contains(animal)) {
			throw new IllegalArgumentException("L'animal n'est pas dans le zoo");
		}
		this.listeAnimaux.remove(animal);
	}
	
	/**
	 * Méthode permettant de savoir si la liste de la classe est vide
	 * @return un booléen indiquant si la classe est vide
	 * 		true = vide
	 */
	public boolean estVide() {
		return this.listeAnimaux.isEmpty();
	}
	
	/**
	 * Méthode permettant de connaitre la quantite de viande nécessaire pour nourrir
	 * tous les animaux de la liste pendant une semaine
	 * (en kg)
	 * @return poids de viande
	 */
	public double calculerViandeHebdo() {
		double poidsViande = 0;
		
		for (Animal animal : this.listeAnimaux) {
			poidsViande += animal.calculerViandeHebdo();
		}
		
		return poidsViande;
	}
	
	/**
	 * Méthode permettant de voir les animaux qui ont besoin de soins
	 * @param soin
	 * 			le type de soin que l'on souhaite vérifier
	 * @return une liste des animaux à soigner
	 */
	public ArrayList<Animal> recupererAnimauxASoigner(SoinEnum soin) {
		ArrayList<Animal> listeAnimauxASoigner = new ArrayList<Animal>();
		
		for (Animal animal : this.listeAnimaux) {
			if(soin == SoinEnum.DENTS) {
				if(animal.isCarnivore()) {
					listeAnimauxASoigner.add(animal);
				}
			} else if(soin == SoinEnum.PIEDS) {
				if(animal.getPoids() >= 200) {
					listeAnimauxASoigner.add(animal);
				}
			} else {
				throw new IllegalArgumentException("Le paramètre entré n'est pas accepté par la méthode");
			}
		}
		
		return listeAnimauxASoigner;
	}

	/**
	 * Retourne la liste d'animaux de la classe
	 * @return la liste d'animaux de la classe
	 */
	public ArrayList<Animal> getListeAnimaux() {
		return listeAnimaux;
	}

	/**
	 * Remplace la liste actuelle par la liste insérée en paramètre
	 * @param listeAnimaux
	 * 				la nouvelle liste à mettre en place
	 */
	public void setListeAnimaux(ArrayList<Animal> listeAnimaux) {
		this.listeAnimaux = listeAnimaux;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "";
		
		for (Animal animal : this.listeAnimaux) {
			str += animal.toString()+"\n";
		}
		return str;
	}
}
