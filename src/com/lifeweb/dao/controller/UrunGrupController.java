/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.controller;

import com.lifeweb.dao.UrunGrupDao;
import com.lifeweb.dao.pojo.UrunGrup;
import java.util.List;

public class UrunGrupController {

    private UrunGrupDao marklarDao;

    public UrunGrupController(UrunGrupDao marklarDao) {
        this. marklarDao = marklarDao;
    }

    public UrunGrupDao getUrunGrupDao() {
        return  marklarDao;
    }

    public List<UrunGrup> getUrunGrupList() {
        return getUrunGrupDao().getUrunGrupList();
    }

    public UrunGrup getUrunGrup(int id) {
        return getUrunGrupDao().getUrunGrup(id);
    }

    

    public UrunGrup editUrunGrup(UrunGrup urunGrup) {
        return getUrunGrupDao().editUrunGrup(urunGrup);
    }

    public void removeUrunGrup(UrunGrup urunGrup) {
        getUrunGrupDao().removeUrunGrup(urunGrup);
    }


    public int createUrunGrup(UrunGrup urunGrup) {
        return getUrunGrupDao().createUrunGrup(urunGrup);
    }
    
}
