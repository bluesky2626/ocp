package ocp.generics.and.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Duck implements Comparable<Duck>{
	private String name;
	
	
	public Duck(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Duck [name=" + name + "]";
	}

	@Override
	public int compareTo(Duck o) {
		return name.compareTo(o.name);
	} 
}

class Duckk {
	private String name;
	
	
	public Duckk(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Duck [name=" + name + "]";
	}
}

public class CompareDucks{
	public static void main(String[] args) {
		  
		   System.out.println("Quack".compareTo("Puddles")); 
		   var ducks = new ArrayList<Duck>();
		   ducks.add(new Duck("Quack"));
		   ducks.add(new Duck("Puddles"));
		   ducks.add(new Duck("Reda"));

		   // Comparable
		   Collections.sort(ducks);
		   ducks.forEach(System.out::println);
		   
		   
		   // Comparator
		   System.out.println("Quack".compareTo("Puddles")); 
		   var duckks = new ArrayList<Duckk>();
		   duckks.add(new Duckk("Quack"));
		   duckks.add(new Duckk("Puddles"));
		   duckks.add(new Duckk("Reda"));
		   Comparator<Duckk> comparator = new Comparator<Duckk>() {

				@Override
				public int compare(Duckk o1, Duckk o2) {
					return o1.getName().compareTo(o2.getName());
				}
			   
		   };
		   
		   Collections.sort(duckks, comparator);
		   duckks.forEach(System.out::println);

	}
	
}
