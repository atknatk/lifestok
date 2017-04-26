/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.impl;

import com.lifeweb.dao.KullaniciDao;
import com.lifeweb.dao.pojo.Kullanici;
import com.lifeweb.enitity.helper.DaoHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Life
 */
public class KullaniciDaoImpl implements KullaniciDao {

    private final static Logger LOGGER = Logger.getLogger(KullaniciDaoImpl.class
            .getName());

    @Override
    public List<Kullanici> getKullaniciList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Kullanici> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("Select KULLANICI_ID, KULLANICI_ADI, SIFRE, ADI, SOYADI, YETKI, DIGER from kullanici");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Kullanici data = new Kullanici();
                data.setKullaniciId(rs.getInt(1));
                data.setKullaniciAdi(rs.getString(2));
                data.setSifre(rs.getString(3));
                data.setAdi(rs.getString(4));
                data.setSoyadi(rs.getString(5));
                data.setYetki(rs.getString(6));
                data.setDiger(rs.getString(7));
                list.add(data);
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
        return list;
    }

    @Override
    public Kullanici getKullanici(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Kullanici data = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("Select KULLANICI_ID,KULLANICI_ADI, SIFRE, ADI, SOYADI, YETKI, DIGER from kullanici where KULLANICI_ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                data = new Kullanici();
                data.setKullaniciId(rs.getInt(1));
                data.setKullaniciAdi(rs.getString(2));
                data.setSifre(rs.getString(3));
                data.setAdi(rs.getString(4));
                data.setSoyadi(rs.getString(5));
                data.setYetki(rs.getString(6));
                data.setDiger(rs.getString(7));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }

        return data;
    }

    @Override
    public Kullanici editKullanici(Kullanici kullanici) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("UPDATE kullanici SET KULLANICI_ADI=?,"
                    + " SIFRE=?, ADI=?, SOYADI=?, YETKI=?, DIGER=? where KULLANICI_ID=?");
            pstmt.setString(1, kullanici.getKullaniciAdi());
            pstmt.setString(2, kullanici.getSifre());
            pstmt.setString(3, kullanici.getAdi());
            pstmt.setString(4, kullanici.getSoyadi());
            pstmt.setString(5, kullanici.getYetki());
            pstmt.setString(6, kullanici.getDiger());
            pstmt.setInt(7, kullanici.getKullaniciId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
        return kullanici;

    }

    @Override
    public void removeKullanici(Kullanici kullanici) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("DELETE FROM kullanici WHERE KULLANICI_ID=?");
            pstmt.setInt(1, kullanici.getKullaniciId());
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
    }

    @Override
    public int getKullaniciId(Kullanici kullanici) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int createKullanici(Kullanici kullanici) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("INSERT INTO kullanici(KULLANICI_ADI, SIFRE,"
                    + " ADI, SOYADI, YETKI, DIGER) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1, kullanici.getKullaniciAdi());
            pstmt.setString(2, kullanici.getSifre());
            pstmt.setString(3, kullanici.getAdi());
            pstmt.setString(4, kullanici.getSoyadi());
            pstmt.setString(5, kullanici.getYetki());
            pstmt.setString(6, kullanici.getDiger());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }

        return -1;
    }

    @Override
    public Kullanici getKullanici(String kullaniciAdi, String sifre) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Kullanici data = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("Select KULLANICI_ID, ADI, SOYADI, YETKI, DIGER from kullanici where KULLANICI_ADI=? and SIFRE=?");
            pstmt.setString(1, kullaniciAdi);
            pstmt.setString(2, sifre);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                data = new Kullanici();
                data.setKullaniciId(rs.getInt(1));
                data.setKullaniciAdi(kullaniciAdi);
                data.setSifre(sifre);
                data.setAdi(rs.getString(2));
                data.setSoyadi(rs.getString(3));
                data.setYetki(rs.getString(4));
                data.setDiger(rs.getString(5));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }

        return data;
    }
}
