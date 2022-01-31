/*
 * Second class for ThreadCounter2 so that both Threads can run 
 * Simultaneously while each counts in a different direction
 */
public class ThreadCounter2 implements Runnable{
	//First Thread and name of Thread variables
	private Thread t2;
	private String threadName;
	//Constructor adds name to the new Thread
	ThreadCounter2(String name) {
		threadName = name;
	}
	//Actual method uses basic for-loop with unique counter
	private void countDown() {
	
		for (int j = 20; j > 0; j--) {
			System.out.print(j + " ");
		}
		System.out.println("\n");
	}
	//Run method starts program with states of process printed to console
	@Override
	public void run() {
		System.out.println("Running " + threadName);
		//Try catch block to catch interrupted exception while 
		//threads are sleeping for formatted display
		try {
			countDown();
			Thread.sleep(100);
		}
		catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println(threadName + " exiting.");
	}
	//Start running program with states of progress printed to console
	public void start() {
		System.out.println("Creating " + threadName);
		System.out.println("Starting " + threadName);
		//If statement to instantiate new thread with constructor
		//if one does not already exist. Then start program
		if (t2 == null) {
			t2 = new Thread(this, threadName);
			t2.start();
		}
	}
}
