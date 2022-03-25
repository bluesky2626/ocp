package ocp.part2.concurrency;

public class PrintData implements Runnable {

	@Override
	public void run() {
		System.out.println("Do some work - Print Data");
	}

	public static void main(String[] args) {
		Runnable task = new PrintData();
		Thread th = new Thread(task);
		th.start();
		
		//Equivalent to 
		Thread th1 = new Thread(() -> System.out.println("Do some other work"));
		th1.start();
		
		
		
		/*
		int a = 10 ,b = 8;
		int i, x, y , result ;
		x = a;
		y = b;
		while(x != y) {
			if(x < y) {
				x = x + a;
				System.out.println();
			}else {
				y = y + b;
			}
		
		}*/
		
		/*	result = x;
		System.out.println(result);
		//System.out.println("a="+ a + " i="+i);
		
		int ii = 1, som = 0;
		do {
			som = som + ii;
			ii = ii+1;
			System.out.println("ii = "+ ii);

		}while(ii<10);
		System.out.println("ii = "+ ii);
		System.out.println("som = "+ som);
	int somme = 0;
		for(i = 1 ; i <= 9; i++) {
			somme = somme + i;
			System.out.println(i);
		}
		
		System.out.println(somme);
		
		System.out.println(1+2+3+4+5+6+7+8+9);*/
	}

}
