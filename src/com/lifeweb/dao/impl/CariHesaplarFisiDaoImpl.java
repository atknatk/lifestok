/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.impl;

import com.lifeweb.dao.CariHesapFisiDao;
import com.lifeweb.dao.pojo.CariHesaplarFisi;
import com.lifeweb.dao.pojo.CariHesaplarFisiLine;
import com.lifeweb.enitity.helper.DaoHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Life
 */
public class CariHesaplarFisiDaoImpl implements CariHesapFisiDao {

    private final static Logger LOGGER = Logger.getLogger(CariHesaplarFisiDaoImpl.class
            .getName());

    @Override
    public int createCariHesapFisi(CariHesaplarFisi satisFisi) {
    Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("INSERT INTO cari_hesaplar_fisi(FIS_TARIHI,FIS_SAATI,OZEL_KODU,"
                    + "BELGE_NO,ACIKLAMA,HESAP_ID,SUBE_ID,ISKONTO_TUTARI,ISKONTO_ORANI,"
                    + "INDIRIM_TUTARI,ARA_TOPLAM,KDV_TOPLAM,GENEL_TOPLAM,SYS_EKLEYEN,CARI_HESAPLAR_ADI) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pstmt.setDate(1, new Date(satisFisi.getFisTarihi().getTime()));
            pstmt.setTime(2, new Time(satisFisi.getFisSaati().getHours(), satisFisi.getFisSaati().getMinutes(), satisFisi.getFisSaati().getSeconds()));
            pstmt.setString(3, satisFisi.getOzelKodu());
            pstmt.setString(4, satisFisi.getBelgeNo());
            pstmt.setString(5, satisFisi.getAciklama());
            pstmt.setNull(6, java.sql.Types.NULL);
            pstmt.setInt(7, satisFisi.getSubeId().getSubeId());
            pstmt.setDouble(8, satisFisi.getIskontoTutari());
            pstmt.setDouble(9, satisFisi.getIskontoOrani());
            pstmt.setDouble(10, satisFisi.getIndirimTutari());
            pstmt.setDouble(11, satisFisi.getAraToplam());
            pstmt.setDouble(12, satisFisi.getKdvToplam());
            pstmt.setDouble(13, satisFisi.getGenelToplam());
            pstmt.setInt(14, satisFisi.getSysEkleyen().getKullaniciId());
            pstmt.setString(15, satisFisi.getCariHesaplarAdi());
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("SELECT CARI_HESAPLAR_FISI_ID FROM cari_hesaplar_fisi ORDER BY CARI_HESAPLAR_FISI_ID DESC LIMIT 1");
            rs = pstmt.executeQuery();
            if (rs.next()) {
                satisFisi.setCariHesapFisiId(rs.getInt(1));
            }
            List<CariHesaplarFisiLine> satisFisiLines = satisFisi.getSatisFisiLineList();
            for (CariHesaplarFisiLine satisFisiLine : satisFisiLines) {
                pstmt = con.prepareStatement("INSERT INTO cari_hesaplar_fisi_line(URUN_ID, MIKTAR, INDIRIM_ORANI,BIRIM_FIYATI,"
                        + " TUTAR, SERI_NO, CARI_HESAPLAR_FISI_ID, ALIS_FIYATI) VALUES (?,?,?,?,?,?,?,?)");
                pstmt.setInt(1, satisFisiLine.getUrunId().getUrunId());
                pstmt.setDouble(2, satisFisiLine.getMiktar());
                pstmt.setDouble(3, satisFisiLine.getIndirimOrani());
                pstmt.setDouble(4, satisFisiLine.getBirimFiyati());
                pstmt.setDouble(5, satisFisiLine.getTutar());
                pstmt.setString(6, satisFisiLine.getSeriNo());
                pstmt.setInt(7, satisFisi.getCariHesapFisiId());
                pstmt.setDouble(8, satisFisiLine.getAlisFiyati());
                System.out.println(pstmt.toString());
                pstmt.executeUpdate();

                pstmt = con.prepareStatement("UPDATE urunler SET URUN_STOK_SEVIYE=URUN_STOK_SEVIYE-? WHERE URUN_ID=?");
                pstmt.setDouble(1, satisFisiLine.getMiktar());
                pstmt.setInt(2, satisFisiLine.getUrunId().getUrunId());
                pstmt.executeUpdate();
            }
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        } 
        return -1;   }

    @Override
    public List<CariHesaplarFisi> getCariHesapFisi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CariHesaplarFisi getCariHesapFisi(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CariHesaplarFisi editCariHesapFisi(CariHesaplarFisi satisFisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCariHesapFisi(CariHesaplarFisi satisFisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
