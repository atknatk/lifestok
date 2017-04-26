/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import com.lifeweb.dao.pojo.SatisFisi;
import java.util.List;



public interface SatisFisiDao {

    int createSatisFisi(SatisFisi satisFisi);

    List<SatisFisi> getSatisFisi();

    SatisFisi getSatisFisi(int id);

    SatisFisi editSatisFisi(SatisFisi satisFisi);

    void removeSatisFisi(SatisFisi satisFisi);
}
