package ocp.generics.and.collections;

import java.util.ArrayList;
import java.util.List;

public class classWrapper {

	// Les primitives n'ont pas de methodes mais ils ont des wrapper avec l'autoboxing
	public static void main(String[] args) {
		
		// Creating wrappers
		Integer a = Integer.valueOf(1);
		Byte b = Byte.valueOf((byte) 1);
		Long l = Long.valueOf(1); 
		Short sh = Short.valueOf((short) 1);
		Float f = Float.valueOf((float)1.0);
		Double  d = Double.valueOf(1.0);
		Character ch =  Character.valueOf('c');
		
		// Double et Long comprennent tt seuls pas besoin d'un cast
		
		
		// TRICK 2 : remove is overloaded 
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		numbers.add(Integer.valueOf(3));
		numbers.add(Integer.valueOf(5));
		numbers.remove(Integer.valueOf(5));
		
		System.out.println(numbers);
		
		
		//Diamond operator
		var list = new ArrayList<Integer>();
		var list2 = new ArrayList<>();
	}

}
