package thread.exo5;

public class Compteur {
	
	private long l;
	
	public Compteur(){
		this.l = 0;
	}
	
	public long getL(){
		return this.l;
	}
	
	public void next(){
		this.l++;
	}
}
