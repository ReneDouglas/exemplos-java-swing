
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JButtonEvents {
	
	public static void main(String[] args) {
		
		JButton jb = new JButton("Press Me");
		jb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("ActionEvent!");
				
			}
		});
		jb.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ev) {
				System.out.println("ChangeEvent!");
			}
		});
		jb.setBounds(50, 100, 100, 30);
		
		
		
		JFrame f = new JFrame( );
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.getContentPane( ).add(jb);
		f.setBounds(200, 200, 200, 200);
		f.setVisible(true);
	}
}
