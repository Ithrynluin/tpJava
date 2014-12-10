package pattern.exo3.composite;

import pattern.exo3.visiteur.FichierVisiteur;
import pattern.exo3.visiteur.GlobalNameVisiteur;
import pattern.exo3.visiteur.HierarchiqueVisiteur;


public class TestComposite {

	public static void main(String[] args) {
		Repertoire racine = new Repertoire("C:");
		Repertoire windows = new Repertoire("Windows");
		Repertoire system32 = new Repertoire("System32");
		system32.addComposantSysteme(new Fichier("adsnt.dll", 12030));
		system32.addComposantSysteme(new Fichier("advnt.dll", 43220));
		windows.addComposantSysteme(system32);
		windows.addComposantSysteme(new Repertoire("win.ini"));
		racine.addComposantSysteme(windows);
		Repertoire temp = new Repertoire("temp");
		temp.addComposantSysteme(new Fichier("test.data", 500));
		racine.addComposantSysteme(temp);
		
		System.out.println(racine);
		
		racine.acceptVisiteur(new HierarchiqueVisiteur());
		System.out.println();
		racine.acceptVisiteur(new GlobalNameVisiteur());
		System.out.println();
		FichierVisiteur visitFichier = new FichierVisiteur();
		racine.acceptVisiteur(visitFichier);
		for (Fichier fichier : visitFichier.getListFichier()) {
			System.out.println(fichier.getNom());
		}
	}

	//Pour implémenter la méthode getTaille de Repertoire, on additionne toutes 
	// les taille retourné par la méthode getTaille de chacun des Composant.
	
	/*
	 * On obtient à l'affichage quelque chose d'illisible.
	 */
	
	/*
	 * Pour propager le visiteur:
	 * 	
	 */
	
	
}
