package ocp.generics.and.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class MyCollection {

	public static void main(String[] args) {
	String[] array = new String[] {"a", "b", "c"};
	List<String> asList = Arrays.asList(array); // [a, b, c]
	List<String> of = List.of(array);           // [a, b, c]
	List<String> copy = List.copyOf(asList);    // [a, b, c]

	array[0] = "z";
	
// 	copy.set(0, "o"); Exception
	System.out.println(asList); // [z, b, c]
	System.out.println(of);     // [a, b, c]
	System.out.println(copy);   // [a, b, c]
	
	
	Queue<Integer> queue = new LinkedList<>();
	System.out.println(queue.offer(10)); // 10    : true
	System.out.println(queue.offer(4));  // 10 4  : true 
	System.out.println(queue.peek());    // 10 4  : 10
	System.out.println(queue.poll());    // 4     : 10 
	System.out.println(queue.poll());    // []    : 4
	System.out.println(queue.peek());    // []    : NULL
	
	Optional<String> sum = asList.stream().reduce((x,y)->x+y);
	if(sum.isPresent()) {
		System.out.println(sum.get());
	}
	
	
	List<Integer> liste = new ArrayList<Integer>();
	liste = Arrays.asList(2, 6, 5 , 1, 10);
	
	
 	}

}
