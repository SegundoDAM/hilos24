package caja2024clientesColaMArket05Synchro;

import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MainRunnable implements Runnable{
	Cola cola=new Cola();
	Caja cajero1 = new Caja("Cajero 1",cola);
	Caja cajero2 = new Caja("Cajero 2",cola);
	
	public static void main(String[] args) {
		MainRunnable superMercado=new MainRunnable();
		//primero probamos sin arrancar el hilo del super
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(superMercado);
		executorService.shutdown();
	}
	public MainRunnable() {
		super();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(cajero1);
		executorService.execute(cajero2);
		executorService.shutdown();
		
	}


	@Override
	public void run() {
		do {			
			System.out.println("creando cliente");
			if(!cola.isBigger(10))
			cola.put(ClientesOM.getRandomClient());
			wasteTime(150000);
		}while(true);
		
	}
	private void wasteTime(int i) {
		String cString="";
		for (int j = 0; j < i; j++) {
			cString+="a";
		}
		
	}

}
