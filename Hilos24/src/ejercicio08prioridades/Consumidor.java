package ejercicio08prioridades;

public class Consumidor extends Thread {
	private ContenedorSincronizado contenedor;

	public Consumidor(ContenedorSincronizado c) {
		contenedor = c;
	}

	public void run() {
		int value = 0;
		System.out.println("comenzando el hilo "+getName());
		for (int i = 0; i < 10; i++) {
			value = contenedor.get();
			System.out.println("Consumidor "+getName()+" . get: " + value);
			try {
				sleep(40);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
