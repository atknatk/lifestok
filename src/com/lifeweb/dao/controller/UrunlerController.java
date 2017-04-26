package com.lifeweb.dao.controller;

import com.lifeweb.dao.UrunlerDao;
import com.lifeweb.dao.pojo.Urunler;
import java.util.List;

public class UrunlerController {

    private UrunlerDao urunDao;

    public UrunlerController(UrunlerDao urunDao) {
        this.urunDao = urunDao;
    }

    public UrunlerDao getUrunlerDao() {
        return urunDao;
    }

    public List<Urunler> getUrunlerList() {
        return getUrunlerDao().getUrunList();
    }

    public List<Urunler> getUrunlerList(String ip) {
        return getUrunlerDao().getUrunList(ip);
    }

    public Urunler getUrunler(int id) {
        return getUrunlerDao().getUrun(id);
    }

    public Urunler getUrunler(String barkod) {
        return getUrunlerDao().getUrun(barkod);
    }

    public Urunler editUrunler(Urunler urun) {
        return getUrunlerDao().editUrun(urun);
    }

    public void removeUrunler(Urunler urun) {
        getUrunlerDao().removeUrun(urun);
    }

    public int createUrunler(Urunler urun) {
        return getUrunlerDao().createUrun(urun);
    }

    public int createUrunlerDigerSube(Urunler urun) {
        return getUrunlerDao().createUrunDigerSube(urun);
    }

    public void stokEksiUrun(Urunler urun, Double miktar) {
        getUrunlerDao().stokEksiUrun(urun, miktar);
    }

}
