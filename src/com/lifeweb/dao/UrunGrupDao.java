/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;
import com.lifeweb.dao.pojo.UrunGrup;
import java.util.List;

public interface UrunGrupDao {

    int createUrunGrup(UrunGrup urunGrup);

    List<UrunGrup> getUrunGrupList();

    UrunGrup getUrunGrup(int id);

    UrunGrup editUrunGrup(UrunGrup urunGrup);

    void removeUrunGrup(UrunGrup urunGrup);

}