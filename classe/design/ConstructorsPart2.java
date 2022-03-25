package ocp.classe.design;


// TRICK 1
class Mammal {
	public Mammal(int age) {}
}
//class Elephant extends Mammal {}  // DOES NOT COMPILE
// -> PK ? Java tente de cr�er un constructeur par defaut � Elephant comme �a :
// public Elephant(){
//     super(); // !!! Mais le constructeur par defaut du p�re n'existe pas (vu qu'il poss�de deja un constructeur avec argument)
// }
	
//Solution
// Specifier le constructeur du p�re
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

