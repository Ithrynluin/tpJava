package pattern.exo3.composite;

import pattern.exo3.visiteur.Visiteur;

public abstract class ComposantSysteme {
	
	public String getNom(){
		throw new UnsupportedOperationException();
	}
	
	public int getTaille(){
		throw new UnsupportedOperationException();
	}
	
	public void addComposantSysteme(ComposantSysteme composant){
		throw new UnsupportedOperationException();
	}
	
	public void removecomposantSysteme(ComposantSysteme composant){
		throw new UnsupportedOperationException();
	}
	
	public ComposantSysteme getComposantSysteme(int index){
		throw new UnsupportedOperationException();
	}
	
	public void acceptVisiteur(Visiteur visiteur){
		throw new UnsupportedOperationException();
	}
}
