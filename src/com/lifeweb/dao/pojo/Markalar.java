/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class Markalar implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer markaId;
    private String markaAdi;
    private String markaDurum;

    public Markalar() {
    }

    public Markalar(Integer markaId) {
        this.markaId = markaId;
    }

    public Markalar(Integer markaId, String markaAdi) {
        this.markaId = markaId;
        this.markaAdi = markaAdi;
    }

    public Integer getMarkaId() {
        return markaId;
    }

    public void setMarkaId(Integer markaId) {
        this.markaId = markaId;
    }

    public String getMarkaAdi() {
        return markaAdi;
    }

    public void setMarkaAdi(String markaAdi) {
        this.markaAdi = markaAdi;
    }

    public String getMarkaDurum() {
        return markaDurum;
    }

    public void setMarkaDurum(String markaDurum) {
        this.markaDurum = markaDurum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (markaId != null ? markaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Markalar)) {
            return false;
        }
        Markalar other = (Markalar) object;
        if ((this.markaId == null && other.markaId != null) || (this.markaId != null && !this.markaId.equals(other.markaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return markaAdi;
    }
    
}
