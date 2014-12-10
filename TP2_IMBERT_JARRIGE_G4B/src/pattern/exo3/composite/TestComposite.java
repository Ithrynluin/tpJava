package pattern.exo3.composite;

import pattern.exo3.visiteur.FichierVisiteur;
import pattern.exo3.visiteur.GlobalNameVisiteur;
import pattern.exo3.visiteur.HierarchiqueVisiteur;

/**
 * Classe de test des classes ComposantSysteme, Repertoire, Fichier, FichierVisteur, 
 * GlobalNameVisiteur, HierarchiqueVisteur et Visiteur
 * @author imbert / jarrige
 *
 */
public class TestComposite {

	public static void main(String[] args) {
		//Création de l'arborescence
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
		
		//Affichage de l'arborescence.
		System.out.println(racine);
		
		//Test HierarchiqueVisiteur
		racine.acceptVisiteur(new HierarchiqueVisiteur());
		System.out.println();
		//Test GlobalNameVisteur
		racine.acceptVisiteur(new GlobalNameVisiteur());
		System.out.println();
		//Test FichierVisiteur
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
	 * On parcours la liste des composant système des Répertoires
	 * et on appelle leur fonction accepteVisiteur en leur passant le visiteur.
	 */
	
	/*
	 * La méthode beforeVisit permet de faire des actions avant de visiter un composant système:
	 * comme dans HierarchiqueVisiteur où l'on incrémente un compteur pour savoir à quelle
	 * profondeur on se trouve dans l'arborescence.
	 * 
	 * La méthode afterVisit permet d'effectuer des actions contraire à 
	 * la méthode before.
	 * Par exemple dans la classe HierarchiqueVisiteur on décrémente le compteur.
	 */
	
	
	
}
