package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class OdemeTurleriLine implements Serializable {

    private Integer odemeTurleriLineId;
    private int satisFisiId;
    private double tutar;
    private String hesapTuru;

    public enum OdemeHesapTuru {

        SATIS, CARI, IADE;

        public static String getOdemeHesapTuru(OdemeHesapTuru odemeHesapTuru) {
            if (odemeHesapTuru == SATIS) {
                return "satis";
            } else if (odemeHesapTuru == CARI) {
                return "cari";
            } else if (odemeHesapTuru == IADE) {
                return "iade";
            }
            return null;
        }

    }

    public String getHesapTuru() {
        return hesapTuru;
    }

    public void setHesapTuru(String hesapTuru) {
        this.hesapTuru = hesapTuru;
    }

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

    public void setSatisFisiId(int satisFisiId) {
        this.satisFisiId = satisFisiId;
    }

    public int getSatisFisiId() {
        return satisFisiId;
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
        return (this.odemeTurleriLineId != null || other.odemeTurleriLineId == null) && (this.odemeTurleriLineId == null || this.odemeTurleriLineId.equals(other.odemeTurleriLineId));
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.OdemeTurleriLine[ odemeTurleriLineId=" + odemeTurleriLineId + " ]";
    }

}
