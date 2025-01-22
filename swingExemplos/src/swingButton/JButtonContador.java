package swingButton;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JButtonContador extends JFrame{
	
	private int cliques = 0;
	private JLabel lblQtdCliques;
	
	public JButtonContador() {
		super("Contador");
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton jb = new JButton("Clicar");
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cliques += 1;
				lblQtdCliques.setText("" + cliques);
			}
		});
		
		JLabel lblInfo = new JLabel("Quantidade de cliques:");
		lblQtdCliques = new JLabel("" + cliques);
		lblQtdCliques.setPreferredSize(new Dimension(50, 30));
		
		add(jb);
		add(lblInfo);
		add(lblQtdCliques);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		JButtonContador frame = new JButtonContador();

	}

}
