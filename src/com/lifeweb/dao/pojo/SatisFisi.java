package com.lifeweb.dao.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SatisFisi implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer satisFisiId;
    private Date fisTarihi;
    private Date fisSaati;
    private String ozelKodu;
    private String belgeNo;
    private String aciklama;
    private double iskontoTutari;
    private double iskontoOrani;
    private double indirimTutari;
    private double araToplam;
    private double kdvToplam;
    private double genelToplam;
    private Subeler subeId;
    private CariHesaplar hesapId;
    private Kullanici sysEkleyen;
    private List<SatisFisiLine> satisFisiLineList;

    public SatisFisi() {
    }

    public SatisFisi(Integer satisFisiId) {
        this.satisFisiId = satisFisiId;
    }

    public SatisFisi(Integer satisFisiId, Date fisTarihi, Date fisSaati, double iskontoTutari, double iskontoOrani, double indirimTutari, double araToplam, double kdvToplam, double genelToplam) {
        this.satisFisiId = satisFisiId;
        this.fisTarihi = fisTarihi;
        this.fisSaati = fisSaati;
        this.iskontoTutari = iskontoTutari;
        this.iskontoOrani = iskontoOrani;
        this.indirimTutari = indirimTutari;
        this.araToplam = araToplam;
        this.kdvToplam = kdvToplam;
        this.genelToplam = genelToplam;
    }

    public List<SatisFisiLine> getSatisFisiLineList() {
        return satisFisiLineList;
    }

    public void setSatisFisiLineList(List<SatisFisiLine> satisFisiLineList) {
        this.satisFisiLineList = satisFisiLineList;
    }

    
    
    public Integer getSatisFisiId() {
        return satisFisiId;
    }

    public void setSatisFisiId(Integer satisFisiId) {
        this.satisFisiId = satisFisiId;
    }

    public Date getFisTarihi() {
        return fisTarihi;
    }

    public void setFisTarihi(Date fisTarihi) {
        this.fisTarihi = fisTarihi;
    }

    public Date getFisSaati() {
        return fisSaati;
    }

    public void setFisSaati(Date fisSaati) {
        this.fisSaati = fisSaati;
    }

    public String getOzelKodu() {
        return ozelKodu;
    }

    public void setOzelKodu(String ozelKodu) {
        this.ozelKodu = ozelKodu;
    }

    public String getBelgeNo() {
        return belgeNo;
    }

    public void setBelgeNo(String belgeNo) {
        this.belgeNo = belgeNo;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public double getIskontoTutari() {
        return iskontoTutari;
    }

    public void setIskontoTutari(double iskontoTutari) {
        this.iskontoTutari = iskontoTutari;
    }

    public double getIskontoOrani() {
        return iskontoOrani;
    }

    public void setIskontoOrani(double iskontoOrani) {
        this.iskontoOrani = iskontoOrani;
    }

    public double getIndirimTutari() {
        return indirimTutari;
    }

    public void setIndirimTutari(double indirimTutari) {
        this.indirimTutari = indirimTutari;
    }

    public double getAraToplam() {
        return araToplam;
    }

    public void setAraToplam(double araToplam) {
        this.araToplam = araToplam;
    }

    public double getKdvToplam() {
        return kdvToplam;
    }

    public void setKdvToplam(double kdvToplam) {
        this.kdvToplam = kdvToplam;
    }

    public double getGenelToplam() {
        return genelToplam;
    }

    public void setGenelToplam(double genelToplam) {
        this.genelToplam = genelToplam;
    }

    public Subeler getSubeId() {
        return subeId;
    }

    public void setSubeId(Subeler subeId) {
        this.subeId = subeId;
    }

    public CariHesaplar getHesapId() {
        return hesapId;
    }

    public void setHesapId(CariHesaplar hesapId) {
        this.hesapId = hesapId;
    }

    public Kullanici getSysEkleyen() {
        return sysEkleyen;
    }

    public void setSysEkleyen(Kullanici sysEkleyen) {
        this.sysEkleyen = sysEkleyen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (satisFisiId != null ? satisFisiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SatisFisi)) {
            return false;
        }
        SatisFisi other = (SatisFisi) object;
        if ((this.satisFisiId == null && other.satisFisiId != null) || (this.satisFisiId != null && !this.satisFisiId.equals(other.satisFisiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.SatisFisi[ satisFisiId=" + satisFisiId + " ]";
    }
}
