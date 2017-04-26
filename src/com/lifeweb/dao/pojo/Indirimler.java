package com.lifeweb.dao.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Indirimler implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer indId;
    private Date btarih;
    private Date etarih;
    private double indOran;
    private double indMinMiktar;
    private boolean indDurum;
    private Kullanici indEkleyen;
    private Date indEtarih;
    private Urunler urunRef;
    private boolean tekUrun;
    private String indAdi;
    private double indNet;
    private boolean yuzde;

    public String getIndAdi() {
        return indAdi;
    }

    public void setIndAdi(String indAdi) {
        this.indAdi = indAdi;
    }

    public double getIndNet() {
        return indNet;
    }

    public void setIndNet(double indNet) {
        this.indNet = indNet;
    }

    public boolean isYuzde() {
        return yuzde;
    }

    public void setYuzde(boolean yuzde) {
        this.yuzde = yuzde;
    }
    
    
    
    private ArrayList<IndirimAltGrup> indirimAltGrups;

    public boolean isTekUrun() {
        return tekUrun;
    }

    public void setTekUrun(boolean tekUrun) {
        this.tekUrun = tekUrun;
    }

    public ArrayList<IndirimAltGrup> getIndirimAltGrups() {
        return indirimAltGrups;
    }

    public void setIndirimAltGrups(ArrayList<IndirimAltGrup> indirimAltGrups) {
        this.indirimAltGrups = indirimAltGrups;
    }
    
    

    public Indirimler() {
    }

    public Indirimler(Integer indId) {
        this.indId = indId;
    }

    public Integer getIndId() {
        return indId;
    }

    public void setIndId(Integer indId) {
        this.indId = indId;
    }

    public Date getBtarih() {
        return btarih;
    }

    public void setBtarih(Date btarih) {
        this.btarih = btarih;
    }

    public Date getEtarih() {
        return etarih;
    }

    public void setEtarih(Date etarih) {
        this.etarih = etarih;
    }

    public double getIndOran() {
        return indOran;
    }

    public void setIndOran(double indOran) {
        this.indOran = indOran;
    }

    public double getIndMinMiktar() {
        return indMinMiktar;
    }

    public void setIndMinMiktar(double indMinMiktar) {
        this.indMinMiktar = indMinMiktar;
    }

    public boolean isIndDurum() {
        return indDurum;
    }

    public void setIndDurum(boolean indDurum) {
        this.indDurum = indDurum;
    }


    public Kullanici getIndEkleyen() {
        return indEkleyen;
    }

    public void setIndEkleyen(Kullanici indEkleyen) {
        this.indEkleyen = indEkleyen;
    }

    public Date getIndEtarih() {
        return indEtarih;
    }

    public void setIndEtarih(Date indEtarih) {
        this.indEtarih = indEtarih;
    }

   

    public Urunler getUrunRef() {
        return urunRef;
    }

    public void setUrunRef(Urunler urunRef) {
        this.urunRef = urunRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indId != null ? indId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indirimler)) {
            return false;
        }
        Indirimler other = (Indirimler) object;
        if ((this.indId == null && other.indId != null) || (this.indId != null && !this.indId.equals(other.indId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return indAdi;
    }
    
}
