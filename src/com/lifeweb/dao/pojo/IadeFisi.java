package com.lifeweb.dao.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class IadeFisi implements Serializable {

    private Integer iadeFisiId;
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
    private String cariHesaplarAdi;
    private List<IadeFisiLine> iadeFisiLineList;

    public IadeFisi() {
    }

    public String getCariHesaplarAdi() {
        return cariHesaplarAdi;
    }

    public void setCariHesaplarAdi(String cariHesaplarAdi) {
        this.cariHesaplarAdi = cariHesaplarAdi;
    }

    public Integer getIadeFisiId() {
        return iadeFisiId;
    }

    public void setIadeFisiId(Integer iadeFisiId) {
        this.iadeFisiId = iadeFisiId;
    }

    public List<IadeFisiLine> getIadeFisiLineList() {
        return iadeFisiLineList;
    }

    public void setIadeFisiLineList(List<IadeFisiLine> iadeFisiLineList) {
        this.iadeFisiLineList = iadeFisiLineList;
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

}
