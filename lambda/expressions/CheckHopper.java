package ocp.lambda.expressions;

import java.util.function.Predicate;

public class CheckHopper implements Predicate<Animal> {

	@Override
	public boolean test(Animal a) {
		return a.canHop();
	}

}
