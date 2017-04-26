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
@Table(name = "hizlisat_kategori", catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"HIZKAT_ADI", "SYS_EKLEYEN"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HizlisatKategori.findAll", query = "SELECT h FROM HizlisatKategori h"),
    @NamedQuery(name = "HizlisatKategori.findByHizkatId", query = "SELECT h FROM HizlisatKategori h WHERE h.hizkatId = :hizkatId"),
    @NamedQuery(name = "HizlisatKategori.findByHizkatAdi", query = "SELECT h FROM HizlisatKategori h WHERE h.hizkatAdi = :hizkatAdi"),
    @NamedQuery(name = "HizlisatKategori.findBySysEkleyen", query = "SELECT h FROM HizlisatKategori h WHERE h.sysEkleyen = :sysEkleyen")})
public class HizlisatKategori implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HIZKAT_ID", nullable = false)
    private Integer hizkatId;
    @Basic(optional = false)
    @Column(name = "HIZKAT_ADI", nullable = false, length = 25)
    private String hizkatAdi;
    @Basic(optional = false)
    @Column(name = "SYS_EKLEYEN", nullable = false, length = 15)
    private String sysEkleyen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hizkatRef", fetch = FetchType.EAGER)
    private List<HizlisatTuslar> hizlisatTuslarList;

    public HizlisatKategori() {
    }

    public HizlisatKategori(Integer hizkatId) {
        this.hizkatId = hizkatId;
    }

    public HizlisatKategori(Integer hizkatId, String hizkatAdi, String sysEkleyen) {
        this.hizkatId = hizkatId;
        this.hizkatAdi = hizkatAdi;
        this.sysEkleyen = sysEkleyen;
    }

    public Integer getHizkatId() {
        return hizkatId;
    }

    public void setHizkatId(Integer hizkatId) {
        this.hizkatId = hizkatId;
    }

    public String getHizkatAdi() {
        return hizkatAdi;
    }

    public void setHizkatAdi(String hizkatAdi) {
        this.hizkatAdi = hizkatAdi;
    }

    public String getSysEkleyen() {
        return sysEkleyen;
    }

    public void setSysEkleyen(String sysEkleyen) {
        this.sysEkleyen = sysEkleyen;
    }

    @XmlTransient
    @JsonIgnore
    public List<HizlisatTuslar> getHizlisatTuslarList() {
        return hizlisatTuslarList;
    }

    public void setHizlisatTuslarList(List<HizlisatTuslar> hizlisatTuslarList) {
        this.hizlisatTuslarList = hizlisatTuslarList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hizkatId != null ? hizkatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HizlisatKategori)) {
            return false;
        }
        HizlisatKategori other = (HizlisatKategori) object;
        if ((this.hizkatId == null && other.hizkatId != null) || (this.hizkatId != null && !this.hizkatId.equals(other.hizkatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.HizlisatKategori[ hizkatId=" + hizkatId + " ]";
    }
    
}
