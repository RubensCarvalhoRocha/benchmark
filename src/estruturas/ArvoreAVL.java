/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estruturas;

import bo.Coleta;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import javax.naming.directory.SearchResult;



public class ArvoreAVL {

    public class Tree {

    List<SearchResult> listResult = new ArrayList<>();
    Map<String, SearchResult> mapa = new HashMap<>();

    public class Node {

        String word;
        int height;
        Node left;
        Node right;
        TreeSet<String> words;
        public String getValue;
        private String value;

        Node(String word) {
            this.word = word;
        }
    }

    private Node root;

    public void insert(String word) {
        root = insert(root, word);

    }

    public Node getRoot() {
        return root;
    }

    public int height() {
        return root == null ? -1 : root.height;
    }

    private Node insert(Node node, String word) {
        TreeSet<String> words = new TreeSet<>();
        if (node == null) {
            return new Node(word);
        } else {
            words.add(word);
            words.add(node.word);
        }
        if (!words.first().equals(node.word)) {
            node.left = insert(node.left, word);
        } else if (words.first().equals(node.word)) {
            node.right = insert(node.right, word);
        } else {
            throw new RuntimeException("Duplicate letter!");
        }
        return rebalance(node);
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

    public void printDictionary(Node node) {
        if (node != null) {
            printDictionary(node.left);
            System.out.print(node.word);
            System.out.println();
            printDictionary(node.right);
        }
    }

    public void print() {
        printDictionary(root);
    }
    
    }
}

