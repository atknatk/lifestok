/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "cari_fis_turleri", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CariFisTurleri.findAll", query = "SELECT c FROM CariFisTurleri c"),
    @NamedQuery(name = "CariFisTurleri.findByFturId", query = "SELECT c FROM CariFisTurleri c WHERE c.fturId = :fturId"),
    @NamedQuery(name = "CariFisTurleri.findBySiraNo", query = "SELECT c FROM CariFisTurleri c WHERE c.siraNo = :siraNo"),
    @NamedQuery(name = "CariFisTurleri.findByFturAdi", query = "SELECT c FROM CariFisTurleri c WHERE c.fturAdi = :fturAdi"),
    @NamedQuery(name = "CariFisTurleri.findByFturVarsayilan", query = "SELECT c FROM CariFisTurleri c WHERE c.fturVarsayilan = :fturVarsayilan"),
    @NamedQuery(name = "CariFisTurleri.findByFturBorc", query = "SELECT c FROM CariFisTurleri c WHERE c.fturBorc = :fturBorc")})
public class CariFisTurleri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FTUR_ID", nullable = false)
    private Integer fturId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SIRA_NO", precision = 9, scale = 2)
    private Float siraNo;
    @Column(name = "FTUR_ADI", length = 30)
    private String fturAdi;
    @Column(name = "FTUR_VARSAYILAN")
    private Short fturVarsayilan;
    @Column(name = "FTUR_BORC")
    private Short fturBorc;

    public CariFisTurleri() {
    }

    public CariFisTurleri(Integer fturId) {
        this.fturId = fturId;
    }

    public Integer getFturId() {
        return fturId;
    }

    public void setFturId(Integer fturId) {
        this.fturId = fturId;
    }

    public Float getSiraNo() {
        return siraNo;
    }

    public void setSiraNo(Float siraNo) {
        this.siraNo = siraNo;
    }

    public String getFturAdi() {
        return fturAdi;
    }

    public void setFturAdi(String fturAdi) {
        this.fturAdi = fturAdi;
    }

    public Short getFturVarsayilan() {
        return fturVarsayilan;
    }

    public void setFturVarsayilan(Short fturVarsayilan) {
        this.fturVarsayilan = fturVarsayilan;
    }

    public Short getFturBorc() {
        return fturBorc;
    }

    public void setFturBorc(Short fturBorc) {
        this.fturBorc = fturBorc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fturId != null ? fturId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CariFisTurleri)) {
            return false;
        }
        CariFisTurleri other = (CariFisTurleri) object;
        if ((this.fturId == null && other.fturId != null) || (this.fturId != null && !this.fturId.equals(other.fturId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.CariFisTurleri[ fturId=" + fturId + " ]";
    }
    
}
