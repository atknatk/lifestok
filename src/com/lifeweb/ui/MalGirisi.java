/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui;

import com.jidesoft.grid.AutoFilterTableHeader;
import com.jidesoft.grid.JideTableTransferHandler;
import com.lifeweb.enitity.helper.DaoHelper;
import com.lifeweb.ui.helper.Helper;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.concurrent.Task;
import javax.swing.DropMode;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MalGirisi extends javax.swing.JFrame {

    private final boolean IS_DIGER_SUBE;
    private Task task;
    private FiyatEsleTask fiyatEsleTask;

    public MalGirisi(boolean isDigerSube) {
        IS_DIGER_SUBE = isDigerSube;
        initComponents();
        if (isDigerSube) {
            jButton2.setVisible(false);
        }
        jProgressBar1.setVisible(false);
        table.setRowResizable(true);
        table.setVariousRowHeights(true);
        table.setSelectInsertedRows(false);
        AutoFilterTableHeader _header = new AutoFilterTableHeader(table);
        _header.setAutoFilterEnabled(true);
        _header.setUseNativeHeaderRenderer(true);
        table.setTableHeader(_header);
        quickTableFilterField1.setTableModel(table.getModel());
        quickTableFilterField1.setColumnIndices(new int[]{0});
        quickTableFilterField1.setTable(table);
        ((JideTableTransferHandler) table.getTransferHandler()).setAcceptImport(true);
        table.setNonContiguousCellSelection(true);
        table.setDropMode(DropMode.INSERT);
        table.setSortable(false);
        InputMap map = table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        map.put(KeyStroke.getKeyStroke("control Z"), "undo");
        map.put(KeyStroke.getKeyStroke("control shift Z"), "redo");
        ((JideTableTransferHandler) table.getTransferHandler()).setAcceptImport(true);
        table.setClickCountToStart(2);
        table.setDragEnabled(false);

        table.getTableHeader().addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Point p = e.getPoint();
                    int column = table.columnAtPoint(p);
                    if (column == 3 || column == 4 || column == 5) {
                        Double toplam = 0.0;
                        Double alisToplam = 0.0;
                        for (int i = 0; i < table.getRowCount(); i++) {
                            try {
                                Double tutar = Double.parseDouble(table.getValueAt(i, column).toString()) * Double.parseDouble(table.getValueAt(i, 6).toString());
                                Double alis = Double.parseDouble(table.getValueAt(i, 2).toString()) * Double.parseDouble(table.getValueAt(i, 6).toString());

                                if (tutar > 0) {
                                    toplam += tutar;
                                    alisToplam += alis;
                                }
                            } catch (Exception ex) {
                            }
                        }
                        jLabel1.setText(table.getColumnName(column) + ": (" + round(toplam) + ") TL  -  Alis Fiyatı Toplam: " + ": (" + round(alisToplam) + ") TL  -  Kar Toplam: (" + round((toplam - alisToplam)) + ") TL");
                    }
                }
            }
        });

        TableModelListener _listener = new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getSource() instanceof TableModel) {
                    int count = ((TableModel) e.getSource()).getRowCount();
                    System.out.println("1");
                }
            }
        };
        quickTableFilterField1.getDisplayTableModel().addTableModelListener(_listener);

        table.addCellEditorListener(new com.jidesoft.grid.JideCellEditorListener() {
            @Override
            public void editingStarted(javax.swing.event.ChangeEvent evt) {
            }

            @Override
            public boolean editingStarting(javax.swing.event.ChangeEvent evt) {
                return true;
            }

            @Override
            public boolean editingStopping(javax.swing.event.ChangeEvent evt) {
                try {
                    com.jidesoft.grid.DoubleCellEditor cellEditor = (com.jidesoft.grid.DoubleCellEditor) evt.getSource();
                    String value = cellEditor.getTextField().getText();
                    if (value != null) {
                        if (value.contains(",")) {
                            degeri = value.replace(",", ".");
                        } else {
                            degeri = value;
                        }
                    }

                } catch (Exception e) {
                }
                return true;
            }
            String degeri = null;

            @Override
            public void editingStopped(ChangeEvent ev) {
                try {

                    table.setValueAt(Double.parseDouble(degeri), table.getSelectedRow(), table.getSelectedColumn());

                } catch (Exception ee) {
                }
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }
        });

    }

    public static double round(double unrounded) {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return rounded.doubleValue();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        table = new com.jidesoft.grid.SortableTable();
        quickTableFilterField1 = new com.jidesoft.grid.QuickTableFilterField();
        jPanel1 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        table.setModel(UrunlerTableModel.urunlerTableModel(IS_DIGER_SUBE));
        table.setSortable(false);
        jScrollPane2.setViewportView(table);

        jButton1.setText("Kaydet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("-");

        jButton2.setText("Fiyatları Eşle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(quickTableFilterField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(quickTableFilterField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /* if (!table.isEditing()) {
         TableModel model = table.getModel();
         int rowCount = model.getRowCount();
         jProgressBar1.setMaximum(rowCount);
         UrunlerJpaController controller = new UrunlerJpaController(EntityHelper.getEmf());
         for (int i = 0; i < rowCount; i++) {
         new Thread(new thread1(i)).start();
         Urunler urun = (Urunler) model.getValueAt(i, 1);
         try {

         Double alis = 0.00;
         Double satis = 0.00;
         Double satis2 = 0.00;
         Float satis3 = new Float("0.00");
         Double stok = 0.00;
         if (model.getValueAt(i, 2) != null) {
         try {

         alis = Double.parseDouble(model.getValueAt(i, 2).toString());
         } catch (Exception e) {
         }
         }
         if (model.getValueAt(i, 3) != null) {
         try {
         satis = Double.parseDouble(model.getValueAt(i, 3).toString());
         } catch (Exception e) {
         }
         }
         if (model.getValueAt(i, 4) != null) {
         try {
         satis2 = Double.parseDouble(model.getValueAt(i, 4).toString());

         } catch (Exception e) {
         }
         }
         if (model.getValueAt(i, 5) != null) {
         try {
         satis3 = Float.parseFloat(model.getValueAt(i, 5).toString());

         } catch (Exception e) {
         }
         }
         if (model.getValueAt(i, 6) != null) {
         try {
         stok = Double.parseDouble(model.getValueAt(i, 6).toString());
         } catch (Exception e) {
         }
         }
         urun.setUrunSatisFiyat(satis);
         urun.setUrunSatisFiyat2(satis2);
         urun.setUrunSatisFiyat3(satis3);
         urun.setUrunAlisFiyat(alis);
         urun.setUrunStokSeviye(stok);

         controller.edit(urun);

         } catch (Exception e) {
         e.printStackTrace();
         }
         }
         } else {
         JOptionPane.showMessageDialog(this, "Tabloda yazma aktif bırakmak için herangi bi ürün adına tıkla");
         }*/
        // metot();

        task = new Task();
        task.start();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fiyatEsleTask = new FiyatEsleTask();
        fiyatEsleTask.start();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.jidesoft.grid.QuickTableFilterField quickTableFilterField1;
    private com.jidesoft.grid.SortableTable table;
    // End of variables declaration//GEN-END:variables

    private void fiyatEsle() {
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        if (!table.isEditing()) {
            TableModel model = table.getModel();
            final int rowCount = model.getRowCount();
            jProgressBar1.setMaximum(rowCount);
            jProgressBar1.setVisible(true);
            Connection con = null;
            PreparedStatement pstmt = null;
            try {
                con = DaoHelper.instance().getConnection(Helper.getConfigs().get("diger_sube_ip"));
                for (int i = 0; i < rowCount; i++) {
                    final int cur = i;
                    Double alis = 0.00;
                    Double satis = 0.00;
                    Double satis2 = 0.00;
                    Double satis3 = 0.00;
                    if (model.getValueAt(i, 2) != null) {
                        try {

                            alis = Double.parseDouble(model.getValueAt(i, 2).toString());
                        } catch (Exception e) {
                        }
                    }
                    if (model.getValueAt(i, 3) != null) {
                        try {
                            satis = Double.parseDouble(model.getValueAt(i, 3).toString());
                        } catch (Exception e) {
                        }
                    }
                    if (model.getValueAt(i, 4) != null) {
                        try {
                            satis2 = Double.parseDouble(model.getValueAt(i, 4).toString());

                        } catch (Exception e) {
                        }
                    }
                    if (model.getValueAt(i, 5) != null) {
                        try {
                            satis3 = Double.parseDouble(model.getValueAt(i, 5).toString());

                        } catch (Exception e) {
                        }
                    }
                  
                    String barkod = model.getValueAt(i, 0).toString();
                    pstmt = con.prepareStatement("UPDATE urunler SET URUN_ALIS_FIYAT=?,"
                            + "URUN_SATIS_FIYAT=?,URUN_SATIS_FIYAT2=?,URUN_SATIS_FIYAT3=? where BARKOD_ID=?");
                    pstmt.setDouble(1, alis);
                    pstmt.setDouble(2, satis);
                    pstmt.setDouble(3, satis2);
                    pstmt.setDouble(4, satis3);
                    pstmt.setString(6, barkod);
                    pstmt.executeUpdate();
                    System.out.println(i);
                    try {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                jProgressBar1.setValue(cur);
                            }
                        });
                    } catch (Exception e) {

                    }
                }
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                jButton1.setEnabled(true);
                jButton2.setEnabled(true);
            }
            jProgressBar1.setVisible(false);
            JOptionPane.showMessageDialog(this, "Kaydedildi");
        } else {
            JOptionPane.showMessageDialog(this, "Tabloda yazma aktif bırakmak için herangi bi ürün adına tıkla");
        }

        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
    }

    private void metot() {
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        if (!table.isEditing()) {
            TableModel model = table.getModel();
            final int rowCount = model.getRowCount();
            jProgressBar1.setMaximum(rowCount);
            jProgressBar1.setVisible(true);
            Connection con = null;
            PreparedStatement pstmt = null;
            try {
                if (IS_DIGER_SUBE) {
                    con = DaoHelper.instance().getConnection(Helper.getConfigs().get("diger_sube_ip"));
                } else {
                    con = DaoHelper.instance().getConnection();
                }
                for (int i = 0; i < rowCount; i++) {
                    final int cur = i;
                    Double alis = 0.00;
                    Double satis = 0.00;
                    Double satis2 = 0.00;
                    Double satis3 = 0.00;
                    Double stok = 0.00;
                    if (model.getValueAt(i, 2) != null) {
                        try {

                            alis = Double.parseDouble(model.getValueAt(i, 2).toString());
                        } catch (Exception e) {
                        }
                    }
                    if (model.getValueAt(i, 3) != null) {
                        try {
                            satis = Double.parseDouble(model.getValueAt(i, 3).toString());
                        } catch (Exception e) {
                        }
                    }
                    if (model.getValueAt(i, 4) != null) {
                        try {
                            satis2 = Double.parseDouble(model.getValueAt(i, 4).toString());

                        } catch (Exception e) {
                        }
                    }
                    if (model.getValueAt(i, 5) != null) {
                        try {
                            satis3 = Double.parseDouble(model.getValueAt(i, 5).toString());

                        } catch (Exception e) {
                        }
                    }
                    if (model.getValueAt(i, 6) != null) {
                        try {
                            stok = Double.parseDouble(model.getValueAt(i, 6).toString());
                        } catch (Exception e) {
                        }
                    }
                    String barkod = model.getValueAt(i, 0).toString();
                    pstmt = con.prepareStatement("UPDATE urunler SET URUN_ALIS_FIYAT=?,"
                            + "URUN_SATIS_FIYAT=?,URUN_SATIS_FIYAT2=?,URUN_SATIS_FIYAT3=?,URUN_STOK_SEVIYE=? where BARKOD_ID=?");
                    pstmt.setDouble(1, alis);
                    pstmt.setDouble(2, satis);
                    pstmt.setDouble(3, satis2);
                    pstmt.setDouble(4, satis3);
                    pstmt.setDouble(5, stok);
                    pstmt.setString(6, barkod);
                    pstmt.executeUpdate();
                    System.out.println(i);
                    try {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                jProgressBar1.setValue(cur);
                            }
                        });
                    } catch (Exception e) {

                    }
                }

                pstmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
                jButton1.setEnabled(true);
                jButton2.setEnabled(true);
            }
            jProgressBar1.setVisible(false);
            JOptionPane.showMessageDialog(this, "Kaydedildi");
        } else {
            JOptionPane.showMessageDialog(this, "Tabloda yazma aktif bırakmak için herangi bi ürün adına tıkla");
        }

        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
    }

    private class Task extends Thread {

        public Task() {
        }

        @Override
        public void run() {
            metot();
        }
    }

    private class FiyatEsleTask extends Thread {
        public FiyatEsleTask() {
        }
        @Override
        public void run() {
            fiyatEsle();
        }
    }
}
