package ocp.part2.concurrency;

public class TestOrder {
	public static void main(String[] args) {
		System.out.println("Begin");
		(new Thread(new PrintData())).start();
		(new PrintDataThread()).start();
		(new Thread(new PrintData())).start();
		System.out.println("End");

		// L'ordre d'affichage est al�atoire, connu seulement � l'execution
		// on a ici 4 threads (3 + main)
		// execut�s de mani�re Asynchrone : main n'attend pas l'execution du premier thread pour executer le suivant
		
		
		System.out.println("Begin");
		(new Thread(new PrintData())).run();
		(new PrintDataThread()).run();
		(new Thread(new PrintData())).run();
		System.out.println("End");
		
		// Ici les thread ne sont pas cr��s et l'ordre l'execution est toujours le meme
		
		
		// N.B. Generalement, on pr�f�re implementer Runnable � extends Thread sauf en cas de circonstances pr�cises
   	
	
	}
}
