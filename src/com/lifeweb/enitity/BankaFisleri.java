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
@Table(name = "banka_fisleri", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankaFisleri.findAll", query = "SELECT b FROM BankaFisleri b"),
    @NamedQuery(name = "BankaFisleri.findByFisId", query = "SELECT b FROM BankaFisleri b WHERE b.fisId = :fisId"),
    @NamedQuery(name = "BankaFisleri.findByFisTarih", query = "SELECT b FROM BankaFisleri b WHERE b.fisTarih = :fisTarih"),
    @NamedQuery(name = "BankaFisleri.findByYatanPara", query = "SELECT b FROM BankaFisleri b WHERE b.yatanPara = :yatanPara"),
    @NamedQuery(name = "BankaFisleri.findByCekilenPara", query = "SELECT b FROM BankaFisleri b WHERE b.cekilenPara = :cekilenPara"),
    @NamedQuery(name = "BankaFisleri.findByFisBelgeno", query = "SELECT b FROM BankaFisleri b WHERE b.fisBelgeno = :fisBelgeno"),
    @NamedQuery(name = "BankaFisleri.findByFisAciklama", query = "SELECT b FROM BankaFisleri b WHERE b.fisAciklama = :fisAciklama"),
    @NamedQuery(name = "BankaFisleri.findByFisOzelkod", query = "SELECT b FROM BankaFisleri b WHERE b.fisOzelkod = :fisOzelkod"),
    @NamedQuery(name = "BankaFisleri.findByIsaret", query = "SELECT b FROM BankaFisleri b WHERE b.isaret = :isaret"),
    @NamedQuery(name = "BankaFisleri.findBySysEkleyen", query = "SELECT b FROM BankaFisleri b WHERE b.sysEkleyen = :sysEkleyen"),
    @NamedQuery(name = "BankaFisleri.findBySysEtarih", query = "SELECT b FROM BankaFisleri b WHERE b.sysEtarih = :sysEtarih"),
    @NamedQuery(name = "BankaFisleri.findBySysDuzelten", query = "SELECT b FROM BankaFisleri b WHERE b.sysDuzelten = :sysDuzelten"),
    @NamedQuery(name = "BankaFisleri.findBySysDtarih", query = "SELECT b FROM BankaFisleri b WHERE b.sysDtarih = :sysDtarih")})
public class BankaFisleri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FIS_ID", nullable = false)
    private Integer fisId;
    @Column(name = "FIS_TARIH")
    @Temporal(TemporalType.DATE)
    private Date fisTarih;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "YATAN_PARA", precision = 15, scale = 2)
    private Double yatanPara;
    @Column(name = "CEKILEN_PARA", precision = 15, scale = 2)
    private Double cekilenPara;
    @Column(name = "FIS_BELGENO", length = 20)
    private String fisBelgeno;
    @Column(name = "FIS_ACIKLAMA", length = 80)
    private String fisAciklama;
    @Column(name = "FIS_OZELKOD", length = 20)
    private String fisOzelkod;
    private Short isaret;
    @Column(name = "SYS_EKLEYEN", length = 15)
    private String sysEkleyen;
    @Column(name = "SYS_ETARIH")
    private Integer sysEtarih;
    @Column(name = "SYS_DUZELTEN", length = 15)
    private String sysDuzelten;
    @Column(name = "SYS_DTARIH")
    private Integer sysDtarih;
    @JoinColumn(name = "BANKA_REF", referencedColumnName = "BANKA_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private Bankalar bankaRef;

    public BankaFisleri() {
    }

    public BankaFisleri(Integer fisId) {
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

    public Double getYatanPara() {
        return yatanPara;
    }

    public void setYatanPara(Double yatanPara) {
        this.yatanPara = yatanPara;
    }

    public Double getCekilenPara() {
        return cekilenPara;
    }

    public void setCekilenPara(Double cekilenPara) {
        this.cekilenPara = cekilenPara;
    }

    public String getFisBelgeno() {
        return fisBelgeno;
    }

    public void setFisBelgeno(String fisBelgeno) {
        this.fisBelgeno = fisBelgeno;
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

    public Short getIsaret() {
        return isaret;
    }

    public void setIsaret(Short isaret) {
        this.isaret = isaret;
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

    public Bankalar getBankaRef() {
        return bankaRef;
    }

    public void setBankaRef(Bankalar bankaRef) {
        this.bankaRef = bankaRef;
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
        if (!(object instanceof BankaFisleri)) {
            return false;
        }
        BankaFisleri other = (BankaFisleri) object;
        if ((this.fisId == null && other.fisId != null) || (this.fisId != null && !this.fisId.equals(other.fisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.BankaFisleri[ fisId=" + fisId + " ]";
    }
    
}
