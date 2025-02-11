package tratamentoDeExcecoes;

public class ExcecoesEmCadeia {

    public static void main(String[] args) {
        try {
            metodo1();
        } catch (Exception e) {
            // Exibe a exceção capturada e sua causa
            System.out.println("Exceção capturada: " + e.getMessage());
            System.out.println("Causa raiz: " + e.getCause().getMessage());
            e.printStackTrace();
        }
    }

    static void metodo1() throws Exception {
        try {
            metodo2();
        } catch (Exception e) {
            // Lança uma nova exceção com a exceção original como causa
            throw new Exception("Erro no método 1", e);
        }
    }

    static void metodo2() throws Exception {
        try {
            metodo3();
        } catch (Exception e) {
            // Lança uma nova exceção com a exceção original como causa
            throw new Exception("Erro no método 2", e);
        }
    }

    static void metodo3() throws Exception {
        // Simula um erro no método 3
        throw new ArithmeticException("Divisão por zero no método 3");
    }
}
