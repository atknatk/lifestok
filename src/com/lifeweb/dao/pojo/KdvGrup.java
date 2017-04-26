/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.pojo;

import java.io.Serializable;

public class KdvGrup implements Serializable {
    private static final long serialVersionUID = 1L;
    private Short kdvGrupNo;
    private Short kdvGrupOran;
    private String kdvAciklama;
    
    public KdvGrup() {
    }

    public KdvGrup(Short kdvGrupNo) {
        this.kdvGrupNo = kdvGrupNo;
    }

    public KdvGrup(Short kdvGrupNo, Short kdvGrupOran, String kdvAciklama) {
        this.kdvGrupNo = kdvGrupNo;
        this.kdvGrupOran = kdvGrupOran;
        this.kdvAciklama = kdvAciklama;
    }

    
    public Short getKdvGrupNo() {
        return kdvGrupNo;
    }

    public void setKdvGrupNo(Short kdvGrupNo) {
        this.kdvGrupNo = kdvGrupNo;
    }

    public Short getKdvGrupOran() {
        return kdvGrupOran;
    }

    public void setKdvGrupOran(Short kdvGrupOran) {
        this.kdvGrupOran = kdvGrupOran;
    }

    public String getKdvAciklama() {
        return kdvAciklama;
    }

    public void setKdvAciklama(String kdvAciklama) {
        this.kdvAciklama = kdvAciklama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kdvGrupNo != null ? kdvGrupNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KdvGrup)) {
            return false;
        }
        KdvGrup other = (KdvGrup) object;
        if ((this.kdvGrupNo == null && other.kdvGrupNo != null) || (this.kdvGrupNo != null && !this.kdvGrupNo.equals(other.kdvGrupNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return kdvGrupOran.toString();
    }
    
}
