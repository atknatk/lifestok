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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "satis_fisi_line", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SatisFisiLine.findAll", query = "SELECT s FROM SatisFisiLine s"),
    @NamedQuery(name = "SatisFisiLine.findBySatisFisiLineId", query = "SELECT s FROM SatisFisiLine s WHERE s.satisFisiLineId = :satisFisiLineId"),
    @NamedQuery(name = "SatisFisiLine.findByMiktar", query = "SELECT s FROM SatisFisiLine s WHERE s.miktar = :miktar"),
    @NamedQuery(name = "SatisFisiLine.findByIndirimOrani", query = "SELECT s FROM SatisFisiLine s WHERE s.indirimOrani = :indirimOrani"),
    @NamedQuery(name = "SatisFisiLine.findByBirimFiyati", query = "SELECT s FROM SatisFisiLine s WHERE s.birimFiyati = :birimFiyati"),
    @NamedQuery(name = "SatisFisiLine.findByTutar", query = "SELECT s FROM SatisFisiLine s WHERE s.tutar = :tutar"),
    @NamedQuery(name = "SatisFisiLine.findBySeriNo", query = "SELECT s FROM SatisFisiLine s WHERE s.seriNo = :seriNo"),
    @NamedQuery(name = "SatisFisiLine.findByAlisFiyati", query = "SELECT s FROM SatisFisiLine s WHERE s.alisFiyati = :alisFiyati")})
public class SatisFisiLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SATIS_FISI_LINE_ID", nullable = false)
    private Integer satisFisiLineId;
    @Basic(optional = false)
    @Column(nullable = false)
    private double miktar;
    @Basic(optional = false)
    @Column(name = "INDIRIM_ORANI", nullable = false)
    private double indirimOrani;
    @Basic(optional = false)
    @Column(name = "BIRIM_FIYATI", nullable = false)
    private double birimFiyati;
    @Basic(optional = false)
    @Column(nullable = false)
    private double tutar;
    @Column(name = "SERI_NO", length = 45)
    private String seriNo;
    @Basic(optional = false)
    @Column(name = "ALIS_FIYATI", nullable = false)
    private double alisFiyati;
    @JoinColumn(name = "URUN_ID", referencedColumnName = "URUN_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Urunler urunId;
    @JoinColumn(name = "SATIS_FISI_ID", referencedColumnName = "SATIS_FISI_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SatisFisi satisFisiId;

    public SatisFisiLine() {
    }

    public SatisFisiLine(Integer satisFisiLineId) {
        this.satisFisiLineId = satisFisiLineId;
    }

    public SatisFisiLine(Integer satisFisiLineId, double miktar, double indirimOrani, double birimFiyati, double tutar, double alisFiyati) {
        this.satisFisiLineId = satisFisiLineId;
        this.miktar = miktar;
        this.indirimOrani = indirimOrani;
        this.birimFiyati = birimFiyati;
        this.tutar = tutar;
        this.alisFiyati = alisFiyati;
    }

    public Integer getSatisFisiLineId() {
        return satisFisiLineId;
    }

    public void setSatisFisiLineId(Integer satisFisiLineId) {
        this.satisFisiLineId = satisFisiLineId;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public double getIndirimOrani() {
        return indirimOrani;
    }

    public void setIndirimOrani(double indirimOrani) {
        this.indirimOrani = indirimOrani;
    }

    public double getBirimFiyati() {
        return birimFiyati;
    }

    public void setBirimFiyati(double birimFiyati) {
        this.birimFiyati = birimFiyati;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public String getSeriNo() {
        return seriNo;
    }

    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }

    public double getAlisFiyati() {
        return alisFiyati;
    }

    public void setAlisFiyati(double alisFiyati) {
        this.alisFiyati = alisFiyati;
    }

    public Urunler getUrunId() {
        return urunId;
    }

    public void setUrunId(Urunler urunId) {
        this.urunId = urunId;
    }

    public SatisFisi getSatisFisiId() {
        return satisFisiId;
    }

    public void setSatisFisiId(SatisFisi satisFisiId) {
        this.satisFisiId = satisFisiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (satisFisiLineId != null ? satisFisiLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SatisFisiLine)) {
            return false;
        }
        SatisFisiLine other = (SatisFisiLine) object;
        if ((this.satisFisiLineId == null && other.satisFisiLineId != null) || (this.satisFisiLineId != null && !this.satisFisiLineId.equals(other.satisFisiLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.SatisFisiLine[ satisFisiLineId=" + satisFisiLineId + " ]";
    }
    
}
