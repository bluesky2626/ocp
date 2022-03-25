package ocp.ch7.methods.encapsulation;

class AnyClass {
	public int z ;
	public String s;
	private int u;
	
	public void setU(int u) {
		this.u = u;
	}
	
	public int getU() {
		return u;
	}
}
public class Main {
	

	
	public static void main(String[] args) {
		int x = 4;
		String y = "first";

		changeX(x);
		System.out.println(x);

		changeY(y);
		System.out.println(y);
		
		StringBuilder name = new StringBuilder();
		name.append("first StringBuilder");
		changeName(name);
		System.out.println(name);
		
		AnyClass any = new AnyClass();
		any.z = 1;
		changeAnyClass(any);
		System.out.println(any.z);
		
		
		AnyClass anyU = new AnyClass();
		anyU.setU(1);
		setAnyClass(anyU);
		System.out.println(anyU.getU());


		anyU.s = "Bonjour";
		anyU.z = 5;
		changeS(anyU);
		
		System.out.println(anyU.s);
		System.out.println(anyU.z);

	}
	
	public static void changeX(int copyX) {
		copyX = 8;
	}
	
	public static void changeY(String copyY) {
		copyY = "second";
	}
	
	public static void changeName(StringBuilder name) {
		name.append("second StringBuilder");
	}
	

	public static void changeAnyClass(AnyClass anyCopy) {
		AnyClass otherObject = new AnyClass();
		otherObject.z = 2;
		
		anyCopy = otherObject;
		anyCopy.z = 3;
	}

	public static void setAnyClass(AnyClass anyCopy) {
		anyCopy.setU(3);
	}
	
	public static void changeS(AnyClass anyCopy) {
		anyCopy.z = 10;
		anyCopy.s = "Re bonjour";
	}
}
