/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao.pojo;

import java.io.Serializable;
import java.util.Date;

public class Urunler implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer urunId;
    private String barkodId;
    private Short barkodTur;
    private String barkodTip;
    private String urunAdi;
    private Double urunAlisFiyat;
    private Double urunSatisFiyat;
    private Double urunSatisFiyat2;
    private Float urunSatisFiyat3;
    private Short urunAktif;
    private String sysEkleyen;
    private Integer sysEtarih;
    private String sysDuzelten;
    private Integer sysDtarih;
    private String urunBeden;
    private String urunRenk;
    private double urunStokSeviye;
    private String urunOzelkod;
    private String urunSerino;
    private String urunNot;
    private Date urunSonkullanma;
    private String urunDurum;
    private Double urunMinumumStok;
    private String urunPid;
    private UrunGrup grupRef;
    private UrunCesit urunCesit;
    private OlcuBirimleri birimRef;
    private Markalar markaRef;
    private KdvGrup urunKdvGrup;
     private Indirimler indirimler;
  
    public Urunler() {
    }

    public Urunler(Integer urunId) {
        this.urunId = urunId;
    }

    public Urunler(Integer urunId, String barkodId, double urunStokSeviye, String urunPid) {
        this.urunId = urunId;
        this.barkodId = barkodId;
        this.urunStokSeviye = urunStokSeviye;
        this.urunPid = urunPid;
    }

    public Integer getUrunId() {
        return urunId;
    }

    public void setUrunId(Integer urunId) {
        this.urunId = urunId;
    }

    public String getBarkodId() {
        return barkodId;
    }

    public void setBarkodId(String barkodId) {
        this.barkodId = barkodId;
    }

    public Short getBarkodTur() {
        return barkodTur;
    }

    public void setBarkodTur(Short barkodTur) {
        this.barkodTur = barkodTur;
    }

    public String getBarkodTip() {
        return barkodTip;
    }

    public void setBarkodTip(String barkodTip) {
        this.barkodTip = barkodTip;
    }

    public String getUrunAdi() {
        return urunAdi;
    }

    public void setUrunAdi(String urunAdi) {
        this.urunAdi = urunAdi;
    }

    public Double getUrunAlisFiyat() {
        return urunAlisFiyat;
    }

    public void setUrunAlisFiyat(Double urunAlisFiyat) {
        this.urunAlisFiyat = urunAlisFiyat;
    }

    public Double getUrunSatisFiyat() {
        return urunSatisFiyat;
    }

    public void setUrunSatisFiyat(Double urunSatisFiyat) {
        this.urunSatisFiyat = urunSatisFiyat;
    }

    public Double getUrunSatisFiyat2() {
        return urunSatisFiyat2;
    }

    public void setUrunSatisFiyat2(Double urunSatisFiyat2) {
        this.urunSatisFiyat2 = urunSatisFiyat2;
    }

    public Float getUrunSatisFiyat3() {
        return urunSatisFiyat3;
    }

    public void setUrunSatisFiyat3(Float urunSatisFiyat3) {
        this.urunSatisFiyat3 = urunSatisFiyat3;
    }

    public Short getUrunAktif() {
        return urunAktif;
    }

    public void setUrunAktif(Short urunAktif) {
        this.urunAktif = urunAktif;
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

    public String getUrunBeden() {
        return urunBeden;
    }

    public void setUrunBeden(String urunBeden) {
        this.urunBeden = urunBeden;
    }

    public String getUrunRenk() {
        return urunRenk;
    }

    public void setUrunRenk(String urunRenk) {
        this.urunRenk = urunRenk;
    }

    public double getUrunStokSeviye() {
        return urunStokSeviye;
    }

    public void setUrunStokSeviye(double urunStokSeviye) {
        this.urunStokSeviye = urunStokSeviye;
    }

    public String getUrunOzelkod() {
        return urunOzelkod;
    }

    public void setUrunOzelkod(String urunOzelkod) {
        this.urunOzelkod = urunOzelkod;
    }

    public String getUrunSerino() {
        return urunSerino;
    }

    public void setUrunSerino(String urunSerino) {
        this.urunSerino = urunSerino;
    }

    public String getUrunNot() {
        return urunNot;
    }

    public void setUrunNot(String urunNot) {
        this.urunNot = urunNot;
    }

    public Date getUrunSonkullanma() {
        return urunSonkullanma;
    }

    public void setUrunSonkullanma(Date urunSonkullanma) {
        this.urunSonkullanma = urunSonkullanma;
    }

    public String getUrunDurum() {
        return urunDurum;
    }

    public void setUrunDurum(String urunDurum) {
        this.urunDurum = urunDurum;
    }

    public Double getUrunMinumumStok() {
        return urunMinumumStok;
    }

    public void setUrunMinumumStok(Double urunMinumumStok) {
        this.urunMinumumStok = urunMinumumStok;
    }

    public String getUrunPid() {
        return urunPid;
    }

    public void setUrunPid(String urunPid) {
        this.urunPid = urunPid;
    }

    public UrunGrup getGrupRef() {
        return grupRef;
    }

    public void setGrupRef(UrunGrup grupRef) {
        this.grupRef = grupRef;
    }

    public UrunCesit getUrunCesit() {
        return urunCesit;
    }

    public void setUrunCesit(UrunCesit urunCesit) {
        this.urunCesit = urunCesit;
    }

    public OlcuBirimleri getBirimRef() {
        return birimRef;
    }

    public void setBirimRef(OlcuBirimleri birimRef) {
        this.birimRef = birimRef;
    }

    public Markalar getMarkaRef() {
        return markaRef;
    }

    public void setMarkaRef(Markalar markaRef) {
        this.markaRef = markaRef;
    }

    public KdvGrup getUrunKdvGrup() {
        return urunKdvGrup;
    }

    public void setUrunKdvGrup(KdvGrup urunKdvGrup) {
        this.urunKdvGrup = urunKdvGrup;
    }

    public Indirimler getIndirimler() {
        return indirimler;
    }

    public void setIndirimler(Indirimler indirimler) {
        this.indirimler = indirimler;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (urunId != null ? urunId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Urunler)) {
            return false;
        }
        Urunler other = (Urunler) object;
        if ((this.urunId == null && other.urunId != null) || (this.urunId != null && !this.urunId.equals(other.urunId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return urunAdi;
    }
    
}
