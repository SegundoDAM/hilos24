package ejercicio08prioridades;
public class ProductorConsumidor {
	
	public static void main(String[] args) {
		ContenedorSincronizado c = new ContenedorSincronizado();
		Productor produce = new Productor(c);
		Consumidor consume = new Consumidor(c);
		Consumidor consumez = new Consumidor(c);
		Consumidor consumezz = new Consumidor(c);
		
		produce.start();
		consume.start();
		consumez.start();
		consumezz.start();
		
	}
}
