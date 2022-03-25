package ocp.exceptions;

// runntime exceptions  are RunntimeException and its subclasses
// Elles sont unchecked
// On est pas obligés de les catcher ou de les throw (optional)
// Peuvent etre thrown by JVM or programmer

public class RunntimeExceptions {
	
	static String name;
	static int[] array = new int[3];
	
	int age;
	public static void main(String[] args) {
		//ArithmeticException
		//int x = 12/0;
		
	//ArrayIndexOutOfBoundsException
		/*int[] things = new int[3];
		int total = 0;
		for(int i = 0; i <= things.length; i++) {
			total+=things[i]; //things[3] index 3 n'existe pas
		}*/
		
	//ClassCastException
		String chaine = "hello";
		//Integer x = (Integer) chaine; // DO NOT COMPILE : j'essaye de mettre un String dans un Integer
		
		Object obj = 1;
		Integer x2 = (Integer)obj; // OK
		
		Object objS = chaine;
		//Integer x3 = (Integer)objS; //ClassCastException
			// le compilateur croit qu'on veut mettre un Object dans un Integer, 
			// il n'a pas vu que dans la reference obj  y'a un String
		 Primate prim2 = new Primate();
	     //Lemur lem2 = (Lemur)prim2; // ClassCastException
	     
	  //NullPointerException
	     //System.out.println(name.length()); // NullPointerException : Les variable d'instance quand c'est des reference Types (static ou pas) sont initialisées à null par defaut 
	     System.out.println(array);   		// [I@1cd072a9
	     System.out.println(array.length);  // 3  
	     
      //NumberFormatException extends IllegalArgumentException
	     Integer.parseInt("3.4");

	}
	
	   //IllegalArgumentException
	  public void setSingerAge(int age ) {
	    	 if(age < 0) {
	    		 throw new IllegalArgumentException("age must be positive");
	    	 }
	    	 this.age = age;
	  }
	  
	  
	  
}
