package ocp.classe.design.polymorphism;


class Primate {
	public boolean hasHair() {
		return true;
	}
}

interface HasTail {
	public abstract boolean isTailStriped();
}

class Lemur extends Primate implements HasTail {
	public int age = 10;
	
	public boolean isTailStriped() {
		return false;
	}
	
	public void processLemur() {
		System.out.println("Lemur method");
	}

}

class Autre {
	
}
// En java, les objets sont accessibles par r�f�rence. l'objet en lui meme ne change jamais
// On peut assigner un objet Lemur � une reference : Primate et HasTail
// Le polymorphism permet d'assigner un objet lemur � une reference de sa superclass ou de l'insterface qu'il implemente
public class Intro {
	public static void main(String[] args) {
		Lemur lemur = new Lemur();

		lemur.isTailStriped(); // false
		
		HasTail hasTail = lemur;
		hasTail.isTailStriped(); // false
		//hasTail.hasHair();       // DO NOT COMPILE. L'objet est devenu HasTail et cette reference n'a rien a voir avec Primate 

		
		lemur.hasHair();   // true

		Primate primate = lemur;
		primate.hasHair();      // true
		//primate.isTailStriped();  // DO NOT COMPILE. L'objet est devenu Primate et cette super class n'a rien a voir avec l'interface HasTail
		
		//hasTail.processLemur(); // DO NOT COMPILE
		//primate.processLemur(); // DO NOT COMPILE
		//primate.age = 2;        // DO NOT COMPILE
		
		// CCL. Le type de r�f�rence d�termine les methodes et variables auquels l'objet a acc�s
		// N.B  avant meme d'assigner lemur � une reference de type primate, lemur pouvait acc�der aux methodes de Primate parce que c'est son p�re
		
		
		// Contrairement � primate, obj garde son identit� de Lemur et peut appeler ses methodes : processLemur
		Object obj = lemur;
		lemur.processLemur();
		
		
		// En assignant une r�f�rence Primate � l'objet lemur on a perdu l'acc�s � la variable age et methode processLemur()
		// Solution : cast
		
		// Cast explicite
		Primate primate2 = new Lemur(); // Primate primate = lemur; // KIFKIF
		Lemur lemur2 = (Lemur)primate2;
		lemur2.age = 2;
		
	
		// Ce qui ne marche pas 
		//Lemur lemur3 = primate2;  // DO NOT COMPILE : on met pas un Primate dans un Lemur il est trop grand*
		
		//Rules :
		//	1. Casting a reference from a subtype to a supertype doesn�t require an explicit cast.
		        Lemur lemurien = new Lemur();
				Primate primatee = lemurien;
		//  2. Casting a reference from a supertype to a subtype requires an explicit cast.
		       Lemur lemur22 = (Lemur)primate;
		//  /!\ primate est une r�f�rence Primate d'un objet Lemur !!! 
		       Primate prim = new Lemur();
		       Lemur lem = (Lemur)prim;
		       lem.age = 2;  
			   // On essaye de mettre un objet Primate dans une reference Lemur => ClassCastException
		       Primate prim2 = new Primate();
		       Lemur lem2 = (Lemur)prim2; // ClassCastException
		       lem2.age = 2;
	   //   3. The compiler disallows casts to an unrelated class. (prend que subtypes)
		       Autre autre = new Autre(); 
		       //Lemur lemurien = (Lemur) autre;// DO NOT COMPILE
	   // At runtime, an invalid cast of a reference to an unrelated type results in a ClassCastException being thrown.
		       
		       
		       
	    // instanceof 
		       //if(autre instanceof Lemur) {} // DO NOT COMPILE
		       // instanceof ne peut pas etre utilis� avec unrelated classes
		       
		       if(primate instanceof Lemur) {
		    	   System.out.println(true);  // TRUE. primate est une r�f�rence � un objet Lemur
		       }
	}
}
