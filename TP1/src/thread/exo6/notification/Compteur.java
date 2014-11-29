package thread.exo6.notification;

public class Compteur {
	private long l;
	
	public Compteur(){
		this.l = 0;
	}
	
	public synchronized long getL(){
		return this.l;
	}
	
	public synchronized void next(){
		this.l++;
	}
}
