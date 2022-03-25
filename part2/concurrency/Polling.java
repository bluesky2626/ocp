package ocp.part2.concurrency;

public class Polling {

	private static long counter = 0;
	
	// Polling est le processus de v�rification intermittente des donn�es � un intervalle fixe.
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(() -> {
			for(int i = 0; i < 500; i++) Polling.counter++;
		}).start();
		
		
		while(Polling.counter < 100) {
			System.out.println("Not reached yet");
			 Thread.sleep(1000);
		}
		
		System.out.println("Reached!");
	}

	// Le nombre d'iteration u while est impr�visible
}
