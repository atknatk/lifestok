/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "urunler_foto", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UrunlerFoto.findAll", query = "SELECT u FROM UrunlerFoto u"),
    @NamedQuery(name = "UrunlerFoto.findByFotoId", query = "SELECT u FROM UrunlerFoto u WHERE u.fotoId = :fotoId"),
    @NamedQuery(name = "UrunlerFoto.findByUreticiRef", query = "SELECT u FROM UrunlerFoto u WHERE u.ureticiRef = :ureticiRef")})
public class UrunlerFoto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FOTO_ID", nullable = false)
    private Integer fotoId;
    @Column(name = "URETICI_REF", length = 50)
    private String ureticiRef;
    @Lob
    @Column(name = "URUN_FOTO")
    private byte[] urunFoto;
    @JoinColumn(name = "GRUP_REF", referencedColumnName = "URUN_GRUP_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private UrunGrupDao grupRef;
    @JoinColumn(name = "CESIT_REF", referencedColumnName = "CESIT_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private UrunCesitDao cesitRef;
    @JoinColumn(name = "MARKA_REF", referencedColumnName = "MARKA_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private MarkalarDao markaRef;
    @JoinColumn(name = "URUN_REF", referencedColumnName = "URUN_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UrunlerDao urunRef;

    public UrunlerFoto() {
    }

    public UrunlerFoto(Integer fotoId) {
        this.fotoId = fotoId;
    }

    public Integer getFotoId() {
        return fotoId;
    }

    public void setFotoId(Integer fotoId) {
        this.fotoId = fotoId;
    }

    public String getUreticiRef() {
        return ureticiRef;
    }

    public void setUreticiRef(String ureticiRef) {
        this.ureticiRef = ureticiRef;
    }

    public byte[] getUrunFoto() {
        return urunFoto;
    }

    public void setUrunFoto(byte[] urunFoto) {
        this.urunFoto = urunFoto;
    }

    public UrunGrupDao getGrupRef() {
        return grupRef;
    }

    public void setGrupRef(UrunGrupDao grupRef) {
        this.grupRef = grupRef;
    }

    public UrunCesitDao getCesitRef() {
        return cesitRef;
    }

    public void setCesitRef(UrunCesitDao cesitRef) {
        this.cesitRef = cesitRef;
    }

    public MarkalarDao getMarkaRef() {
        return markaRef;
    }

    public void setMarkaRef(MarkalarDao markaRef) {
        this.markaRef = markaRef;
    }

    public UrunlerDao getUrunRef() {
        return urunRef;
    }

    public void setUrunRef(UrunlerDao urunRef) {
        this.urunRef = urunRef;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fotoId != null ? fotoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UrunlerFoto)) {
            return false;
        }
        UrunlerFoto other = (UrunlerFoto) object;
        if ((this.fotoId == null && other.fotoId != null) || (this.fotoId != null && !this.fotoId.equals(other.fotoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.UrunlerFoto[ fotoId=" + fotoId + " ]";
    }
    
}
