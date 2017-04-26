/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doviz.findAll", query = "SELECT d FROM Doviz d"),
    @NamedQuery(name = "Doviz.findByTarih", query = "SELECT d FROM Doviz d WHERE d.tarih = :tarih"),
    @NamedQuery(name = "Doviz.findByDolarsatis", query = "SELECT d FROM Doviz d WHERE d.dolarsatis = :dolarsatis"),
    @NamedQuery(name = "Doviz.findByEurosatis", query = "SELECT d FROM Doviz d WHERE d.eurosatis = :eurosatis"),
    @NamedQuery(name = "Doviz.findBySterlinsatis", query = "SELECT d FROM Doviz d WHERE d.sterlinsatis = :sterlinsatis")})
public class DovizDao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date tarih;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 12, scale = 5)
    private Double dolarsatis;
    @Column(precision = 12, scale = 5)
    private Double eurosatis;
    @Column(precision = 12, scale = 5)
    private Double sterlinsatis;

    public DovizDao() {
    }

    public DovizDao(Date tarih) {
        this.tarih = tarih;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public Double getDolarsatis() {
        return dolarsatis;
    }

    public void setDolarsatis(Double dolarsatis) {
        this.dolarsatis = dolarsatis;
    }

    public Double getEurosatis() {
        return eurosatis;
    }

    public void setEurosatis(Double eurosatis) {
        this.eurosatis = eurosatis;
    }

    public Double getSterlinsatis() {
        return sterlinsatis;
    }

    public void setSterlinsatis(Double sterlinsatis) {
        this.sterlinsatis = sterlinsatis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tarih != null ? tarih.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DovizDao)) {
            return false;
        }
        DovizDao other = (DovizDao) object;
        if ((this.tarih == null && other.tarih != null) || (this.tarih != null && !this.tarih.equals(other.tarih))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.Doviz[ tarih=" + tarih + " ]";
    }
    
}
