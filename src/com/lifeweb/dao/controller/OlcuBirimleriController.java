/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.controller;

import com.lifeweb.dao.OlcuBirimleriDao;
import com.lifeweb.dao.pojo.OlcuBirimleri;
import java.util.List;

public class OlcuBirimleriController {

    private OlcuBirimleriDao olcuBirimleriDao;

    public OlcuBirimleriController(OlcuBirimleriDao olcuBirimleriDao) {
        this. olcuBirimleriDao = olcuBirimleriDao;
    }

    public OlcuBirimleriDao getOlcuBirimleriDao() {
        return  olcuBirimleriDao;
    }

    public List<OlcuBirimleri> getOlcuBirimleriList() {
        return getOlcuBirimleriDao().getOlcuBirimleriList();
    }

    public OlcuBirimleri getOlcuBirimleri(int id) {
        return getOlcuBirimleriDao().getOlcuBirimleri(id);
    }

    

    public OlcuBirimleri editOlcuBirimleri(OlcuBirimleri urun) {
        return getOlcuBirimleriDao().editOlcuBirimleri(urun);
    }

    public void removeOlcuBirimleri(OlcuBirimleri urun) {
        getOlcuBirimleriDao().removeOlcuBirimleri(urun);
    }


    public int createOlcuBirimleri(OlcuBirimleri urun) {
        return getOlcuBirimleriDao().createOlcuBirimleri(urun);
    }
    
}
