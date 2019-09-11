/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui;

import com.jidesoft.gauge.Clock;
import com.jidesoft.gauge.DialConicalPaint;
import com.jidesoft.gauge.DialFrame;
import com.jidesoft.gauge.DialLabel;
import com.jidesoft.gauge.DialLabelOrientation;
import com.jidesoft.status.LabelStatusBarItem;
import com.jidesoft.status.MemoryStatusBarItem;
import com.jidesoft.status.OvrInsStatusBarItem;
import com.jidesoft.status.ProgressStatusBarItem;
import com.jidesoft.status.ResizeStatusBarItem;
import com.jidesoft.status.StatusBar;
import com.jidesoft.status.TimeStatusBarItem;
import com.jidesoft.swing.JideBoxLayout;
import com.jidesoft.swing.JideSwingUtilities;
import com.lifeweb.Backup;
import com.lifeweb.dao.pojo.Kullanici;
import com.lifeweb.ui.carihesap.CariHesapUI;
import com.lifeweb.ui.fisler.FislerUI;
import com.lifeweb.ui.helper.Helper;
import com.lifeweb.ui.indirimler.CokTarihIndirim;
import com.lifeweb.ui.indirimler.TekTarihIndirim;
import com.lifeweb.ui.indirimler.TekUrunIndirimDuzenle;
import com.lifeweb.ui.kullanicilar.KullaniciListesi;
import com.lifeweb.ui.report.AylikEkstraPanel;
import com.lifeweb.ui.report.AylikKarPanel;
import com.lifeweb.ui.report.GunlereGoreCiroPanel;
import com.lifeweb.ui.report.GunlereGoreEkstraPanel;
import com.lifeweb.ui.report.GunlereGoreKarPanel;
import com.lifeweb.ui.report.GunlukCiro;
import com.lifeweb.ui.report.GunlukEkstre;
import com.lifeweb.ui.report.GunlukKar;
import com.lifeweb.ui.report.HaftalikEkstraPanel;
import com.lifeweb.ui.report.HaftalikKarPanel;
import com.lifeweb.ui.report.RaporFilter;
import com.lifeweb.ui.satis.SatisUI;
import com.lifeweb.ui.tanimlama.CesitTanimlamaPanel;
import com.lifeweb.ui.tanimlama.GrupTanimlamaPanel;
import com.lifeweb.ui.tanimlama.KdvTanimlamaPanel;
import com.lifeweb.ui.tanimlama.MarkaTanimlamaPanel;
import com.lifeweb.ui.urun.UrunUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Paint;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Life
 */
public final class MainUI extends javax.swing.JFrame {

    private static Kullanici kullanici;
    private static LabelStatusBarItem _label;
    private final boolean VISIBILTY_SHOW = true;
    private static String ip = "";

    public MainUI(Kullanici kullanici) {
        MainUI.kullanici = kullanici;
        initComponents();
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/resources/img/logo16.png")).getImage());

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        loadProperty();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        setTitle("Life Barkodlu Stok Takip Programı");
        StatusBar _statusBar = createStatusBar();
        jPanel1.add(_statusBar);
        getDemoPanel();

        if (kullanici.getYetki().equals("Kasiyer")) {
            jMenu4.setVisible(false);
            jMenu5.setVisible(false);
            jMenu11.setVisible(false);
            jMenu6.setVisible(false);
            jMenu12.setVisible(false);
            jMenu2.setVisible(false);
            jMenu3.setVisible(false);
            jMenu14.setVisible(false);
            jMenu16.setVisible(false);
            //digerSubeMenu.setVisible(false);

        }
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                int i = JOptionPane.showConfirmDialog(MainUI.this, "Yedek almak istiyor musunuz?", "Kapat", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                MainUI.this.dispose();
                if (i == JOptionPane.YES_OPTION) {
                    try {
                        new Backup().metot();
                    } catch (Exception ex) {
                        Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return;
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator19 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        anaPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem11 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenu17 = new javax.swing.JMenu();
        jMenu18 = new javax.swing.JMenu();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu19 = new javax.swing.JMenu();
        jMenuItem41 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem22 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem23 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem24 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem25 = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenuItem27 = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem28 = new javax.swing.JMenuItem();
        jSeparator20 = new javax.swing.JPopupMenu.Separator();
        jMenuItem29 = new javax.swing.JMenuItem();
        jSeparator21 = new javax.swing.JPopupMenu.Separator();
        jMenuItem30 = new javax.swing.JMenuItem();
        jSeparator22 = new javax.swing.JPopupMenu.Separator();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        jMenuItem37 = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem65 = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        jMenuItem68 = new javax.swing.JMenuItem();
        jMenuItem69 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jMenuItem64 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem31 = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem40 = new javax.swing.JMenuItem();

        jMenuItem20.setText("jMenuItem20");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout anaPanelLayout = new javax.swing.GroupLayout(anaPanel);
        anaPanel.setLayout(anaPanelLayout);
        anaPanelLayout.setHorizontalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        anaPanelLayout.setVerticalGroup(
            anaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        jMenu1.setText("Satış");

        jMenuItem1.setText("Satış Ekranı");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ürünler");

        jMenuItem3.setText("Ürünler");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Hesaplar");

        jMenuItem8.setText("Hesaplar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Fişler");

        jMenuItem9.setText("Alım Fişi");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem9);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Tanımlamalar");

        jMenuItem10.setText("Marka Tanımlama");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem10);
        jMenu5.add(jSeparator9);

        jMenuItem11.setText("Çeşit Tanımlama");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);
        jMenu5.add(jSeparator10);

        jMenuItem12.setText("Ürün Grubu Tanımlama");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem12);
        jMenu5.add(jSeparator11);

        jMenuItem13.setText("KDV Tanımlama");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem13);

        jMenuBar1.add(jMenu5);

        jMenu11.setText("İşlemler");

        jMenu17.setText("İndirimler");

        jMenu18.setText("Tek Ürünlü İndirimler");

        jMenuItem42.setText("Ekle");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem42);

        jMenuItem2.setText("Düzenle");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu18.add(jMenuItem2);

        jMenu17.add(jMenu18);

        jMenu19.setText("Birçok Ürünlü İndirimler");

        jMenuItem41.setText("Ekle");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem41);

        jMenu17.add(jMenu19);

        jMenu11.add(jMenu17);
        jMenu11.add(jSeparator12);

        jMenuItem5.setText("Kendi Çeklerim");
        jMenu11.add(jMenuItem5);

        jMenuBar1.add(jMenu11);

        jMenu6.setText("Raporlar");

        jMenu7.setText("Ürün Raporları");

        jMenuItem14.setText("Ürün Listesi Raporu");
        jMenu7.add(jMenuItem14);
        jMenu7.add(jSeparator1);

        jMenuItem15.setText("Ürün Listesi Detay Raporu");
        jMenu7.add(jMenuItem15);
        jMenu7.add(jSeparator2);

        jMenuItem16.setText("Ürün Ekstresi Raporu");
        jMenu7.add(jMenuItem16);
        jMenu7.add(jSeparator3);

        jMenuItem17.setText("Ürün Satış Miktarı");
        jMenu7.add(jMenuItem17);
        jMenu7.add(jSeparator4);

        jMenuItem18.setText("Satılmayan Ürünler Raporu");
        jMenu7.add(jMenuItem18);

        jMenu6.add(jMenu7);
        jMenu6.add(jSeparator13);

        jMenu8.setText("Cari Hesap Raporları");

        jMenuItem19.setText("Cari Hesap Ekstrası");
        jMenu8.add(jMenuItem19);

        jMenuItem21.setText("Cari Hesap Ekstrası (Detaylı)");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem21);
        jMenu8.add(jSeparator5);

        jMenuItem22.setText("Cari Hesap Listesi");
        jMenu8.add(jMenuItem22);
        jMenu8.add(jSeparator6);

        jMenuItem23.setText("Borç / Alacak Raporu");
        jMenu8.add(jMenuItem23);
        jMenu8.add(jSeparator7);

        jMenuItem24.setText("Borçlu Cari Hesaplar");
        jMenu8.add(jMenuItem24);
        jMenu8.add(jSeparator8);

        jMenuItem25.setText("Alacaklı Cari Hesaplar");
        jMenu8.add(jMenuItem25);

        jMenu6.add(jMenu8);
        jMenu6.add(jSeparator14);

        jMenu9.setText("Ciro Raporları");

        jMenuItem26.setText("Gün Sonu Raporu");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem26);
        jMenu9.add(jSeparator16);

        jMenuItem27.setText("Günlere Göre Ciro Raporu");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem27);
        jMenu9.add(jSeparator17);

        jMenuItem28.setText("Haftalara Göre Ciro Raporu");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem28);
        jMenu9.add(jSeparator20);

        jMenuItem29.setText("Aylara Göre Ciro Raporu");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem29);
        jMenu9.add(jSeparator21);

        jMenuItem30.setText("Yıllara Göre Ciro Raporu");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem30);

        jMenu6.add(jMenu9);
        jMenu6.add(jSeparator22);

        jMenu13.setText("Kar Raprları");

        jMenuItem33.setText("Yıllara Göre Kar Raporu");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem33);

        jMenuItem34.setText("Aylara Göre Kar Raporu");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem34);

        jMenuItem35.setText("Haftalara Göre Kar Raporu");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem35);

        jMenuItem36.setText("Günlere Göre Kar Raporu");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem36);

        jMenuItem37.setText("Gün Sonu Kar Raporu");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem37);

        jMenu6.add(jMenu13);
        jMenu6.add(jSeparator15);

        jMenu10.setText("Ödeme Raporları");

        jMenuItem65.setText("Gün Sonu Ödeme  Ekstresi Raporu");
        jMenuItem65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem65ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem65);

        jMenuItem66.setText("Yıllara Göre Ödeme  Ekstresi Raporu");
        jMenuItem66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem66ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem66);

        jMenuItem67.setText("Aylara Göre Ödeme  Ekstresi Raporu");
        jMenuItem67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem67ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem67);

        jMenuItem68.setText("Haftalara Göre Ödeme  Ekstresi Raporu");
        jMenuItem68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem68ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem68);

        jMenuItem69.setText("Günlere Göre Ödeme  Ekstresi Raporu");
        jMenuItem69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem69ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem69);

        jMenu6.add(jMenu10);

        jMenu20.setText("Fiş Raporları");

        jMenuItem64.setText("Satış Dökümü");
        jMenuItem64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem64ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem64);

        jMenu6.add(jMenu20);

        jMenuBar1.add(jMenu6);

        jMenu12.setText("Kullanıcılar");

        jMenuItem6.setText("Kullanıcı Ekle");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem6);

        jMenuItem7.setText("Kullanıcı Sil");
        jMenu12.add(jMenuItem7);

        jMenuItem31.setText("Kullanıcı Düzenle");
        jMenu12.add(jMenuItem31);
        jMenu12.add(jSeparator18);

        jMenuItem32.setText("Kullanıcı Yetkilendirme");
        jMenu12.add(jMenuItem32);

        jMenuBar1.add(jMenu12);

        jMenu14.setText("Pencere");

        jMenuItem4.setText("Saat");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem4);

        jMenuBar1.add(jMenu14);

        jMenu15.setText("Sistem");

        jMenuItem38.setText("Kullanıcı Değiştir");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem38);

        jMenuItem39.setText("Çıkış");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem39);

        jMenuBar1.add(jMenu15);

        jMenu16.setText("Mal Girişi");

        jMenuItem40.setText("Mal Girişi");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem40);

        jMenuBar1.add(jMenu16);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 970, Short.MAX_VALUE)
            .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(anaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new UrunUI(false).setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new CariHesapUI(false, null).setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new FislerUI().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new MarkaTanimlamaPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new CesitTanimlamaPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new GrupTanimlamaPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        new KdvTanimlamaPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new SatisUI().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new KullaniciListesi().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        new GunlukCiro();
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        new AylikKarPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        new GunlukKar();
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        new GunlereGoreKarPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        new GunlereGoreCiroPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        this.dispose();
        new LoginUi().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        getDemoPanel();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        System.exit(1);
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        int n = JOptionPane.showConfirmDialog(MainUI.this, "Diğer şubede değişiklik yapmak istiyor musunuz ?", "Şube Seçimi", JOptionPane.YES_NO_CANCEL_OPTION);
        if (n == JOptionPane.YES_OPTION) {
            new MalGirisi(true).setVisible(VISIBILTY_SHOW);
        } else if (n == JOptionPane.NO_OPTION) {
            new MalGirisi(false).setVisible(VISIBILTY_SHOW);
        }

    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new TekUrunIndirimDuzenle().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        new CokTarihIndirim().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        new TekTarihIndirim().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        new HaftalikKarPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    private void jMenuItem65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem65ActionPerformed
        Date date = new Date();
        new GunlukEkstre(date, date);
    }//GEN-LAST:event_jMenuItem65ActionPerformed

    private void jMenuItem66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem66ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem66ActionPerformed

    private void jMenuItem67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem67ActionPerformed
        new AylikEkstraPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem67ActionPerformed

    private void jMenuItem69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem69ActionPerformed
        new GunlereGoreEkstraPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem69ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem68ActionPerformed
        new HaftalikEkstraPanel().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem68ActionPerformed

    private void jMenuItem64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem64ActionPerformed
        new RaporFilter().setVisible(VISIBILTY_SHOW);
    }//GEN-LAST:event_jMenuItem64ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel anaPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu17;
    private javax.swing.JMenu jMenu18;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem27;
    private javax.swing.JMenuItem jMenuItem28;
    private javax.swing.JMenuItem jMenuItem29;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem30;
    private javax.swing.JMenuItem jMenuItem31;
    private javax.swing.JMenuItem jMenuItem32;
    private javax.swing.JMenuItem jMenuItem33;
    private javax.swing.JMenuItem jMenuItem34;
    private javax.swing.JMenuItem jMenuItem35;
    private javax.swing.JMenuItem jMenuItem36;
    private javax.swing.JMenuItem jMenuItem37;
    private javax.swing.JMenuItem jMenuItem38;
    private javax.swing.JMenuItem jMenuItem39;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem40;
    private javax.swing.JMenuItem jMenuItem41;
    private javax.swing.JMenuItem jMenuItem42;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem64;
    private javax.swing.JMenuItem jMenuItem65;
    private javax.swing.JMenuItem jMenuItem66;
    private javax.swing.JMenuItem jMenuItem67;
    private javax.swing.JMenuItem jMenuItem68;
    private javax.swing.JMenuItem jMenuItem69;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator20;
    private javax.swing.JPopupMenu.Separator jSeparator21;
    private javax.swing.JPopupMenu.Separator jSeparator22;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables
private static ProgressStatusBarItem progress;

    public static StatusBar createStatusBar() {
        // setup status bar
        StatusBar statusBar = new StatusBar();
        progress = new ProgressStatusBarItem();
        progress.setCancelCallback(new ProgressStatusBarItem.CancelCallback() {
            @Override
            public void cancelPerformed() {
                progress.setStatus("İptal Edildi");
                progress.showStatus();
            }
        });
        progress.setStatus("Life Stok Takip Programı");

        statusBar.add(progress, JideBoxLayout.VARY);
        _label = new LabelStatusBarItem();
        _label.setText(kullanici.getAdi() + " " + kullanici.getSoyadi());
        _label.setAlignment(JLabel.CENTER);
        statusBar.add(_label, JideBoxLayout.FLEXIBLE);

        final OvrInsStatusBarItem ovr = new OvrInsStatusBarItem();
        ovr.setPreferredWidth(100);
        ovr.setAlignment(JLabel.CENTER);
        final TimeStatusBarItem time = new TimeStatusBarItem();
        statusBar.add(time, JideBoxLayout.FLEXIBLE);

        statusBar.add(ovr, JideBoxLayout.FLEXIBLE);
        final MemoryStatusBarItem gc = new MemoryStatusBarItem();
        statusBar.add(gc, JideBoxLayout.FIX);

        final ResizeStatusBarItem resize = new ResizeStatusBarItem();
        statusBar.add(resize, JideBoxLayout.FIX);

        return statusBar;
    }
    private Clock clock;
    private DialFrame dialFrame;
    private static final Color w = new Color(250, 250, 250);
    private static final Color lg = new Color(175, 175, 180);
    private static final Color g = new Color(170, 170, 175);
    private static final Color dg = new Color(140, 140, 145);
    private DialLabel upperLabel, lowerLabel;

    public void getDemoPanel() {
        Helper.instance();
        anaPanel.removeAll();
        anaPanel.setLayout(new BorderLayout());
        clock = new Clock();
        Border outerBorder = BorderFactory.createEtchedBorder();
        Border innerBorder = new EmptyBorder(20, 20, 20, 20);
        clock.setBorder(new CompoundBorder(outerBorder, innerBorder));
        clock.setDialBackground(JideSwingUtilities.getLinearGradientPaint(0f, 0f, 0f, 450f, new float[]{0f, 1f},
                new Color[]{Color.white, Color.lightGray}));
        clock.setResizeFonts(true);
        clock.setShadowVisible(false);
        anaPanel.add(clock, BorderLayout.CENTER);
        anaPanel.setPreferredSize(new Dimension(450, 450));
        dialFrame = new DialFrame();
        clock.setFrame(dialFrame);
        upperLabel = new DialLabel(clock, 0.4, 90, Helper.getConfigs().get("title"));
        upperLabel.setColor(Color.gray);
        clock.addDrawable(upperLabel);
        lowerLabel = new DialLabel(clock, 0.4, -90, "Antalya / Serik");
        lowerLabel.setColor(Color.gray);
        clock.addDrawable(lowerLabel);
        float[] angles = {15f, 30f, 45f, 75f, 105f, 120f, 135f, 165f, 190f, 210f, 230f, 255f, 280f, 300, 320f, 345f};
        final Color[] colors = {lg, w, lg, dg, lg, w, lg, dg, lg, w, lg, dg, lg, w, lg, dg};
        Paint dialPaint = new DialConicalPaint(clock, angles, colors);
        clock.setFacePaint(dialPaint);
        clock.setShadowVisible(true);
        Color b = Color.black;
        Color wh = Color.white;
        final float[] angles2 = {0f, 45f, 75f, 90f, 115f, 135f, 170f, 210f, 270f, 330f};
        final Color[] colors2 = {b, g, b, wh, b, g, b, g, b, g};
        Paint framePaint = new DialConicalPaint(clock, angles2, colors2);
        dialFrame.setFill(framePaint);
        upperLabel.setColor(Color.darkGray);
        lowerLabel.setColor(Color.darkGray);
        DialLabelOrientation orientation = DialLabelOrientation.UPRIGHT;
        clock.getAxis().setLabelOrientation(orientation);
        clock.update();
    }

    public static JPanel getAnaPanel() {
        return anaPanel;
    }

    private void loadProperty() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("config.properties"));
            ip = prop.getProperty("sql_ip");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private void write() {
        Properties prop = new Properties();

        try {
            //set the properties value
            prop.setProperty("sql_ip", "localhost");
            prop.setProperty("title", "Çınaraltı Kozmetik");

            prop.store(new FileOutputStream("config.properties"), null);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getIp() {
        return ip;
    }

    public static ProgressStatusBarItem getProgress() {
        return progress;
    }

}
