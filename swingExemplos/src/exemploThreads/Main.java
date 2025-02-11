package exemploThreads;

public class Main {

	public static void main(String[] args) {
	
		/*ExemploThread1 t1 = new ExemploThread1("t1");
		ExemploThread1 t2 = new ExemploThread1("t2");
		
		t1.start();
		t2.start();
		
		ExemploThread2 obj = new ExemploThread2();
		Thread t3 = new Thread(obj);
		t3.start();*/
		TelaComThread frame = new TelaComThread();
		Thread t1 = new Thread(frame);
		t1.start();

	}

}
