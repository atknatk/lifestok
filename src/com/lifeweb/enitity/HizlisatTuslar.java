/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "hizlisat_tuslar", catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"HIZKAT_REF", "BARKOD_REF", "SYS_EKLEYEN"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HizlisatTuslar.findAll", query = "SELECT h FROM HizlisatTuslar h"),
    @NamedQuery(name = "HizlisatTuslar.findByTusId", query = "SELECT h FROM HizlisatTuslar h WHERE h.tusId = :tusId"),
    @NamedQuery(name = "HizlisatTuslar.findByTusNo", query = "SELECT h FROM HizlisatTuslar h WHERE h.tusNo = :tusNo"),
    @NamedQuery(name = "HizlisatTuslar.findByTusOrder", query = "SELECT h FROM HizlisatTuslar h WHERE h.tusOrder = :tusOrder"),
    @NamedQuery(name = "HizlisatTuslar.findBySysEkleyen", query = "SELECT h FROM HizlisatTuslar h WHERE h.sysEkleyen = :sysEkleyen")})
public class HizlisatTuslar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TUS_ID", nullable = false)
    private Integer tusId;
    @Column(name = "TUS_NO")
    private Integer tusNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TUS_ORDER", precision = 9, scale = 3)
    private Float tusOrder;
    @Basic(optional = false)
    @Column(name = "SYS_EKLEYEN", nullable = false, length = 15)
    private String sysEkleyen;
    @JoinColumn(name = "HIZKAT_REF", referencedColumnName = "HIZKAT_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private HizlisatKategori hizkatRef;
    @JoinColumn(name = "BARKOD_REF", referencedColumnName = "BARKOD_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Urunler barkodRef;

    public HizlisatTuslar() {
    }

    public HizlisatTuslar(Integer tusId) {
        this.tusId = tusId;
    }

    public HizlisatTuslar(Integer tusId, String sysEkleyen) {
        this.tusId = tusId;
        this.sysEkleyen = sysEkleyen;
    }

    public Integer getTusId() {
        return tusId;
    }

    public void setTusId(Integer tusId) {
        this.tusId = tusId;
    }

    public Integer getTusNo() {
        return tusNo;
    }

    public void setTusNo(Integer tusNo) {
        this.tusNo = tusNo;
    }

    public Float getTusOrder() {
        return tusOrder;
    }

    public void setTusOrder(Float tusOrder) {
        this.tusOrder = tusOrder;
    }

    public String getSysEkleyen() {
        return sysEkleyen;
    }

    public void setSysEkleyen(String sysEkleyen) {
        this.sysEkleyen = sysEkleyen;
    }

    public HizlisatKategori getHizkatRef() {
        return hizkatRef;
    }

    public void setHizkatRef(HizlisatKategori hizkatRef) {
        this.hizkatRef = hizkatRef;
    }

    public Urunler getBarkodRef() {
        return barkodRef;
    }

    public void setBarkodRef(Urunler barkodRef) {
        this.barkodRef = barkodRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tusId != null ? tusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HizlisatTuslar)) {
            return false;
        }
        HizlisatTuslar other = (HizlisatTuslar) object;
        if ((this.tusId == null && other.tusId != null) || (this.tusId != null && !this.tusId.equals(other.tusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.HizlisatTuslar[ tusId=" + tusId + " ]";
    }
    
}
