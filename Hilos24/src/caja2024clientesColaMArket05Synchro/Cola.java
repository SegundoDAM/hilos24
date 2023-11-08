package caja2024clientesColaMArket05Synchro;

import java.util.ArrayDeque;
import java.util.Optional;


public class Cola {
//	public ConcurrentLinkedQueue<Cliente> clientes=new ConcurrentLinkedQueue<>();
	public ArrayDeque<Cliente> clientes = new ArrayDeque<>();

	public void push(Optional<Cliente> randomClient) {
		randomClient.ifPresent((cliente) -> clientes.push(cliente));
	}

	public boolean isBigger(int i) {
		return clientes.size() > 10;
	}

	public synchronized Cliente get() throws InterruptedException {
		while (clientes.isEmpty()) {
			wait();
		}
		return clientes.pop();
	}

	public synchronized void put(Optional<Cliente> optional) {
		push(optional);
		notifyAll();
	}
}
