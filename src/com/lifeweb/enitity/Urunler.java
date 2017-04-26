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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Life
 */
@Entity
@Table(catalog = "lifev1", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"BARKOD_ID"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Urunler.findAll", query = "SELECT u FROM Urunler u"),
    @NamedQuery(name = "Urunler.findByUrunId", query = "SELECT u FROM Urunler u WHERE u.urunId = :urunId"),
    @NamedQuery(name = "Urunler.findByBarkodId", query = "SELECT u FROM Urunler u WHERE u.barkodId = :barkodId"),
    @NamedQuery(name = "Urunler.findByBarkodTur", query = "SELECT u FROM Urunler u WHERE u.barkodTur = :barkodTur"),
    @NamedQuery(name = "Urunler.findByBarkodTip", query = "SELECT u FROM Urunler u WHERE u.barkodTip = :barkodTip"),
    @NamedQuery(name = "Urunler.findByUrunAdi", query = "SELECT u FROM Urunler u WHERE u.urunAdi = :urunAdi"),
    @NamedQuery(name = "Urunler.findByUrunAlisFiyat", query = "SELECT u FROM Urunler u WHERE u.urunAlisFiyat = :urunAlisFiyat"),
    @NamedQuery(name = "Urunler.findByUrunSatisFiyat", query = "SELECT u FROM Urunler u WHERE u.urunSatisFiyat = :urunSatisFiyat"),
    @NamedQuery(name = "Urunler.findByUrunSatisFiyat2", query = "SELECT u FROM Urunler u WHERE u.urunSatisFiyat2 = :urunSatisFiyat2"),
    @NamedQuery(name = "Urunler.findByUrunSatisFiyat3", query = "SELECT u FROM Urunler u WHERE u.urunSatisFiyat3 = :urunSatisFiyat3"),
    @NamedQuery(name = "Urunler.findByUrunAktif", query = "SELECT u FROM Urunler u WHERE u.urunAktif = :urunAktif"),
    @NamedQuery(name = "Urunler.findBySysEkleyen", query = "SELECT u FROM Urunler u WHERE u.sysEkleyen = :sysEkleyen"),
    @NamedQuery(name = "Urunler.findBySysEtarih", query = "SELECT u FROM Urunler u WHERE u.sysEtarih = :sysEtarih"),
    @NamedQuery(name = "Urunler.findBySysDuzelten", query = "SELECT u FROM Urunler u WHERE u.sysDuzelten = :sysDuzelten"),
    @NamedQuery(name = "Urunler.findBySysDtarih", query = "SELECT u FROM Urunler u WHERE u.sysDtarih = :sysDtarih"),
    @NamedQuery(name = "Urunler.findByUrunBeden", query = "SELECT u FROM Urunler u WHERE u.urunBeden = :urunBeden"),
    @NamedQuery(name = "Urunler.findByUrunRenk", query = "SELECT u FROM Urunler u WHERE u.urunRenk = :urunRenk"),
    @NamedQuery(name = "Urunler.findByUrunStokSeviye", query = "SELECT u FROM Urunler u WHERE u.urunStokSeviye = :urunStokSeviye"),
    @NamedQuery(name = "Urunler.findByUrunOzelkod", query = "SELECT u FROM Urunler u WHERE u.urunOzelkod = :urunOzelkod"),
    @NamedQuery(name = "Urunler.findByUrunSerino", query = "SELECT u FROM Urunler u WHERE u.urunSerino = :urunSerino"),
    @NamedQuery(name = "Urunler.findByUrunNot", query = "SELECT u FROM Urunler u WHERE u.urunNot = :urunNot"),
    @NamedQuery(name = "Urunler.findByUrunSonkullanma", query = "SELECT u FROM Urunler u WHERE u.urunSonkullanma = :urunSonkullanma"),
    @NamedQuery(name = "Urunler.findByUrunDurum", query = "SELECT u FROM Urunler u WHERE u.urunDurum = :urunDurum"),
    @NamedQuery(name = "Urunler.findByUrunMinumumStok", query = "SELECT u FROM Urunler u WHERE u.urunMinumumStok = :urunMinumumStok"),
    @NamedQuery(name = "Urunler.findByUrunPid", query = "SELECT u FROM Urunler u WHERE u.urunPid = :urunPid")})
public class Urunler implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "URUN_ID", nullable = false)
    private Integer urunId;
    @Basic(optional = false)
    @Column(name = "BARKOD_ID", nullable = false, length = 32)
    private String barkodId;
    @Column(name = "BARKOD_TUR")
    private Short barkodTur;
    @Column(name = "BARKOD_TIP", length = 10)
    private String barkodTip;
    @Column(name = "URUN_ADI", length = 100)
    private String urunAdi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "URUN_ALIS_FIYAT", precision = 12, scale = 5)
    private Double urunAlisFiyat;
    @Column(name = "URUN_SATIS_FIYAT", precision = 8, scale = 2)
    private Double urunSatisFiyat;
    @Column(name = "URUN_SATIS_FIYAT2", precision = 8, scale = 2)
    private Double urunSatisFiyat2;
    @Column(name = "URUN_SATIS_FIYAT3", precision = 8, scale = 2)
    private Float urunSatisFiyat3;
    @Column(name = "URUN_AKTIF")
    private Short urunAktif;
    @Column(name = "SYS_EKLEYEN", length = 15)
    private String sysEkleyen;
    @Column(name = "SYS_ETARIH")
    private Integer sysEtarih;
    @Column(name = "SYS_DUZELTEN", length = 15)
    private String sysDuzelten;
    @Column(name = "SYS_DTARIH")
    private Integer sysDtarih;
    @Column(name = "URUN_BEDEN", length = 30)
    private String urunBeden;
    @Column(name = "URUN_RENK", length = 30)
    private String urunRenk;
    @Basic(optional = false)
    @Column(name = "URUN_STOK_SEVIYE", nullable = false)
    private double urunStokSeviye;
    @Column(name = "URUN_OZELKOD", length = 20)
    private String urunOzelkod;
    @Column(name = "URUN_SERINO", length = 20)
    private String urunSerino;
    @Column(name = "URUN_NOT", length = 50)
    private String urunNot;
    @Column(name = "URUN_SONKULLANMA")
    @Temporal(TemporalType.DATE)
    private Date urunSonkullanma;
    @Column(name = "URUN_DURUM", length = 5)
    private String urunDurum;
    @Column(name = "URUN_MINUMUM_STOK", precision = 15, scale = 3)
    private Double urunMinumumStok;
    @Basic(optional = false)
    @Column(name = "URUN_PID", nullable = false, length = 45)
    private String urunPid;
    @JoinColumn(name = "GRUP_REF", referencedColumnName = "URUN_GRUP_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private UrunGrup grupRef;
    @JoinColumn(name = "URUN_CESIT", referencedColumnName = "CESIT_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private UrunCesit urunCesit;
    @JoinColumn(name = "BIRIM_REF", referencedColumnName = "BIRIM_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private OlcuBirimleri birimRef;
    @JoinColumn(name = "MARKA_REF", referencedColumnName = "MARKA_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private Markalar markaRef;
    @JoinColumn(name = "URUN_KDV_GRUP", referencedColumnName = "KDV_GRUP_NO")
    @ManyToOne(fetch = FetchType.EAGER)
    private KdvGrup urunKdvGrup;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "barkodRef", fetch = FetchType.EAGER)
    private List<HizlisatTuslar> hizlisatTuslarList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urunRef", fetch = FetchType.EAGER)
    private List<UrunlerFoto> urunlerFotoList;
    @OneToMany(mappedBy = "urunId", fetch = FetchType.EAGER)
    private List<AlimFisiLine> alimFisiLineList;
    @OneToOne(mappedBy = "urunRef", fetch = FetchType.EAGER)
    private Indirimler indirimler;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urunRef", fetch = FetchType.EAGER)
    private List<CariFisler> cariFislerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urunId", fetch = FetchType.EAGER)
    private List<SatisFisiLine> satisFisiLineList;

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

    @XmlTransient
    @JsonIgnore
    public List<HizlisatTuslar> getHizlisatTuslarList() {
        return hizlisatTuslarList;
    }

    public void setHizlisatTuslarList(List<HizlisatTuslar> hizlisatTuslarList) {
        this.hizlisatTuslarList = hizlisatTuslarList;
    }

    @XmlTransient
    @JsonIgnore
    public List<UrunlerFoto> getUrunlerFotoList() {
        return urunlerFotoList;
    }

    public void setUrunlerFotoList(List<UrunlerFoto> urunlerFotoList) {
        this.urunlerFotoList = urunlerFotoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<AlimFisiLine> getAlimFisiLineList() {
        return alimFisiLineList;
    }

    public void setAlimFisiLineList(List<AlimFisiLine> alimFisiLineList) {
        this.alimFisiLineList = alimFisiLineList;
    }

    public Indirimler getIndirimler() {
        return indirimler;
    }

    public void setIndirimler(Indirimler indirimler) {
        this.indirimler = indirimler;
    }

    @XmlTransient
    @JsonIgnore
    public List<CariFisler> getCariFislerList() {
        return cariFislerList;
    }

    public void setCariFislerList(List<CariFisler> cariFislerList) {
        this.cariFislerList = cariFislerList;
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
