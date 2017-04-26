/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import com.lifeweb.dao.pojo.IadeFisi;
import java.util.List;



public interface IadeFisiDao {

    int createIadeFisi(IadeFisi satisFisi);

    List<IadeFisi> getIadeFisi();

    IadeFisi getIadeFisi(int id);

    IadeFisi editIadeFisi(IadeFisi satisFisi);

    void removeIadeFisi(IadeFisi satisFisi);
}
