package caja2024clientesColaMArketHorario06;

import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

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

	public void procesarCompra(Cliente cliente, int timeStamp) {
		Instant older = Instant.now();
//		System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
//				+ cliente.getNombre() + " EN EL TIEMPO: " + older.getEpochSecond() + "seg");

		esperarXsegundos(timeStamp);
//		System.out.println("El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + cliente.getNombre()
//		 + " EN EL TIEMPO: " + Duration.between(older, Instant.now()) + "seg");

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
		Cliente cliente = null;
		do {
//			System.out.println("buscando clientes " + getNombre());
			try {
				cliente = cola.get();
//				System.out.println("cliente aleatorio "+cliente);
				if (cliente != null) {
					procesarCompra(cliente, 1);
//					 System.out.println("salgo del wait");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (cliente != null);
//		Logger.getGlobal().log(Level.INFO,"cierro, no hay clientes "+getNombre());
		System.out.println("termino caja");
	}

}