/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.impl;

import com.lifeweb.dao.UrunCesitDao;
import com.lifeweb.dao.pojo.UrunCesit;
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
public class UrunCesitDaoImpl implements UrunCesitDao {
private final static Logger LOGGER = Logger.getLogger(UrunCesitDaoImpl.class
            .getName());
    @Override
    public int createUrunCesit(UrunCesit urunCesit) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("INSERT INTO urun_cesit ( CESIT_ADI, CESIT_DURUM)"
                    + " VALUES (?, ?)");
            pstmt.setString(1, urunCesit.getCesitAdi());
            pstmt.setString(3, urunCesit.getCesitDurum());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
        LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
           }

        return -1;
    }

    @Override
    public List<UrunCesit> getUrunCesitList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<UrunCesit> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT CESIT_ID,CESIT_ADI,CESIT_DURUM FROM urun_cesit ORDER BY CESIT_ADI ASC ");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                UrunCesit data = new UrunCesit();
                data.setCesitId(rs.getInt(1));
                data.setCesitAdi(rs.getString(2));
                data.setCesitDurum(rs.getString(3));
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
    public UrunCesit getUrunCesit(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        UrunCesit data = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT CESIT_ID,CESIT_ADI,CESIT_DURUM "
                    + "FROM urun_cesit where CESIT_ID=?");
              pstmt.setInt(1, id);
          
            rs = pstmt.executeQuery();
            if (rs.next()) {
                data = new UrunCesit();
                data.setCesitId(rs.getInt(1));
                data.setCesitAdi(rs.getString(2));
                data.setCesitDurum(rs.getString(3));

            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
       LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
              }
        return data;
    }

    @Override
    public UrunCesit editUrunCesit(UrunCesit urunCesit) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("UPDATE urun_cesit CESIT_ADI=?,CESIT_DURUM=? WHERE CESIT_ID=?");
            pstmt.setString(1, urunCesit.getCesitAdi());
            pstmt.setString(2, urunCesit.getCesitDurum());
            pstmt.setInt(3, urunCesit.getCesitId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
         LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
          } 
        return urunCesit;
    }

    @Override
    public void removeUrunCesit(UrunCesit urunCesit) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("delete from  olcu_birimleri WHERE CESIT_ID=?");
            pstmt.setInt(1, urunCesit.getCesitId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
       LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
           } 
    }
}
