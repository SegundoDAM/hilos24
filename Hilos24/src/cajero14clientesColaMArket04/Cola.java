package cajero14clientesColaMArket04;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Cola {
	//He utilizado un cola concurrente que bloquea el acceso 
	//al resto de hilos. mirad que pasa
	//luego habilitad la linea 59 de la clase caja y observa como cambia
	public ConcurrentLinkedQueue<Cliente> clientes=new ConcurrentLinkedQueue<>();
//	public ArrayDeque<Cliente> clientes=new ArrayDeque<>();

	public void push(Optional<Cliente> randomClient) {
//		System.out.println("cliente creado"+randomClient);
//		System.out.println("size "+clientes.size());
		randomClient.ifPresent((cliente)->clientes.add(cliente));
	}

	public boolean isBigger(int i) {
		return clientes.size()>i;
	}

	public boolean isEmpty() {
		return clientes.isEmpty();
	}

	public Cliente poll() {
		return this.clientes.poll();
	}

	
}
