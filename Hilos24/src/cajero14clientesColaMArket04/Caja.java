package cajero14clientesColaMArket04;

import java.time.Duration;
import java.time.Instant;

//solo hay una caja
public class Caja implements Runnable {

	private String nombre;
	private Cola cola;

	public Caja(String nombre, Cola cola) {
		this.nombre = nombre;
		this.cola = cola;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void procesarCompra(Cliente cliente, long timeStamp) {
		System.out.println("Demora base " + timeStamp);
		Instant now = Instant.now();
		Instant older = now;
		System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
				+ cliente.getNombre() + " EN EL TIEMPO: " + older.getEpochSecond() + "seg");

		for (int i = 0; i < cliente.getCarroCompra().length; i++) {
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			System.out.println("Procesado el producto " + (i + 1) + " ->Tiempo: "
					+ Duration.between(now, now = Instant.now()).getSeconds() + "seg");
		}

		System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + cliente.getNombre()
				+ " EN EL TIEMPO: " + Duration.between(older, now) + "seg");
	}

	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	@Override
	public void run() {
		do {
//			System.out.println("buscando clientes");
			if (!cola.isEmpty()) {
//				System.out.println("procesa compra");
				procesarCompra(cola.poll(), 1);
			}
//			System.out.println("cola vacia "+cola.clientes.isEmpty());
//			esperarXsegundos(3);
		} while (true);
	}

}