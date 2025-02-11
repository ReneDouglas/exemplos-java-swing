package exemploThreads;

public class ExemploThread1 extends Thread{
	
	public ExemploThread1(String nome) {
		super(nome);
	}
	
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
