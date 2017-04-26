package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class SatisFisiLine implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer satisFisiLineId;
    private double miktar;
    private double indirimOrani;
    private double birimFiyati;
    private double tutar;
    private String seriNo;
    private double alisFiyati;
    private Urunler urunId;
    private SatisFisi satisFisiId;

    public SatisFisiLine() {
    }

    public SatisFisiLine(Integer satisFisiLineId) {
        this.satisFisiLineId = satisFisiLineId;
    }

    public SatisFisiLine(Integer satisFisiLineId, double miktar, double indirimOrani, double birimFiyati, double tutar, double alisFiyati) {
        this.satisFisiLineId = satisFisiLineId;
        this.miktar = miktar;
        this.indirimOrani = indirimOrani;
        this.birimFiyati = birimFiyati;
        this.tutar = tutar;
        this.alisFiyati = alisFiyati;
    }

    public Integer getSatisFisiLineId() {
        return satisFisiLineId;
    }

    public void setSatisFisiLineId(Integer satisFisiLineId) {
        this.satisFisiLineId = satisFisiLineId;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public double getIndirimOrani() {
        return indirimOrani;
    }

    public void setIndirimOrani(double indirimOrani) {
        this.indirimOrani = indirimOrani;
    }

    public double getBirimFiyati() {
        return birimFiyati;
    }

    public void setBirimFiyati(double birimFiyati) {
        this.birimFiyati = birimFiyati;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }

    public double getAlisFiyati() {
        return alisFiyati;
    }

    public void setAlisFiyati(double alisFiyati) {
        this.alisFiyati = alisFiyati;
    }

    public Urunler getUrunId() {
        return urunId;
    }

    public void setUrunId(Urunler urunId) {
        this.urunId = urunId;
    }

    public SatisFisi getSatisFisiId() {
        return satisFisiId;
    }

    public void setSatisFisiId(SatisFisi satisFisiId) {
        this.satisFisiId = satisFisiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (satisFisiLineId != null ? satisFisiLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SatisFisiLine)) {
            return false;
        }
        SatisFisiLine other = (SatisFisiLine) object;
        if ((this.satisFisiLineId == null && other.satisFisiLineId != null) || (this.satisFisiLineId != null && !this.satisFisiLineId.equals(other.satisFisiLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.SatisFisiLine[ satisFisiLineId=" + satisFisiLineId + " ]";
    }
    
}
