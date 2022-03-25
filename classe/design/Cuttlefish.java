package ocp.classe.design;


class Cuttlefish {
    private String name = "swimmy";
    
    { System.out.println(name); }
    
    private static int COUNT = 0;
    
    static { System.out.println(COUNT); }
    
    { COUNT++; System.out.println(COUNT); }
 
    public Cuttlefish() {
       System.out.println("Constructor");
   }

   public static void main(String[] args) {
      System.out.println("Ready");
      new Cuttlefish();
  }
}

// 0 Ready swimmy  1 Constructor

// ou est main ? in Cuttlefish
// init class Cuttlefish
					// init variables de class 
					// init static blocks
// exec main
// new Cuttlefich() = init instance Cuttlefich
										// init variable d'instance
										// init blocs
										// init constructors en commençant par celui qui contient this() ou super()