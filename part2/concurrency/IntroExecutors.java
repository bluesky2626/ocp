package ocp.part2.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IntroExecutors {

	public static void main(String[] args) {

		ExecutorService service = null;
		
		Runnable task1 = () -> System.out.println("Printing zoo inventory");
		
		Runnable task2 = () -> {
			for(int i = 0; i<3; i++) {
				System.out.println("record "+ i);
			}
		};
		
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			
			System.out.println("Begin");
			service.execute(task1);
			service.execute(task2);
			service.execute(task1);
			System.out.println("End");
		} finally {
			if(service != null ) {
				service.shutdown();
			}
		}

	}

}
