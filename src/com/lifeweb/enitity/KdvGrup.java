/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "kdv_grup", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KdvGrup.findAll", query = "SELECT k FROM KdvGrup k"),
    @NamedQuery(name = "KdvGrup.findByKdvGrupNo", query = "SELECT k FROM KdvGrup k WHERE k.kdvGrupNo = :kdvGrupNo"),
    @NamedQuery(name = "KdvGrup.findByKdvGrupOran", query = "SELECT k FROM KdvGrup k WHERE k.kdvGrupOran = :kdvGrupOran"),
    @NamedQuery(name = "KdvGrup.findByKdvAciklama", query = "SELECT k FROM KdvGrup k WHERE k.kdvAciklama = :kdvAciklama")})
public class KdvGrup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KDV_GRUP_NO", nullable = false)
    private Short kdvGrupNo;
    @Column(name = "KDV_GRUP_ORAN")
    private Short kdvGrupOran;
    @Column(name = "KDV_ACIKLAMA", length = 16)
    private String kdvAciklama;
    @OneToMany(mappedBy = "urunKdvGrup", fetch = FetchType.EAGER)
    private List<Urunler> urunlerList;
    @OneToMany(mappedBy = "deptKdvRef", fetch = FetchType.EAGER)
    private List<Departman> departmanList;

    public KdvGrup() {
    }

    public KdvGrup(Short kdvGrupNo) {
        this.kdvGrupNo = kdvGrupNo;
    }

    public Short getKdvGrupNo() {
        return kdvGrupNo;
    }

    public void setKdvGrupNo(Short kdvGrupNo) {
        this.kdvGrupNo = kdvGrupNo;
    }

    public Short getKdvGrupOran() {
        return kdvGrupOran;
    }

    public void setKdvGrupOran(Short kdvGrupOran) {
        this.kdvGrupOran = kdvGrupOran;
    }

    public String getKdvAciklama() {
        return kdvAciklama;
    }

    public void setKdvAciklama(String kdvAciklama) {
        this.kdvAciklama = kdvAciklama;
    }

    @XmlTransient
    @JsonIgnore
    public List<Urunler> getUrunlerList() {
        return urunlerList;
    }

    public void setUrunlerList(List<Urunler> urunlerList) {
        this.urunlerList = urunlerList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Departman> getDepartmanList() {
        return departmanList;
    }

    public void setDepartmanList(List<Departman> departmanList) {
        this.departmanList = departmanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdvGrupNo != null ? kdvGrupNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KdvGrup)) {
            return false;
        }
        KdvGrup other = (KdvGrup) object;
        if ((this.kdvGrupNo == null && other.kdvGrupNo != null) || (this.kdvGrupNo != null && !this.kdvGrupNo.equals(other.kdvGrupNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return kdvGrupOran.toString();
    }
    
}
