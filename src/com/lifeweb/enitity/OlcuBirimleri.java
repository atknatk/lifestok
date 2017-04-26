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
@Table(name = "olcu_birimleri", catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"BIRIM_ADI"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OlcuBirimleri.findAll", query = "SELECT o FROM OlcuBirimleri o"),
    @NamedQuery(name = "OlcuBirimleri.findByBirimId", query = "SELECT o FROM OlcuBirimleri o WHERE o.birimId = :birimId"),
    @NamedQuery(name = "OlcuBirimleri.findByBirimAdi", query = "SELECT o FROM OlcuBirimleri o WHERE o.birimAdi = :birimAdi"),
    @NamedQuery(name = "OlcuBirimleri.findByBirimDurum", query = "SELECT o FROM OlcuBirimleri o WHERE o.birimDurum = :birimDurum")})
public class OlcuBirimleri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BIRIM_ID", nullable = false)
    private Integer birimId;
    @Basic(optional = false)
    @Column(name = "BIRIM_ADI", nullable = false, length = 10)
    private String birimAdi;
    @Column(name = "BIRIM_DURUM", length = 20)
    private String birimDurum;
    @OneToMany(mappedBy = "birimRef", fetch = FetchType.EAGER)
    private List<Urunler> urunlerList;
    @OneToMany(mappedBy = "lineBirim", fetch = FetchType.EAGER)
    private List<CariFisler> cariFislerList;

    public OlcuBirimleri() {
    }

    public OlcuBirimleri(Integer birimId) {
        this.birimId = birimId;
    }

    public OlcuBirimleri(Integer birimId, String birimAdi) {
        this.birimId = birimId;
        this.birimAdi = birimAdi;
    }

    public Integer getBirimId() {
        return birimId;
    }

    public void setBirimId(Integer birimId) {
        this.birimId = birimId;
    }

    public String getBirimAdi() {
        return birimAdi;
    }

    public void setBirimAdi(String birimAdi) {
        this.birimAdi = birimAdi;
    }

    public String getBirimDurum() {
        return birimDurum;
    }

    public void setBirimDurum(String birimDurum) {
        this.birimDurum = birimDurum;
    }

    @XmlTransient
    @JsonIgnore
    public List<Urunler> getUrunlerList() {
        return urunlerList;
    }

    public void setUrunlerList(List<Urunler> urunlerList) {
        this.urunlerList = urunlerList;
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
        hash += (birimId != null ? birimId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OlcuBirimleri)) {
            return false;
        }
        OlcuBirimleri other = (OlcuBirimleri) object;
        if ((this.birimId == null && other.birimId != null) || (this.birimId != null && !this.birimId.equals(other.birimId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return birimAdi;
    }
    
}
