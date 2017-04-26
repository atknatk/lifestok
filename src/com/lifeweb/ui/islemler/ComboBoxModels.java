/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.islemler;

import com.lifeweb.dao.controller.MarkalarController;
import com.lifeweb.dao.controller.OlcuBirimleriController;
import com.lifeweb.dao.controller.UrunCesitController;
import com.lifeweb.dao.controller.UrunGrupController;
import com.lifeweb.dao.impl.MarkalarDaoImpl;
import com.lifeweb.dao.impl.OlcuBirimleriDaoImpl;
import com.lifeweb.dao.impl.UrunCesitDaoImpl;
import com.lifeweb.dao.impl.UrunGrupDaoImpl;
import com.lifeweb.dao.pojo.KdvGrup;
import com.lifeweb.dao.pojo.Markalar;
import com.lifeweb.dao.pojo.OlcuBirimleri;
import com.lifeweb.dao.pojo.UrunCesit;
import com.lifeweb.dao.pojo.UrunGrup;
import com.lifeweb.enitity.helper.DaoHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author VELI
 */
public class ComboBoxModels {
    
    
    public static DefaultComboBoxModel<OlcuBirimleri> getOlcuBirimiModel(){
        DefaultComboBoxModel<OlcuBirimleri> model = new DefaultComboBoxModel<>();
        OlcuBirimleriController controller = new OlcuBirimleriController(new OlcuBirimleriDaoImpl());
        List<OlcuBirimleri> list = controller.getOlcuBirimleriList();
        for (OlcuBirimleri olcuBirimleri : list) {
            model.addElement(olcuBirimleri);
        }
        return model;
    }
    
    
    public static DefaultComboBoxModel<Markalar> getMarkalarModel(){
        DefaultComboBoxModel<Markalar> model = new DefaultComboBoxModel<>();
        MarkalarController controller = new MarkalarController(new MarkalarDaoImpl());
        List<Markalar> list = controller.getMarkalarList();
        for (Markalar markalar : list) {
            model.addElement(markalar);
        }
        return model;
    }
    
    public static DefaultComboBoxModel<UrunCesit> getUrunCesitModel(){
        DefaultComboBoxModel<UrunCesit> model = new DefaultComboBoxModel<>();
        UrunCesitController controller = new UrunCesitController(new UrunCesitDaoImpl());
        List<UrunCesit> list = controller.getUrunCesitList();
        for (UrunCesit urunCesit : list) {
            model.addElement(urunCesit);
        }
        return model;
    }
    
    public static DefaultComboBoxModel<UrunGrup> getUrunGrupModel(){
        DefaultComboBoxModel<UrunGrup> model = new DefaultComboBoxModel<>();
        UrunGrupController controller = new UrunGrupController(new UrunGrupDaoImpl());
        List<UrunGrup> list = controller.getUrunGrupList();
        for (UrunGrup ug : list) {
            model.addElement(ug);
        }
        return model;
    }
    
    public static DefaultComboBoxModel<KdvGrup> getKDVModel(){
        DefaultComboBoxModel<KdvGrup> model = new DefaultComboBoxModel<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<KdvGrup> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT KDV_GRUP_NO,KDV_GRUP_ORAN, KDV_ACIKLAMA FROM kdv_grup");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                KdvGrup data = new KdvGrup();
                data.setKdvGrupNo(rs.getShort(1));
                data.setKdvGrupOran(rs.getShort(2));
                data.setKdvAciklama(rs.getString(3));
                list.add(data);
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        for (KdvGrup kdvGrup : list) {
            model.addElement(kdvGrup);
        }
        return model;
    }
}
