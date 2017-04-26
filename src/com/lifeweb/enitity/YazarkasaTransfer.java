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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "yazarkasa_transfer", catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "YazarkasaTransfer.findAll", query = "SELECT y FROM YazarkasaTransfer y"),
    @NamedQuery(name = "YazarkasaTransfer.findById", query = "SELECT y FROM YazarkasaTransfer y WHERE y.id = :id"),
    @NamedQuery(name = "YazarkasaTransfer.findByZaman", query = "SELECT y FROM YazarkasaTransfer y WHERE y.zaman = :zaman"),
    @NamedQuery(name = "YazarkasaTransfer.findByMarkaModel", query = "SELECT y FROM YazarkasaTransfer y WHERE y.markaModel = :markaModel"),
    @NamedQuery(name = "YazarkasaTransfer.findByKasaNo", query = "SELECT y FROM YazarkasaTransfer y WHERE y.kasaNo = :kasaNo"),
    @NamedQuery(name = "YazarkasaTransfer.findByUrunSayisi", query = "SELECT y FROM YazarkasaTransfer y WHERE y.urunSayisi = :urunSayisi"),
    @NamedQuery(name = "YazarkasaTransfer.findByIslem", query = "SELECT y FROM YazarkasaTransfer y WHERE y.islem = :islem"),
    @NamedQuery(name = "YazarkasaTransfer.findByUser", query = "SELECT y FROM YazarkasaTransfer y WHERE y.user = :user")})
public class YazarkasaTransfer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer zaman;
    @Column(name = "MARKA_MODEL", length = 30)
    private String markaModel;
    @Column(name = "KASA_NO")
    private Integer kasaNo;
    @Column(name = "URUN_SAYISI")
    private Integer urunSayisi;
    @Column(length = 20)
    private String islem;
    @Column(length = 16)
    private String user;

    public YazarkasaTransfer() {
    }

    public YazarkasaTransfer(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getZaman() {
        return zaman;
    }

    public void setZaman(Integer zaman) {
        this.zaman = zaman;
    }

    public String getMarkaModel() {
        return markaModel;
    }

    public void setMarkaModel(String markaModel) {
        this.markaModel = markaModel;
    }

    public Integer getKasaNo() {
        return kasaNo;
    }

    public void setKasaNo(Integer kasaNo) {
        this.kasaNo = kasaNo;
    }

    public Integer getUrunSayisi() {
        return urunSayisi;
    }

    public void setUrunSayisi(Integer urunSayisi) {
        this.urunSayisi = urunSayisi;
    }

    public String getIslem() {
        return islem;
    }

    public void setIslem(String islem) {
        this.islem = islem;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
        if (!(object instanceof YazarkasaTransfer)) {
            return false;
        }
        YazarkasaTransfer other = (YazarkasaTransfer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.YazarkasaTransfer[ id=" + id + " ]";
    }
    
}
