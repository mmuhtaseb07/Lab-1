package lab5;

import java.util.ArrayList;
import java.util.Random;

public class CarQueue {
	
	private ArrayList<Integer> queue;
	public Random random;
	
	public CarQueue() {
		queue = new ArrayList<>();
		random = new Random();
		
		for(int i = 0; i < 5; i++) {
			queue.add(random.nextInt(4));
		}
	}
	
	public void addToQueue() {
		class MyRunnable implements Runnable{

			@Override
			public void run() {
				
				try {
					while(true) {
						queue.add(random.nextInt(4));
						Thread.sleep(1000);
					}
				}
				catch(InterruptedException e){}
			}
			
		}
		
		MyRunnable r = new MyRunnable();
		Thread thread = new Thread(r);
		thread.start();
	}
	
	public int deleteQueue() {
		if(queue.size() > 0) {
			int num = queue.get(0);
			queue.remove(0);
			return num;
		}
		else {
			return -1;

		}
	}
}
