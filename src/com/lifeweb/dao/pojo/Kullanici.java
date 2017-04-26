package com.lifeweb.dao.pojo;

import com.lifeweb.enitity.SatisFisi;
import java.io.Serializable;
import java.util.ArrayList;

public class Kullanici implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer kullaniciId;
    private String kullaniciAdi;
    private String sifre;
    private String adi;
    private String soyadi;
    private String yetki;
    private String diger;
    private ArrayList<SatisFisi> satisFisiList;

    public Kullanici() {
    }

    public Kullanici(Integer kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Kullanici(Integer kullaniciId, String kullaniciAdi, String sifre, String adi, String soyadi, String yetki) {
        this.kullaniciId = kullaniciId;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.adi = adi;
        this.soyadi = soyadi;
        this.yetki = yetki;
    }

    public Integer getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(Integer kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getYetki() {
        return yetki;
    }

    public void setYetki(String yetki) {
        this.yetki = yetki;
    }

    public String getDiger() {
        return diger;
    }

    public void setDiger(String diger) {
        this.diger = diger;
    }

    public ArrayList<SatisFisi> getSatisFisiList() {
        return satisFisiList;
    }

    public void setSatisFisiList(ArrayList<SatisFisi> satisFisiList) {
        this.satisFisiList = satisFisiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciId != null ? kullaniciId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        if ((this.kullaniciId == null && other.kullaniciId != null) || (this.kullaniciId != null && !this.kullaniciId.equals(other.kullaniciId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return adi + " " + soyadi;
    }
}
