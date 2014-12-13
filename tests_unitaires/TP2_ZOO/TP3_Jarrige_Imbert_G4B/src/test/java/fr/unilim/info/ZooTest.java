package fr.unilim.info;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.unilim.info.fixture.AnimalFixture;

/**
 * Classe permettant de tester les méthodes de la classe Zoo
 * @author Imbert / Jarrige
 *
 */
public class ZooTest {
	private Zoo zoo;
	
	/**
	 * Méthode qui s'éxécute avant chaque méthode test
	 * Elle initialise une classe zoo et lui transfert une liste grâce à la
	 * classe AnimalFixture
	 */
	@Before
	public void setUp() {
		zoo = new Zoo();
		zoo.setListeAnimaux(AnimalFixture.creerListeAnimaux());
	}
	
	/**
	 * Méthode qui s'éxécute après chaque méthode test
	 * Elle désinitialise la variable zoo (créer dans la méthode setUp)
	 */
	@After
	public void tearDown() {
		zoo = null;
	}
	
	/**
	 * Méthode permettant de tester la méthode ajouterAnimal de la classe zoo
	 */
	@Test
	public void testAjouterAnimal() {
		Animal tortue = new Animal("Tortue", false, 352.4);
		ArrayList<Animal> listeAnimal = AnimalFixture.creerListeAnimaux();
		
		zoo.ajouterAnimal(tortue);
		listeAnimal.add(tortue);
		
		assertEquals(listeAnimal, zoo.getListeAnimaux());
	}
	
	/**
	 * Méthode permettant de tester la méthode ajouterAnimal de la classe Zoo
	 * Elle vérifie que cette méthode renvoie bien un IllegalArgumentException
	 * lorsque l'on essaye d'ajouter une variable nulle à la liste
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAjouterAnimalRenvoieErreur() {
		zoo.ajouterAnimal(null);
	}
	
	/**
	 * Méthode permettant de tester la méthode retirerAnimal de la classe Zoo
	 */
	@Test
	public void testRetirerAnimal() {
		Animal bison = new Animal("Bison", false, 698.1);
		ArrayList<Animal> listeAnimal = AnimalFixture.creerListeAnimaux();
		
		zoo.retirerAnimal(bison);
		listeAnimal.remove(bison);
		
		assertEquals(listeAnimal, zoo.getListeAnimaux());
	}
	
	/**
	 * Méthode permettant de tester la méthode retirerAnimal de la classe Zoo
	 * Elle vérifie que cette méthode renvoie bien un IllegalArgumentException
	 * lorsque l'on essaye de retirer une variable nulle à la liste
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRetirerAnimalRenvoieErreurAvecNull() {
		zoo.retirerAnimal(null);
	}
	
	/**
	 * Méthode permettant de tester la méthode retirerAnimal de la classe Zoo
	 * Elle vérifie que cette méthode renvoie bien un IllegalArgumentException
	 * lorsque l'on essaye de retirer un animal qui n'existe pas dans la liste
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRetirerAnimalRenvoieErreurAvecInexistant() {
		Animal tortue = new Animal("Tortue", false, 352.4);
		
		zoo.retirerAnimal(tortue);
	}
	
	/**
	 * Méthode permettant de tester la méthode estVide de la classe Zoo
	 */
	@Test
	public void testEstVide() {
		Zoo zooVide = new Zoo();
		
		assertTrue(zooVide.estVide());
		assertFalse(zoo.estVide());
	}
	
	/**
	 * Méthode permettant de tester la méthode calculerViandeHebdo de la classe Zoo
	 */
	@Test
	public void testCalculerViandeHebdo() {
		double poidsViande = 233;
		assertTrue(poidsViande == zoo.calculerViandeHebdo());
	}
	
	/**
	 * Méthode permettant de tester la méthode recupererAnimauxASoigner de la classe Zoo
	 * Elle teste si la méthode renvoie bien la liste correcte des animaux qui ont 
	 * besoin de soins dentaires
	 */
	@Test
	public void testRecupererAnimauxASoignerDents() {
		ArrayList<Animal> listeAnimauxASoigner = new ArrayList<Animal>();
		Animal lion = new Animal("Lion", true, 248.2);
		Animal tigre = new Animal("Tigre", true, 265.3);
		Animal requin = new Animal("Requin", true, 402.7);
		Animal serpent = new Animal("Serpent", true, 15.8);
		
		listeAnimauxASoigner.add(lion);
		listeAnimauxASoigner.add(tigre);
		listeAnimauxASoigner.add(requin);
		listeAnimauxASoigner.add(serpent);
		
		assertEquals(listeAnimauxASoigner, zoo.recupererAnimauxASoigner(SoinEnum.DENTS));
	}
	
	/**
	 * Méthode permettant de tester la méthode recupererAnimauxASoigner de la classe Zoo
	 * Elle teste si la méthode renvoie bien la liste correcte des animaux qui ont 
	 * besoin de soins aux pieds
	 */
	@Test
	public void testRecupererAnimauxASoignerPieds() {
		ArrayList<Animal> listeAnimauxASoigner = new ArrayList<Animal>();
		Animal lion = new Animal("Lion", true, 248.2);
		Animal tigre = new Animal("Tigre", true, 265.3);
		Animal requin = new Animal("Requin", true, 402.7);
		Animal kangourou = new Animal("Kangourou", false, 425.4);
		Animal bison = new Animal("Bison", false, 698.1);
		
		listeAnimauxASoigner.add(lion);
		listeAnimauxASoigner.add(tigre);
		listeAnimauxASoigner.add(requin);
		listeAnimauxASoigner.add(bison);
		listeAnimauxASoigner.add(kangourou);
		
		assertEquals(listeAnimauxASoigner, zoo.recupererAnimauxASoigner(SoinEnum.PIEDS));
	}
	/**
	 * Méthode permettant de tester la méthode recupererAnimauxASoigner de la classe Zoo
	 * Elle vérifie que cette méthode renvoie bien un IllegalArgumentException
	 * lorsque l'on met une variable nulle en paramètre
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecupererAnimauxASoignerNull() {
		zoo.recupererAnimauxASoigner(null);
	}
	
	/**
	 * Méthode permettant de tester la méthode toString de la classe Zoo
	 */
	@Test
	public void testToString() {
		String retourToString = "espece=[Lion], carnivore=[true], poids=[248.2]\n"
				+ "espece=[Tigre], carnivore=[true], poids=[265.3]\n"
				+ "espece=[Requin], carnivore=[true], poids=[402.7]\n"
				+ "espece=[Panda], carnivore=[false], poids=[96.3]\n"
				+ "espece=[Panda], carnivore=[false], poids=[96.3]\n"
				+ "espece=[Bison], carnivore=[false], poids=[698.1]\n"
				+ "espece=[Serpent], carnivore=[true], poids=[15.8]\n"
				+ "espece=[Kangourou], carnivore=[false], poids=[425.4]\n";
		
		assertEquals(retourToString, zoo.toString());
	}
}
