package cajer14solucionConCola03;

import java.util.ArrayDeque;

public class Cola {
//	public ConcurrentLinkedQueue<Cliente> clientes=new ConcurrentLinkedQueue<>();
	public ArrayDeque<Cliente> clientes;

	public Cola(ArrayDeque<Cliente> clientes) {
		super();
		this.clientes = clientes;
	}

	public Cola() {
		super();
		this.clientes=new ArrayDeque<>();
	}

	
}
