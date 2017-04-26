/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.islemler;

import com.lifeweb.dao.pojo.Urunler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class SatisTableModel {

    private static List _rows;
    private static final long serialVersionUID = -1833788400649626721L;
    private static Object[][] data;
    private static String[] header;

    public static TableModel satisTableModel() {
        RoomTableListWithChild();
        _rows = new ArrayList();
        _rows.addAll(Arrays.asList(data));
        return new QuoteTableModel();
    }

    private static void RoomTableListWithChild() {
        data = new Object[0][7];
        header = new String[]{"BARKOD NO", "ÜRÜN ADI", "MİKTAR", "BİRİM FİYATI", "İND. %", "İND. TUTAR", "TUTAR"};
    }

    static class QuoteTableModel extends DefaultTableModel {

        public QuoteTableModel() {
            super(data, header);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return columnIndex == 2 || columnIndex == 4|| columnIndex == 5;
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 1) {
                return Urunler.class;
            } 
            return String.class;
        }
    }
}
