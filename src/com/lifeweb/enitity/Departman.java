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
@Table(catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departman.findAll", query = "SELECT d FROM Departman d"),
    @NamedQuery(name = "Departman.findByDeptNo", query = "SELECT d FROM Departman d WHERE d.deptNo = :deptNo"),
    @NamedQuery(name = "Departman.findByDeptAciklama", query = "SELECT d FROM Departman d WHERE d.deptAciklama = :deptAciklama"),
    @NamedQuery(name = "Departman.findByDeptGrupNo", query = "SELECT d FROM Departman d WHERE d.deptGrupNo = :deptGrupNo"),
    @NamedQuery(name = "Departman.findByDeptYazici", query = "SELECT d FROM Departman d WHERE d.deptYazici = :deptYazici"),
    @NamedQuery(name = "Departman.findByDeptKomisyon", query = "SELECT d FROM Departman d WHERE d.deptKomisyon = :deptKomisyon"),
    @NamedQuery(name = "Departman.findByDeptLimit", query = "SELECT d FROM Departman d WHERE d.deptLimit = :deptLimit")})
public class Departman implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DEPT_NO", nullable = false)
    private Integer deptNo;
    @Column(name = "DEPT_ACIKLAMA", length = 16)
    private String deptAciklama;
    @Column(name = "DEPT_GRUP_NO")
    private Short deptGrupNo;
    @Column(name = "DEPT_YAZICI")
    private Short deptYazici;
    @Column(name = "DEPT_KOMISYON")
    private Short deptKomisyon;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DEPT_LIMIT", precision = 10, scale = 2)
    private Double deptLimit;
    @JoinColumn(name = "DEPT_KDV_REF", referencedColumnName = "KDV_GRUP_NO")
    @ManyToOne(fetch = FetchType.EAGER)
    private KdvGrup deptKdvRef;

    public Departman() {
    }

    public Departman(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptAciklama() {
        return deptAciklama;
    }

    public void setDeptAciklama(String deptAciklama) {
        this.deptAciklama = deptAciklama;
    }

    public Short getDeptGrupNo() {
        return deptGrupNo;
    }

    public void setDeptGrupNo(Short deptGrupNo) {
        this.deptGrupNo = deptGrupNo;
    }

    public Short getDeptYazici() {
        return deptYazici;
    }

    public void setDeptYazici(Short deptYazici) {
        this.deptYazici = deptYazici;
    }

    public Short getDeptKomisyon() {
        return deptKomisyon;
    }

    public void setDeptKomisyon(Short deptKomisyon) {
        this.deptKomisyon = deptKomisyon;
    }

    public Double getDeptLimit() {
        return deptLimit;
    }

    public void setDeptLimit(Double deptLimit) {
        this.deptLimit = deptLimit;
    }

    public KdvGrup getDeptKdvRef() {
        return deptKdvRef;
    }

    public void setDeptKdvRef(KdvGrup deptKdvRef) {
        this.deptKdvRef = deptKdvRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptNo != null ? deptNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departman)) {
            return false;
        }
        Departman other = (Departman) object;
        if ((this.deptNo == null && other.deptNo != null) || (this.deptNo != null && !this.deptNo.equals(other.deptNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.Departman[ deptNo=" + deptNo + " ]";
    }
    
}
