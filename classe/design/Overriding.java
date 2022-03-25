package ocp.classe.design;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Utilité du super.
public class Overriding {
	public static void main(String[] args) {
		
		System.out.println(new Wolf().getAverageWeight()); // java.lang.StackOverflowError
	}
}


class Canine {
	protected double getAverageWeight() {
		return 50;
	}
}

class Wolf extends Canine {
	public double getAverageWeight() {
		//return getAverageWeight()+20;  // java.lang.StackOverflowError
		//Soulution: 
		return super.getAverageWeight()+20;
	}

}

// Les conditions pour overrider
// 1 - meme signature
// 2 - type de retour est le meme ou bien type de retour du fils est un subtype du type de retour du père
// 3 - La methode dans le fils a la meme ou plus de visibilité que dans le père
// 4 - l'Exception du fils doit etre plus etroite que celle du père et un truc avec checked que je pige pas


// X et un subtype de Y
// 1 - X et Y sont des class et X extends Y
// 2 - X et Y sont des interfaces et X implements Y
// 3 - X est une class qui implements l'interface Y
// 4 - X est une class qui extends la class Z et Z implements Y


// TRICK 1 : le fils a moins de visibilité que son père !! 
class Camel {
	public int getNumberOfHumps() {
		return 1;
	}
}

class BactrianCamel extends Camel {
	private int getNumberOfHumps() {  // DOES NOT COMPILE
		return 2;
	}
}

// Override / overloading
class Bird {
	public void fly() {}
	public void eat(int food) {}
}

class Eagle extends Bird {
	public int fly(int height) {	 // fly() -> Overloaded
		return height;
	}
	// eat() -> meme signature mais le type de retour n'est ni le meme ni un sybtype
	public int eat(int food) {  // DOES NOT COMPILE -> ni override ni overload
		return food;
	}
}

// Exception
class Reptile {
	protected void sleepInShell() throws IOException {}

	protected void hideInShell() throws NumberFormatException {}

	protected void exitShell() throws FileNotFoundException {}
}

class GalapagosTortoise extends Reptile {
	// FileNotFoundException extends IOException
	public void sleepInShell() throws FileNotFoundException {}

	public void hideInShell() throws IllegalArgumentException {}

	public void exitShell() throws IOException {} // DOES NOT COMPILE
}

// TRICK : type de retour
class Rhino {
	protected CharSequence getName() {
		return "rhino";
	}
	protected String getColor() {
		return "grey, black, or white";
	}
}

class JavanRhino extends Rhino {
	public String getName() {  // String implements CharSequence so ok
		return "javan rhino";
	}
	public CharSequence getColor() {  // DOES NOT COMPILE
		return "grey";
	}
}

// GROS TRICK : GENERICS dans le perametre
class LongTailAnimal {
	protected void chew(List<Object> input) {}
}

class Anteater extends LongTailAnimal {
	protected void chew(List<Double> input) {}  // DOES NOT COMPILE
}

		// Signature differente -> pas de override
		// Overload ? Non parce que c'est considéré comme duplicate, java voir que List il s'en fiche du type

class LongTailAnimall {
	protected void chew(List<Object> input) {}
}

class Anteaterr extends LongTailAnimall {
	protected void chew(ArrayList<Double> input) {}
}

		// Signature differente -> pas de override
		// Overload ? oui parce que ce n'est pas un DUPLICATE

// GENERICS dans le type de retour


class Mammalll {
	public List<CharSequence> play() { return Arrays.asList("");}
}

class Monkeyy extends Mammalll {
	public ArrayList<CharSequence> play() {  return new ArrayList<CharSequence>(); }
}

// Override ok !
// ArrayList is a subtype pf List
// A condition que <T> soit le meme


// Override private methods  ?? Imposible parce qu'elles ne peuvent pas etre héritées
// Override final methods    ?? Impossible parce qu'elles ne peuvent pas etre héritées

