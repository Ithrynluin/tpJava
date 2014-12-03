package thread.exo2;

public class Demon extends Thread {
	
	public Demon(){
		this.setDaemon(true);
	}
	
	@Override
	public void run(){

		try{
			for(int i = 0; i < 20; i ++){
				Thread.sleep(200);
				System.out.println(Thread.currentThread().getName());
			}
		} catch(InterruptedException ie){
			ie.printStackTrace();
		} finally{
			System.out.println("Pas un démon");
		}
	}
}
