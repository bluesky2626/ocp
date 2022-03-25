package ocp.classe.design;

// Rule 1: Si une class ne contient aucun constructor (meme pas un private)=> le constructor par defaut estt généré à la compilation
// N.B Si une class a déja un constructeur , le constructor par defaut n'est pas généré
// Généré à la compilation (existe dans le .class)
// le constructeur ne peut etre appelé que avec new

// Une class peut avoir plusieurs constructeurs : overloading


	
class MyConstrArePiv{
	private MyConstrArePiv() {
		
	}
	
	class Fille extends MyConstrArePiv {
		
	}
	
}

class Constructors {
	public static void main(String[] args) {
		
		// pk on utilise this() ????
		Hamster ham = new Hamster(20);
		// Les deux constructors sont appelés, on a créé 2 objets
		// new Hamster(int weight)
		// new Hamster(int weight, String color)
		// C'est pas cool 
		
		
		//Solution => this
		ThisHamster thisHam = new ThisHamster(30);
		
		
		// Rule 3: Est-ce quo'n peut instanier une classe avec que des constructeur private ??? Non
			// Une class qui n'a que des constructeurs private
			//MyConstrArePiv c = new MyConstrArePiv();	 // DO NOT COMPILE
			// Cela empeche : 
			// - la creation d'un constructor par defaut
			// - les autres classes d'instancier cette classe
		// Mais elle peut etre Mère si la class Fille est inner 
		
		//Fille fille = new Fille();
	}
}

class Hamster {
	private String color;
	private int weight;
	
	/* Ecrire ça provoque beaucoup de redondance 
	 * On essaie donc de remplacer son contenu par un appel à un constructeur deja existant
	 * 
	 * public Hamster(int weight) {
			this.weight = weight;
		    this.color = "brown";
	}
	 */
	
	public Hamster(int weight, String color) {  
		this.weight = weight;
		this.color = color;
	}
	
	public Hamster(int weight) {
		new Hamster(weight, "brown");
	}
}


class ThisHamster {
	private String color;
	private int weight;
	
	public ThisHamster(int weight, String color) {  
		this.weight = weight;
		this.color = color;
	}
	
	public ThisHamster(int weight) {
		// Rule 2: this() et super() doit etre la première ligne du code du constuctor 
		this(weight, "brown"); // ===  new ThisHamster(int weight, String color)
		System.out.println("this");
	}
	
	// Trick 1	
	/* DO NOT COMPILE
	 * Constructeur s'appelle lui meme à l'infini
	 * 
	 * public ThisHamster(int weight) {
	 *   this(weight); 
	 * }
	*/
	
	//Trick 2
    /*
     * Constructors s'appelent mutuellement à l'infini
     * public ThisHamster() {
	 *   this(weight); 
	 * }
	 * 
	 * public ThisHamster(int weight) {
	 *   this(); 
	 * }
	 * 
     */
	
	// this -> fait référence à une instance de la class
	// this() -> fait référence au constructeur
	
	// super -> fait référence à une instance du parent
	// super() -> fait référence au constructeur du parent
	
	// this() et super() doivent etre a la premiere ligne du constructeur
	

}