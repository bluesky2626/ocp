package ocp.exceptions;

import java.util.ArrayList;
import java.util.List;

// An exception is an event that alters program flow and asks the developer to deal with it
//			   Object
//     		   Throwable
//   Exception          Error
//   RuntimeException


//Checked and Unchecked Exceptions
	//The distinction is that checked exceptions must be handled or declared (try catch / throws)
	//while unchecked exceptions can be optionally handled or declared.

// Checked Exceptions 
// subclasses of Exceptions but to of RuntimeException

//Unchecked Exceptions
// - Error : est un problème grave (disk drive disapeared, out of memory). Le programme ne peut pas le catcher.

// - RuntimeException class and its subclasses :tend to be unexpected but not necessarily fatal.
//   ex. accessing invalid array index is unexpected, nullPointerException
// si on devait handle ou declarer toutes les unchecked exceptions ce serait trop redondant



// Trois Groupes d'exceptions: Exception, RunntimeException , Error
// On doit savoir pour une exception : a quelle groupe elle appartient et si elle a été thrown par la JVM ou bien programmer
public class Introduction {

	public static void main(String[] args) {
		String[] animals = new String[0];
		System.out.println(animals[0]); //ArrayIndexOutOfBoundsException = Unchecked
	
		String[] animalss = new String[4];
		System.out.println(animalss[0]); // null
		
		List<Integer> animalList = new ArrayList<Integer>();
		System.out.println(animalList.get(0));  //IndexOutOfBoundsException
		//!\ On peut mettre des int dans cette liste et grace à l'autoboxing ça deviendra des Integer
		
		//TRICK
		try {
			throw new NullPointerException();
			throw new ArrayIndexOutOfBoundsException();  // DOES NOT COMPILE
			// PARCE QUE cette ligne ne sera jamais ateinte, car NullPointerException serait thrown avant
		} catch (Exception e) {}
	}
	
// throw == dire à java qu'un autre bout de code devra prendre en charge mon exception (le père qui doit prendre en charge les pleurs de la petite fille)
}
