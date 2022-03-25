package ocp.ch15.functional.programming;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class CommonFunctionalInterfaces {

	public static void main(String[] args) {
		// Supplier
		Supplier<LocalDate> s = () -> LocalDate.now();
		Supplier<LocalDate> s1 = LocalDate::now;
		
		LocalDate date = s.get();
		
		Supplier<StringBuilder> strb = () -> new StringBuilder();
		Supplier<StringBuilder> strb1 = StringBuilder::new;
		
		Supplier<ArrayList<String>> arr = () -> new ArrayList<>();
		Supplier<ArrayList<String>> arr1 = ArrayList<String>::new;
		
		List<String> list = arr.get();

		// Consumer
		Consumer<String> c = msg -> System.out.println(msg);
		Consumer<String> c1 = System.out::println;
		
		c1.accept("Bonjour");
		
		
		var map = new HashMap<Integer, String>();
		BiConsumer<Integer,String> cc = (k, v) -> map.put(k,v);
		BiConsumer<Integer,String> cc1 = map::put;
				
		cc1.accept(1, "Ballon");
		
			// andThen()
			// execute deux consumer sequenciellement
		    // Attention ! ce n'est pas une execution à la chaine:
		    // le paramètre du deuxième Consumer n'est pas le résultat du premier
			Consumer<String> print1 = x -> System.out.println(x + " ?");
			Consumer<String> print2 = x -> System.out.println(x + " !");
			Consumer<String> combinePrint = print1.andThen(print2);
			combinePrint.accept("Boubou");  
				//=> Boubou ?
				//   Boubou !
			
		// Predicate
		
		 Predicate<String> predicate1 =  str -> str.startsWith("A");
		 Predicate<String> predicate2 =  str -> str.length() < 6;
		  
		    // and / negate
		     String[] namesArr = {"Ariel", "Flora", "Apollon"};  ///!! on n'invoke pas un stream sur une array
		 	 List<String> names = Arrays.asList(namesArr);
			 List<String> filtredNames = names.stream()
			      .filter(predicate1.and(predicate2.negate()))
			      .collect(Collectors.toList());
			
			 System.out.println(filtredNames); //[Apollon]
		 
		 
		// Function<T,R> and BiFunction<T,U,R>
			 // after.compose(before) : operation à la chaine contrairement à andThen()
			 Function<Integer, Integer> before = x -> x + 1;
			 Function<Integer, Integer> after = x -> x * 2;
			  
			 Function<Integer, Integer> combined = after.compose(before);
			 System.out.println(combined.apply(3));   // 8
		
		// UnaryOperator<T> and BinaryOperator<T> extends Function<T,T> and BiFunction<T,T,T>
		UnaryOperator<String> up = x -> x.toUpperCase();
		UnaryOperator<String> up1 = String::toUpperCase;
		
		String result = up1.apply("joe");
		
		
		BinaryOperator<String> concat = (x, y) -> x.concat(y);
		BinaryOperator<String> concat1 = String::concat;
		
		
	
		
 	}
	
}
