package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import bo.Coleta;
import estruturas.Arvore;
import estruturas.ArvoreAVL;
import bo.FrequenciaPalavra;
import estruturas.BuscaBinaria2;

public class BenchMark extends javax.swing.JFrame {

    public BenchMark() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonImportar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRelatorioBuscaBinaria = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaRelatorioArvore = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaRelatorioFrequencia = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaRelatorioArvoreAVL = new javax.swing.JTextArea();
        jLabelUrl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Relatório BenchMark");

        jButtonImportar.setText("Importar Arquivo");
        jButtonImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonImportarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jButtonImportar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButtonImportar))
        );

        jTextAreaRelatorioBuscaBinaria.setColumns(20);
        jTextAreaRelatorioBuscaBinaria.setRows(5);
        jScrollPane1.setViewportView(jTextAreaRelatorioBuscaBinaria);

        jTextAreaRelatorioArvore.setColumns(20);
        jTextAreaRelatorioArvore.setRows(5);
        jScrollPane2.setViewportView(jTextAreaRelatorioArvore);

        jTextAreaRelatorioFrequencia.setColumns(20);
        jTextAreaRelatorioFrequencia.setRows(5);
        jScrollPane3.setViewportView(jTextAreaRelatorioFrequencia);

        jTextAreaRelatorioArvoreAVL.setColumns(20);
        jTextAreaRelatorioArvoreAVL.setRows(5);
        jScrollPane4.setViewportView(jTextAreaRelatorioArvoreAVL);

        jLabelUrl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Busca Binária");

        jLabel3.setText("Arvore");

        jLabel4.setText("Arvore AVL");

        jLabel5.setText("Frequencia");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(69, 69, 69)
                .addComponent(jLabel3)
                .addGap(68, 68, 68)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addComponent(jScrollPane2)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonImportarActionPerformed
                                         
    Coleta coleta = new Coleta();

    try {
        // Chamar o método coletarStopWords
        Set<String> stopWords = coleta.coletarStopWords();

        // Chamar o método coletarPalavras
        ArrayList<String> palavras = coleta.coletarPalavras();

        // Chamar o método removerStopWords, passando as palavras coletadas e as stop words como argumentos
        ArrayList<String> palavrasLimpas = coleta.removerStopWords(palavras, stopWords);

        // Por exemplo, você pode imprimir as palavras limpas no console:
        ArrayList<String> palavrasLimpasOrdenadas = coleta.obterPalavrasLimpasOrdenadas(palavrasLimpas);

        ArrayList<FrequenciaPalavra> frequencia = coleta.contarFrequencia(palavrasLimpasOrdenadas);
        
        // Limpar o conteúdo do jTextAreaRelatorioFrequencia
        jTextAreaRelatorioFrequencia.setText("");
        
        // Exibir a frequência das palavras no jTextAreaRelatorioFrequencia
        for (FrequenciaPalavra freq : frequencia) {
            jTextAreaRelatorioFrequencia.append(freq.getPalavra() + ": " + freq.getFrequencia() + "\n");
        }

        // Instanciar a árvore AVL
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        // Adicionar palavras limpas à árvore AVL
        long startTimeAVL = System.currentTimeMillis(); // Registrar o tempo inicial
        arvoreAVL.addPalavrasLimpasArvoreAVL(palavrasLimpas);
        long endTimeAVL = System.currentTimeMillis(); // Registrar o tempo final
        long arvoreAVLTempo = endTimeAVL - startTimeAVL;
        int comparacoesAVL = arvoreAVL.comparacoesArvoreAVL;
        String info = comparacoesAVL + " comparações\n" + arvoreAVLTempo + " milissegundos";
        jTextAreaRelatorioArvoreAVL.setText(info);

        // Instanciar a árvore não balanceada
        Arvore arvore = new Arvore();

        // Adicionar palavras limpas à árvore não balanceada
        long startTime = System.currentTimeMillis(); // Registrar o tempo inicial
        arvore.addPalavrasLimpasArvore(palavrasLimpas);
        long endTime = System.currentTimeMillis(); // Registrar o tempo final
        long arvoreTempo = endTime - startTime;
        int comparacoes = arvore.comparacoesArvore;
        String info2 = comparacoes + " comparações\n" + arvoreTempo + " milissegundos";
        jTextAreaRelatorioArvore.setText(info2);

        // Inicializar a busca binária
        BuscaBinaria2 busca = new BuscaBinaria2();

        // Inserir palavras limpas na busca binária
        busca.InserirVetorDinamico(palavrasLimpas);
        int comparacoesBusca = busca.comparacoesBuscaBinaria;
        String info4 = (comparacoesBusca) + " comparações\n";

        // Medir o tempo da busca binária
        long startTimeVetor = System.currentTimeMillis(); // Registrar o tempo inicial
        busca.InserirVetorDinamico(palavrasLimpas);
        long endTimeVetor = System.currentTimeMillis(); // Registrar o tempo final
        long vetorTempo = endTimeVetor - startTimeVetor;

        String info3 = vetorTempo + " milissegundos";
        jTextAreaRelatorioBuscaBinaria.setText(info4 + info3);

        // Construir um vetor dinâmico sem duplicatas
        ArrayList<String> vetorDinamico = new ArrayList<>();
        for (String palavra : palavrasLimpas) {
            if (!vetorDinamico.contains(palavra)) {
                vetorDinamico.add(palavra);
            }
        }

        // Imprimir os elementos do vetor dinâmico na tela
        System.out.println("Palavras únicas no vetor dinâmico:");
        for (String palavra : vetorDinamico) {
            System.out.println(palavra);
        }

        // Imprimir a árvore AVL
        System.out.println("Arvore AVL:");
        arvoreAVL.printAVLTree();

        // Imprimir a árvore não balanceada
        System.out.println("\nArvore Não Balanceada:");
        arvore.printTree();

    } catch (IOException e) {
        // Lidar com exceções, se necessário
    }


    }//GEN-LAST:event_jButtonImportarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //Validando as Arvores:S
        /*Arvore arvore = new Arvore();
        ArvoreAVL arvoreAvl = new ArvoreAVL();
        System.out.println("Arvore AVL");
        arvore.addPalavrasLimpasArvore();
        arvore.printTree();
        System.out.println("---------------");
        System.out.println("Arvore Não Balanceada");
        arvoreAvl.addPalavrasLimpasArvoreAVL();
        arvoreAvl.printAVLTree();*/

 /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BenchMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BenchMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BenchMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BenchMark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BenchMark().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonImportar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelUrl;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaRelatorioArvore;
    private javax.swing.JTextArea jTextAreaRelatorioArvoreAVL;
    private javax.swing.JTextArea jTextAreaRelatorioBuscaBinaria;
    private javax.swing.JTextArea jTextAreaRelatorioFrequencia;
    // End of variables declaration//GEN-END:variables
}
