/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

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
@Table(name = "cari_hesaplar_bakiye", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CariHesaplarBakiye.findAll", query = "SELECT c FROM CariHesaplarBakiye c"),
    @NamedQuery(name = "CariHesaplarBakiye.findByRefCari", query = "SELECT c FROM CariHesaplarBakiye c WHERE c.refCari = :refCari"),
    @NamedQuery(name = "CariHesaplarBakiye.findByBakiye", query = "SELECT c FROM CariHesaplarBakiye c WHERE c.bakiye = :bakiye"),
    @NamedQuery(name = "CariHesaplarBakiye.findByAb", query = "SELECT c FROM CariHesaplarBakiye c WHERE c.ab = :ab"),
    @NamedQuery(name = "CariHesaplarBakiye.findByIsaret", query = "SELECT c FROM CariHesaplarBakiye c WHERE c.isaret = :isaret")})
public class CariHesaplarBakiye implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "REF_CARI", nullable = false)
    private Integer refCari;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 15, scale = 2)
    private Double bakiye;
    @Column(length = 3)
    private String ab;
    @Column(length = 1)
    private String isaret;

    public CariHesaplarBakiye() {
    }

    public CariHesaplarBakiye(Integer refCari) {
        this.refCari = refCari;
    }

    public Integer getRefCari() {
        return refCari;
    }

    public void setRefCari(Integer refCari) {
        this.refCari = refCari;
    }

    public Double getBakiye() {
        return bakiye;
    }

    public void setBakiye(Double bakiye) {
        this.bakiye = bakiye;
    }

    public String getAb() {
        return ab;
    }

    public void setAb(String ab) {
        this.ab = ab;
    }

    public String getIsaret() {
        return isaret;
    }

    public void setIsaret(String isaret) {
        this.isaret = isaret;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (refCari != null ? refCari.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CariHesaplarBakiye)) {
            return false;
        }
        CariHesaplarBakiye other = (CariHesaplarBakiye) object;
        if ((this.refCari == null && other.refCari != null) || (this.refCari != null && !this.refCari.equals(other.refCari))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.CariHesaplarBakiye[ refCari=" + refCari + " ]";
    }
    
}
