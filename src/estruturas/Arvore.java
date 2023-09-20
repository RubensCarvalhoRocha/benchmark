package estruturas;

import bo.Coleta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.naming.directory.SearchResult;

public class Arvore {

    int comparacoesArvore = 0;

    public class Node {

        String key;
        Node left;
        Node right;
        int height;

        Node(String key) {
            this.key = key;
        }
    }

    private Node root;

    public int find(String palavra) {
        Node current = root;

        while (current != null) {
            comparacoesArvore = comparacoesArvore + 1;
            if (palavra.isEmpty()) {
                return -1;
            }
            if (current.key.equals(palavra)) { // Check for exact match
                return 0; // Palavra encontrada, retorne 0
            }
            int cmp = current.key.compareTo(palavra);
            if (cmp < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return -1; // Palavra não encontrada, retorne -1
    }

    public void insert(String key) {
        comparacoesArvore = comparacoesArvore + 1;
        root = insert(root, key);
    }

    public void delete(String key) {
        root = delete(root, key);
    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private Node insert(Node node, String key) {
        comparacoesArvore = comparacoesArvore + 1;
        if (node == null) {
            return new Node(key);
        } else if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("Duplicate key!");
        }
        return node;
    }

    private Node delete(Node node, String key) {
        if (node == null) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public void printTree(Node node) {
        if (node != null) {
            System.out.println(node.key);
            printTree(node.left);
            printTree(node.right);
        }
    }

    public void printTree() {
        printTree(root);
    }
    
        public void addPalavrasLimpasArvoreAVL() {
        
        Coleta coleta = new Coleta();
         
           try {       
            // Chamar o método coletarStopWords
            Set<String> stopWords = coleta.coletarStopWords();
            // Chamar o método coletarPalavras
            ArrayList<String> palavras = coleta.coletarPalavras();
            // Chamar o método removerStopWords, passando as palavras coletadas e as stop words como argumentos
            ArrayList<String> palavrasLimpas = coleta.removerStopWords(palavras, stopWords);

                for (String palavraLimpa : palavrasLimpas) {
                    int resultadoBusca = find(palavraLimpa);
                    if (resultadoBusca == -1) {
                        insert(palavraLimpa);
                    }
                }
          
            } catch (IOException e) {}
        
    }
}
