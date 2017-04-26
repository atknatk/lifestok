package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class UrunCesit implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cesitId;
    private String cesitAdi;
    private String cesitDurum;

    public UrunCesit() {
    }

    public UrunCesit(Integer cesitId) {
        this.cesitId = cesitId;
    }

    public UrunCesit(Integer cesitId, String cesitAdi) {
        this.cesitId = cesitId;
        this.cesitAdi = cesitAdi;
    }

    public Integer getCesitId() {
        return cesitId;
    }

    public void setCesitId(Integer cesitId) {
        this.cesitId = cesitId;
    }

    public String getCesitAdi() {
        return cesitAdi;
    }

    public void setCesitAdi(String cesitAdi) {
        this.cesitAdi = cesitAdi;
    }

    public String getCesitDurum() {
        return cesitDurum;
    }

    public void setCesitDurum(String cesitDurum) {
        this.cesitDurum = cesitDurum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cesitId != null ? cesitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UrunCesit)) {
            return false;
        }
        UrunCesit other = (UrunCesit) object;
        if ((this.cesitId == null && other.cesitId != null) || (this.cesitId != null && !this.cesitId.equals(other.cesitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cesitAdi;
    }
    
}
