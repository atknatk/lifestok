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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Life
 */
@Entity
@Table(catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"BANKA_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bankalar.findAll", query = "SELECT b FROM Bankalar b"),
    @NamedQuery(name = "Bankalar.findByBankaAdi", query = "SELECT b FROM Bankalar b WHERE b.bankaAdi = :bankaAdi"),
    @NamedQuery(name = "Bankalar.findByBankaDurum", query = "SELECT b FROM Bankalar b WHERE b.bankaDurum = :bankaDurum"),
    @NamedQuery(name = "Bankalar.findByBankaId", query = "SELECT b FROM Bankalar b WHERE b.bankaId = :bankaId")})
public class Bankalar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "BANKA_ADI", nullable = false, length = 50)
    private String bankaAdi;
    @Column(name = "BANKA_DURUM", length = 20)
    private String bankaDurum;
    @Basic(optional = false)
    @Column(name = "BANKA_ID", nullable = false)
    private int bankaId;
    @OneToMany(mappedBy = "bankaRef", fetch = FetchType.EAGER)
    private List<BankaFisleri> bankaFisleriList;

    public Bankalar() {
    }

    public Bankalar(String bankaAdi) {
        this.bankaAdi = bankaAdi;
    }

    public Bankalar(String bankaAdi, int bankaId) {
        this.bankaAdi = bankaAdi;
        this.bankaId = bankaId;
    }

    public String getBankaAdi() {
        return bankaAdi;
    }

    public void setBankaAdi(String bankaAdi) {
        this.bankaAdi = bankaAdi;
    }

    public String getBankaDurum() {
        return bankaDurum;
    }

    public void setBankaDurum(String bankaDurum) {
        this.bankaDurum = bankaDurum;
    }

    public int getBankaId() {
        return bankaId;
    }

    public void setBankaId(int bankaId) {
        this.bankaId = bankaId;
    }

    @XmlTransient
    @JsonIgnore
    public List<BankaFisleri> getBankaFisleriList() {
        return bankaFisleriList;
    }

    public void setBankaFisleriList(List<BankaFisleri> bankaFisleriList) {
        this.bankaFisleriList = bankaFisleriList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankaAdi != null ? bankaAdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bankalar)) {
            return false;
        }
        Bankalar other = (Bankalar) object;
        if ((this.bankaAdi == null && other.bankaAdi != null) || (this.bankaAdi != null && !this.bankaAdi.equals(other.bankaAdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.Bankalar[ bankaAdi=" + bankaAdi + " ]";
    }
    
}
