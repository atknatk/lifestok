/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.controller;

import com.lifeweb.dao.MarkalarDao;
import com.lifeweb.dao.pojo.Markalar;
import java.util.List;

public class MarkalarController {

    private MarkalarDao marklarDao;

    public MarkalarController(MarkalarDao marklarDao) {
        this. marklarDao = marklarDao;
    }

    public MarkalarDao getMarkalarDao() {
        return  marklarDao;
    }

    public List<Markalar> getMarkalarList() {
        return getMarkalarDao().getMarkalarList();
    }

    public Markalar getMarkalar(int id) {
        return getMarkalarDao().getMarkalar(id);
    }

    

    public Markalar editMarkalar(Markalar markalar) {
        return getMarkalarDao().editMarkalar(markalar);
    }

    public void removeMarkalar(Markalar markalar) {
        getMarkalarDao().removeMarkalar(markalar);
    }


    public int createMarkalar(Markalar markalar) {
        return getMarkalarDao().createMarkalar(markalar);
    }
    
}
