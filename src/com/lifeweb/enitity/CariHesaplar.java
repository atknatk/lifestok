/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "cari_hesaplar", catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ADI_SOYADI", "SEMT", "SEHIR"}),
    @UniqueConstraint(columnNames = {"MUSTERI_NO"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CariHesaplar.findAll", query = "SELECT c FROM CariHesaplar c"),
    @NamedQuery(name = "CariHesaplar.findByMusteriId", query = "SELECT c FROM CariHesaplar c WHERE c.musteriId = :musteriId"),
    @NamedQuery(name = "CariHesaplar.findByMusteriNo", query = "SELECT c FROM CariHesaplar c WHERE c.musteriNo = :musteriNo"),
    @NamedQuery(name = "CariHesaplar.findByAdiSoyadi", query = "SELECT c FROM CariHesaplar c WHERE c.adiSoyadi = :adiSoyadi"),
    @NamedQuery(name = "CariHesaplar.findByAdres", query = "SELECT c FROM CariHesaplar c WHERE c.adres = :adres"),
    @NamedQuery(name = "CariHesaplar.findByAdres2", query = "SELECT c FROM CariHesaplar c WHERE c.adres2 = :adres2"),
    @NamedQuery(name = "CariHesaplar.findBySemt", query = "SELECT c FROM CariHesaplar c WHERE c.semt = :semt"),
    @NamedQuery(name = "CariHesaplar.findBySehir", query = "SELECT c FROM CariHesaplar c WHERE c.sehir = :sehir"),
    @NamedQuery(name = "CariHesaplar.findByTelefon1", query = "SELECT c FROM CariHesaplar c WHERE c.telefon1 = :telefon1"),
    @NamedQuery(name = "CariHesaplar.findByTelefon2", query = "SELECT c FROM CariHesaplar c WHERE c.telefon2 = :telefon2"),
    @NamedQuery(name = "CariHesaplar.findByFaxno", query = "SELECT c FROM CariHesaplar c WHERE c.faxno = :faxno"),
    @NamedQuery(name = "CariHesaplar.findByYetkili", query = "SELECT c FROM CariHesaplar c WHERE c.yetkili = :yetkili"),
    @NamedQuery(name = "CariHesaplar.findByVergiDairesi", query = "SELECT c FROM CariHesaplar c WHERE c.vergiDairesi = :vergiDairesi"),
    @NamedQuery(name = "CariHesaplar.findByVergiNo", query = "SELECT c FROM CariHesaplar c WHERE c.vergiNo = :vergiNo"),
    @NamedQuery(name = "CariHesaplar.findByEposta", query = "SELECT c FROM CariHesaplar c WHERE c.eposta = :eposta"),
    @NamedQuery(name = "CariHesaplar.findByTuru", query = "SELECT c FROM CariHesaplar c WHERE c.turu = :turu"),
    @NamedQuery(name = "CariHesaplar.findByOzelKod", query = "SELECT c FROM CariHesaplar c WHERE c.ozelKod = :ozelKod"),
    @NamedQuery(name = "CariHesaplar.findByOzelFiyat", query = "SELECT c FROM CariHesaplar c WHERE c.ozelFiyat = :ozelFiyat"),
    @NamedQuery(name = "CariHesaplar.findByCariAktif", query = "SELECT c FROM CariHesaplar c WHERE c.cariAktif = :cariAktif"),
    @NamedQuery(name = "CariHesaplar.findBySysEkleyen", query = "SELECT c FROM CariHesaplar c WHERE c.sysEkleyen = :sysEkleyen"),
    @NamedQuery(name = "CariHesaplar.findBySysEtarih", query = "SELECT c FROM CariHesaplar c WHERE c.sysEtarih = :sysEtarih"),
    @NamedQuery(name = "CariHesaplar.findBySysDuzelten", query = "SELECT c FROM CariHesaplar c WHERE c.sysDuzelten = :sysDuzelten"),
    @NamedQuery(name = "CariHesaplar.findBySysDtarih", query = "SELECT c FROM CariHesaplar c WHERE c.sysDtarih = :sysDtarih"),
    @NamedQuery(name = "CariHesaplar.findByRiskLimit", query = "SELECT c FROM CariHesaplar c WHERE c.riskLimit = :riskLimit"),
    @NamedQuery(name = "CariHesaplar.findByCariIskonto", query = "SELECT c FROM CariHesaplar c WHERE c.cariIskonto = :cariIskonto")})
public class CariHesaplar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MUSTERI_ID", nullable = false)
    private Integer musteriId;
    @Column(name = "MUSTERI_NO", length = 20)
    private String musteriNo;
    @Column(name = "ADI_SOYADI", length = 60)
    private String adiSoyadi;
    @Column(length = 80)
    private String adres;
    @Column(length = 80)
    private String adres2;
    @Column(length = 20)
    private String semt;
    @Column(length = 30)
    private String sehir;
    @Column(length = 20)
    private String telefon1;
    @Column(length = 20)
    private String telefon2;
    @Column(length = 20)
    private String faxno;
    @Column(length = 50)
    private String yetkili;
    @Column(name = "VERGI_DAIRESI", length = 30)
    private String vergiDairesi;
    @Column(name = "VERGI_NO", length = 20)
    private String vergiNo;
    @Column(length = 200)
    private String eposta;
    @Column(length = 20)
    private String turu;
    @Column(name = "OZEL_KOD", length = 20)
    private String ozelKod;
    @Column(name = "OZEL_FIYAT")
    private Short ozelFiyat;
    @Column(name = "CARI_AKTIF")
    private Integer cariAktif;
    @Column(name = "SYS_EKLEYEN", length = 15)
    private String sysEkleyen;
    @Column(name = "SYS_ETARIH")
    private Integer sysEtarih;
    @Column(name = "SYS_DUZELTEN", length = 15)
    private String sysDuzelten;
    @Column(name = "SYS_DTARIH")
    private Integer sysDtarih;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "RISK_LIMIT", precision = 15, scale = 2)
    private Double riskLimit;
    @Column(name = "CARI_ISKONTO")
    private Integer cariIskonto;
    @OneToMany(mappedBy = "hesapId", fetch = FetchType.EAGER)
    private List<SatisFisi> satisFisiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hesapId", fetch = FetchType.EAGER)
    private List<AlimFisi> alimFisiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "musteriRef", fetch = FetchType.EAGER)
    private List<CariFisler> cariFislerList;

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

    @XmlTransient
    @JsonIgnore
    public List<SatisFisi> getSatisFisiList() {
        return satisFisiList;
    }

    public void setSatisFisiList(List<SatisFisi> satisFisiList) {
        this.satisFisiList = satisFisiList;
    }

    @XmlTransient
    @JsonIgnore
    public List<AlimFisi> getAlimFisiList() {
        return alimFisiList;
    }

    public void setAlimFisiList(List<AlimFisi> alimFisiList) {
        this.alimFisiList = alimFisiList;
    }

    @XmlTransient
    @JsonIgnore
    public List<CariFisler> getCariFislerList() {
        return cariFislerList;
    }

    public void setCariFislerList(List<CariFisler> cariFislerList) {
        this.cariFislerList = cariFislerList;
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
        return "com.lifeweb.enitity.CariHesaplar[ musteriId=" + musteriId + " ]";
    }
    
}
