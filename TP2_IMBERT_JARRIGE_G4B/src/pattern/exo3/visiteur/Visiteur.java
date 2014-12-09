package pattern.exo3.visiteur;

import pattern.exo3.composite.ComposantSysteme;
import pattern.exo3.composite.Fichier;
import pattern.exo3.composite.Repertoire;

public interface Visiteur {

	public void visit(Fichier fichier);
	
	
	public void visit(Repertoire repertoire);
	
	public void beforeVisit(ComposantSysteme composantSysteme);
	
	public void afterVisit(ComposantSysteme composantSysteme);
}
