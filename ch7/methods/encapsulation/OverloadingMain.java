package ocp.ch7.methods.encapsulation;



public class OverloadingMain {
	//Trick 1
	public static void fly(int numMiles) {
		System.out.println("int");
	}
	public static void fly(short numFeet) {
		System.out.println("short");
	}
	
	//Trick 2
	public static void fly(int... list) {
		System.out.println("int...");
	}
	//public static void fly(int[] list) {
	//	System.out.println("int[]");
	//}  
	// => DUPLICATE method :  int... ===== int[]
	
	// Trick 3 : Autoboxing : java choisi la fonction avec le type le plus specifique
				// si fly(int) n'existe pas Java autobox en utilisant fly(Integer)
	public static void fly2(int numMiles) {
		System.out.println("int");
	}
	public static void fly2(Object numMiles) {
		System.out.println("int");
	}
	public static void fly2(Integer numMiles) {
		System.out.println("Integer");
	}
	
	//trick 4 : Java choisi la fonction avec le type le plus specifique
	public static void fly3(String s) {
		System.out.print("string");
	}
	
	public static void fly3(Object o) {
		System.out.print("object");
	}
	
	//trick 5 : Generics Vs Arrays
	//public void walk(List<String> strings) {}
	//public void walk(List<Integer> integers) {}  // ERROR DUPLICATE METHOD
	
	public static void walk(String[] ints) {}
	public static void walk(int[] integers) {}  // Java considere chaque array typé comme un type à part
	
	//Trick 6
	public static void play(Long l) {}
	   
	public static void main(String[] args) {
		// Trick 1
		fly(1); // calls fly(int) 
		fly((short)1); // Java ne va pas chercher le type le plus etroit elle prend le plus large
						// si on veut plus de précision il faut faire un cast 
		
		// Trick 2
		int[] list = new int[] {1, 2};
		fly(list);
		
		//Tric 3
		fly2(1);
		
		//Tric 4
		fly3("global"); // => string
		System.out.println("-");
		fly3(1); // => object
		
		
		// Dans l'ordre
		//int => Exact match by type	
		//long => Larger primitive type
		//Integer => Autoboxing
		//int... => Varargs
		
		//Trick 6
		//play(4); //Error JAVA est bien gentil de convertir int => long mais de la a encore convertir long => Long. trop demandé
		play(4L); // autoboxing long => Long
		
		
		
	}

}
