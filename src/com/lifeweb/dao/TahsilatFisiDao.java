package com.lifeweb.dao;

import com.lifeweb.dao.pojo.TahsilatFisi;
import java.util.List;



public interface TahsilatFisiDao {

    int createTahsilatFisi(TahsilatFisi satisFisi);

    List<TahsilatFisi> getTahsilatFisi();

    TahsilatFisi getTahsilatFisi(int id);

    TahsilatFisi editTahsilatFisi(TahsilatFisi satisFisi);

    void removeTahsilatFisi(TahsilatFisi satisFisi);
}
