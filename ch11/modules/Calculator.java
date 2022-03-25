package ocp.ch11.modules;

import com.lib.maths.Addition;

public class Calculator {

	public static void main(String[] args) {
		Addition addition = new Addition();
		System.out.println(addition.add(2, 3));
	}
}
