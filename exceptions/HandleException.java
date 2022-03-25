package ocp.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.MissingResourceException;

// try catch permet de séparer la logique qui pourrait throw une exception de la logique qui handle l'exception
public class HandleException {

	public static void main(String[] args) {
		HandleException handle = new HandleException();
		handle.explore();
	}
	
	// la petite fille se relère toute seule quand elle tombe et continue a explorer

	void explore() {
		try {
			fallDown(); //1
			System.out.println("Never gets here");
			
		}catch(Exception e) {
			System.out.println("getUp");// 2
		}

		seeMoreThings();// 3
	}
	
	void seeMoreThings(){
		System.out.println("seeMore");
	}

	// Toute fonction contenant throw ne contient pas forcement un throws
	void fallDown() {
		System.out.println("fallDown");
		throw new RuntimeException("");
	}
	
	// JAVA prend les bloc dans l'ordre de leur apparition
	public void visitSnakes() {
		try {
		} catch (IllegalArgumentException e) {
		} catch (NumberFormatException e) {  // DOES NOT COMPILE : unreachable code block
			// Prsk NumberFormatException subclass of
				//IllegalArgumentException
		}
	}
	
	// Pk utiliser le multicatch ? A cause du code dupliqué
	// Utilisé pour les exceptions qui n'ont aucun lien entre elles
	// L'ordre n'a pas d'importance
	void duplicateCode(String...args ) {
		 try {
		      System.out.println(Integer.parseInt(args[1]));
		   } catch (ArrayIndexOutOfBoundsException e) {
		      System.out.println("Missing or invalid input");
		   } catch (NumberFormatException e) {
		      System.out.println("Missing or invalid input");
		   }
	}
	
	void multiCatchBlock(String...args ) {
		 try {
		      System.out.println(Integer.parseInt(args[1]));
		   } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
		      System.out.println("Missing or invalid input");
		   } 
		 // On ne peut pas mettre deux exceptions avec un lien hierarchique entre elles dans le meme multicatch
		 try {
		      System.out.println(Integer.parseInt(args[1]));
		   } catch (NumberFormatException | IllegalArgumentException e) {
		      System.out.println("Missing or invalid input");
		   } 
	}
	
	public void doesNotCompile() { 
		try {
			mightThrow();
		} catch (FileNotFoundException | IllegalStateException e) {
		} catch (InputMismatchException e | MissingResourceException e) { // deux fois e
		} catch (FileNotFoundException | IllegalStateException e) { // Duplicate FileNotFoundException already caugh
		} catch (Exception e) {
		} catch (IOException e) { // IOException extends Exception // Unreachable bloc
		}
	}
	private void mightThrow() throws DateTimeParseException, IOException { }
	
}
