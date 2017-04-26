/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Life
 */
@Entity
@Table(name = "cari_fisler", catalog = "lifev1", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CariFisler.findAll", query = "SELECT c FROM CariFisler c"),
    @NamedQuery(name = "CariFisler.findByFisId", query = "SELECT c FROM CariFisler c WHERE c.fisId = :fisId"),
    @NamedQuery(name = "CariFisler.findByFisLevel", query = "SELECT c FROM CariFisler c WHERE c.fisLevel = :fisLevel"),
    @NamedQuery(name = "CariFisler.findByParentFis", query = "SELECT c FROM CariFisler c WHERE c.parentFis = :parentFis"),
    @NamedQuery(name = "CariFisler.findByFisTarih", query = "SELECT c FROM CariFisler c WHERE c.fisTarih = :fisTarih"),
    @NamedQuery(name = "CariFisler.findByFisSaat", query = "SELECT c FROM CariFisler c WHERE c.fisSaat = :fisSaat"),
    @NamedQuery(name = "CariFisler.findByFisOdemeTarih", query = "SELECT c FROM CariFisler c WHERE c.fisOdemeTarih = :fisOdemeTarih"),
    @NamedQuery(name = "CariFisler.findByFisToplam", query = "SELECT c FROM CariFisler c WHERE c.fisToplam = :fisToplam"),
    @NamedQuery(name = "CariFisler.findByFisKdv", query = "SELECT c FROM CariFisler c WHERE c.fisKdv = :fisKdv"),
    @NamedQuery(name = "CariFisler.findByFisIndirim", query = "SELECT c FROM CariFisler c WHERE c.fisIndirim = :fisIndirim"),
    @NamedQuery(name = "CariFisler.findByFisIskontoOran", query = "SELECT c FROM CariFisler c WHERE c.fisIskontoOran = :fisIskontoOran"),
    @NamedQuery(name = "CariFisler.findByFisIskontoTutar", query = "SELECT c FROM CariFisler c WHERE c.fisIskontoTutar = :fisIskontoTutar"),
    @NamedQuery(name = "CariFisler.findByFisGtoplam", query = "SELECT c FROM CariFisler c WHERE c.fisGtoplam = :fisGtoplam"),
    @NamedQuery(name = "CariFisler.findByFisTuru", query = "SELECT c FROM CariFisler c WHERE c.fisTuru = :fisTuru"),
    @NamedQuery(name = "CariFisler.findByFisFaturano", query = "SELECT c FROM CariFisler c WHERE c.fisFaturano = :fisFaturano"),
    @NamedQuery(name = "CariFisler.findByFisAciklama", query = "SELECT c FROM CariFisler c WHERE c.fisAciklama = :fisAciklama"),
    @NamedQuery(name = "CariFisler.findByFisOzelkod", query = "SELECT c FROM CariFisler c WHERE c.fisOzelkod = :fisOzelkod"),
    @NamedQuery(name = "CariFisler.findByLineBarkod", query = "SELECT c FROM CariFisler c WHERE c.lineBarkod = :lineBarkod"),
    @NamedQuery(name = "CariFisler.findByLineKdvOran", query = "SELECT c FROM CariFisler c WHERE c.lineKdvOran = :lineKdvOran"),
    @NamedQuery(name = "CariFisler.findByLineKdv", query = "SELECT c FROM CariFisler c WHERE c.lineKdv = :lineKdv"),
    @NamedQuery(name = "CariFisler.findByLineIskonto", query = "SELECT c FROM CariFisler c WHERE c.lineIskonto = :lineIskonto"),
    @NamedQuery(name = "CariFisler.findByLineIskontoTutar", query = "SELECT c FROM CariFisler c WHERE c.lineIskontoTutar = :lineIskontoTutar"),
    @NamedQuery(name = "CariFisler.findByLineMiktar", query = "SELECT c FROM CariFisler c WHERE c.lineMiktar = :lineMiktar"),
    @NamedQuery(name = "CariFisler.findByLineBirimfiyat", query = "SELECT c FROM CariFisler c WHERE c.lineBirimfiyat = :lineBirimfiyat"),
    @NamedQuery(name = "CariFisler.findByLineMatrah", query = "SELECT c FROM CariFisler c WHERE c.lineMatrah = :lineMatrah"),
    @NamedQuery(name = "CariFisler.findByLineIndirim", query = "SELECT c FROM CariFisler c WHERE c.lineIndirim = :lineIndirim"),
    @NamedQuery(name = "CariFisler.findByLineTutar", query = "SELECT c FROM CariFisler c WHERE c.lineTutar = :lineTutar"),
    @NamedQuery(name = "CariFisler.findByLineIndMinMiktar", query = "SELECT c FROM CariFisler c WHERE c.lineIndMinMiktar = :lineIndMinMiktar"),
    @NamedQuery(name = "CariFisler.findByLineAlisfiyat", query = "SELECT c FROM CariFisler c WHERE c.lineAlisfiyat = :lineAlisfiyat"),
    @NamedQuery(name = "CariFisler.findByLineAciklama", query = "SELECT c FROM CariFisler c WHERE c.lineAciklama = :lineAciklama"),
    @NamedQuery(name = "CariFisler.findByLineKatsayi", query = "SELECT c FROM CariFisler c WHERE c.lineKatsayi = :lineKatsayi"),
    @NamedQuery(name = "CariFisler.findByIsaret", query = "SELECT c FROM CariFisler c WHERE c.isaret = :isaret"),
    @NamedQuery(name = "CariFisler.findBySysEkleyen", query = "SELECT c FROM CariFisler c WHERE c.sysEkleyen = :sysEkleyen"),
    @NamedQuery(name = "CariFisler.findBySysEtarih", query = "SELECT c FROM CariFisler c WHERE c.sysEtarih = :sysEtarih"),
    @NamedQuery(name = "CariFisler.findBySysDuzelten", query = "SELECT c FROM CariFisler c WHERE c.sysDuzelten = :sysDuzelten"),
    @NamedQuery(name = "CariFisler.findBySysDtarih", query = "SELECT c FROM CariFisler c WHERE c.sysDtarih = :sysDtarih"),
    @NamedQuery(name = "CariFisler.findByCekVade", query = "SELECT c FROM CariFisler c WHERE c.cekVade = :cekVade"),
    @NamedQuery(name = "CariFisler.findByCekOdemeYeri", query = "SELECT c FROM CariFisler c WHERE c.cekOdemeYeri = :cekOdemeYeri"),
    @NamedQuery(name = "CariFisler.findByCekSeriNo", query = "SELECT c FROM CariFisler c WHERE c.cekSeriNo = :cekSeriNo"),
    @NamedQuery(name = "CariFisler.findByCekDurum", query = "SELECT c FROM CariFisler c WHERE c.cekDurum = :cekDurum"),
    @NamedQuery(name = "CariFisler.findByFatMusteriAdi", query = "SELECT c FROM CariFisler c WHERE c.fatMusteriAdi = :fatMusteriAdi"),
    @NamedQuery(name = "CariFisler.findByFatAdres1", query = "SELECT c FROM CariFisler c WHERE c.fatAdres1 = :fatAdres1"),
    @NamedQuery(name = "CariFisler.findByFatAdres2", query = "SELECT c FROM CariFisler c WHERE c.fatAdres2 = :fatAdres2"),
    @NamedQuery(name = "CariFisler.findByFatSemt", query = "SELECT c FROM CariFisler c WHERE c.fatSemt = :fatSemt"),
    @NamedQuery(name = "CariFisler.findByFatSehir", query = "SELECT c FROM CariFisler c WHERE c.fatSehir = :fatSehir"),
    @NamedQuery(name = "CariFisler.findByFatVdaire", query = "SELECT c FROM CariFisler c WHERE c.fatVdaire = :fatVdaire"),
    @NamedQuery(name = "CariFisler.findByFatGsm", query = "SELECT c FROM CariFisler c WHERE c.fatGsm = :fatGsm")})
public class CariFislerDao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FIS_ID", nullable = false)
    private Integer fisId;
    @Basic(optional = false)
    @Column(name = "FIS_LEVEL", nullable = false)
    private int fisLevel;
    @Basic(optional = false)
    @Column(name = "PARENT_FIS", nullable = false)
    private int parentFis;
    @Basic(optional = false)
    @Column(name = "FIS_TARIH", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fisTarih;
    @Column(name = "FIS_SAAT")
    @Temporal(TemporalType.TIME)
    private Date fisSaat;
    @Column(name = "FIS_ODEME_TARIH")
    @Temporal(TemporalType.DATE)
    private Date fisOdemeTarih;
    @Basic(optional = false)
    @Column(name = "FIS_TOPLAM", nullable = false)
    private double fisToplam;
    @Basic(optional = false)
    @Column(name = "FIS_KDV", nullable = false)
    private double fisKdv;
    @Basic(optional = false)
    @Column(name = "FIS_INDIRIM", nullable = false)
    private double fisIndirim;
    @Basic(optional = false)
    @Column(name = "FIS_ISKONTO_ORAN", nullable = false)
    private double fisIskontoOran;
    @Basic(optional = false)
    @Column(name = "FIS_ISKONTO_TUTAR", nullable = false)
    private double fisIskontoTutar;
    @Basic(optional = false)
    @Column(name = "FIS_GTOPLAM", nullable = false)
    private double fisGtoplam;
    @Basic(optional = false)
    @Column(name = "FIS_TURU", nullable = false)
    private short fisTuru;
    @Column(name = "FIS_FATURANO", length = 20)
    private String fisFaturano;
    @Column(name = "FIS_ACIKLAMA", length = 80)
    private String fisAciklama;
    @Column(name = "FIS_OZELKOD", length = 20)
    private String fisOzelkod;
    @Column(name = "LINE_BARKOD", length = 15)
    private String lineBarkod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LINE_KDV_ORAN", precision = 15, scale = 2)
    private Double lineKdvOran;
    @Column(name = "LINE_KDV", precision = 15, scale = 2)
    private Double lineKdv;
    @Column(name = "LINE_ISKONTO", precision = 15, scale = 2)
    private Double lineIskonto;
    @Column(name = "LINE_ISKONTO_TUTAR", precision = 15, scale = 2)
    private Double lineIskontoTutar;
    @Column(name = "LINE_MIKTAR", precision = 15, scale = 3)
    private Double lineMiktar;
    @Column(name = "LINE_BIRIMFIYAT", precision = 12, scale = 5)
    private Double lineBirimfiyat;
    @Column(name = "LINE_MATRAH", precision = 15, scale = 2)
    private Double lineMatrah;
    @Column(name = "LINE_INDIRIM", precision = 15, scale = 2)
    private Double lineIndirim;
    @Column(name = "LINE_TUTAR", precision = 15, scale = 2)
    private Double lineTutar;
    @Column(name = "LINE_IND_MIN_MIKTAR")
    private Integer lineIndMinMiktar;
    @Column(name = "LINE_ALISFIYAT", precision = 12, scale = 5)
    private Double lineAlisfiyat;
    @Column(name = "LINE_ACIKLAMA", length = 100)
    private String lineAciklama;
    @Column(name = "LINE_KATSAYI")
    private Integer lineKatsayi;
    @Basic(optional = false)
    @Column(nullable = false)
    private short isaret;
    @Basic(optional = false)
    @Column(name = "SYS_EKLEYEN", nullable = false, length = 15)
    private String sysEkleyen;
    @Basic(optional = false)
    @Column(name = "SYS_ETARIH", nullable = false)
    private int sysEtarih;
    @Column(name = "SYS_DUZELTEN", length = 15)
    private String sysDuzelten;
    @Column(name = "SYS_DTARIH")
    private Integer sysDtarih;
    @Column(name = "CEK_VADE")
    @Temporal(TemporalType.DATE)
    private Date cekVade;
    @Column(name = "CEK_ODEME_YERI", length = 50)
    private String cekOdemeYeri;
    @Column(name = "CEK_SERI_NO", length = 20)
    private String cekSeriNo;
    @Column(name = "CEK_DURUM", length = 10)
    private String cekDurum;
    @Column(name = "FAT_MUSTERI_ADI", length = 80)
    private String fatMusteriAdi;
    @Column(name = "FAT_ADRES1", length = 80)
    private String fatAdres1;
    @Column(name = "FAT_ADRES2", length = 80)
    private String fatAdres2;
    @Column(name = "FAT_SEMT", length = 30)
    private String fatSemt;
    @Column(name = "FAT_SEHIR", length = 30)
    private String fatSehir;
    @Column(name = "FAT_VDAIRE", length = 25)
    private String fatVdaire;
    @Lob
    @Column(name = "FAT_VNO")
    private byte[] fatVno;
    @Column(name = "FAT_GSM", length = 30)
    private String fatGsm;
    @Lob
    @Column(name = "LINE_SERI_NOLAR")
    private byte[] lineSeriNolar;
    @JoinColumn(name = "LINE_ODEME_REF", referencedColumnName = "ODEME_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OdemeTurleriDao lineOdemeRef;
    @JoinColumn(name = "URUN_REF", referencedColumnName = "URUN_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UrunlerDao urunRef;
    @JoinColumn(name = "SUBE_REF", referencedColumnName = "SUBE_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SubelerDao subeRef;
    @JoinColumn(name = "MUSTERI_REF", referencedColumnName = "MUSTERI_ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CariHesaplarDao musteriRef;
    @JoinColumn(name = "MASRAF_YERI", referencedColumnName = "MASRAF_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private MasraflarDao masrafYeri;
    @JoinColumn(name = "LINE_BIRIM", referencedColumnName = "BIRIM_ADI")
    @ManyToOne(fetch = FetchType.EAGER)
    private OlcuBirimleriDao lineBirim;

    public CariFislerDao() {
    }

    public CariFislerDao(Integer fisId) {
        this.fisId = fisId;
    }

    public CariFislerDao(Integer fisId, int fisLevel, int parentFis, Date fisTarih, double fisToplam, double fisKdv, double fisIndirim, double fisIskontoOran, double fisIskontoTutar, double fisGtoplam, short fisTuru, short isaret, String sysEkleyen, int sysEtarih) {
        this.fisId = fisId;
        this.fisLevel = fisLevel;
        this.parentFis = parentFis;
        this.fisTarih = fisTarih;
        this.fisToplam = fisToplam;
        this.fisKdv = fisKdv;
        this.fisIndirim = fisIndirim;
        this.fisIskontoOran = fisIskontoOran;
        this.fisIskontoTutar = fisIskontoTutar;
        this.fisGtoplam = fisGtoplam;
        this.fisTuru = fisTuru;
        this.isaret = isaret;
        this.sysEkleyen = sysEkleyen;
        this.sysEtarih = sysEtarih;
    }

    public Integer getFisId() {
        return fisId;
    }

    public void setFisId(Integer fisId) {
        this.fisId = fisId;
    }

    public int getFisLevel() {
        return fisLevel;
    }

    public void setFisLevel(int fisLevel) {
        this.fisLevel = fisLevel;
    }

    public int getParentFis() {
        return parentFis;
    }

    public void setParentFis(int parentFis) {
        this.parentFis = parentFis;
    }

    public Date getFisTarih() {
        return fisTarih;
    }

    public void setFisTarih(Date fisTarih) {
        this.fisTarih = fisTarih;
    }

    public Date getFisSaat() {
        return fisSaat;
    }

    public void setFisSaat(Date fisSaat) {
        this.fisSaat = fisSaat;
    }

    public Date getFisOdemeTarih() {
        return fisOdemeTarih;
    }

    public void setFisOdemeTarih(Date fisOdemeTarih) {
        this.fisOdemeTarih = fisOdemeTarih;
    }

    public double getFisToplam() {
        return fisToplam;
    }

    public void setFisToplam(double fisToplam) {
        this.fisToplam = fisToplam;
    }

    public double getFisKdv() {
        return fisKdv;
    }

    public void setFisKdv(double fisKdv) {
        this.fisKdv = fisKdv;
    }

    public double getFisIndirim() {
        return fisIndirim;
    }

    public void setFisIndirim(double fisIndirim) {
        this.fisIndirim = fisIndirim;
    }

    public double getFisIskontoOran() {
        return fisIskontoOran;
    }

    public void setFisIskontoOran(double fisIskontoOran) {
        this.fisIskontoOran = fisIskontoOran;
    }

    public double getFisIskontoTutar() {
        return fisIskontoTutar;
    }

    public void setFisIskontoTutar(double fisIskontoTutar) {
        this.fisIskontoTutar = fisIskontoTutar;
    }

    public double getFisGtoplam() {
        return fisGtoplam;
    }

    public void setFisGtoplam(double fisGtoplam) {
        this.fisGtoplam = fisGtoplam;
    }

    public short getFisTuru() {
        return fisTuru;
    }

    public void setFisTuru(short fisTuru) {
        this.fisTuru = fisTuru;
    }

    public String getFisFaturano() {
        return fisFaturano;
    }

    public void setFisFaturano(String fisFaturano) {
        this.fisFaturano = fisFaturano;
    }

    public String getFisAciklama() {
        return fisAciklama;
    }

    public void setFisAciklama(String fisAciklama) {
        this.fisAciklama = fisAciklama;
    }

    public String getFisOzelkod() {
        return fisOzelkod;
    }

    public void setFisOzelkod(String fisOzelkod) {
        this.fisOzelkod = fisOzelkod;
    }

    public String getLineBarkod() {
        return lineBarkod;
    }

    public void setLineBarkod(String lineBarkod) {
        this.lineBarkod = lineBarkod;
    }

    public Double getLineKdvOran() {
        return lineKdvOran;
    }

    public void setLineKdvOran(Double lineKdvOran) {
        this.lineKdvOran = lineKdvOran;
    }

    public Double getLineKdv() {
        return lineKdv;
    }

    public void setLineKdv(Double lineKdv) {
        this.lineKdv = lineKdv;
    }

    public Double getLineIskonto() {
        return lineIskonto;
    }

    public void setLineIskonto(Double lineIskonto) {
        this.lineIskonto = lineIskonto;
    }

    public Double getLineIskontoTutar() {
        return lineIskontoTutar;
    }

    public void setLineIskontoTutar(Double lineIskontoTutar) {
        this.lineIskontoTutar = lineIskontoTutar;
    }

    public Double getLineMiktar() {
        return lineMiktar;
    }

    public void setLineMiktar(Double lineMiktar) {
        this.lineMiktar = lineMiktar;
    }

    public Double getLineBirimfiyat() {
        return lineBirimfiyat;
    }

    public void setLineBirimfiyat(Double lineBirimfiyat) {
        this.lineBirimfiyat = lineBirimfiyat;
    }

    public Double getLineMatrah() {
        return lineMatrah;
    }

    public void setLineMatrah(Double lineMatrah) {
        this.lineMatrah = lineMatrah;
    }

    public Double getLineIndirim() {
        return lineIndirim;
    }

    public void setLineIndirim(Double lineIndirim) {
        this.lineIndirim = lineIndirim;
    }

    public Double getLineTutar() {
        return lineTutar;
    }

    public void setLineTutar(Double lineTutar) {
        this.lineTutar = lineTutar;
    }

    public Integer getLineIndMinMiktar() {
        return lineIndMinMiktar;
    }

    public void setLineIndMinMiktar(Integer lineIndMinMiktar) {
        this.lineIndMinMiktar = lineIndMinMiktar;
    }

    public Double getLineAlisfiyat() {
        return lineAlisfiyat;
    }

    public void setLineAlisfiyat(Double lineAlisfiyat) {
        this.lineAlisfiyat = lineAlisfiyat;
    }

    public String getLineAciklama() {
        return lineAciklama;
    }

    public void setLineAciklama(String lineAciklama) {
        this.lineAciklama = lineAciklama;
    }

    public Integer getLineKatsayi() {
        return lineKatsayi;
    }

    public void setLineKatsayi(Integer lineKatsayi) {
        this.lineKatsayi = lineKatsayi;
    }

    public short getIsaret() {
        return isaret;
    }

    public void setIsaret(short isaret) {
        this.isaret = isaret;
    }

    public String getSysEkleyen() {
        return sysEkleyen;
    }

    public void setSysEkleyen(String sysEkleyen) {
        this.sysEkleyen = sysEkleyen;
    }

    public int getSysEtarih() {
        return sysEtarih;
    }

    public void setSysEtarih(int sysEtarih) {
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

    public Date getCekVade() {
        return cekVade;
    }

    public void setCekVade(Date cekVade) {
        this.cekVade = cekVade;
    }

    public String getCekOdemeYeri() {
        return cekOdemeYeri;
    }

    public void setCekOdemeYeri(String cekOdemeYeri) {
        this.cekOdemeYeri = cekOdemeYeri;
    }

    public String getCekSeriNo() {
        return cekSeriNo;
    }

    public void setCekSeriNo(String cekSeriNo) {
        this.cekSeriNo = cekSeriNo;
    }

    public String getCekDurum() {
        return cekDurum;
    }

    public void setCekDurum(String cekDurum) {
        this.cekDurum = cekDurum;
    }

    public String getFatMusteriAdi() {
        return fatMusteriAdi;
    }

    public void setFatMusteriAdi(String fatMusteriAdi) {
        this.fatMusteriAdi = fatMusteriAdi;
    }

    public String getFatAdres1() {
        return fatAdres1;
    }

    public void setFatAdres1(String fatAdres1) {
        this.fatAdres1 = fatAdres1;
    }

    public String getFatAdres2() {
        return fatAdres2;
    }

    public void setFatAdres2(String fatAdres2) {
        this.fatAdres2 = fatAdres2;
    }

    public String getFatSemt() {
        return fatSemt;
    }

    public void setFatSemt(String fatSemt) {
        this.fatSemt = fatSemt;
    }

    public String getFatSehir() {
        return fatSehir;
    }

    public void setFatSehir(String fatSehir) {
        this.fatSehir = fatSehir;
    }

    public String getFatVdaire() {
        return fatVdaire;
    }

    public void setFatVdaire(String fatVdaire) {
        this.fatVdaire = fatVdaire;
    }

    public byte[] getFatVno() {
        return fatVno;
    }

    public void setFatVno(byte[] fatVno) {
        this.fatVno = fatVno;
    }

    public String getFatGsm() {
        return fatGsm;
    }

    public void setFatGsm(String fatGsm) {
        this.fatGsm = fatGsm;
    }

    public byte[] getLineSeriNolar() {
        return lineSeriNolar;
    }

    public void setLineSeriNolar(byte[] lineSeriNolar) {
        this.lineSeriNolar = lineSeriNolar;
    }

    public OdemeTurleriDao getLineOdemeRef() {
        return lineOdemeRef;
    }

    public void setLineOdemeRef(OdemeTurleriDao lineOdemeRef) {
        this.lineOdemeRef = lineOdemeRef;
    }

    public UrunlerDao getUrunRef() {
        return urunRef;
    }

    public void setUrunRef(UrunlerDao urunRef) {
        this.urunRef = urunRef;
    }

    public SubelerDao getSubeRef() {
        return subeRef;
    }

    public void setSubeRef(SubelerDao subeRef) {
        this.subeRef = subeRef;
    }

    public CariHesaplarDao getMusteriRef() {
        return musteriRef;
    }

    public void setMusteriRef(CariHesaplarDao musteriRef) {
        this.musteriRef = musteriRef;
    }

    public MasraflarDao getMasrafYeri() {
        return masrafYeri;
    }

    public void setMasrafYeri(MasraflarDao masrafYeri) {
        this.masrafYeri = masrafYeri;
    }

    public OlcuBirimleriDao getLineBirim() {
        return lineBirim;
    }

    public void setLineBirim(OlcuBirimleriDao lineBirim) {
        this.lineBirim = lineBirim;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fisId != null ? fisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CariFislerDao)) {
            return false;
        }
        CariFislerDao other = (CariFislerDao) object;
        if ((this.fisId == null && other.fisId != null) || (this.fisId != null && !this.fisId.equals(other.fisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lifeweb.enitity.CariFisler[ fisId=" + fisId + " ]";
    }
    
}
