/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"URUN_REF"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indirimler.findAll", query = "SELECT i FROM Indirimler i"),
    @NamedQuery(name = "Indirimler.findByIndId", query = "SELECT i FROM Indirimler i WHERE i.indId = :indId"),
    @NamedQuery(name = "Indirimler.findByBtarih", query = "SELECT i FROM Indirimler i WHERE i.btarih = :btarih"),
    @NamedQuery(name = "Indirimler.findByEtarih", query = "SELECT i FROM Indirimler i WHERE i.etarih = :etarih"),
    @NamedQuery(name = "Indirimler.findByIndOran", query = "SELECT i FROM Indirimler i WHERE i.indOran = :indOran"),
    @NamedQuery(name = "Indirimler.findByIndMinMiktar", query = "SELECT i FROM Indirimler i WHERE i.indMinMiktar = :indMinMiktar"),
    @NamedQuery(name = "Indirimler.findByIndDurum", query = "SELECT i FROM Indirimler i WHERE i.indDurum = :indDurum"),
    @NamedQuery(name = "Indirimler.findByIndEkleyen", query = "SELECT i FROM Indirimler i WHERE i.indEkleyen = :indEkleyen"),
    @NamedQuery(name = "Indirimler.findByIndEtarih", query = "SELECT i FROM Indirimler i WHERE i.indEtarih = :indEtarih")})
public class Indirimler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IND_ID", nullable = false)
    private Integer indId;
    @Temporal(TemporalType.DATE)
    private Date btarih;
    @Temporal(TemporalType.DATE)
    private Date etarih;
    @Column(name = "IND_ORAN")
    private Integer indOran;
    @Column(name = "IND_MIN_MIKTAR")
    private Integer indMinMiktar;
    @Column(name = "IND_DURUM")
    private Integer indDurum;
    @Column(name = "IND_EKLEYEN", length = 15)
    private String indEkleyen;
    @Column(name = "IND_ETARIH")
    private Integer indEtarih;
    @JoinColumn(name = "URUN_REF", referencedColumnName = "URUN_ID")
    @OneToOne(fetch = FetchType.EAGER)
    private Urunler urunRef;

    public Indirimler() {
    }

    public Indirimler(Integer indId) {
        this.indId = indId;
    }

    public Integer getIndId() {
        return indId;
    }

    public void setIndId(Integer indId) {
        this.indId = indId;
    }

    public Date getBtarih() {
        return btarih;
    }

    public void setBtarih(Date btarih) {
        this.btarih = btarih;
    }

    public Date getEtarih() {
        return etarih;
    }

    public void setEtarih(Date etarih) {
        this.etarih = etarih;
    }

    public Integer getIndOran() {
        return indOran;
    }

    public void setIndOran(Integer indOran) {
        this.indOran = indOran;
    }

    public Integer getIndMinMiktar() {
        return indMinMiktar;
    }

    public void setIndMinMiktar(Integer indMinMiktar) {
        this.indMinMiktar = indMinMiktar;
    }

    public Integer getIndDurum() {
        return indDurum;
    }

    public void setIndDurum(Integer indDurum) {
        this.indDurum = indDurum;
    }

    public String getIndEkleyen() {
        return indEkleyen;
    }

    public void setIndEkleyen(String indEkleyen) {
        this.indEkleyen = indEkleyen;
    }

    public Integer getIndEtarih() {
        return indEtarih;
    }

    public void setIndEtarih(Integer indEtarih) {
        this.indEtarih = indEtarih;
    }

    public Urunler getUrunRef() {
        return urunRef;
    }

    public void setUrunRef(Urunler urunRef) {
        this.urunRef = urunRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indId != null ? indId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indirimler)) {
            return false;
        }
        Indirimler other = (Indirimler) object;
        if ((this.indId == null && other.indId != null) || (this.indId != null && !this.indId.equals(other.indId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.Indirimler[ indId=" + indId + " ]";
    }
    
}
