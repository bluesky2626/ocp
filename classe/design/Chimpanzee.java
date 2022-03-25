package ocp.classe.design;


class Primate {
	public Primate() {
		System.out.print("Primate-");
	}
}

class Ape extends Primate {
	public Ape(int fur) {
		System.out.print("Ape1-");
	}
	public Ape() {
		System.out.print("Ape2-");
	}
}

public class Chimpanzee extends Ape {
	public Chimpanzee() {
		super(2);
		System.out.print("Chimpanzee-");
	}
	public static void main(String[] args) {
		new Chimpanzee();
	}
}

// init class Ape, init class Primate => rien  => exec main => init instance Chimanzee
// => init instance Primate => print "Primate-"
// => init instance Ape => aucun constructeur n'est appelé parce qu'ils ne contiennent pas un super() ou un this()
// => init instance Chimpanzee =>  print Ape1  (super(2))
//                             => "Chimpanzee-"
				
