/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.carihesap;

import com.lifeweb.dao.pojo.CariHesaplar;
import com.lifeweb.ui.helper.UIConfig;
import com.lifeweb.ui.islemler.CariHesapTableModel;
import com.lifeweb.ui.islemler.RowNumberTable;
import com.lifeweb.ui.satis.SatisUI;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Life
 */
public class CariHesapUI extends javax.swing.JFrame {

    private final Boolean isSatis;
    private final SatisUI satisUI;
    public CariHesapUI(Boolean isSatis,SatisUI satisUI) {
        this.isSatis = isSatis;
        initComponents();
        this.satisUI=satisUI;
        setLocation(UIConfig.getLocation(CariHesapUI.this));
        RowNumberTable.setRowNumber(jScrollPane1, sortableTable1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sortableTable1 = new com.jidesoft.grid.SortableTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hesaplar");
        setAlwaysOnTop(true);
        setType(java.awt.Window.Type.UTILITY);

        sortableTable1.setModel(CariHesapTableModel.cariTableModel());
        sortableTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sortableTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(sortableTable1);

        jButton1.setText("Yeni Hesap");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hesap Düzenle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hesap İncele");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hesabı Sii");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Güncelle");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Kapat");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 441, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new CariHesapCrudUI(CariHesapPanelTip.KAYDET, null).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = sortableTable1.getSelectedRow();
        if (row != -1) {
            CariHesaplar tableCari = (CariHesaplar) sortableTable1.getValueAt(row, 2);
            new CariHesapCrudUI(CariHesapPanelTip.DUZENLE, tableCari).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen Hesap Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = sortableTable1.getSelectedRow();
        if (row != -1) {
            CariHesaplar tableCari = (CariHesaplar) sortableTable1.getValueAt(row, 2);
            new CariHesapCrudUI(CariHesapPanelTip.INCELE, tableCari).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen Hesap Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row = sortableTable1.getSelectedRow();
        if (row != -1) {
            CariHesaplar tableCari = (CariHesaplar) sortableTable1.getValueAt(row, 2);
            int n = JOptionPane.showConfirmDialog(this, "Seçili hesabı silmek istediğinizden emin misiniz ?", "Silme İşlemi", JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {
                try {
//                    CariHesaplarJpaController controller = new CariHesaplarJpaController(EntityHelper.getEmf());
//                    controller.destroy(tableCari.getMusteriId());
                    JOptionPane.showConfirmDialog(this, "Başarıyla Silindi", "Silme İşlemi", JOptionPane.INFORMATION_MESSAGE);
                } catch (HeadlessException e) {
                    JOptionPane.showConfirmDialog(this, "Hata Oluştu", "Silme İşlemi", JOptionPane.ERROR_MESSAGE);
                    System.err.println(e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen Hesap Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        sortableTable1.setModel(CariHesapTableModel.cariTableModel());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void sortableTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sortableTable1MouseClicked
        if (!isSatis) {
            if (evt.getClickCount() == 2) {
                int row = sortableTable1.getSelectedRow();
                if (row != -1) {
                    CariHesaplar tableCari = (CariHesaplar) sortableTable1.getValueAt(row, 2);
                    new CariHesapCrudUI(CariHesapPanelTip.INCELE, tableCari).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Lütfen Hesap Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

                }
            }
        } else {
            if (evt.getClickCount() == 2) {
                int row = sortableTable1.getSelectedRow();
                if (row != -1) {
                    CariHesaplar tableCari = (CariHesaplar) sortableTable1.getValueAt(row, 2);
                    satisUI.getCariField().setText(tableCari.getAdiSoyadi());
                    satisUI.getAcikHesap().setEnabled(true);
                    satisUI.setHesap(tableCari);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Lütfen Hesap Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }//GEN-LAST:event_sortableTable1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.jidesoft.grid.SortableTable sortableTable1;
    // End of variables declaration//GEN-END:variables
}
