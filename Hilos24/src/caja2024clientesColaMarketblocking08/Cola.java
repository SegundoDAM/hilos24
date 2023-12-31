package caja2024clientesColaMarketblocking08;

import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;

public class Cola {
	public LinkedBlockingQueue<Cliente> clientes = new LinkedBlockingQueue<Cliente>();
	private int totalClientes = 0;

	private boolean push(Optional<Cliente> randomClient) {
		randomClient.ifPresent((cliente) -> {
			clientes.add(cliente);
			totalClientes++;
		});
		return randomClient.isPresent();
	}

	public boolean isBigger(int i) {
		return clientes.size() > 10;
	}

	public Cliente get() throws InterruptedException {
		return clientes.poll();
	}

	public void put(Optional<Cliente> optional) {
		push(optional);
	}

	public boolean totalClientesAlcanzado() {
		return totalClientes > 2000;
	}

	public int size() {
		return clientes.size();
	}

	public boolean isEmpty() {
		return clientes.isEmpty();
	}

	public int getTotalClientes() {
		return totalClientes;
	}
}
