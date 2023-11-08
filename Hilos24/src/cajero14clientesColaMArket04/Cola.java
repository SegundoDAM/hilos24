package cajero14clientesColaMArket04;

import java.util.ArrayDeque;
import java.util.Optional;

public class Cola {
//	public ConcurrentLinkedQueue<Cliente> clientes=new ConcurrentLinkedQueue<>();
	public ArrayDeque<Cliente> clientes=new ArrayDeque<>();

	public void push(Optional<Cliente> randomClient) {
//		System.out.println("cliente creado"+randomClient);
//		System.out.println("size "+clientes.size());
		randomClient.ifPresent((cliente)->clientes.push(cliente));
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