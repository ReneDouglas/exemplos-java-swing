
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ExemploForm extends JFrame{
	
	private JPanel panelPrincipal;
	private JPanel panelFormulario;
	private JPanel panelInformacoes;
	
	JTextField fieldNome;
	
	private JLabel lblNomeDisplay;
	private JLabel lblEmailDisplay;
	private JLabel lblTelefoneDisplay;
	private JLabel lblCidadeDisplay;
	
	public ExemploForm() {
		super("Exemplo Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 200);
		
		panelPrincipal = new JPanel(new GridLayout(1, 2, 8, 8));
		panelFormulario = new JPanel(new GridLayout(5, 1, 5, 5));
		panelInformacoes = new JPanel(new GridLayout(4, 1, 5, 5));
		
		panelInformacoes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelPrincipal.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		
		desenharFormulario();
		desenharInformacoes();
		
		panelPrincipal.add(panelFormulario);
		panelPrincipal.add(panelInformacoes);
		
		setContentPane(panelPrincipal);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void desenharFormulario() {
		
		JLabel lblNome = new JLabel("Nome", JLabel.RIGHT);
		JTextField fieldNome = new JTextField();
		panelFormulario.add(lblNome);
		panelFormulario.add(fieldNome);
		
		JLabel lblEmail = new JLabel("Email", JLabel.RIGHT);
		JTextField fieldEmail = new JTextField();
		panelFormulario.add(lblEmail);
		panelFormulario.add(fieldEmail);
		
		JLabel lblPhone = new JLabel("Telefone", JLabel.RIGHT);
		JTextField fieldPhone = new JTextField();
		panelFormulario.add(lblPhone);
		panelFormulario.add(fieldPhone);
		
		JLabel lblCidade = new JLabel("Cidade", JLabel.RIGHT);
		JTextField fieldCidade = new JTextField();
		panelFormulario.add(lblCidade);
		panelFormulario.add(fieldCidade);
		
		JLabel emptyLbl = new JLabel();
		JButton btnEnviar = new JButton("Enviar");
		
		btnEnviar.addActionListener(action -> {
			lblNomeDisplay.setText(fieldNome.getText());
			lblEmailDisplay.setText(fieldEmail.getText());
			lblTelefoneDisplay.setText(fieldPhone.getText());
			lblCidadeDisplay.setText(fieldCidade.getText());
		});
		
		panelFormulario.add(emptyLbl);
		panelFormulario.add(btnEnviar);
		
		
	}
	
	public void desenharInformacoes() {
		
		JLabel lblNome = new JLabel("Nome:", JLabel.RIGHT);
		lblNomeDisplay = new JLabel("", JLabel.CENTER);
		panelInformacoes.add(lblNome);
		panelInformacoes.add(lblNomeDisplay);
		
		JLabel lblEmail = new JLabel("Email:", JLabel.RIGHT);
		lblEmailDisplay = new JLabel("", JLabel.CENTER);
		panelInformacoes.add(lblEmail);
		panelInformacoes.add(lblEmailDisplay);
		
		JLabel lblPhone = new JLabel("Telefone:", JLabel.RIGHT);
		lblTelefoneDisplay = new JLabel("", JLabel.CENTER);
		panelInformacoes.add(lblPhone);
		panelInformacoes.add(lblTelefoneDisplay);
		
		JLabel lblCidade = new JLabel("Cidade:", JLabel.RIGHT);
		lblCidadeDisplay = new JLabel("", JLabel.CENTER);
		panelInformacoes.add(lblCidade);
		panelInformacoes.add(lblCidadeDisplay);
		
	}

	public static void main(String[] args) {
		ExemploForm ex1 = new ExemploForm();

	}

}
