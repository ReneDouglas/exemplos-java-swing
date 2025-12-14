
public class ExemploThread2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + " - Valor: " + i);

           try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrompida!");
            }
        }
		
	}

}
