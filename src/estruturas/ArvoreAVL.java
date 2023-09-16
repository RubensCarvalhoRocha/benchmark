/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estruturas;

import java.util.ArrayList;

public class ArvoreAVL {

    public class Node {
        public String palavra;
        int altura;
        public Node esquerda, direita;

        Node(String palavra) {
            this.palavra = palavra;
            this.altura = 1;
        }
    }

    public Node raiz;

    public int altura(Node n) {
        if (n == null)
            return 0;
        return n.altura;
    }

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public Node rotacaoDireita(Node y) {
        Node x = y.esquerda;
        Node T = x.direita;

        x.direita = y;
        y.esquerda = T;

        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    public Node rotacaoEsquerda(Node x) {
        Node y = x.direita;
        Node T = y.esquerda;

        y.esquerda = x;
        x.direita = T;

        x.altura = max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    public int getBalance(Node n) {
        if (n == null)
            return 0;
        return altura(n.esquerda) - altura(n.direita);
    }

    public Node inserir(Node no, String palavra) {
        if (no == null)
            return (new Node(palavra));

        if (palavra.compareTo(no.palavra) < 0)
            no.esquerda = inserir(no.esquerda, palavra);
        else if (palavra.compareTo(no.palavra) > 0)
            no.direita = inserir(no.direita, palavra);
        else
            return no;

        no.altura = 1 + max(altura(no.esquerda), altura(no.direita));

        int balance = getBalance(no);

        if (balance > 1 && palavra.compareTo(no.esquerda.palavra) < 0)
            return rotacaoDireita(no);

        if (balance < -1 && palavra.compareTo(no.direita.palavra) > 0)
            return rotacaoEsquerda(no);

        if (balance > 1 && palavra.compareTo(no.esquerda.palavra) > 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (balance < -1 && palavra.compareTo(no.direita.palavra) < 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void inorder(Node no) {
        if (no != null) {
            inorder(no.esquerda);
            System.out.print(no.palavra + " ");
            inorder(no.direita);
        }
    }

    public void  inserirPalavras(ArrayList<String> palavras) {
        for (String palavra : palavras) {
            raiz = inserir(raiz, palavra);
        }
    }
}
