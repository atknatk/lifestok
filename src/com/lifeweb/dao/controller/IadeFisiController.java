package com.lifeweb.dao.controller;

import com.lifeweb.dao.IadeFisiDao;
import com.lifeweb.dao.IadeFisiDao;
import com.lifeweb.dao.pojo.IadeFisi;
import com.lifeweb.dao.pojo.IadeFisi;
import java.util.List;

public class IadeFisiController {

    private IadeFisiDao iadeFisiDao;

    public IadeFisiController(IadeFisiDao urunDao) {
        this.iadeFisiDao = urunDao;
    }

    public IadeFisiDao getIadeFisiDao() {
        return iadeFisiDao;
    }

    public List<IadeFisi> getIadeFisiList() {
        return getIadeFisiDao().getIadeFisi();
    }

    public IadeFisi getIadeFisi(int id) {
        return getIadeFisiDao().getIadeFisi(id);
    }

    
   

    public IadeFisi editIadeFisi(IadeFisi satisFisi) {
        return getIadeFisiDao().editIadeFisi(satisFisi);
    }

    public void removeIadeFisi(IadeFisi satisFisi) {
        getIadeFisiDao().removeIadeFisi(satisFisi);
    }


    public int createIadeFisi(IadeFisi satisFisi) {
        return getIadeFisiDao().createIadeFisi(satisFisi);
    }
    
  
    
}
