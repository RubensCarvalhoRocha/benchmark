/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruturas;

import bo.Coleta;
import java.util.ArrayList;
import java.util.Collections;

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

    public static void main(String[] args) {
        // Suponha que você já tenha o ArrayList de palavras limpas ordenadas
        Coleta coleta = new Coleta(); // Suponha que Coleta seja a classe onde obterPalavrasLimpasOrdenadas está definido
        ArrayList<String> palavrasLimpasOrdenadas = coleta.obterPalavrasLimpasOrdenadas(palavrasLimpas);

        // Crie a instância da BuscaBinariaVetorDinamico com o ArrayList de palavras limpas ordenadas
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

