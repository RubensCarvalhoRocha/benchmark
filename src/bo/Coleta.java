/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrator
 */
public class Coleta {

    public Set<String> coletarStopWords() throws IOException {
        // Cria um conjunto vazio para armazenar as stop words.
        Set<String> stopWords = new HashSet<>();

        // Início do bloco try-catch para tratamento de exceções de E/S (IOException).
        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\WorkSpace\\Faculdade\\EstruturaDeDados2\\benchmark\\src\\Arquivos\\stopwords.txt"))) {
            // Declaração de uma variável para armazenar cada linha do arquivo.
            String linha;

            // Enquanto houver linhas para ler no arquivo.
            while ((linha = br.readLine()) != null) {
                // Remove espaços em branco no início e no final da linha e converte para minúsculas.
                linha = linha.trim().toLowerCase();

                // Adiciona a palavra processada ao conjunto stopWords.
                stopWords.add(linha);
            }
        } // Fim do bloco try-catch.

        // Retorna o conjunto stopWords contendo todas as stop words do arquivo.
        return stopWords;
    }

    //Apenas para verificar se as stopWords estão sendo buscadas no arquivo:
    public void imprimirStopWords(Set<String> stopWords) {
        for (String palavra : stopWords) {
            System.out.println(palavra);
        }
    }

    //Apenas para verificar se as stopWords estão sendo buscadas no arquivo:
    public static void main(String[] args) throws IOException {
        Coleta coleta = new Coleta();
        Set<String> stopWords = coleta.coletarStopWords();

        // Chama o método para imprimir as stop words
        coleta.imprimirStopWords(stopWords);
    }

public ArrayList<String> coletarPalavras() {
    ArrayList<String> palavras = new ArrayList<>();

    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Texto (.txt)", "txt");
    fileChooser.setFileFilter(filter);
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result = fileChooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();

        try (FileReader fileReader = new FileReader(selectedFile); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Dividir a linha em palavras usando a expressão regular [\\s\\p{Punct}]+
                String[] words = line.split("[\\s\\p{Punct}]+|\\d+");
                for (String word : words) {
                    // Transformar a palavra em minúsculas e adicionar à lista de palavras
                    word = word.toLowerCase();
                    if (!word.isEmpty()) { // Certifique-se de que a palavra não está vazia após a filtragem
                        palavras.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Nenhum arquivo selecionado");
    }

    return palavras;
}


    // Método que recebe uma lista de palavras e um conjunto de stop words e retorna uma lista de palavras limpas.
    public ArrayList<String> removerStopWords(ArrayList<String> palavras, Set<String> stopWords) {
        // Cria uma nova ArrayList para armazenar as palavras limpas.
        ArrayList<String> palavrasLimpas = new ArrayList<>();

        // Itera através de cada palavra na lista de entrada 'palavras'.
        for (String palavra : palavras) {
            // Verifica se a palavra não está presente no conjunto de stop words antes de adicioná-la às palavras limpas.
            if (!stopWords.contains(palavra)) {
                // Se a palavra não estiver nas stop words, ela é adicionada à lista de palavras limpas.
                palavrasLimpas.add(palavra);
            }
        }

        // Retorna a lista de palavras limpas após o processamento.
        return palavrasLimpas;

    }

    public ArrayList<String> obterPalavrasLimpasOrdenadas(ArrayList<String> palavrasLimpas) {
        // Copia as palavras limpas para o ArrayList palavrasLimpasOrdenadas
        ArrayList<String> palavrasLimpasOrdenadas = new ArrayList<>(palavrasLimpas);

        // Chama o método de ordenação (Quicksort)
        quickSort(palavrasLimpasOrdenadas, 0, palavrasLimpasOrdenadas.size() - 1);

        return palavrasLimpasOrdenadas;
    }

    public void quickSort(ArrayList<String> palavras, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(palavras, inicio, fim);
            quickSort(palavras, inicio, indicePivo - 1);
            quickSort(palavras, indicePivo + 1, fim);
        }
    }

    public int particionar(ArrayList<String> palavras, int inicio, int fim) {
        String pivo = palavras.get(fim);
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {
            if (palavras.get(j).compareTo(pivo) < 0) {
                i++;
                String temp = palavras.get(i);
                palavras.set(i, palavras.get(j));
                palavras.set(j, temp);
            }
        }

        String temp = palavras.get(i + 1);
        palavras.set(i + 1, palavras.get(fim));
        palavras.set(fim, temp);

        return i + 1;
    }
    
    public ArrayList<FrequenciaPalavra> contarFrequencia(ArrayList<String> palavras) {
    ArrayList<FrequenciaPalavra> frequencia = new ArrayList<>();

    for (String palavra : palavras) {
        boolean encontrada = false;
        
        for (FrequenciaPalavra freq : frequencia) {
            if (freq.getPalavra().equals(palavra)) {
                freq.incrementarFrequencia();
                encontrada = true;
                break;
            }
        }
        
        if (!encontrada) {
            frequencia.add(new FrequenciaPalavra(palavra));
        }
    }

    return frequencia;
}
    


}
