package pattern.exo1.adaptateur;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe adapte une instance de la classe java.util.List
 * @author imbert / jarrige
 *
 */
public class FileImpl<E> implements File<E>{

	private final List<E> list;
	
	/**
	 * Constructeur par défaut.
	 */
	public FileImpl(){
		this.list = new ArrayList<E>();
	}
	
	/**
	 * @see exo1.adaptateur.File#tete()
	 */
	@Override
	public E tete() {
		if(this.estVide()){
			throw new IllegalStateException("La file est vide");
		}
		return this.list.get(0);
	}

	/**
	 * @see exo1.adaptateur.File#insereQueue(E e)
	 */
	@Override
	public void insererQueue(E e) {
		this.list.add(e);
	}
	
	/**
	 * @see exo1.adaptateur.File#retirerTete()
	 */
	@Override
	public void retirerTete() {
		if(this.estVide()){
			throw new IllegalStateException("La file est vide");
		}
		this.list.remove(0);
	}

	/**
	 * @see exo1.adaptateur.File#longueur()
	 */
	@Override
	public int longueur() {
		return this.list.size();
	}

	/**
	 * @see exo1.adaptateur.File#estVide()
	 */
	@Override
	public boolean estVide() {
		return this.list.isEmpty();
	}
	
	
}
