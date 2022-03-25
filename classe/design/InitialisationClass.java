package ocp.classe.design;

// Class Initialization

// Rule 1: une class est initialisée une fois au plus 
// Rule 2: Si une class a une mère on initialise d'abord la mère 
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
// on commence par initialiser sa mère Animall =>  "A"
// ensuite initialiser Hippo  =>  "B"
// ensuite main() affiche => C
// new Hippo();  // RIEN ,cette classe est déja initialisée



class InitialisationClass {
	public static void main(String[] args) {
		System.out.println("C");
		new Hippo();
	}
}

//CAB
// main est dans InitialisationClass => on initialise InitialisationClass => Rien
// print "C"
// initialiser Hippo => avant ça initialiser Animall => "A"
// initialiser Hippo => "B"