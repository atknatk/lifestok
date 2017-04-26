package com.lifeweb.ui.indirimler;

import com.jidesoft.grid.AutoFilterTableHeader;
import com.jidesoft.grid.RowStripeTableStyleProvider;
import com.lifeweb.dao.controller.IndirimlerController;
import com.lifeweb.dao.impl.IndirimlerDaoImpl;
import com.lifeweb.dao.pojo.IndirimAltGrup;
import com.lifeweb.dao.pojo.Indirimler;
import com.lifeweb.dao.pojo.Kullanici;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.ui.helper.UIConfig;
import com.lifeweb.ui.islemler.UrunlerTableModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CokUrunIndirim extends javax.swing.JFrame {

    private Urunler anaUrun;
    private DefaultTableModel ustModel;
    private DefaultTableModel altModel;
    private DefaultTableModel anaModel;
    private Date start;
    private Date finish;
    private String ad;
    protected final Color BACKGROUND1 = new Color(253, 253, 220);
    protected final Color BACKGROUND2 = new Color(255, 255, 255);

    public CokUrunIndirim(Date start, Date finish, String ad) {
        this.start = start;
        this.finish = finish;
        this.ad = ad;
        altModel = (DefaultTableModel) UrunlerTableModel.urunlerTableModel(false);
        ustModel = (DefaultTableModel) UrunlerTableModel.urunlerTableModel(true);
        anaModel = (DefaultTableModel) UrunlerTableModel.urunlerTableModel(false);
        ustModel.addColumn("Indirim Değeri");

        initComponents();
        setLocation(UIConfig.getLocation(CokUrunIndirim.this));
        ustTable.setTableStyleProvider(new RowStripeTableStyleProvider(new Color[]{BACKGROUND1, BACKGROUND2}));
        altTable.setTableStyleProvider(new RowStripeTableStyleProvider(new Color[]{BACKGROUND1, BACKGROUND2}));
        anaTable.setTableStyleProvider(new RowStripeTableStyleProvider(new Color[]{BACKGROUND1, BACKGROUND2}));

        setLabel(this.start, this.finish);
        setList();

    }

    private void setLabel(Date bas, Date bit) {
        Locale.setDefault(new Locale("tr", "TR"));
        String data = "";
        data += " Başlangıç Tarihi " + bas.toLocaleString().split(" ")[0] + " - ";
        data += " Başlangıç Tarihi " + bit.toLocaleString().split(" ")[0] + " - ";
        Locale.setDefault(Locale.ENGLISH);

        setTitle(data);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        anaTable = new com.jidesoft.grid.SortableTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ustTable = new com.jidesoft.grid.SortableTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        altTable = new com.jidesoft.grid.SortableTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("İndirimler");
        setAlwaysOnTop(true);

        anaTable.setRowResizable(false);
        anaTable.setVariousRowHeights(true);
        anaTable.setSelectInsertedRows(false);
        AutoFilterTableHeader _header = new AutoFilterTableHeader(anaTable);
        _header.setAutoFilterEnabled(true);
        _header.setUseNativeHeaderRenderer(true);
        anaTable.setTableHeader(_header);
        anaTable.setModel(anaModel);
        anaTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anaTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(anaTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        ustTable.setModel(ustModel);
        ustTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ustTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ustTable);

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

        jButton1.setText("Kaydet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anaTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anaTableMouseClicked
        if (evt.getClickCount() == 2) {
            if (anaTable.getSelectedRow() != -1) {
                Urunler urun = (Urunler) anaTable.getModel().getValueAt(anaTable.getSelectedRow(), 1);
                jLabel2.setText(urun.toString());
                anaUrun = urun;
            }
        }
    }//GEN-LAST:event_anaTableMouseClicked

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
        }        // TODO add your handling code here:
    }//GEN-LAST:event_altTableMouseClicked

    private void ustTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ustTableMouseClicked
        if (evt.getClickCount() == 3) {
            if (ustTable.getSelectedRow() != -1) {
                Urunler urun = (Urunler) ustTable.getModel().getValueAt(ustTable.getSelectedRow(), 1);
                ustModel.removeRow(ustTable.getSelectedRow());
                altModel.addRow(getUrunVector(urun));
            }
        }
    }//GEN-LAST:event_ustTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ustTable.isEditing()) {
            JOptionPane.showMessageDialog(this, "Tablo düzenlemeyi bitiriniz");
        } else {
            if (anaUrun == null) {
                JOptionPane.showMessageDialog(this, "Ana ürün seçiniz");
            } else {
                int ustCount = ustModel.getRowCount();
                boolean isFull = true;
                for (int i = 0; i < ustCount; i++) {
                    Object oran = ustModel.getValueAt(i, 8);

                    if (oran == null || oran.toString().equals("")) {
                        isFull = false;
                        break;
                    }
                }
                if (isFull) {

                    Indirimler indirimler = new Indirimler();
                    indirimler.setBtarih(start);
                    indirimler.setEtarih(finish);
                    indirimler.setIndAdi(ad);
                    indirimler.setIndDurum(isFull);
                    indirimler.setIndEkleyen(new Kullanici(1));
                    indirimler.setIndEtarih(new Date());
                    indirimler.setIndMinMiktar(1);
                    indirimler.setIndNet(0);
                    indirimler.setIndOran(0);
                    indirimler.setTekUrun(false);
                    indirimler.setUrunRef(anaUrun);
                    indirimler.setYuzde(isFull);
                    ArrayList<IndirimAltGrup> altGrups = new ArrayList<>();
                    for (int i = 0; i < ustCount; i++) {
                        
                        IndirimAltGrup altGrup =new IndirimAltGrup();
                        altGrup.setNet(Double.parseDouble(ustModel.getValueAt(i, 8).toString()));
                        altGrup.setOran(0);
                        altGrup.setYuzde(!isFull);
                        altGrup.setUrun((Urunler) ustModel.getValueAt(i, 1));
                    altGrups.add(altGrup);
                                }
                    indirimler.setIndirimAltGrups(altGrups);
                    IndirimlerController controller = new IndirimlerController(new IndirimlerDaoImpl());
                    controller.createIndirimler(indirimler);
                    JOptionPane.showMessageDialog(this, "İndirim Kaydedildi");
                } else {
                    JOptionPane.showMessageDialog(this, "Tablo yüzde bilgisi eksik");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jidesoft.grid.SortableTable altTable;
    private com.jidesoft.grid.SortableTable anaTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private com.jidesoft.grid.SortableTable ustTable;
    // End of variables declaration//GEN-END:variables

    private void setList() {
        DefaultListModel<String> model = new DefaultListModel<>();
        IndirimlerController controller = new IndirimlerController(new IndirimlerDaoImpl());
        List<String> list = controller.getIndirimlerTekAdList();
        for (String indirimler : list) {
            model.addElement(indirimler);
        }
        //   jList1.setModel(model);
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
