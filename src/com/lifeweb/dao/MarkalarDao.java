/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import com.lifeweb.dao.pojo.Markalar;
import java.util.List;

public interface MarkalarDao {

    int createMarkalar(Markalar markalar);

    List<Markalar> getMarkalarList();

    Markalar getMarkalar(int id);

    Markalar editMarkalar(Markalar markalar);

    void removeMarkalar(Markalar markalar);

}