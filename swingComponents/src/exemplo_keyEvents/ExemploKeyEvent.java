package exemplo_keyEvents;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExemploKeyEvent extends JFrame {
	
	private JLabel lblCenario;
	private JLabel lblBomberman;
	private int posX = 400;
	private int posY = 100;
	
	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	
	private List<JLabel> bombermanLeft = new ArrayList<JLabel>();
	private List<JLabel> bombermanRight = new ArrayList<JLabel>();
	private List<JLabel> bombermanUp = new ArrayList<JLabel>();
	private List<JLabel> bombermanDown = new ArrayList<JLabel>();
	
	public ExemploKeyEvent() {
		super("Exemplo ImageIcon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		
		ImageIcon iconCenario = new ImageIcon(getClass().getResource("/images/background.jpg"));
		lblCenario = new JLabel(iconCenario);
		lblCenario.setBounds(0, 0, iconCenario.getIconWidth(), iconCenario.getIconHeight());
		
		
		carregarImagens();
		
		bombermanDown.get(0).setBounds(posX, posY, 34, 50);
		
		/*ImageIcon icon = new ImageIcon(getClass().getResource("/images/bomberman-abaixo-1.png"));
		lblBomberman = new JLabel(icon);
		lblBomberman.setBounds(posX, posY, icon.getIconWidth(), icon.getIconHeight());*/
		
		
		getContentPane().add(bombermanDown.get(0));
		getContentPane().add(lblCenario);
		
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
				switch(e.getKeyCode()) {
		        	case KeyEvent.VK_UP -> upPressed = true;
		        	case KeyEvent.VK_DOWN -> downPressed = true;
		        	case KeyEvent.VK_LEFT -> leftPressed = true;
		        	case KeyEvent.VK_RIGHT -> rightPressed = true;
				}
		    atualizarPosicao();
			}
		});
		
		//addMouseListener()
		
		setBounds(100, 100, iconCenario.getIconWidth(), iconCenario.getIconHeight());
		setVisible(true);
	}
	
	private void carregarImagens() {
		for (int i = 0; i < 3; i++) {
			bombermanLeft.add(new JLabel(new ImageIcon(getClass().getResource("/images/bomberman-esquerda-"+(i+1)+".png"))));
			bombermanRight.add(new JLabel(new ImageIcon(getClass().getResource("/images/bomberman-direita-"+(i+1)+".png"))));
			bombermanUp.add(new JLabel(new ImageIcon(getClass().getResource("/images/bomberman-acima-"+(i+1)+".png"))));
			bombermanDown.add(new JLabel(new ImageIcon(getClass().getResource("/images/bomberman-abaixo-"+(i+1)+".png"))));
		}
	}
	
	private void atualizarPosicao() {
	    if(upPressed) posY-=5;
	    if(downPressed) posY+=5;
	    if(leftPressed) posX-=5;
	    if(rightPressed) posX+=5;
	    
	    bombermanDown.get(0).setLocation(posX, posY);
	}

	public static void main(String[] args) {
		ExemploKeyEvent ex1 = new ExemploKeyEvent();

	}

}
