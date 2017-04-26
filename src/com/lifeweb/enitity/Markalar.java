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
    @UniqueConstraint(columnNames = {"MARKA_ADI"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Markalar.findAll", query = "SELECT m FROM Markalar m"),
    @NamedQuery(name = "Markalar.findByMarkaId", query = "SELECT m FROM Markalar m WHERE m.markaId = :markaId"),
    @NamedQuery(name = "Markalar.findByMarkaAdi", query = "SELECT m FROM Markalar m WHERE m.markaAdi = :markaAdi"),
    @NamedQuery(name = "Markalar.findByMarkaDurum", query = "SELECT m FROM Markalar m WHERE m.markaDurum = :markaDurum")})
public class Markalar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MARKA_ID", nullable = false)
    private Integer markaId;
    @Basic(optional = false)
    @Column(name = "MARKA_ADI", nullable = false, length = 50)
    private String markaAdi;
    @Column(name = "MARKA_DURUM", length = 20)
    private String markaDurum;
    @OneToMany(mappedBy = "markaRef", fetch = FetchType.EAGER)
    private List<Urunler> urunlerList;
    @OneToMany(mappedBy = "markaRef", fetch = FetchType.EAGER)
    private List<UrunlerFoto> urunlerFotoList;

    public Markalar() {
    }

    public Markalar(Integer markaId) {
        this.markaId = markaId;
    }

    public Markalar(Integer markaId, String markaAdi) {
        this.markaId = markaId;
        this.markaAdi = markaAdi;
    }

    public Integer getMarkaId() {
        return markaId;
    }

    public void setMarkaId(Integer markaId) {
        this.markaId = markaId;
    }

    public String getMarkaAdi() {
        return markaAdi;
    }

    public void setMarkaAdi(String markaAdi) {
        this.markaAdi = markaAdi;
    }

    public String getMarkaDurum() {
        return markaDurum;
    }

    public void setMarkaDurum(String markaDurum) {
        this.markaDurum = markaDurum;
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
    public List<UrunlerFoto> getUrunlerFotoList() {
        return urunlerFotoList;
    }

    public void setUrunlerFotoList(List<UrunlerFoto> urunlerFotoList) {
        this.urunlerFotoList = urunlerFotoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (markaId != null ? markaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Markalar)) {
            return false;
        }
        Markalar other = (Markalar) object;
        if ((this.markaId == null && other.markaId != null) || (this.markaId != null && !this.markaId.equals(other.markaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return markaAdi;
    }
    
}
