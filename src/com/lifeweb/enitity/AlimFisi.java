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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "alim_fisi", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlimFisi.findAll", query = "SELECT a FROM AlimFisi a"),
    @NamedQuery(name = "AlimFisi.findByAlimFisiId", query = "SELECT a FROM AlimFisi a WHERE a.alimFisiId = :alimFisiId"),
    @NamedQuery(name = "AlimFisi.findByFisTarihi", query = "SELECT a FROM AlimFisi a WHERE a.fisTarihi = :fisTarihi"),
    @NamedQuery(name = "AlimFisi.findByFisSaati", query = "SELECT a FROM AlimFisi a WHERE a.fisSaati = :fisSaati"),
    @NamedQuery(name = "AlimFisi.findByOzelKodu", query = "SELECT a FROM AlimFisi a WHERE a.ozelKodu = :ozelKodu"),
    @NamedQuery(name = "AlimFisi.findByBelgeNo", query = "SELECT a FROM AlimFisi a WHERE a.belgeNo = :belgeNo"),
    @NamedQuery(name = "AlimFisi.findByAciklama", query = "SELECT a FROM AlimFisi a WHERE a.aciklama = :aciklama"),
    @NamedQuery(name = "AlimFisi.findBySubeId", query = "SELECT a FROM AlimFisi a WHERE a.subeId = :subeId"),
    @NamedQuery(name = "AlimFisi.findByIskontoTutari", query = "SELECT a FROM AlimFisi a WHERE a.iskontoTutari = :iskontoTutari"),
    @NamedQuery(name = "AlimFisi.findByIskontoOrani", query = "SELECT a FROM AlimFisi a WHERE a.iskontoOrani = :iskontoOrani"),
    @NamedQuery(name = "AlimFisi.findByVadeTarihi", query = "SELECT a FROM AlimFisi a WHERE a.vadeTarihi = :vadeTarihi"),
    @NamedQuery(name = "AlimFisi.findByIndirimTutari", query = "SELECT a FROM AlimFisi a WHERE a.indirimTutari = :indirimTutari"),
    @NamedQuery(name = "AlimFisi.findByAraToplam", query = "SELECT a FROM AlimFisi a WHERE a.araToplam = :araToplam"),
    @NamedQuery(name = "AlimFisi.findByKdvToplam", query = "SELECT a FROM AlimFisi a WHERE a.kdvToplam = :kdvToplam"),
    @NamedQuery(name = "AlimFisi.findByGenelToplam", query = "SELECT a FROM AlimFisi a WHERE a.genelToplam = :genelToplam")})
public class AlimFisi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ALIM_FISI_ID", nullable = false)
    private Integer alimFisiId;
    @Basic(optional = false)
    @Column(name = "FIS_TARIHI", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fisTarihi;
    @Basic(optional = false)
    @Column(name = "FIS_SAATI", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date fisSaati;
    @Basic(optional = false)
    @Column(name = "OZEL_KODU", nullable = false, length = 45)
    private String ozelKodu;
    @Basic(optional = false)
    @Column(name = "BELGE_NO", nullable = false, length = 45)
    private String belgeNo;
    @Basic(optional = false)
    @Column(nullable = false, length = 145)
    private String aciklama;
    @Basic(optional = false)
    @Column(name = "SUBE_ID", nullable = false)
    private int subeId;
    @Basic(optional = false)
    @Column(name = "ISKONTO_TUTARI", nullable = false)
    private double iskontoTutari;
    @Basic(optional = false)
    @Column(name = "ISKONTO_ORANI", nullable = false)
    private double iskontoOrani;
    @Basic(optional = false)
    @Column(name = "VADE_TARIHI", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date vadeTarihi;
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
    @JoinColumn(name = "HESAP_ID", referencedColumnName = "MUSTERI_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CariHesaplar hesapId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alimFisiId", fetch = FetchType.EAGER)
    private List<AlimFisiLine> alimFisiLineList;

    public AlimFisi() {
    }

    public AlimFisi(Integer alimFisiId) {
        this.alimFisiId = alimFisiId;
    }

    public AlimFisi(Integer alimFisiId, Date fisTarihi, Date fisSaati, String ozelKodu, String belgeNo, String aciklama, int subeId, double iskontoTutari, double iskontoOrani, Date vadeTarihi, double indirimTutari, double araToplam, double kdvToplam, double genelToplam) {
        this.alimFisiId = alimFisiId;
        this.fisTarihi = fisTarihi;
        this.fisSaati = fisSaati;
        this.ozelKodu = ozelKodu;
        this.belgeNo = belgeNo;
        this.aciklama = aciklama;
        this.subeId = subeId;
        this.iskontoTutari = iskontoTutari;
        this.iskontoOrani = iskontoOrani;
        this.vadeTarihi = vadeTarihi;
        this.indirimTutari = indirimTutari;
        this.araToplam = araToplam;
        this.kdvToplam = kdvToplam;
        this.genelToplam = genelToplam;
    }

    public Integer getAlimFisiId() {
        return alimFisiId;
    }

    public void setAlimFisiId(Integer alimFisiId) {
        this.alimFisiId = alimFisiId;
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

    public int getSubeId() {
        return subeId;
    }

    public void setSubeId(int subeId) {
        this.subeId = subeId;
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

    public Date getVadeTarihi() {
        return vadeTarihi;
    }

    public void setVadeTarihi(Date vadeTarihi) {
        this.vadeTarihi = vadeTarihi;
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

    public CariHesaplar getHesapId() {
        return hesapId;
    }

    public void setHesapId(CariHesaplar hesapId) {
        this.hesapId = hesapId;
    }

    @XmlTransient
    @JsonIgnore
    public List<AlimFisiLine> getAlimFisiLineList() {
        return alimFisiLineList;
    }

    public void setAlimFisiLineList(List<AlimFisiLine> alimFisiLineList) {
        this.alimFisiLineList = alimFisiLineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alimFisiId != null ? alimFisiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlimFisi)) {
            return false;
        }
        AlimFisi other = (AlimFisi) object;
        if ((this.alimFisiId == null && other.alimFisiId != null) || (this.alimFisiId != null && !this.alimFisiId.equals(other.alimFisiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.AlimFisi[ alimFisiId=" + alimFisiId + " ]";
    }
    
}
