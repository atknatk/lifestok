
package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class CariHesaplar implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer musteriId;
    private String musteriNo;
    private String adiSoyadi;
    private String adres;
    private String adres2;
    private String semt;
    private String sehir;
    private String telefon1;
    private String telefon2;
    private String faxno;
    private String yetkili;
    private String vergiDairesi;
    private String vergiNo;
    private String eposta;
    private String turu;
    private String ozelKod;
    private Short ozelFiyat;
    private Integer cariAktif;
    private String sysEkleyen;
    private Integer sysEtarih;
    private String sysDuzelten;
    private Integer sysDtarih;
    private Double riskLimit;
    private Integer cariIskonto;
    public CariHesaplar() {
    }

    public CariHesaplar(Integer musteriId) {
        this.musteriId = musteriId;
    }

    public Integer getMusteriId() {
        return musteriId;
    }

    public void setMusteriId(Integer musteriId) {
        this.musteriId = musteriId;
    }

    public String getMusteriNo() {
        return musteriNo;
    }

    public void setMusteriNo(String musteriNo) {
        this.musteriNo = musteriNo;
    }

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getAdres2() {
        return adres2;
    }

    public void setAdres2(String adres2) {
        this.adres2 = adres2;
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

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String faxno) {
        this.faxno = faxno;
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

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getOzelKod() {
        return ozelKod;
    }

    public void setOzelKod(String ozelKod) {
        this.ozelKod = ozelKod;
    }

    public Short getOzelFiyat() {
        return ozelFiyat;
    }

    public void setOzelFiyat(Short ozelFiyat) {
        this.ozelFiyat = ozelFiyat;
    }

    public Integer getCariAktif() {
        return cariAktif;
    }

    public void setCariAktif(Integer cariAktif) {
        this.cariAktif = cariAktif;
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

    public Double getRiskLimit() {
        return riskLimit;
    }

    public void setRiskLimit(Double riskLimit) {
        this.riskLimit = riskLimit;
    }

    public Integer getCariIskonto() {
        return cariIskonto;
    }

    public void setCariIskonto(Integer cariIskonto) {
        this.cariIskonto = cariIskonto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (musteriId != null ? musteriId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CariHesaplar)) {
            return false;
        }
        CariHesaplar other = (CariHesaplar) object;
        if ((this.musteriId == null && other.musteriId != null) || (this.musteriId != null && !this.musteriId.equals(other.musteriId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return adiSoyadi;
    }
    
}
