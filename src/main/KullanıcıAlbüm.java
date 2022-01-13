/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Vector;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alperen
 */
public class KullanıcıAlbüm extends javax.swing.JFrame {

    /**
     * Creates new form KullanıcıAlbüm
     */
    public KullanıcıAlbüm() {
        initComponents();
        güncelle();
    }

    public void güncelle(){
        int i,j;
        try {
            Veritabanı.pstmt= Veritabanı.con.prepareStatement("SELECT albumler.album_ad,sanatcilar.sanatci_ad,albumler.album_tarih,albumler.album_tur FROM albumler JOIN sanatcilar_albumler ON (albumler.album_id=sanatcilar_albumler.album_id) JOIN sanatcilar ON (sanatcilar.sanatci_id=sanatcilar_albumler.sanatci_id)");
            Veritabanı.rs= Veritabanı.pstmt.executeQuery();
            ResultSetMetaData AlbumData = Veritabanı.rs.getMetaData();
            i = AlbumData.getColumnCount();
            DefaultTableModel RecordTable = (DefaultTableModel)albümTablo.getModel();
            RecordTable.setRowCount(0);
            while(Veritabanı.rs.next()){
                Vector columnData = new Vector();
                for(j=1;j<=i;j++){
                    columnData.add(Veritabanı.rs.getString("album_ad"));
                    columnData.add(Veritabanı.rs.getString("sanatci_ad"));
                    columnData.add(Veritabanı.rs.getString("album_tarih"));
                    columnData.add(Veritabanı.rs.getString("album_tur"));
                }
                RecordTable.addRow(columnData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KullanıcıAlbüm.class.getName()).log(Level.SEVERE, null, ex);
        }
        } 
        
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        albümTablo = new javax.swing.JTable();
        geriDönButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        albümTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Albüm Adı", "Sanatçı", "Tarih", "Tür"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(albümTablo);

        geriDönButon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        geriDönButon.setText("GERİ DÖN");
        geriDönButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriDönButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(geriDönButon, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(296, 296, 296)
                        .addComponent(geriDönButon, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(216, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geriDönButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriDönButonActionPerformed
        Proje3.KullanıcıPanel = new KullanıcıPanel();
        Proje3.KullanıcıPanel.setLocationRelativeTo(null);
        Proje3.KullanıcıPanel.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_geriDönButonActionPerformed

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
            java.util.logging.Logger.getLogger(KullanıcıAlbüm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KullanıcıAlbüm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KullanıcıAlbüm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KullanıcıAlbüm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KullanıcıAlbüm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable albümTablo;
    private javax.swing.JButton geriDönButon;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
