package game;

public class nap extends Thread {
	public void run() {
		try {
			Thread.sleep(2000);
			System.exit(0);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}