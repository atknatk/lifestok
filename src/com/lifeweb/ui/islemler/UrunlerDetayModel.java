package com.lifeweb.ui.islemler;

import com.lifeweb.enitity.helper.DaoHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Life
 */
public class UrunlerDetayModel {

    private static List _rows;
    private static final long serialVersionUID = -1833788400649626721L;
    private static Object[][] data;
    private static String[] header;

 
 public static TableModel urunlerDetayTableModel(int urun_id) {
        getUrunDetayData(urun_id);
        _rows = new ArrayList();
        _rows.addAll(Arrays.asList(data));
        return new QuoteTableModel();
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

    private static void getUrunDetayData(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT count(satis_fisi_line_id) FROM satis_fisi_line where urun_id=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            header = new String[]{"Ürün Adı", "Fiş Tarihi", "Fiş Saati", "Miktar","Birim Fiyatı", "İndirim Oranı", "İndirim Miktarı", "Tutar", "Kasiyer"};
     
            if (rs.next()) {
                int count = rs.getInt(1);
                pstmt = con.prepareStatement("SELECT ur.urun_adi,sf.fis_tarihi, sf.fis_saati,sfl.miktar,sfl.birim_fiyati, sfl.indirim_orani,sfl.birim_fiyati-sfl.tutar as indirim_miktari, sfl.tutar,concat(kul.adi,' ',kul.soyadi) as isim FROM satis_fisi_line  as sfl left join  satis_fisi as sf on sf.SATIS_FISI_ID=sfl.SATIS_FISI_ID left join urunler as ur on ur.urun_id=sfl.urun_id left join odeme_turleri_line as otl on otl.satis_fisi_id=sf.satis_fisi_id left join odeme_turleri as ot on ot.odeme_id=otl.odeme_id left join kullanici as kul on kul.KULLANICI_ID=sf.sys_ekleyen where ur.urun_id=?");
                pstmt.setInt(1, id);
                rs = pstmt.executeQuery();

                data = new Object[count][8];
                int i = 0;
                 Format formatter = new SimpleDateFormat("dd MMMM yyyy, EEEE");
                while (rs.next()) {
                    data[i][0] = rs.getString(1);
                    data[i][1] = formatter.format(new Date(rs.getDate(2).getTime()));
                    data[i][2] = rs.getDate(3);
                    data[i][3] = rs.getDouble(4);
                    data[i][4] = rs.getDouble(5);
                    data[i][5] = rs.getDouble(6);
                    data[i][6] = rs.getDouble(7);
                    data[i][7] = rs.getDouble(8);
                    data[i][8] = rs.getString(9);
                    i++;
                }
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
        } 
    }
}
