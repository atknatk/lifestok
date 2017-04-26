package com.lifeweb.dao.impl;

import com.lifeweb.dao.MarkalarDao;
import com.lifeweb.dao.pojo.Markalar;
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
public class MarkalarDaoImpl implements MarkalarDao {
private final static Logger LOGGER = Logger.getLogger(MarkalarDaoImpl.class
            .getName());

    @Override
    public int createMarkalar(Markalar markalar) {
        Connection con;
        PreparedStatement pstmt;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("INSERT INTO markalar ( MARKA_ADI, MARKA_DURUM)"
                    + " VALUES (?, ?)");
            pstmt.setString(1, markalar.getMarkaAdi());
            pstmt.setString(2, markalar.getMarkaDurum());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
         LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
          } 

        return -1;
    }

    @Override
    public List<Markalar> getMarkalarList() {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        ArrayList<Markalar> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT MARKA_ID,MARKA_ADI,MARKA_DURUM FROM markalar ORDER BY MARKA_ADI ASC ");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Markalar data = new Markalar();
                data.setMarkaId(rs.getInt(1));
                data.setMarkaAdi(rs.getString(2));
                data.setMarkaDurum(rs.getString(3));
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
    public Markalar getMarkalar(int id) {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        Markalar data = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT MARKA_ID,MARKA_ADI,MARKA_DURUM "
                    + "FROM markalar where MARKA_ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                data = new Markalar();
                data.setMarkaId(rs.getInt(1));
                data.setMarkaAdi(rs.getString(2));
                data.setMarkaDurum(rs.getString(3));

            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
       LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
           }

        return data;
    }

    @Override
    public Markalar editMarkalar(Markalar markalar) {
        Connection con;
        PreparedStatement pstmt;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("UPDATE markalar MARKA_ADI=?,MARKA_DURUM=? WHERE MARKA_ID=?");
            pstmt.setString(1, markalar.getMarkaAdi());
            pstmt.setString(2, markalar.getMarkaDurum());
            pstmt.setInt(3, markalar.getMarkaId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
      LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
             }
        return markalar;
    }

    @Override
    public void removeMarkalar(Markalar markalar) {

        Connection con;
        PreparedStatement pstmt;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("delete from  markalar WHERE MARKA_ID=?");
            pstmt.setInt(1, markalar.getMarkaId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
       LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(),e);
           }
    }
}
