package ocp.lambda.expressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
class Bicycle {

    private String brand;
    private Integer frameSize;
    // standard constructor, getters and setters
	public Bicycle(String brand, Integer frameSize) {
		super();
		this.brand = brand;
		this.frameSize = frameSize;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Integer getFrameSize() {
		return frameSize;
	}
	public void setFrameSize(Integer frameSize) {
		this.frameSize = frameSize;
	}
	
	
    
}
class BicycleComparator implements Comparator {

    @Override
    int compare(Bicycle a, Bicycle b) {
        return a.getFrameSize().compareTo(b.getFrameSize());
    }

}*/
public class LambdaExpressions {

	void createPredicate(int a) {
		int b = 1;
		Predicate<Integer> a = x -> {
			//return b == a;
			return x == a;
			// b  has been reassigned after lambda, b is not effectively final
		};
		b = 12;
		
	}
	public static void main(String[] args) {
		LambdaExpressions lambdaExp = new LambdaExpressions();
		lambdaExp.createPredicate(2);
		
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		// boolean test( T )
		Predicate<Integer> p = x -> x == 1;
		list.removeIf(p);
		System.out.println(list); //list = [1]
		
		// accept( T )
		Consumer<Integer> c = x -> System.out.println(x);
		list.forEach(c);
		
		// R apply( T )
		Function<Integer, Integer> f = x -> x + 1;
		List list1 = list.stream()
				.map(f)
				.collect(Collectors.toList());
		System.out.println(list1);
		
		//creer des sream
		Stream s = Stream.empty();
		Stream s1 = Stream.of("A", "B", "X");

		Stream s2 = Arrays.stream(new String[] {"C", "D", "E"} );
		
	}
}
