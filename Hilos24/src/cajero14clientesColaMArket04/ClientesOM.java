package cajero14clientesColaMArket04;

import java.util.Optional;
import java.util.Random;

public class ClientesOM {

	public static Optional<Cliente> getRandomClient() {
		return Optional.of(new Cliente("cliente "+new Random().nextInt(100), new int[] {1,1,1}));
	}
	public static Optional<Cliente> getRandomClientPossiblyNull() {
		Cliente retorno=new Cliente("cliente "+new Random().nextInt(100), new int[] {1,1,1});
		return new Random().nextBoolean()?Optional.ofNullable(retorno):Optional.ofNullable(null);
	}
	
	public void dimequesi(int condicion,int dos) {
		boolean resultado=condicion>dos;
		 String cosa=resultado?"es verdadero":"es falso";
	}
}
