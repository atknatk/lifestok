package com.lifeweb.dao.impl;

import com.lifeweb.dao.IndirimlerDao;
import com.lifeweb.dao.pojo.IndirimAltGrup;
import com.lifeweb.dao.pojo.Indirimler;
import com.lifeweb.dao.pojo.KdvGrup;
import com.lifeweb.dao.pojo.Kullanici;
import com.lifeweb.dao.pojo.Markalar;
import com.lifeweb.dao.pojo.OlcuBirimleri;
import com.lifeweb.dao.pojo.UrunCesit;
import com.lifeweb.dao.pojo.UrunGrup;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.enitity.helper.DaoHelper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Life
 */
public class IndirimlerDaoImpl implements IndirimlerDao {

    private final static Logger LOGGER = Logger.getLogger(IndirimlerDaoImpl.class
            .getName());

    @Override
    public int createIndirimler(Indirimler indirimler) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DaoHelper.instance().getConnection();
            
            pstmt = con.prepareStatement("INSERT INTO indirimler("
                    + "URUN_REF, BTARIH, ETARIH, IND_ORAN,"
                    + " IND_MIN_MIKTAR, IND_DURUM, IND_EKLEYEN, "
                    + "IND_ETARIH, TEK_URUN,IND_ADI,IND_NET,YUZDE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, indirimler.getUrunRef().getUrunId());
            pstmt.setDate(2, new Date(indirimler.getBtarih().getTime()));
            pstmt.setDate(3, new Date(indirimler.getEtarih().getTime()));
            pstmt.setDouble(4, indirimler.getIndOran());
            pstmt.setDouble(5, indirimler.getIndMinMiktar());
            pstmt.setBoolean(6, indirimler.isIndDurum());
            pstmt.setInt(7, indirimler.getIndEkleyen().getKullaniciId());
            pstmt.setDate(8, new Date(System.currentTimeMillis()));
            pstmt.setBoolean(9, indirimler.isTekUrun());
            pstmt.setString(10, indirimler.getIndAdi());
            pstmt.setDouble(11, indirimler.getIndNet());
            pstmt.setBoolean(12, indirimler.isYuzde());
            pstmt.executeUpdate();
            if (!indirimler.isTekUrun()) {
                pstmt = con.prepareStatement("SELECT IND_ID FROM indirimler ORDER BY IND_ID DESC LIMIT 1");
                rs = pstmt.executeQuery();
                int id = 0;
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                ArrayList<IndirimAltGrup> grups = indirimler.getIndirimAltGrups();
                if (id != 0 && grups != null) {
                    for (IndirimAltGrup indirimAltGrup : grups) {
                        pstmt = con.prepareStatement("INSERT INTO indirim_alt_grup("
                                + "INDIRIM_ID, URUN_ID, ORAN,NET,YUZDE)VALUES (?,?,?,?,?)");
                        pstmt.setInt(1, id);
                        pstmt.setInt(2, indirimAltGrup.getUrun().getUrunId());
                        pstmt.setDouble(3, indirimAltGrup.getOran());
                        pstmt.setDouble(4, indirimAltGrup.getNet());
                        pstmt.setBoolean(5, indirimAltGrup.isYuzde());
                        pstmt.executeUpdate();
                    }
                }
            }
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        } 

        return -1;
    }

    @Override
    public List<Indirimler> getIndirimlerList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Indirimler> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT "
                    + " URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, "
                    + "BIRIM_REF, URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, "
                    + "URUN_SATIS_FIYAT3, URUN_AKTIF, SYS_EKLEYEN, "
                    + "SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                    + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT,"
                    + " MARKA_REF, GRUP_REF, URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK,"
                    + " URUN_PID,KDV_GRUP_NO, KDV_GRUP_ORAN, "
                    + "KDV_ACIKLAMA, IND_ID, BTARIH, ETARIH,"
                    + " IND_ORAN, IND_MIN_MIKTAR, IND_DURUM, IND_EKLEYEN, IND_ETARIH, TEK_URUN,IND_ADI,IND_NET,YUZDE"
                    + " FROM indirimler as i left join urunler as ana on "
                    + "i.urun_ref=ana.urun_id left join kdv_grup as k on ana.URUN_KDV_GRUP=k.KDV_GRUP_NO");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Urunler data = new Urunler();
                data.setUrunId(rs.getInt(1));
                data.setBarkodId(rs.getString(2));
                data.setBarkodTur(rs.getShort(3));
                data.setBarkodTip(rs.getString(4));
                data.setUrunAdi(rs.getString(5));
                data.setBirimRef(new OlcuBirimleri(-1, rs.getString(6)));
                data.setUrunAlisFiyat(rs.getDouble(7));
                data.setUrunSatisFiyat(rs.getDouble(8));
                data.setUrunSatisFiyat2(rs.getDouble(9));
                data.setUrunSatisFiyat3(rs.getFloat(10));
                data.setUrunAktif(rs.getShort(11));
                data.setSysEkleyen(rs.getString(12));
                data.setSysEtarih(null);
                data.setSysDuzelten(rs.getString(14));
                data.setSysDtarih(null);
                data.setUrunBeden(rs.getString(16));
                data.setUrunRenk(rs.getString(17));
                data.setUrunCesit(new UrunCesit(-1, rs.getString(18)));
                data.setUrunStokSeviye(rs.getDouble(19));
                data.setUrunOzelkod(rs.getString(20));
                data.setUrunSerino(rs.getString(21));
                data.setUrunNot(rs.getString(22));
                data.setMarkaRef(new Markalar(-1, rs.getString(25)));
                data.setGrupRef(new UrunGrup(-1, rs.getString(26)));
                data.setUrunSonkullanma(new java.util.Date(rs.getDate(27) != null ? rs.getDate(27).getTime() : System.currentTimeMillis()));
                data.setUrunPid(rs.getString(28));
                data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));

                Indirimler anaData = new Indirimler();
                anaData.setIndId(rs.getInt(32));
                anaData.setUrunRef(data);
                anaData.setBtarih(new java.util.Date(rs.getDate(33).getTime()));
                anaData.setEtarih(new java.util.Date(rs.getDate(34).getTime()));
                anaData.setIndOran(rs.getDouble(35));
                anaData.setIndMinMiktar(rs.getDouble(36));
                anaData.setIndDurum(rs.getBoolean(37));
                anaData.setIndEkleyen(new Kullanici(rs.getInt(38)));
                anaData.setIndEtarih(new java.util.Date(rs.getDate(39).getTime()));
                anaData.setTekUrun(rs.getBoolean(40));
                anaData.setIndAdi(rs.getString(41));
                anaData.setIndNet(rs.getDouble(42));
                anaData.setYuzde(rs.getBoolean(43));
                list.add(anaData);
            }

            for (Indirimler indirimler : list) {
                if (!indirimler.isTekUrun()) {
                    ArrayList<IndirimAltGrup> altGrups = new ArrayList<>();
                    pstmt = con.prepareStatement("SELECT "
                            + "URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, "
                            + "BIRIM_REF, URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, "
                            + "URUN_SATIS_FIYAT3, URUN_AKTIF, SYS_EKLEYEN, "
                            + "SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                            + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT,"
                            + " MARKA_REF, GRUP_REF, URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK,"
                            + " URUN_PID,KDV_GRUP_NO, KDV_GRUP_ORAN, "
                            + "KDV_ACIKLAMA, INDIRIM_ALT_GRUP_ID, ORAN,NET,YUZDE "
                            + "FROM indirim_alt_grup natural join urunler as ana left join kdv_grup as k on ana.URUN_KDV_GRUP=k.KDV_GRUP_NO where INDIRIM_ID=?");
                    pstmt.setInt(1, indirimler.getIndId());
                    System.out.println(pstmt.toString());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        Urunler data = new Urunler();
                        data.setUrunId(rs.getInt(1));
                        data.setBarkodId(rs.getString(2));
                        data.setBarkodTur(rs.getShort(3));
                        data.setBarkodTip(rs.getString(4));
                        data.setUrunAdi(rs.getString(5));
                        data.setBirimRef(new OlcuBirimleri(-1, rs.getString(6)));
                        data.setUrunAlisFiyat(rs.getDouble(7));
                        data.setUrunSatisFiyat(rs.getDouble(8));
                        data.setUrunSatisFiyat2(rs.getDouble(9));
                        data.setUrunSatisFiyat3(rs.getFloat(10));
                        data.setUrunAktif(rs.getShort(11));
                        data.setSysEkleyen(rs.getString(12));
                        data.setSysEtarih(null);
                        data.setSysDuzelten(rs.getString(14));
                        data.setSysDtarih(null);
                        data.setUrunBeden(rs.getString(16));
                        data.setUrunRenk(rs.getString(17));
                        data.setUrunCesit(new UrunCesit(-1, rs.getString(18)));
                        data.setUrunStokSeviye(rs.getDouble(19));
                        data.setUrunOzelkod(rs.getString(20));
                        data.setUrunSerino(rs.getString(21));
                        data.setUrunNot(rs.getString(22));
                        data.setMarkaRef(new Markalar(-1, rs.getString(25)));
                        data.setGrupRef(new UrunGrup(-1, rs.getString(26)));
                        data.setUrunSonkullanma(new java.util.Date(rs.getDate(27) != null ? rs.getDate(27).getTime() : System.currentTimeMillis()));
                        data.setUrunPid(rs.getString(28));
                        data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));

                        IndirimAltGrup altGrup = new IndirimAltGrup();
                        altGrup.setId(rs.getInt(32));
                        altGrup.setIndirimId(indirimler);
                        altGrup.setOran(rs.getDouble(33));
                        altGrup.setUrun(data);
                        altGrup.setNet(rs.getDouble(34));
                        altGrup.setYuzde(rs.getBoolean(35));
                        altGrups.add(altGrup);
                    }
                    indirimler.setIndirimAltGrups(altGrups);
                }

            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        } 
        return list;
    }

    @Override
    public Indirimler getIndirimler(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Indirimler editIndirimler(Indirimler indirimler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeIndirimler(Indirimler indirimler) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Indirimler> getIndirimlerTekList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Indirimler> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT "
                    + " URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, "
                    + "BIRIM_REF, URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, "
                    + "URUN_SATIS_FIYAT3, URUN_AKTIF, SYS_EKLEYEN, "
                    + "SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                    + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT,"
                    + " MARKA_REF, GRUP_REF, URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK,"
                    + " URUN_PID,KDV_GRUP_NO, KDV_GRUP_ORAN, "
                    + "KDV_ACIKLAMA, IND_ID, BTARIH, ETARIH,"
                    + " IND_ORAN, IND_MIN_MIKTAR, IND_DURUM, IND_EKLEYEN, IND_ETARIH, TEK_URUN,IND_ADI,IND_NET,YUZDE"
                    + " FROM indirimler as i left join urunler as ana on "
                    + "i.urun_ref=ana.urun_id left join kdv_grup as k on ana.URUN_KDV_GRUP=k.KDV_GRUP_NO where TEK_URUN=1");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Urunler data = new Urunler();
                data.setUrunId(rs.getInt(1));
                data.setBarkodId(rs.getString(2));
                data.setBarkodTur(rs.getShort(3));
                data.setBarkodTip(rs.getString(4));
                data.setUrunAdi(rs.getString(5));
                data.setBirimRef(new OlcuBirimleri(-1, rs.getString(6)));
                data.setUrunAlisFiyat(rs.getDouble(7));
                data.setUrunSatisFiyat(rs.getDouble(8));
                data.setUrunSatisFiyat2(rs.getDouble(9));
                data.setUrunSatisFiyat3(rs.getFloat(10));
                data.setUrunAktif(rs.getShort(11));
                data.setSysEkleyen(rs.getString(12));
                data.setSysEtarih(null);
                data.setSysDuzelten(rs.getString(14));
                data.setSysDtarih(null);
                data.setUrunBeden(rs.getString(16));
                data.setUrunRenk(rs.getString(17));
                data.setUrunCesit(new UrunCesit(-1, rs.getString(18)));
                data.setUrunStokSeviye(rs.getDouble(19));
                data.setUrunOzelkod(rs.getString(20));
                data.setUrunSerino(rs.getString(21));
                data.setUrunNot(rs.getString(22));
                data.setMarkaRef(new Markalar(-1, rs.getString(25)));
                data.setGrupRef(new UrunGrup(-1, rs.getString(26)));
                data.setUrunSonkullanma(new java.util.Date(rs.getDate(27) != null ? rs.getDate(27).getTime() : System.currentTimeMillis()));
                data.setUrunPid(rs.getString(28));
                data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));

                Indirimler anaData = new Indirimler();
                anaData.setIndId(rs.getInt(32));
                anaData.setUrunRef(data);
                anaData.setBtarih(new java.util.Date(rs.getDate(33).getTime()));
                anaData.setEtarih(new java.util.Date(rs.getDate(34).getTime()));
                anaData.setIndOran(rs.getDouble(35));
                anaData.setIndMinMiktar(rs.getDouble(36));
                anaData.setIndDurum(rs.getBoolean(37));
                anaData.setIndEkleyen(new Kullanici(rs.getInt(38)));
                anaData.setIndEtarih(new java.util.Date(rs.getDate(39).getTime()));
                anaData.setTekUrun(rs.getBoolean(40));
                anaData.setIndAdi(rs.getString(41));
                anaData.setIndNet(rs.getDouble(42));
                anaData.setYuzde(rs.getBoolean(43));
                list.add(anaData);



            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        } 

        return list;
    }

    @Override
    public List<Indirimler> getIndirimlerCokList() {

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Indirimler> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT "
                    + " URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, "
                    + "BIRIM_REF, URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, "
                    + "URUN_SATIS_FIYAT3, URUN_AKTIF, SYS_EKLEYEN, "
                    + "SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                    + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT,"
                    + " MARKA_REF, GRUP_REF, URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK,"
                    + " URUN_PID,KDV_GRUP_NO, KDV_GRUP_ORAN, "
                    + "KDV_ACIKLAMA, IND_ID, BTARIH, ETARIH,"
                    + " IND_ORAN, IND_MIN_MIKTAR, IND_DURUM, IND_EKLEYEN, IND_ETARIH, TEK_URUN,IND_ADI,IND_NET,YUZDE"
                    + " FROM indirimler as i left join urunler as ana on "
                    + "i.urun_ref=ana.urun_id left join kdv_grup as k on ana.URUN_KDV_GRUP=k.KDV_GRUP_NO where TEK_URUN=0");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Urunler data = new Urunler();
                data.setUrunId(rs.getInt(1));
                data.setBarkodId(rs.getString(2));
                data.setBarkodTur(rs.getShort(3));
                data.setBarkodTip(rs.getString(4));
                data.setUrunAdi(rs.getString(5));
                data.setBirimRef(new OlcuBirimleri(-1, rs.getString(6)));
                data.setUrunAlisFiyat(rs.getDouble(7));
                data.setUrunSatisFiyat(rs.getDouble(8));
                data.setUrunSatisFiyat2(rs.getDouble(9));
                data.setUrunSatisFiyat3(rs.getFloat(10));
                data.setUrunAktif(rs.getShort(11));
                data.setSysEkleyen(rs.getString(12));
                data.setSysEtarih(null);
                data.setSysDuzelten(rs.getString(14));
                data.setSysDtarih(null);
                data.setUrunBeden(rs.getString(16));
                data.setUrunRenk(rs.getString(17));
                data.setUrunCesit(new UrunCesit(-1, rs.getString(18)));
                data.setUrunStokSeviye(rs.getDouble(19));
                data.setUrunOzelkod(rs.getString(20));
                data.setUrunSerino(rs.getString(21));
                data.setUrunNot(rs.getString(22));
                data.setMarkaRef(new Markalar(-1, rs.getString(25)));
                data.setGrupRef(new UrunGrup(-1, rs.getString(26)));
                data.setUrunSonkullanma(new java.util.Date(rs.getDate(27) != null ? rs.getDate(27).getTime() : System.currentTimeMillis()));
                data.setUrunPid(rs.getString(28));
                data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));

                Indirimler anaData = new Indirimler();
                anaData.setIndId(rs.getInt(32));
                anaData.setUrunRef(data);
                anaData.setBtarih(new java.util.Date(rs.getDate(33).getTime()));
                anaData.setEtarih(new java.util.Date(rs.getDate(34).getTime()));
                anaData.setIndOran(rs.getDouble(35));
                anaData.setIndMinMiktar(rs.getDouble(36));
                anaData.setIndDurum(rs.getBoolean(37));
                anaData.setIndEkleyen(new Kullanici(rs.getInt(38)));
                anaData.setIndEtarih(new java.util.Date(rs.getDate(39).getTime()));
                anaData.setTekUrun(rs.getBoolean(40));
                anaData.setIndAdi(rs.getString(41));
                anaData.setIndNet(rs.getDouble(42));
                anaData.setYuzde(rs.getBoolean(43));
                list.add(anaData);
            }

            for (Indirimler indirimler : list) {
                if (!indirimler.isTekUrun()) {
                    ArrayList<IndirimAltGrup> altGrups = new ArrayList<>();
                    pstmt = con.prepareStatement("SELECT "
                            + "URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, "
                            + "BIRIM_REF, URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, "
                            + "URUN_SATIS_FIYAT3, URUN_AKTIF, SYS_EKLEYEN, "
                            + "SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                            + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT,"
                            + " MARKA_REF, GRUP_REF, URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK,"
                            + " URUN_PID,KDV_GRUP_NO, KDV_GRUP_ORAN, "
                            + "KDV_ACIKLAMA, INDIRIM_ALT_GRUP_ID, ORAN,NET,YUZDE"
                            + "FROM indirim_alt_grup natural join urunler as ana left join kdv_grup as k on ana.URUN_KDV_GRUP=k.KDV_GRUP_NO where INDIRIM_ID=?");
                    pstmt.setInt(1, indirimler.getIndId());
                    System.out.println(pstmt.toString());
                    rs = pstmt.executeQuery();
                    while (rs.next()) {
                        Urunler data = new Urunler();
                        data.setUrunId(rs.getInt(1));
                        data.setBarkodId(rs.getString(2));
                        data.setBarkodTur(rs.getShort(3));
                        data.setBarkodTip(rs.getString(4));
                        data.setUrunAdi(rs.getString(5));
                        data.setBirimRef(new OlcuBirimleri(-1, rs.getString(6)));
                        data.setUrunAlisFiyat(rs.getDouble(7));
                        data.setUrunSatisFiyat(rs.getDouble(8));
                        data.setUrunSatisFiyat2(rs.getDouble(9));
                        data.setUrunSatisFiyat3(rs.getFloat(10));
                        data.setUrunAktif(rs.getShort(11));
                        data.setSysEkleyen(rs.getString(12));
                        data.setSysEtarih(null);
                        data.setSysDuzelten(rs.getString(14));
                        data.setSysDtarih(null);
                        data.setUrunBeden(rs.getString(16));
                        data.setUrunRenk(rs.getString(17));
                        data.setUrunCesit(new UrunCesit(-1, rs.getString(18)));
                        data.setUrunStokSeviye(rs.getDouble(19));
                        data.setUrunOzelkod(rs.getString(20));
                        data.setUrunSerino(rs.getString(21));
                        data.setUrunNot(rs.getString(22));
                        data.setMarkaRef(new Markalar(-1, rs.getString(25)));
                        data.setGrupRef(new UrunGrup(-1, rs.getString(26)));
                        data.setUrunSonkullanma(new java.util.Date(rs.getDate(27) != null ? rs.getDate(27).getTime() : System.currentTimeMillis()));
                        data.setUrunPid(rs.getString(28));
                        data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));

                        IndirimAltGrup altGrup = new IndirimAltGrup();
                        altGrup.setId(rs.getInt(32));
                        altGrup.setIndirimId(indirimler);
                        altGrup.setOran(rs.getDouble(33));
                        altGrup.setUrun(data);
                        altGrup.setNet(rs.getDouble(34));
                        altGrup.setYuzde(rs.getBoolean(35));
                        altGrups.add(altGrup);
                    }
                    indirimler.setIndirimAltGrups(altGrups);
                }

            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        } 

        return list;
    }

    @Override
    public List<Indirimler> getIndirimlerTekList(String ad) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Indirimler> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();

            pstmt = con.prepareStatement("SELECT "
                    + " URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, "
                    + "BIRIM_REF, URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, "
                    + "URUN_SATIS_FIYAT3, URUN_AKTIF, SYS_EKLEYEN, "
                    + "SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                    + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT,"
                    + " MARKA_REF, GRUP_REF, URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK,"
                    + " URUN_PID,KDV_GRUP_NO, KDV_GRUP_ORAN, "
                    + "KDV_ACIKLAMA, IND_ID, BTARIH, ETARIH,"
                    + " IND_ORAN, IND_MIN_MIKTAR, IND_DURUM, IND_EKLEYEN, IND_ETARIH, TEK_URUN,IND_ADI,IND_NET,YUZDE"
                    + " FROM indirimler as i left join urunler as ana on "
                    + "i.urun_ref=ana.urun_id left join kdv_grup as k on ana.URUN_KDV_GRUP=k.KDV_GRUP_NO where TEK_URUN=1 and IND_ADI=?");
            pstmt.setString(1, ad);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                Urunler data = new Urunler();
                data.setUrunId(rs.getInt(1));
                data.setBarkodId(rs.getString(2));
                data.setBarkodTur(rs.getShort(3));
                data.setBarkodTip(rs.getString(4));
                data.setUrunAdi(rs.getString(5));
                data.setBirimRef(new OlcuBirimleri(-1, rs.getString(6)));
                data.setUrunAlisFiyat(rs.getDouble(7));
                data.setUrunSatisFiyat(rs.getDouble(8));
                data.setUrunSatisFiyat2(rs.getDouble(9));
                data.setUrunSatisFiyat3(rs.getFloat(10));
                data.setUrunAktif(rs.getShort(11));
                data.setSysEkleyen(rs.getString(12));
                data.setSysEtarih(null);
                data.setSysDuzelten(rs.getString(14));
                data.setSysDtarih(null);
                data.setUrunBeden(rs.getString(16));
                data.setUrunRenk(rs.getString(17));
                data.setUrunCesit(new UrunCesit(-1, rs.getString(18)));
                data.setUrunStokSeviye(rs.getDouble(19));
                data.setUrunOzelkod(rs.getString(20));
                data.setUrunSerino(rs.getString(21));
                data.setUrunNot(rs.getString(22));
                data.setMarkaRef(new Markalar(-1, rs.getString(25)));
                data.setGrupRef(new UrunGrup(-1, rs.getString(26)));
                data.setUrunSonkullanma(new java.util.Date(rs.getDate(27) != null ? rs.getDate(27).getTime() : System.currentTimeMillis()));
                data.setUrunPid(rs.getString(28));
                data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));

                Indirimler anaData = new Indirimler();
                anaData.setIndId(rs.getInt(32));
                anaData.setUrunRef(data);
                anaData.setBtarih(new java.util.Date(rs.getDate(33).getTime()));
                anaData.setEtarih(new java.util.Date(rs.getDate(34).getTime()));
                anaData.setIndOran(rs.getDouble(35));
                anaData.setIndMinMiktar(rs.getDouble(36));
                anaData.setIndDurum(rs.getBoolean(37));
                anaData.setIndEkleyen(new Kullanici(rs.getInt(38)));
                anaData.setIndEtarih(new java.util.Date(rs.getDate(39).getTime()));
                anaData.setTekUrun(rs.getBoolean(40));
                anaData.setIndAdi(rs.getString(41));
                anaData.setIndNet(rs.getDouble(42));
                anaData.setYuzde(rs.getBoolean(43));
                list.add(anaData);



            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }

        return list;
    }

    @Override
    public List<Indirimler> getIndirimlerCokList(String ad) {
        return null;
    }

    @Override
    public List<String> getIndirimlerTekAdList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT distinct IND_ADI FROM indirimler where TEK_URUN=1");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
                }
            }
        }

        return list;
    }

    @Override
    public List<String> getIndirimlerCokAdList() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<String> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT distinct IND_ADI FROM  indirimler  where TEK_URUN=0");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        } 

        return list;
    }

    @Override
    public void createIndirimler(List<Indirimler> indirimlers) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = DaoHelper.instance().getConnection();
            for (Indirimler indirimler : indirimlers) {
                    pstmt = con.prepareStatement("INSERT INTO indirimler("
                    + "URUN_REF, BTARIH, ETARIH, IND_ORAN,"
                    + " IND_MIN_MIKTAR, IND_DURUM, IND_EKLEYEN, "
                    + "IND_ETARIH, TEK_URUN,IND_ADI,IND_NET,YUZDE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, indirimler.getUrunRef().getUrunId());
            pstmt.setDate(2, new Date(indirimler.getBtarih().getTime()));
            pstmt.setDate(3, new Date(indirimler.getEtarih().getTime()));
            pstmt.setDouble(4, indirimler.getIndOran());
            pstmt.setDouble(5, indirimler.getIndMinMiktar());
            pstmt.setBoolean(6, indirimler.isIndDurum());
            pstmt.setInt(7, indirimler.getIndEkleyen().getKullaniciId());
            pstmt.setDate(8, new Date(System.currentTimeMillis()));
            pstmt.setBoolean(9, indirimler.isTekUrun());
            pstmt.setString(10, indirimler.getIndAdi());
            pstmt.setDouble(11, indirimler.getIndNet());
            pstmt.setBoolean(12, indirimler.isYuzde());
            pstmt.executeUpdate();
            }
             pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        } 
   }
}
