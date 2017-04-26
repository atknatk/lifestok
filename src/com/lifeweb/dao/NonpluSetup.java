/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

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
@Table(name = "nonplu_setup", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NonpluSetup.findAll", query = "SELECT n FROM NonpluSetup n"),
    @NamedQuery(name = "NonpluSetup.findByNpluNo", query = "SELECT n FROM NonpluSetup n WHERE n.npluNo = :npluNo"),
    @NamedQuery(name = "NonpluSetup.findByNpluBarkodtip", query = "SELECT n FROM NonpluSetup n WHERE n.npluBarkodtip = :npluBarkodtip"),
    @NamedQuery(name = "NonpluSetup.findByNpluPluboyut", query = "SELECT n FROM NonpluSetup n WHERE n.npluPluboyut = :npluPluboyut"),
    @NamedQuery(name = "NonpluSetup.findByNpluFmboyut", query = "SELECT n FROM NonpluSetup n WHERE n.npluFmboyut = :npluFmboyut"),
    @NamedQuery(name = "NonpluSetup.findByNpluOndalikboyut", query = "SELECT n FROM NonpluSetup n WHERE n.npluOndalikboyut = :npluOndalikboyut"),
    @NamedQuery(name = "NonpluSetup.findByNpluFmturu", query = "SELECT n FROM NonpluSetup n WHERE n.npluFmturu = :npluFmturu"),
    @NamedQuery(name = "NonpluSetup.findByNpluKontrolHanesi", query = "SELECT n FROM NonpluSetup n WHERE n.npluKontrolHanesi = :npluKontrolHanesi"),
    @NamedQuery(name = "NonpluSetup.findByNpluStatus", query = "SELECT n FROM NonpluSetup n WHERE n.npluStatus = :npluStatus")})
public class NonpluSetup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NPLU_NO", nullable = false)
    private Short npluNo;
    @Column(name = "NPLU_BARKODTIP", length = 6)
    private String npluBarkodtip;
    @Column(name = "NPLU_PLUBOYUT")
    private Short npluPluboyut;
    @Column(name = "NPLU_FMBOYUT")
    private Short npluFmboyut;
    @Column(name = "NPLU_ONDALIKBOYUT")
    private Short npluOndalikboyut;
    @Column(name = "NPLU_FMTURU", length = 6)
    private String npluFmturu;
    @Column(name = "NPLU_KONTROL_HANESI", length = 2)
    private String npluKontrolHanesi;
    @Column(name = "NPLU_STATUS")
    private Short npluStatus;

    public NonpluSetup() {
    }

    public NonpluSetup(Short npluNo) {
        this.npluNo = npluNo;
    }

    public Short getNpluNo() {
        return npluNo;
    }

    public void setNpluNo(Short npluNo) {
        this.npluNo = npluNo;
    }

    public String getNpluBarkodtip() {
        return npluBarkodtip;
    }

    public void setNpluBarkodtip(String npluBarkodtip) {
        this.npluBarkodtip = npluBarkodtip;
    }

    public Short getNpluPluboyut() {
        return npluPluboyut;
    }

    public void setNpluPluboyut(Short npluPluboyut) {
        this.npluPluboyut = npluPluboyut;
    }

    public Short getNpluFmboyut() {
        return npluFmboyut;
    }

    public void setNpluFmboyut(Short npluFmboyut) {
        this.npluFmboyut = npluFmboyut;
    }

    public Short getNpluOndalikboyut() {
        return npluOndalikboyut;
    }

    public void setNpluOndalikboyut(Short npluOndalikboyut) {
        this.npluOndalikboyut = npluOndalikboyut;
    }

    public String getNpluFmturu() {
        return npluFmturu;
    }

    public void setNpluFmturu(String npluFmturu) {
        this.npluFmturu = npluFmturu;
    }

    public String getNpluKontrolHanesi() {
        return npluKontrolHanesi;
    }

    public void setNpluKontrolHanesi(String npluKontrolHanesi) {
        this.npluKontrolHanesi = npluKontrolHanesi;
    }

    public Short getNpluStatus() {
        return npluStatus;
    }

    public void setNpluStatus(Short npluStatus) {
        this.npluStatus = npluStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (npluNo != null ? npluNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NonpluSetup)) {
            return false;
        }
        NonpluSetup other = (NonpluSetup) object;
        if ((this.npluNo == null && other.npluNo != null) || (this.npluNo != null && !this.npluNo.equals(other.npluNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.NonpluSetup[ npluNo=" + npluNo + " ]";
    }
    
}
