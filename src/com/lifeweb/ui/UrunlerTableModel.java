package com.lifeweb.ui;

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

    public static TableModel urunlerTableModel(boolean digerSube) {

        RoomTableListWithChild(digerSube);
        _rows = new ArrayList();
        _rows.addAll(Arrays.asList(data));
        return new QuoteTableModel();
    }

    private static void RoomTableListWithChild(boolean digerSube) {
        UrunlerController controller = new UrunlerController(new UrunlerDaoImpl());
        header = new String[]{"Barkod No", "Ürün Adı", "Alış Fiyatı", "Satış Fiyatı 1", "Satış Fiyatı 2", "Satış Fiyatı 3", "Mevcut Stok"};
        if (!digerSube) {
            List<Urunler> urunler = controller.getUrunlerList();

            data = new Object[urunler.size()][7];

            for (int i = 0; i < urunler.size(); i++) {
                Urunler urun = urunler.get(i);
                data[i][0] = urun.getBarkodId();
                data[i][1] = urun;
                data[i][2] = urun.getUrunAlisFiyat();
                data[i][3] = urun.getUrunSatisFiyat();
                data[i][4] = urun.getUrunSatisFiyat2();
                data[i][5] = urun.getUrunSatisFiyat3();
                data[i][6] = urun.getUrunStokSeviye();
            }
        } else {
            List<Urunler> urunler = controller.getUrunlerList(MainUI.getIp());
            data = new Object[urunler.size()][7];
            for (int i = 0; i < urunler.size(); i++) {
                Urunler urun = urunler.get(i);
                data[i][0] = urun.getBarkodId();
                data[i][1] = urun;
                data[i][2] = urun.getUrunAlisFiyat();
                data[i][3] = urun.getUrunSatisFiyat();
                data[i][4] = urun.getUrunSatisFiyat2();
                data[i][5] = urun.getUrunSatisFiyat3();
                data[i][6] = urun.getUrunStokSeviye();
            }
        }

    }

    private static Urunler findUrun(List<Urunler> list, Urunler urun) {
        for (int i = list.size() - 1; i >= 0; i--) {
            Urunler listUrun = list.get(i);
            if (listUrun.equals(urun)) {
                return listUrun;
            }
        }
        return null;
    }

    static class QuoteTableModel extends DefaultTableModel {

        public QuoteTableModel() {
            super(data, header);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex == 0 || columnIndex == 1) {
                return false;
            } else {
                if (getValueAt(rowIndex, columnIndex) == null) {
                    return false;
                }
                return true;
            }
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            } else if (columnIndex == 1) {
                return Urunler.class;
            } else if (columnIndex == 2 || columnIndex == 3 || columnIndex == 4 || columnIndex == 5 || columnIndex == 6 || columnIndex == 7) {
                return Double.class;
            }
            return String.class;
        }
    }
}
