package com.lifeweb.ui.indirimler;

import com.jidesoft.grid.AutoFilterTableHeader;
import com.jidesoft.grid.RowStripeTableStyleProvider;
import com.lifeweb.dao.controller.IndirimlerController;
import com.lifeweb.dao.impl.IndirimlerDaoImpl;
import com.lifeweb.dao.pojo.Indirimler;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.ui.helper.UIConfig;
import com.lifeweb.ui.islemler.UrunlerTableModel;
import java.awt.Color;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class TekUrunIndirimDuzenle extends javax.swing.JFrame {

    private DefaultTableModel ustModel;
    private DefaultTableModel altModel;
   protected final Color BACKGROUND1 = new Color(253, 253, 220);
    protected final Color BACKGROUND2 = new Color(255, 255, 255);

    public TekUrunIndirimDuzenle() {
       
        altModel = (DefaultTableModel) UrunlerTableModel.urunlerTableModel(false);
        ustModel = (DefaultTableModel) UrunlerTableModel.urunlerTableModel(true);
        initComponents();
        setLocation(UIConfig.getLocation(TekUrunIndirimDuzenle.this));
        ustTable.setTableStyleProvider(new RowStripeTableStyleProvider(new Color[]{BACKGROUND1, BACKGROUND2}));
        altTable.setTableStyleProvider(new RowStripeTableStyleProvider(new Color[]{BACKGROUND1, BACKGROUND2}));
     setList();

    }

    private void setLabel(Date bas, Date bit, double yuzde) {
        Locale.setDefault(new Locale("tr", "TR"));
        String data = "";
        data += " Başlangıç Tarihi " + bas.toLocaleString().split(" ")[0] + " - ";
        data += " Başlangıç Tarihi " + bit.toLocaleString().split(" ")[0] + " - ";
        data += " İndirim Oranı %" + yuzde;

        Locale.setDefault(Locale.ENGLISH);

        jLabel1.setText(data);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        altTable = new com.jidesoft.grid.SortableTable();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ustTable = new com.jidesoft.grid.SortableTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("İndirimler");
        setAlwaysOnTop(true);
        setResizable(false);

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        altTable.setRowResizable(false);
        altTable.setVariousRowHeights(true);
        altTable.setSelectInsertedRows(false);
        AutoFilterTableHeader _header2 = new AutoFilterTableHeader(altTable);
        _header2.setAutoFilterEnabled(true);
        _header2.setUseNativeHeaderRenderer(true);
        altTable.setTableHeader(_header2);
        altTable.setModel(altModel);
        altTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                altTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(altTable);

        jButton2.setText("Kaydet");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(90, 90, 90))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("İndirim Oranı");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ustTable.setRowResizable(false);
        ustTable.setVariousRowHeights(true);
        ustTable.setSelectInsertedRows(false);
        AutoFilterTableHeader _header = new AutoFilterTableHeader(ustTable);
        _header.setAutoFilterEnabled(true);
        _header.setUseNativeHeaderRenderer(true);
        ustTable.setTableHeader(_header);
        ustTable.setModel(ustModel);
        ustTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ustTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ustTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ustTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ustTableMouseClicked
        if (evt.getClickCount() == 2) {
            if (ustTable.getSelectedRow() != -1) {
                Urunler urun = (Urunler) ustTable.getModel().getValueAt(ustTable.getSelectedRow(), 1);
                ustModel.removeRow(ustTable.getSelectedRow());
                altModel.addRow(getUrunVector(urun));
            }
        }
    }//GEN-LAST:event_ustTableMouseClicked

    private void altTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_altTableMouseClicked
        if (evt.getClickCount() == 2) {
            if (altTable.getSelectedRow() != -1) {

                Urunler urun = (Urunler) altTable.getModel().getValueAt(altTable.getSelectedRow(), 1);
                altModel.removeRow(altTable.getSelectedRow());
                boolean isAdded = false;
                for (int i = 0; i < ustModel.getRowCount(); i++) {
                    Urunler urunn = (Urunler) ustTable.getModel().getValueAt(i, 1);
                    if (urunn.getBarkodId().equals(urun.getBarkodId())) {
                        isAdded = true;
                        break;
                    }
                }
                if (!isAdded) {
                    ustModel.addRow(getUrunVector(urun));
                }

            }
        }
    }//GEN-LAST:event_altTableMouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        if (jList1.getSelectedIndex() != -1) {
            for (int i = 0; i < ustTable.getRowCount(); i++) {
                Urunler urun = (Urunler) altTable.getModel().getValueAt(i, 1);
                altModel.addRow(getUrunVector(urun));
            }
            for (int i = 0; i < ustTable.getRowCount(); i++) {
                ustModel.removeRow(i);
            }

            IndirimlerController controller = new IndirimlerController(new IndirimlerDaoImpl());
            List<Indirimler> list = controller.getIndirimlerTelList(jList1.getSelectedValue().toString());
            for (Indirimler indirimler : list) {
                ustModel.addRow(getUrunVector(indirimler.getUrunRef()));
            }
            setLabel(list.get(0).getBtarih(), list.get(0).getEtarih(), list.get(0).getIndOran());

        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jidesoft.grid.SortableTable altTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.jidesoft.grid.SortableTable ustTable;
    // End of variables declaration//GEN-END:variables

    private void setList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        IndirimlerController controller = new IndirimlerController(new IndirimlerDaoImpl());
        List<String> list = controller.getIndirimlerTekAdList();
        for (String indirimler : list) {
            model.addElement(indirimler);
        }
        jList1.setModel(model);
    }

    private Vector getUrunVector(Urunler urun) {
        Vector data = new Vector();
        data.add(urun.getBarkodId());;
        data.add(urun);
        data.add(urun.getBirimRef().getBirimAdi());
        data.add(urun.getUrunKdvGrup().getKdvGrupOran());
        data.add(urun.getUrunSatisFiyat());
        data.add(urun.getUrunStokSeviye());
        data.add(urun.getMarkaRef() == null ? "Tanımsız" : urun.getMarkaRef().getMarkaAdi());
        data.add(urun.getUrunCesit().getCesitAdi());
        return data;

    }
}
