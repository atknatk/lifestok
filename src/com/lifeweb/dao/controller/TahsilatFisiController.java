package com.lifeweb.dao.controller;

import com.lifeweb.dao.TahsilatFisiDao;
import com.lifeweb.dao.pojo.TahsilatFisi;
import java.util.List;

public class TahsilatFisiController {

    private final TahsilatFisiDao tahsilatFisiDao;

    public TahsilatFisiController(TahsilatFisiDao urunDao) {
        this.tahsilatFisiDao = urunDao;
    }

    public TahsilatFisiDao getTahsilatFisiDao() {
        return tahsilatFisiDao;
    }

    public List<TahsilatFisi> getTahsilatFisiList() {
        return getTahsilatFisiDao().getTahsilatFisi();
    }

    public TahsilatFisi getTahsilatFisi(int id) {
        return getTahsilatFisiDao().getTahsilatFisi(id);
    }

    
   

    public TahsilatFisi editTahsilatFisi(TahsilatFisi satisFisi) {
        return getTahsilatFisiDao().editTahsilatFisi(satisFisi);
    }

    public void removeTahsilatFisi(TahsilatFisi satisFisi) {
        getTahsilatFisiDao().removeTahsilatFisi(satisFisi);
    }


    public int createTahsilatFisi(TahsilatFisi satisFisi) {
        return getTahsilatFisiDao().createTahsilatFisi(satisFisi);
    }
    
  
    
}
