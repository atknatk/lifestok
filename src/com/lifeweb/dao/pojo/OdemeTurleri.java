package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class OdemeTurleri implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer odemeId;
    private String odemeAdi;
    private String odemeKisayol;
    private String odemeDurum;
    private Short odemeVarsayilan;
    private String odemeOzelkod;
    private String odemeOzelkod2;
    private String sysEkleyen;
    private String sysDuzelten;
    private Integer sysDtarih;
    private Integer sysEtarih;

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
