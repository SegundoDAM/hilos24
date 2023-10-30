package future12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EjecutorTareas00 {
	public static void main(String[] args) {
		// crea y nombra cada objeto Runnable
		//Comparar con Ejecutor00 de teoriahilosv11
		TareaImprimir tarea1 = new TareaImprimir("tarea1");
		TareaImprimir tarea2 = new TareaImprimir("tarea2");
		TareaImprimir tarea3 = new TareaImprimir("tarea3");
		System.out.println("Iniciando Executor");
		// crea objeto ExecutorService para administrar los subprocesos
		ExecutorService ejecutorSubprocesos = Executors.newCachedThreadPool();
		Future<String> submitResponse = ejecutorSubprocesos.submit(tarea1);
		Future<String> submitResponse2 = ejecutorSubprocesos.submit(tarea2);
		Future<String> submitResponse3 = ejecutorSubprocesos.submit(tarea3);
		ejecutorSubprocesos.shutdown();
		try {
			//esperando la respuesta del Callable
			System.out.println("submit response "+submitResponse.get());
			System.out.println("submit response "+submitResponse2.get());
			System.out.println("submit response "+submitResponse3.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("Tareas iniciadas, main termina.\n");
	}
}
