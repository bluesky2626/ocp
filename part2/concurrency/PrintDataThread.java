package ocp.part2.concurrency;

public class PrintDataThread extends Thread {

	
	@Override
	public void run() {
		System.out.println("Do some work - PrintDataThread");
	}

	public static void main(String[] args) {
		Thread th = new PrintDataThread();
		th.start();
	}

}
