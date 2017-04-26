/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.pojo;

/**
 *
 * @author VELI
 */
public class IndirimAltGrup {
    private int id;
    private Indirimler indirimId;
    private Urunler urun;
    private double oran;
    private double net;
    private boolean yuzde;

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public boolean isYuzde() {
        return yuzde;
    }

    public void setYuzde(boolean yuzde) {
        this.yuzde = yuzde;
    }

    public Urunler getUrun() {
        return urun;
    }

    public void setUrun(Urunler urun) {
        this.urun = urun;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Indirimler getIndirimId() {
        return indirimId;
    }

    public void setIndirimId(Indirimler indirimId) {
        this.indirimId = indirimId;
    }

  

    public double getOran() {
        return oran;
    }

    public void setOran(double oran) {
        this.oran = oran;
    }
    
    
}
