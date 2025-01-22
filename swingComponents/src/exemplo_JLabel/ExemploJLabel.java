package exemplo_JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ExemploJLabel extends JFrame{
	
	public ExemploJLabel() {
		super("Exemplo JLabel e Icon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setBounds(100, 100, 800, 600);
		
		JPanel panel = new JPanel(new GridLayout(3,1,8,8));
		
		JLabel lbl1 = new JLabel("Exemplo de JLabel 1", JLabel.CENTER);
		lbl1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lbl1.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lbl1);
		
		JLabel lbl2 = new JLabel("Exemplo de JLabel 2", JLabel.RIGHT);
		lbl2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.add(lbl2);
		
		JLabel lbl3 = new JLabel("<html>line 1<p><font color=blue size=+2>"
				+ "big blue</font> line 2<p>line 3</html>");
		lbl3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.add(lbl3);
		
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		
		setContentPane(panel);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		ExemploJLabel ex1 = new ExemploJLabel();

	}

}
