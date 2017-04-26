package com.lifeweb.dao;

import com.lifeweb.dao.pojo.CariHesaplar;
import java.util.List;

public interface CariHesaplarDao{ List<CariHesaplar> getCariHesaplarList();

    CariHesaplar getCariHesaplar(int id);

    CariHesaplar setCariHesaplar(CariHesaplar cariHesaplar);

    void removeCariHesaplar(CariHesaplar cariHesaplar);
    
     void updateCariHesaplar(CariHesaplar cariHesaplar,CariHesaplar newCariHesaplar);

    int getCariHesaplarId(CariHesaplar cariHesaplar);    
}
