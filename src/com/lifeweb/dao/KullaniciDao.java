package com.lifeweb.dao;

import com.lifeweb.dao.pojo.Kullanici;
import java.util.List;

public interface KullaniciDao {

    int createKullanici(Kullanici kullanici);

    List<Kullanici> getKullaniciList();

    Kullanici getKullanici(int id);

    Kullanici getKullanici(String kullaniciAdi,String sifre);

    Kullanici editKullanici(Kullanici kullanici);

    void removeKullanici(Kullanici kullanici);

    int getKullaniciId(Kullanici kullanici);
}