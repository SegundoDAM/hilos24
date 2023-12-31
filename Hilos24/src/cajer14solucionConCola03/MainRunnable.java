package cajer14solucionConCola03;

import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MainRunnable {

	public static void main(String[] args) {

//		List<Cliente> clientes = List.of(new Cliente("Cliente 1", new int[] { 2, 2, 1 }),
//				new Cliente("Cliente 2", new int[] { 2, 2, 1 }),
//				new Cliente("Cliente 3", new int[] { 2, 2, 1 }),
//				new Cliente("Cliente 4", new int[] { 2, 2, 1 }),
//				new Cliente("Cliente 5", new int[] { 2, 2, 1 }),
//				new Cliente("Cliente 6", new int[] { 2, 2, 1 }),
//				new Cliente("Cliente 7", new int[] { 2, 2, 1 }));
//		ArrayDeque<Cliente> collect = clientes.stream()
//				.collect(Collectors.toCollection(ArrayDeque::new));
//		Cola cola=new Cola(collect);
		Cola cola=new Cola();
		Caja cajero1 = new Caja("Cajero 1",cola);
		Caja cajero2 = new Caja("Cajero 2",cola);
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(cajero1);
		executorService.execute(cajero2);
		executorService.shutdown();
	}

}
