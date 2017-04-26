/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.controller;

import com.lifeweb.dao.IndirimlerDao;
import com.lifeweb.dao.pojo.Indirimler;
import java.util.List;

public class IndirimlerController {

    private IndirimlerDao indirimlerDao;

    public IndirimlerController(IndirimlerDao indirimlerDao) {
        this.indirimlerDao = indirimlerDao;
    }

    public IndirimlerDao getIndirimlerDao() {
        return indirimlerDao;
    }

    public List<Indirimler> getIndirimlerList() {
        return getIndirimlerDao().getIndirimlerList();
    }

    public List<Indirimler> getIndirimlerTekList() {
        return getIndirimlerDao().getIndirimlerTekList();
    }

    public List<Indirimler> getIndirimlerCokList() {
        return getIndirimlerDao().getIndirimlerCokList();
    }

     public List<Indirimler> getIndirimlerTelList(String ad) {
        return getIndirimlerDao().getIndirimlerTekList(ad);
    }
     public List<Indirimler> getIndirimlerCokList(String ad) {
        return getIndirimlerDao().getIndirimlerCokList(ad);
    }
    public List<String> getIndirimlerCokAdList() {
        return getIndirimlerDao().getIndirimlerCokAdList();
    }

    public List<String> getIndirimlerTekAdList() {
        return getIndirimlerDao().getIndirimlerTekAdList();
    }

    public Indirimler getIndirimler(int id) {
        return getIndirimlerDao().getIndirimler(id);
    }

    public Indirimler editIndirimler(Indirimler indirimler) {
        return getIndirimlerDao().editIndirimler(indirimler);
    }

    public void removeIndirimler(Indirimler indirimler) {
        getIndirimlerDao().removeIndirimler(indirimler);
    }

    public int createIndirimler(Indirimler indirimler) {
        return getIndirimlerDao().createIndirimler(indirimler);
    }
     public void createIndirimler(List<Indirimler> indirimler) {
         getIndirimlerDao().createIndirimler(indirimler);
    }
}
