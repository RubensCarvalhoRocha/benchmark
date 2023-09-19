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



public class Arvore {

    public class Tree {

        public class Node {

            String word;
            Node left;
            Node right;

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

        private Node insert(Node node, String word) {
            if (node == null) {
                return new Node(word);
            }
            
            int compareResult = word.compareTo(node.word);
            
            if (compareResult < 0) {
                node.left = insert(node.left, word);
            } else if (compareResult > 0) {
                node.right = insert(node.right, word);
            } else {
                throw new RuntimeException("Duplicate word!");
            }
            
            return node;
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

