
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HelloWorldFrame extends JFrame{
	
	private JLabel label;
	private JPanel contentPane;
	
	public HelloWorldFrame() {
		super("Olá Swing - exemplo 2");
		setBounds(0, 0, 800, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		label = new JLabel("Clique aqui: ");
		label.setBounds(100, 100, 100, 50);
		getContentPane().add(label);
		
		JButton btn = new JButton("Clicar");
		btn.setBounds(200, 100, 150, 50);
		
		//getContentPane().add(btn);
		

		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		HelloWorldFrame frame = new HelloWorldFrame();
	}

}


