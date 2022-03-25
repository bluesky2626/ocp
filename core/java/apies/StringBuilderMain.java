package ocp.core.java.apies;

public class StringBuilderMain {

	public static void main(String[] args) {

		String alpha = "";
		for(char s = 'a'; s <= 'z'; s++ ) {
			alpha = alpha + s;
		}
		//Comme alpha est immuable, chaque affectation ligne 9 cr�� un nouvel objet String 
		// it1 : ligne 9 cr�e un nouvel objet alpha = "a" et rend l'objet "" eligible au garbage collector etc..
		//en tou 1("")+26 objets sont instanci�s 
		
		StringBuilder alphaa = new StringBuilder();
		for(char s = 'a'; s <= 'z'; s++) {
			alphaa.append(s); 
		}
		// un seul objet est instanci�, StringBuilder is not imutable
		
		//Trick
		StringBuilder a = new StringBuilder("abc");
		StringBuilder b = a; //b = abcde = a ??
		b.append("f").append("g"); //b = abcdefg ??
		System.out.println("a=" + a); //  abcdefg
		System.out.println("b=" + b);//   abcdefg (O_O) 
		
		// "abcdefg" - a , b 
		
		// Il existe un seul objet "abc" cr��. (un seul new)
		// les references a et b sont li� a ce meme objet qui change
		
		StringBuilder sb = new StringBuilder("animals");   
		String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al")); //sb.substring(0,4) //anim
		int len = sb.length(); //7 = because it is the number of characters in the StringBuilder
		int lenSub = sub.length(); // 4 
		char ch = sb.charAt(6); //s 
		//"animals" - sb
		//"anim   " - sb 
		//"anim"    - sub  
		//N.B. sb.substring(x,y) ne change pas la valeur de sb comme append
		
		//append(true) pas besoin de convertir le parametre de append en String il le fait pour toi
	
		//N.B. StringBuffer c'est pareil sauf qu'il g�re les thread et il est plus lent
		
		StringBuilder sf = new StringBuilder("animals");  
		StringBuilder suf = sf.insert(2, '-');
		//StringBuilder suff = sf.insert(99, '-'); //java.lang.StringIndexOutOfBoundsException:

		// an-imals -> sf, suf
		//StringBuilder delete(int startIndex, int endIndex) {}
		//StringBuilder deleteCharAt(int index) {}
		sb.delete(1, 100);                  // sb = a //No Exeption
		//sb.deleteCharAt(19);               // throws an exception .StringIndexOutOfBoundsException

		StringBuilder builder = new StringBuilder("pigeon dirty");
		builder.replace(3, 100, ""); //"pig" first delete from 3 to 100 then put ""
		
		
		StringBuilder sbb = new StringBuilder("ABC");
		sbb.reverse();		
		
		// charAt , substring => java.lang.StringIndexOutOfBoundsException (comme pour String)
		// insert, deleteCharAt
		
		//-------------------------------EQUALITY-------------------------------------------------
		// On parle d'egalit� des references
		StringBuilder one = new StringBuilder();
		StringBuilder two = new StringBuilder();
		System.out.println(one == two); // false 
		// x - one
		// y - two
		
		StringBuilder three = new StringBuilder();
		StringBuilder four = three.append("chekla");
		System.out.println(three == four); // true
		// x - three
		// "chekla" - three 
		// "chekla" - three - four
		
		
		// Egalit� des valeurs
		one.append("chkla");
		two.append("chkla");
		System.out.println(one == two); // false 

		String oneS = "chekla";
		String twoS = "chekla";
		System.out.println(oneS == twoS); // true 
		System.out.println(oneS.equals(twoS)); // true 

		//Si une class n'impl�mente pas sa methode equals, le == cherche si les references pointent sur le meme objet


		
		

	}

}
