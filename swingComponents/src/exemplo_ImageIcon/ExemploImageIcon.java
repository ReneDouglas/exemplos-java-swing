package exemplo_ImageIcon;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExemploImageIcon extends JFrame{
	
	public ExemploImageIcon() {
		super("Exemplo ImageIcon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setBounds(100, 100, 800, 600);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/bomberman-abaixo-1.png"));
		JLabel lbl = new JLabel(icon);
		lbl.setBounds(400, 100, icon.getIconWidth(), icon.getIconHeight());
		
		getContentPane().add(lbl);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		ExemploImageIcon ex1 = new ExemploImageIcon();

	}

}
