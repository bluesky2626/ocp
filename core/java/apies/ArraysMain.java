package ocp.core.java.apies;

import java.util.Arrays;

class Name {
	String names[];
	//names ==> null
	String names1[] = new String[2];
	//names1 ==> String[2]

}

public class ArraysMain {

    String names[];
	public static void main(String[] args) {

		// Array is a reference type
		// Array est representée par []
		// Array is an ordered list
		char[] chaine; // = String;
		
		int[] numbers1 = new int[3]; //crée un tableau avec des int dont la valeur est 0 (valeur par defaut des int)
		int[] numbers2 = new int[] {1,2,3};
		int[] numbers3 = {1,2,3}; // racourci pour la precedente
		//int[] numbers4 = new int[3] {1,2,3}; // NOT COMPILE, PAS les deux en meme temps

		
		int num[]; // ça aussi ça passe et meme avec des espaces autour
		//num = {6 , 9, 1}; DO NOT COMPILE : cela n'est valable qu'à la declaration
			      // int[] num = {6 , 9, 1}

		//Trick
		int ids[], types; // une array , un int
		
		  String [] bugs = { "cricket", "beetle", "ladybug" };
		  //bugs ==> String[3] { "cricket", "beetle", "ladybug" }
	      String [] alias = bugs;
	      //alias ==> String[3] { "cricket", "beetle", "ladybug" }
	      bugs.equals(alias);     // true (reference equality)

	      
	      System.out.println(bugs);            //[Ljava.lang.String;@27f674d
	      System.out.println(bugs.toString()); //[Ljava.lang.String;@27f674d
	      Arrays.toString(bugs); //[cricket, beetle, ladybug]
	      
	      // initialisation de types
	      Name name = new Name();
	      System.out.println(name.names); // null - names n'a jamais été instanciée
	      System.out.println(name.names1); // [Ljava.lang.String;@48140564
	      
	      //Cast ou pas
	      String[] strings = { "stringValue" };
	      // strings ==> String[1] { "stringValue" }
	      Object[] objects = strings;                  //  /!\Pas besoin de cast Object peut contenir String parce qu'il est plus large
	      // objects ==> String[1] { "stringValue" }

	      objects[0] = new StringBuilder();    // GROS TRICK (java.lang.ArrayStoreException:) objects doit contenir que des strings il n'y a pas du tout un Object[]

	      
	      String[] againStrings = (String[]) objects; // cast obligatoire : String[] a = Object[] b !!!!! pas possible  
	      // againStrings ==> String[1] { "stringValue" }
	      
	     // againStrings[0] = new Date();   // DOES NOT COMPILE
	      // String[] againStrings -> only allows String objects in it
	     
	      
	      System.out.println(Arrays.toString(againStrings)); // { "stringValue" } 
	      // { "stringValue" } <-  strings - objects - againStrings

	      
	      
	      
	      
	      //Out of bounds
	      int[] numbers = new int[10];
	     // numbers[10] = 3; // java.lang.ArrayIndexOutOfBoundsException
	     // numbers[numbers.length] = 5;
	      for (int i = 0; i <= numbers.length - 1; i++) numbers[i] = i + 5;
	      for (int i = 0; i < numbers.length; i++) numbers[i] = i + 5;
	      
	      //Sort
	      int[] numbersToSort = {6 , 9, 1};
	      Arrays.sort( numbersToSort); 
	      System.out.println(Arrays.toString(numbersToSort)); // [1, 6, 9]
	      
	      //Search
	      int[] numbersA = {2,4,6,8};
	      
	      // -- prerequis = on sorted array
          Arrays.binarySearch(numbersA, 2); // 0  -> OK - returns index 
	      Arrays.binarySearch(numbersA, 4); // 1  -> OK - returns index 
	      Arrays.binarySearch(numbersA, 1); // -1 -> Not found : devrait etre dans 0 mais 0-1 
	      Arrays.binarySearch(numbersA, 3); // -2 -> Not found : devrait etre dans 1 mais (-1) -1
	      Arrays.binarySearch(numbersA, 9); // -5 -> Not found : devrait etre dans 4 mais (-4) -1

	      Arrays.binarySearch(numbersToSort, 9); // Surprise !!
	      
	      //compare
	      // first < second -> -
	      // first > second -> +
	      // equals         -> 0
	      
	      // {1} < {2}
	      // {1, 2, 3} < {1, 3, 3} -> first element that differs <
	      // {1} < {1 , 2 }
	      // {"a"} < {"aa"}
	      // {"A"} < {"a"}    -> UpperCase is smaller than lowercase
	      // {null} < {"a"}
	      String[] a = new String[] {"c"};
	      String[] b = new String[] {"cc"};

	      System.out.println(Arrays.compare(a,b)); // c > ac // prsk c>a
	      
	      //Multidimentional
	      // 2D = [][]
	      String[][] rectangle = new String[3][2];
	      System.out.println(rectangle[0]); // [Ljava.lang.String;@7c30a502
	      System.out.println(rectangle[0][0]);  // null
	      rectangle[0][0]="set";
	      System.out.println(Arrays.toString(rectangle[0])); // [set, null]
	        //asymmetric array : 2 manières d'instancier
	      //First way
	      int[][] asym = new int[3][]; // donner la length pour l'array principale et laisser l'autre libre
	      asym[0] = new int[2]; 
	      asym[1] = new int[8];
	      asym[2] = new int[9]; // /!\ il faut absolument instancier chaque sous-array
	      
	      //Second way
	      int[][] asym1 = {{1, 2} , {1,2,3}}; 
	      
	      for(int i=0; i < asym.length; i++) {
	    	 for(int j=0; j < asym[i].length; j++) { // DO NOT COMPILE IF SUB-ARRAYS ARE NOT INSTANCIATED
	    		 asym[i][j] = 2;
	    	  }
	      }
	      // other way to loop through
	      for(int[] sub : asym) { //For each sub-array
	    	  for(int i : sub) { 
	    		 // System.out.println(i);
	    	  }
	      }
	    	  
	    	  
	  //    System.out.println(Arrays.toString(asym));
	}

}
