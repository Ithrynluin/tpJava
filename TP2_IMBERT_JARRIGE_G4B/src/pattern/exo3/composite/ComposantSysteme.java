package pattern.exo3.composite;

import pattern.exo3.visiteur.Visiteur;

/**
 * Classe abstraite représentant un composant du système
 * @author Imbert / Jarrige
 *
 */
public abstract class ComposantSysteme {
	
	/**
	 * Retourne le nom du composant
	 * @return nom du composant
	 */
	public String getNom(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Retourne la taille du composant
	 * @return taille du composant
	 */
	public int getTaille(){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Méthode permettant d'ajouter un composants dans un autre composant
	 * (ici il s'agira surtout de mettre des fichiers dans un répertoire)
	 * @param composant
	 * 				le composant à ajouter
	 */
	public void addComposantSysteme(ComposantSysteme composant){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Méthode permettant d'enlever un composant d'un autre composant
	 * (ici il s'agira surtout de supprimer un fichier d'un répertoire)
	 * @param composant
	 * 				le composant à enlever
	 */
	public void removeComposantSysteme(ComposantSysteme composant){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Méthode renvoyant le composant à un index donné d'une liste de composant
	 * @param index
	 * 			le numéro où se situe le composant dans la liste
	 * @return le composant situé à l'adresse indiqué en paramètre
	 */
	public ComposantSysteme getComposantSysteme(int index){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Méthode permettant à un composant d'accepter un visiteur
	 * @param visiteur
	 * 				le visiteur accepté par le composant
	 */
	public void acceptVisiteur(Visiteur visiteur){
		throw new UnsupportedOperationException();
	}
}
