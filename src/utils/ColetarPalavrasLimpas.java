/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.List;
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


   // Método que recebe uma lista de palavras e um conjunto de stop words e retorna uma lista de palavras limpas.
public ArrayList<String> limparPalavras(ArrayList<String> palavras, Set<String> stopWords) {
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
}