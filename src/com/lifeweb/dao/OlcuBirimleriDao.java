/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import com.lifeweb.dao.pojo.OlcuBirimleri;
import java.util.List;

public interface OlcuBirimleriDao {

    int createOlcuBirimleri(OlcuBirimleri olcuBirimleri);

    List<OlcuBirimleri> getOlcuBirimleriList();

    OlcuBirimleri getOlcuBirimleri(int id);

    OlcuBirimleri editOlcuBirimleri(OlcuBirimleri olcuBirimleri);

    void removeOlcuBirimleri(OlcuBirimleri olcuBirimleri);

}
