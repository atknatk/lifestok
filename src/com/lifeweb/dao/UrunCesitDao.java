/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import com.lifeweb.dao.pojo.UrunCesit;
import java.util.List;

public interface UrunCesitDao {

    int createUrunCesit(UrunCesit urunCesit);

    List<UrunCesit> getUrunCesitList();

    UrunCesit getUrunCesit(int id);

    UrunCesit editUrunCesit(UrunCesit urunCesit);

    void removeUrunCesit(UrunCesit urunCesit);

}