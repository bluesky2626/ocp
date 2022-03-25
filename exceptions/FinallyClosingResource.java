package ocp.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Resource : external data source
// Souvent, on ouvre une connexion à une resource, read/write , close .
// Qu'est-ce qui peut arriver si on ne la ferme pas ?
// 	- ex. sur une database : on peut utiliser toutes les connexions disponibles rendant ainsi la base inaccessible

// Resource leak : quand un programme n'arrive pas a fermer ses connexions aux ressources qui deviennent inaccessibles

//
public class FinallyClosingResource {

	public void readFile(String path) {
		FileInputStream in = null;

		try {
			in = new FileInputStream(path);
			// Read
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println(in);
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// Le meme code avec try-with-resource
	public void readFileNewGeneration(String path) {

		try (FileInputStream in = new FileInputStream(path)){
			// Read
		} catch (FileNotFoundException e) {
			e.printStackTrace();   // throws du new
		} catch (IOException e1) { // throws du close()
			e1.printStackTrace();
		} 
		// implicit finally block
	}

	// Rule 1: try-with-resource peut se passer du CATCH et FINALLY blocks
	public void readFileNewGenerationBis(String path) throws IOException{

		try (FileInputStream in = new FileInputStream(path)){
			// Read
		}

	}

	// Rule 2: le finally implicit that closes the connexion is run BEFORE the finally du programmer
	public void readFileNewGenerationBisBis(String path) throws IOException{

		try (FileInputStream in = new FileInputStream(path)){
			// Read
		}finally {
			
			System.out.println("Hello");
			
		}

	}
	
	// Rule 3: La class qu'on met dans le try-with-resource must implement AutoClosable interface 
	
	// Rule 4: On déclare pas deux instance de la meme classe dans un seul bloc try
	public void readFileNewGenerationBisBisBis(String path) throws IOException{

		// Cela est permis
		File is = new File(""), os = new File("");
		//Mais 
		try (FileInputStream isis = new FileInputStream(""),
				osss = new FileInputStream("")){ //  DO NOT COMPILE
			// Read
		}
		
		// ça marche avec ;
		try (FileInputStream isis = new FileInputStream("");
				FileInputStream osss = new FileInputStream("")){ 
			// Read
		}
		

	}
	// qui contient la methode close()
	public static void main(String[] args) {

		FinallyClosingResource finaly = new FinallyClosingResource();
		finaly.readFile("D:\\X182928\\JAVA-FOR-ME\\inputFile.txt");
	}

}
