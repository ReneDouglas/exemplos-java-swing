package swingExemplo1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class CalculadoraV2 extends JFrame{
	
	private JLabel resultado;
	
	public CalculadoraV2() {
		super("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel display = new JPanel();
		resultado = new JLabel();
		resultado.setBackground(Color.GRAY);
		display.setPreferredSize(new Dimension(getWidth(), 30));
		display.add(resultado);
		getContentPane().add(display, BorderLayout.NORTH);
		
		JPanel teclado = new JPanel();
		teclado.setLayout(new GridLayout(0, 4));
		
		JButton n7 = new JButton("7");
		n7.addActionListener(e -> {
			
		});
		JButton n8 = new JButton("8");
		JButton n9 = new JButton("9");
		JButton div = new JButton("/");
		JButton n4 = new JButton("4");
		JButton n5 = new JButton("5");
		JButton n6 = new JButton("6");
		JButton mult = new JButton("*");
		JButton n1 = new JButton("1");
		JButton n2 = new JButton("2");
		JButton n3 = new JButton("3");
		JButton sub = new JButton("-");
		JButton zero = new JButton("0");
		JButton dec = new JButton(".");
		JButton resolver = new JButton("=");
		JButton adicao = new JButton("+");
		
		teclado.add(n7);
		teclado.add(n8);
		teclado.add(n9);
		teclado.add(div);
		teclado.add(n4);
		teclado.add(n5);
		teclado.add(n6);
		teclado.add(mult);
		teclado.add(n1);
		teclado.add(n2);
		teclado.add(n3);
		teclado.add(sub);
		teclado.add(zero);
		teclado.add(dec);
		teclado.add(resolver);
		teclado.add(adicao);
		
		getContentPane().add(teclado, BorderLayout.CENTER);
		
		setBounds(100, 100, 200, 200);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		CalculadoraV2 calc = new CalculadoraV2();
	}

}
