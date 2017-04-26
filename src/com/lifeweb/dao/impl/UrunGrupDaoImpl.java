/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.impl;

import com.lifeweb.dao.UrunGrupDao;
import com.lifeweb.dao.pojo.UrunGrup;
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
public class UrunGrupDaoImpl implements UrunGrupDao {
private final static Logger LOGGER = Logger.getLogger(UrunGrupDaoImpl.class
            .getName());
    @Override
    public int createUrunGrup(UrunGrup urunGrup) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("INSERT INTO urun_grup ( URUN_GRUP_ADI, URUN_GRUP_DURUM)"
                    + " VALUES (?, ?)");
            pstmt.setString(1, urunGrup.getUrunGrupAdi());
            pstmt.setString(3, urunGrup.getUrunGrupDurum());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
       LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
           }
        return -1;
    }

    @Override
    public List<UrunGrup> getUrunGrupList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UrunGrup> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT URUN_GRUP_ID,URUN_GRUP_ADI, URUN_GRUP_DURUM FROM urun_grup ORDER BY URUN_GRUP_ADI ASC ");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UrunGrup data = new UrunGrup();
                data.setUrunGrupId(rs.getInt(1));
                data.setUrunGrupAdi(rs.getString(2));
                data.setUrunGrupDurum(rs.getString(3));
                list.add(data);
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
         LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
          } 
        return list;
    }

    @Override
    public UrunGrup getUrunGrup(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UrunGrup data = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT URUN_GRUP_ID,URUN_GRUP_ADI, URUN_GRUP_DURUM "
                    + "FROM urun_grup where GRUP_ID=?");
              pstmt.setInt(1, id);
          
            rs = pstmt.executeQuery();
            if (rs.next()) {
                data = new UrunGrup();
                data.setUrunGrupId(rs.getInt(1));
                data.setUrunGrupAdi(rs.getString(2));
                data.setUrunGrupDurum(rs.getString(3));

            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
         LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
           } 
        return data;
    }

    @Override
    public UrunGrup editUrunGrup(UrunGrup urunGrup) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("UPDATE urun_grup URUN_GRUP_ADI=?, URUN_GRUP_DURUM=? WHERE URUN_GRUP_ID=?");
            pstmt.setString(1, urunGrup.getUrunGrupAdi());
            pstmt.setString(2, urunGrup.getUrunGrupDurum());
            pstmt.setInt(3, urunGrup.getUrunGrupId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
          LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
          }
        return urunGrup;
    }

    @Override
    public void removeUrunGrup(UrunGrup urunGrup) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("delete from  urun_grup WHERE URUN_GRUP_ID=?");
            pstmt.setInt(1, urunGrup.getUrunGrupId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
        LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
          } 
    }
}
