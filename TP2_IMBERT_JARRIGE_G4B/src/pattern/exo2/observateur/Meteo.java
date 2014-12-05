package pattern.exo2.observateur;

public class Meteo implements Observateur {

	@Override
	public void modifier(Donnee donnee) {
		System.out.println(donnee);
	}

}
