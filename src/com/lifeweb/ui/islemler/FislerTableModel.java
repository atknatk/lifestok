/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.islemler;

import com.lifeweb.enitity.AlimFisi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Life
 */
public class FislerTableModel {

    private static List _rows;
    private static final long serialVersionUID = -1833788400649626721L;
    private static Object[][] data;
    private static String[] header;

    public static TableModel getFislerTableModel() {
        RoomTableListWithChild();
        _rows = new ArrayList();
        _rows.addAll(Arrays.asList(data));
        return new UrunlerTableModel.QuoteTableModel();
    }

    private static void RoomTableListWithChild() {
//        AlimFisiJpaController controller = new AlimFisiJpaController(EntityHelper.getEmf());
//        List<AlimFisi> alimFisis = controller.findAlimFisiEntities();
//        data = new Object[alimFisis.size()][8];
//        header = new String[]{"Fiş Tarihi", "Fiş Saati", "Fiş Türü", "Belge No", "Açıklama", "Hesap Adı", "Fiş Tutarı", "id"};
//        for (int i = 0; i < alimFisis.size(); i++) {
//            AlimFisi cariFis = alimFisis.get(i);
//            data[i][0] = cariFis.getFisTarihi();
//            data[i][1] = cariFis.getFisSaati();
//            data[i][2] = cariFis;
//            data[i][3] = cariFis.getBelgeNo();
//            data[i][4] = cariFis.getAciklama();
//            data[i][5] = cariFis.getHesapId();
//            data[i][6] = cariFis.getGenelToplam();
//        }

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
            if (columnIndex == 2) {
                return AlimFisi.class;
            }
            return String.class;
        }
    }
}