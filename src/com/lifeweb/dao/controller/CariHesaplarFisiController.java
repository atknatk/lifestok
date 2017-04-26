package com.lifeweb.dao.controller;

import com.lifeweb.dao.CariHesapFisiDao;
import com.lifeweb.dao.pojo.CariHesaplarFisi;
import java.util.List;

public class CariHesaplarFisiController {

    private CariHesapFisiDao satisFisiDao;

    public CariHesaplarFisiController(CariHesapFisiDao urunDao) {
        this.satisFisiDao = urunDao;
    }

    public CariHesapFisiDao getCariHesaplarFisiDao() {
        return satisFisiDao;
    }

    public List<CariHesaplarFisi> getCariHesaplarFisiList() {
        return getCariHesaplarFisiDao().getCariHesapFisi();
    }

    public CariHesaplarFisi getCariHesaplarFisi(int id) {
        return getCariHesaplarFisiDao().getCariHesapFisi(id);
    }

    
   

    public CariHesaplarFisi editCariHesaplarFisi(CariHesaplarFisi satisFisi) {
        return getCariHesaplarFisiDao().editCariHesapFisi(satisFisi);
    }

    public void removeCariHesaplarFisi(CariHesaplarFisi satisFisi) {
        getCariHesaplarFisiDao().removeCariHesapFisi(satisFisi);;
    }


    public int createCariHesaplarFisi(CariHesaplarFisi satisFisi) {
        return getCariHesaplarFisiDao().createCariHesapFisi(satisFisi);
    }
    
  
    
}
