/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturas;

import bo.Coleta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class BuscaBinaria {
        private ArrayList<String> palavrasOrdenadas;

    public BuscaBinaria(ArrayList<String> palavrasOrdenadas) {
        this.palavrasOrdenadas = palavrasOrdenadas;
    }

    public boolean buscaBinaria(String palavra) {
        int esquerda = 0;
        int direita = palavrasOrdenadas.size() - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            int comparacao = palavra.compareTo(palavrasOrdenadas.get(meio));

            if (comparacao == 0) {
                return true; // A palavra foi encontrada no vetor
            } else if (comparacao < 0) {
                direita = meio - 1;
            } else {
                esquerda = meio + 1;
            }
        }

        return false; // A palavra não foi encontrada no vetor
    }

    public void adicionarPalavra(String palavra) {
        if (!buscaBinaria(palavra)) {
            // A palavra não está no vetor, então a adicionamos.
            palavrasOrdenadas.add(palavra);
            // Como o vetor está ordenado, precisamos reordená-lo após a adição.
            Collections.sort(palavrasOrdenadas);
        }
    }

    public void imprimirPalavras() {
        for (String palavra : palavrasOrdenadas) {
            System.out.println(palavra);
        }
    }

    public void executarColeta() {
        // Suponha que você já tenha o ArrayList de palavras limpas ordenadas
        Coleta coleta = new Coleta(); // Suponha que Coleta seja a classe onde obterPalavrasLimpasOrdenadas está definido
        ArrayList<String> palavrasLimpasOrdenadas = null; // Inicialize a variável fora do bloco try-catch

        try {
            // Chamar o método coletarStopWords
            Set<String> stopWords = coleta.coletarStopWords();

            // Chamar o método coletarPalavras
            ArrayList<String> palavras = coleta.coletarPalavras();

            // Chamar o método removerStopWords, passando as palavras coletadas e as stop words como argumentos
            ArrayList<String> palavrasLimpas = coleta.removerStopWords(palavras, stopWords);

            // Chamar o método obterPalavrasLimpasOrdenadas, passando as palavrasLimpas coletadas. 
            palavrasLimpasOrdenadas = coleta.obterPalavrasLimpasOrdenadas(palavrasLimpas);
            for (String palavra : palavrasLimpasOrdenadas) {
                System.out.println(palavra);
            }

        } catch (IOException e) {
            // Trate a exceção, se necessário
        }

        // Crie a instância da BuscaBinaria com o ArrayList de palavras limpas ordenadas
        BuscaBinaria vetor = new BuscaBinaria(palavrasLimpasOrdenadas);

        // Adicione algumas palavras ao vetor
        vetor.adicionarPalavra("maçã");
        vetor.adicionarPalavra("banana");
        vetor.adicionarPalavra("abacaxi");

        // Imprima o vetor
        vetor.imprimirPalavras();

        // Tente adicionar uma palavra já existente
        vetor.adicionarPalavra("banana");

        // Imprima o vetor novamente
        vetor.imprimirPalavras();
    }
}

