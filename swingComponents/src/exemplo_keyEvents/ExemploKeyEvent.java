package exemplo_keyEvents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExemploKeyEvent extends JFrame {
	
	private JLabel lblBomberman;
	private int posX = 400;
	private int posY = 100;
	
	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	
	public ExemploKeyEvent() {
		super("Exemplo ImageIcon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		setBounds(100, 100, 800, 600);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/images/bomberman-abaixo-1.png"));
		lblBomberman = new JLabel(icon);
		lblBomberman.setBounds(posX, posY, icon.getIconWidth(), icon.getIconHeight());
		
		getContentPane().add(lblBomberman);
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				//System.out.println("keyTyped");
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
		        	case KeyEvent.VK_UP -> upPressed = false;
		        	case KeyEvent.VK_DOWN -> downPressed = false;
		        	case KeyEvent.VK_LEFT -> leftPressed = false;
		        	case KeyEvent.VK_RIGHT -> rightPressed = false;
				}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				/*if(e.getKeyCode() == KeyEvent.VK_UP) {
					upPressed = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					downPressed = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					leftPressed = true;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					rightPressed = true;
					
				}
				lbl.setLocation(posX, posY);*/
				switch(e.getKeyCode()) {
		        	case KeyEvent.VK_UP -> upPressed = true;
		        	case KeyEvent.VK_DOWN -> downPressed = true;
		        	case KeyEvent.VK_LEFT -> leftPressed = true;
		        	case KeyEvent.VK_RIGHT -> rightPressed = true;
				}
		    atualizarPosicao();
			}
		});
		
		setVisible(true);
	}
	
	private void atualizarPosicao() {
	    if(upPressed) posY-=5;
	    if(downPressed) posY+=5;
	    if(leftPressed) posX-=5;
	    if(rightPressed) posX+=5;
	    
	    lblBomberman.setLocation(posX, posY);
	}

	public static void main(String[] args) {
		ExemploKeyEvent ex1 = new ExemploKeyEvent();

	}

}
