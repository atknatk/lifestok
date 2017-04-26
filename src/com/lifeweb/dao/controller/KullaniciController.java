/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.controller;

import com.lifeweb.dao.KullaniciDao;
import com.lifeweb.dao.pojo.Kullanici;
import java.util.List;

public class KullaniciController {

    private KullaniciDao kullaniciDao;

    public KullaniciController(KullaniciDao kullaniciDao) {
        this.kullaniciDao = kullaniciDao;
    }

    public KullaniciDao getKullaniciDao() {
        return kullaniciDao;
    }

    public List<Kullanici> getKullaniciList() {
        return getKullaniciDao().getKullaniciList();
    }

    public Kullanici getKullanici(int id) {
        return getKullaniciDao().getKullanici(id);
    }

    public Kullanici editKullanici(Kullanici kullanici) {
        return getKullaniciDao().editKullanici(kullanici);
    }

    public void removeKullanici(Kullanici kullanici) {
        getKullaniciDao().removeKullanici(kullanici);
    }

    public int getKullaniciId(Kullanici kullanici) {
        return getKullaniciDao().getKullaniciId(kullanici);
    }

    public int createKullanici(Kullanici kullanici) {
        return getKullaniciDao().createKullanici(kullanici);
    }
    
    public  Kullanici getKullanici(String kullaniciAdi,String sifre){
        return getKullaniciDao().getKullanici(kullaniciAdi, sifre);
    }

}
