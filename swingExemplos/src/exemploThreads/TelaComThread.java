package exemploThreads;

import javax.swing.JFrame;

public class TelaComThread extends JFrame implements Runnable{

	public TelaComThread() {
		super("Exemplo ImageIcon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setBounds(100, 100, 800, 600);
		setVisible(true);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Thread ativa!");
		}
		
	}

}
