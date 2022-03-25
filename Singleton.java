package design.pattern.singleton;

public class Singleton {

	private static Singleton INSTANCE;
	
	private Singleton() {
		
	}
	
	public Singleton getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new Singleton();
		}
		return INSTANCE;
	}
}
