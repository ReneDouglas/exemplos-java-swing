package bomberman;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Exemplo de uso de eventos de teclado (KeyListener) em Java Swing.
 * Esta classe demonstra como capturar teclas pressionadas e movimentar
 * um personagem (Bomberman) na tela com animação baseada na direção.
 */
public class BombermanKeyEvent extends JFrame {
	
	// Labels para exibir o cenário e o personagem
	private JLabel lblCenario;
	private JLabel lblBomberman;
	
	// Coordenadas da posição atual do personagem na tela
	private int posX = 400;
	private int posY = 100;
	
	// Índice para controlar qual frame da animação será exibido (0, 1 ou 2)
	private int labelIndex = 0;
	
	// Constante que define quantos pixels o personagem se move por tecla pressionada
	private final int STEP = 8;
	
	// Variáveis booleanas para rastrear quais teclas direcionais estão pressionadas
	private boolean upPressed = false;
	private boolean downPressed = false;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	
	// Listas que armazenam os frames de animação do Bomberman para cada direção
	// Cada lista contém 3 imagens que criam o efeito de caminhada
	private List<ImageIcon> bombermanLeft = new ArrayList<ImageIcon>();
	private List<ImageIcon> bombermanRight = new ArrayList<ImageIcon>();
	private List<ImageIcon> bombermanUp = new ArrayList<ImageIcon>();
	private List<ImageIcon> bombermanDown = new ArrayList<ImageIcon>();
	
	/**
	 * Construtor da classe - inicializa a janela e configura todos os componentes.
	 */
	public BombermanKeyEvent() {
		super("Exemplo ImageIcon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // Centraliza a janela na tela
		setLayout(null); // Layout absoluto para posicionamento manual
		
		// Carrega e configura a imagem de fundo (cenário)
		/**
		 * Para carregar imagens e sons em Java Swing, é comum utilizar o método
		 * getResource() da classe ClassLoader. Este método busca o recurso (imagem,
		 * som, etc.) no classpath da aplicação.
		 * Crie uma pasta "resources" na raiz do projeto e dentro dela crie a
		 * estrutura de pastas "images" para armazenar as imagens utilizadas.
		 * Certifique-se de que as imagens estejam corretamente posicionadas em
		 * "resources/images/".
		 * Não esqueça de adicionar a pasta "resources" como fonte de recursos no
		 * build path do seu projeto, para que o Java possa encontrá-las em tempo de
		 * execução.
		 */
		ImageIcon iconCenario = new ImageIcon(getClass().getResource("/images/background.jpg"));
		lblCenario = new JLabel(iconCenario);
		lblCenario.setBounds(0, 0, iconCenario.getIconWidth(), iconCenario.getIconHeight());
		
		// Carrega todas as imagens de animação do Bomberman
		carregarImagens();

		// Cria o label do Bomberman com a primeira imagem (olhando para baixo)
		lblBomberman = new JLabel(bombermanDown.get(0));
		lblBomberman.setBounds(posX, posY, 34, 50);
		
		// Adiciona os componentes ao painel (bomberman deve ficar acima do cenário)
		getContentPane().add(lblBomberman);
		getContentPane().add(lblCenario);
		
		// Adiciona um listener para capturar eventos do teclado
		addKeyListener(new KeyListener() {
			
			/**
			 * Método chamado quando uma tecla é digitada (pressionada e solta)
			 * Não utilizado neste exemplo
			 */
			@Override
			public void keyTyped(KeyEvent e) {
				// Não implementado
			}
			
			/**
			 * Método chamado quando uma tecla é solta
			 * Marca a respectiva direção como não pressionada
			 */
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
		        	case KeyEvent.VK_UP -> upPressed = false;
		        	case KeyEvent.VK_DOWN -> downPressed = false;
		        	case KeyEvent.VK_LEFT -> leftPressed = false;
		        	case KeyEvent.VK_RIGHT -> rightPressed = false;
				}
				atualizarPosicao();
			}
			
			/**
			 * Método chamado quando uma tecla é pressionada
			 * Marca a respectiva direção como pressionada e atualiza a posição
			 */
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
				
		setBounds(100, 100, iconCenario.getIconWidth(), iconCenario.getIconHeight());
		setVisible(true);
	}
	
	/**
	 * Carrega todas as imagens do Bomberman para cada direção.
	 * Para cada direção, carrega 3 frames de animação (numerados de 1 a 3)
	 * criando o efeito de caminhada do personagem.
	 */
	private void carregarImagens() {
		for (int i = 0; i < 3; i++) {
			// Carrega os 3 frames para cada direção
			bombermanLeft.add(new ImageIcon(getClass().getResource("/images/bomberman-esquerda-"+(i+1)+".png")));
			bombermanRight.add(new ImageIcon(getClass().getResource("/images/bomberman-direita-"+(i+1)+".png")));
			bombermanUp.add(new ImageIcon(getClass().getResource("/images/bomberman-acima-"+(i+1)+".png")));
			bombermanDown.add(new ImageIcon(getClass().getResource("/images/bomberman-abaixo-"+(i+1)+".png")));
		}
	}
	
	/**
	 * Atualiza a posição do Bomberman na tela baseado nas teclas pressionadas.
	 * Este método também controla a animação, alternando entre os 3 frames
	 * da direção correspondente para criar o efeito de caminhada.
	 */
	private void atualizarPosicao() {

		// Reseta o índice da animação quando passa do último frame (0, 1, 2)
		if (labelIndex > 2) labelIndex = 0;

		// Verifica cada direção e atualiza posição + imagem correspondente
		if (upPressed) {
	        posY -= STEP; // Move para cima (diminui Y)
			lblBomberman.setIcon(bombermanUp.get(this.labelIndex));
	    }
	    if (downPressed) {
	        posY += STEP; // Move para baixo (aumenta Y)
			lblBomberman.setIcon(bombermanDown.get(this.labelIndex));
	    }
	    if (leftPressed) {
	        posX -= STEP; // Move para esquerda (diminui X)
			lblBomberman.setIcon(bombermanLeft.get(this.labelIndex));
	    }
	    if (rightPressed) {
	        posX += STEP; // Move para direita (aumenta X)
			lblBomberman.setIcon(bombermanRight.get(this.labelIndex));
		}

		// Avança para o próximo frame da animação
		labelIndex++;
		
		// Atualiza a posição do label na tela
		lblBomberman.setLocation(posX, posY);
	}

	public static void main(String[] args) {
		BombermanKeyEvent ex1 = new BombermanKeyEvent();

	}

}
