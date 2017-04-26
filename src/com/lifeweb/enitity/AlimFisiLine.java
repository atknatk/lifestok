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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "alim_fisi_line", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlimFisiLine.findAll", query = "SELECT a FROM AlimFisiLine a"),
    @NamedQuery(name = "AlimFisiLine.findByAlimFisiLineId", query = "SELECT a FROM AlimFisiLine a WHERE a.alimFisiLineId = :alimFisiLineId"),
    @NamedQuery(name = "AlimFisiLine.findByMiktar", query = "SELECT a FROM AlimFisiLine a WHERE a.miktar = :miktar"),
    @NamedQuery(name = "AlimFisiLine.findByIndirimOrani", query = "SELECT a FROM AlimFisiLine a WHERE a.indirimOrani = :indirimOrani"),
    @NamedQuery(name = "AlimFisiLine.findByBirimFiyati", query = "SELECT a FROM AlimFisiLine a WHERE a.birimFiyati = :birimFiyati"),
    @NamedQuery(name = "AlimFisiLine.findByTutar", query = "SELECT a FROM AlimFisiLine a WHERE a.tutar = :tutar"),
    @NamedQuery(name = "AlimFisiLine.findBySatilmayanMiktar", query = "SELECT a FROM AlimFisiLine a WHERE a.satilmayanMiktar = :satilmayanMiktar")})
public class AlimFisiLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALIM_FISI_LINE_ID", nullable = false)
    private Integer alimFisiLineId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 15, scale = 3)
    private Double miktar;
    @Column(name = "INDIRIM_ORANI", precision = 15, scale = 2)
    private Double indirimOrani;
    @Column(name = "BIRIM_FIYATI", precision = 15, scale = 2)
    private Double birimFiyati;
    @Column(precision = 15, scale = 2)
    private Double tutar;
    @Lob
    @Column(name = "SERI_NO", length = 16777215)
    private String seriNo;
    @Basic(optional = false)
    @Column(name = "SATILMAYAN_MIKTAR", nullable = false)
    private double satilmayanMiktar;
    @JoinColumn(name = "ALIM_FISI_ID", referencedColumnName = "ALIM_FISI_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private AlimFisi alimFisiId;
    @JoinColumn(name = "URUN_ID", referencedColumnName = "URUN_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Urunler urunId;

    public AlimFisiLine() {
    }

    public AlimFisiLine(Integer alimFisiLineId) {
        this.alimFisiLineId = alimFisiLineId;
    }

    public AlimFisiLine(Integer alimFisiLineId, double satilmayanMiktar) {
        this.alimFisiLineId = alimFisiLineId;
        this.satilmayanMiktar = satilmayanMiktar;
    }

    public Integer getAlimFisiLineId() {
        return alimFisiLineId;
    }

    public void setAlimFisiLineId(Integer alimFisiLineId) {
        this.alimFisiLineId = alimFisiLineId;
    }

    public Double getMiktar() {
        return miktar;
    }

    public void setMiktar(Double miktar) {
        this.miktar = miktar;
    }

    public Double getIndirimOrani() {
        return indirimOrani;
    }

    public void setIndirimOrani(Double indirimOrani) {
        this.indirimOrani = indirimOrani;
    }

    public Double getBirimFiyati() {
        return birimFiyati;
    }

    public void setBirimFiyati(Double birimFiyati) {
        this.birimFiyati = birimFiyati;
    }

    public Double getTutar() {
        return tutar;
    }

    public void setTutar(Double tutar) {
        this.tutar = tutar;
    }

    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }

    public double getSatilmayanMiktar() {
        return satilmayanMiktar;
    }

    public void setSatilmayanMiktar(double satilmayanMiktar) {
        this.satilmayanMiktar = satilmayanMiktar;
    }

    public AlimFisi getAlimFisiId() {
        return alimFisiId;
    }

    public void setAlimFisiId(AlimFisi alimFisiId) {
        this.alimFisiId = alimFisiId;
    }

    public Urunler getUrunId() {
        return urunId;
    }

    public void setUrunId(Urunler urunId) {
        this.urunId = urunId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alimFisiLineId != null ? alimFisiLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlimFisiLine)) {
            return false;
        }
        AlimFisiLine other = (AlimFisiLine) object;
        if ((this.alimFisiLineId == null && other.alimFisiLineId != null) || (this.alimFisiLineId != null && !this.alimFisiLineId.equals(other.alimFisiLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.AlimFisiLine[ alimFisiLineId=" + alimFisiLineId + " ]";
    }
    
}
