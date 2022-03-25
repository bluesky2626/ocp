package ocp.classe.design;

 

public class Inheritance {
	//Une classe java ne peut hériter directement que d'un seul parent
	// pk ? Si deux parents ont le meme membre (protected / public) lequel il doit choisir

	// Une class final ne peut pas avoir d'enfant 
	public final class Sterile {
		
	}

	//Toutes les class qui n'héritent pas d'une class, héritent de java.lang.Object automatiquement grace au compilateur
	// en consequence, elles ont toutes : toString() , equals()
	//Les primitive n'héritent pas de java.lang.Object
	
	//member private n'est accessible que dans la class elle meme
	
	//inner class = class defined inside another class (pblic / package-private / protected / private )
	//top level class = is not defined inside another class  (public / package-private)
	
	//In a File : on peut avoir qu'une seule class public 
	

	private String color;
	public void setColor(String color) {
		color = color; //Il croit qu'on dit : moi = moi
		// Solution
		// this.color = color
	}
	public void setData(String color) {
		color = this.color; 
	}
	
	public void setDataa(String newColor) {
		color = newColor; 
	}
	public static void main(String[] args) {
		
		//Trick
		Inheritance in = new Inheritance();
		in.setColor("Blue");
		System.out.println(in.color); // NULL
		
		in.setData("Red");
		System.out.println(in.color); // NULL

		in.setDataa("Yellow");
		System.out.println(in.color); // Yellow
	}
}
