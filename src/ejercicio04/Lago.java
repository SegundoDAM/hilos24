package ejercicio04;

public class Lago {

	private static Lago instancia = new Lago();
	private int vida = 0;

	private Lago() {
	}

	public int getVida() {
		return vida;
	}

	public static Lago getInstance() {
		return instancia;
	}

	public synchronized void incrementarVida() {
		vida++;
		notify();
	}

	public synchronized void beber() {
		while (isVacio()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		notify();
		vida--;
	}

	public boolean isVacio() {
		return vida == 0;
	}
}
