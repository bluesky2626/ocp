package ocp.generics.and.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReference {

	public static void main(String[] args) {
		// Calling Static methods
		Consumer<List<Integer>> lambda = list -> Collections.sort(list);
		Consumer<List<Integer>> methRef = Collections::sort;

		// Calling Instance methods on a defined object 
		String str = "Hello"; //=> object::
		Predicate<String> lambda1 = s -> str.startsWith(s);
		Predicate<String> methRef1 = str::startsWith;

		Random random = new Random(); // => object::
		Supplier<Integer> lambda2 = () -> random.nextInt();
		Supplier<Integer> methRef2  = random::nextInt;

		// Calling Instance methods on a defined parameter
		Predicate<String> lambda3 = s -> s.isEmpty();
		Predicate<String> methRef3 = String::isEmpty; // type::

		BiPredicate<String, String> lambda4 = (s,p) -> s.startsWith(p); 
		BiPredicate<String, String> methRef4 = String::startsWith;

		// Calling constructor
		// default
		Supplier<List<String>> lambda5 = () -> new ArrayList<String>();
		Supplier<List<String>> methRef5 = ArrayList<String>::new;
		// with parameter
		Function<Integer, List<String>> lambda6 = len -> new ArrayList<String>(len);
		Function<Integer, List<String>> methRef6 = ArrayList<String>::new;

		// !! tricky : on peut pas savoir quel constructeur a été créé il faut tjrs regarder le context pour le savoir
		
		// NB. une method reference peur etre la meme pour plusieurs interpretations
		Supplier<Integer> noArgument = () -> Penguin.countBabies();
		Supplier<Integer> noArgument1 = Penguin::countBabies;
		
		Function< Penguin, Integer> onePinguinParam = penguin -> Penguin.countBabies(penguin);
		Function< Penguin, Integer> onePinguinParam1 = Penguin::countBabies;
		
		BiFunction< Penguin, Penguin, Integer> twoPinguinParam = (penguin, penguin2)  -> Penguin.countBabies(penguin, penguin2);
		BiFunction< Penguin, Penguin, Integer> twoPinguinParam1 = Penguin::countBabies;
	}

	

}

class Penguin {
	public static Integer countBabies(Penguin... cuties) {
		return cuties.length;
	}
}
