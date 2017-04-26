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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "masraf_fisleri", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MasrafFisleri.findAll", query = "SELECT m FROM MasrafFisleri m"),
    @NamedQuery(name = "MasrafFisleri.findByFisId", query = "SELECT m FROM MasrafFisleri m WHERE m.fisId = :fisId"),
    @NamedQuery(name = "MasrafFisleri.findByFisTarih", query = "SELECT m FROM MasrafFisleri m WHERE m.fisTarih = :fisTarih"),
    @NamedQuery(name = "MasrafFisleri.findByMasrafVade", query = "SELECT m FROM MasrafFisleri m WHERE m.masrafVade = :masrafVade"),
    @NamedQuery(name = "MasrafFisleri.findByFisOdemeTarih", query = "SELECT m FROM MasrafFisleri m WHERE m.fisOdemeTarih = :fisOdemeTarih"),
    @NamedQuery(name = "MasrafFisleri.findByFisToplam", query = "SELECT m FROM MasrafFisleri m WHERE m.fisToplam = :fisToplam"),
    @NamedQuery(name = "MasrafFisleri.findByFisFaturano", query = "SELECT m FROM MasrafFisleri m WHERE m.fisFaturano = :fisFaturano"),
    @NamedQuery(name = "MasrafFisleri.findByFisAciklama", query = "SELECT m FROM MasrafFisleri m WHERE m.fisAciklama = :fisAciklama"),
    @NamedQuery(name = "MasrafFisleri.findByFisOzelkod", query = "SELECT m FROM MasrafFisleri m WHERE m.fisOzelkod = :fisOzelkod"),
    @NamedQuery(name = "MasrafFisleri.findByFisDurum", query = "SELECT m FROM MasrafFisleri m WHERE m.fisDurum = :fisDurum"),
    @NamedQuery(name = "MasrafFisleri.findBySysEkleyen", query = "SELECT m FROM MasrafFisleri m WHERE m.sysEkleyen = :sysEkleyen"),
    @NamedQuery(name = "MasrafFisleri.findBySysEtarih", query = "SELECT m FROM MasrafFisleri m WHERE m.sysEtarih = :sysEtarih"),
    @NamedQuery(name = "MasrafFisleri.findBySysDuzelten", query = "SELECT m FROM MasrafFisleri m WHERE m.sysDuzelten = :sysDuzelten"),
    @NamedQuery(name = "MasrafFisleri.findBySysDtarih", query = "SELECT m FROM MasrafFisleri m WHERE m.sysDtarih = :sysDtarih")})
public class MasrafFisleri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FIS_ID", nullable = false)
    private Integer fisId;
    @Column(name = "FIS_TARIH")
    @Temporal(TemporalType.DATE)
    private Date fisTarih;
    @Column(name = "MASRAF_VADE")
    @Temporal(TemporalType.DATE)
    private Date masrafVade;
    @Column(name = "FIS_ODEME_TARIH")
    @Temporal(TemporalType.DATE)
    private Date fisOdemeTarih;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FIS_TOPLAM", precision = 15, scale = 2)
    private Double fisToplam;
    @Column(name = "FIS_FATURANO", length = 20)
    private String fisFaturano;
    @Column(name = "FIS_ACIKLAMA", length = 80)
    private String fisAciklama;
    @Column(name = "FIS_OZELKOD", length = 20)
    private String fisOzelkod;
    @Column(name = "FIS_DURUM", length = 10)
    private String fisDurum;
    @Column(name = "SYS_EKLEYEN", length = 15)
    private String sysEkleyen;
    @Column(name = "SYS_ETARIH")
    private Integer sysEtarih;
    @Column(name = "SYS_DUZELTEN", length = 15)
    private String sysDuzelten;
    @Column(name = "SYS_DTARIH")
    private Integer sysDtarih;
    @JoinColumn(name = "MASRAF_REF", referencedColumnName = "MASRAF_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private Masraflar masrafRef;

    public MasrafFisleri() {
    }

    public MasrafFisleri(Integer fisId) {
        this.fisId = fisId;
    }

    public Integer getFisId() {
        return fisId;
    }

    public void setFisId(Integer fisId) {
        this.fisId = fisId;
    }

    public Date getFisTarih() {
        return fisTarih;
    }

    public void setFisTarih(Date fisTarih) {
        this.fisTarih = fisTarih;
    }

    public Date getMasrafVade() {
        return masrafVade;
    }

    public void setMasrafVade(Date masrafVade) {
        this.masrafVade = masrafVade;
    }

    public Date getFisOdemeTarih() {
        return fisOdemeTarih;
    }

    public void setFisOdemeTarih(Date fisOdemeTarih) {
        this.fisOdemeTarih = fisOdemeTarih;
    }

    public Double getFisToplam() {
        return fisToplam;
    }

    public void setFisToplam(Double fisToplam) {
        this.fisToplam = fisToplam;
    }

    public String getFisFaturano() {
        return fisFaturano;
    }

    public void setFisFaturano(String fisFaturano) {
        this.fisFaturano = fisFaturano;
    }

    public String getFisAciklama() {
        return fisAciklama;
    }

    public void setFisAciklama(String fisAciklama) {
        this.fisAciklama = fisAciklama;
    }

    public String getFisOzelkod() {
        return fisOzelkod;
    }

    public void setFisOzelkod(String fisOzelkod) {
        this.fisOzelkod = fisOzelkod;
    }

    public String getFisDurum() {
        return fisDurum;
    }

    public void setFisDurum(String fisDurum) {
        this.fisDurum = fisDurum;
    }

    public String getSysEkleyen() {
        return sysEkleyen;
    }

    public void setSysEkleyen(String sysEkleyen) {
        this.sysEkleyen = sysEkleyen;
    }

    public Integer getSysEtarih() {
        return sysEtarih;
    }

    public void setSysEtarih(Integer sysEtarih) {
        this.sysEtarih = sysEtarih;
    }

    public String getSysDuzelten() {
        return sysDuzelten;
    }

    public void setSysDuzelten(String sysDuzelten) {
        this.sysDuzelten = sysDuzelten;
    }

    public Integer getSysDtarih() {
        return sysDtarih;
    }

    public void setSysDtarih(Integer sysDtarih) {
        this.sysDtarih = sysDtarih;
    }

    public Masraflar getMasrafRef() {
        return masrafRef;
    }

    public void setMasrafRef(Masraflar masrafRef) {
        this.masrafRef = masrafRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fisId != null ? fisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasrafFisleri)) {
            return false;
        }
        MasrafFisleri other = (MasrafFisleri) object;
        if ((this.fisId == null && other.fisId != null) || (this.fisId != null && !this.fisId.equals(other.fisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.MasrafFisleri[ fisId=" + fisId + " ]";
    }
    
}
