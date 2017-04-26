/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.islemler;

import com.lifeweb.dao.controller.CariHesaplarController;
import com.lifeweb.dao.impl.CariHesaplarDaoImpl;
import com.lifeweb.dao.pojo.CariHesaplar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Atakan
 */
public class CariHesapTableModel {

    private static List _rows;
    private static final long serialVersionUID = -1833788400649626721L;
    private static Object[][] data;
    private static String[] header;

    public static TableModel cariTableModel() {
        RoomTableListWithChild();
        _rows = new ArrayList();
        _rows.addAll(Arrays.asList(data));
        return new QuoteTableModel();
    }

    public static void RoomTableListWithChild() {
        CariHesaplarController controller = new CariHesaplarController(new CariHesaplarDaoImpl());
        List<CariHesaplar> cariHesaplars =controller.getCariHesaplarList();

        data = new Object[cariHesaplars.size()][7];
        header = new String[]{"Türü", "Kart No", "Cari Hesap Adı", "Yetkili Kişi", "Telefon", "Şehir", "Özel Kodu"};
        for (int i = 0; i < cariHesaplars.size(); i++) {
            CariHesaplar hesaplar = cariHesaplars.get(i);
            data[i][0] = hesaplar.getTuru();
            data[i][1] = hesaplar.getMusteriNo();
            data[i][2] = hesaplar;
            data[i][3] = hesaplar.getYetkili();
            data[i][4] = hesaplar.getTelefon1();
            data[i][5] = hesaplar.getSehir();
            data[i][6] = hesaplar.getOzelKod();

        }

    }

    static class QuoteTableModel extends DefaultTableModel {

   

        public QuoteTableModel() {
            super(data, header);
        }
     
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Class getColumnClass(int columnIndex) {
           if(columnIndex==2){
                return CariHesaplar.class;
           }else{
                return String.class;
           }
        }
    }
}