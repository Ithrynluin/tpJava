package thread.exo1.heritage;

public class TestWhoIsThread {
	/**
	* @param args
	* @throws InterruptedException
	*/
	public static void main(String[] args) throws InterruptedException{
		System.out.println(Thread.currentThread());
		
		final WhoIsThread threadA = new WhoIsThread();
		final WhoIsThread threadB = new WhoIsThread();
		
		threadA.start();
		threadB. start();
	}

}
