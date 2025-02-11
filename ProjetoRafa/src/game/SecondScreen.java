package game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecondScreen extends JPanel implements KeyListener {
    private Player player;
    private NPC[] npcs;
    private String currentMessage; // Armazena a mensagem atual a ser exibida
    private NPC currentNpc; // Armazena o NPC atual que está interagindo
    private Image backgroundImage; // Imagem de fundo do mapa
    private String dialogMessage; // Mensagem atual do diálogo
    private boolean isDialogActive; // Indica se o diálogo está ativo

    // Lista de blocos de colisão
    private List<CollisionBlock> collisionBlocks;

    // Referência para o JFrame principal
    private JFrame parentFrame;

    public SecondScreen(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.BLACK); // Fundo preto (será coberto pela imagem)
        this.setFocusable(true);
        addKeyListener(this);

        // Posiciona o jogador na parte inferior da tela
        player = new Player(400, 500);

        // Criando NPCs para a segunda tela
        npcs = new NPC[]{
            new ChallengeNPC(200, 300),
            // Adicione mais NPCs aqui
        };

        // Inicializa a lista de blocos de colisão
        collisionBlocks = new ArrayList<>();

        // Adiciona blocos de colisão para as bordas do mapa
        collisionBlocks.add(new CollisionBlock(0, 0, 800, 20)); // Borda superior
        collisionBlocks.add(new CollisionBlock(0, 580, 800, 20)); // Borda inferior
        collisionBlocks.add(new CollisionBlock(0, 0, 20, 600)); // Borda esquerda
        collisionBlocks.add(new CollisionBlock(780, 0, 20, 600)); // Borda direita

        // Carregar a imagem de fundo da segunda tela
        try {
            backgroundImage = ImageIO.read(new File("Imagens\\TELA 2.png")); // Substitua pelo caminho da sua imagem
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a imagem de fundo da segunda tela.");
        }
    }

    // Método para verificar colisões
    private boolean isColliding(Rectangle bounds) {
        for (CollisionBlock block : collisionBlocks) {
            if (block.getBounds().intersects(bounds)) {
                return true; // Há colisão
            }
        }
        return false; // Não há colisão
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha a imagem de fundo redimensionada para ocupar toda a tela
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }

        // Desenha os blocos de colisão
        for (CollisionBlock block : collisionBlocks) {
            block.draw(g);
        }

        // Desenha o jogador
        player.draw(g);

        // Desenha os NPCs
        for (NPC npc : npcs) {
            npc.draw(g);

            // Verifica se o jogador está perto do NPC
            if (npc.isPlayerNear(player.getX(), player.getY())) {
                currentMessage = npc.getMessage(); // Atualiza a mensagem atual
                currentNpc = npc; // Armazena o NPC atual
            }
        }

        // Exibe a mensagem atual na tela, acima do NPC
        if (currentMessage != null && currentNpc != null) {
            g.setColor(Color.WHITE); // Cor do texto
            g.drawString(currentMessage, currentNpc.getX(), currentNpc.getY() - 10); // Texto acima do NPC
        }

        // Desenha a caixa de diálogo se estiver ativa
        if (isDialogActive) {
            drawDialogBox(g);
        }
    }

    // Método para desenhar a caixa de diálogo
    private void drawDialogBox(Graphics g) {
        int boxWidth = getWidth() - 40; // Largura da caixa de diálogo
        int boxHeight = 100; // Altura da caixa de diálogo
        int boxX = 20; // Posição X da caixa de diálogo
        int boxY = getHeight() - boxHeight - 20; // Posição Y da caixa de diálogo

        // Desenha o fundo da caixa de diálogo
        g.setColor(new Color(0, 0, 0, 200)); // Preto semi-transparente
        g.fillRect(boxX, boxY, boxWidth, boxHeight);

        // Desenha a borda da caixa de diálogo
        g.setColor(Color.WHITE);
        g.drawRect(boxX, boxY, boxWidth, boxHeight);

        // Desenha a mensagem do diálogo
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", Font.PLAIN, 16);
        g.setFont(font);

        // Quebra a mensagem em várias linhas se necessário
        String[] lines = dialogMessage.split("\n");
        int lineHeight = g.getFontMetrics().getHeight();
        int textY = boxY + 30;

        for (String line : lines) {
            g.drawString(line, boxX + 20, textY);
            textY += lineHeight;
        }
    }

    @Override
public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();

    int newX = player.getX();
    int newY = player.getY();

    if (key == KeyEvent.VK_UP) {
        newY -= 10;
    } else if (key == KeyEvent.VK_DOWN) {
        newY += 10;
    } else if (key == KeyEvent.VK_LEFT) {
        newX -= 10;
    } else if (key == KeyEvent.VK_RIGHT) {
        newX += 10;
    } else if (key == KeyEvent.VK_E) { // Tecla "E" para interagir
        if (currentNpc != null) {
            dialogMessage = currentNpc.interact(); // Executa a interação do NPC
            isDialogActive = true; // Ativa a caixa de diálogo
        }
    } else if (key == KeyEvent.VK_ESCAPE) { // Tecla "ESC" para fechar o diálogo
        isDialogActive = false; // Desativa a caixa de diálogo
    }

    // Verifica se a nova posição colide com algum bloco
    Rectangle newBounds = new Rectangle(newX, newY, player.getBounds().width, player.getBounds().height);
    if (!isColliding(newBounds)) {
        player.move(newX - player.getX(), newY - player.getY());
    }

    // Verifica se o jogador atingiu as coordenadas para voltar à primeira tela
    if (player.getX() >= 390 && player.getX() <= 420 && player.getY() >= 520) {
        System.out.println("Jogador atingiu as coordenadas de retorno. Voltando para a primeira tela...");

        // Cria a primeira tela (GamePanel) e define a posição e direção do jogador
        GamePanel firstScreen = new GamePanel(parentFrame);
        firstScreen.setPlayerPosition(420, 40); // Define a posição do jogador
        firstScreen.setPlayerDirection(1); // Define a direção do jogador como "para baixo"

        // Transporta o jogador de volta para a primeira tela
        parentFrame.getContentPane().removeAll();
        parentFrame.add(firstScreen);
        parentFrame.revalidate();
        parentFrame.repaint();
        parentFrame.transferFocus();
        
    }

    // Exibe as coordenadas do jogador no console
    System.out.println("Jogador está em: (" + player.getX() + ", " + player.getY() + ")");

    // Limpa a mensagem e o NPC atual quando o jogador se move
    currentMessage = null;
    currentNpc = null;

    repaint();
}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}