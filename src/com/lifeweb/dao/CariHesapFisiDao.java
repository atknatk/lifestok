/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import com.lifeweb.dao.pojo.CariHesaplarFisi;
import java.util.List;



public interface CariHesapFisiDao {

    int createCariHesapFisi(CariHesaplarFisi satisFisi);

    List<CariHesaplarFisi> getCariHesapFisi();

    CariHesaplarFisi getCariHesapFisi(int id);

    CariHesaplarFisi editCariHesapFisi(CariHesaplarFisi satisFisi);

    void removeCariHesapFisi(CariHesaplarFisi satisFisi);
}
