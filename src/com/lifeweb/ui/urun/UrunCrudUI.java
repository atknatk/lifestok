package com.lifeweb.ui.urun;

import com.jidesoft.swing.JideTabbedPane;
import com.lifeweb.dao.controller.UrunlerController;
import com.lifeweb.dao.impl.UrunlerDaoImpl;
import com.lifeweb.dao.pojo.KdvGrup;
import com.lifeweb.dao.pojo.Markalar;
import com.lifeweb.dao.pojo.OlcuBirimleri;
import com.lifeweb.dao.pojo.UrunCesit;
import com.lifeweb.dao.pojo.UrunGrup;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.ui.helper.UIConfig;
import com.lifeweb.ui.islemler.ComboBoxModels;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Life
 */
public class UrunCrudUI extends javax.swing.JFrame {

    private final UrunPanelTip tip;
    private final Urunler urun;

    public UrunCrudUI(UrunPanelTip tip, Urunler urun) {
        this.urun = urun;
        this.tip = tip;
        initComponents();
        setLocation(UIConfig.getLocation(this));
        setAlwaysOnTop(true);
        jideTabbedPane1.setTabColorProvider(JideTabbedPane.ONENOTE_COLOR_PROVIDER);
        if (this.tip == UrunPanelTip.DUZENLE) {
            fillField();
            barkodNo.setEditable(false);
            onay.setText("Düzenle");
            setTitle(urun.getUrunAdi());
        } else if (this.tip == UrunPanelTip.INCELE) {
            fillField();
            setEditable(false);
            onay.setVisible(false);
            setTitle(urun.getUrunAdi());
        }
        if (tip == UrunPanelTip.DUZENLE) {
            jCheckBox1.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vazgez = new javax.swing.JButton();
        onay = new javax.swing.JButton();
        jideTabbedPane1 = new com.jidesoft.swing.JideTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        urunAdi = new javax.swing.JTextField();
        barkodNo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        barkodTipi = new com.jidesoft.swing.AutoCompletionComboBox();
        olcuBirimi = new com.jidesoft.swing.AutoCompletionComboBox();
        kdv = new com.jidesoft.swing.AutoCompletionComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        satisFiyati3 = new javax.swing.JFormattedTextField();
        satisFiyati2 = new javax.swing.JFormattedTextField();
        satisFiyati = new javax.swing.JFormattedTextField();
        alisFiyati = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        urunMarkasi = new com.jidesoft.swing.AutoCompletionComboBox();
        casitTanimi = new com.jidesoft.swing.AutoCompletionComboBox();
        urunGrubu = new com.jidesoft.swing.AutoCompletionComboBox();
        durum = new com.jidesoft.swing.AutoCompletionComboBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ureticiKodu = new javax.swing.JTextField();
        garantiSuresi = new javax.swing.JTextField();
        minStokSeviyesi = new javax.swing.JTextField();
        ozelKod = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        bedenKodu = new javax.swing.JTextField();
        renkKodu = new javax.swing.JTextField();
        kasaTransfer = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Yeni Ürün");
        setAlwaysOnTop(true);
        setResizable(false);

        vazgez.setText("Vazgeç");
        vazgez.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vazgezActionPerformed(evt);
            }
        });

        onay.setText("Taman");
        onay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onayActionPerformed(evt);
            }
        });

        jideTabbedPane1.setColorTheme(com.jidesoft.swing.JideTabbedPane.COLOR_THEME_VSNET);
        jideTabbedPane1.setTabShape(com.jidesoft.swing.JideTabbedPane.SHAPE_VSNET);

        jLabel1.setText("Barkod No:");

        jLabel2.setText("Ürün Adı:");

        jLabel3.setText("KDV Grup:");

        urunAdi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                urunAdiFocusGained(evt);
            }
        });

        barkodNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                barkodNoFocusGained(evt);
            }
        });

        jLabel4.setText("Barkod Tipi:");

        jLabel5.setText("Ölçü Birimi:");

        barkodTipi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Artikel", "EAN-8", "EAN-13" }));

        olcuBirimi.setModel(ComboBoxModels.getOlcuBirimiModel());

        kdv.setModel(ComboBoxModels.getKDVModel());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(barkodNo)
                            .addComponent(kdv, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(olcuBirimi, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                            .addComponent(barkodTipi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(urunAdi))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(barkodNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(barkodTipi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(urunAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(olcuBirimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jLabel6.setText("Birim Alış Fiyatı:");

        jLabel7.setText("Birim Satış Fiyatı:");

        jLabel8.setText("Birim Satış Fiyatı 2:");

        jLabel9.setText("Birim Satış Fiyatı 3:");

        satisFiyati3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        satisFiyati3.setText("0,00");
        satisFiyati3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                satisFiyati3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                satisFiyati3FocusLost(evt);
            }
        });

        satisFiyati2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        satisFiyati2.setText("0,00");
        satisFiyati2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                satisFiyati2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                satisFiyati2FocusLost(evt);
            }
        });

        satisFiyati.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        satisFiyati.setText("0,00");
        satisFiyati.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                satisFiyatiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                satisFiyatiFocusLost(evt);
            }
        });

        alisFiyati.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        alisFiyati.setText("0,00");
        alisFiyati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alisFiyatiActionPerformed(evt);
            }
        });
        alisFiyati.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                alisFiyatiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                alisFiyatiFocusLost(evt);
            }
        });

        jLabel10.setText("Ürün Markası:");

        jLabel11.setText("Çeşit Tanımı:");

        jLabel12.setText("Ürün Grubu:");

        jLabel13.setText("Durum:");

        urunMarkasi.setModel(ComboBoxModels.getMarkalarModel());

        casitTanimi.setModel(ComboBoxModels.getUrunCesitModel());

        urunGrubu.setModel(ComboBoxModels.getUrunGrupModel());
        urunGrubu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urunGrubuActionPerformed(evt);
            }
        });

        durum.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pasif", "Aktif" }));
        durum.setSelectedIndex(1);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Diğer Şübeye Kaydet");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(satisFiyati2)
                            .addComponent(satisFiyati)
                            .addComponent(alisFiyati)
                            .addComponent(satisFiyati3, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urunMarkasi, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(urunGrubu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(durum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(casitTanimi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(alisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(urunMarkasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(satisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(casitTanimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(satisFiyati2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(urunGrubu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(satisFiyati3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(durum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jideTabbedPane1.addTab("Yeni Ürün", jPanel4);

        jLabel14.setText("Uretici Kodu:");

        jLabel15.setText("Garanti Süresi (AY):");

        jLabel16.setText("Min. Stok Seviyesi:");

        jLabel17.setText("Özel Kod:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ozelKod, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(minStokSeviyesi, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(garantiSuresi)
                    .addComponent(ureticiKodu))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ureticiKodu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(garantiSuresi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(minStokSeviyesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(ozelKod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jLabel18.setText("Beden Kodu:");

        jLabel19.setText("Renk Kodu:");

        jLabel20.setText("Kasa Transfer:");

        kasaTransfer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Evet", "Hayır" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(kasaTransfer, 0, 116, Short.MAX_VALUE)
                    .addComponent(renkKodu, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(bedenKodu))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(bedenKodu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(renkKodu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(kasaTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jButton3.setText("Resmi Büyüt");

        jButton4.setText("Resim Ekle");

        jButton5.setText("Resim Sil");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton5))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jideTabbedPane1.addTab("Diğer Bilgiler", jPanel5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        jideTabbedPane1.addTab("Mevcut Stoklar", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(onay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vazgez)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jideTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jideTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vazgez)
                    .addComponent(onay))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alisFiyatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alisFiyatiActionPerformed
    }//GEN-LAST:event_alisFiyatiActionPerformed

    private void urunGrubuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urunGrubuActionPerformed
    }//GEN-LAST:event_urunGrubuActionPerformed

    private void onayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onayActionPerformed
        if (tip == UrunPanelTip.KAYDET) {
            kaydet();
            if (jCheckBox1.isSelected()) {
                kaydetDigerSube();
            }
        } else if (tip == UrunPanelTip.DUZENLE) {
            duzenle();
        }
    }//GEN-LAST:event_onayActionPerformed

    private void vazgezActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vazgezActionPerformed
        this.dispose();
    }//GEN-LAST:event_vazgezActionPerformed

    private void barkodNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_barkodNoFocusGained
        barkodNo.selectAll();
    }//GEN-LAST:event_barkodNoFocusGained

    private void urunAdiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_urunAdiFocusGained
        urunAdi.selectAll();
    }//GEN-LAST:event_urunAdiFocusGained

    private void alisFiyatiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alisFiyatiFocusGained
        alisFiyati.selectAll();
    }//GEN-LAST:event_alisFiyatiFocusGained

    private void satisFiyatiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_satisFiyatiFocusGained
        satisFiyati.selectAll();
    }//GEN-LAST:event_satisFiyatiFocusGained

    private void satisFiyati2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_satisFiyati2FocusGained
        satisFiyati2.selectAll();
    }//GEN-LAST:event_satisFiyati2FocusGained

    private void satisFiyati3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_satisFiyati3FocusGained
        satisFiyati3.selectAll();
        
    }//GEN-LAST:event_satisFiyati3FocusGained

    private void satisFiyati2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_satisFiyati2FocusLost
        if (satisFiyati2.getText().contains(",")) {
            satisFiyati2.setText(satisFiyati2.getText().replace(",", "."));
        }
    }//GEN-LAST:event_satisFiyati2FocusLost

    private void satisFiyatiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_satisFiyatiFocusLost
        if (satisFiyati.getText().contains(",")) {
            satisFiyati.setText(satisFiyati.getText().replace(",", "."));
        }
    }//GEN-LAST:event_satisFiyatiFocusLost

    private void satisFiyati3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_satisFiyati3FocusLost
        if (satisFiyati3.getText().contains(",")) {
            satisFiyati3.setText(satisFiyati3.getText().replace(",", "."));
        }
    }//GEN-LAST:event_satisFiyati3FocusLost

    private void alisFiyatiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_alisFiyatiFocusLost
        if (alisFiyati.getText().contains(",")) {
            alisFiyati.setText(alisFiyati.getText().replace(",", "."));
        }
    }//GEN-LAST:event_alisFiyatiFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField alisFiyati;
    private javax.swing.JTextField barkodNo;
    private com.jidesoft.swing.AutoCompletionComboBox barkodTipi;
    private javax.swing.JTextField bedenKodu;
    private com.jidesoft.swing.AutoCompletionComboBox casitTanimi;
    private com.jidesoft.swing.AutoCompletionComboBox durum;
    private javax.swing.JTextField garantiSuresi;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private com.jidesoft.swing.JideTabbedPane jideTabbedPane1;
    private javax.swing.JComboBox kasaTransfer;
    private com.jidesoft.swing.AutoCompletionComboBox kdv;
    private javax.swing.JTextField minStokSeviyesi;
    private com.jidesoft.swing.AutoCompletionComboBox olcuBirimi;
    private javax.swing.JButton onay;
    private javax.swing.JTextField ozelKod;
    private javax.swing.JTextField renkKodu;
    private javax.swing.JFormattedTextField satisFiyati;
    private javax.swing.JFormattedTextField satisFiyati2;
    private javax.swing.JFormattedTextField satisFiyati3;
    private javax.swing.JTextField ureticiKodu;
    private javax.swing.JTextField urunAdi;
    private com.jidesoft.swing.AutoCompletionComboBox urunGrubu;
    private com.jidesoft.swing.AutoCompletionComboBox urunMarkasi;
    private javax.swing.JButton vazgez;
    // End of variables declaration//GEN-END:variables

    private void kaydet() {
        UrunlerController controller = new UrunlerController(new UrunlerDaoImpl());

        label1:
        if (barkodNo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Barkod boş bırakılamaz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
            break label1;
        } else if (urunAdi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ürün Adı boş bırakılamaz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
            break label1;
        } else {
            try {
                Urunler urunler = new Urunler();
                urunler.setBarkodId(barkodNo.getText());
                urunler.setBarkodTur(Short.MIN_VALUE);
                urunler.setBarkodTip(barkodTipi.getSelectedItem().toString());
                urunler.setBirimRef((OlcuBirimleri) olcuBirimi.getSelectedItem());
                urunler.setGrupRef((UrunGrup) urunGrubu.getSelectedItem());
                urunler.setMarkaRef((Markalar) urunMarkasi.getSelectedItem());
                urunler.setUrunAdi(urunAdi.getText());
                urunler.setUrunPid("0");
                urunler.setUrunAktif(durum.getSelectedItem().toString().equals("Aktif") ? new Short("1") : new Short("0"));
                Number value = (Number) alisFiyati.getValue();
                if (value != null) {
                    urunler.setUrunAlisFiyat(value.doubleValue());
                }
                value = (Number) satisFiyati.getValue();
                if (value != null) {
                    urunler.setUrunSatisFiyat(value.doubleValue());
                }
                value = (Number) satisFiyati2.getValue();
                if (value != null) {
                    urunler.setUrunSatisFiyat2(value.doubleValue());
                }
                value = (Number) satisFiyati3.getValue();
                if (value != null) {
                    urunler.setUrunSatisFiyat3(value.floatValue());
                }
                urunler.setUrunCesit((UrunCesit) casitTanimi.getSelectedItem());
                urunler.setUrunDurum(durum.getSelectedItem().toString());
                urunler.setUrunKdvGrup((KdvGrup) kdv.getSelectedItem());
                urunler.setUrunOzelkod(ozelKod.getText());
                urunler.setUrunRenk(renkKodu.getText());
                controller.createUrunler(urunler);
                JOptionPane.showMessageDialog(this, "Ürün Kaydedildi", "Kaydedildi", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException | HeadlessException e) {
                Urunler urunler = null;
                try {
                    urunler = controller.getUrunler(barkodNo.getText());
                } catch (Exception ee) {
                }
                if (urunler != null) {
                    JOptionPane.showMessageDialog(this, urunler.getBarkodId() + " nolu barkod " + urunler.getUrunAdi() + " adlı ürün olarak kayıtlıdır", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Hata Oluştu Tekrar Deneyiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
                }
               e.printStackTrace();
            }
        }
    }
   private void kaydetDigerSube() {
        UrunlerController controller = new UrunlerController(new UrunlerDaoImpl());

        label1:
        if (barkodNo.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Barkod boş bırakılamaz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
            break label1;
        } else if (urunAdi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ürün Adı boş bırakılamaz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
            break label1;
        } else {
            try {
                Urunler urunler = new Urunler();
                urunler.setBarkodId(barkodNo.getText());
                urunler.setBarkodTur(Short.MIN_VALUE);
                urunler.setBarkodTip(barkodTipi.getSelectedItem().toString());
                urunler.setBirimRef((OlcuBirimleri) olcuBirimi.getSelectedItem());
                urunler.setGrupRef((UrunGrup) urunGrubu.getSelectedItem());
                urunler.setMarkaRef((Markalar) urunMarkasi.getSelectedItem());
                urunler.setUrunAdi(urunAdi.getText());
                urunler.setUrunPid("0");
                urunler.setUrunAktif(durum.getSelectedItem().toString().equals("Aktif") ? new Short("1") : new Short("0"));
                Number value = (Number) alisFiyati.getValue();
                if (value != null) {
                    urunler.setUrunAlisFiyat(value.doubleValue());
                }
                value = (Number) satisFiyati.getValue();
                if (value != null) {
                    urunler.setUrunSatisFiyat(value.doubleValue());
                }
                value = (Number) satisFiyati2.getValue();
                if (value != null) {
                    urunler.setUrunSatisFiyat2(value.doubleValue());
                }
                value = (Number) satisFiyati3.getValue();
                if (value != null) {
                    urunler.setUrunSatisFiyat3(value.floatValue());
                }
                urunler.setUrunCesit((UrunCesit) casitTanimi.getSelectedItem());
                urunler.setUrunDurum(durum.getSelectedItem().toString());
                urunler.setUrunKdvGrup((KdvGrup) kdv.getSelectedItem());
                urunler.setUrunOzelkod(ozelKod.getText());
                urunler.setUrunRenk(renkKodu.getText());
                controller.createUrunlerDigerSube(urunler);
                JOptionPane.showMessageDialog(this, "Ürün Diğer Şübeye Kaydedildi", "Kaydedildi", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException | HeadlessException e) {
                Urunler urunler = null;
                if (urunler != null) {
                    JOptionPane.showMessageDialog(this, urunler.getBarkodId() + " nolu barkod " + urunler.getUrunAdi() + " adlı ürün olarak diğer şübede kayıtlıdır", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Hata Oluştu Tekrar Deneyiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
                }
               e.printStackTrace();
            }
        }
    }

    private void duzenle() {
        label1:
        if (urunAdi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ürün Adı boş bırakılamaz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
            break label1;
        } else if (urun != null) {
            try {

                urun.setBarkodTip(barkodTipi.getSelectedItem().toString());
                urun.setBirimRef((OlcuBirimleri) olcuBirimi.getSelectedItem());
                urun.setGrupRef((UrunGrup) urunGrubu.getSelectedItem());
                urun.setMarkaRef((Markalar) urunMarkasi.getSelectedItem());
                urun.setUrunAdi(urunAdi.getText());
                urun.setUrunAktif(durum.getSelectedItem().toString().equals("Aktif") ? new Short("1") : new Short("0"));
                Number value = (Number) alisFiyati.getValue();
                if (value != null) {
                    urun.setUrunAlisFiyat(value.doubleValue());
                }
                value = (Number) satisFiyati.getValue();
                if (value != null) {
                    urun.setUrunSatisFiyat(value.doubleValue());
                }
                value = (Number) satisFiyati2.getValue();
                if (value != null) {
                    urun.setUrunSatisFiyat2(value.doubleValue());
                }
                value = (Number) satisFiyati3.getValue();
                if (value != null) {
                    urun.setUrunSatisFiyat3(value.floatValue());
                }

                urun.setUrunCesit((UrunCesit) casitTanimi.getSelectedItem());
                urun.setUrunDurum(durum.getSelectedItem().toString());
                urun.setUrunKdvGrup((KdvGrup) kdv.getSelectedItem());
                urun.setUrunOzelkod(ozelKod.getText());
                urun.setUrunRenk(renkKodu.getText());
                UrunlerController controller = new UrunlerController(new UrunlerDaoImpl());
                controller.editUrunler(urun);
                JOptionPane.showMessageDialog(this, "Ürün Kaydedildi", "Kaydedildi", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(this, "Hata Oluştu Tekrar Deneyiniz", "Kayıt Hatası", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void fillField() {
        if (urun != null) {
            barkodNo.setText(urun.getBarkodId());
            barkodTipi.setSelectedItem(urun.getBarkodTip());
            olcuBirimi.setSelectedItem(urun.getBirimRef());
            urunGrubu.setSelectedItem(urun.getGrupRef());
            urunMarkasi.setSelectedItem(urun.getMarkaRef());
            urunAdi.setText(urun.getUrunAdi());
            durum.setSelectedIndex(urun.getUrunDurum().equals("Aktif") ? 1 : 0);
            Number value = urun.getUrunAlisFiyat();
            alisFiyati.setValue(value);
            value = urun.getUrunSatisFiyat();
            satisFiyati.setValue(value);
            value = urun.getUrunSatisFiyat2();
            satisFiyati2.setValue(value);
            value = urun.getUrunSatisFiyat3();
            satisFiyati3.setValue(value);
            casitTanimi.setSelectedItem(urun.getUrunCesit());
            kdv.setSelectedItem(urun.getUrunKdvGrup());
            ozelKod.setText(urun.getUrunOzelkod());
            renkKodu.setText(urun.getUrunRenk());
        }
    }

    private void setEditable(Boolean value) {
        if (urun != null) {
            barkodNo.setEditable(value);
            barkodTipi.setEditable(value);
            olcuBirimi.setEditable(value);
            urunGrubu.setEditable(value);
            urunMarkasi.setEditable(value);
            urunAdi.setEditable(value);
            durum.setEditable(value);
            alisFiyati.setEditable(value);
            satisFiyati.setEditable(value);
            satisFiyati2.setEditable(value);
            satisFiyati3.setEditable(value);
            casitTanimi.setEditable(value);
            kdv.setEditable(value);
            ozelKod.setEditable(value);
            renkKodu.setEditable(value);
        }
    }
}
