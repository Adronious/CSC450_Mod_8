/*
 * Class ThreadCounter counts up from 1 to 20 and
 * has main method to run both threads and second class
 */
public class ThreadCounter implements Runnable {
	//First Thread and name of Thread variables
	private Thread t1;
	private String threadName;	
	//Constructor for First Thread passes the name of the thread
	ThreadCounter(String name) {
		threadName = name;
		System.out.println("Creating " + name);
	}
	//Actual counting method uses basic for-loop with unique counter
	private void countUp() {

		for (int i = 1; i < 21; i++) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
	}
	//Run method starts program with states of process printed to console
	@Override
	public void run() {
		
		System.out.println("Running " + threadName);
		//Try catch block to catch interrupted exception while 
		//threads are sleeping
		try {
			countUp();
			Thread.sleep(50);
		}
		catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println(threadName + " exiting.");
	}
	//Start running program with states of progress printed to console
	public void start() {
		
		System.out.println("Starting " + threadName);
		//If statement to instantiate new thread with constructor
		//if one does not already exist. Then start program
		if (t1 == null) {
			t1 = new Thread(this, threadName);
			t1.start();
		}
	}
	//Main method to run each thread and instantiate them by passing their respective names
	public static void main(String[] args) {
		
		ThreadCounter T1 = new ThreadCounter("First Thread");
		T1.start();
		
		ThreadCounter2 T2 = new ThreadCounter2("Second Thread");
		T2.start();
	}
}
