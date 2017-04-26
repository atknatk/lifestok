/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.impl;

import com.lifeweb.DMGenel;
import com.lifeweb.LifewebDateUtils;
import com.lifeweb.LifewebSession;
import com.lifeweb.dao.CariHesaplarDao;
import com.lifeweb.dao.pojo.CariHesaplar;
import com.lifeweb.enitity.helper.DaoHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Atakan
 */
public class CariHesaplarDaoImpl implements CariHesaplarDao {

    private String table = "cari_hesaplar";

    @Override
    public List<CariHesaplar> getCariHesaplarList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<CariHesaplar> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT MUSTERI_ID, MUSTERI_NO, ADI_SOYADI,"
                    + " ADRES, ADRES2, SEMT, SEHIR, TELEFON1, TELEFON2, FAXNO, YETKILI,"
                    + " VERGI_DAIRESI, VERGI_NO, EPOSTA, TURU, OZEL_KOD, OZEL_FIYAT,"
                    + " CARI_AKTIF, SYS_EKLEYEN, SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH,"
                    + " RISK_LIMIT, CARI_ISKONTO FROM cari_hesaplar");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                CariHesaplar data = new CariHesaplar();
                data.setMusteriId(rs.getInt(1));
                data.setMusteriNo(rs.getString(2));
                data.setAdiSoyadi(rs.getString(3));
                data.setAdres(rs.getString(4));
                data.setAdres2(rs.getString(5));
                data.setSemt(rs.getString(6));
                data.setSehir(rs.getString(7));
                data.setTelefon1(rs.getString(8));
                data.setTelefon2(rs.getString(9));
                data.setFaxno(rs.getString(10));
                data.setYetkili(rs.getString(11));
                data.setVergiDairesi(rs.getString(12));
                data.setVergiNo(rs.getString(13));
                data.setEposta(rs.getString(14));
                data.setTuru(rs.getString(15));
                data.setOzelKod(rs.getString(16));
                data.setOzelFiyat(rs.getShort(17));
                data.setCariAktif(rs.getInt(18));
                data.setSysEkleyen(rs.getString(19));
                data.setSysEtarih(rs.getInt(20));
                data.setSysDuzelten(rs.getString(21));
                data.setSysDtarih(rs.getInt(22));
                data.setRiskLimit(rs.getDouble(23));
                data.setCariIskonto(rs.getInt(24));
                list.add(data);
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
        }
        return list;
    }

    @Override
    public CariHesaplar getCariHesaplar(int id) {
        CariHesaplar data = null;
        try {
            Connection con = DaoHelper.instance().getConnection();
            PreparedStatement pstmt = con.prepareStatement("SELECT MUSTERI_ID, MUSTERI_NO, ADI_SOYADI,"
                    + " ADRES, ADRES2, SEMT, SEHIR, TELEFON1, TELEFON2, FAXNO, YETKILI,"
                    + " VERGI_DAIRESI, VERGI_NO, EPOSTA, TURU, OZEL_KOD, OZEL_FIYAT,"
                    + " CARI_AKTIF, SYS_EKLEYEN, SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH,"
                    + " RISK_LIMIT, CARI_ISKONTO FROM cari_hesaplar where MUSTERI_ID=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                data = new CariHesaplar();
                data.setMusteriId(rs.getInt(1));
                data.setMusteriNo(rs.getString(2));
                data.setAdiSoyadi(rs.getString(3));
                data.setAdres(rs.getString(4));
                data.setAdres2(rs.getString(5));
                data.setSemt(rs.getString(6));
                data.setSehir(rs.getString(7));
                data.setTelefon1(rs.getString(8));
                data.setTelefon2(rs.getString(9));
                data.setFaxno(rs.getString(10));
                data.setYetkili(rs.getString(11));
                data.setVergiDairesi(rs.getString(12));
                data.setVergiNo(rs.getString(13));
                data.setEposta(rs.getString(14));
                data.setTuru(rs.getString(15));
                data.setOzelKod(rs.getString(16));
                data.setOzelFiyat(rs.getShort(17));
                data.setCariAktif(rs.getInt(18));
                data.setSysEkleyen(rs.getString(19));
                data.setSysEtarih(rs.getInt(20));
                data.setSysDuzelten(rs.getString(21));
                data.setSysDtarih(rs.getInt(22));
                data.setRiskLimit(rs.getDouble(23));
                data.setCariIskonto(rs.getInt(24));

            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
        }
        return data;
    }

    @Override
    public CariHesaplar setCariHesaplar(CariHesaplar data) {
        try {
            Connection con = DaoHelper.instance().getConnection();
            String query = DMGenel.MyNewInstance().myPrepareSqlWithoutID("trInsert", con, table);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setObject(1, data.getMusteriNo());
            pstmt.setObject(2, data.getAdiSoyadi());
            pstmt.setObject(3, data.getAdres());
            pstmt.setObject(4, data.getAdres2());
            pstmt.setObject(5, data.getSemt());
            pstmt.setObject(6, data.getSehir());
            pstmt.setObject(7, data.getTelefon1());
            pstmt.setObject(8, data.getTelefon2());
            pstmt.setObject(9, data.getFaxno());
            pstmt.setObject(10, data.getYetkili());
            pstmt.setObject(11, data.getVergiDairesi());
            pstmt.setObject(12, data.getVergiNo());
            pstmt.setObject(13, data.getEposta());
            pstmt.setObject(14, data.getTuru());
            pstmt.setObject(15, data.getOzelKod());
            pstmt.setObject(16, data.getOzelFiyat());
            pstmt.setObject(17, data.getCariAktif());
            pstmt.setObject(18, LifewebSession.instance().getKullanici().getAdi());
            pstmt.setObject(19, LifewebDateUtils.myGetNow());
            pstmt.setObject(20, java.sql.Types.NULL);
            pstmt.setObject(21, java.sql.Types.NULL);
            pstmt.setObject(22, data.getRiskLimit());
            pstmt.setObject(23, data.getCariIskonto());
            System.out.println(pstmt.toString());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void removeCariHesaplar(CariHesaplar cariHesaplar) {
        Connection con = null;
        try {
            con = DaoHelper.instance().getConnection();
            String query = DMGenel.MyNewInstance().myPrepareSql("trDelete", con, table);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, cariHesaplar.getMusteriId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getCariHesaplarId(CariHesaplar cariHesaplar) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCariHesaplar(CariHesaplar old, CariHesaplar data) {
        Connection con = null;
        try {
            con = DaoHelper.instance().getConnection();
            String query = DMGenel.MyNewInstance().myPrepareSql("trModify", con, table);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setObject(1, data.getMusteriNo());
            pstmt.setObject(2, data.getAdiSoyadi());
            pstmt.setObject(3, data.getAdres());
            pstmt.setObject(4, data.getAdres2());
            pstmt.setObject(5, data.getSemt());
            pstmt.setObject(6, data.getSehir());
            pstmt.setObject(7, data.getTelefon1());
            pstmt.setObject(8, data.getTelefon2());
            pstmt.setObject(9, data.getFaxno());
            pstmt.setObject(10, data.getYetkili());
            pstmt.setObject(11, data.getVergiDairesi());
            pstmt.setObject(12, data.getVergiNo());
            pstmt.setObject(13, data.getEposta());
            pstmt.setObject(14, data.getTuru());
            pstmt.setObject(15, data.getOzelKod());
            pstmt.setObject(16, data.getOzelFiyat());
            pstmt.setObject(17, data.getCariAktif());
            pstmt.setObject(18, LifewebSession.instance().getKullanici().getAdi());
            pstmt.setObject(19, LifewebDateUtils.myGetNow());
            pstmt.setObject(20, java.sql.Types.NULL);
            pstmt.setObject(21, java.sql.Types.NULL);
            pstmt.setObject(22, data.getRiskLimit());
            pstmt.setObject(23, data.getCariIskonto());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
