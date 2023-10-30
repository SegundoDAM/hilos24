package ejercicio04;

import java.time.Duration;
import java.time.Instant;

public class Ser extends Thread {

	int vida;
	int tamano = 0;
	String nombre;

	public Ser(String nombre, int vida) {
		this.vida = vida;
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getTamano() {
		return tamano;
	}

	public void setTamano(int tamano) {
		this.tamano = tamano;
	}

	@Override
	public String toString() {
		return "tiene de vida " + vida + " y de tamano " + tamano;
	}

	@Override
	public void run() {
		System.out.println("Llego aqui " + nombre);
		while (tamano < vida) {
			Instant now = Instant.now();
			Lago.getInstance().beber();
			tamano++;
			System.out.println("creci uno");
			System.out.println(nombre);
			System.out.println("he tardado "+(Duration.between(Instant.now(), now)));
		}
		System.out.println("muriendo con tamano " + tamano);
	}

}
