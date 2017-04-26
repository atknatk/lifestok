package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class CariHesaplarFisiLine implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cariHesaplarFisiLineId;
    private double miktar;
    private double indirimOrani;
    private double birimFiyati;
    private double tutar;
    private String seriNo;
    private double alisFiyati;
    private Urunler urunId;
    private CariHesaplarFisi cariHesaplarFisiId;

    public CariHesaplarFisiLine() {
    }

    public CariHesaplarFisi getCariHesaplarFisiId() {
        return cariHesaplarFisiId;
    }

    public void setCariHesaplarFisiId(CariHesaplarFisi cariHesaplarFisiId) {
        this.cariHesaplarFisiId = cariHesaplarFisiId;
    }

    public Integer getCariHesaplarFisiLineId() {
        return cariHesaplarFisiLineId;
    }

    public void setCariHesaplarFisiLineId(Integer cariHesaplarFisiLineId) {
        this.cariHesaplarFisiLineId = cariHesaplarFisiLineId;
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
    
}
