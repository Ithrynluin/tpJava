package pattern.exo2.observateur;

public class Meteo implements Observateur {

	/**
	 * @see Observateur#modifier(Donnee)
	 */
	@Override
	public void modifier(Donnee donnee) {
		System.out.println(donnee);
	}

}
