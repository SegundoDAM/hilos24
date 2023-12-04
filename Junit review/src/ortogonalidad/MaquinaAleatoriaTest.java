package ortogonalidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaquinaAleatoriaTest {

	@Test
	void testDameNumero() {
		MaquinaAleatoria maquinaAleatoria=new MaquinaAleatoria();
		//condiciones iniciales
		int[] min= {-1,-5,0,5}, 
			  max= {9,-1,0,1};
		//experados
		int expected[]= 
			       {-1,-1,-1,-1};
		//experimento		//aseveraciones
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], maquinaAleatoria.dameNumero(min[i], max[i]));
			System.out.println("caso "+i);
		}

		
	}

}
