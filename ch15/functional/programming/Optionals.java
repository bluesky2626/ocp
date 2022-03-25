package ocp.ch15.functional.programming;

import java.util.Optional;

// Optional is a box that might contain something or might instread be empty
public class Optionals {

	// creating an Optional : empty() et of()
	public static Optional<Double> average(int... scores){
		if(scores.length == 0) return Optional.empty();
		
		int sum = 0;
		for(int sc : scores) {
			sum+= sc;
			
		}
		//return Optional.of(sum/scores.length); // Cannot convert from int to Double (pas d'autoboxing)
		return Optional.of((double)sum/scores.length); // Faut absolument caster pour permettre l'autoboxing (double -> Double)
		
	}
	
	public static Optional<Double> moyenne(int... scores){
		//if(scores.length == 0) return Optional.empty();
		
		int sum = 0;
		for(int sc : scores) {
			sum+= sc;
			
		}
		//return Optional.of(sum/scores.length); // Cannot convert from int to Double (pas d'autoboxing)
		return Optional.ofNullable((double)sum/scores.length); // Faut absolument caster pour permettre l'autoboxing (double -> Double)
		
	}
	public static void main(String[] args) throws IllegalAccessException {
		
		//Using the Optional : isPresent() puis get()
		Optional<Double> avr = average();
		//avr.get();       // NoSuchElementException
		avr.isPresent(); // false
		
		Optional<Double> avr2 = average(new int[] {90, 100});		
		if( avr2.isPresent() )
			avr2.get(); //95
		

		//Using the Optional created with ofNullable 
		//pour ne pas tomber des l'exception NoSuchElementException
		Optional<Double> moy = moyenne();
		moy.get();  //NaN
		Optional<Double> moy2 = moyenne(90, 100);
		moy2.get(); //95.0
		
		
		// ifPresent(Concumer ) 
		avr2.ifPresent(System.out::println); // optional est present => on l'affiche 95.0
		avr.ifPresent(System.out::println);  // optional est empty => on fait rien


		// Qu'est-ce qu'on fait si la valeur n'est pas présente
		// orElse : je lui attribue une valeur donnée
		// Attention !! cette valeur doit un Double (Optional<Double>)
		avr.orElse(Double.NaN);  //NaN
		// orElseGet(Supplier ) : je lui attribue une valeur plus sophistiquée en utilisant un supplier 
		avr2.orElseGet(Math::random); // 0.2009638144548167
        // orElseThrow()
		avr.orElseThrow(); // NoSuchElementException
		// orElseThrow(Supplier )
		avr.orElseThrow(() -> new IllegalAccessException());
		
		// Attention !! si l'optional contient une valeur toutes les fonctions renvoient cette valeur là
	}
}
