/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estruturas;

/**
 *
 * @author aluno
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class BTree {
    public int comparisons; // Adicione este campo


    private TreeNode root;
    private int t; // Ordem da árvore B

    class TreeNode {

        ArrayList<String> keys;
        ArrayList<TreeNode> childPointers;
        boolean isLeaf;

        public TreeNode(boolean isLeaf) {
            this.isLeaf = isLeaf;
            keys = new ArrayList<>();
            childPointers = new ArrayList<>();
        }
    }
    Map<String, SearchResult> mapa = new HashMap<>();

    public BTree(int t) {
        this.t = t;
        root = new TreeNode(true);
        root.keys.add(""); // Inicializa com uma chave fictícia (vazia)
        comparisons = 0; // Inicialize o contador
    }
    public int getComparisons() {
        return comparisons;
    }

    public void insert(String key) {
        TreeNode rootNode = root;
        if (root.keys.size() == (2 * t) - 1) {
            TreeNode newRoot = new TreeNode(false);
            newRoot.childPointers.add(rootNode);
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(rootNode, key);
    }

    private void insertNonFull(TreeNode node, String key) {
        int i = node.keys.size() - 1;
        if (node.isLeaf) {
            node.keys.add(""); // Adiciona uma chave vazia temporariamente
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
                node.keys.set(i + 1, node.keys.get(i));
                i--;
            }
            node.keys.set(i + 1, key);
        } else {
            while (i >= 0 && key.compareTo(node.keys.get(i)) < 0) {
                i--;
            }
            i++;
            TreeNode child = node.childPointers.get(i);
            if (child.keys.size() == (2 * t) - 1) {
                splitChild(node, i);
                if (key.compareTo(node.keys.get(i)) > 0) {
                    i++;
                }
            }
            insertNonFull(node.childPointers.get(i), key);
        }
    }

    private void splitChild(TreeNode parentNode, int index) {
        
        TreeNode nodeToSplit = parentNode.childPointers.get(index);
        TreeNode newChild = new TreeNode(nodeToSplit.isLeaf);
        parentNode.keys.add(index, nodeToSplit.keys.get(t - 1));
        parentNode.childPointers.add(index + 1, newChild);
        for (int i = 0; i < t - 1; i++) {
            newChild.keys.add(nodeToSplit.keys.remove(t));
        }
        if (!nodeToSplit.isLeaf) {
            for (int i = 0; i < t; i++) {
                newChild.childPointers.add(nodeToSplit.childPointers.remove(t));
            }
        }
    }

    public boolean search(String key) {
        return search(root, key);
    }

    private boolean search(TreeNode node, String key) {
        if (node == null) {
            return false;
        }
        int i = 0;
        while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
            i++;
             comparisons++; // Incrementa o contador de comparações
        }
        if (i < node.keys.size() && key.equals(node.keys.get(i))) {
            return true;
        } else if (node.isLeaf) {
            return false;
        } else {
            return search(node.childPointers.get(i), key);
        }
    }

    public void delete(String key) {
        delete(root, key);
    }

    private void delete(TreeNode node, String key) {
        if (node == null) {
            return;
        }
        int i = 0;
        while (i < node.keys.size() && key.compareTo(node.keys.get(i)) > 0) {
            i++;
        }

        if (i < node.keys.size() && key.equals(node.keys.get(i))) {
            // Caso 1: A chave está na folha
            if (node.isLeaf) {
                node.keys.remove(i);
            } // Caso 2: A chave está em um nó interno
            else {
                // Substitua a chave a ser excluída pela chave predecessora/sucessora
                // e exclua a chave predecessora/sucessora do nó filho apropriado
                String predecessorKey = getPredecessor(node, i);
                node.keys.set(i, predecessorKey);
                delete(node.childPointers.get(i), predecessorKey);
            }
        } else {
            // Se a chave não está presente no nó atual, vá para o nó filho apropriado
            if (node.isLeaf) {
                return;
            }
            boolean flag = (i == node.keys.size());
            if (node.childPointers.get(i).keys.size() < t) {
                fill(node, i);
            }
            if (flag && i > node.keys.size()) {
                delete(node.childPointers.get(i - 1), key);
            } else {
                delete(node.childPointers.get(i), key);
            }
        }
    }

    private String getPredecessor(TreeNode node, int index) {
        TreeNode current = node.childPointers.get(index);
        while (!current.isLeaf) {
            current = current.childPointers.get(current.childPointers.size() - 1);
        }
        return current.keys.get(current.keys.size() - 1);
    }

    private void fill(TreeNode node, int index) {
        if (index != 0 && node.childPointers.get(index - 1).keys.size() >= t) {
            borrowFromPrev(node, index);
        } else if (index != node.keys.size() && node.childPointers.get(index + 1).keys.size() >= t) {
            borrowFromNext(node, index);
        } else {
            if (index != node.keys.size()) {
                merge(node, index);
            } else {
                merge(node, index - 1);
            }
        }
    }

    private void borrowFromPrev(TreeNode node, int index) {
        TreeNode child = node.childPointers.get(index);
        TreeNode sibling = node.childPointers.get(index - 1);

        child.keys.add(0, node.keys.get(index - 1));
        if (!child.isLeaf) {
            child.childPointers.add(0, sibling.childPointers.remove(sibling.childPointers.size() - 1));
        }
        node.keys.set(index - 1, sibling.keys.remove(sibling.keys.size() - 1));
    }

    private void borrowFromNext(TreeNode node, int index) {
        TreeNode child = node.childPointers.get(index);
        TreeNode sibling = node.childPointers.get(index + 1);

        child.keys.add(node.keys.get(index));
        if (!child.isLeaf) {
            child.childPointers.add(sibling.childPointers.remove(0));
        }
        node.keys.set(index, sibling.keys.remove(0));
    }

    private void merge(TreeNode node, int index) {
        TreeNode child = node.childPointers.get(index);
        TreeNode sibling = node.childPointers.get(index + 1);

        child.keys.add(node.keys.remove(index));
        for (int i = 0; i < sibling.keys.size(); i++) {
            child.keys.add(sibling.keys.get(i));
        }
        if (!child.isLeaf) {
            for (int i = 0; i < sibling.childPointers.size(); i++) {
                child.childPointers.add(sibling.childPointers.get(i));
            }
        }
        node.childPointers.remove(index + 1);
    }

    public void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.keys);
            for (int i = 0; i < node.childPointers.size() - 1; i++) {
                printTree(node.childPointers.get(i), prefix + (isLeft ? "│   " : "    "), true);
            }
            if (node.childPointers.size() > 0) {
                printTree(node.childPointers.get(node.childPointers.size() - 1), prefix + (isLeft ? "│   " : "    "), false);
            }
        }
    }

    public int readTxt(List<String> wordsList) {
        int cont = 0;

        for (String word : wordsList) {
            if (!word.isEmpty()) {
                SearchResult sr = searchAlphabetical(word);
                if (sr.isSearch() == false) {
                    insert(word);
                    sr.setWord(word);
                    sr.setOccurrences(1);
                    mapa.put(word, sr);
                    cont += sr.getComparisons();
                } else {
                    sr = mapa.get(word);
                    sr.setOccurrences(sr.getOccurrences() + 1);
                    mapa.put(word, sr);
                    cont += mapa.get(word).getComparisons();
                }
            }
        }

        return cont;
    }

    public SearchResult searchAlphabetical(String word) {
        return searchAlphabetical(root, word, new SearchResult(0, 0));
    }

    private SearchResult searchAlphabetical(BTree.TreeNode node, String word, SearchResult result) {
        if (node == null) {
            return result;
        }
        result = new SearchResult(result.getComparisons() + 1, false);
        

        int i = 0;
        while (i < node.keys.size() && word.compareTo(node.keys.get(i)) > 0) {
            i++;
        }

        if (i < node.keys.size() && word.equals(node.keys.get(i))) {
            result.setSearch(true);
            return result;
        } else if (node.childPointers != null && i < node.childPointers.size()) {
            return searchAlphabetical(node.childPointers.get(i), word, result);
        } else {
            return result;
        }
    }

    public void printTree() {
        printTree(root, "", true);
    }
      public void addPalavrasLimpasBtree(ArrayList<String> palavrasLimpas) {
        for (String palavraLimpa : palavrasLimpas) {
            if (!search(palavraLimpa)) {
                insert(palavraLimpa);
            }
        }

        // Após adicionar as palavras limpas, imprime a árvore.
        System.out.println("Árvore B após adicionar palavras limpas:");
        printTree(root, "", true);
    }
    
public static void main(String[] args) {
    BTree tree = new BTree(2); // Crie uma Árvore B com ordem 2 (você pode alterar isso se desejar)

    ArrayList<String> palavrasLimpas = new ArrayList<>();
    palavrasLimpas.add("apple");
    palavrasLimpas.add("banana");
    palavrasLimpas.add("cherry");
    palavrasLimpas.add("apple");

    int comparacoes = tree.readTxt(palavrasLimpas); // Use a função readTxt

    System.out.println("Número de comparações: " + comparacoes);
}

}
