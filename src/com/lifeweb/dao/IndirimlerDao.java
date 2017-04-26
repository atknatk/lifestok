/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import com.lifeweb.dao.pojo.Indirimler;
import java.util.List;

public interface IndirimlerDao {

    int createIndirimler(Indirimler indirimler);

    void createIndirimler(List<Indirimler> indirimlers);
    
    List<Indirimler> getIndirimlerTekList(String ad);

    List<Indirimler> getIndirimlerCokList(String ad);

    List<Indirimler> getIndirimlerList();

    List<Indirimler> getIndirimlerTekList();

    List<Indirimler> getIndirimlerCokList();

    List<String> getIndirimlerTekAdList();

    List<String> getIndirimlerCokAdList();
    
    Indirimler getIndirimler(int id);

    Indirimler editIndirimler(Indirimler indirimler);

    void removeIndirimler(Indirimler indirimler);
}
