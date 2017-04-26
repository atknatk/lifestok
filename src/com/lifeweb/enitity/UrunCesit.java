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
@Table(name = "urun_cesit", catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"CESIT_ADI"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UrunCesit.findAll", query = "SELECT u FROM UrunCesit u"),
    @NamedQuery(name = "UrunCesit.findByCesitId", query = "SELECT u FROM UrunCesit u WHERE u.cesitId = :cesitId"),
    @NamedQuery(name = "UrunCesit.findByCesitAdi", query = "SELECT u FROM UrunCesit u WHERE u.cesitAdi = :cesitAdi"),
    @NamedQuery(name = "UrunCesit.findByCesitDurum", query = "SELECT u FROM UrunCesit u WHERE u.cesitDurum = :cesitDurum")})
public class UrunCesit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CESIT_ID", nullable = false)
    private Integer cesitId;
    @Basic(optional = false)
    @Column(name = "CESIT_ADI", nullable = false, length = 20)
    private String cesitAdi;
    @Column(name = "CESIT_DURUM", length = 20)
    private String cesitDurum;
    @OneToMany(mappedBy = "urunCesit", fetch = FetchType.EAGER)
    private List<Urunler> urunlerList;
    @OneToMany(mappedBy = "cesitRef", fetch = FetchType.EAGER)
    private List<UrunlerFoto> urunlerFotoList;

    public UrunCesit() {
    }

    public UrunCesit(Integer cesitId) {
        this.cesitId = cesitId;
    }

    public UrunCesit(Integer cesitId, String cesitAdi) {
        this.cesitId = cesitId;
        this.cesitAdi = cesitAdi;
    }

    public Integer getCesitId() {
        return cesitId;
    }

    public void setCesitId(Integer cesitId) {
        this.cesitId = cesitId;
    }

    public String getCesitAdi() {
        return cesitAdi;
    }

    public void setCesitAdi(String cesitAdi) {
        this.cesitAdi = cesitAdi;
    }

    public String getCesitDurum() {
        return cesitDurum;
    }

    public void setCesitDurum(String cesitDurum) {
        this.cesitDurum = cesitDurum;
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
        hash += (cesitId != null ? cesitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UrunCesit)) {
            return false;
        }
        UrunCesit other = (UrunCesit) object;
        if ((this.cesitId == null && other.cesitId != null) || (this.cesitId != null && !this.cesitId.equals(other.cesitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cesitAdi;
    }
    
}
