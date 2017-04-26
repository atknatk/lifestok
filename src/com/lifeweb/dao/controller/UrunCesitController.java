/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.controller;

import com.lifeweb.dao.UrunCesitDao;
import com.lifeweb.dao.pojo.UrunCesit;
import java.util.List;

public class UrunCesitController {

    private UrunCesitDao marklarDao;

    public UrunCesitController(UrunCesitDao marklarDao) {
        this. marklarDao = marklarDao;
    }

    public UrunCesitDao getUrunCesitDao() {
        return  marklarDao;
    }

    public List<UrunCesit> getUrunCesitList() {
        return getUrunCesitDao().getUrunCesitList();
    }

    public UrunCesit getUrunCesit(int id) {
        return getUrunCesitDao().getUrunCesit(id);
    }

    

    public UrunCesit editUrunCesit(UrunCesit urunCesit) {
        return getUrunCesitDao().editUrunCesit(urunCesit);
    }

    public void removeUrunCesit(UrunCesit urunCesit) {
        getUrunCesitDao().removeUrunCesit(urunCesit);
    }


    public int createUrunCesit(UrunCesit urunCesit) {
        return getUrunCesitDao().createUrunCesit(urunCesit);
    }
    
}
