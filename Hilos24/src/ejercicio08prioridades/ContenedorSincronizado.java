package ejercicio08prioridades;
public class ContenedorSincronizado {
	//Esta clase contenedor permite la sincronizacion
	private int dato=0;
	private boolean hayDato = false;

	public synchronized int get() {
		while (hayDato == false) {
			try {
				// espera a que el productor coloque un valor
				//Suspende el hilo hasta que hay una señal de notify
				wait();
			} catch (InterruptedException e) {
			}
		}
		hayDato = false;
		// notificar que el valor ha sido consumido
		notifyAll();
		return dato;
	}
// La clausula synchonized permite gestionar wait y notify
	//tambien vale para que nadie más acceda a este recurso
	//De esta forma evitamos que dos objetos que compartiesen
	//el contenedor y que pudieran usar put() y hacer inestable 
	//el valor dado a dato
	public synchronized void put(int valor) {
		while (hayDato == true) {
			try {
				// espera a que se consuma el dato
				wait();
			} catch (InterruptedException e) {
			}
		}
		dato = valor;
		hayDato = true;
		// notificar que ya hay dato.
		notifyAll();
	}
}
