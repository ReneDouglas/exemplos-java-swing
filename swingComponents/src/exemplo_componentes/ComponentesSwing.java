package exemplo_componentes;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComponentesSwing extends JFrame{
	
	public ComponentesSwing() {
		super("Exemplo ImageIcon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setBounds(100, 100, 800, 600);
		
		JTextField textField = new JTextField();
		textField.setBounds(10, 10, 100, 30);
		add(textField);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 50, 100, 100);
		add(textArea);
		
		JCheckBox checkBox = new JCheckBox();
		checkBox.setBounds(10, 150, 30, 30);
		add(checkBox);
		
		String s1[] = {"Masculino", "Feminino"};
		JComboBox cb = new JComboBox(s1);
		cb.setBounds(10, 200, 120, 30);
		add(cb);
		
		JRadioButton radio1 = new JRadioButton("Java", false);
		JRadioButton radio2 = new JRadioButton("C#", false);
		JRadioButton radio3 = new JRadioButton("Python", false);
		
		radio1.setBounds(10, 230, 70, 30);
		radio2.setBounds(10, 260, 70, 30);
		radio3.setBounds(10, 290, 70, 30);
		
		add(radio1);
		add(radio2);
		add(radio3);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(radio1);
		grupo.add(radio2);
		grupo.add(radio3);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		ComponentesSwing ex1 = new ComponentesSwing();

	}

}
