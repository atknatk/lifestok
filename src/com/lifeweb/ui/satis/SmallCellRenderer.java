/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.satis;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author VELI
 */
public class SmallCellRenderer  extends DefaultTableCellRenderer {
    
    
    @Override
    public Component getTableCellRendererComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row,
                                                 int column) {
    Component c = 
      super.getTableCellRendererComponent(table, value,
                                          isSelected, hasFocus,
                                          row, column);
   TableColumnModel columnModel = table.getColumnModel();
        int urunAdiIndex = columnModel.getColumnIndex("ÜRÜN ADI");
        int miktarIndex = columnModel.getColumnIndex("MİKTAR");
        int birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
        int indYuzdeIndex = columnModel.getColumnIndex("İND. %");
        int indTutarIndex = columnModel.getColumnIndex("İND. TUTAR");
        int tutarIndex = columnModel.getColumnIndex("TUTAR");
         int barkodIndex = columnModel.getColumnIndex("BARKOD NO");
           c.setForeground(Color.BLACK);
       c.setBackground(Color.CYAN);
    if (column ==  indTutarIndex||column ==  indYuzdeIndex) {
   //    c.setFont(new Font("Arial", Font.PLAIN, 16)); 
    }else if (column ==  tutarIndex) {
   //    c.setFont(new Font("Arial", Font.PLAIN, 24));
        c.setForeground(Color.RED);
    }else{
   //     c.setFont(new Font("Arial", Font.PLAIN, 24));
     }
    return c;
  }
}