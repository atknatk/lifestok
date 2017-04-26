package com.lifeweb.ui.carihesap;

import com.lifeweb.dao.controller.CariHesaplarController;
import com.lifeweb.dao.impl.CariHesaplarDaoImpl;
import com.lifeweb.dao.pojo.CariHesaplar;
import com.lifeweb.ui.helper.UIConfig;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Life
 */
public class CariHesapCrudUI extends javax.swing.JFrame {

    private CariHesapPanelTip cariHesapPanelTip;
    private CariHesaplar cariHesap;

    public CariHesapCrudUI(CariHesapPanelTip cariHesapPanelTip, CariHesaplar cariHesap) {
        this.cariHesap = cariHesap;
        this.cariHesapPanelTip = cariHesapPanelTip;
        initComponents();
        setLocation(UIConfig.getLocation(this));
        if (cariHesapPanelTip == CariHesapPanelTip.DUZENLE) {
            fillField();
            onayButton.setText("Düzenle");
            setTitle(cariHesap.getAdiSoyadi());
        } else if (cariHesapPanelTip == CariHesapPanelTip.INCELE) {
            fillField();
            setEditable(false);
            onayButton.setVisible(false);
            setTitle(cariHesap.getAdiSoyadi());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField17 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kartNo = new javax.swing.JTextField();
        hesapAdi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        hesapTuru = new com.jidesoft.swing.AutoCompletionComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        YetkiliKisi = new javax.swing.JTextField();
        telefon1 = new javax.swing.JTextField();
        telefon2 = new javax.swing.JTextField();
        faxNo = new javax.swing.JTextField();
        ozelKodu = new javax.swing.JTextField();
        satisFiyati = new com.jidesoft.swing.AutoCompletionComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        adres1 = new javax.swing.JTextField();
        adres2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        semt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        sehir = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        vergiDairesi = new javax.swing.JTextField();
        vergiNumarasi = new javax.swing.JTextField();
        eposta = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        iskontoOrani = new javax.swing.JFormattedTextField();
        riskLimiti = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        onayButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jTextField17.setText("jTextField17");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Yeni Hesap");
        setAlwaysOnTop(true);
        setType(java.awt.Window.Type.UTILITY);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(119, 197, 229), 1, true));

        jLabel1.setText("Kart No");

        jLabel2.setText("Hesap Adı");

        jLabel3.setText("Hesap Türü");

        hesapTuru.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ALICI", "SATICI", "ALICI+SATICI" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hesapAdi)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kartNo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(0, 115, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hesapTuru, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kartNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hesapTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hesapAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(119, 197, 229), 1, true));

        jLabel4.setText("Yetkili Kişi");

        jLabel6.setText("Telefon 1");

        jLabel7.setText("Fax No");

        jLabel8.setText("Telefon 2");

        jLabel9.setText("Özel Kodu");

        jLabel10.setText("Özel Satış Fiyatı:");

        telefon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefon1ActionPerformed(evt);
            }
        });

        satisFiyati.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YOK", "SATIŞ FİYATI 1", "SATIŞ FİYATI 2", "SATIŞ FİYATI 3" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(YetkiliKisi)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(telefon1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(telefon2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(faxNo)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(ozelKodu)
                            .addComponent(satisFiyati, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(YetkiliKisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(faxNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ozelKodu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(satisFiyati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(119, 197, 229), 1, true));

        jLabel5.setText("Adres");

        jLabel11.setText("Semt");

        jLabel12.setText("Şehir");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adres2)
                    .addComponent(adres1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(semt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sehir)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adres1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(adres2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sehir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(119, 197, 229), 1, true));

        jLabel13.setText("Vergi Dairesi");

        jLabel14.setText("Vergi Numarası");

        jLabel17.setText("E-Posta Adresi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eposta)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(vergiDairesi, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vergiNumarasi))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel14)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vergiDairesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vergiNumarasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(119, 197, 229), 1, true));

        jLabel18.setText("İskonto Oranı(%)");

        jLabel19.setText("Risk Limiti");

        iskontoOrani.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        iskontoOrani.setText("0");

        riskLimiti.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        riskLimiti.setText("0,00");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 69, Short.MAX_VALUE))
                    .addComponent(iskontoOrani))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(riskLimiti, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iskontoOrani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(riskLimiti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jButton2.setText("Vazgeç");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        onayButton.setText("Tamam");
        onayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(onayButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(onayButton))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telefon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefon1ActionPerformed
    }//GEN-LAST:event_telefon1ActionPerformed

    private void onayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onayButtonActionPerformed
        if (cariHesapPanelTip == CariHesapPanelTip.KAYDET) {
            kaydet();
        } else if (cariHesapPanelTip == CariHesapPanelTip.DUZENLE) {
            duzenle();
        }
    }//GEN-LAST:event_onayButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField YetkiliKisi;
    private javax.swing.JTextField adres1;
    private javax.swing.JTextField adres2;
    private javax.swing.JTextField eposta;
    private javax.swing.JTextField faxNo;
    private javax.swing.JTextField hesapAdi;
    private com.jidesoft.swing.AutoCompletionComboBox hesapTuru;
    private javax.swing.JFormattedTextField iskontoOrani;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField kartNo;
    private javax.swing.JButton onayButton;
    private javax.swing.JTextField ozelKodu;
    private javax.swing.JFormattedTextField riskLimiti;
    private com.jidesoft.swing.AutoCompletionComboBox satisFiyati;
    private javax.swing.JTextField sehir;
    private javax.swing.JTextField semt;
    private javax.swing.JTextField telefon1;
    private javax.swing.JTextField telefon2;
    private javax.swing.JTextField vergiDairesi;
    private javax.swing.JTextField vergiNumarasi;
    // End of variables declaration//GEN-END:variables

    private void kaydet() {
        try {
            CariHesaplar cariHesaplar = new CariHesaplar();
            cariHesaplar.setAdiSoyadi(hesapAdi.getText());
            cariHesaplar.setAdres(adres1.getText());
            cariHesaplar.setAdres2(adres2.getText());
            cariHesaplar.setCariAktif(1);
            Number value = (Number) iskontoOrani.getValue();
            cariHesaplar.setCariIskonto(value != null ? value.intValue() : 0);
            cariHesaplar.setEposta(eposta.getText());
            cariHesaplar.setFaxno(faxNo.getText());
            cariHesaplar.setMusteriNo(kartNo.getText());
            Short s = null;
            if (satisFiyati.getSelectedIndex() == 0) {
                s = 00;
            } else if (satisFiyati.getSelectedIndex() == 1) {
                s = 01;
            } else if (satisFiyati.getSelectedIndex() == 2) {
                s = 10;
            } else if (satisFiyati.getSelectedIndex() == 3) {
                s = 11;
            }
            cariHesaplar.setOzelFiyat(s);
            cariHesaplar.setOzelKod(ozelKodu.getText());
            value = (Number) riskLimiti.getValue();
            cariHesaplar.setRiskLimit(value == null ? 0 : value.doubleValue());
            cariHesaplar.setSehir(sehir.getText());
            cariHesaplar.setSemt(semt.getText());
            cariHesaplar.setTelefon1(telefon1.getText());
            cariHesaplar.setTelefon2(telefon2.getText());
            cariHesaplar.setTuru(hesapTuru.getSelectedItem().toString());
            cariHesaplar.setVergiDairesi(vergiDairesi.getText());
            cariHesaplar.setVergiNo(vergiNumarasi.getText());
            cariHesaplar.setYetkili(YetkiliKisi.getText());
            CariHesaplarController controller = new CariHesaplarController(new CariHesaplarDaoImpl());
            controller.createCariHesaplar(cariHesaplar);
            JOptionPane.showMessageDialog(this, "Hesap Kaydedildi", "Kaydedildi", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Hata Oluştu", "Hata", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void duzenle() {
        if (cariHesap != null) {
            try {
                CariHesaplar cariHesaplar = cariHesap;
                cariHesaplar.setAdiSoyadi(hesapAdi.getText());
                cariHesaplar.setAdres(adres1.getText());
                cariHesaplar.setAdres2(adres2.getText());
                cariHesaplar.setCariAktif(1);
                Number value = (Number) iskontoOrani.getValue();
                cariHesaplar.setCariIskonto(value != null ? value.intValue() : 0);
                cariHesaplar.setEposta(eposta.getText());
                cariHesaplar.setFaxno(faxNo.getText());
                cariHesaplar.setMusteriNo(kartNo.getText());
                Short s = null;
                if (satisFiyati.getSelectedIndex() == 0) {
                    s = 00;
                } else if (satisFiyati.getSelectedIndex() == 1) {
                    s = 01;
                } else if (satisFiyati.getSelectedIndex() == 2) {
                    s = 10;
                } else if (satisFiyati.getSelectedIndex() == 3) {
                    s = 11;
                }
                cariHesaplar.setOzelFiyat(s);
                cariHesaplar.setOzelKod(ozelKodu.getText());
                value = (Number) riskLimiti.getValue();
                cariHesaplar.setRiskLimit(value == null ? 0 : value.doubleValue());
                cariHesaplar.setSehir(sehir.getText());
                cariHesaplar.setSemt(semt.getText());
                cariHesaplar.setTelefon1(telefon1.getText());
                cariHesaplar.setTelefon2(telefon2.getText());
                cariHesaplar.setTuru(hesapTuru.getSelectedItem().toString());
                cariHesaplar.setVergiDairesi(vergiDairesi.getText());
                cariHesaplar.setVergiNo(vergiNumarasi.getText());
                cariHesaplar.setYetkili(YetkiliKisi.getText());
//                CariHesaplarJpaController controller = new CariHesaplarJpaController(EntityHelper.getEmf());
//                try {
//                    controller.edit(cariHesaplar);
//                } catch (Exception ex) {
//                    Logger.getLogger(CariHesapCrudUI.class.getName()).log(Level.SEVERE, null, ex);
//                }
                JOptionPane.showMessageDialog(this, "Hesap Kaydedildi", "Kaydedildi", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Hata Oluştu", "Hata", JOptionPane.ERROR_MESSAGE);

            }
        }

    }

    private void fillField() {
        if (cariHesap != null) {
            hesapAdi.setText(cariHesap.getAdiSoyadi());
            adres1.setText(cariHesap.getAdres());
            adres2.setText(cariHesap.getAdres2());
            Number value = cariHesap.getCariIskonto();
            iskontoOrani.setValue(value != null ? value : 0);
            eposta.setText(cariHesap.getEposta());
            faxNo.setText(cariHesap.getFaxno());
            kartNo.setText(cariHesap.getMusteriNo());
            Short s = cariHesap.getOzelFiyat();
            if (s == 00) {
                satisFiyati.setSelectedIndex(0);
            } else if (s == 01) {
                satisFiyati.setSelectedIndex(1);
            } else if (s == 10) {
                satisFiyati.setSelectedIndex(2);
            } else if (s == 11) {
                satisFiyati.setSelectedIndex(3);
            }
            ozelKodu.setText(cariHesap.getOzelKod());
            value = cariHesap.getRiskLimit();
            riskLimiti.setValue(value == null ? 0 : value);
            sehir.setText(cariHesap.getSehir());
            semt.setText(cariHesap.getSemt());
            telefon1.setText(cariHesap.getTelefon1());
            telefon2.setText(cariHesap.getTelefon2());
            hesapTuru.setSelectedItem(cariHesap.getTuru());
            vergiDairesi.setText(cariHesap.getVergiDairesi());
            vergiNumarasi.setText(cariHesap.getVergiNo());
            YetkiliKisi.setText(cariHesap.getYetkili());
        }
    }

    private void setEditable(Boolean value) {
        if (cariHesap != null) {
            hesapAdi.setEditable(value);
            adres1.setEditable(value);
            adres2.setEditable(value);
            iskontoOrani.setEditable(value);
            eposta.setEditable(value);
            faxNo.setEditable(value);
            kartNo.setEditable(value);
            satisFiyati.setEditable(value);
            ozelKodu.setEditable(value);
            riskLimiti.setEditable(value);
            sehir.setEditable(value);
            semt.setEditable(value);
            telefon1.setEditable(value);
            telefon2.setEditable(value);
            hesapTuru.setEditable(value);
            vergiDairesi.setEditable(value);
            vergiNumarasi.setEditable(value);
            YetkiliKisi.setEditable(value);
        }
    }
}
