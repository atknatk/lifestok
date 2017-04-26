/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.impl;

import com.lifeweb.dao.OlcuBirimleriDao;
import com.lifeweb.dao.pojo.OlcuBirimleri;
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
public class OlcuBirimleriDaoImpl implements OlcuBirimleriDao {
private final static Logger LOGGER = Logger.getLogger(OlcuBirimleriDaoImpl.class
            .getName());
    @Override
    public int createOlcuBirimleri(OlcuBirimleri olcuBirimleri) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("INSERT INTO olcu_birimleri ( BIRIM_ADI, BIRIM_DURUM)"
                    + " VALUES (?, ?)");
            pstmt.setString(1, olcuBirimleri.getBirimAdi());
            pstmt.setString(3, olcuBirimleri.getBirimDurum());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
       LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
            }
        return -1;
    }

    @Override
    public List<OlcuBirimleri> getOlcuBirimleriList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<OlcuBirimleri> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT BIRIM_ID,BIRIM_ADI,BIRIM_DURUM FROM olcu_birimleri ORDER BY BIRIM_ADI ASC ");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                OlcuBirimleri data = new OlcuBirimleri();
                data.setBirimId(rs.getInt(1));
                data.setBirimAdi(rs.getString(2));
                data.setBirimDurum(rs.getString(3));
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
    public OlcuBirimleri getOlcuBirimleri(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        OlcuBirimleri data = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT BIRIM_ID,BIRIM_ADI,BIRIM_DURUM "
                    + "FROM olcu_birimleri where BIRIM_ID=?");
              pstmt.setInt(1, id);
          
            rs = pstmt.executeQuery();
            if (rs.next()) {
                data = new OlcuBirimleri();
                data.setBirimId(rs.getInt(1));
                data.setBirimAdi(rs.getString(2));
                data.setBirimDurum(rs.getString(3));

            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
         LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
         } 

        return data;
    }

    @Override
    public OlcuBirimleri editOlcuBirimleri(OlcuBirimleri olcuBirimleri) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("UPDATE olcu_birimleri BIRIM_ADI=?,BIRIM_DURUM=? WHERE BIRIM_ID=?");
            pstmt.setString(1, olcuBirimleri.getBirimAdi());
            pstmt.setString(2, olcuBirimleri.getBirimDurum());
            pstmt.setInt(3, olcuBirimleri.getBirimId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
        LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
          }
        return olcuBirimleri;
    }

    @Override
    public void removeOlcuBirimleri(OlcuBirimleri olcuBirimleri) {

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("delete from  olcu_birimleri WHERE BIRIM_ID=?");
            pstmt.setInt(1, olcuBirimleri.getBirimId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
       LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
           } 
    }
}
