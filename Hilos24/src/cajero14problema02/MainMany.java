package cajero14problema02;

import java.util.List;

public class MainMany {

	public static void main(String[] args) {

		List<Cliente> clientes = List.of(new Cliente("Cliente 1", new int[] { 2, 2, 1 }),
				new Cliente("Cliente 2", new int[] { 2, 2, 1 }), new Cliente("Cliente 3", new int[] { 2, 2, 1 }));
		Caja cajero1 = new Caja("Cajero 1");
		clientes.forEach((cliente) -> {
			cajero1.procesarCompra(cliente, 1);
		});
		//que pasa si hay dos cajas?
		// usaremos una cola
	}

}
