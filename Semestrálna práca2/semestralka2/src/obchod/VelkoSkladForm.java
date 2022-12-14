/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obchod;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import predajna.VelkoSklad;

/**
 *
 * @author Rudolf Pastva
 */
public class VelkoSkladForm extends javax.swing.JFrame {

    private VelkoSklad velkoSklad;

    /**
     * Creates new form VelkoSkladForm
     */
    public VelkoSkladForm(VelkoSklad velkoSk) {
        this.velkoSklad = velkoSk;
        this.initComponents();
        datumLb.setText("Datum: " + new Date().toString());
    }

    private VelkoSkladForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vypisBt = new javax.swing.JButton();
        dodajTBt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        datumLb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("VelkoSklad");
        setMinimumSize(new java.awt.Dimension(1070, 680));
        getContentPane().setLayout(null);

        vypisBt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vypisBt.setText("Vypis tovar");
        vypisBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vypisBtActionPerformed(evt);
            }
        });
        getContentPane().add(vypisBt);
        vypisBt.setBounds(450, 140, 193, 35);

        dodajTBt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dodajTBt.setText("Dodaj tovar");
        dodajTBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajTBtActionPerformed(evt);
            }
        });
        getContentPane().add(dodajTBt);
        dodajTBt.setBounds(450, 240, 193, 34);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Aktualna hodnota tovarov");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(450, 340, 193, 34);

        datumLb.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        getContentPane().add(datumLb);
        datumLb.setBounds(400, 0, 330, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rudolf Pastva\\Desktop\\modre-pozadie-157922.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1070, 670);

        jMenu1.setText("Menu");

        jMenuItem1.setText("Koniec");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Sp????");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vypisBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vypisBtActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, this.velkoSklad.toString());
    }//GEN-LAST:event_vypisBtActionPerformed

    private void dodajTBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajTBtActionPerformed
        try {
            // TODO add your handling code here:
            this.velkoSklad.prijemTovaruOdDodavatelov("prijemka");
            JOptionPane.showMessageDialog(this, "Tovar dodany, aktualna stav zasob : \n" + this.velkoSklad.toString());
        } catch (IOException ex) {
            Logger.getLogger(VelkoSkladForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_dodajTBtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, this.velkoSklad.getPenaznyMajetok() + " eur");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.akciaKoniec();
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    private void akciaKoniec() {
        if (JOptionPane.showConfirmDialog(this, "Chce?? skutocne skon??i?? program", "Ukon??enie", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            System.exit(1);
        }
        this.repaint();
    }

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
            java.util.logging.Logger.getLogger(VelkoSkladForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VelkoSkladForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VelkoSkladForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VelkoSkladForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VelkoSkladForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel datumLb;
    private javax.swing.JButton dodajTBt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JButton vypisBt;
    // End of variables declaration//GEN-END:variables
}
