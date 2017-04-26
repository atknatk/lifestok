package com.lifeweb.ui.islemler;

import com.jidesoft.grid.AbstractMultiTableModel;
import com.jidesoft.grid.CellStyleTable;
import com.lifeweb.dao.controller.CariHesaplarFisiController;
import com.lifeweb.dao.controller.IadeFisiController;
import com.lifeweb.dao.controller.OdemeTurleriLineController;
import com.lifeweb.dao.controller.SatisFisiController;
import com.lifeweb.dao.impl.CariHesaplarFisiDaoImpl;
import com.lifeweb.dao.impl.IadeFisiDaoImpl;
import com.lifeweb.dao.impl.OdemeTurleriLineDaoImpl;
import com.lifeweb.dao.impl.SatisFisiDaoImpl;
import com.lifeweb.dao.pojo.CariHesaplar;
import com.lifeweb.dao.pojo.CariHesaplarFisi;
import com.lifeweb.dao.pojo.CariHesaplarFisiLine;
import com.lifeweb.dao.pojo.IadeFisi;
import com.lifeweb.dao.pojo.IadeFisiLine;
import com.lifeweb.dao.pojo.Kullanici;
import com.lifeweb.dao.pojo.OdemeTurleri;
import com.lifeweb.dao.pojo.OdemeTurleriLine;
import com.lifeweb.dao.pojo.SatisFisi;
import com.lifeweb.dao.pojo.SatisFisiLine;
import com.lifeweb.dao.pojo.Subeler;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.pojo.IdValue;
import com.lifeweb.ui.MainUI;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class SatisIslemi {

    private static SatisIslemi satisIslemi;
    private final static Object lock = new Object();

    private int urunAdiIndex = -1;
    private int miktarIndex = -1;
    private int birimFiyatIndex = -1;
    private int indYuzdeIndex = -1;
    private int indTutarIndex = -1;
    private int tutarIndex = -1;

    private SatisIslemi() {
    }

    private SatisIslemi(CellStyleTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        urunAdiIndex = columnModel.getColumnIndex("ÜRÜN ADI");
        miktarIndex = columnModel.getColumnIndex("MİKTAR");
        birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
        indYuzdeIndex = columnModel.getColumnIndex("İND. %");
        indTutarIndex = columnModel.getColumnIndex("İND. TUTAR");
        tutarIndex = columnModel.getColumnIndex("TUTAR");
    }

    public static SatisIslemi myInstance(CellStyleTable table) {
        if (satisIslemi == null) {
            synchronized (lock) {
                satisIslemi = new SatisIslemi(table);
            }
        }
        return satisIslemi;
    }

//Doğrusu bu 
    public void satis(CellStyleTable table, OdemeTurleri odemeTurleri, Kullanici ekleyen) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() != 0) {
            SatisFisi fisi = new SatisFisi();
            fisi.setAciklama(odemeTurleri.getOdemeId()==1?"Nakit Satış Ekranı":"Kredi Satış Ekranı");
            fisi.setBelgeNo("");
            Date now = new Date();
            fisi.setFisSaati(now);
            fisi.setFisTarihi(now);
            fisi.setSubeId(new Subeler(1));
            fisi.setSysEkleyen(ekleyen);
            int row = model.getRowCount();
            double iskontoToplam = 0.00;
            double gToplam = 0.00;
            double kdvToplam = 0.00;
            for (int i = 0; i < row; i++) {
                Urunler urunler = (Urunler) model.getValueAt(i, urunAdiIndex);
                Double tutar = round(Double.valueOf(model.getValueAt(i, tutarIndex).toString()));
                kdvToplam += round(tutar * urunler.getUrunKdvGrup().getKdvGrupOran() / 100);
                iskontoToplam += round(Double.valueOf(model.getValueAt(i, indTutarIndex).toString()));
                gToplam += tutar;
            }
            fisi.setIskontoTutari(iskontoToplam);
            if (iskontoToplam == 0) {
                fisi.setIskontoOrani(0);

            } else {
                fisi.setIskontoOrani((gToplam + iskontoToplam) / (iskontoToplam * 100) * 100);

            }
            fisi.setKdvToplam(kdvToplam);
            fisi.setAraToplam(gToplam - kdvToplam - iskontoToplam);
            fisi.setGenelToplam(gToplam);
            SatisFisiLine fisiLine;
            ArrayList<SatisFisiLine> list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                fisiLine = new SatisFisiLine();
                fisiLine.setSatisFisiId(fisi);
                fisiLine.setIndirimOrani(round(Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString())));
                fisiLine.setTutar(round(Double.valueOf(model.getValueAt(i, tutarIndex).toString())));
                fisiLine.setBirimFiyati(round(Double.valueOf(model.getValueAt(i, birimFiyatIndex).toString())));
                fisiLine.setMiktar(round(Double.valueOf(model.getValueAt(i, miktarIndex).toString())));
                Urunler urun = (Urunler) model.getValueAt(i, urunAdiIndex);
                fisiLine.setUrunId(urun);
                fisiLine.setAlisFiyati(urun.getUrunAlisFiyat() == null ? 0.00 : urun.getUrunAlisFiyat());
                list.add(fisiLine);
            }
            fisi.setSatisFisiLineList(list);

            SatisFisiController controller = new SatisFisiController(new SatisFisiDaoImpl());
            controller.createSatisFisi(fisi);

            OdemeTurleriLine line = new OdemeTurleriLine();
            line.setOdemeId(odemeTurleri);
            line.setSatisFisiId(fisi.getSatisFisiId());
            line.setTutar(gToplam);
            line.setHesapTuru(OdemeTurleriLine.OdemeHesapTuru.getOdemeHesapTuru(OdemeTurleriLine.OdemeHesapTuru.SATIS));
            OdemeTurleriLineController odemeTurleriLineController = new OdemeTurleriLineController(new OdemeTurleriLineDaoImpl());
            odemeTurleriLineController.createOdemeTurleriLine(line);
            MainUI.getProgress().setStatus(fisi.getSatisFisiId()+ " id satış gerçekleşti");
        }
    }

    public void satisIade(CellStyleTable table, OdemeTurleri odemeTurleri, Kullanici ekleyen) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() != 0) {
            IadeFisi fisi = new IadeFisi();
            fisi.setAciklama(odemeTurleri.getOdemeId()==1?"Nakit Odeme İade":"Kredi Kartı İade");
            fisi.setBelgeNo("");
            Date now = new Date();
            fisi.setFisSaati(now);
            fisi.setFisTarihi(now);
            fisi.setSubeId(new Subeler(1));
            fisi.setSysEkleyen(ekleyen);
            int row = model.getRowCount();
            double iskontoToplam = 0.00;
            double gToplam = 0.00;
            double kdvToplam = 0.00;
            for (int i = 0; i < row; i++) {
                Urunler urunler = (Urunler) model.getValueAt(i, urunAdiIndex);
                Double tutar = round(Double.valueOf(model.getValueAt(i, tutarIndex).toString()));
                kdvToplam += round(tutar * urunler.getUrunKdvGrup().getKdvGrupOran() / 100);
                iskontoToplam += round(Double.valueOf(model.getValueAt(i, indTutarIndex).toString()));
                gToplam += tutar;
            }
            fisi.setIskontoTutari(iskontoToplam);
            if (iskontoToplam == 0) {
                fisi.setIskontoOrani(0);

            } else {
                fisi.setIskontoOrani((gToplam + iskontoToplam) / (iskontoToplam * 100) * 100);

            }
            fisi.setKdvToplam(kdvToplam);
            fisi.setAraToplam(gToplam - kdvToplam - iskontoToplam);
            fisi.setGenelToplam(gToplam);
            IadeFisiLine fisiLine;
            ArrayList<IadeFisiLine> list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                fisiLine = new IadeFisiLine();
                 fisiLine.setIndirimOrani(round(Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString())));
                fisiLine.setTutar(round(Double.valueOf(model.getValueAt(i, tutarIndex).toString())));
                fisiLine.setBirimFiyati(round(Double.valueOf(model.getValueAt(i, birimFiyatIndex).toString())));
                fisiLine.setMiktar(round(Double.valueOf(model.getValueAt(i, miktarIndex).toString())));
                Urunler urun = (Urunler) model.getValueAt(i, urunAdiIndex);
                fisiLine.setUrunId(urun);
                fisiLine.setAlisFiyati(urun.getUrunAlisFiyat() == null ? 0.00 : urun.getUrunAlisFiyat());
                list.add(fisiLine);
            }
            fisi.setIadeFisiLineList(list);

            IadeFisiController controller = new IadeFisiController(new IadeFisiDaoImpl());
            controller.createIadeFisi(fisi);

            OdemeTurleriLine line = new OdemeTurleriLine();
            line.setOdemeId(odemeTurleri);
            line.setSatisFisiId(fisi.getIadeFisiId());
            line.setTutar(-gToplam);
            line.setHesapTuru(OdemeTurleriLine.OdemeHesapTuru.getOdemeHesapTuru(OdemeTurleriLine.OdemeHesapTuru.IADE));
            OdemeTurleriLineController odemeTurleriLineController = new OdemeTurleriLineController(new OdemeTurleriLineDaoImpl());
            odemeTurleriLineController.createOdemeTurleriLine(line);
        }
    }

    public void satisBol(CellStyleTable table, ArrayList<IdValue> odemeList, Kullanici ekleyen) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        if (model.getRowCount() != 0) {
            SatisFisi fisi = new SatisFisi();
            fisi.setAciklama("Satis Ekranı");
            fisi.setBelgeNo("");
            Date now = new Date();
            fisi.setFisSaati(now);
            fisi.setFisTarihi(now);
            fisi.setSubeId(new Subeler(1));
            fisi.setSysEkleyen(ekleyen);
            int row = model.getRowCount();
            double iskontoToplam = 0.00;
            double gToplam = 0.00;
            double kdvToplam = 0.00;
            for (int i = 0; i < row; i++) {
                Urunler urunler = (Urunler) model.getValueAt(i, urunAdiIndex);
                Double tutar = round(Double.valueOf(model.getValueAt(i, tutarIndex).toString()));
                kdvToplam += round(tutar * urunler.getUrunKdvGrup().getKdvGrupOran() / 100);
                iskontoToplam += round(Double.valueOf(model.getValueAt(i, indTutarIndex).toString()));
                gToplam += tutar;
            }
            fisi.setIskontoTutari(iskontoToplam);
            if (iskontoToplam == 0) {
                fisi.setIskontoOrani(0);

            } else {
                fisi.setIskontoOrani((gToplam + iskontoToplam) / (iskontoToplam * 100) * 100);

            }
            fisi.setKdvToplam(kdvToplam);
            fisi.setAraToplam(gToplam - kdvToplam - iskontoToplam);
            fisi.setGenelToplam(gToplam);
            SatisFisiLine fisiLine;
            ArrayList<SatisFisiLine> list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                fisiLine = new SatisFisiLine();
                fisiLine.setSatisFisiId(fisi);
                fisiLine.setIndirimOrani(round(Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString())));
                fisiLine.setTutar(round(Double.valueOf(model.getValueAt(i, tutarIndex).toString())));
                fisiLine.setBirimFiyati(round(Double.valueOf(model.getValueAt(i, birimFiyatIndex).toString())));
                fisiLine.setMiktar(round(Double.valueOf(model.getValueAt(i, miktarIndex).toString())));
                Urunler urun = (Urunler) model.getValueAt(i, urunAdiIndex);
                fisiLine.setUrunId(urun);
                fisiLine.setAlisFiyati(urun.getUrunAlisFiyat() == null ? 0.00 : urun.getUrunAlisFiyat());
                list.add(fisiLine);
            }
            fisi.setSatisFisiLineList(list);

            SatisFisiController controller = new SatisFisiController(new SatisFisiDaoImpl());
            controller.createSatisFisi(fisi);
            OdemeTurleriLineController odemeTurleriLineController = new OdemeTurleriLineController(new OdemeTurleriLineDaoImpl());

            for (IdValue value : odemeList) {
                OdemeTurleriLine line = new OdemeTurleriLine();
                line.setOdemeId(new OdemeTurleri(value.getId()));
                line.setSatisFisiId(fisi.getSatisFisiId());
                line.setHesapTuru(OdemeTurleriLine.OdemeHesapTuru.getOdemeHesapTuru(OdemeTurleriLine.OdemeHesapTuru.SATIS));
                line.setTutar(Double.parseDouble(value.getValue().toString()));
                odemeTurleriLineController.createOdemeTurleriLine(line);

            }
        }
    }

    public void cariSatis(CellStyleTable table, OdemeTurleri odemeTurleri, Kullanici ekleyen, CariHesaplar hesap) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() != 0) {
            CariHesaplarFisi fisi = new CariHesaplarFisi();
            fisi.setAciklama("Cari Satış Ekranı");
            fisi.setBelgeNo("");
            Date now = new Date();
            fisi.setFisSaati(now);
            fisi.setFisTarihi(now);
            fisi.setSubeId(new Subeler(1));
            fisi.setSysEkleyen(ekleyen);
            fisi.setCariHesaplarAdi(hesap.getAdiSoyadi());
            int row = model.getRowCount();
            double iskontoToplam = 0.00;
            double gToplam = 0.00;
            double kdvToplam = 0.00;
            for (int i = 0; i < row; i++) {
                Urunler urunler = (Urunler) model.getValueAt(i, urunAdiIndex);
                Double tutar = round(Double.valueOf(model.getValueAt(i, tutarIndex).toString()));
                kdvToplam += round(tutar * urunler.getUrunKdvGrup().getKdvGrupOran() / 100);
                iskontoToplam += round(Double.valueOf(model.getValueAt(i, indTutarIndex).toString()));
                gToplam += tutar;
            }
            fisi.setIskontoTutari(iskontoToplam);
            if (iskontoToplam == 0) {
                fisi.setIskontoOrani(0);

            } else {
                fisi.setIskontoOrani((gToplam + iskontoToplam) / (iskontoToplam * 100) * 100);

            }
            fisi.setKdvToplam(kdvToplam);
            fisi.setAraToplam(gToplam - kdvToplam - iskontoToplam);
            fisi.setGenelToplam(gToplam);
            CariHesaplarFisiLine fisiLine;
            ArrayList<CariHesaplarFisiLine> list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                fisiLine = new CariHesaplarFisiLine();
                fisiLine.setCariHesaplarFisiId(fisi);
                fisiLine.setIndirimOrani(round(Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString())));
                fisiLine.setTutar(round(Double.valueOf(model.getValueAt(i, tutarIndex).toString())));
                fisiLine.setBirimFiyati(round(Double.valueOf(model.getValueAt(i, birimFiyatIndex).toString())));
                fisiLine.setMiktar(round(Double.valueOf(model.getValueAt(i, miktarIndex).toString())));
                Urunler urun = (Urunler) model.getValueAt(i, urunAdiIndex);
                fisiLine.setUrunId(urun);
                fisiLine.setAlisFiyati(urun.getUrunAlisFiyat() == null ? 0.00 : urun.getUrunAlisFiyat());
                list.add(fisiLine);
            }
            fisi.setSatisFisiLineList(list);

            CariHesaplarFisiController controller = new CariHesaplarFisiController(new CariHesaplarFisiDaoImpl());
            controller.createCariHesaplarFisi(fisi);

            OdemeTurleriLine line = new OdemeTurleriLine();
            line.setOdemeId(odemeTurleri);
            line.setSatisFisiId(fisi.getCariHesapFisiId());
            line.setTutar(gToplam);

            line.setHesapTuru(OdemeTurleriLine.OdemeHesapTuru.getOdemeHesapTuru(OdemeTurleriLine.OdemeHesapTuru.CARI));
            OdemeTurleriLineController odemeTurleriLineController = new OdemeTurleriLineController(new OdemeTurleriLineDaoImpl());
            odemeTurleriLineController.createOdemeTurleriLine(line);
        }
    }
 public void cariSatisIade(CellStyleTable table, OdemeTurleri odemeTurleri, Kullanici ekleyen, CariHesaplar hesap) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() != 0) {
            IadeFisi fisi = new IadeFisi();
            if (odemeTurleri.getOdemeId()==1) {
            fisi.setAciklama("Cari Satis Nakit  İade");
            }else if(odemeTurleri.getOdemeId()==2){
            fisi.setAciklama("Cari Satis Kredi Kartı İade");
            }else{
            fisi.setAciklama("Cari Satis Açık Hesap İade");
            }
            fisi.setBelgeNo("");
            Date now = new Date();
            fisi.setFisSaati(now);
            fisi.setFisTarihi(now);
            fisi.setSubeId(new Subeler(1));
            fisi.setSysEkleyen(ekleyen);
            fisi.setCariHesaplarAdi(hesap.getAdiSoyadi());
            int row = model.getRowCount();
            double iskontoToplam = 0.00;
            double gToplam = 0.00;
            double kdvToplam = 0.00;
            for (int i = 0; i < row; i++) {
                Urunler urunler = (Urunler) model.getValueAt(i, urunAdiIndex);
                Double tutar = round(Double.valueOf(model.getValueAt(i, tutarIndex).toString()));
                kdvToplam += round(tutar * urunler.getUrunKdvGrup().getKdvGrupOran() / 100);
                iskontoToplam += round(Double.valueOf(model.getValueAt(i, indTutarIndex).toString()));
                gToplam += tutar;
            }
            fisi.setIskontoTutari(iskontoToplam);
            if (iskontoToplam == 0) {
                fisi.setIskontoOrani(0);

            } else {
                fisi.setIskontoOrani((gToplam + iskontoToplam) / (iskontoToplam * 100) * 100);

            }
            fisi.setKdvToplam(kdvToplam);
            fisi.setAraToplam(gToplam - kdvToplam - iskontoToplam);
            fisi.setGenelToplam(gToplam);
            IadeFisiLine fisiLine;
            ArrayList<IadeFisiLine> list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                fisiLine = new IadeFisiLine();
                fisiLine.setIndirimOrani(round(Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString())));
                fisiLine.setTutar(round(Double.valueOf(model.getValueAt(i, tutarIndex).toString())));
                fisiLine.setBirimFiyati(round(Double.valueOf(model.getValueAt(i, birimFiyatIndex).toString())));
                fisiLine.setMiktar(round(Double.valueOf(model.getValueAt(i, miktarIndex).toString())));
                Urunler urun = (Urunler) model.getValueAt(i, urunAdiIndex);
                fisiLine.setUrunId(urun);
                fisiLine.setAlisFiyati(urun.getUrunAlisFiyat() == null ? 0.00 : urun.getUrunAlisFiyat());
                list.add(fisiLine);
            }
            fisi.setIadeFisiLineList(list);

            IadeFisiController controller = new IadeFisiController(new IadeFisiDaoImpl());
            controller.createIadeFisi(fisi);

            OdemeTurleriLine line = new OdemeTurleriLine();
            line.setOdemeId(odemeTurleri);
            line.setSatisFisiId(fisi.getIadeFisiId());
            line.setTutar(-gToplam);

            line.setHesapTuru(OdemeTurleriLine.OdemeHesapTuru.getOdemeHesapTuru(OdemeTurleriLine.OdemeHesapTuru.IADE));
            OdemeTurleriLineController odemeTurleriLineController = new OdemeTurleriLineController(new OdemeTurleriLineDaoImpl());
            odemeTurleriLineController.createOdemeTurleriLine(line);
        }
    }

    public void cariSatisBol(CellStyleTable table, ArrayList<IdValue> odemeList, Kullanici ekleyen, CariHesaplar hesap) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        if (model.getRowCount() != 0) {
            CariHesaplarFisi fisi = new CariHesaplarFisi();
            fisi.setAciklama("Satis Ekranı Böl");
            fisi.setBelgeNo("");
            Date now = new Date();
            fisi.setFisSaati(now);
            fisi.setFisTarihi(now);
            fisi.setSubeId(new Subeler(1));
            fisi.setSysEkleyen(ekleyen);
            fisi.setCariHesaplarAdi(hesap.getAdiSoyadi());
            int row = model.getRowCount();
            double iskontoToplam = 0.00;
            double gToplam = 0.00;
            double kdvToplam = 0.00;
            for (int i = 0; i < row; i++) {
                Urunler urunler = (Urunler) model.getValueAt(i, urunAdiIndex);
                Double tutar = round(Double.valueOf(model.getValueAt(i, tutarIndex).toString()));
                kdvToplam += round(tutar * urunler.getUrunKdvGrup().getKdvGrupOran() / 100);
                iskontoToplam += round(Double.valueOf(model.getValueAt(i, indTutarIndex).toString()));
                gToplam += tutar;
            }
            fisi.setIskontoTutari(iskontoToplam);
            if (iskontoToplam == 0) {
                fisi.setIskontoOrani(0);

            } else {
                fisi.setIskontoOrani((gToplam + iskontoToplam) / (iskontoToplam * 100) * 100);

            }
            fisi.setKdvToplam(kdvToplam);
            fisi.setAraToplam(gToplam - kdvToplam - iskontoToplam);
            fisi.setGenelToplam(gToplam);
            CariHesaplarFisiLine fisiLine;
            ArrayList<CariHesaplarFisiLine> list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                fisiLine = new CariHesaplarFisiLine();
                fisiLine.setCariHesaplarFisiId(fisi);
                fisiLine.setIndirimOrani(round(Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString())));
                fisiLine.setTutar(round(Double.valueOf(model.getValueAt(i, tutarIndex).toString())));
                fisiLine.setBirimFiyati(round(Double.valueOf(model.getValueAt(i, birimFiyatIndex).toString())));
                fisiLine.setMiktar(round(Double.valueOf(model.getValueAt(i, miktarIndex).toString())));
                Urunler urun = (Urunler) model.getValueAt(i, urunAdiIndex);
                fisiLine.setUrunId(urun);
                fisiLine.setAlisFiyati(urun.getUrunAlisFiyat() == null ? 0.00 : urun.getUrunAlisFiyat());
                list.add(fisiLine);
            }
            fisi.setSatisFisiLineList(list);

            CariHesaplarFisiController controller = new CariHesaplarFisiController(new CariHesaplarFisiDaoImpl());
            controller.createCariHesaplarFisi(fisi);
            OdemeTurleriLineController odemeTurleriLineController = new OdemeTurleriLineController(new OdemeTurleriLineDaoImpl());

            for (IdValue value : odemeList) {
                OdemeTurleriLine line = new OdemeTurleriLine();
                line.setOdemeId(new OdemeTurleri(value.getId()));
                line.setSatisFisiId(fisi.getCariHesapFisiId());
                line.setHesapTuru(OdemeTurleriLine.OdemeHesapTuru.getOdemeHesapTuru(OdemeTurleriLine.OdemeHesapTuru.CARI));
                line.setTutar(Double.parseDouble(value.getValue().toString()));
                odemeTurleriLineController.createOdemeTurleriLine(line);

            }
        }
    }

    class DummyTableModel extends AbstractMultiTableModel {

        @Override
        public int getRowCount() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getColumnCount() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getColumnType(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getTableIndex(int i) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public static double round(double unrounded) {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return rounded.doubleValue();
    }
}
