package com.lifeweb.ui.islemler;

import com.lifeweb.dao.controller.KullaniciController;
import com.lifeweb.dao.impl.KullaniciDaoImpl;
import com.lifeweb.dao.pojo.Kullanici;


public class LoginIslemler {

    public static Kullanici login(String kul, String sifre) {
        return new KullaniciController(new KullaniciDaoImpl()).getKullanici(kul, sifre);
    }
}
