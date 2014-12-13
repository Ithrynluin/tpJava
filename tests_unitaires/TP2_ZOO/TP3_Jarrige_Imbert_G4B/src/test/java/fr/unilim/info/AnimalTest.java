package fr.unilim.info;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Classe permettant de tester les méthodes de la classe Animal
 * @author Imbert / Jarrige
 *
 */
public class AnimalTest {
	/**
	 * Méthode permettant de tester la méthode toString de la classe Animal
	 */
	@Test
	public void testAnimalToString() {
		Animal lion = new Animal("Lion", true, 217.5);
		String retourToString = "espece=[Lion], carnivore=[true], poids=[217.5]";
		
		assertEquals(lion.toString(), retourToString);
	}
	
	/**
	 * Méthode permettant de tester la méthode equals de la classe Animal
	 * elle teste les cas où :
	 * 			une classe est identique à une autre (renvoie true)
	 * 			une classe utilise equals sur elle-même
	 */
	@Test
	public void testAnimalEqualsTrue() {
		Animal lion1 = new Animal("Lion", true, 217.5);
		Animal lion2 = new Animal("Lion", true, 217.5);
		
		assertEquals(lion1, lion2);
		assertTrue(lion1.equals(lion2));
		assertTrue(lion1.equals(lion1));
	}
	
	/**
	 * Méthode permettant de tester la méthode equals de la classe Aniaml
	 * elle teste les cas où :
	 * 				seule la variable espece change
	 * 				seule la variable carnivore change
	 * 				seule la variable poids change
	 */
	@Test
	public void testAnimalEqualsFalse() {
		Animal lion = new Animal("Lion", true, 217.5);
		Animal tigre = new Animal("Tigre", true, 217.5);
		Animal lionHerbivore = new Animal("Lion", false, 217.5);
		Animal lion300kg = new Animal("Lion", true, 300.0);
		
		assertFalse(lion.equals(tigre));
		assertFalse(lion.equals(lionHerbivore));
		assertFalse(lion.equals(lion300kg));
	}
	
	/**
	 * Méthode permettant de tester la méthode equals de la classe Animal
	 * elle teste le cas où l'un des objets comparés est null
	 */
	@Test
	public void testAnimalEqualsFalseQuandNull() {
		Animal lion = new Animal("Lion", true, 217.5);
		
		assertFalse(lion.equals(null));
	}
	
	/**
	 * Méthode permettant de tester la méthode equals de la classe Animal
	 * elle teste le cas où eule la variable espece change et, dans l'un des objets,
	 * cette variable est nulle
	 */
	@Test
	public void testAnimalEqualsFalseQuandEspeceNull() {
		Animal lion = new Animal("Lion", true, 217.5);
		Animal animalNull = new Animal(null, true, 217.5);
		
		assertFalse(animalNull.equals(lion));
	}
	
	/**
	 * Méthode permettant de tester la méthode equals de la classe Animal
	 * elle teste le cas où la comparaison se fait entre un objet de classe Animal
	 * et un objet d'une autre classe
	 */
	@Test
	public void testAnimalEqualsFalseQuandClasseDifferente() {
		Animal lion = new Animal("Lion", true, 217.5);
		String str = "Lion";
		int entier = 2;
		ArrayList<Animal> liste = new ArrayList<Animal>();
		
		assertFalse(lion.equals(str));
		assertFalse(lion.equals(entier));
		assertFalse(lion.equals(liste));
	}
}
