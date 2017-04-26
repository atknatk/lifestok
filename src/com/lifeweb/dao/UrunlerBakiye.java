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
@Table(name = "urunler_bakiye", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UrunlerBakiye.findAll", query = "SELECT u FROM UrunlerBakiye u"),
    @NamedQuery(name = "UrunlerBakiye.findByRefStok", query = "SELECT u FROM UrunlerBakiye u WHERE u.refStok = :refStok"),
    @NamedQuery(name = "UrunlerBakiye.findByBakiye", query = "SELECT u FROM UrunlerBakiye u WHERE u.bakiye = :bakiye"),
    @NamedQuery(name = "UrunlerBakiye.findByAb", query = "SELECT u FROM UrunlerBakiye u WHERE u.ab = :ab"),
    @NamedQuery(name = "UrunlerBakiye.findByIsaret", query = "SELECT u FROM UrunlerBakiye u WHERE u.isaret = :isaret")})
public class UrunlerBakiye implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "REF_STOK", nullable = false)
    private Integer refStok;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 15, scale = 2)
    private Double bakiye;
    @Column(length = 3)
    private String ab;
    @Column(length = 1)
    private String isaret;

    public UrunlerBakiye() {
    }

    public UrunlerBakiye(Integer refStok) {
        this.refStok = refStok;
    }

    public Integer getRefStok() {
        return refStok;
    }

    public void setRefStok(Integer refStok) {
        this.refStok = refStok;
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
        hash += (refStok != null ? refStok.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UrunlerBakiye)) {
            return false;
        }
        UrunlerBakiye other = (UrunlerBakiye) object;
        if ((this.refStok == null && other.refStok != null) || (this.refStok != null && !this.refStok.equals(other.refStok))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.UrunlerBakiye[ refStok=" + refStok + " ]";
    }
    
}
