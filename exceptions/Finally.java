package ocp.exceptions;

// Finally block always executes whether or not an exception occurs  
public class Finally {
	void explore() {
		// Catch block is not required if finally is here
		try {
			fall();
		} finally {
			System.out.println("all better");
		}
	}
	
	void fall() {}
// ---------------------------------------------------------------
	int goHomee() {
		try {
			System.out.println("Hello try");
			// OH Je vois un return 
			// GO TO Finally block
			return -1;	
		} catch(Exception e){
			
		}finally {
			System.out.println("Hello finally");
			return 0;
		}		
	}// 0
// ---------------------------------------------------------------
		int goHome() {
			try {
				System.out.println("Hello try");
				// OH Je vois un return 
				// GO TO Finally block
				return -1;	
			} catch(Exception e){
				
			}finally {
				System.out.println("Hello finally");
				//Return to Try block
			}
			return 0;	

		}//-1
		
// ---------------------------------------------------------------
	
	// TRICK
	void fallDown() throws Exception {
		throw new Exception();
	}
	int goHomeAgain() {
		try {
			fallDown();
			//GO TO Catch block
			System.out.println("hello try"); //SKIPED
			return -1;						 // SKIPED
		} catch(Exception e){
			System.out.println("Hello catch");
			//GO TO Finally block
		} finally {
			System.out.println("Hello finally");
			// !!!! Ne revient pas au Try block parce qu'il y'a eu un exception qui a fait ejecter le curseur du Try 
			// GO TO return 99
		}
		return 99;
	}//99
	
// ---------------------------------------------------------------
	int goHomeAgainAgain() {
		try {
			fallDown();
			//GO TO Catch block
			System.out.println("hello try"); //SKIPED
			return -1;						 // SKIPED
		} catch(Exception e){
			System.out.println("Hello catch");
			//GO TO Finally block
		} finally {
			System.out.println("Hello finally");
			// !!!! Ne revient pas au Try block parce qu'il y'a eu un exception qui a fait ejecter le curseur du Try 
			return -3;
		}
	}
	

	// GROS TRICK
	// Finally est tjrs executé mais peut ne pas s'executer en entier
	void finallyStops(String info) {
		try {
			//
		}finally{
			info.length(); // STOPS HERE with NullPointerException thrown
			System.out.println("Finally end");
		}
	}
	
// ----------------------------------------------------------------------------
	//Exception à la règle
	// Finally n'execute toujours sauf si on met un exit dans le try
	void exitMethod() {
		try {
			System.exit(0);
		}finally {
			System.out.println("Finally end");
		}
	}
	public static void main(String[] args) {
		Finally finaly = new Finally();
		
		finaly.explore();
		finaly.goHomee(); 

		finaly.goHome(); 
		
		finaly.goHomeAgain(); 
		finaly.goHomeAgainAgain(); 

		finaly.finallyStops(null); //NullPointerException
		
		finaly.exitMethod();
		
		//Rule: Si on a pas catché une exception Finally (s'il na pas de return) revient au try block
		//Rappel : si une exception est catchée on sort definitivement du try et on y retourn jamais
		
	
	}
}
