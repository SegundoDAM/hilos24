package cajero14clientesColaMArket04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainRunnable implements Runnable {
	Cola cola = new Cola();
	Caja cajero1 = new Caja("Cajero 1", cola);
	Caja cajero2 = new Caja("Cajero 2", cola);

	public static void main(String[] args) {
		MainRunnable superMercado = new MainRunnable();
		// primero probamos sin arrancar el hilo del super
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(superMercado);
		executorService.shutdown();
	}

	public MainRunnable() {
		super();
		

	}

	@Override
	public void run() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(cajero1);
		executorService.execute(cajero2);
		executorService.shutdown();
		do {
//			System.out.println("creando cliente");
			if (!cola.isBigger(1)) {
//				System.out.println("is lesser into if "+cola.isBigger(10));
				cola.push(ClientesOM.getRandomClient());
			}
			// con esta cantidad funciona bien
			wasteTime(5000);
			// con esta ya falla mucho porque hay sondeo
//			wasteTime(150000);
		} while (true);
//		System.out.println("fin del main");

	}

	private void wasteTime(int i) {
		String cString = "";
		for (int j = 0; j < i; j++) {
			cString += "a";
		}

	}

}
