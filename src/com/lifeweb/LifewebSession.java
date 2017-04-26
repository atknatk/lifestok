/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lifeweb;

import com.lifeweb.dao.pojo.Kullanici;

/**
 *
 * @author Atakan
 */
public class LifewebSession {
    private static LifewebSession lifewebSession;
    private Kullanici kullanici;

    private LifewebSession() {
    }
    
    public static LifewebSession instance(){
        if (lifewebSession==null) {
            lifewebSession = new LifewebSession();
            return lifewebSession;
        }
        return lifewebSession;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }
    
    
    
}
