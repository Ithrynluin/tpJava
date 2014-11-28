package thread.exo1.realisation;

public class TestWhoIsThread {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		
		final Thread threadA = new Thread(new WhoIsThread());
		final Thread threadB = new Thread(new WhoIsThread());
		
		threadA.start();
		threadB.start();
	}

}
