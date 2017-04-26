package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class Subeler implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer subeId;
    private String subeAdi;
    private String adres;
    private String semt;
    private String sehir;
    private String telefon1;
    private String telefon2;
    private String yetkili;
    private String vergiDairesi;
    private String vergiNo;
    private String ozelKod;
    private Integer subeAktif;
    private String sysEkleyen;
    private Integer sysEtarih;
    private String sysDuzelten;
    private Integer sysDtarih;

    public Subeler() {
    }

    public Subeler(Integer subeId) {
        this.subeId = subeId;
    }

    public Integer getSubeId() {
        return subeId;
    }

    public void setSubeId(Integer subeId) {
        this.subeId = subeId;
    }

    public String getSubeAdi() {
        return subeAdi;
    }

    public void setSubeAdi(String subeAdi) {
        this.subeAdi = subeAdi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSemt() {
        return semt;
    }

    public void setSemt(String semt) {
        this.semt = semt;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getTelefon1() {
        return telefon1;
    }

    public void setTelefon1(String telefon1) {
        this.telefon1 = telefon1;
    }

    public String getTelefon2() {
        return telefon2;
    }

    public void setTelefon2(String telefon2) {
        this.telefon2 = telefon2;
    }

    public String getYetkili() {
        return yetkili;
    }

    public void setYetkili(String yetkili) {
        this.yetkili = yetkili;
    }

    public String getVergiDairesi() {
        return vergiDairesi;
    }

    public void setVergiDairesi(String vergiDairesi) {
        this.vergiDairesi = vergiDairesi;
    }

    public String getVergiNo() {
        return vergiNo;
    }

    public void setVergiNo(String vergiNo) {
        this.vergiNo = vergiNo;
    }

    public String getOzelKod() {
        return ozelKod;
    }

    public void setOzelKod(String ozelKod) {
        this.ozelKod = ozelKod;
    }

    public Integer getSubeAktif() {
        return subeAktif;
    }

    public void setSubeAktif(Integer subeAktif) {
        this.subeAktif = subeAktif;
    }

    public String getSysEkleyen() {
        return sysEkleyen;
    }

    public void setSysEkleyen(String sysEkleyen) {
        this.sysEkleyen = sysEkleyen;
    }

    public Integer getSysEtarih() {
        return sysEtarih;
    }

    public void setSysEtarih(Integer sysEtarih) {
        this.sysEtarih = sysEtarih;
    }

    public String getSysDuzelten() {
        return sysDuzelten;
    }

    public void setSysDuzelten(String sysDuzelten) {
        this.sysDuzelten = sysDuzelten;
    }

    public Integer getSysDtarih() {
        return sysDtarih;
    }

    public void setSysDtarih(Integer sysDtarih) {
        this.sysDtarih = sysDtarih;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subeId != null ? subeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subeler)) {
            return false;
        }
        Subeler other = (Subeler) object;
        if ((this.subeId == null && other.subeId != null) || (this.subeId != null && !this.subeId.equals(other.subeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return subeAdi;
    }
    
}
