package exemplo_multiplas_janelas;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class OutroJFrame extends JFrame{
	
	public OutroJFrame() {
		super("Outra tela");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(100, 100, 300, 200);
		
		JButton voltar = new JButton("Voltar");
		voltar.addActionListener(e -> {
			dispose();
			new ExemploMultiplasTelas();
		});
		voltar.setBounds(150, 100, 100, 40);
		add(voltar);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
