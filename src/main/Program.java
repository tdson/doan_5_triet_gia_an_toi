/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import dinningPhilosophers.App;
import gmail.FramePosition;
import gmail.View;
import java.awt.Cursor;

/**
 *
 * @author ds_mu
 */
public class Program extends javax.swing.JFrame {

    /**
     * Creates new form Program
     */
    public Program() {
        super("Đồ Án Cơ Sở Ngành Mạng | Trần Đại Sơn | sontd.it@gmail.com");
        initComponents();
        FramePosition.setCenterPosition(this);
        //setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lapTrinhMangBtn = new javax.swing.JLabel();
        heDieuHanhBtn = new javax.swing.JLabel();
        bgImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lapTrinhMangBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/ltmIcon142_b.png"))); // NOI18N
        lapTrinhMangBtn.setToolTipText("SMTP Mail Client");
        lapTrinhMangBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lapTrinhMangBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lapTrinhMangBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lapTrinhMangBtnMouseExited(evt);
            }
        });
        mainPanel.add(lapTrinhMangBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 142, 142));

        heDieuHanhBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/hdhIcon142_b.png"))); // NOI18N
        heDieuHanhBtn.setToolTipText("Bài toán 5 triết gia ăn tối");
        heDieuHanhBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                heDieuHanhBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                heDieuHanhBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                heDieuHanhBtnMouseExited(evt);
            }
        });
        mainPanel.add(heDieuHanhBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 142, 142));

        bgImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/bg_main.png"))); // NOI18N
        mainPanel.add(bgImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lapTrinhMangBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapTrinhMangBtnMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        lapTrinhMangBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/ltm_entered.png")));
    }//GEN-LAST:event_lapTrinhMangBtnMouseEntered

    private void heDieuHanhBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heDieuHanhBtnMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        heDieuHanhBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/hdh_entered.png")));
    }//GEN-LAST:event_heDieuHanhBtnMouseEntered

    private void heDieuHanhBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heDieuHanhBtnMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        heDieuHanhBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/hdhIcon142_b.png")));
    }//GEN-LAST:event_heDieuHanhBtnMouseExited

    private void lapTrinhMangBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapTrinhMangBtnMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        lapTrinhMangBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main/ltmIcon142_b.png")));
    }//GEN-LAST:event_lapTrinhMangBtnMouseExited

    // HĐH ActionPerformed
    private void heDieuHanhBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heDieuHanhBtnMouseClicked
        new App(this);
        setVisible(false);
    }//GEN-LAST:event_heDieuHanhBtnMouseClicked

    // LTM ActionPerformed
    private void lapTrinhMangBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lapTrinhMangBtnMouseClicked
        new View(this);
        setVisible(false);
    }//GEN-LAST:event_lapTrinhMangBtnMouseClicked

    public void requestMaximize() {
        this.setVisible(true);
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
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Program().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgImage;
    private javax.swing.JLabel heDieuHanhBtn;
    private javax.swing.JLabel lapTrinhMangBtn;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
