package com.lifeweb.dao.controller;

import com.lifeweb.dao.SatisFisiDao;
import com.lifeweb.dao.pojo.SatisFisi;
import java.util.List;

public class SatisFisiController {

    private SatisFisiDao satisFisiDao;

    public SatisFisiController(SatisFisiDao urunDao) {
        this.satisFisiDao = urunDao;
    }

    public SatisFisiDao getSatisFisiDao() {
        return satisFisiDao;
    }

    public List<SatisFisi> getSatisFisiList() {
        return getSatisFisiDao().getSatisFisi();
    }

    public SatisFisi getSatisFisi(int id) {
        return getSatisFisiDao().getSatisFisi(id);
    }

    
   

    public SatisFisi editSatisFisi(SatisFisi satisFisi) {
        return getSatisFisiDao().editSatisFisi(satisFisi);
    }

    public void removeSatisFisi(SatisFisi satisFisi) {
        getSatisFisiDao().removeSatisFisi(satisFisi);
    }


    public int createSatisFisi(SatisFisi satisFisi) {
        return getSatisFisiDao().createSatisFisi(satisFisi);
    }
    
  
    
}
