package comienzo01;

public class Comienzo5 {
	public static void main(String[] args) throws InterruptedException {
		Thread vamos = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					System.out.println("Pa habernos matao");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		vamos.start();
//		Thread.sleep(1000);
//		vamos.stop();
//		vamos.suspend();
//		Thread.sleep(1000);
//		vamos.resume();
//		vamos.destroy();
		
	}

}
