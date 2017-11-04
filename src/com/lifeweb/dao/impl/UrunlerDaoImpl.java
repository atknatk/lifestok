package com.lifeweb.dao.impl;

import com.lifeweb.dao.UrunlerDao;
import com.lifeweb.dao.pojo.KdvGrup;
import com.lifeweb.dao.pojo.Markalar;
import com.lifeweb.dao.pojo.OlcuBirimleri;
import com.lifeweb.dao.pojo.UrunCesit;
import com.lifeweb.dao.pojo.UrunGrup;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.enitity.helper.DaoHelper;
import com.lifeweb.ui.helper.Helper;
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
public class UrunlerDaoImpl implements UrunlerDao {

    private final static Logger LOGGER = Logger.getLogger(UrunlerDaoImpl.class
            .getName());

    @Override
    public int createUrun(Urunler urunler) {
        Connection con;
        PreparedStatement pstmt;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("INSERT INTO urunler(BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI,"
                    + " BIRIM_REF, URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2,"
                    + " URUN_SATIS_FIYAT3, URUN_KDV_GRUP, URUN_AKTIF, SYS_EKLEYEN, SYS_ETARIH,"
                    + " SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, URUN_CESIT, URUN_STOK_SEVIYE,"
                    + " URUN_OZELKOD, URUN_SERINO, URUN_NOT, MARKA_REF, GRUP_REF, URUN_SONKULLANMA,"
                    + " URUN_DURUM, URUN_MINUMUM_STOK, URUN_PID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, urunler.getBarkodId());
            pstmt.setShort(2, new Short("1"));
            pstmt.setString(3, urunler.getBarkodTip());
            pstmt.setString(4, urunler.getUrunAdi());
            pstmt.setString(5, urunler.getBirimRef().getBirimAdi());
            pstmt.setDouble(6, urunler.getUrunAlisFiyat() == null ? 0.00 : urunler.getUrunAlisFiyat());
            pstmt.setDouble(7, urunler.getUrunSatisFiyat() == null ? 0.00 : urunler.getUrunSatisFiyat());
            pstmt.setDouble(8, urunler.getUrunSatisFiyat2() == null ? 0.00 : urunler.getUrunSatisFiyat2());
            pstmt.setFloat(9, urunler.getUrunSatisFiyat3() == null ? new Float(0.00) : urunler.getUrunSatisFiyat3());
            pstmt.setInt(10, urunler.getUrunKdvGrup().getKdvGrupNo());
            pstmt.setBoolean(11, true);
            pstmt.setString(12, urunler.getSysEkleyen());
            pstmt.setInt(13, 1);
            pstmt.setString(14, urunler.getSysDuzelten());
            pstmt.setInt(15, 1);
            pstmt.setString(16, urunler.getUrunBeden());
            pstmt.setString(17, urunler.getUrunRenk());
            pstmt.setString(18, urunler.getUrunCesit().getCesitAdi());
            pstmt.setDouble(19, urunler.getUrunStokSeviye());
            pstmt.setString(20, urunler.getUrunOzelkod());
            pstmt.setString(21, urunler.getUrunSerino());
            pstmt.setString(22, urunler.getUrunNot());
            pstmt.setString(23, urunler.getMarkaRef().getMarkaAdi());
            pstmt.setString(24, urunler.getGrupRef().getUrunGrupAdi());
            pstmt.setDate(25, new Date(System.currentTimeMillis()));
            pstmt.setString(26, urunler.getUrunDurum());
            pstmt.setDouble(27, urunler.getUrunMinumumStok() == null ? 0 : urunler.getUrunMinumumStok());
            pstmt.setString(28, urunler.getUrunPid());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
        return -1;
    }

    @Override
    public int createUrunDigerSube(Urunler urunler) {
        Connection con = null;
        PreparedStatement pstmt;
        try {
            String ip = Helper.getConfigs().get("diger_sube_ip");
            con = DaoHelper.instance().getConnection(ip);
            pstmt = con.prepareStatement("INSERT INTO urunler(BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI,"
                    + " BIRIM_REF, URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2,"
                    + " URUN_SATIS_FIYAT3, URUN_KDV_GRUP, URUN_AKTIF, SYS_EKLEYEN, SYS_ETARIH,"
                    + " SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, URUN_CESIT, URUN_STOK_SEVIYE,"
                    + " URUN_OZELKOD, URUN_SERINO, URUN_NOT, MARKA_REF, GRUP_REF, URUN_SONKULLANMA,"
                    + " URUN_DURUM, URUN_MINUMUM_STOK, URUN_PID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, urunler.getBarkodId());
            pstmt.setShort(2, new Short("1"));
            pstmt.setString(3, urunler.getBarkodTip());
            pstmt.setString(4, urunler.getUrunAdi());
            pstmt.setString(5, urunler.getBirimRef().getBirimAdi());
            pstmt.setDouble(6, urunler.getUrunAlisFiyat() == null ? 0.00 : urunler.getUrunAlisFiyat());
            pstmt.setDouble(7, urunler.getUrunSatisFiyat() == null ? 0.00 : urunler.getUrunSatisFiyat());
            pstmt.setDouble(8, urunler.getUrunSatisFiyat2() == null ? 0.00 : urunler.getUrunSatisFiyat2());
            pstmt.setFloat(9, urunler.getUrunSatisFiyat3() == null ? new Float(0.00) : urunler.getUrunSatisFiyat3());
            pstmt.setInt(10, urunler.getUrunKdvGrup().getKdvGrupNo());
            pstmt.setBoolean(11, true);
            pstmt.setString(12, urunler.getSysEkleyen());
            pstmt.setInt(13, 1);
            pstmt.setString(14, urunler.getSysDuzelten());
            pstmt.setInt(15, 1);
            pstmt.setString(16, urunler.getUrunBeden());
            pstmt.setString(17, urunler.getUrunRenk());
            pstmt.setString(18, urunler.getUrunCesit().getCesitAdi());
            pstmt.setDouble(19, urunler.getUrunStokSeviye());
            pstmt.setString(20, urunler.getUrunOzelkod());
            pstmt.setString(21, urunler.getUrunSerino());
            pstmt.setString(22, urunler.getUrunNot());
            pstmt.setString(23, urunler.getMarkaRef().getMarkaAdi());
            pstmt.setString(24, urunler.getGrupRef().getUrunGrupAdi());
            pstmt.setDate(25, new Date(System.currentTimeMillis()));
            pstmt.setString(26, urunler.getUrunDurum());
            pstmt.setDouble(27, urunler.getUrunMinumumStok() == null ? 0 : urunler.getUrunMinumumStok());
            pstmt.setString(28, urunler.getUrunPid());
            pstmt.executeUpdate();
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

        return -1;
    }

    @Override
    public List<Urunler> getUrunList() {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        ArrayList<Urunler> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT "
                    + "URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, BIRIM_REF,"
                    + " URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, URUN_SATIS_FIYAT3, "
                    + " URUN_AKTIF, SYS_EKLEYEN, SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                    + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT, MARKA_REF, GRUP_REF,"
                    + " URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK, URUN_PID, KDV_GRUP_NO, KDV_GRUP_ORAN, "
                    + "KDV_ACIKLAMA "
                    + "FROM urunler as u left join kdv_grup as k on u.URUN_KDV_GRUP=k.KDV_GRUP_NO");
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
                data.setMarkaRef(new Markalar(-1, rs.getString(23)));
                data.setGrupRef(new UrunGrup(-1, rs.getString(24)));
                data.setUrunSonkullanma(null);
                data.setUrunDurum(rs.getString(26));
                data.setUrunMinumumStok(rs.getDouble(27));
                data.setUrunPid(rs.getString(28));
                data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));
                list.add(data);
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
        return list;
    }

    @Override
    public Urunler getUrun(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Urunler data = null;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT "
                    + "URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, BIRIM_REF,"
                    + " URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, URUN_SATIS_FIYAT3, "
                    + " URUN_AKTIF, SYS_EKLEYEN, SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                    + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT, MARKA_REF, GRUP_REF,"
                    + " URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK, URUN_PID, KDV_GRUP_NO, KDV_GRUP_ORAN, "
                    + "KDV_ACIKLAMA "
                    + "FROM urunler as u left join kdv_grup as k on u.URUN_KDV_GRUP=k.KDV_GRUP_NO "
                    + "where u.URUN_ID=?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                data = new Urunler();
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
                data.setMarkaRef(new Markalar(-1, rs.getString(23)));
                data.setGrupRef(new UrunGrup(-1, rs.getString(24)));
                data.setUrunSonkullanma(null);
                data.setUrunDurum(rs.getString(26));
                data.setUrunMinumumStok(rs.getDouble(27));
                data.setUrunPid(rs.getString(28));
                data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
        return data;
    }

    @Override
    public Urunler getUrun(String barkod) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Urunler data = null;

        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("SELECT URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, BIRIM_REF,"
                    + " URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, URUN_SATIS_FIYAT3, "
                    + " URUN_AKTIF, SYS_EKLEYEN, SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                    + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT, MARKA_REF, GRUP_REF,"
                    + " URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK, URUN_PID, KDV_GRUP_NO, KDV_GRUP_ORAN, "
                    + "KDV_ACIKLAMA FROM urunler as u left join kdv_grup as k on u.URUN_KDV_GRUP=k.KDV_GRUP_NO "
                    + "where u.BARKOD_ID=?");
            pstmt.setString(1, barkod);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                data = new Urunler();
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
                data.setMarkaRef(new Markalar(-1, rs.getString(23)));
                data.setGrupRef(new UrunGrup(-1, rs.getString(24)));
                data.setUrunSonkullanma(null);
                data.setUrunDurum(rs.getString(26));
                data.setUrunMinumumStok(rs.getDouble(27));
                data.setUrunPid(rs.getString(28));
                data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
        return data;
    }

    @Override
    public Urunler editUrun(Urunler urunler) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("UPDATE urunler SET BARKOD_ID=?, BARKOD_TUR=?, BARKOD_TIP=?,"
                    + " URUN_ADI=?, BIRIM_REF=?, URUN_ALIS_FIYAT=?, URUN_SATIS_FIYAT=?, URUN_SATIS_FIYAT2=?,"
                    + " URUN_SATIS_FIYAT3=?, URUN_KDV_GRUP=?, URUN_AKTIF=?, SYS_EKLEYEN=?, SYS_ETARIH=?,"
                    + " SYS_DUZELTEN=?, SYS_DTARIH=?, URUN_BEDEN=?, URUN_RENK=?, URUN_CESIT=?, URUN_STOK_SEVIYE=?,"
                    + " URUN_OZELKOD=?, URUN_SERINO=?, URUN_NOT=?, MARKA_REF=?, GRUP_REF=?, URUN_SONKULLANMA=?, "
                    + " URUN_DURUM=?, URUN_MINUMUM_STOK=?, URUN_PID=? where URUN_ID=?");
            pstmt.setString(1, urunler.getBarkodId());
            pstmt.setShort(2, urunler.getBarkodTur());
            pstmt.setString(3, urunler.getBarkodTip());
            pstmt.setString(4, urunler.getUrunAdi());
            pstmt.setString(5, urunler.getBirimRef().getBirimAdi());
            pstmt.setDouble(6, urunler.getUrunAlisFiyat());
            pstmt.setDouble(7, urunler.getUrunSatisFiyat());
            pstmt.setDouble(8, urunler.getUrunSatisFiyat2());
            pstmt.setFloat(9, urunler.getUrunSatisFiyat3());
            pstmt.setShort(10, urunler.getUrunKdvGrup().getKdvGrupNo());
            pstmt.setShort(11, urunler.getUrunAktif());
            pstmt.setString(12, urunler.getSysEkleyen());
            pstmt.setInt(13, 1);
            pstmt.setString(14, urunler.getSysDuzelten());
            pstmt.setInt(15, 1);
            pstmt.setString(16, urunler.getUrunBeden());
            pstmt.setString(17, urunler.getUrunRenk());
            pstmt.setString(18, urunler.getUrunCesit().getCesitAdi());
            pstmt.setDouble(19, urunler.getUrunStokSeviye());
            pstmt.setString(20, urunler.getUrunOzelkod());
            pstmt.setString(21, urunler.getUrunSerino());
            pstmt.setString(22, urunler.getUrunNot());
            pstmt.setString(23, urunler.getMarkaRef().getMarkaAdi());
            pstmt.setString(24, urunler.getGrupRef().getUrunGrupAdi());
            pstmt.setDate(25, new Date(System.currentTimeMillis()));
            pstmt.setString(26, urunler.getUrunDurum());
            pstmt.setDouble(27, urunler.getUrunMinumumStok() == null ? 0 : urunler.getUrunMinumumStok());
            pstmt.setString(28, urunler.getUrunPid());
            pstmt.setInt(29, urunler.getUrunId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
        return urunler;
    }

    @Override
    public void removeUrun(Urunler urunler) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("DELETE FROM urunler WHERE URUN_ID=?");
            pstmt.setInt(1, urunler.getUrunId());
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void stokEksiUrun(Urunler urunler, Double miktar) {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = DaoHelper.instance().getConnection();
            pstmt = con.prepareStatement("UPDATE urunler SET URUN_STOK_SEVIYE=URUN_STOK_SEVIYE-? WHERE URUN_ID=?");
            pstmt.setDouble(1, miktar);
            pstmt.setInt(2, urunler.getUrunId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }

    }

    @Override
    public List<Urunler> getUrunList(String ip) {
      Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Urunler> list = new ArrayList<>();

        try {
            con = DaoHelper.instance().getConnection(ip);
            pstmt = con.prepareStatement("SELECT "
                    + "URUN_ID, BARKOD_ID, BARKOD_TUR, BARKOD_TIP, URUN_ADI, BIRIM_REF,"
                    + " URUN_ALIS_FIYAT, URUN_SATIS_FIYAT, URUN_SATIS_FIYAT2, URUN_SATIS_FIYAT3, "
                    + " URUN_AKTIF, SYS_EKLEYEN, SYS_ETARIH, SYS_DUZELTEN, SYS_DTARIH, URUN_BEDEN, URUN_RENK, "
                    + "URUN_CESIT, URUN_STOK_SEVIYE, URUN_OZELKOD, URUN_SERINO, URUN_NOT, MARKA_REF, GRUP_REF,"
                    + " URUN_SONKULLANMA, URUN_DURUM, URUN_MINUMUM_STOK, URUN_PID, KDV_GRUP_NO, KDV_GRUP_ORAN, "
                    + "KDV_ACIKLAMA "
                    + "FROM urunler as u left join kdv_grup as k on u.URUN_KDV_GRUP=k.KDV_GRUP_NO");
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
                data.setMarkaRef(new Markalar(-1, rs.getString(23)));
                data.setGrupRef(new UrunGrup(-1, rs.getString(24)));
                data.setUrunSonkullanma(null);
                data.setUrunDurum(rs.getString(26));
                data.setUrunMinumumStok(rs.getDouble(27));
                data.setUrunPid(rs.getString(28));
                data.setUrunKdvGrup(new KdvGrup(rs.getShort(29), rs.getShort(30), rs.getString(31)));
                list.add(data);
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), IndirimlerDaoImpl.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
        }
        return list;
    }
}
