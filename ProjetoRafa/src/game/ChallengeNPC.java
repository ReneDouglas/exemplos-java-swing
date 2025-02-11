package game;

import javax.swing.JOptionPane;

public class ChallengeNPC extends NPC {
    private String question; // Pergunta do desafio
    private String correctAnswer; // Resposta correta
    private String rewardMessage; // Mensagem de recompensa
    private String hintMessage; // Mensagem de dica

    // Caminhos dos sprites
    private static final String[] SPRITE_PATHS = {
        "Imagens\\velho.png",    // Sprite para cima
        "Imagens\\velho.png",  // Sprite para baixo
        "Imagens\\velho.png",  // Sprite para esquerda
        "Imagens\\velho.png"  // Sprite para direita
    };

    // Mensagens do NPC
    private static final String INITIAL_MESSAGE = "Olá! Vamos testar seus conhecimentos sobre IF e ELSE.";
    private static final String QUESTION = "O que o comando 'else' faz em um bloco 'if'?";
    private static final String CORRECT_ANSWER = "Executa se a condição do 'if' for falsa";
    private static final String REWARD_MESSAGE = "Parabéns! Você acertou! Aqui está sua recompensa: +10 pontos.";
    private static final String HINT_MESSAGE = "Dica: O 'else' é executado quando a condição do 'if' não é atendida.";

    public ChallengeNPC(int x, int y) {
        super(x, y, INITIAL_MESSAGE, SPRITE_PATHS);
        this.question = QUESTION;
        this.correctAnswer = CORRECT_ANSWER;
        this.rewardMessage = REWARD_MESSAGE;
        this.hintMessage = HINT_MESSAGE;
    }

    @Override
    public String interact() {
        // Exibe a pergunta do desafio em uma caixa de diálogo
        String userAnswer = JOptionPane.showInputDialog(null, question, "Desafio do NPC", JOptionPane.QUESTION_MESSAGE);

        // Verifica se a resposta do jogador está correta
        if (userAnswer != null && userAnswer.equalsIgnoreCase(correctAnswer)) {
            return rewardMessage; // Resposta correta
        } else {
            return hintMessage; // Resposta incorreta (dica)
        }
    }
}
