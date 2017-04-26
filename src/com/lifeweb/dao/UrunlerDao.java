package com.lifeweb.dao;

import com.lifeweb.dao.pojo.Urunler;
import java.util.List;

public interface UrunlerDao {

    int createUrun(Urunler urunler);

    int createUrunDigerSube(Urunler urunler);

    List<Urunler> getUrunList();

    List<Urunler> getUrunList(String ip);

    Urunler getUrun(int id);

    Urunler getUrun(String barkod);

    Urunler editUrun(Urunler urunler);

    void removeUrun(Urunler urunler);

    void stokEksiUrun(Urunler urunler, Double miktar);
}
