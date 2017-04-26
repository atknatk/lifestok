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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "odeme_turleri_line", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdemeTurleriLine.findAll", query = "SELECT o FROM OdemeTurleriLine o"),
    @NamedQuery(name = "OdemeTurleriLine.findByOdemeTurleriLineId", query = "SELECT o FROM OdemeTurleriLine o WHERE o.odemeTurleriLineId = :odemeTurleriLineId"),
    @NamedQuery(name = "OdemeTurleriLine.findByTutar", query = "SELECT o FROM OdemeTurleriLine o WHERE o.tutar = :tutar")})
public class OdemeTurleriLine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ODEME_TURLERI_LINE_ID", nullable = false)
    private Integer odemeTurleriLineId;
    @Basic(optional = false)
    @Column(nullable = false)
    private double tutar;
    @JoinColumn(name = "SATIS_FISI_ID", referencedColumnName = "SATIS_FISI_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SatisFisi satisFisiId;
    @JoinColumn(name = "ODEME_ID", referencedColumnName = "ODEME_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OdemeTurleri odemeId;

    public OdemeTurleriLine() {
    }

    public OdemeTurleriLine(Integer odemeTurleriLineId) {
        this.odemeTurleriLineId = odemeTurleriLineId;
    }

    public OdemeTurleriLine(Integer odemeTurleriLineId, double tutar) {
        this.odemeTurleriLineId = odemeTurleriLineId;
        this.tutar = tutar;
    }

    public Integer getOdemeTurleriLineId() {
        return odemeTurleriLineId;
    }

    public void setOdemeTurleriLineId(Integer odemeTurleriLineId) {
        this.odemeTurleriLineId = odemeTurleriLineId;
    }

    public double getTutar() {
        return tutar;
    }

    public void setTutar(double tutar) {
        this.tutar = tutar;
    }

    public SatisFisi getSatisFisiId() {
        return satisFisiId;
    }

    public void setSatisFisiId(SatisFisi satisFisiId) {
        this.satisFisiId = satisFisiId;
    }

    public OdemeTurleri getOdemeId() {
        return odemeId;
    }

    public void setOdemeId(OdemeTurleri odemeId) {
        this.odemeId = odemeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odemeTurleriLineId != null ? odemeTurleriLineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdemeTurleriLine)) {
            return false;
        }
        OdemeTurleriLine other = (OdemeTurleriLine) object;
        if ((this.odemeTurleriLineId == null && other.odemeTurleriLineId != null) || (this.odemeTurleriLineId != null && !this.odemeTurleriLineId.equals(other.odemeTurleriLineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.OdemeTurleriLine[ odemeTurleriLineId=" + odemeTurleriLineId + " ]";
    }
    
}
