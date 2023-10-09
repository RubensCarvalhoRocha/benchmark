package estruturas;

import bo.Coleta;
import java.util.ArrayList;


public class Arvore {

     public int comparacoesArvore = 0;

    public class Node {
        String key;
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
            comparacoesArvore = comparacoesArvore + 1;
            if (palavra.isEmpty()) {
                return -1;
            }
            if (current.key.equals(palavra)) {
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
        
        root = insertRec(root, key);
    }

    private Node insertRec(Node node, String key) {
        
        if (node == null) {
            return new Node(key);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insertRec(node.left, key);
        } else if (cmp > 0) {
            node.right = insertRec(node.right, key);
        }
        return node;
    }

    public void delete(String key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node node, String key) {
        if (node == null) {
            return node;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = deleteRec(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteRec(node.right, key);
        } else {
            // Node com apenas um filho ou nenhum filho
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node com dois filhos, obtem o sucessor in-order (menor na subárvore direita)
            node.key = minValue(node.right);

            // Deleta o sucessor in-order
            node.right = deleteRec(node.right, node.key);
        }

        return node;
    }

    private String minValue(Node node) {
        String minValue = node.key;
        while (node.left != null) {
            minValue = node.left.key;
            node = node.left;
        }
        return minValue;
    }

    public Node getRoot() {
        return root;
    }

    public void printTree(Node node, String indent, boolean last) {
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

            printTree(node.left, indent, false);
            printTree(node.right, indent, true);
        }
    }

    public void printTree() {
        printTree(root, "", true);
    }

    public void addPalavrasLimpasArvore(ArrayList<String> palavrasLimpas) {
        Coleta coleta = new Coleta();

                
            for (String palavraLimpa : palavrasLimpas) {
                int resultadoBusca = find(palavraLimpa);
                if (resultadoBusca == -1) {
                    insert(palavraLimpa);
                }
            }         

    }
}
