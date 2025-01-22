package exemplo_multiplas_janelas;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class OutroJDialog extends JDialog{
	
	public OutroJDialog(JFrame telaPai) {
		super(telaPai, "modal", true);
		setSize(150, 150);
		setLocationRelativeTo(telaPai);
		setVisible(true);
	}

}
