/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ColetarStopWords {
    public Set<String> coletarStopWords() throws IOException {
    // Cria um conjunto vazio para armazenar as stop words.
    
    Set<String> stopWords = new HashSet<>();

    // Início do bloco try-catch para tratamento de exceções de E/S (IOException).
    try (BufferedReader br = new BufferedReader(new FileReader("C:\\WorkSpace\\Faculdade\\EstruturaDeDados2\\benchmarkAVL\\src\\files\\stopwords.txt"))) {
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
}
