package swingExemplo1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldSwing {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Olá Swing");
		final JLabel label = new JLabel("Hello World!");
		frame.getContentPane().add(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}

