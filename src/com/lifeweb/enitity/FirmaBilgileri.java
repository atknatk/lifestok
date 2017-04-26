/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "firma_bilgileri", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FirmaBilgileri.findAll", query = "SELECT f FROM FirmaBilgileri f"),
    @NamedQuery(name = "FirmaBilgileri.findByFirmaAdi", query = "SELECT f FROM FirmaBilgileri f WHERE f.firmaAdi = :firmaAdi"),
    @NamedQuery(name = "FirmaBilgileri.findByAdres", query = "SELECT f FROM FirmaBilgileri f WHERE f.adres = :adres"),
    @NamedQuery(name = "FirmaBilgileri.findBySemt", query = "SELECT f FROM FirmaBilgileri f WHERE f.semt = :semt"),
    @NamedQuery(name = "FirmaBilgileri.findBySehir", query = "SELECT f FROM FirmaBilgileri f WHERE f.sehir = :sehir"),
    @NamedQuery(name = "FirmaBilgileri.findByVdaire", query = "SELECT f FROM FirmaBilgileri f WHERE f.vdaire = :vdaire"),
    @NamedQuery(name = "FirmaBilgileri.findByVno", query = "SELECT f FROM FirmaBilgileri f WHERE f.vno = :vno"),
    @NamedQuery(name = "FirmaBilgileri.findByLokasyonRef", query = "SELECT f FROM FirmaBilgileri f WHERE f.lokasyonRef = :lokasyonRef")})
public class FirmaBilgileri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FIRMA_ADI", nullable = false, length = 50)
    private String firmaAdi;
    @Column(length = 100)
    private String adres;
    @Column(length = 30)
    private String semt;
    @Column(length = 30)
    private String sehir;
    @Column(length = 50)
    private String vdaire;
    @Column(length = 20)
    private String vno;
    @Column(name = "LOKASYON_REF")
    private Integer lokasyonRef;

    public FirmaBilgileri() {
    }

    public FirmaBilgileri(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    public String getFirmaAdi() {
        return firmaAdi;
    }

    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
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

    public String getVdaire() {
        return vdaire;
    }

    public void setVdaire(String vdaire) {
        this.vdaire = vdaire;
    }

    public String getVno() {
        return vno;
    }

    public void setVno(String vno) {
        this.vno = vno;
    }

    public Integer getLokasyonRef() {
        return lokasyonRef;
    }

    public void setLokasyonRef(Integer lokasyonRef) {
        this.lokasyonRef = lokasyonRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (firmaAdi != null ? firmaAdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FirmaBilgileri)) {
            return false;
        }
        FirmaBilgileri other = (FirmaBilgileri) object;
        if ((this.firmaAdi == null && other.firmaAdi != null) || (this.firmaAdi != null && !this.firmaAdi.equals(other.firmaAdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.FirmaBilgileri[ firmaAdi=" + firmaAdi + " ]";
    }
    
}
