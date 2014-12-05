package pattern.exo2.observateur;

public interface Sujet {
	public void ajouterObservateur(Observateur observateur);
	public void retirerObservateur(Observateur observateur);
	public void notifierObservateurs();
}
