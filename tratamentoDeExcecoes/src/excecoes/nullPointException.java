package excecoes;

import java.util.Iterator;

public class nullPointException {

	public static void main(String[] args) {
	
		int vetor[] = new int[10];
		
		try {
			for (int i = 0; i < 15; i++) {
				vetor[i] = i;
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Erro ao preencher vetor.");
			System.out.println("Mensagem: " + ex.getMessage());
			System.out.println("Causa: " + ex.getCause());
			System.out.println("Mensagem localizada: " + ex.getLocalizedMessage());
		}
		
		
		

	}

}
