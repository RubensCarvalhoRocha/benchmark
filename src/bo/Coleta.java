package bo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Coleta {

    public Set<String> coletarStopWords() throws IOException {
        // Cria um conjunto vazio para armazenar as stop words.
        Set<String> stopWords = new HashSet<>();

        // Início do bloco try-catch para tratamento de exceções de E/S (IOException).
        try ( BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\arthu\\Downloads\\stopwords.txt"))) {
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

public ArrayList<String> coletarPalavrasLimpas(Set<String> stopWords) {
    ArrayList<String> palavrasLimpas = new ArrayList<>();

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
                String[] words = line.split("[\\s\\p{Punct}]+|\\d+");
                for (String word : words) {
                    word = word.toLowerCase();
                    if (!word.isEmpty() && !stopWords.contains(word)) {
                        palavrasLimpas.add(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Nenhum arquivo selecionado");
    }

    return palavrasLimpas;
}

}
