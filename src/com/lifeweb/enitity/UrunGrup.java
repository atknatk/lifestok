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
@Table(name = "urun_grup", catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"URUN_GRUP_ADI"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UrunGrup.findAll", query = "SELECT u FROM UrunGrup u"),
    @NamedQuery(name = "UrunGrup.findByUrunGrupId", query = "SELECT u FROM UrunGrup u WHERE u.urunGrupId = :urunGrupId"),
    @NamedQuery(name = "UrunGrup.findByUrunGrupAdi", query = "SELECT u FROM UrunGrup u WHERE u.urunGrupAdi = :urunGrupAdi"),
    @NamedQuery(name = "UrunGrup.findByUrunGrupDurum", query = "SELECT u FROM UrunGrup u WHERE u.urunGrupDurum = :urunGrupDurum"),
    @NamedQuery(name = "UrunGrup.findByUrunGrupYazici", query = "SELECT u FROM UrunGrup u WHERE u.urunGrupYazici = :urunGrupYazici")})
public class UrunGrup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "URUN_GRUP_ID", nullable = false)
    private Integer urunGrupId;
    @Basic(optional = false)
    @Column(name = "URUN_GRUP_ADI", nullable = false, length = 50)
    private String urunGrupAdi;
    @Column(name = "URUN_GRUP_DURUM", length = 20)
    private String urunGrupDurum;
    @Column(name = "URUN_GRUP_YAZICI", length = 500)
    private String urunGrupYazici;
    @OneToMany(mappedBy = "grupRef", fetch = FetchType.EAGER)
    private List<Urunler> urunlerList;
    @OneToMany(mappedBy = "grupRef", fetch = FetchType.EAGER)
    private List<UrunlerFoto> urunlerFotoList;

    public UrunGrup() {
    }

    public UrunGrup(Integer urunGrupId) {
        this.urunGrupId = urunGrupId;
    }

    public UrunGrup(Integer urunGrupId, String urunGrupAdi) {
        this.urunGrupId = urunGrupId;
        this.urunGrupAdi = urunGrupAdi;
    }

    public Integer getUrunGrupId() {
        return urunGrupId;
    }

    public void setUrunGrupId(Integer urunGrupId) {
        this.urunGrupId = urunGrupId;
    }

    public String getUrunGrupAdi() {
        return urunGrupAdi;
    }

    public void setUrunGrupAdi(String urunGrupAdi) {
        this.urunGrupAdi = urunGrupAdi;
    }

    public String getUrunGrupDurum() {
        return urunGrupDurum;
    }

    public void setUrunGrupDurum(String urunGrupDurum) {
        this.urunGrupDurum = urunGrupDurum;
    }

    public String getUrunGrupYazici() {
        return urunGrupYazici;
    }

    public void setUrunGrupYazici(String urunGrupYazici) {
        this.urunGrupYazici = urunGrupYazici;
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
        hash += (urunGrupId != null ? urunGrupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UrunGrup)) {
            return false;
        }
        UrunGrup other = (UrunGrup) object;
        if ((this.urunGrupId == null && other.urunGrupId != null) || (this.urunGrupId != null && !this.urunGrupId.equals(other.urunGrupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return urunGrupAdi;
    }
    
}
