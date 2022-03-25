package ocp.classe.design;

// Rule 1: une instance est initialisée à chaque fois que new est appelé
// Rule 2: l'ordre
/*
 * 1- s'il y'a une superclass, initialise la avant
 * 2- executer les declaration de variables d'instance
 * 3- execturer les blocs 
 * 4- exectuer d'abord les constructeurs qui comportent un this() ou un super() 
 */

public class InitialisationInstance {
     private String name = "BestZoo";
     { System.out.print(name+"-"); }
     
     private static int COUNT = 0;
     
     static { System.out.print(COUNT+"-"); }
     static { COUNT += 10; System.out.print(COUNT+"-"); }
  
     public InitialisationInstance() {
        System.out.print("z-");
    }

    public static void main(String... patrons) {
       new InitialisationInstance();
    }
 }

// main est dans  InitialisationInstance => init la class InitialisationInstance :
																			// init COUNT (variables de class dans l'ordre)
																		   	//  static { System.out.print(COUNT+"-"); } => print 0-
																			//  static { COUNT += 10; System.out.print(COUNT+"-"); }  => print 10-
// new InitialisationInstance(); => init l'instance InitialisationInstance :
					// init les variables d'instance :  private String name = "BestZoo";
					// init les bloc  : { System.out.print(name+"-"); }  => print "BestZoo-"
					// executer les constructors  => print "z-"
//=> 0-10-BestZoo-z
