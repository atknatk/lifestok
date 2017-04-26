/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.kullanicilar;

import com.lifeweb.dao.controller.KullaniciController;
import com.lifeweb.dao.controller.UrunlerController;
import com.lifeweb.dao.impl.KullaniciDaoImpl;
import com.lifeweb.dao.impl.UrunlerDaoImpl;
import com.lifeweb.dao.pojo.Kullanici;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.ui.islemler.UrunlerTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author AtiTuvi-PC
 */
public class KullaniciTableModel {
     private static List _rows;
    private static final long serialVersionUID = -1833788400619626721L;
    private static Object[][] data;
    private static String[] header;


        public static TableModel kullaniciTableModel(boolean empty) {
        RoomTableListWithChild(empty);
        _rows = new ArrayList();
        _rows.addAll(Arrays.asList(data));
        return new KullaniciTableModel.QuoteTableModel();
    }

        

    private static void RoomTableListWithChild(boolean empty) {
        KullaniciController controller = new KullaniciController(new KullaniciDaoImpl());
                List<Kullanici> kullaniciList = controller.getKullaniciList();
        header = new String[]{"Kullanıcı Id","Kullanıcı Adı", "Adı", "Soyadı"};
        if (!empty) {
             data = new Object[kullaniciList.size()][8];
        for (int i = 0; i < kullaniciList.size(); i++) {
            Kullanici kul = kullaniciList.get(i);
            data[i][0] = kul.getKullaniciId();
            data[i][1] = kul.getKullaniciAdi();
            data[i][2] = kul.getAdi();
            data[i][3] = kul.getSoyadi();
        }
        }else{
                    data = new Object[0][3];
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
            return String.class;
        }
    }
}
