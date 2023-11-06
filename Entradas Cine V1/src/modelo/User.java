package modelo;

import java.util.concurrent.Callable;

public class User implements Callable<Reference> {
	private String id;
	private Pit pit;
	private Reference randomReference;
	
	public User(String id, Pit pit) {
		super();
		this.id = id;
		this.pit = pit;
	}

	@Override
	public Reference call() {
		boolean takeSeat = false;
		do {
			// aqui obtengo el asiento que quiero
			randomReference = Reference.getRandomReference();
			// Pedir la reserva de asiento
			takeSeat = pit.takeSeat(randomReference);
		} while (!takeSeat);
		return randomReference;
	}

	public Reference getRandomReference() {
		return randomReference;
	}

}
