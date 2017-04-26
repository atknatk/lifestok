
package com.lifeweb.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Life
 */
@Embeddable
public class SubelerBakiyePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "SUBE_REF", nullable = false)
    private int subeRef;
    @Basic(optional = false)
    @Column(name = "STOK_REF", nullable = false)
    private int stokRef;

    public SubelerBakiyePK() {
    }

    public SubelerBakiyePK(int subeRef, int stokRef) {
        this.subeRef = subeRef;
        this.stokRef = stokRef;
    }

    public int getSubeRef() {
        return subeRef;
    }

    public void setSubeRef(int subeRef) {
        this.subeRef = subeRef;
    }

    public int getStokRef() {
        return stokRef;
    }

    public void setStokRef(int stokRef) {
        this.stokRef = stokRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += subeRef;
        hash += stokRef;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubelerBakiyePK)) {
            return false;
        }
        SubelerBakiyePK other = (SubelerBakiyePK) object;
        if (this.subeRef != other.subeRef) {
            return false;
        }
        if (this.stokRef != other.stokRef) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.SubelerBakiyePK[ subeRef=" + subeRef + ", stokRef=" + stokRef + " ]";
    }
    
}
