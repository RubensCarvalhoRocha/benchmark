package estruturas;

import bo.Coleta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class ArvoreAVL {

    int comparacoesArvoreAVL = 0;

    public class Node {

        String key;
        int height;
        Node left;
        Node right;

        Node(String key) {
            this.key = key;
        }
    }

    private Node root;

    public int find(String palavra) {
        Node current = root;
        
        while (current != null) {
            comparacoesArvoreAVL = comparacoesArvoreAVL + 1;
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
        comparacoesArvoreAVL = comparacoesArvoreAVL + 1;
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
        comparacoesArvoreAVL = comparacoesArvoreAVL + 1;
        if (node == null) {
            return new Node(key);
        } else if (node.key.compareTo(key) > 0) {
            node.left = insert(node.left, key);
        } else if (node.key.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("Duplicate key!");
        }
        return rebalance(node);
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
        if (node != null) {
            node = rebalance(node);
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

    private Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n) {
        return n == null ? -1 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    public void printAVLTree(Node node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("└─");
                indent += "  ";
            } else {
                System.out.print("├─");
                indent += "│ ";
            }
            System.out.println(node.key);

            printAVLTree(node.left, indent, false);
            printAVLTree(node.right, indent, true);
        }
    }

    public void printAVLTree() {
        printAVLTree(root, "", true);
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


