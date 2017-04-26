package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class OlcuBirimleri implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer birimId;
    private String birimAdi;
    private String birimDurum;

    public OlcuBirimleri() {
    }

    public OlcuBirimleri(Integer birimId) {
        this.birimId = birimId;
    }

    public OlcuBirimleri(Integer birimId, String birimAdi) {
        this.birimId = birimId;
        this.birimAdi = birimAdi;
    }

    public Integer getBirimId() {
        return birimId;
    }

    public void setBirimId(Integer birimId) {
        this.birimId = birimId;
    }

    public String getBirimAdi() {
        return birimAdi;
    }

    public void setBirimAdi(String birimAdi) {
        this.birimAdi = birimAdi;
    }

    public String getBirimDurum() {
        return birimDurum;
    }

    public void setBirimDurum(String birimDurum) {
        this.birimDurum = birimDurum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (birimId != null ? birimId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OlcuBirimleri)) {
            return false;
        }
        OlcuBirimleri other = (OlcuBirimleri) object;
        if ((this.birimId == null && other.birimId != null) || (this.birimId != null && !this.birimId.equals(other.birimId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return birimAdi;
    }
    
}
