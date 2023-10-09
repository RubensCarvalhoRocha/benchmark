package estruturas;

import java.util.ArrayList;
import java.util.Collections;

public class BuscaBinaria {
    
    public static int comparacoesBuscaBinaria = 0;
 
     public void InserirVetorDinamico(ArrayList<String> palavrasLimpas) {
         
        ArrayList<String> vetorDinamico = new ArrayList<>();

            for (String palavra : palavrasLimpas) {
                
            
            int posicao = buscaBinaria(vetorDinamico, palavra);

            if (posicao == -1) {
                vetorDinamico.add(palavra);
                Collections.sort(vetorDinamico);
                
            }
        }
    }
     
      public static int buscaBinaria(ArrayList<String> listaOrdenada, String alvo) {
        int esquerda = 0;
        int direita = listaOrdenada.size() - 1;

        while (esquerda <= direita) {
            comparacoesBuscaBinaria++;
            int meio = esquerda + (direita - esquerda) / 2;
            int comparacao = alvo.compareTo(listaOrdenada.get(meio));

            if (comparacao == 0) {
                return meio; // Encontrou a palavra
            } else if (comparacao < 0) {
                direita = meio - 1; // A palavra está à esquerda
            } else {
                esquerda = meio + 1; // A palavra está à direita
            }
        }

        return -1; // A palavra não foi encontrada
    }
    
}
