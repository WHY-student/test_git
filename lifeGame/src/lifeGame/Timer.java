package lifeGame;

import java.util.concurrent.TimeUnit;

public class Timer extends Thread {
		public boolean stop = false;
		private int duration = 5;
	    @Override
	    public void run() {
	        while (!stop) {
	            Logic.nextWorld();
	            
	            try {
	                TimeUnit.SECONDS.sleep(duration);
	            } catch (InterruptedException ex) {
	                ex.printStackTrace();
	            }
	        }

	    }

}
