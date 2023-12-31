package caja2024clientesColaMArketHorario06;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

public class MainRunnable implements Runnable {
	Cola cola = new Cola();
	Caja cajero1 = new Caja("Cajero 1", cola);
	Caja cajero2 = new Caja("Cajero 2", cola);
	Logger logger;

	public static void main(String[] args) throws SecurityException, IOException {
		MainRunnable superMercado = new MainRunnable();
		// primero probamos sin arrancar el hilo del super
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(superMercado);
		// si no lo pones no cierra el programa
		executorService.shutdown();
	}

	public MainRunnable() throws SecurityException, IOException {
		super();
//		Logger logger = Logger.getLogger("runnable");
		logger = Logger.getLogger("main");
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(cajero1);
		executorService.execute(cajero2);
		executorService.shutdown();
		// Configura un FileHandler para escribir logs en un archivo llamado
		// "mi_aplicacion.log"
		FileHandler fileHandler = new FileHandler("miaplicacion.log");

		// Establece un formateador para dar formato a los mensajes de registro
		SimpleFormatter formatter = new SimpleFormatter();
		fileHandler.setFormatter(formatter);

		// Agrega el FileHandler al logger
		logger.addHandler(fileHandler);
//        van a consola los mensajes de menor nivel que Warning
		logger.setLevel(Level.INFO);
	}

	@Override
	public void run() {
		do {

			if (!cola.totalClientesAlcanzado()) {
				cola.put(ClientesOM.getRandomClient());
//				System.out.println("creando cliente hay "+cola.size()+" clientes"+" total:"+cola.totalClientesAlcanzado());
				wasteTime(5000);
			}
		} while (!cola.totalClientesAlcanzado());
//		System.out.println("teminando");
		logger.warning("terminado");
		logger.log(Level.INFO,"cosas");
		System.out.println("termino market");

	}

	private void wasteTime(int i) {
		String cString = "";
		for (int j = 0; j < i; j++) {
			cString += "a";
		}

	}

}
