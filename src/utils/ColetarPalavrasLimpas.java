/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Administrator
 */
public class ColetarPalavrasLimpas {
 
public ArrayList<String> coletarPalavras() {
        ArrayList<String> palavras = new ArrayList<>();

        JFileChooser fileChooser = new JFileChooser();

        // Criar um filtro para permitir apenas arquivos .txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Texto (.txt)", "txt");
        fileChooser.setFileFilter(filter);

        // Configurar o JFileChooser para abrir apenas arquivos
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Exibir o diálogo de seleção de arquivo e verificar se o usuário clicou em "Abrir"
        int result = fileChooser.showOpenDialog(null); // null significa que o diálogo não terá um componente pai

        if (result == JFileChooser.APPROVE_OPTION) {
            // O usuário selecionou um arquivo
            File selectedFile = fileChooser.getSelectedFile();

            try (FileReader fileReader = new FileReader(selectedFile);
                 BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    StringTokenizer tokenizer = new StringTokenizer(line);
                    while (tokenizer.hasMoreTokens()) {
                        String palavra = tokenizer.nextToken();
                        // Adicione a palavra à lista
                        palavras.add(palavra);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // O usuário cancelou a seleção de arquivo
            System.out.println("Nenhum arquivo selecionado");
        }

        return palavras;
    }

     public static void main(String[] args) throws IOException {
        ColetarStopWords coletarStopWords = new ColetarStopWords();
        Set<String> stopWords = coletarStopWords.coletarStopWords();
        
      for (String palavra : stopWords) {
        System.out.println(palavra);
        }
    }
     
}





