package com.lifeweb.dao.impl;

import com.lifeweb.dao.TahsilatFisiDao;
import com.lifeweb.dao.pojo.TahsilatFisi;
import com.lifeweb.enitity.helper.DaoHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

public class TahsilatFisiDaoImpl implements TahsilatFisiDao {

    @Override
    public int createTahsilatFisi(TahsilatFisi satisFisi) {

        try {
            Connection con = DaoHelper.instance().getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO tahsilat_fisi(FIS_TARIHI, FIS_SAATI, OZEL_KODU, BELGE_NO, ACIKLAMA, HESAP_ID, SUBE_ID, GENEL_TOPLAM, SYS_EKLEYEN, CARI_HESAPLAR_ADI) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pstmt.setDate(1, new Date(satisFisi.getFisTarihi().getTime()));
            pstmt.setTime(2, new Time(satisFisi.getFisSaati().getHours(), satisFisi.getFisSaati().getMinutes(), satisFisi.getFisSaati().getSeconds()));
            pstmt.setString(3, satisFisi.getOzelKodu());
            pstmt.setString(4, satisFisi.getBelgeNo());
            pstmt.setString(5, satisFisi.getAciklama());
            pstmt.setNull(6, java.sql.Types.NULL);
            pstmt.setInt(7, satisFisi.getSubeId().getSubeId());
            pstmt.setDouble(13, satisFisi.getGenelToplam());
            pstmt.setInt(14, satisFisi.getSysEkleyen().getKullaniciId());
            pstmt.setString(15, satisFisi.getCariHesaplarAdi());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<TahsilatFisi> getTahsilatFisi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TahsilatFisi getTahsilatFisi(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TahsilatFisi editTahsilatFisi(TahsilatFisi satisFisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTahsilatFisi(TahsilatFisi satisFisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
