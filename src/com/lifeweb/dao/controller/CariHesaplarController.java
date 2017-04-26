
package com.lifeweb.dao.controller;

import com.lifeweb.dao.CariHesaplarDao;
import com.lifeweb.dao.pojo.CariHesaplar;
import java.util.List;

public class CariHesaplarController {

    private CariHesaplarDao cariHesaplarDao;

    public CariHesaplarController(CariHesaplarDao urunDao) {
        this.cariHesaplarDao = urunDao;
    }

    public CariHesaplarDao getCariHesaplarDao() {
        return cariHesaplarDao;
    }

    public List<CariHesaplar> getCariHesaplarList() {
        return getCariHesaplarDao().getCariHesaplarList();
    }

    public CariHesaplar getCariHesaplar(int id) {
        return getCariHesaplarDao().getCariHesaplar(id);
    }

    
   

    public void editCariHesaplar(CariHesaplar old,CariHesaplar neww) {
         getCariHesaplarDao().updateCariHesaplar(old, neww);
    }

    public void removeCariHesaplar(CariHesaplar urun) {
        getCariHesaplarDao().removeCariHesaplar(urun);
    }


    public CariHesaplar createCariHesaplar(CariHesaplar urun) {
        return getCariHesaplarDao().setCariHesaplar(urun);
    }
    
}
