package fr.unilim.info.fixture;

import java.util.ArrayList;
import fr.unilim.info.Animal;

/**
 * Classe qui créer une liste de 7 animaux
 * @author Imbert / Jarrige
 *
 */
public class AnimalFixture {
	/**
	 * Méthode qui crée la liste de 7 animaux
	 * @return liste de 7 animaux
	 */
	public static ArrayList<Animal> creerListeAnimaux() {
		ArrayList<Animal> liste7Animaux = new ArrayList<Animal>();
		Animal lion = new Animal("Lion", true, 248.2);
		Animal tigre = new Animal("Tigre", true, 265.3);
		Animal requin = new Animal("Requin", true, 402.7);
		Animal panda = new Animal("Panda", false, 96.3);
		Animal bison = new Animal("Bison", false, 698.1);
		Animal serpent = new Animal("Serpent", true, 15.8);
		Animal kangourou = new Animal("Kangourou", false, 425.4);
		
		liste7Animaux.add(lion);
		liste7Animaux.add(tigre);
		liste7Animaux.add(requin);
		liste7Animaux.add(panda);
		liste7Animaux.add(panda);
		liste7Animaux.add(bison);
		liste7Animaux.add(serpent);
		liste7Animaux.add(kangourou);
		
		return liste7Animaux;
	}
}
