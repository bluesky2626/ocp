package ocp.ch7.methods.encapsulation;
import static java.util.Arrays.*;     // DOES NOT COMPILE


// Rule 1: une variable static ne peut etre qu'une variable d'instance (elle ne peut pas etre locale)
//         variable de class = variable d'unstance static
public class Static {

	private final static int x;
	private int y;
	static {
		x = 2;
		System.out.println("Static initializer");
	}
	
	{
		y = 2;
		System.out.println("Instance initialize");

	}
	
	public static void main(String[] args) {
		
		Koala koala = new Koala();
		koala.count = 2;
		System.out.println(koala.count); // 2
		koala = null;
		System.out.println(koala.count); // 2 et pas un NullPointerException comme on s'y attendait
		// Java comprends koala.count => Koala.count
		
		// Rule 2 :
		// Quand on a modifié variable de class d'une instance  
		// on a modifié cette variable pour toutes les instances de cette class
	}
}

class Koala {
	static int count;
}