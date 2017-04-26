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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametreler.findAll", query = "SELECT p FROM Parametreler p"),
    @NamedQuery(name = "Parametreler.findByParamId", query = "SELECT p FROM Parametreler p WHERE p.paramId = :paramId")})
public class Parametreler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PARAM_ID", nullable = false)
    private Integer paramId;
    @Lob
    @Column(name = "PARAM_GRID")
    private byte[] paramGrid;

    public Parametreler() {
    }

    public Parametreler(Integer paramId) {
        this.paramId = paramId;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public byte[] getParamGrid() {
        return paramGrid;
    }

    public void setParamGrid(byte[] paramGrid) {
        this.paramGrid = paramGrid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paramId != null ? paramId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametreler)) {
            return false;
        }
        Parametreler other = (Parametreler) object;
        if ((this.paramId == null && other.paramId != null) || (this.paramId != null && !this.paramId.equals(other.paramId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.Parametreler[ paramId=" + paramId + " ]";
    }
    
}
