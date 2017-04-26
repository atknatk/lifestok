package com.lifeweb.ui.urun;

import com.jidesoft.grid.AutoFilterTableHeader;
import com.jidesoft.grid.RowStripeTableStyleProvider;
import com.jidesoft.lucene.LuceneFilterableTableModel;
import com.lifeweb.dao.controller.UrunlerController;
import com.lifeweb.dao.impl.UrunlerDaoImpl;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.ui.helper.UIConfig;
import com.lifeweb.ui.islemler.RowNumberTable;
import com.lifeweb.ui.islemler.UrunlerTableModel;
import com.lifeweb.ui.satis.SatisUI;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class UrunUI extends javax.swing.JFrame {

    protected final Color BACKGROUND1 = new Color(253, 253, 220);
    protected final Color BACKGROUND2 = new Color(255, 255, 255);

    private Boolean isSatis;

    public UrunUI(Boolean isSatis) {
        this.isSatis = isSatis;
        initComponents();
        setLocation(UIConfig.getLocation(UrunUI.this));
        setTitle("Ürünler");
        RowNumberTable.setRowNumber(jScrollPane1, table);
        table.setTableStyleProvider(new RowStripeTableStyleProvider(new Color[]{BACKGROUND1, BACKGROUND2}));
        TableModel model = UrunlerTableModel.urunlerTableModel(false);
        filterField.setTableModel(model);
        table.setModel(new LuceneFilterableTableModel(filterField.getDisplayTableModel()));;
        filterField.setHintText("Filtrelenecek kelimeyi giriniz");
        filterField.setObjectConverterManagerEnabled(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.jidesoft.grid.SortableTable();
        jPanel2 = new javax.swing.JPanel();
        guncelleButton = new javax.swing.JButton();
        yeniUrunButton = new javax.swing.JButton();
        urunDuzeltButton = new javax.swing.JButton();
        urunInceleButton = new javax.swing.JButton();
        urunSilButton = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        filterField = new com.jidesoft.lucene.LuceneQuickTableFilterField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ürünler");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        table.setRowResizable(false);
        table.setVariousRowHeights(true);
        table.setSelectInsertedRows(false);
        AutoFilterTableHeader _header = new AutoFilterTableHeader(table);
        _header.setAutoFilterEnabled(true);
        _header.setUseNativeHeaderRenderer(true);
        table.setTableHeader(_header);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        guncelleButton.setText("Güncelle");
        guncelleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guncelleButtonActionPerformed(evt);
            }
        });

        yeniUrunButton.setText("Yeni Ürün");
        yeniUrunButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yeniUrunButtonActionPerformed(evt);
            }
        });

        urunDuzeltButton.setText("Ürün Düzelt");
        urunDuzeltButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunDuzeltButtonActionPerformed(evt);
            }
        });

        urunInceleButton.setText("Ürün İncele");
        urunInceleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunInceleButtonActionPerformed(evt);
            }
        });

        urunSilButton.setText("Ürün Sil");
        urunSilButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunSilButtonActionPerformed(evt);
            }
        });

        jButton6.setText("Kapat");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton1.setText("Ürün Detay");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(yeniUrunButton)
                .addGap(18, 18, 18)
                .addComponent(urunDuzeltButton)
                .addGap(18, 18, 18)
                .addComponent(urunInceleButton)
                .addGap(18, 18, 18)
                .addComponent(urunSilButton)
                .addGap(18, 18, 18)
                .addComponent(guncelleButton)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
                .addComponent(jButton6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yeniUrunButton)
                    .addComponent(urunDuzeltButton)
                    .addComponent(urunInceleButton)
                    .addComponent(urunSilButton)
                    .addComponent(guncelleButton)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guncelleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guncelleButtonActionPerformed
        table.setModel(UrunlerTableModel.urunlerTableModel(false));

    }//GEN-LAST:event_guncelleButtonActionPerformed

    private void yeniUrunButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yeniUrunButtonActionPerformed
        new UrunCrudUI(UrunPanelTip.KAYDET, null).setVisible(true);
    }//GEN-LAST:event_yeniUrunButtonActionPerformed

    private void urunDuzeltButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunDuzeltButtonActionPerformed
        if (table.getSelectedRow() != -1) {
            Urunler urun = (Urunler) table.getModel().getValueAt(table.getSelectedRow(), 1);
            new UrunCrudUI(UrunPanelTip.DUZENLE, urun).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen Ürün Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_urunDuzeltButtonActionPerformed

    private void urunInceleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunInceleButtonActionPerformed
        if (table.getSelectedRow() != -1) {
            Urunler urun = (Urunler) table.getModel().getValueAt(table.getSelectedRow(), 1);
            new UrunCrudUI(UrunPanelTip.INCELE, urun).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen Ürün Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_urunInceleButtonActionPerformed

    private void urunSilButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunSilButtonActionPerformed
        if (table.getSelectedRow() != -1) {
            Urunler urun = (Urunler) table.getModel().getValueAt(table.getSelectedRow(), 1);
            int n = JOptionPane.showConfirmDialog(this, "Seçili ürünü silmek istediğinizden emin misiniz ?", "Silme İşlemi", JOptionPane.YES_NO_OPTION);

            if (n == JOptionPane.YES_OPTION) {
                try {
                    UrunlerController controller = new UrunlerController(new UrunlerDaoImpl());
                    controller.removeUrunler(urun);
                    JOptionPane.showConfirmDialog(this, "Başarıyla Silindi", "Silme İşlemi", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(this, "Hata Oluştu", "Silme İşlemi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen Ürün Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_urunSilButtonActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (!isSatis) {
            if (evt.getClickCount() == 2) {
                if (table.getSelectedRow() != -1) {
                    Urunler urun = (Urunler) table.getModel().getValueAt(table.getSelectedRow(), 1);
                    new UrunCrudUI(UrunPanelTip.INCELE, urun).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Lütfen Ürün Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

                }
            }
        } else {
//            if (evt.getClickCount() == 2) {
//                if (table.getSelectedRow() != -1) {
//                    Urunler urun = (Urunler) table.getModel().getValueAt(table.getSelectedRow(), 1);
//                    SatisUI.getBarkodField().setText(urun.getBarkodId());
//                    this.dispose();
//                } else {
//                    JOptionPane.showMessageDialog(this, "Lütfen Ürün Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
//
//                }
//            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (table.getSelectedRow() != -1) {
            Urunler urun = (Urunler) table.getModel().getValueAt(table.getSelectedRow(), 1);
//new TableScrollPaneDemo().setVisible(true);
            new UrunDetayPanel(urun).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Lütfen Ürün Seçiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jidesoft.lucene.LuceneQuickTableFilterField filterField;
    private javax.swing.JButton guncelleButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.jidesoft.grid.SortableTable table;
    private javax.swing.JButton urunDuzeltButton;
    private javax.swing.JButton urunInceleButton;
    private javax.swing.JButton urunSilButton;
    private javax.swing.JButton yeniUrunButton;
    // End of variables declaration//GEN-END:variables
}
