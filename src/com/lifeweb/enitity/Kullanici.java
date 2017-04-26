/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
    @UniqueConstraint(columnNames = {"KULLANICI_ADI"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k"),
    @NamedQuery(name = "Kullanici.findByKullaniciId", query = "SELECT k FROM Kullanici k WHERE k.kullaniciId = :kullaniciId"),
    @NamedQuery(name = "Kullanici.findByKullaniciAdi", query = "SELECT k FROM Kullanici k WHERE k.kullaniciAdi = :kullaniciAdi"),
    @NamedQuery(name = "Kullanici.findBySifre", query = "SELECT k FROM Kullanici k WHERE k.sifre = :sifre"),
    @NamedQuery(name = "Kullanici.findByAdi", query = "SELECT k FROM Kullanici k WHERE k.adi = :adi"),
    @NamedQuery(name = "Kullanici.findBySoyadi", query = "SELECT k FROM Kullanici k WHERE k.soyadi = :soyadi"),
    @NamedQuery(name = "Kullanici.findByYetki", query = "SELECT k FROM Kullanici k WHERE k.yetki = :yetki"),
    @NamedQuery(name = "Kullanici.findByDiger", query = "SELECT k FROM Kullanici k WHERE k.diger = :diger")})
public class Kullanici implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KULLANICI_ID", nullable = false)
    private Integer kullaniciId;
    @Basic(optional = false)
    @Column(name = "KULLANICI_ADI", nullable = false, length = 45)
    private String kullaniciAdi;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String sifre;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String adi;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String soyadi;
    @Basic(optional = false)
    @Column(nullable = false, length = 45)
    private String yetki;
    @Column(length = 45)
    private String diger;
    @OneToMany(mappedBy = "sysEkleyen", fetch = FetchType.EAGER)
    private List<SatisFisi> satisFisiList;

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

    @XmlTransient
    @JsonIgnore
    public List<SatisFisi> getSatisFisiList() {
        return satisFisiList;
    }

    public void setSatisFisiList(List<SatisFisi> satisFisiList) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
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
        return "com.lifeweb.enitity.Kullanici[ kullaniciId=" + kullaniciId + " ]";
    }
    
}
