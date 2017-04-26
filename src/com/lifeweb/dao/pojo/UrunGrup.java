/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class UrunGrup implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer urunGrupId;
    private String urunGrupAdi;
    private String urunGrupDurum;
    private String urunGrupYazici;
    
    public UrunGrup() {
    }

    public UrunGrup(Integer urunGrupId) {
        this.urunGrupId = urunGrupId;
    }

    public UrunGrup(Integer urunGrupId, String urunGrupAdi) {
        this.urunGrupId = urunGrupId;
        this.urunGrupAdi = urunGrupAdi;
    }

    public Integer getUrunGrupId() {
        return urunGrupId;
    }

    public void setUrunGrupId(Integer urunGrupId) {
        this.urunGrupId = urunGrupId;
    }

    public String getUrunGrupAdi() {
        return urunGrupAdi;
    }

    public void setUrunGrupAdi(String urunGrupAdi) {
        this.urunGrupAdi = urunGrupAdi;
    }

    public String getUrunGrupDurum() {
        return urunGrupDurum;
    }

    public void setUrunGrupDurum(String urunGrupDurum) {
        this.urunGrupDurum = urunGrupDurum;
    }

    public String getUrunGrupYazici() {
        return urunGrupYazici;
    }

    public void setUrunGrupYazici(String urunGrupYazici) {
        this.urunGrupYazici = urunGrupYazici;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (urunGrupId != null ? urunGrupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UrunGrup)) {
            return false;
        }
        UrunGrup other = (UrunGrup) object;
        if ((this.urunGrupId == null && other.urunGrupId != null) || (this.urunGrupId != null && !this.urunGrupId.equals(other.urunGrupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return urunGrupAdi;
    }
    
}
