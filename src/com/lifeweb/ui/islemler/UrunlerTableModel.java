/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.islemler;


import com.lifeweb.dao.controller.UrunlerController;
import com.lifeweb.dao.impl.UrunlerDaoImpl;
import com.lifeweb.dao.pojo.Urunler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Life
 */
public class UrunlerTableModel {

    private static List _rows;
    private static final long serialVersionUID = -1833788400649626721L;
    private static Object[][] data;
    private static String[] header;

    public static TableModel urunlerTableModel(boolean empty) {
        RoomTableListWithChild(empty);
        _rows = new ArrayList();
        _rows.addAll(Arrays.asList(data));
        return new QuoteTableModel();
    }
    
   

    private static void RoomTableListWithChild(boolean empty) {
        UrunlerController controller = new UrunlerController(new UrunlerDaoImpl());
        List<Urunler> cariHesaplars = controller.getUrunlerList();
        header = new String[]{"Barkod No", "Ürün Adı", "Birim", "KDV", "Satış Fiyatı", "Mevcut Stok", "Ürün Markası","Çeşit Tanımı"};
        if (!empty) {
             data = new Object[cariHesaplars.size()][8];
        for (int i = 0; i < cariHesaplars.size(); i++) {
            Urunler urun = cariHesaplars.get(i);
            data[i][0] = urun.getBarkodId();
            data[i][1] = urun;
            data[i][2] = urun.getBirimRef().getBirimAdi();
            data[i][3] = urun.getUrunKdvGrup().getKdvGrupOran();
            data[i][4] = urun.getUrunSatisFiyat();
            data[i][5] = urun.getUrunStokSeviye();
            data[i][6] = urun.getMarkaRef()==null?"Tanımsız":urun.getMarkaRef().getMarkaAdi();
            data[i][7] = urun.getUrunCesit().getCesitAdi();
        }
        }else{
                    data = new Object[0][8];
     
        }
    }

    static class QuoteTableModel extends DefaultTableModel {

   

        public QuoteTableModel() {
            super(data, header);
        }
     
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex==8) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            if (columnIndex==2) {
            return Urunler.class;    
            }else  if (columnIndex==8) {
                return Double.class;
            }
            return String.class;
        }
    }
}