/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

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
@Table(catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"SUBE_ADI"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subeler.findAll", query = "SELECT s FROM Subeler s"),
    @NamedQuery(name = "Subeler.findBySubeId", query = "SELECT s FROM Subeler s WHERE s.subeId = :subeId"),
    @NamedQuery(name = "Subeler.findBySubeAdi", query = "SELECT s FROM Subeler s WHERE s.subeAdi = :subeAdi"),
    @NamedQuery(name = "Subeler.findByAdres", query = "SELECT s FROM Subeler s WHERE s.adres = :adres"),
    @NamedQuery(name = "Subeler.findBySemt", query = "SELECT s FROM Subeler s WHERE s.semt = :semt"),
    @NamedQuery(name = "Subeler.findBySehir", query = "SELECT s FROM Subeler s WHERE s.sehir = :sehir"),
    @NamedQuery(name = "Subeler.findByTelefon1", query = "SELECT s FROM Subeler s WHERE s.telefon1 = :telefon1"),
    @NamedQuery(name = "Subeler.findByTelefon2", query = "SELECT s FROM Subeler s WHERE s.telefon2 = :telefon2"),
    @NamedQuery(name = "Subeler.findByYetkili", query = "SELECT s FROM Subeler s WHERE s.yetkili = :yetkili"),
    @NamedQuery(name = "Subeler.findByVergiDairesi", query = "SELECT s FROM Subeler s WHERE s.vergiDairesi = :vergiDairesi"),
    @NamedQuery(name = "Subeler.findByVergiNo", query = "SELECT s FROM Subeler s WHERE s.vergiNo = :vergiNo"),
    @NamedQuery(name = "Subeler.findByOzelKod", query = "SELECT s FROM Subeler s WHERE s.ozelKod = :ozelKod"),
    @NamedQuery(name = "Subeler.findBySubeAktif", query = "SELECT s FROM Subeler s WHERE s.subeAktif = :subeAktif"),
    @NamedQuery(name = "Subeler.findBySysEkleyen", query = "SELECT s FROM Subeler s WHERE s.sysEkleyen = :sysEkleyen"),
    @NamedQuery(name = "Subeler.findBySysEtarih", query = "SELECT s FROM Subeler s WHERE s.sysEtarih = :sysEtarih"),
    @NamedQuery(name = "Subeler.findBySysDuzelten", query = "SELECT s FROM Subeler s WHERE s.sysDuzelten = :sysDuzelten"),
    @NamedQuery(name = "Subeler.findBySysDtarih", query = "SELECT s FROM Subeler s WHERE s.sysDtarih = :sysDtarih")})
public class SubelerDao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SUBE_ID", nullable = false)
    private Integer subeId;
    @Column(name = "SUBE_ADI", length = 60)
    private String subeAdi;
    @Column(length = 80)
    private String adres;
    @Column(length = 20)
    private String semt;
    @Column(length = 30)
    private String sehir;
    @Column(length = 20)
    private String telefon1;
    @Column(length = 20)
    private String telefon2;
    @Column(length = 50)
    private String yetkili;
    @Column(name = "VERGI_DAIRESI", length = 30)
    private String vergiDairesi;
    @Column(name = "VERGI_NO", length = 20)
    private String vergiNo;
    @Column(name = "OZEL_KOD", length = 20)
    private String ozelKod;
    @Column(name = "SUBE_AKTIF")
    private Integer subeAktif;
    @Column(name = "SYS_EKLEYEN", length = 15)
    private String sysEkleyen;
    @Column(name = "SYS_ETARIH")
    private Integer sysEtarih;
    @Column(name = "SYS_DUZELTEN", length = 15)
    private String sysDuzelten;
    @Column(name = "SYS_DTARIH")
    private Integer sysDtarih;
    @OneToMany(mappedBy = "subeId", fetch = FetchType.EAGER)
    private List<SatisFisiDao> satisFisiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subeler", fetch = FetchType.EAGER)
    private List<SubelerBakiye> subelerBakiyeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subeRef", fetch = FetchType.EAGER)
    private List<CariFislerDao> cariFislerList;

    public SubelerDao() {
    }

    public SubelerDao(Integer subeId) {
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

    @XmlTransient
    @JsonIgnore
    public List<SatisFisiDao> getSatisFisiList() {
        return satisFisiList;
    }

    public void setSatisFisiList(List<SatisFisiDao> satisFisiList) {
        this.satisFisiList = satisFisiList;
    }

    @XmlTransient
    @JsonIgnore
    public List<SubelerBakiye> getSubelerBakiyeList() {
        return subelerBakiyeList;
    }

    public void setSubelerBakiyeList(List<SubelerBakiye> subelerBakiyeList) {
        this.subelerBakiyeList = subelerBakiyeList;
    }

    @XmlTransient
    @JsonIgnore
    public List<CariFislerDao> getCariFislerList() {
        return cariFislerList;
    }

    public void setCariFislerList(List<CariFislerDao> cariFislerList) {
        this.cariFislerList = cariFislerList;
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
        if (!(object instanceof SubelerDao)) {
            return false;
        }
        SubelerDao other = (SubelerDao) object;
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
