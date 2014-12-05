package pattern.exo2.observateur;

public class Statistique implements Observateur {

	private double min;
	private double max;
	private double moyenne;
	
	public Statistique() {
		this.max = 0;
		this.min = 0;
		this.moyenne = 0;
	}
	
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
	 * @return the min
	 */
	public double getMinTemperature() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public double getMaxTemperatue() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * @return the moyenne
	 */
	public double getCumulTemperature() {
		return moyenne;
	}

	/**
	 * @param moyenne the moyenne to set
	 */
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

}
