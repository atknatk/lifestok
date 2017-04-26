/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.pojo;

import com.lifeweb.enitity.Urunler;

/**
 *
 * @author Life
 */
public class AlisFiyatPojo {
    private Urunler urun;
    private double miktar;
    private double alisFiyati;

    public Urunler getUrun() {
        return urun;
    }

    public void setUrun(Urunler urun) {
        this.urun = urun;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public double getAlisFiyati() {
        return alisFiyati;
    }

    public void setAlisFiyati(double alisFiyati) {
        this.alisFiyati = alisFiyati;
    }
}
