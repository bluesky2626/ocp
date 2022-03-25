package ocp.classe.design;

class FinalThings {
	
	// Rule 1 : les variable d'instance finales doivent absolument etre initialis�e
	// TRICK 1
	private final int type ;     // DO NOT COMPILE
								   // Java s'attend � ce que type soit initialis�e 
	
	// TRICK 2
	public FinalThings() {	// DO NOT COMPILE
		
	}
								// PK ? java s'attendait � ce que le constructeur initialise la variable d'instance finale : type
	
	// Solution 1: 
	private final int type = 1;
	
	// Solution 2: 
	private final int type1;
	{
		type1 = 1;
	}
	
	// Solution 3: 
	private final int type2;
	public FinalThings() {
		type2 =  1;
	}
	
	// Rule 2 :Les variables d'instances locales, pas necessairement initialis�e
	void lambdaMethod() {
		final int localFinal; 
	}
	
}


class TrickFinal {
	private final int volume;
	
	public TrickFinal(int volume) {
		this.volume = volume;
	}
	
	public TrickFinal() {  // DO NOT COMPILE
		
	}
	// Java croit que volume n'est  pas initialis�e parce qu'il prend chaque constructeur independement 
	
}