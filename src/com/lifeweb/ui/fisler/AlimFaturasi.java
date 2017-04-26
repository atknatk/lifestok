package com.lifeweb.ui.fisler;

import com.jidesoft.combobox.TableExComboBoxSearchable;
import com.jidesoft.grid.SortableTable;
import com.lifeweb.enitity.Urunler;
import com.lifeweb.ui.helper.UIConfig;
import com.lifeweb.ui.islemler.CariHesapTableModel;
import com.lifeweb.ui.islemler.NumberRenderer;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class AlimFaturasi extends javax.swing.JFrame {

    public AlimFaturasi() {
        initComponents();
        setLocation(UIConfig.getLocation(this));
        dateExComboBox1.setLocale(new Locale("TR", "tr"));
        TableColumnModel m = table.getColumnModel();
        m.getColumn(1).setWidth(200);
        m.getColumn(2).setCellRenderer(new NumberRenderer(NumberFormat.getNumberInstance()));
        table.addCellEditorListener(new com.jidesoft.grid.JideCellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent ee) {
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                if (column == 0) {
                    if (table.getModel().getValueAt(row, column) != null && !table.getModel().getValueAt(row, column).toString().equals("")) {
//                        UrunlerJpaController controller = new UrunlerJpaController(EntityHelper.getEmf());
//                        Object barkod = table.getModel().getValueAt(table.getSelectedRow(), column);
//                        Query q = controller.getEntityManager().createNamedQuery("Urunler.findByBarkodId");
//                        q.setParameter("barkodId", barkod);
//                        Urunler urun = null;
//                        try {
//                            urun = (Urunler) q.getSingleResult();
//                        } catch (Exception e) {
//                        }
//                        if (urun != null) {
//                            table.getModel().setValueAt(urun, row, 1);
//                            table.getModel().setValueAt(1, row, 2);
//                            table.getModel().setValueAt(urun.getBirimRef(), row, 3);
//                            table.getModel().setValueAt(Double.valueOf(urun.getUrunKdvGrup().getKdvGrupOran()), row, 4);
//                            table.getModel().setValueAt(0, row, 5);
//                        } else {
//                            JOptionPane.showMessageDialog(table, "Ürün Barkodu Bulunmuyor");
//                            table.getModel().setValueAt(null, row, column);
//
//                        }
                    }
                } else if (column == 2 && table.getModel().getValueAt(row, 0) != null && !table.getModel().getValueAt(row, 0).toString().equals("")) { // miktar

                    Object value = table.getModel().getValueAt(table.getSelectedRow(), column);
                    if (value == null) {
                        value = 1;
                        table.getModel().setValueAt(table.getSelectedRow(), column, 1);
                    }
                    Double miktar = Double.valueOf(value.toString());
                    Double birimFiyat = 0.00;
                    Double indirimm = 0.00;
                    if (table.getModel().getValueAt(row, 6) != null && !table.getModel().getValueAt(row, 6).toString().equals("")) {
                        birimFiyat = Double.valueOf(table.getModel().getValueAt(row, 6).toString());
                    }
                    if (table.getModel().getValueAt(row, 5) != null && !table.getModel().getValueAt(row, 5).toString().equals("")) {
                        indirimm = Double.valueOf(table.getModel().getValueAt(row, 5).toString());
                        table.getModel().setValueAt((miktar * birimFiyat) - (miktar * birimFiyat * indirimm / 100), row, 7);
                    }
                    setAltField();
                } else if (column == 6 && table.getModel().getValueAt(row, 0) != null && !table.getModel().getValueAt(row, 0).toString().equals("")) { // birim fiyat
                    Object value = table.getModel().getValueAt(table.getSelectedRow(), column);

                    if (value == null) {
                        value = 0;
                        table.getModel().setValueAt(table.getSelectedRow(), column, 0);
                    }
                    Double miktar = 1.00;
                    Double birimFiyat = Double.valueOf(value.toString());
                    Double indirim = 0.00;
                    if (table.getModel().getValueAt(row, 2) != null && !table.getModel().getValueAt(row, 2).toString().equals("")) {
                        miktar = Double.valueOf(table.getModel().getValueAt(row, 2).toString());
                    }
                    if (table.getModel().getValueAt(row, 5) != null && !table.getModel().getValueAt(row, 5).toString().equals("")) {
                        indirim = Double.valueOf(table.getModel().getValueAt(row, 5).toString());
                        table.getModel().setValueAt((miktar * birimFiyat) - (miktar * birimFiyat * indirim / 100), row, 7);
                    }
                    setAltField();
                } else if (column == 5 && table.getModel().getValueAt(row, 0) != null && !table.getModel().getValueAt(row, 0).toString().equals("")) {
                    Object value = table.getModel().getValueAt(table.getSelectedRow(), column);

                    if (value == null) {
                        value = 0;
                        table.getModel().setValueAt(table.getSelectedRow(), column, 0);
                    }
                    Double miktar = 1.00;
                    Double birimFiyat = 0.00;
                    Double indirim = Double.valueOf(value.toString());
                    if (table.getModel().getValueAt(row, 2) != null && !table.getModel().getValueAt(row, 2).toString().equals("")) {
                        miktar = Double.valueOf(table.getModel().getValueAt(row, 2).toString());
                    }
                    if (table.getModel().getValueAt(row, 6) != null && !table.getModel().getValueAt(row, 6).toString().equals("")) {
                        birimFiyat = Double.valueOf(table.getModel().getValueAt(row, 6).toString());
                    }
                    table.getModel().setValueAt((miktar * birimFiyat) - (miktar * birimFiyat * indirim / 100), row, 7);
                    setAltField();
                }

            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }

            @Override
            public boolean editingStarting(ChangeEvent ce) {
                return true;
            }

            @Override
            public void editingStarted(ChangeEvent ce) {
            }

            @Override
            public boolean editingStopping(ChangeEvent ce) {
                return true;
            }
        });

        table.setOpaque(false);
        table.setFont(new Font("Arial", Font.BOLD, 16));
        table.setRowHeight(24);
        int totalWitdth = table.getColumnModel().getTotalColumnWidth();
        table.getColumnModel().getColumn(0).setPreferredWidth((int) (totalWitdth * 0.21));
        table.getColumnModel().getColumn(1).setPreferredWidth((int) (totalWitdth * 0.48));
        table.getColumnModel().getColumn(2).setPreferredWidth((int) (totalWitdth * 0.04));
        table.getColumnModel().getColumn(3).setPreferredWidth((int) (totalWitdth * 0.06));
        table.getColumnModel().getColumn(4).setPreferredWidth((int) (totalWitdth * 0.06));
        table.getColumnModel().getColumn(5).setPreferredWidth((int) (totalWitdth * 0.05));
        table.getColumnModel().getColumn(6).setPreferredWidth((int) (totalWitdth * 0.05));
        table.getColumnModel().getColumn(7).setPreferredWidth((int) (totalWitdth * 0.05));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateExComboBox1 = new com.jidesoft.combobox.DateExComboBox();
        dateSpinner1 = new com.jidesoft.spinner.DateSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        belgeNo = new javax.swing.JTextField();
        fisAciklama = new javax.swing.JTextField();
        ozelKod = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new com.jidesoft.grid.SortableTable();
        cariHesapBox = new com.jidesoft.combobox.TableExComboBox(CariHesapTableModel.cariTableModel()){
            @Override
            protected JTable createTable(TableModel model) {
                return new SortableTable(model);
            }};
            jSeparator1 = new javax.swing.JSeparator();
            jLabel8 = new javax.swing.JLabel();
            iskonto = new javax.swing.JFormattedTextField();
            jLabel10 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            jLabel13 = new javax.swing.JLabel();
            indirim = new javax.swing.JTextField();
            araToplam = new javax.swing.JTextField();
            toplamKdv = new javax.swing.JTextField();
            gToplam = new javax.swing.JTextField();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setAlwaysOnTop(true);
            setResizable(false);
            setType(java.awt.Window.Type.UTILITY);

            jLabel1.setText("Fiş Tarihi:");

            dateExComboBox1.setEditable(true);
            dateExComboBox1.setDate(new Date());

            jLabel2.setText("Fiş Saati:");

            jLabel3.setText("Özel Kodu:");

            jLabel4.setText("Belge No:");

            jLabel5.setText("Cari Hesap Adı:");

            jLabel6.setText("Fiş Açıklama:");

            jLabel7.setText("Lokasyon:");

            table.setAutoCreateRowSorter(true);
            table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null}
                },
                new String [] {
                    "BARKOD NO", "URUN ADI", "MİKTAR", "BİRİM", "KDV", "İND %", "BİRİM FİYATI", "TUTAR"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
                };
                boolean[] canEdit = new boolean [] {
                    true, false, true, false, false, true, true, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
            table.setAutoStartCellEditing(true);
            jScrollPane1.setViewportView(table);

            cariHesapBox.setValueColumnIndex(2); // display the second column value in the combobox.
            cariHesapBox.setMaximumRowCount(12);
            new TableExComboBoxSearchable(cariHesapBox);

            jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

            jLabel8.setText("Fiş İskonto Tutarı");

            iskonto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
            iskonto.setText("0,00");

            jLabel10.setText("İndirim:");

            jLabel11.setText("Ara Toplam:");

            jLabel12.setText("Toplam KDV:");

            jLabel13.setText("Genel Toplam:");

            indirim.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            indirim.setText("0,00");

            araToplam.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            araToplam.setText("0,00");

            toplamKdv.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            toplamKdv.setText("0,00");

            gToplam.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            gToplam.setText("0,00");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(51, 51, 51)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(dateExComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(belgeNo))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel6))
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fisAciklama)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(329, 329, 329)
                                            .addComponent(jLabel3))
                                        .addComponent(cariHesapBox, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ozelKod))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel7)
                                            .addGap(0, 0, Short.MAX_VALUE))))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(iskonto, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(indirim)
                                .addComponent(araToplam)
                                .addComponent(toplamKdv, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(gToplam, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(dateExComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dateSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(ozelKod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel6)
                        .addComponent(belgeNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fisAciklama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel7)
                        .addComponent(cariHesapBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(iskonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(indirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(araToplam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel12)
                                        .addComponent(toplamKdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(gToplam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(3, 3, 3))))
            );

            jButton1.setText("Tamam");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jButton2.setText("Vazgeç");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jButton1)
                    .addGap(10, 10, 10)
                    .addComponent(jButton2)
                    .addGap(523, 754, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addContainerGap(22, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        if (cariHesapBox.getSelectedIndex() != -1) {
//            AlimFisiJpaController alimFisiJpaController = new AlimFisiJpaController(EntityHelper.getEmf());
//            AlimFisiLineJpaController alimFisiLineJpaController = new AlimFisiLineJpaController(EntityHelper.getEmf());
//            AlimFisi alimFisi = new AlimFisi();
//            alimFisi.setAciklama(fisAciklama.getText());
//            alimFisi.setBelgeNo(belgeNo.getText());
//            alimFisi.setFisSaati(dateExComboBox1.getDate());
//            alimFisi.setFisTarihi(dateExComboBox1.getDate());
//            alimFisi.setHesapId((CariHesaplar) cariHesapBox.getSelectedItem());
//            alimFisi.setIskontoOrani(0);
//            alimFisi.setIskontoTutari(0);
//            alimFisi.setOzelKodu(ozelKod.getText());
//            alimFisi.setVadeTarihi(new Date());
//            alimFisi.setIndirimTutari(Double.valueOf(indirim.getText().replace("\\.", "").replace(',', '.')));
//            alimFisi.setAraToplam(Double.valueOf(araToplam.getText().replace("\\.", "").replace(',', '.')));
//            alimFisi.setKdvToplam(Double.valueOf(toplamKdv.getText().replace("\\.", "").replace(',', '.')));
//            alimFisi.setGenelToplam(Double.valueOf(gToplam.getText().replace("\\.", "").replace(',', '.')));
//            alimFisi = alimFisiJpaController.create(alimFisi);
//
//            //  ArrayList<AlimFisiLine> lines = new ArrayList<>();
//            for (int i = 0; i < 20; i++) {
//
//                if (table.getModel().getValueAt(i, 0) != null && !table.getModel().getValueAt(i, 0).toString().equals("")) {
//                    AlimFisiLine fisiLine = new AlimFisiLine();
//                    fisiLine.setBirimFiyati(Double.valueOf(table.getModel().getValueAt(i, 6).toString()));
//                    fisiLine.setIndirimOrani(Double.valueOf(table.getModel().getValueAt(i, 5).toString()));
//                    fisiLine.setMiktar(Double.valueOf(table.getModel().getValueAt(i, 2).toString()));
//                    fisiLine.setTutar(Double.valueOf(table.getModel().getValueAt(i, 7).toString()));
//                    fisiLine.setUrunId((Urunler) table.getModel().getValueAt(i, 1));
//                    fisiLine.setSatilmayanMiktar(fisiLine.getMiktar());
//                    fisiLine.setAlimFisiId(alimFisi);
//                    alimFisiLineJpaController.create(fisiLine);
//                    updateStok(fisiLine.getUrunId(), fisiLine.getMiktar(), alimFisiLineJpaController.getEntityManager());
//                }
//
//            }
//
//            JOptionPane.showMessageDialog(this, "Fiş Kaydedildi");
//        } else {
//            JOptionPane.showMessageDialog(this, "Cari Hesap Seçiniz");
//        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void updateStok(Urunler urun, Double miktar, EntityManager em) {
        try {
            em.getTransaction().begin();
            Urunler urunler = em.find(Urunler.class, urun.getUrunId());
            urunler.setUrunStokSeviye(urun.getUrunStokSeviye() + miktar);
            em.getTransaction()
                    .commit();
        } catch (Exception ex) {
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField araToplam;
    private javax.swing.JTextField belgeNo;
    private com.jidesoft.combobox.TableExComboBox cariHesapBox;
    private com.jidesoft.combobox.DateExComboBox dateExComboBox1;
    private com.jidesoft.spinner.DateSpinner dateSpinner1;
    private javax.swing.JTextField fisAciklama;
    private javax.swing.JTextField gToplam;
    private javax.swing.JTextField indirim;
    private javax.swing.JFormattedTextField iskonto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField ozelKod;
    private com.jidesoft.grid.SortableTable table;
    private javax.swing.JTextField toplamKdv;
    // End of variables declaration//GEN-END:variables

    private void setAltField() {
        Double fieldIndirim = 0.00;
        Double fieldAraToplam = 0.00;
        Double fieldKdvToplam = 0.00;
        Double fieldGToplam = 0.00;
        for (int i = 0; i < 20; i++) {
            if (table.getModel().getValueAt(i, 0) != null && !table.getModel().getValueAt(i, 0).toString().equals("")) {
                if (table.getModel().getValueAt(i, 2) == null) {
                    table.getModel().setValueAt(1, i, 2);
                }
                if (table.getModel().getValueAt(i, 5) == null) {
                    table.getModel().setValueAt(0, i, 5);
                }
                if (table.getModel().getValueAt(i, 6) == null) {
                    table.getModel().setValueAt(0, i, 6);
                }
                Double miktar = Double.valueOf(table.getModel().getValueAt(i, 2).toString());
                Double indirimOrani = Double.valueOf(table.getModel().getValueAt(i, 5).toString());
                Double birimFiyat = Double.valueOf(table.getModel().getValueAt(i, 6).toString());
                Double kdv = Double.valueOf(table.getModel().getValueAt(i, 4).toString());
                fieldIndirim += miktar * birimFiyat * indirimOrani / 100;
                fieldAraToplam += miktar * birimFiyat;
                fieldKdvToplam += miktar * birimFiyat * kdv / 100;
                fieldGToplam += (miktar * birimFiyat) - (miktar * birimFiyat * indirimOrani / 100) + (miktar * birimFiyat * kdv / 100);
            }
        }
        indirim.setText(String.valueOf(round(fieldIndirim)));
        araToplam.setText(String.valueOf(round(fieldAraToplam)));
        toplamKdv.setText(String.valueOf(round(fieldKdvToplam)));
        gToplam.setText(String.valueOf(round(fieldGToplam)));
    }

    public static double round(double unrounded) {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return rounded.doubleValue();
    }
}
