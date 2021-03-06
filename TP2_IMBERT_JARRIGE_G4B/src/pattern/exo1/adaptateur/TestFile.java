package pattern.exo1.adaptateur;

/**
 * Classe de test des classes FileImpl et File
 * @author imbert / jarrige
 *
 */
public class TestFile {

	public static void main(String[] args) {
		File<Integer> file = new FileImpl<Integer>();
		
		file.insererQueue(Integer.valueOf(1));
		file.insererQueue(Integer.valueOf(2));
		
		file.retirerTete();
		
		System.out.println(file.tete());
	}
	
	/*
	 * Les classes qui jouent le rôle du client, de la cible, de l'adapteur et de l'adaptaté sont :
	 * Client = TestFile
	 * Cible = FileImpl
	 * Adaptateur = File
	 * Adaptaté = List
	 */
}
