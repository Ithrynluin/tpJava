package pattern.exo2.observateur;

/**
 * Cette classe génére des statistique météorologique.
 * Cette classe est un observateur.
 * @author Imbert / Jarrige
 *
 */
public class Statistique implements Observateur {

	private double min;
	private double max;
	private double moyenne;
	
	/**
	 * Constructeur par défaut
	 */
	public Statistique() {
		this.max = 0;
		this.min = 0;
		this.moyenne = 0;
	}
	
	/**
	 * @see Observateur#modifier(Donnee)
	 */
	@Override
	public void modifier(Donnee donnee) {
		if(this.min > donnee.getTemperature()){
			this.min = donnee.getTemperature();
		}
		if(this.max < donnee.getTemperature()){
			this.max = donnee.getTemperature();
		}
		
		if(this.moyenne != 0){
			this.moyenne = (this.moyenne + donnee.getTemperature()) / 2;
		}else{
			this.moyenne = donnee.getTemperature();
		}
		
		System.out.println("Min = " + this.min + " Max = " + this.max + " Cumul = " + this.moyenne);
	}

	/**
	 * Retourne la température minimum.
	 * @return la température minimum
	 */
	public double getMinTemperature() {
		return min;
	}

	/**
	 * Modifie la température minimum.
	 * @param min
	 * 		la nouvelle température minimum
	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * Retourne la température maximum.
	 * @return la température maximun
	 */
	public double getMaxTemperatue() {
		return max;
	}

	/**
	 * Modifie la température maximum.
	 * @param max
	 * 		la nouvelle température maximum
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * Retourne la température moyenne.
	 * @return la température moyenne
	 */
	public double getCumulTemperature() {
		return moyenne;
	}

	/**
	 * Modifie la température moyenne.
	 * @param moyenne
	 * 		la nouvelle température moyenne
	 */
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

}
