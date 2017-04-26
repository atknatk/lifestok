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
@Table(name = "maliyet_temp", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MaliyetTemp.findAll", query = "SELECT m FROM MaliyetTemp m"),
    @NamedQuery(name = "MaliyetTemp.findById", query = "SELECT m FROM MaliyetTemp m WHERE m.id = :id"),
    @NamedQuery(name = "MaliyetTemp.findByUrunRef", query = "SELECT m FROM MaliyetTemp m WHERE m.urunRef = :urunRef"),
    @NamedQuery(name = "MaliyetTemp.findByBirimMaliyet", query = "SELECT m FROM MaliyetTemp m WHERE m.birimMaliyet = :birimMaliyet")})
public class MaliyetTemp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "URUN_REF", nullable = false)
    private int urunRef;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BIRIM_MALIYET", precision = 15, scale = 2)
    private Double birimMaliyet;

    public MaliyetTemp() {
    }

    public MaliyetTemp(Integer id) {
        this.id = id;
    }

    public MaliyetTemp(Integer id, int urunRef) {
        this.id = id;
        this.urunRef = urunRef;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUrunRef() {
        return urunRef;
    }

    public void setUrunRef(int urunRef) {
        this.urunRef = urunRef;
    }

    public Double getBirimMaliyet() {
        return birimMaliyet;
    }

    public void setBirimMaliyet(Double birimMaliyet) {
        this.birimMaliyet = birimMaliyet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaliyetTemp)) {
            return false;
        }
        MaliyetTemp other = (MaliyetTemp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.MaliyetTemp[ id=" + id + " ]";
    }
    
}
