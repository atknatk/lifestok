package com.lifeweb.dao.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TahsilatFisi implements Serializable {

    private Integer tahsilatFisiId;
    private Date fisTarihi;
    private Date fisSaati;
    private String ozelKodu;
    private String belgeNo;
    private String aciklama;
    private double genelToplam;
    private Subeler subeId;
    private CariHesaplar hesapId;
    private Kullanici sysEkleyen;
    private String cariHesaplarAdi;


    public TahsilatFisi() {
    }

    public String getCariHesaplarAdi() {
        return cariHesaplarAdi;
    }

    public void setCariHesaplarAdi(String cariHesaplarAdi) {
        this.cariHesaplarAdi = cariHesaplarAdi;
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
