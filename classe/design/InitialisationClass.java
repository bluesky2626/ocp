package ocp.classe.design;

// Class Initialization

// Rule 1: une class est initialis�e une fois au plus 
// Rule 2: Si une class a une m�re on initialise d'abord la m�re 
// Rule 3: Initialiser une class : executer les declaration de variable de class (static) dans l'ordre de leur apparition
//						  Ensuite  executer les blocs static dans l'ordre de leur apparition 

class Animall{
	static {
		System.out.println("A");
	}
}

class Hippo extends Animall{
	static {
		System.out.println("B");
	}
	
    public static void main(String[] args) {
		System.out.println("C");
		new Hippo();
	}
}

// ABC
// main est dans Hippo => on initialise Hippo
// on commence par initialiser sa m�re Animall =>  "A"
// ensuite initialiser Hippo  =>  "B"
// ensuite main() affiche => C
// new Hippo();  // RIEN ,cette classe est d�ja initialis�e



class InitialisationClass {
	public static void main(String[] args) {
		System.out.println("C");
		new Hippo();
	}
}

//CAB
// main est dans InitialisationClass => on initialise InitialisationClass => Rien
// print "C"
// initialiser Hippo => avant �a initialiser Animall => "A"
// initialiser Hippo => "B"