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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"BEDEN_KOD"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bedenler.findAll", query = "SELECT b FROM Bedenler b"),
    @NamedQuery(name = "Bedenler.findByBedenId", query = "SELECT b FROM Bedenler b WHERE b.bedenId = :bedenId"),
    @NamedQuery(name = "Bedenler.findByBedenKod", query = "SELECT b FROM Bedenler b WHERE b.bedenKod = :bedenKod"),
    @NamedQuery(name = "Bedenler.findByBedenDurum", query = "SELECT b FROM Bedenler b WHERE b.bedenDurum = :bedenDurum")})
public class Bedenler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BEDEN_ID", nullable = false)
    private Integer bedenId;
    @Basic(optional = false)
    @Column(name = "BEDEN_KOD", nullable = false, length = 30)
    private String bedenKod;
    @Column(name = "BEDEN_DURUM", length = 20)
    private String bedenDurum;

    public Bedenler() {
    }

    public Bedenler(Integer bedenId) {
        this.bedenId = bedenId;
    }

    public Bedenler(Integer bedenId, String bedenKod) {
        this.bedenId = bedenId;
        this.bedenKod = bedenKod;
    }

    public Integer getBedenId() {
        return bedenId;
    }

    public void setBedenId(Integer bedenId) {
        this.bedenId = bedenId;
    }

    public String getBedenKod() {
        return bedenKod;
    }

    public void setBedenKod(String bedenKod) {
        this.bedenKod = bedenKod;
    }

    public String getBedenDurum() {
        return bedenDurum;
    }

    public void setBedenDurum(String bedenDurum) {
        this.bedenDurum = bedenDurum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bedenId != null ? bedenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bedenler)) {
            return false;
        }
        Bedenler other = (Bedenler) object;
        if ((this.bedenId == null && other.bedenId != null) || (this.bedenId != null && !this.bedenId.equals(other.bedenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.Bedenler[ bedenId=" + bedenId + " ]";
    }
    
}
