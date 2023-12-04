package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoordinateTest {

	@Test
	void testMove() {
		//sin desplazar
		//condiciones de la prueba
		int x = 0,y=0;
		Coordinate coordinate=new Coordinate(x, y);
		int offsetX=0,offsetY=0;
		//esperados
		int expectedX=0,expectedY=0;
		//experimento
		coordinate.move(offsetX, offsetY);
		//aseveraciones
		assertEquals(expectedX, coordinate.getX());
		assertEquals(expectedY, coordinate.getY());
//		desplazamiento izquierda,abajo
		offsetX=-1;
		offsetY=-1;
		coordinate=new Coordinate(x, y);
		expectedX=-1;expectedY=-1;
		coordinate.move(offsetX, offsetY);
		assertEquals(expectedX, coordinate.getX());
		assertEquals(expectedY, coordinate.getY());
	}

}
