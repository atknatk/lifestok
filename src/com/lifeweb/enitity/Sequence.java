/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sequence.findAll", query = "SELECT s FROM Sequence s"),
    @NamedQuery(name = "Sequence.findBySeqCount", query = "SELECT s FROM Sequence s WHERE s.seqCount = :seqCount"),
    @NamedQuery(name = "Sequence.findBySeqName", query = "SELECT s FROM Sequence s WHERE s.seqName = :seqName")})
public class Sequence implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "SEQ_COUNT", nullable = false)
    private int seqCount;
    @Id
    @Basic(optional = false)
    @Column(name = "SEQ_NAME", nullable = false, length = 45)
    private String seqName;

    public Sequence() {
    }

    public Sequence(String seqName) {
        this.seqName = seqName;
    }

    public Sequence(String seqName, int seqCount) {
        this.seqName = seqName;
        this.seqCount = seqCount;
    }

    public int getSeqCount() {
        return seqCount;
    }

    public void setSeqCount(int seqCount) {
        this.seqCount = seqCount;
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqName != null ? seqName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sequence)) {
            return false;
        }
        Sequence other = (Sequence) object;
        if ((this.seqName == null && other.seqName != null) || (this.seqName != null && !this.seqName.equals(other.seqName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.Sequence[ seqName=" + seqName + " ]";
    }
    
}
