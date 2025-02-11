package exemplo_multiplas_janelas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExemploMultiplasTelas extends JFrame{
	
	public ExemploMultiplasTelas() {
		super("Exemplo JLabel e Icon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setBounds(100, 100, 800, 600);
		
		JPanel panel = new JPanel(new GridLayout(7,1,8,8));
		
		JButton btn1 = new JButton("Outro JFrame");
		btn1.addActionListener(e -> {
			dispose();
			new OutroJFrame();
		});
		panel.add(btn1);
		
		JButton btn2 = new JButton("Abrindo JDialog");
		btn2.addActionListener(e -> {
			new OutroJDialog(this);
		});
		panel.add(btn2);
		JButton btn3 = new JButton("show inputDialog 1");
		btn3.addActionListener(e -> {
			
			String nome = (String) JOptionPane.showInputDialog(
					null,
					"Por favor, escolha um nome",
					"Exemplo 1",
					JOptionPane.QUESTION_MESSAGE,
					null,
					new String[] {
							"Fred",
							"Colin",
							"Peter",
							"Joe",
							"Mike"},
					"Joe");
			System.out.println("Nome escolhido: " + nome);
		});
		panel.add(btn3);
		JButton btn4 = new JButton("show inputDialog 2");
		btn4.addActionListener(e -> {
			String nome = (String) JOptionPane.showInputDialog(
					null,
					"Por favor, digite o seu nome",
					"Exemplo 2",
					JOptionPane.QUESTION_MESSAGE,
					null,
					null,
					"Renê");
			System.out.println("Nome digitado: " + nome);
		});

		panel.add(btn4);
		JButton btn5 = new JButton("show messageDialog");
		btn5.addActionListener(e -> {
			JOptionPane.showMessageDialog(
					null,
					"Tenha um ótimo dia!",
					"Exemplo 3",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(getClass().getResource("/images/bomberman-abaixo-1.png"))
					);
		});
		panel.add(btn5);
		
		JButton btn6 = new JButton("show confirmDialog");
		btn6.addActionListener(e -> {
			int escolha = JOptionPane.showConfirmDialog(
					null,
					"Você tem certeza?",
					"Exemplo 4",
					JOptionPane.YES_NO_CANCEL_OPTION);
			System.out.println("Opção escolhida: " + escolha);
		});
		panel.add(btn6);
		
		JButton btn7 = new JButton("Warning, Info, Error, etc..");
		btn7.addActionListener(e -> {
			
			JOptionPane.showMessageDialog(
					null,
					"Mensagem de cuidado!",
					"Atenção!",
					JOptionPane.ERROR_MESSAGE);
		});
		panel.add(btn7);
		
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		
		setContentPane(panel);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		ExemploMultiplasTelas ex1 = new ExemploMultiplasTelas();

	}

}
