package com.lifeweb.dao.impl;

import com.lifeweb.dao.IadeFisiDao;
import com.lifeweb.dao.pojo.IadeFisi;
import com.lifeweb.dao.pojo.IadeFisiLine;
import com.lifeweb.enitity.helper.DaoHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.logging.Logger;

public class IadeFisiDaoImpl implements IadeFisiDao {

  

    @Override
    public int createIadeFisi(IadeFisi iadeFisi) {
    

        try {
            Connection con = DaoHelper.instance().getConnection();
           PreparedStatement pstmt = con.prepareStatement("INSERT INTO iade_fisi(FIS_TARIHI,FIS_SAATI,OZEL_KODU,"
                    + "BELGE_NO,ACIKLAMA,HESAP_ID,SUBE_ID,ISKONTO_TUTARI,ISKONTO_ORANI,"
                    + "INDIRIM_TUTARI,ARA_TOPLAM,KDV_TOPLAM,GENEL_TOPLAM,SYS_EKLEYEN,CARI_HESAPLAR_ADI) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pstmt.setDate(1, new Date(iadeFisi.getFisTarihi().getTime()));
            pstmt.setTime(2, new Time(iadeFisi.getFisSaati().getHours(), iadeFisi.getFisSaati().getMinutes(), iadeFisi.getFisSaati().getSeconds()));
            pstmt.setString(3, iadeFisi.getOzelKodu());
            pstmt.setString(4, iadeFisi.getBelgeNo());
            pstmt.setString(5, iadeFisi.getAciklama());
            pstmt.setNull(6, java.sql.Types.NULL);
            pstmt.setInt(7, iadeFisi.getSubeId().getSubeId());
            pstmt.setDouble(8, iadeFisi.getIskontoTutari());
            pstmt.setDouble(9, iadeFisi.getIskontoOrani());
            pstmt.setDouble(10, iadeFisi.getIndirimTutari());
            pstmt.setDouble(11, iadeFisi.getAraToplam());
            pstmt.setDouble(12, iadeFisi.getKdvToplam());
            pstmt.setDouble(13, iadeFisi.getGenelToplam());
            pstmt.setInt(14, iadeFisi.getSysEkleyen().getKullaniciId());
            pstmt.setString(15, iadeFisi.getCariHesaplarAdi());
            pstmt.executeUpdate();
            pstmt = con.prepareStatement("SELECT IADE_FISI_ID FROM iade_fisi ORDER BY IADE_FISI_ID DESC LIMIT 1");
          ResultSet  rs = pstmt.executeQuery();
            if (rs.next()) {
                iadeFisi.setIadeFisiId(rs.getInt(1));
            }
            List<IadeFisiLine> satisFisiLines = iadeFisi.getIadeFisiLineList();
            for (IadeFisiLine satisFisiLine : satisFisiLines) {
                pstmt = con.prepareStatement("INSERT INTO iade_fisi_line(URUN_ID, MIKTAR, INDIRIM_ORANI,BIRIM_FIYATI,"
                        + " TUTAR, SERI_NO, IADE_FISI_ID, ALIS_FIYATI) VALUES (?,?,?,?,?,?,?,?)");
                pstmt.setInt(1, satisFisiLine.getUrunId().getUrunId());
                pstmt.setDouble(2, satisFisiLine.getMiktar());
                pstmt.setDouble(3, satisFisiLine.getIndirimOrani());
                pstmt.setDouble(4, satisFisiLine.getBirimFiyati());
                pstmt.setDouble(5, satisFisiLine.getTutar());
                pstmt.setString(6, satisFisiLine.getSeriNo());
                pstmt.setInt(7, iadeFisi.getIadeFisiId());
                pstmt.setDouble(8, satisFisiLine.getAlisFiyati());
                System.out.println(pstmt.toString());
                pstmt.executeUpdate();

                pstmt = con.prepareStatement("UPDATE urunler SET URUN_STOK_SEVIYE=URUN_STOK_SEVIYE+? WHERE URUN_ID=?");
                pstmt.setDouble(1, satisFisiLine.getMiktar());
                pstmt.setInt(2, satisFisiLine.getUrunId().getUrunId());
                pstmt.executeUpdate();
            }
            pstmt.close();
        } catch (SQLException e) {
    e.printStackTrace();
        } 
        return -1;   }

    @Override
    public List<IadeFisi> getIadeFisi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IadeFisi getIadeFisi(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IadeFisi editIadeFisi(IadeFisi satisFisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeIadeFisi(IadeFisi satisFisi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
