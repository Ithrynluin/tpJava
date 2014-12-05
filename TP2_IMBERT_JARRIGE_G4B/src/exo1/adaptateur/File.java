package exo1.adaptateur;

/**
 * Interface qui reprrésente une File
 * @author Imbert / Jarrige
 *
 * @param <E>
 * 		Le type générique de l'élément qui compose la File
 */
public interface File<E> {
	
	/**
	 * Retourne l'élément de tête de la File.
	 * @return élément de tête de la File.
	 */
	E tete();
	
	/**
	 * Insère un élément en queue de File.
	 * @param e
	 * 		L'élément à iinsérer
	 */
	void insererQueue(E e);
	
	/**
	 * Retire l'élément de tête de File.
	 */
	void retirerTete();
	
	/**
	 * Retourne la longueur de la File
	 * @return longueur de la File
	 */
	int longueur();
	
	/**
	 * Retourne vrai si la File est vide, sinon faux.
	 * @return vrai si la File est vide, sinon faux.
	 */
	boolean estVide();
	
}
