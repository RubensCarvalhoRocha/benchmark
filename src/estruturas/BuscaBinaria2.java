package estruturas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import bo.Coleta;

public class BuscaBinaria2 {
 
     public static void main() {
        // Criando um ArrayList de inteiros
        ArrayList<String> vetorDinamico = new ArrayList<>();
        
        Coleta coleta = new Coleta();
        
        try {
            // Chamar o método coletarStopWords
            Set<String> stopWords = coleta.coletarStopWords();
            // Chamar o método coletarPalavras
            ArrayList<String> palavras = coleta.coletarPalavras();
            // Chamar o método removerStopWords, passando as palavras coletadas e as stop words como argumentos
            ArrayList<String> palavrasLimpas = coleta.removerStopWords(palavras, stopWords);

             for (String palavra : palavrasLimpas) {
                if (!vetorDinamico.contains(palavra)) {
                    // A palavra não foi encontrada no vetor dinâmico, então a adicionamos
                    vetorDinamico.add(palavra);
                }
            }

        } catch (IOException e) {}
        
     }
     
      public static int buscaBinaria(ArrayList<String> listaOrdenada, String alvo) {
        int esquerda = 0;
        int direita = listaOrdenada.size() - 1;

        while (esquerda <= direita) {
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
