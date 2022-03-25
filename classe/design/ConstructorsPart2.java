package ocp.classe.design;


// TRICK 1
class Mammal {
	public Mammal(int age) {}
}
//class Elephant extends Mammal {}  // DOES NOT COMPILE
// -> PK ? Java tente de créer un constructeur par defaut à Elephant comme ça :
// public Elephant(){
//     super(); // !!! Mais le constructeur par defaut du père n'existe pas (vu qu'il possède deja un constructeur avec argument)
// }
	
//Solution
// Specifier le constructeur du père
class Elephant extends Mammal {
	public Elephant() {
		super(10);
	}
}  
//CCL: les enfants peuvent avoir des constructeurs par defaut meme si leur parent n'en a pas




public class ConstructorsPart2 {

	
	public static void main(String[] args) {

		{
			var x = "bonjour";
		}
	}

}

