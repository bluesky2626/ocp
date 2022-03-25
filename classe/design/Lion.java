package ocp.classe.design;

// l'héritage ça veut dire que Lion peut utiliser les membre public et protected directement
// sans instancier un objet de type Animal afin d'y acceder : setAge(a);
//															  name = n;
//                                                            this.name = name
//      /!\ this permet d'acceder aux membres public et protected du pere comme si c'était le mien

// super is similar to the this reference, except that it excludes any members found in the current clas
// si on a deux fields du meme nom dans Animal et Lion, java prend celui de la current class avec ou sans this
class Animal {
	   private int age;
	   protected String name;
	   public int getAge() {
	      return age;
	   }
	   public void setAge(int newAge) {
	      age = newAge;
	   }
}

public class Lion extends Animal {
	
	public void setProperties(int a, String n) {
	   //age = a; DO NOT COMPILE
		setAge(a);
		// NAME IS PROTECTED
		name = n;
	}
	public void roar() {
		System.out.print(name + ", age " + getAge() + ", says: Roar!");
	}
	public static void main(String[] args) {
		var lion = new Lion();
		lion.setProperties(3, "kion");
		lion.roar();
	}
}
//-----------------------------------------------------------------------
