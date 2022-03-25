package ocp.part2.concurrency;

public class TestOrder {
	public static void main(String[] args) {
		System.out.println("Begin");
		(new Thread(new PrintData())).start();
		(new PrintDataThread()).start();
		(new Thread(new PrintData())).start();
		System.out.println("End");

		// L'ordre d'affichage est aléatoire, connu seulement à l'execution
		// on a ici 4 threads (3 + main)
		// executés de manière Asynchrone : main n'attend pas l'execution du premier thread pour executer le suivant
		
		
		System.out.println("Begin");
		(new Thread(new PrintData())).run();
		(new PrintDataThread()).run();
		(new Thread(new PrintData())).run();
		System.out.println("End");
		
		// Ici les thread ne sont pas créés et l'ordre l'execution est toujours le meme
		
		
		// N.B. Generalement, on préfère implementer Runnable à extends Thread sauf en cas de circonstances précises
   	
	
	}
}
