/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.impl;

import com.lifeweb.dao.OdemeTurleriLineDao;
import com.lifeweb.dao.pojo.OdemeTurleriLine;
import com.lifeweb.enitity.helper.DaoHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Life
 */
public class OdemeTurleriLineDaoImpl implements OdemeTurleriLineDao {

    @Override
    public int createOdemeTurleriLine(OdemeTurleriLine line) {

        try {
            if (line.getTutar() == 0) {
                return 0;
            }
            Connection con = DaoHelper.instance().getConnection();
            try (PreparedStatement pstmt = con.prepareStatement("INSERT INTO odeme_turleri_line(ODEME_ID,SATIS_FISI_ID,TUTAR,HESAP_TURU)"
                    + " VALUES (?,?,?,?)")) {
                pstmt.setInt(1, line.getOdemeId().getOdemeId());
                pstmt.setInt(2, line.getSatisFisiId());
                pstmt.setDouble(3, line.getTutar());
                pstmt.setString(4, line.getHesapTuru());
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;

    }

    @Override
    public List<OdemeTurleriLine> getOdemeTurleriLineList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OdemeTurleriLine getOdemeTurleriLine(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OdemeTurleriLine editOdemeTurleriLine(OdemeTurleriLine urunler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeOdemeTurleriLine(OdemeTurleriLine urunler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
