/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @UniqueConstraint(columnNames = {"MASRAF_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Masraflar.findAll", query = "SELECT m FROM Masraflar m"),
    @NamedQuery(name = "Masraflar.findByMasrafAdi", query = "SELECT m FROM Masraflar m WHERE m.masrafAdi = :masrafAdi"),
    @NamedQuery(name = "Masraflar.findByMasrafDurum", query = "SELECT m FROM Masraflar m WHERE m.masrafDurum = :masrafDurum"),
    @NamedQuery(name = "Masraflar.findByMasrafId", query = "SELECT m FROM Masraflar m WHERE m.masrafId = :masrafId")})
public class MasraflarDao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "MASRAF_ADI", nullable = false, length = 50)
    private String masrafAdi;
    @Column(name = "MASRAF_DURUM", length = 20)
    private String masrafDurum;
    @Basic(optional = false)
    @Column(name = "MASRAF_ID", nullable = false)
    private int masrafId;
    @OneToMany(mappedBy = "masrafRef", fetch = FetchType.EAGER)
    private List<MasrafFisleriDao> masrafFisleriList;
    @OneToMany(mappedBy = "masrafYeri", fetch = FetchType.EAGER)
    private List<CariFislerDao> cariFislerList;

    public MasraflarDao() {
    }

    public MasraflarDao(String masrafAdi) {
        this.masrafAdi = masrafAdi;
    }

    public MasraflarDao(String masrafAdi, int masrafId) {
        this.masrafAdi = masrafAdi;
        this.masrafId = masrafId;
    }

    public String getMasrafAdi() {
        return masrafAdi;
    }

    public void setMasrafAdi(String masrafAdi) {
        this.masrafAdi = masrafAdi;
    }

    public String getMasrafDurum() {
        return masrafDurum;
    }

    public void setMasrafDurum(String masrafDurum) {
        this.masrafDurum = masrafDurum;
    }

    public int getMasrafId() {
        return masrafId;
    }

    public void setMasrafId(int masrafId) {
        this.masrafId = masrafId;
    }

    @XmlTransient
    @JsonIgnore
    public List<MasrafFisleriDao> getMasrafFisleriList() {
        return masrafFisleriList;
    }

    public void setMasrafFisleriList(List<MasrafFisleriDao> masrafFisleriList) {
        this.masrafFisleriList = masrafFisleriList;
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
        hash += (masrafAdi != null ? masrafAdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasraflarDao)) {
            return false;
        }
        MasraflarDao other = (MasraflarDao) object;
        if ((this.masrafAdi == null && other.masrafAdi != null) || (this.masrafAdi != null && !this.masrafAdi.equals(other.masrafAdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.Masraflar[ masrafAdi=" + masrafAdi + " ]";
    }
    
}
