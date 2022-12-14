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
import predajna.Predajna;
import predajna.SkladPredajne;
import predajna.VelkoSklad;

/**
 *
 * @author Rudolf Pastva
 */
public class SietSpolForm extends javax.swing.JFrame {

    private SietSpolocnosti sietSpolocnosti;

    public SietSpolForm() throws IOException {
        VelkoSklad velkosklad;
        velkosklad = new VelkoSklad("Cadca");
        Predajna predajna1 = new Predajna();
        Predajna predajna2 = new Predajna();
        Predajna predajna3 = new Predajna();
        SkladPredajne skPredajne1 = new SkladPredajne(velkosklad, predajna1);
        SkladPredajne skPredajne2 = new SkladPredajne(velkosklad, predajna2);
        SkladPredajne skPredajne3 = new SkladPredajne(velkosklad, predajna3);

        Obchod obchod1 = new Obchod("Nova Bystrica", predajna1, skPredajne1);
        Obchod obchod2 = new Obchod("Cadca", predajna2, skPredajne2);
        Obchod obchod3 = new Obchod("Zilina", predajna3, skPredajne3);
        this.sietSpolocnosti = new SietSpolocnosti();
        this.sietSpolocnosti.pridajPrevadzku(obchod1);
        this.sietSpolocnosti.pridajPrevadzku(obchod2);
        this.sietSpolocnosti.pridajPrevadzku(obchod3);
        this.sietSpolocnosti.pridajPrevadzku(velkosklad);
        

        initComponents();
        datumLb.setText("Datum: " + new Date().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        koniecBt = new javax.swing.JButton();
        vypisBt = new javax.swing.JButton();
        dajPrevadzkuBt = new javax.swing.JButton();
        vypisPrBt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cisloPrTf = new javax.swing.JTextField();
        hTBt = new javax.swing.JButton();
        datumLb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        KnBt = new javax.swing.JMenuItem();

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rudolf Pastva\\Desktop\\modre-pozadie-157922.jpg")); // NOI18N
        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SietSpolocnosti");
        setBackground(new java.awt.Color(51, 153, 0));
        setMinimumSize(new java.awt.Dimension(1070, 680));
        getContentPane().setLayout(null);

        koniecBt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        koniecBt.setText("Koniec");
        koniecBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                koniecBtActionPerformed(evt);
            }
        });
        getContentPane().add(koniecBt);
        koniecBt.setBounds(420, 410, 190, 35);

        vypisBt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vypisBt.setText("Vypis");
        vypisBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vypisBtActionPerformed(evt);
            }
        });
        getContentPane().add(vypisBt);
        vypisBt.setBounds(420, 170, 193, 37);

        dajPrevadzkuBt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dajPrevadzkuBt.setText("Ist do prevadzky");
        dajPrevadzkuBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dajPrevadzkuBtActionPerformed(evt);
            }
        });
        getContentPane().add(dajPrevadzkuBt);
        dajPrevadzkuBt.setBounds(420, 250, 193, 37);

        vypisPrBt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vypisPrBt.setText("Vypis prevadzky");
        vypisPrBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vypisPrBtActionPerformed(evt);
            }
        });
        getContentPane().add(vypisPrBt);
        vypisPrBt.setBounds(420, 90, 193, 37);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Poradove cislo");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(640, 250, 88, 37);

        cisloPrTf.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        getContentPane().add(cisloPrTf);
        cisloPrTf.setBounds(740, 250, 104, 37);

        hTBt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        hTBt.setText("Aktualna hodnota tovarov");
        hTBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hTBtActionPerformed(evt);
            }
        });
        getContentPane().add(hTBt);
        hTBt.setBounds(420, 330, 193, 37);

        datumLb.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        getContentPane().add(datumLb);
        datumLb.setBounds(360, 0, 310, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Rudolf Pastva\\Desktop\\modre-pozadie-157922.jpg")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1080, 650);

        jMenu1.setText("Menu");

        KnBt.setText("Koniec");
        KnBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KnBtActionPerformed(evt);
            }
        });
        jMenu1.add(KnBt);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KnBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KnBtActionPerformed
        // TODO add your handling code here:
        this.akciaKoniec();
    }//GEN-LAST:event_KnBtActionPerformed

    private void koniecBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_koniecBtActionPerformed
        // TODO add your handling code here:
        this.akciaKoniec();
    }//GEN-LAST:event_koniecBtActionPerformed

    private void vypisBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vypisBtActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, this.sietSpolocnosti.toString());
    }//GEN-LAST:event_vypisBtActionPerformed

    private void vypisPrBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vypisPrBtActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, this.sietSpolocnosti.stringPrevadzky());
    }//GEN-LAST:event_vypisPrBtActionPerformed

    private void dajPrevadzkuBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dajPrevadzkuBtActionPerformed
        // TODO add your handling code here:
        this.getPrevadzku();
    }//GEN-LAST:event_dajPrevadzkuBtActionPerformed

    private void hTBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hTBtActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, this.sietSpolocnosti.getHodnotuTovarovSpolocnosti() + " eur");

    }//GEN-LAST:event_hTBtActionPerformed
    private void getPrevadzku() {

        try {

            Prevadzky prevadzka = this.sietSpolocnosti.poskytniPrevadzku(this.akciaPoradoveCislo());
            if (prevadzka instanceof Obchod) {
                prevadzka.getVisible();
            }
            if (prevadzka instanceof VelkoSklad) {
                prevadzka.getVisible();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Neexistuje prevadzka " + ex, null, JOptionPane.ERROR_MESSAGE);

        }

    }

    private int akciaPoradoveCislo() {
        int cislo;
        try {
            cislo = Integer.parseInt(this.cisloPrTf.getText());
            return cislo - 1;
        } catch (NumberFormatException ex) {
            //JOptionPane.showMessageDialog(this, "Chybne id tovaru");
            throw new NumberFormatException("Chybne cislo prevadzky");

        }

    }

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
            java.util.logging.Logger.getLogger(SietSpolForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SietSpolForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SietSpolForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SietSpolForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new SietSpolForm().setVisible(false);
                } catch (IOException ex) {
                    Logger.getLogger(SietSpolForm.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem KnBt;
    private javax.swing.JTextField cisloPrTf;
    private javax.swing.JButton dajPrevadzkuBt;
    private javax.swing.JLabel datumLb;
    private javax.swing.JButton hTBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton koniecBt;
    private javax.swing.JButton vypisBt;
    private javax.swing.JButton vypisPrBt;
    // End of variables declaration//GEN-END:variables
}
