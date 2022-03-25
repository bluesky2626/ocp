package ocp.exceptions;

// Are unchecked exceptions thrown by JVM
public class ErrorExceptions {

	// ExceptionInInitializerError
	// si l'initializer static throw une exception alors Java ne peut pas loader (initialiser) la class
	static {
		   int[] countsOfMoose = new int[3];
		//   int num = countsOfMoose[-1]; //ArrayIndexOutOfBoundsException
		}
	
	// StackOverflowError
	// infinite recursion
	// Quand java calls cette methode elle stocke le paramere num et les variables locales dans la stack
	// Since the method calls itself, it will never end storing in stack qui se retrouve full.
	// c'est toujours mieux qu'une boucle infinie qui fini par utiliser tout le cpu jusqu'a ce qu'on tue le programme
	public static void doNotCodeThis(int num) {
		   doNotCodeThis(1);
		}
	
	
	//NoClassDefFoundError
	
	public static void main(String[] args) {
		doNotCodeThis(2);
	}
}
