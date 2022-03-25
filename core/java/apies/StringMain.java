package ocp.core.java.apies;

public class StringMain {

	public static void main(String[] args) {
		// Concatenation
		System.out.println(1 + 2 + "c");     // 3c
		
		// String is immutable
		// Immutable classes on uniquement des getters, quand la variable d'instance est créée il n'y a aucun moyen de la modifier
		String s = "1";
		s.concat("2");
		System.out.println(s); //1 => aucune methode ne peut modifier s 
		String s2 = s.concat("2"); 
		System.out.println(s2); // 12 
		
		// methodes
		int l = s.length(); //2
		char c = s.charAt(0); //1
		//char c = s.charAt(99);  java.lang.StringIndexOutOfBoundsException: String index out of range: 3
		
		String s1 = "animals";
		int i = s1.indexOf('a'); //0
		int j = s1.indexOf('K'); // -1 : Je n'ai pas trouvé (Pas d'exception)
		int z = s1.indexOf("im"); //2 (index du premier caractère de la sous-chaine)
		int z1 = s1.indexOf("im", 2); // 2 : Java commence à chercher à partir du index 2 

		
		s1.substring(3,4); //m : le curseur se place au tout début du caractere 
		s1.substring(3,3); // rien
		//s1.substring(3,2); // Java.lang.StringIndexOutOfBoundsException: begin 3, end 2, length 7
		//s1.substring(3,8) // Java.lang.StringIndexOutOfBoundsException:
		
		
		// boolean equals(Object ) is the same for all objects
		
		s1.startsWith("A"); // false : case-sensitive
		s1.contains("A"); //false : case-sensitive
		
		String s3 = " \nanimals\t ";
		s3.strip(); //trim including unicodes
		s3.stripLeading(); //trim on the beginning
		String ss3 = s3.stripTrailing(); //trim in the end of the word
		System.out.println(s3); // s3 est immuable
		
		System.out.println(s1.intern()); // value from the string pool
		
		//CCL: charAt, substring =>  Java.lang.StringIndexOutOfBoundsException
		

	}

}
