/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.satis;

import com.jidesoft.converter.ConverterContext;
import com.jidesoft.grid.ContextSensitiveTableModel;
import com.jidesoft.grid.EditorContext;
import com.lifeweb.LifewebSession;
import com.lifeweb.pojo.IdValue;
import com.lifeweb.ui.helper.UIConfig;
import com.lifeweb.ui.islemler.SatisIslemi;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Life
 */
public class OdemeBolPanel extends javax.swing.JFrame {

    private double toplamTutar = 0;
    private SatisUI ui;
    private final String PESIN = "Peşin";
    private final String KREDI = "Kredi Kartı";
    private final String ACIK = "Açık Hesap";

    public OdemeBolPanel(boolean acikHesap, final double toplamTutar, SatisUI ui) {
        initComponents();
        this.ui = ui;
        this.toplamTutar = toplamTutar;
        setLocation(UIConfig.getLocation(OdemeBolPanel.this));
        final DefaultTableModel model = new SampleTableModel(acikHesap);
        table.setModel(model);
        jLabel1.setText(toplamTutar + "");
        jLabel4.setText(toplamTutar + "");
        setAlwaysOnTop(true);
        table.addCellEditorListener(new com.jidesoft.grid.JideCellEditorListener() {

            @Override
            public void editingStopped(ChangeEvent e) {
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                int rowCount = model.getRowCount();
                int zeroCount = 0;
                double girilenTutar = 0;
                int lastRow = 0;
                double deger = 0;
                try {
                    deger = Double.parseDouble(model.getValueAt(row, 1).toString());
                } catch (NumberFormatException ex) {
                    model.setValueAt(0, row, 1);
                }
                if (deger > toplamTutar) {
                    model.setValueAt(0, row, 1);
                    return;
                }
                if (column == 1) {
                    if (rowCount == 2) {
                        model.setValueAt(toplamTutar - deger, row == 0 ? 1 : 0, 1);
                        jLabel4.setText("0.00");
                        return;
                    }

                    for (int i = 0; i < rowCount; i++) {
                        deger = Double.parseDouble(model.getValueAt(i, 1).toString());
                        girilenTutar += deger;
                        if (deger == 0) {
                            zeroCount++;
                            lastRow = i;
                        }
                    }
                    if (zeroCount == 1) {
                        model.setValueAt(toplamTutar - girilenTutar, lastRow, 1);
                        jLabel4.setText("0.00");
                    } else {
                        jLabel4.setText(toplamTutar - girilenTutar + "");
                    }

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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new com.jidesoft.grid.SortableTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("0.0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Toplam Tutar:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Kalan Tutar");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("0.0");

        jButton1.setText("Onayla");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Kapat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            if (ui.getTable().getModel().getRowCount() > 0) {
                ArrayList<IdValue> list = new ArrayList<>();
                for (int i = 0; i < table.getRowCount(); i++) {
                    double deger = Double.parseDouble(table.getModel().getValueAt(i, 1).toString());
                    if (deger != 0) {
                        String tur = table.getValueAt(i, 0).toString();
                        switch (tur) {
                            case PESIN:
                                list.add(new IdValue(1, deger));
                                break;
                            case KREDI:
                                list.add(new IdValue(2, deger));
                                break;
                            case ACIK:
                                list.add(new IdValue(3, deger));
                                break;
                        }
                    }
                }
                if (ui.getHesap() == null) {
                    SatisIslemi.myInstance(ui.getTable()).satisBol(ui.getTable(), list, LifewebSession.instance().getKullanici());

                } else {
                    SatisIslemi.myInstance(ui.getTable()).cariSatisBol(ui.getTable(), list, LifewebSession.instance().getKullanici(), ui.getHesap());

                }
                ui.satisEkraniSifirla();
                OdemeBolPanel.this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Sepet Boş");
            }
        } catch (NumberFormatException | HeadlessException e) {
            ui.satisEkraniSifirla();
            e.printStackTrace();

        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private com.jidesoft.grid.SortableTable table;
    // End of variables declaration//GEN-END:variables

    private class SampleTableModel extends DefaultTableModel implements ContextSensitiveTableModel {

        private static final long serialVersionUID = 7989993131145324195L;

        public SampleTableModel(boolean acikHesap) {
            setColumnCount(2);
            addRow(new Object[]{PESIN, 0});
            addRow(new Object[]{KREDI, 0});
            if (acikHesap) {
                addRow(new Object[]{ACIK, 0});
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 0) {
                return false;
            }
            return true;
        }

        @Override
        public ConverterContext getConverterContextAt(int row, int column) {
            return null;
        }

        @Override
        public EditorContext getEditorContextAt(int row, int column) {
//            if (column == 1) {
//                return CalculatorCellEditor.CONTEXT;
//            } else {
            return null;
//            }
        }

        @Override
        public Class<?> getCellClassAt(int row, int column) {
            return getColumnClass(column);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            } else {
                return Double.class;
            }
        }

        @Override
        public String getColumnName(int column) {
            if (column == 0) {
                return "Ödeme Türü";
            } else /*if(columnIndex == 1)*/ {
                return "Tutar";
            }
        }
    }

}
