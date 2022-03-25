package ocp.classe.design;

class Insect {
    protected int numberOfLegs = 4;
    String label = "buggy";
 }
 
class Beetel extends Insect {
    protected int numberOfLegs = 6;
    short age = 3;
    
    
    public void printData() {
      System.out.print(this.label); // "buggy" 
      // Rule 1: le fils a acces a tous les public, private-package (si fils et père font partie du meme package) and protected members de son père en plus de ses propres variables directement ou avec this
      System.out.print(super.label); // "buggy"
     // Rule 2 : le fils a acces a tous les public, private-package and protected members de son père avec super

      System.out.print(this.age);    // 3
     // System.out.print(super.age);  // y a pas de age chez Inserct
      System.out.print(numberOfLegs); // 6
   }
    
    
  
}

public class ThisAndSuper {
	 public static void main(String []n) {
	      new Beetel().printData();
	   }
}