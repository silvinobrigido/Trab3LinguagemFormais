/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3.frontend;
import java.awt.List;
import trabalho3.backend.LexicalError;
import trabalho3.backend.Lexico;
import trabalho3.backend.Token;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author silvinos
 */
public class Trabalho3 extends javax.swing.JFrame {
    //Observação qualquer semelhança é mera coincidência
    //Atributos da Classe
    private int linhaDoErro;
    private String textoConsole; 
    private ArrayList<String> palavrasAnalisadas;
    private Lexico lexico = new Lexico();
    private Token token = null;
    public Trabalho3() {
        initComponents();
        this.setTitle("Trabalho 3");

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btAnalisar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        btEquipe = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoA = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoB = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btAnalisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho3/frontend/icons/211801-16.png"))); // NOI18N
        btAnalisar.setText("Analisar");
        btAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnalisarActionPerformed(evt);
            }
        });

        btLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho3/frontend/icons/172590-16.png"))); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        btEquipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho3/frontend/icons/103572-16.png"))); // NOI18N
        btEquipe.setText("Equipe");
        btEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEquipeActionPerformed(evt);
            }
        });

        campoA.setColumns(20);
        campoA.setRows(0);
        campoA.setText("");
        campoA.setName(""); // NOI18N
        campoA.setPreferredSize(new java.awt.Dimension(870, 400));
        jScrollPane2.setViewportView(campoA);
        campoA.setBorder(new NumberedBorder());

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setAutoscrolls(true);

        campoB.setEditable(false);
        campoB.setColumns(20);
        campoB.setRows(5);
        campoB.setWrapStyleWord(true);
        campoB.setPreferredSize(new java.awt.Dimension(870, 200));
        jScrollPane1.setViewportView(campoB);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btAnalisar, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAnalisar)
                    .addComponent(btLimpar)
                    .addComponent(btEquipe))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEquipeActionPerformed
        campoB.setText("Rodrigo Schneider \nLeonardo Hoffmann Sebold \nSilvino Brigido de Souza\n©2018 todos os direitos reservados");
    }//GEN-LAST:event_btEquipeActionPerformed

    private void btAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnalisarActionPerformed
        try {
            String texto = campoA.getText();
            linhaDoErro = 0;
            textoConsole = "";
            palavrasAnalisadas = new ArrayList<>();// somente com arraylist funciona            
            String linhas[] = texto.split("\n"); // quebro em linhas 
            //Verifico se existe texto            
            if (!"".equals(texto)) {
                //percorro meu array de string
                for (String linha : linhas) {
                    lexico.setInput(linha);
                    linhaDoErro++;
                    while ((token = lexico.nextToken()) != null) {
                        textoConsole = String.valueOf(linhaDoErro) + "   " + token.getLexeme() + "   " + getNome(token.getId());
                        palavrasAnalisadas.add(textoConsole);                        
                    }
                }
                String resultado = "Dados Analisados:" + "\n";
                resultado = palavrasAnalisadas.stream().map((palavrasAnalisada) -> palavrasAnalisada + "\n").reduce(resultado, String::concat);
                campoB.setText(resultado);
            }
        } catch (LexicalError ex) {
            campoB.setText("erro na linha - " + String.valueOf(linhaDoErro) + " - " + ex.getMessage());// ARRUMAR O RESULTADO
        }
    }//GEN-LAST:event_btAnalisarActionPerformed
    private void acheiErro(String palavra , int tipoDeErro){
        String text = campoA.getText();
        String linhas[];
        linhas = text.split( "\n" );
        int linhaErro =0;
        for (int i=0; i< linhas.length; i++) {
            if(linhas[i].contains(palavra)){
                linhaErro = i + 1;
            }
        }
        
        switch(tipoDeErro){
            case 1:
                 campoB.append("erro na linha "+ linhaErro +" - motor, ano ou KM inválido: " + palavra);
                 
                break;
            case 2:
                campoB.append("erro na linha "+ linhaErro+ " – valor inválido: " + palavra);
                break;
            case 3:
                campoB.append("erro na linha "+ linhaErro +"– combustível inválido: " + palavra);
                break;    
            case 4:
                campoB.append("erro na linha "+ linhaErro + "– símbolo(s) inválido(s): " + palavra);
                break;
        }
        
        
    }
    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
       campoA.setText(null);
       campoB.setText(null);
       textoConsole = "";
       palavrasAnalisadas = null;
    }//GEN-LAST:event_btLimparActionPerformed
     
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Trabalho3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trabalho3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trabalho3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trabalho3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {  
                new Trabalho3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAnalisar;
    private javax.swing.JButton btEquipe;
    private javax.swing.JButton btLimpar;
    private javax.swing.JTextArea campoA;
    private javax.swing.JTextArea campoB;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private String getNome(int cod) {
        String retorno = "";
        switch (cod) {
            case 2:
                retorno ="Motor";
                break;
            case 3: 
                retorno="Ano";
                break;
            case 4: 
                retorno="Valor";
                break;
            case 5: 
                retorno="KM";
                break;
            case 6: 
                retorno= "Chassi";
                break;
            case 7: 
                retorno= "Placa";
                break;
            case 8: 
                retorno= "Marca ou Modelo";
                break;
            case 9: 
                retorno= "Combustível";
                break;    
        }
        return retorno;
    }
}
