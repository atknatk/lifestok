/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"RENK_KOD"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Renkler.findAll", query = "SELECT r FROM Renkler r"),
    @NamedQuery(name = "Renkler.findByRenkId", query = "SELECT r FROM Renkler r WHERE r.renkId = :renkId"),
    @NamedQuery(name = "Renkler.findByRenkKod", query = "SELECT r FROM Renkler r WHERE r.renkKod = :renkKod"),
    @NamedQuery(name = "Renkler.findByRenkDurum", query = "SELECT r FROM Renkler r WHERE r.renkDurum = :renkDurum")})
public class RenklerDao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "RENK_ID", nullable = false)
    private Integer renkId;
    @Basic(optional = false)
    @Column(name = "RENK_KOD", nullable = false, length = 30)
    private String renkKod;
    @Column(name = "RENK_DURUM", length = 20)
    private String renkDurum;

    public RenklerDao() {
    }

    public RenklerDao(Integer renkId) {
        this.renkId = renkId;
    }

    public RenklerDao(Integer renkId, String renkKod) {
        this.renkId = renkId;
        this.renkKod = renkKod;
    }

    public Integer getRenkId() {
        return renkId;
    }

    public void setRenkId(Integer renkId) {
        this.renkId = renkId;
    }

    public String getRenkKod() {
        return renkKod;
    }

    public void setRenkKod(String renkKod) {
        this.renkKod = renkKod;
    }

    public String getRenkDurum() {
        return renkDurum;
    }

    public void setRenkDurum(String renkDurum) {
        this.renkDurum = renkDurum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (renkId != null ? renkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RenklerDao)) {
            return false;
        }
        RenklerDao other = (RenklerDao) object;
        if ((this.renkId == null && other.renkId != null) || (this.renkId != null && !this.renkId.equals(other.renkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.Renkler[ renkId=" + renkId + " ]";
    }
    
}
