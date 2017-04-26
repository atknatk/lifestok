/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "subeler_bakiye", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubelerBakiye.findAll", query = "SELECT s FROM SubelerBakiye s"),
    @NamedQuery(name = "SubelerBakiye.findBySubeRef", query = "SELECT s FROM SubelerBakiye s WHERE s.subelerBakiyePK.subeRef = :subeRef"),
    @NamedQuery(name = "SubelerBakiye.findByStokRef", query = "SELECT s FROM SubelerBakiye s WHERE s.subelerBakiyePK.stokRef = :stokRef"),
    @NamedQuery(name = "SubelerBakiye.findByBakiye", query = "SELECT s FROM SubelerBakiye s WHERE s.bakiye = :bakiye"),
    @NamedQuery(name = "SubelerBakiye.findByAb", query = "SELECT s FROM SubelerBakiye s WHERE s.ab = :ab"),
    @NamedQuery(name = "SubelerBakiye.findByIsaret", query = "SELECT s FROM SubelerBakiye s WHERE s.isaret = :isaret")})
public class SubelerBakiye implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SubelerBakiyePK subelerBakiyePK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 15, scale = 2)
    private Double bakiye;
    @Column(length = 3)
    private String ab;
    @Column(length = 1)
    private String isaret;
    @JoinColumn(name = "SUBE_REF", referencedColumnName = "SUBE_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SubelerDao subeler;

    public SubelerBakiye() {
    }

    public SubelerBakiye(SubelerBakiyePK subelerBakiyePK) {
        this.subelerBakiyePK = subelerBakiyePK;
    }

    public SubelerBakiye(int subeRef, int stokRef) {
        this.subelerBakiyePK = new SubelerBakiyePK(subeRef, stokRef);
    }

    public SubelerBakiyePK getSubelerBakiyePK() {
        return subelerBakiyePK;
    }

    public void setSubelerBakiyePK(SubelerBakiyePK subelerBakiyePK) {
        this.subelerBakiyePK = subelerBakiyePK;
    }

    public Double getBakiye() {
        return bakiye;
    }

    public void setBakiye(Double bakiye) {
        this.bakiye = bakiye;
    }

    public String getAb() {
        return ab;
    }

    public void setAb(String ab) {
        this.ab = ab;
    }

    public String getIsaret() {
        return isaret;
    }

    public void setIsaret(String isaret) {
        this.isaret = isaret;
    }

    public SubelerDao getSubeler() {
        return subeler;
    }

    public void setSubeler(SubelerDao subeler) {
        this.subeler = subeler;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subelerBakiyePK != null ? subelerBakiyePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubelerBakiye)) {
            return false;
        }
        SubelerBakiye other = (SubelerBakiye) object;
        if ((this.subelerBakiyePK == null && other.subelerBakiyePK != null) || (this.subelerBakiyePK != null && !this.subelerBakiyePK.equals(other.subelerBakiyePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.SubelerBakiye[ subelerBakiyePK=" + subelerBakiyePK + " ]";
    }
    
}
