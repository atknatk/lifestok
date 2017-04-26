/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "odeme_turleri", catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"ODEME_ADI"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OdemeTurleri.findAll", query = "SELECT o FROM OdemeTurleri o"),
    @NamedQuery(name = "OdemeTurleri.findByOdemeId", query = "SELECT o FROM OdemeTurleri o WHERE o.odemeId = :odemeId"),
    @NamedQuery(name = "OdemeTurleri.findByOdemeAdi", query = "SELECT o FROM OdemeTurleri o WHERE o.odemeAdi = :odemeAdi"),
    @NamedQuery(name = "OdemeTurleri.findByOdemeKisayol", query = "SELECT o FROM OdemeTurleri o WHERE o.odemeKisayol = :odemeKisayol"),
    @NamedQuery(name = "OdemeTurleri.findByOdemeDurum", query = "SELECT o FROM OdemeTurleri o WHERE o.odemeDurum = :odemeDurum"),
    @NamedQuery(name = "OdemeTurleri.findByOdemeVarsayilan", query = "SELECT o FROM OdemeTurleri o WHERE o.odemeVarsayilan = :odemeVarsayilan"),
    @NamedQuery(name = "OdemeTurleri.findByOdemeOzelkod", query = "SELECT o FROM OdemeTurleri o WHERE o.odemeOzelkod = :odemeOzelkod"),
    @NamedQuery(name = "OdemeTurleri.findByOdemeOzelkod2", query = "SELECT o FROM OdemeTurleri o WHERE o.odemeOzelkod2 = :odemeOzelkod2"),
    @NamedQuery(name = "OdemeTurleri.findBySysEkleyen", query = "SELECT o FROM OdemeTurleri o WHERE o.sysEkleyen = :sysEkleyen"),
    @NamedQuery(name = "OdemeTurleri.findBySysEtarih", query = "SELECT o FROM OdemeTurleri o WHERE o.sysEtarih = :sysEtarih"),
    @NamedQuery(name = "OdemeTurleri.findBySysDuzelten", query = "SELECT o FROM OdemeTurleri o WHERE o.sysDuzelten = :sysDuzelten"),
    @NamedQuery(name = "OdemeTurleri.findBySysDtarih", query = "SELECT o FROM OdemeTurleri o WHERE o.sysDtarih = :sysDtarih")})
public class OdemeTurleri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ODEME_ID", nullable = false)
    private Integer odemeId;
    @Basic(optional = false)
    @Column(name = "ODEME_ADI", nullable = false, length = 50)
    private String odemeAdi;
    @Column(name = "ODEME_KISAYOL", length = 15)
    private String odemeKisayol;
    @Column(name = "ODEME_DURUM", length = 20)
    private String odemeDurum;
    @Column(name = "ODEME_VARSAYILAN")
    private Short odemeVarsayilan;
    @Column(name = "ODEME_OZELKOD", length = 20)
    private String odemeOzelkod;
    @Column(name = "ODEME_OZELKOD2", length = 25)
    private String odemeOzelkod2;
    @Column(name = "SYS_EKLEYEN", length = 15)
    private String sysEkleyen;
    @Column(name = "SYS_ETARIH")
    private Integer sysEtarih;
    @Column(name = "SYS_DUZELTEN", length = 15)
    private String sysDuzelten;
    @Column(name = "SYS_DTARIH")
    private Integer sysDtarih;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineOdemeRef", fetch = FetchType.EAGER)
    private List<CariFisler> cariFislerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "odemeId", fetch = FetchType.EAGER)
    private List<OdemeTurleriLine> odemeTurleriLineList;

    public OdemeTurleri() {
    }

    public OdemeTurleri(Integer odemeId) {
        this.odemeId = odemeId;
    }

    public OdemeTurleri(Integer odemeId, String odemeAdi) {
        this.odemeId = odemeId;
        this.odemeAdi = odemeAdi;
    }

    public Integer getOdemeId() {
        return odemeId;
    }

    public void setOdemeId(Integer odemeId) {
        this.odemeId = odemeId;
    }

    public String getOdemeAdi() {
        return odemeAdi;
    }

    public void setOdemeAdi(String odemeAdi) {
        this.odemeAdi = odemeAdi;
    }

    public String getOdemeKisayol() {
        return odemeKisayol;
    }

    public void setOdemeKisayol(String odemeKisayol) {
        this.odemeKisayol = odemeKisayol;
    }

    public String getOdemeDurum() {
        return odemeDurum;
    }

    public void setOdemeDurum(String odemeDurum) {
        this.odemeDurum = odemeDurum;
    }

    public Short getOdemeVarsayilan() {
        return odemeVarsayilan;
    }

    public void setOdemeVarsayilan(Short odemeVarsayilan) {
        this.odemeVarsayilan = odemeVarsayilan;
    }

    public String getOdemeOzelkod() {
        return odemeOzelkod;
    }

    public void setOdemeOzelkod(String odemeOzelkod) {
        this.odemeOzelkod = odemeOzelkod;
    }

    public String getOdemeOzelkod2() {
        return odemeOzelkod2;
    }

    public void setOdemeOzelkod2(String odemeOzelkod2) {
        this.odemeOzelkod2 = odemeOzelkod2;
    }

    public String getSysEkleyen() {
        return sysEkleyen;
    }

    public void setSysEkleyen(String sysEkleyen) {
        this.sysEkleyen = sysEkleyen;
    }

    public Integer getSysEtarih() {
        return sysEtarih;
    }

    public void setSysEtarih(Integer sysEtarih) {
        this.sysEtarih = sysEtarih;
    }

    public String getSysDuzelten() {
        return sysDuzelten;
    }

    public void setSysDuzelten(String sysDuzelten) {
        this.sysDuzelten = sysDuzelten;
    }

    public Integer getSysDtarih() {
        return sysDtarih;
    }

    public void setSysDtarih(Integer sysDtarih) {
        this.sysDtarih = sysDtarih;
    }

    @XmlTransient
    @JsonIgnore
    public List<CariFisler> getCariFislerList() {
        return cariFislerList;
    }

    public void setCariFislerList(List<CariFisler> cariFislerList) {
        this.cariFislerList = cariFislerList;
    }

    @XmlTransient
    @JsonIgnore
    public List<OdemeTurleriLine> getOdemeTurleriLineList() {
        return odemeTurleriLineList;
    }

    public void setOdemeTurleriLineList(List<OdemeTurleriLine> odemeTurleriLineList) {
        this.odemeTurleriLineList = odemeTurleriLineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odemeId != null ? odemeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OdemeTurleri)) {
            return false;
        }
        OdemeTurleri other = (OdemeTurleri) object;
        if ((this.odemeId == null && other.odemeId != null) || (this.odemeId != null && !this.odemeId.equals(other.odemeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.OdemeTurleri[ odemeId=" + odemeId + " ]";
    }
    
}
