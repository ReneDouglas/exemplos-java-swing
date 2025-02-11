package threads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MovimentoThread extends JPanel implements Runnable{
	
	private int x = 400;
    private int y = 300;
    private int dx = 0;
    private int dy = 10;
    private final int DIAMETRO = 50;
    private boolean movendoVertical = true;
    private Clip ballEffect;
    private Clip backgroundTheme;
	
	public MovimentoThread() {
		
		carregarSom();
		
		backgroundTheme.loop(Clip.LOOP_CONTINUOUSLY);
		
		JButton botaoHorizontal = new JButton("Mover Horizontal");
        JButton botaoVertical = new JButton("Mover Vertical");
        botaoHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movendoVertical = false;
                dx = 10; 
                dy = 0;
            }
        });
       botaoVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                movendoVertical = true;
                dx = 0; 
                dy = 10;
            }
        });
       botaoVertical.setBounds(10, 10, 150, 30);
       botaoHorizontal.setBounds(10, 40, 150, 30);
       add(botaoHorizontal);
       add(botaoVertical);
       
       Thread thread = new Thread(this);
       thread.start();
	}
	
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x, y, DIAMETRO, DIAMETRO);
    }

	@Override
	public void run() {
		while (true) {

            x += dx;
            y += dy;

            if (movendoVertical) {
                if (y <= 0 || y + DIAMETRO >= getHeight()) {
                    dy = -dy; 
                    tocarSom();
                }
            } else {
                if (x <= 0 || x + DIAMETRO >= getWidth()) {
                    dx = -dx; 
                    tocarSom();
                }
            }
            
            repaint();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
	}
	
	private void carregarSom() {
		try {
            InputStream ballEfectStream = getClass().getResourceAsStream("/sounds/ball-effect.wav");
            InputStream backgroundThemeStream = getClass().getResourceAsStream("/sounds/background-theme.wav");
            if (ballEfectStream == null || backgroundThemeStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado!");
            }
            AudioInputStream ballEffectAIS = AudioSystem.getAudioInputStream(ballEfectStream);
            ballEffect = AudioSystem.getClip();
            ballEffect.open(ballEffectAIS);
            
            AudioInputStream backgroundThemeAIS = AudioSystem.getAudioInputStream(backgroundThemeStream);
            backgroundTheme = AudioSystem.getClip();
            backgroundTheme.open(backgroundThemeAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao carregar o áudio!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
	}
	
	private void tocarSom() {
        if (ballEffect != null) {
        	ballEffect.setFramePosition(0);
        	ballEffect.start();
        }
    }
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bola Móvel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        MovimentoThread painel = new MovimentoThread();
        frame.add(painel);

        frame.setVisible(true);

	}

}
