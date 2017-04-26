/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.enitity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "satis_fisi", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SatisFisi.findAll", query = "SELECT s FROM SatisFisi s"),
    @NamedQuery(name = "SatisFisi.findBySatisFisiId", query = "SELECT s FROM SatisFisi s WHERE s.satisFisiId = :satisFisiId"),
    @NamedQuery(name = "SatisFisi.findByFisTarihi", query = "SELECT s FROM SatisFisi s WHERE s.fisTarihi = :fisTarihi"),
    @NamedQuery(name = "SatisFisi.findByFisSaati", query = "SELECT s FROM SatisFisi s WHERE s.fisSaati = :fisSaati"),
    @NamedQuery(name = "SatisFisi.findByOzelKodu", query = "SELECT s FROM SatisFisi s WHERE s.ozelKodu = :ozelKodu"),
    @NamedQuery(name = "SatisFisi.findByBelgeNo", query = "SELECT s FROM SatisFisi s WHERE s.belgeNo = :belgeNo"),
    @NamedQuery(name = "SatisFisi.findByAciklama", query = "SELECT s FROM SatisFisi s WHERE s.aciklama = :aciklama"),
    @NamedQuery(name = "SatisFisi.findByIskontoTutari", query = "SELECT s FROM SatisFisi s WHERE s.iskontoTutari = :iskontoTutari"),
    @NamedQuery(name = "SatisFisi.findByIskontoOrani", query = "SELECT s FROM SatisFisi s WHERE s.iskontoOrani = :iskontoOrani"),
    @NamedQuery(name = "SatisFisi.findByIndirimTutari", query = "SELECT s FROM SatisFisi s WHERE s.indirimTutari = :indirimTutari"),
    @NamedQuery(name = "SatisFisi.findByAraToplam", query = "SELECT s FROM SatisFisi s WHERE s.araToplam = :araToplam"),
    @NamedQuery(name = "SatisFisi.findByKdvToplam", query = "SELECT s FROM SatisFisi s WHERE s.kdvToplam = :kdvToplam"),
    @NamedQuery(name = "SatisFisi.findByGenelToplam", query = "SELECT s FROM SatisFisi s WHERE s.genelToplam = :genelToplam")})
public class SatisFisi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SATIS_FISI_ID", nullable = false)
    private Integer satisFisiId;
    @Basic(optional = false)
    @Column(name = "FIS_TARIHI", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fisTarihi;
    @Basic(optional = false)
    @Column(name = "FIS_SAATI", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fisSaati;
    @Column(name = "OZEL_KODU", length = 45)
    private String ozelKodu;
    @Column(name = "BELGE_NO", length = 45)
    private String belgeNo;
    @Column(length = 145)
    private String aciklama;
    @Basic(optional = false)
    @Column(name = "ISKONTO_TUTARI", nullable = false)
    private double iskontoTutari;
    @Basic(optional = false)
    @Column(name = "ISKONTO_ORANI", nullable = false)
    private double iskontoOrani;
    @Basic(optional = false)
    @Column(name = "INDIRIM_TUTARI", nullable = false)
    private double indirimTutari;
    @Basic(optional = false)
    @Column(name = "ARA_TOPLAM", nullable = false)
    private double araToplam;
    @Basic(optional = false)
    @Column(name = "KDV_TOPLAM", nullable = false)
    private double kdvToplam;
    @Basic(optional = false)
    @Column(name = "GENEL_TOPLAM", nullable = false)
    private double genelToplam;
    @JoinColumn(name = "SUBE_ID", referencedColumnName = "SUBE_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Subeler subeId;
    @JoinColumn(name = "HESAP_ID", referencedColumnName = "MUSTERI_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private CariHesaplar hesapId;
    @JoinColumn(name = "SYS_EKLEYEN", referencedColumnName = "KULLANICI_ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Kullanici sysEkleyen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "satisFisiId", fetch = FetchType.EAGER)
    private List<OdemeTurleriLine> odemeTurleriLineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "satisFisiId", fetch = FetchType.EAGER)
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

    @XmlTransient
    @JsonIgnore
    public List<OdemeTurleriLine> getOdemeTurleriLineList() {
        return odemeTurleriLineList;
    }

    public void setOdemeTurleriLineList(List<OdemeTurleriLine> odemeTurleriLineList) {
        this.odemeTurleriLineList = odemeTurleriLineList;
    }

    @XmlTransient
    @JsonIgnore
    public List<SatisFisiLine> getSatisFisiLineList() {
        return satisFisiLineList;
    }

    public void setSatisFisiLineList(List<SatisFisiLine> satisFisiLineList) {
        this.satisFisiLineList = satisFisiLineList;
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
