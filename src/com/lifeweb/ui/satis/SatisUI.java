package com.lifeweb.ui.satis;

import com.jidesoft.grid.CellStyleTable;
import com.jidesoft.grid.RowStripeTableStyleProvider;
import com.jidesoft.status.StatusBar;
import com.lifeweb.LifewebSession;
import com.lifeweb.dao.controller.IndirimlerController;
import com.lifeweb.dao.controller.UrunlerController;
import com.lifeweb.dao.impl.IndirimlerDaoImpl;
import com.lifeweb.dao.impl.UrunlerDaoImpl;
import com.lifeweb.dao.pojo.CariHesaplar;
import com.lifeweb.dao.pojo.IndirimAltGrup;
import com.lifeweb.dao.pojo.Indirimler;
import com.lifeweb.dao.pojo.OdemeTurleri;
import com.lifeweb.dao.pojo.Urunler;
import com.lifeweb.ui.MainUI;
import com.lifeweb.ui.carihesap.CariHesapUI;
import com.lifeweb.ui.helper.BlinkLabel;
import com.lifeweb.ui.helper.KeyPressTool;
import com.lifeweb.ui.helper.UIConfig;
import com.lifeweb.ui.islemler.NumberRenderer;
import com.lifeweb.ui.islemler.RowNumberTable;
import com.lifeweb.ui.islemler.SatisIslemi;
import com.lifeweb.ui.islemler.SatisTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class SatisUI extends javax.swing.JFrame {

    protected final Color BACKGROUND1 = new Color(253, 253, 220);
    protected final Color BACKGROUND2 = new Color(255, 255, 255);
    private CariHesaplar hesap;
    private final static Logger LOGGER = Logger.getLogger(SatisUI.class.getName());
    List<Indirimler> indirimlerList = null;
    DefaultTableModel model;
    private static double adet = 1;

    public SatisUI() {
        model = (DefaultTableModel) SatisTableModel.satisTableModel();
        initComponents();
        setTitle(LifewebSession.instance().getKullanici().toString() + " Satış Ekranı");
        UIConfig.getLocationFull(SatisUI.this);
        //setIconImage(new javax.swing.ImageIcon(getClass().getResource("/resources/img/logo16.png")).getImage());
        UIManager.put("ToggleButton.select", Color.RED);
        SwingUtilities.updateComponentTreeUI(satisIade);

        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        IndirimlerController controller = new IndirimlerController(new IndirimlerDaoImpl());
        indirimlerList = controller.getIndirimlerList();
        tableConfig();
        StatusBar _statusBar = MainUI.createStatusBar();
        statusPanel.add(_statusBar);

        table.setTableStyleProvider(new RowStripeTableStyleProvider(new Color[]{BACKGROUND1, BACKGROUND2}));
        RowNumberTable.setRowNumber(jScrollPane2, table);
        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "focus");
        getRootPane().getActionMap().put("focus", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                barkodField.requestFocus();
                barkodField.selectAll();
            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "pesin");
        getRootPane().getActionMap().put("pesin", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //    pesinSatAction();
                if (KeyPressTool.isDoublePress(e, KeyEvent.VK_SPACE) && KeyPressTool.lastKeyPressedCode == KeyEvent.VK_SPACE) {
                    pesinSatAction();
                }
            }
        });
        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), "adet");
        getRootPane().getActionMap().put("adet", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdetForm().setVisible(true);
            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "kredi");
        getRootPane().getActionMap().put("kredi", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                krediSatAction();
            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "sf1");
        getRootPane().getActionMap().put("sf1", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fiyat1.setSelected(true);
            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "sf2");
        getRootPane().getActionMap().put("sf2", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fiyat2.setSelected(true);
            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "sf3");
        getRootPane().getActionMap().put("sf3", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fiyat3.setSelected(true);
            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "miktar");
        getRootPane().getActionMap().put("miktar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.requestFocus();
                int miktarIndex = table.getColumnModel().getColumnIndex("MİKTAR");
                table.editCellAt(table.getRowCount() - 1, miktarIndex);

            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "indoran");
        getRootPane().getActionMap().put("indoran", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.requestFocus();
                int miktarIndex = table.getColumnModel().getColumnIndex("İND. %");
                table.editCellAt(table.getRowCount() - 1, miktarIndex);

            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "indtutar");
        getRootPane().getActionMap().put("indtutar", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.requestFocus();
                int miktarIndex = table.getColumnModel().getColumnIndex("İND. TUTAR");
                table.editCellAt(table.getRowCount() - 1, miktarIndex);

            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "topluind");
        getRootPane().getActionMap().put("topluind", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextField3.requestFocus();
                jTextField3.select(1, jTextField3.getText().length());

            }
        });

        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "alinanpara");
        getRootPane().getActionMap().put("alinanpara", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFormattedTextField1.requestFocus();
                jFormattedTextField1.selectAll();

            }
        });
        getRootPane().getInputMap(JRootPane.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, 0), "satisIptal");
        getRootPane().getActionMap().put("satisIptal", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                satisEkraniSifirla();
                barkodField.requestFocus();
            }
        });

        if (LifewebSession.instance().getKullanici().getYetki().equals("Kasiyer")) {
            satisIade.setEnabled(false);
            jButton3.setEnabled(false);
        }

    }

    public JTextField getBarkodField() {
        return barkodField;
    }

    public JTextField getCariField() {
        return cariField;
    }

    public CariHesaplar getHesap() {
        return hesap;
    }

    public void setHesap(CariHesaplar hesap) {
        this.hesap = hesap;
    }

    private void blink() {
        blinkLabel = new BlinkLabel("");
        blinkLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel4.removeAll();
        jPanel4.add(blinkLabel);
        jPanel4.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        tutarField = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        fiyat1 = new javax.swing.JToggleButton();
        fiyat2 = new javax.swing.JToggleButton();
        fiyat3 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        satisIade = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        cariField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        paraUstuLabel = new javax.swing.JTextField();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel7 = new javax.swing.JPanel();
        miktarLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        urunAdiLabel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        acikHesap = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new SatisTable(model);
        jPanel12 = new javax.swing.JPanel();
        barkodField = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        urunFiyatLabel = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tutarField.setEditable(false);
        tutarField.setBackground(new java.awt.Color(255, 0, 0));
        tutarField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        tutarField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tutarField.setText("0,00");
        tutarField.setToolTipText("");
        tutarField.setFont(new java.awt.Font("Tahoma", 1, 44)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tutarField)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tutarField)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonGroup1.add(fiyat1);
        fiyat1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fiyat1.setSelected(true);
        fiyat1.setText("SF 1");
        fiyat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiyat1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(fiyat2);
        fiyat2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fiyat2.setText("SF 2");
        fiyat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiyat2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(fiyat3);
        fiyat3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fiyat3.setText("SF 3");
        fiyat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiyat3ActionPerformed(evt);
            }
        });

        jButton1.setText("Ödeme Böl");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Satış İptal");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        satisIade.setText("Satış İade");
        satisIade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satisIadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(satisIade, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fiyat1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fiyat2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fiyat3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiyat1)
                    .addComponent(fiyat2)
                    .addComponent(fiyat3))
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(satisIade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cari Hesap", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        cariField.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        cariField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cariFieldFocusLost(evt);
            }
        });

        jButton4.setText("..");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cariField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariField)
                    .addComponent(jButton4))
                .addGap(6, 6, 6))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("İskonto Oranı");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("İskonto Tutarı");

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField3.setText("%0");
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.setText("0,00");
        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jTextField3))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Alınan Para");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Para Üstü");

        paraUstuLabel.setEditable(false);
        paraUstuLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        paraUstuLabel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        paraUstuLabel.setText("0,00");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jFormattedTextField1.setText("0,00");
        jFormattedTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jFormattedTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextField1MouseClicked(evt);
            }
        });
        jFormattedTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField1FocusLost(evt);
            }
        });
        jFormattedTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextField1PropertyChange(evt);
            }
        });
        jFormattedTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFormattedTextField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField1))
                .addGap(6, 6, 6)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(paraUstuLabel))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(paraUstuLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        miktarLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        miktarLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        miktarLabel.setText("1");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miktarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(miktarLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel7.setBackground(new java.awt.Color(241, 248, 32));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("x");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        urunAdiLabel.setBackground(new java.awt.Color(241, 248, 32));
        urunAdiLabel.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        urunAdiLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        urunAdiLabel.setText("Ürün Adı");
        urunAdiLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(urunAdiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(urunAdiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel10.setLayout(new java.awt.GridLayout(1, 10, 5, 5));

        acikHesap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acikHesap.setText("Açık Hesap");
        acikHesap.setEnabled(false);
        acikHesap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acikHesapActionPerformed(evt);
            }
        });
        jPanel10.add(acikHesap);

        jButton7.setBackground(new java.awt.Color(0, 0, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Peşin - F1");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton7);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Kredi Kartı - F2");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton8);
        jPanel10.add(jLabel9);
        jPanel10.add(jLabel10);
        jPanel10.add(jLabel12);
        jPanel10.add(jLabel11);

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Barkod No", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        barkodField.setBackground(new java.awt.Color(238, 183, 45));
        barkodField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        barkodField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barkodFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barkodField)
                .addGap(5, 5, 5))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(barkodField, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        urunFiyatLabel.setBackground(new java.awt.Color(241, 248, 32));
        urunFiyatLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        urunFiyatLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        urunFiyatLabel.setText("0,00");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(urunFiyatLabel)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(urunFiyatLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        statusPanel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyReleased
    }//GEN-LAST:event_jFormattedTextField1KeyReleased

    private void jFormattedTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextField1MouseClicked
        jFormattedTextField1.selectAll();
    }//GEN-LAST:event_jFormattedTextField1MouseClicked

    private void jFormattedTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField1KeyTyped
    }//GEN-LAST:event_jFormattedTextField1KeyTyped

    private void jFormattedTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField1FocusLost
    }//GEN-LAST:event_jFormattedTextField1FocusLost

    private void jFormattedTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextField1PropertyChange
        try {
            Number tutar = (Number) tutarField.getValue();
            if (tutar != null) {

                Number value = (Number) jFormattedTextField1.getValue();
                if (value != null) {
                    paraUstuLabel.setText(String.valueOf(round(value.doubleValue() - tutar.doubleValue())));
                }
            }
        } catch (Exception e) {
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), SatisUI.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);

        }

    }//GEN-LAST:event_jFormattedTextField1PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new CariHesapUI(Boolean.TRUE, SatisUI.this).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void barkodFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barkodFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            barkodRead();
        }
    }//GEN-LAST:event_barkodFieldKeyPressed

    private void fiyat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiyat2ActionPerformed
        fiyatDegistir();
    }//GEN-LAST:event_fiyat2ActionPerformed

    private void fiyat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiyat1ActionPerformed
        fiyatDegistir();
    }//GEN-LAST:event_fiyat1ActionPerformed

    private void fiyat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiyat3ActionPerformed
        fiyatDegistir();
    }//GEN-LAST:event_fiyat3ActionPerformed

    private void cariFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cariFieldFocusLost
        if (cariField.getText().equals("")) {
            acikHesap.setEnabled(false);
        } else {
            acikHesap.setEnabled(true);
            barkodField.requestFocusInWindow();
        }
    }//GEN-LAST:event_cariFieldFocusLost

    public static double round(double unrounded) {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return rounded.doubleValue();
    }

    public static double round9(double unrounded) {
        BigDecimal bd = new BigDecimal(unrounded);
        BigDecimal rounded = bd.setScale(9, BigDecimal.ROUND_HALF_UP);
        return rounded.doubleValue();
    }
    private void acikHesapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acikHesapActionPerformed
        cariSatAction();
    }//GEN-LAST:event_acikHesapActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        pesinSatAction();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        krediSatAction();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
            if (table.getSelectedRow() != -1) {
                int[] rows = table.getSelectedRows();
                DefaultTableModel modell = (DefaultTableModel) table.getModel();
                int z = 0;
                for (int i : rows) {
                    modell.removeRow(i - z);
                    z++;
                }
                table.setModel(modell);
                setToplamFiyat();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (table.getSelectedRow() != -1) {
                DefaultTableModel modelz = (DefaultTableModel) table.getModel();
                TableColumnModel columnModel = table.getColumnModel();
                final int urunAdiIndex = columnModel.getColumnIndex("ÜRÜN ADI");
                final int miktarIndex = columnModel.getColumnIndex("MİKTAR");
                final int birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
                miktarLabel.setText(modelz.getValueAt(table.getSelectedRow(), miktarIndex).toString());
                urunFiyatLabel.setText(modelz.getValueAt(table.getSelectedRow(), birimFiyatIndex).toString());
                urunAdiLabel.setText(modelz.getValueAt(table.getSelectedRow(), urunAdiIndex).toString());
                String urunAdi = modelz.getValueAt(table.getSelectedRow(), urunAdiIndex).toString();
                if (urunAdi.length() > 30) {
                    urunAdiLabel.setText(urunAdi.substring(0, 30) + " ...");

                } else {
                    urunAdiLabel.setText(urunAdi);
                }
            }
            barkodField.requestFocus();
            barkodField.selectAll();
        } else {
            if (table.getSelectedRow() != -1) {
                DefaultTableModel modelk = (DefaultTableModel) table.getModel();
                TableColumnModel columnModel = table.getColumnModel();
                final int urunAdiIndex = columnModel.getColumnIndex("ÜRÜN ADI");
                final int miktarIndex = columnModel.getColumnIndex("MİKTAR");
                final int birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
                miktarLabel.setText(modelk.getValueAt(table.getSelectedRow(), miktarIndex).toString());
                urunFiyatLabel.setText(modelk.getValueAt(table.getSelectedRow(), birimFiyatIndex).toString());
                urunAdiLabel.setText(modelk.getValueAt(table.getSelectedRow(), urunAdiIndex).toString());
                String urunAdi = modelk.getValueAt(table.getSelectedRow(), urunAdiIndex).toString();
                if (urunAdi.length() > 30) {
                    urunAdiLabel.setText(urunAdi.substring(0, 30) + " ...");

                } else {
                    urunAdiLabel.setText(urunAdi);
                }
            }
        }
    }//GEN-LAST:event_tableKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (table.getSelectedRow() != -1) {
            TableColumnModel columnModel = table.getColumnModel();
            final int urunAdiIndex = columnModel.getColumnIndex("ÜRÜN ADI");
            final int miktarIndex = columnModel.getColumnIndex("MİKTAR");
            final int birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
            miktarLabel.setText(model.getValueAt(table.getSelectedRow(), miktarIndex).toString());
            urunFiyatLabel.setText(model.getValueAt(table.getSelectedRow(), birimFiyatIndex).toString());
            String urunAdi = model.getValueAt(table.getSelectedRow(), urunAdiIndex).toString();
            if (urunAdi.length() > 30) {
                urunAdiLabel.setText(urunAdi.substring(0, 30) + " ...");

            } else {
                urunAdiLabel.setText(urunAdi);
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        yuzdeIndirimUygula();
    }//GEN-LAST:event_jTextField3FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new OdemeBolPanel(acikHesap.isEnabled(), Double.parseDouble(tutarField.getText()), SatisUI.this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        satisEkraniSifirla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_F2) {
            pesinSatAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_3) {
            krediSatAction();
        }
    }//GEN-LAST:event_formKeyReleased

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (KeyPressTool.isDoublePress(evt) && KeyPressTool.lastKeyPressedCode == evt.getKeyCode()) {
            System.out.println("keySpace");
        }
    }//GEN-LAST:event_formKeyPressed

    private void satisIadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satisIadeActionPerformed
        if (satisIade.isSelected()) {
            satisIade.setBackground(Color.RED);
            satisIade.revalidate();
            satisIade.validate();
            satisIade.updateUI();
            blink();
            blinkLabel.setText("Satış İade !!!");
            blinkLabel.setBlinking(true);
        } else {
            satisIade.setBackground(Color.WHITE);
            satisIade.revalidate();
            satisIade.validate();
            satisIade.updateUI();
            blinkLabel.setText("");
            blinkLabel.setBlinking(false);
            jPanel4.removeAll();
            jPanel4.repaint();
        }
    }//GEN-LAST:event_satisIadeActionPerformed

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        try {
            double ind = Double.parseDouble(jTextField4.getText().replace(",", "."));
            double top = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                top += Double.parseDouble(model.getValueAt(i, 2).toString())
                        * Double.parseDouble(model.getValueAt(i, 3).toString());
            }
            double deger = round9((100 * ind) / top);
            jTextField3.setText("%" + deger);
            TableColumnModel columnModel = table.getColumnModel();
            final int miktarIndex = columnModel.getColumnIndex("MİKTAR");
            final int birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
            final int indYuzdeIndex = columnModel.getColumnIndex("İND. %");
            final int indTutarIndex = columnModel.getColumnIndex("İND. TUTAR");
            final int tutarIndex = columnModel.getColumnIndex("TUTAR");
            int rowCount = table.getModel().getRowCount();
            for (int i = 0; i < rowCount; i++) {
                Double birimFiyat = Double.valueOf(table.getModel().getValueAt(i, birimFiyatIndex).toString());
                Double miktar = Double.valueOf(table.getModel().getValueAt(i, miktarIndex).toString());
                Double iskontoDegeri = miktar * birimFiyat * deger / 100;
                table.setValueAt((miktar * birimFiyat) - iskontoDegeri, i, tutarIndex);
                table.setValueAt(iskontoDegeri, i, indTutarIndex);
                table.setValueAt(deger, i, indYuzdeIndex);
            }
            fiyatDegistir();
        } catch (NumberFormatException e) {
        }
    }//GEN-LAST:event_jTextField4FocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acikHesap;
    private static javax.swing.JTextField barkodField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cariField;
    private javax.swing.JToggleButton fiyat1;
    private javax.swing.JToggleButton fiyat2;
    private javax.swing.JToggleButton fiyat3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel miktarLabel;
    private javax.swing.JTextField paraUstuLabel;
    private javax.swing.JToggleButton satisIade;
    private javax.swing.JPanel statusPanel;
    private com.jidesoft.grid.CellStyleTable table;
    private javax.swing.JFormattedTextField tutarField;
    private javax.swing.JLabel urunAdiLabel;
    private javax.swing.JLabel urunFiyatLabel;
    // End of variables declaration//GEN-END:variables
 private BlinkLabel blinkLabel;

    private void cariSatAction() {
        try {
            if (hesap == null) {
                JOptionPane.showMessageDialog(this, "Hesap seçili değil");
                return;
            }
            if (table.getModel().getRowCount() > 0) {
                if (satisIade.isSelected()) {
                    SatisIslemi.myInstance(table).cariSatisIade(table, new OdemeTurleri(3), LifewebSession.instance().getKullanici(), hesap);

                } else {
                    SatisIslemi.myInstance(table).cariSatis(table, new OdemeTurleri(3), LifewebSession.instance().getKullanici(), hesap);
                }
                hesap = null;
                satisEkraniSifirla();
            } else {
                JOptionPane.showMessageDialog(this, "Sepet Boş");
            }
        } catch (HeadlessException e) {
            satisEkraniSifirla();
            e.printStackTrace();
        }
    }

    private void pesinSatAction() {
        try {
            if (table.getModel().getRowCount() > 0) {
                if (hesap == null) {
                    if (satisIade.isSelected()) {
                        SatisIslemi.myInstance(table).satisIade(table, new OdemeTurleri(1), LifewebSession.instance().getKullanici());

                    } else {
                        SatisIslemi.myInstance(table).satis(table, new OdemeTurleri(1), LifewebSession.instance().getKullanici());
                    }
                } else {
                    if (satisIade.isSelected()) {
                        SatisIslemi.myInstance(table).cariSatisIade(table, new OdemeTurleri(1), LifewebSession.instance().getKullanici(), hesap);
                    } else {
                        SatisIslemi.myInstance(table).cariSatis(table, new OdemeTurleri(1), LifewebSession.instance().getKullanici(), hesap);
                    }
                }
                satisEkraniSifirla();

            } else {
                JOptionPane.showMessageDialog(this, "Sepet Boş");
            }
        } catch (HeadlessException e) {
            satisEkraniSifirla();
            e.printStackTrace();
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), SatisUI.class.getEnclosingMethod() + "", e.getLocalizedMessage(), e);

        }
    }

    private void krediSatAction() {
        try {
            if (hesap == null) {
                if (satisIade.isSelected()) {
                    SatisIslemi.myInstance(table).satisIade(table, new OdemeTurleri(2), LifewebSession.instance().getKullanici());
                } else {
                    SatisIslemi.myInstance(table).satis(table, new OdemeTurleri(2), LifewebSession.instance().getKullanici());
                }
            } else {
                if (satisIade.isSelected()) {
                    SatisIslemi.myInstance(table).cariSatisIade(table, new OdemeTurleri(2), LifewebSession.instance().getKullanici(), hesap);
                } else {
                    SatisIslemi.myInstance(table).cariSatis(table, new OdemeTurleri(2), LifewebSession.instance().getKullanici(), hesap);
                }
            }
            satisEkraniSifirla();

        } catch (HeadlessException e) {
            satisEkraniSifirla();
            LOGGER.logp(Level.SEVERE, LOGGER.getName(), SatisUI.class.getEnclosingMethod() + "", e.getLocalizedMessage(), e);
        }
    }

    public void barkodRead() {
        String barkod = barkodField.getText().trim();
        UrunlerController controller = new UrunlerController(new UrunlerDaoImpl());
        Urunler urunler = controller.getUrunler(barkod);
        if (urunler == null) {
            jPanel4.removeAll();
            jPanel4.add(SatisUrunUI.tableList(barkod, SatisUI.this));
            jPanel4.repaint();
            jPanel4.getParent().requestFocus();
          JOptionPane.showMessageDialog(null, "Bu ürün barkodu bulunmuyor");
            LOGGER.logp(Level.INFO, LOGGER.getName(), "barkodRead", "%" + barkodField.getText() + "%", "Bu ürün barkodu bulunmuyor");
            return;
        }
        for (int i = 0; i < model.getRowCount(); i++) {
            if (urunler.equals(model.getValueAt(i, 1))) {
                double newAdet = Double.parseDouble(model.getValueAt(i, 2).toString()) + 1;
                model.setValueAt(newAdet, i, 2);
                setIndirim();
                fiyatDegistirIndirim(true);
                miktarLabel.setText(newAdet + "");
                urunAdiLabel.setToolTipText(urunler.getUrunAdi());
                if (urunler.getUrunAdi().length() > 30) {
                    urunAdiLabel.setText(urunler.getUrunAdi().substring(0, 30) + " ...");
                } else {
                    urunAdiLabel.setText(urunler.getUrunAdi());
                }
                urunFiyatLabel.setText(model.getValueAt(i, 3).toString());
                return;
            }
        }
        if (fiyat1.isSelected() && (urunler.getUrunSatisFiyat() == null || urunler.getUrunSatisFiyat() == 0.00)) {
            JOptionPane.showMessageDialog(null, "Satış Fiyatı 1 eksik!");
            return;
        } else if (fiyat2.isSelected() && (urunler.getUrunSatisFiyat2() == null || urunler.getUrunSatisFiyat2() == 0.00)) {
            JOptionPane.showMessageDialog(null, "Satış Fiyatı 2 eksik!");
            return;
        } else if (fiyat3.isSelected() && (urunler.getUrunSatisFiyat3() == null || urunler.getUrunSatisFiyat3() == 0.00)) {
            JOptionPane.showMessageDialog(null, "Satış Fiyatı 3 eksik!");
            return;
        } else if (urunler.getUrunAlisFiyat() == null) {
            JOptionPane.showMessageDialog(null, "Alış Fiyatı eksik!");
            return;
        }
        Object[] data = new Object[9];
        data[0] = urunler.getBarkodId();
        data[1] = urunler;
        data[2] = adet;
        data[4] = 0.0;
        data[5] = "0.0";

        urunAdiLabel.setToolTipText(urunler.getUrunAdi());
        miktarLabel.setText(adet + "");
        if (urunler.getUrunAdi().length() > 30) {
            urunAdiLabel.setText(urunler.getUrunAdi().substring(0, 30) + " ...");
        } else {
            urunAdiLabel.setText(urunler.getUrunAdi());
        }

        if (fiyat1.isSelected()) {
            data[3] = urunler.getUrunSatisFiyat();
        } else if (fiyat2.isSelected()) {
            data[3] = urunler.getUrunSatisFiyat2();
        } else if (fiyat3.isSelected()) {
            data[3] = urunler.getUrunSatisFiyat3();
        }

        Double satisFiyati = Double.parseDouble(String.valueOf(data[3]));
        try {
            data[6] = Double.valueOf(String.valueOf(data[2])) * satisFiyati;
        } catch (NumberFormatException e) {
            data[6] = data[3];
        }
        model.addRow(data);
        table.setModel(model);
        urunFiyatLabel.setText(String.valueOf(data[3]));
        Number value = (Number) tutarField.getValue();
        if (value != null) {
            tutarField.setValue(value.doubleValue() + (satisFiyati * adet));
        } else {
            tutarField.setValue(satisFiyati * adet);
        }
        setIndirim();
        adet = 1;
        barkodField.requestFocus();
        barkodField.selectAll();
    }

    private void fiyatDegistir() {
        TableColumnModel columnModel = table.getColumnModel();
        int urunAdiIndex = columnModel.getColumnIndex("ÜRÜN ADI");
        int miktarIndex = columnModel.getColumnIndex("MİKTAR");
        int birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
        int indYuzdeIndex = columnModel.getColumnIndex("İND. %");
        int indTutarIndex = columnModel.getColumnIndex("İND. TUTAR");
        int tutarIndex = columnModel.getColumnIndex("TUTAR");

        int rowCount = model.getRowCount();
        Double gTutar = 0.0;
        Double indMiktari = 0.0;
        for (int i = 0; i < rowCount; i++) {
            Urunler urun = (Urunler) model.getValueAt(i, urunAdiIndex);
            Double birimFiyat;
            Double tutar;
            Double indirimMiktari;
            Double indirimOrani;
            Double miktar;
            if (fiyat1.isSelected()) {
                birimFiyat = urun.getUrunSatisFiyat();
                miktar = Double.valueOf(model.getValueAt(i, miktarIndex).toString());
                indirimOrani = Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString());
                model.setValueAt(birimFiyat, i, birimFiyatIndex);
                indirimMiktari = birimFiyat * miktar * indirimOrani / 100;
                tutar = (birimFiyat * miktar) - indirimMiktari;
                model.setValueAt(tutar, i, tutarIndex);
                model.setValueAt(indirimMiktari, i, indTutarIndex);
                indMiktari += indirimMiktari;
            } else if (fiyat2.isSelected()) {
                birimFiyat = urun.getUrunSatisFiyat2();
                miktar = Double.valueOf(model.getValueAt(i, miktarIndex).toString());
                indirimOrani = Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString());
                model.setValueAt(birimFiyat, i, birimFiyatIndex);
                indirimMiktari = birimFiyat * miktar * indirimOrani / 100;
                tutar = (birimFiyat * miktar) - indirimMiktari;
                model.setValueAt(tutar, i, tutarIndex);
                model.setValueAt(indirimMiktari, i, indTutarIndex);
                indMiktari += indirimMiktari;
            } else {
                float birimFiyat3 = urun.getUrunSatisFiyat3();
                miktar = Double.valueOf(model.getValueAt(i, miktarIndex).toString());
                indirimOrani = Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString());
                model.setValueAt(birimFiyat3, i, birimFiyatIndex);
                indirimMiktari = birimFiyat3 * miktar * indirimOrani / 100;
                tutar = (birimFiyat3 * miktar) - indirimMiktari;
                model.setValueAt(tutar, i, tutarIndex);
                model.setValueAt(indirimMiktari, i, indTutarIndex);
                indMiktari += indirimMiktari;
            }
            gTutar += tutar;
        }
        jTextField4.setText(round(indMiktari) + "");
        jTextField3.setText(round(((100 * indMiktari) / (gTutar + indMiktari))) + "");
        indChart(gTutar, indMiktari);
        tutarField.setValue(gTutar);
        table.setModel(model);
    }

    private void fiyatDegistirIndirim(boolean isYuzde) {

        TableColumnModel columnModel = table.getColumnModel();
        int miktarIndex = columnModel.getColumnIndex("MİKTAR");
        int birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
        int indYuzdeIndex = columnModel.getColumnIndex("İND. %");
        int indTutarIndex = columnModel.getColumnIndex("İND. TUTAR");
        int tutarIndex = columnModel.getColumnIndex("TUTAR");
        double indMiktari = 0;
        int rowCount = model.getRowCount();
        Double gTutar = 0.0;

        for (int i = 0; i < rowCount; i++) {
            Double birimFiyat = Double.valueOf(model.getValueAt(i, birimFiyatIndex).toString());
            Double tutar;

            Double miktar = Double.valueOf(model.getValueAt(i, miktarIndex).toString());
            if (isYuzde) {
                Double indirimOrani = Double.valueOf(model.getValueAt(i, indYuzdeIndex).toString());
                Double indirimMiktari = birimFiyat * miktar * indirimOrani / 100;
                model.setValueAt(indirimMiktari, i, indTutarIndex);
                tutar = (birimFiyat * miktar) - indirimMiktari;
                model.setValueAt(tutar, i, tutarIndex);
                indMiktari += indirimMiktari;
            } else {
                Double indirimMiktari = Double.valueOf(model.getValueAt(i, indTutarIndex).toString());
                Double indirimOrani = ((indirimMiktari * 100) / (birimFiyat * miktar));

                model.setValueAt(indirimOrani, i, indYuzdeIndex);
                tutar = (birimFiyat * miktar) - indirimMiktari;
                model.setValueAt(tutar, i, tutarIndex);
                indMiktari += indirimMiktari;
            }

            gTutar += tutar;
        }
        jTextField4.setText(round(indMiktari) + "");
        jTextField3.setText(round(((100 * indMiktari) / (gTutar + indMiktari))) + "");
        tutarField.setValue(gTutar);
        indChart(gTutar, indMiktari);
        table.setModel(model);
    }

    private void setToplamFiyat() {
        TableColumnModel columnModel = table.getColumnModel();
        int tutarIndex = columnModel.getColumnIndex("TUTAR");

        int row = model.getRowCount();
        Double toplamTutar = 0.0;
        for (int i = 0; i < row; i++) {
            toplamTutar += Double.parseDouble(model.getValueAt(i, tutarIndex).toString());
        }
        tutarField.setValue(toplamTutar);
    }

    private void tableConfig() {
        NumberRenderer nr = new NumberRenderer(new DecimalFormat("#,##0.00"));
        NumberRenderer percent = new NumberRenderer(new DecimalFormat("#,##0%"));
        TableColumnModel columnModel = table.getColumnModel();
        final int miktarIndex = columnModel.getColumnIndex("MİKTAR");
        final int birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
        final int indYuzdeIndex = columnModel.getColumnIndex("İND. %");
        final int indTutarIndex = columnModel.getColumnIndex("İND. TUTAR");
        final int tutarIndex = columnModel.getColumnIndex("TUTAR");
//
        TableColumnModel tcm = table.getColumnModel();
        tcm.getColumn(tutarIndex).setCellRenderer(nr);
        tcm.getColumn(indTutarIndex).setCellRenderer(nr);
        //  tcm.getColumn(5).setCellRenderer(percent);

        table.addCellEditorListener(new com.jidesoft.grid.JideCellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                int row = table.getSelectedRow();
                int column = table.getSelectedColumn();
                DefaultTableModel model = (DefaultTableModel) table.getModel();

                if (column == miktarIndex) {
                    Object value = table.getValueAt(table.getSelectedRow(), column);
                    //     de.javasoft.plaf.synthetica.SynftheticaDefaultTableCellEditor editor = (de.javasoft.plaf.synthetica.SyntheticaDefaultTableCellEditor) ce.getSource();
                    //     Object value = editor.getCellEditorValue();
                    if (value != null) {
                        try {

                            Double miktar = Double.valueOf(value.toString());
                            Double birimFiyat = Double.valueOf(table.getModel().getValueAt(row, birimFiyatIndex).toString());
                            Double iskontoYuzde = Double.valueOf(table.getModel().getValueAt(row, indYuzdeIndex).toString());
                            Double iskontoDegeri = miktar * birimFiyat * iskontoYuzde / 100;
                            model.setValueAt(iskontoDegeri, row, indTutarIndex);
                            Double ss = (miktar * birimFiyat) - iskontoDegeri;
                            model.setValueAt(ss, row, tutarIndex);
                        } catch (NumberFormatException ee) {
                            LOGGER.logp(Level.INFO, LOGGER.getName(), SatisUI.class.getEnclosingMethod().getName(), ee.getLocalizedMessage(), ee);

                        }

                    }
                } else if (column == indYuzdeIndex) {
                    Object value = table.getModel().getValueAt(table.getSelectedRow(), column);
                    String degeri;
                    if (value.toString().contains(",")) {
                        degeri = value.toString().replace(",", ".");

                    } else {
                        degeri = value.toString();
                    }
                    if (degeri != null) {
                        try {
                            Double iskontoYuzde = Double.valueOf(degeri.toString());
                            Double birimFiyat = Double.valueOf(table.getModel().getValueAt(row, birimFiyatIndex).toString());
                            Double miktar = Double.valueOf(table.getModel().getValueAt(row, miktarIndex).toString());
                            Double iskontoDegeri = miktar * birimFiyat * iskontoYuzde / 100;
                            model.setValueAt(iskontoDegeri, row, indTutarIndex);
                            model.setValueAt((miktar * birimFiyat) - iskontoDegeri, row, tutarIndex);
                        } catch (NumberFormatException ee) {
                            LOGGER.logp(Level.INFO, LOGGER.getName(), SatisUI.class.getEnclosingMethod().getName(), ee.getLocalizedMessage(), ee);
                        }
                    }
                } else if (column == indTutarIndex) {
                    Object value = table.getModel().getValueAt(table.getSelectedRow(), column);
                    String degeri;
                    if (value.toString().contains(",")) {
                        degeri = value.toString().replace(",", ".");
                    } else {
                        degeri = value.toString();
                    }
                    if (degeri != null) {
                        try {
                            Double iskontoNet = Double.valueOf(degeri.toString());
                            Double birimFiyat = Double.valueOf(table.getModel().getValueAt(row, birimFiyatIndex).toString());
                            Double miktar = Double.valueOf(table.getModel().getValueAt(row, miktarIndex).toString());
                            Double iskontoYuzde = ((iskontoNet * 100) / (birimFiyat * miktar));
                            model.setValueAt(round(iskontoYuzde), row, indYuzdeIndex);
                            model.setValueAt((miktar * birimFiyat) - iskontoNet, row, tutarIndex);
                        } catch (NumberFormatException ee) {
                            LOGGER.logp(Level.INFO, LOGGER.getName(), SatisUI.class.getEnclosingMethod().getName(), ee.getLocalizedMessage(), ee);
                        }
                    }
                }
                table.setModel(model);
                fiyatDegistir();
                table.repaint();
                table.validate();
            }

            @Override
            public void editingCanceled(ChangeEvent e) {
            }

            @Override
            public boolean editingStarting(ChangeEvent ce) {
                return true;
            }

            @Override
            public void editingStarted(ChangeEvent ce) {
            }

            @Override
            public boolean editingStopping(ChangeEvent ce) {

                return true;
            }
        });

    }

    public void satisEkraniSifirla() {
        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            model.removeRow(0);
        }

        tutarField.setValue(Double.valueOf(0));
        miktarLabel.setText("1");
        urunAdiLabel.setText("Ürün Adı");
        urunFiyatLabel.setText("0,00");
        barkodField.setText("");
        cariField.setText("");
        jTextField3.setText("%0");
        jTextField4.setText("0,00");
        jFormattedTextField1.setValue(Double.valueOf(0));
        paraUstuLabel.setText("0,00");
        acikHesap.setEnabled(false);
        satisIade.setSelected(false);
        hesap = null;
        jPanel4.removeAll();
        jPanel4.repaint();
        chartPanel.reset();
        if (blinkLabel != null) {
            blinkLabel.setText("");
            blinkLabel.setBlinking(false);
        }

    }

    private void setIndirim() {
        int count = model.getRowCount();
        for (Indirimler indirimler : indirimlerList) {
            for (int i = 0; i < count; i++) {
                Urunler tableUrun = (Urunler) model.getValueAt(i, 1);
                if (tableUrun.getUrunId().intValue() == indirimler.getUrunRef().getUrunId().intValue() && tableUrun.getUrunPid().equals("0")) {
                    if (indirimler.isTekUrun()) {
                        TableColumnModel columnModel = table.getColumnModel();
                        final int indYuzdeIndex = columnModel.getColumnIndex("İND. %");
                        model.setValueAt(indirimler.getIndOran(), i, indYuzdeIndex);
                        table.setModel(model);

                        fiyatDegistirIndirim(true);
                    } else {
                        ArrayList<IndirimAltGrup> indirimAltGrups = indirimler.getIndirimAltGrups();
                        label1:
                        for (int j = 0; j < count; j++) {
                            Urunler tableAltUrun = (Urunler) model.getValueAt(j, 1);
                            for (IndirimAltGrup indirimAltGrup : indirimAltGrups) {
                                if (indirimAltGrup.getUrun().getUrunId().intValue() == tableAltUrun.getUrunId().intValue() && tableAltUrun.getUrunPid().equals("0")) {
                                    TableColumnModel columnModel = table.getColumnModel();
                                    tableAltUrun.setUrunPid("1");
                                    tableUrun.setUrunPid("1");
                                    final int indYuzdeIndex = columnModel.getColumnIndex("İND. TUTAR");
                                    model.setValueAt(indirimAltGrup.getNet(), j, indYuzdeIndex);
                                    table.setModel(model);
                                    fiyatDegistirIndirim(false);
                                    break label1;
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    class SatisTable extends CellStyleTable {

        public SatisTable(TableModel tm) {
            super(tm);
            setOpaque(false);
            //        ((JComponent) getDefaultRenderer(Object.class)).setOpaque(false);
            setFont(new Font("Arial", Font.PLAIN, 24));
            JTextField textField = new JTextField();
            textField.setFont(new Font("Arial", Font.PLAIN, 24));
            textField.setBorder(new LineBorder(Color.BLACK));
            DefaultCellEditor dce = new DefaultCellEditor(textField);
            getColumnModel().getColumn(2).setCellEditor(dce);
            getColumnModel().getColumn(4).setCellEditor(dce);
            getColumnModel().getColumn(5).setCellEditor(dce);
            int count = getColumnCount();
            for (int i = 0; i < count; i++) {
                getColumnModel().getColumn(i).setCellRenderer(new SmallCellRenderer());

            }//17720071979
            //8690605662691
            setRowHeight(50);
            int totalWitdth = getColumnModel().getTotalColumnWidth();
            getColumnModel().getColumn(0).setPreferredWidth(180);
            getColumnModel().getColumn(1).setPreferredWidth((int) (totalWitdth * 0.65));
            getColumnModel().getColumn(2).setPreferredWidth(40);
            getColumnModel().getColumn(3).setPreferredWidth(60);
            getColumnModel().getColumn(4).setPreferredWidth(60);
            getColumnModel().getColumn(5).setPreferredWidth(60);
            getColumnModel().getColumn(6).setPreferredWidth(80);

            getColumnModel().getColumn(0).setMaxWidth(180);
            getColumnModel().getColumn(2).setMaxWidth(40);
            getColumnModel().getColumn(3).setMaxWidth(60);
            getColumnModel().getColumn(4).setMaxWidth(60);
            getColumnModel().getColumn(5).setMaxWidth(60);
            getColumnModel().getColumn(6).setMaxWidth(80);

            getColumnModel().getColumn(0).setMinWidth(180);
            getColumnModel().getColumn(2).setMinWidth(40);
            getColumnModel().getColumn(3).setMinWidth(60);
            getColumnModel().getColumn(4).setMinWidth(60);
            getColumnModel().getColumn(5).setMinWidth(60);
            getColumnModel().getColumn(6).setMinWidth(80);
            /* 
             getColumnModel().getColumn(0).setWidth((int) (totalWitdth * 0.24));
             getColumnModel().getColumn(1).setWidth((int) (totalWitdth * 0.65));
             getColumnModel().getColumn(2).setWidth((int) (totalWitdth * 0.005));
             getColumnModel().getColumn(3).setWidth((int) (totalWitdth * 0.005));
             getColumnModel().getColumn(4).setWidth((int) (totalWitdth * 0.005));
             getColumnModel().getColumn(5).setWidth((int) (totalWitdth * 0.005));
             getColumnModel().getColumn(6).setWidth((int) (totalWitdth * 0.09));*/
            setColumnSelectionAllowed(true);

        }

        @Override
        protected void paintComponent(Graphics grphcs) {

            super.paintComponent(grphcs);
        }
    }

    public static double getAdet() {
        return adet;
    }

    public static void setAdet(double adet) {
        SatisUI.adet = adet;
    }

    private void yuzdeIndirimUygula() {
        String veri = jTextField3.getText().replace(',', '.');
        Double toplamIskonto = 0.0;
        if (veri.startsWith("%")) {
            veri = veri.substring(1).trim();
        }
        try {
            TableColumnModel columnModel = table.getColumnModel();
            final int miktarIndex = columnModel.getColumnIndex("MİKTAR");
            final int birimFiyatIndex = columnModel.getColumnIndex("BİRİM FİYATI");
            final int indYuzdeIndex = columnModel.getColumnIndex("İND. %");
            final int indTutarIndex = columnModel.getColumnIndex("İND. TUTAR");
            final int tutarIndex = columnModel.getColumnIndex("TUTAR");
            Double oran = Double.parseDouble(veri);
            int rowCount = table.getModel().getRowCount();
            for (int i = 0; i < rowCount; i++) {
                Double birimFiyat = Double.valueOf(table.getModel().getValueAt(i, birimFiyatIndex).toString());
                Double miktar = Double.valueOf(table.getModel().getValueAt(i, miktarIndex).toString());
                Double iskontoDegeri = miktar * birimFiyat * oran / 100;
                toplamIskonto += iskontoDegeri;
                table.setValueAt((miktar * birimFiyat) - iskontoDegeri, i, tutarIndex);
                table.setValueAt(iskontoDegeri, i, indTutarIndex);
                table.setValueAt(oran, i, indYuzdeIndex);
            }
            fiyatDegistir();
            jTextField4.setText(round(toplamIskonto) + "");
        } catch (NumberFormatException e) {
            LOGGER.logp(Level.INFO, LOGGER.getName(), SatisUI.class.getEnclosingMethod().getName(), e.getLocalizedMessage(), e);
            JOptionPane.showMessageDialog(this, "Geçersiz Format");
            jTextField3.setText("%0");
        }
    }

    public CellStyleTable getTable() {
        return table;
    }

    public JButton getAcikHesap() {
        return acikHesap;
    }

    IndirimChartPanel chartPanel = new IndirimChartPanel();

    private void indChart(double net, double ind) {
        if (ind == 0) {
            return;
        }
        jPanel4.removeAll();
        jPanel4.add(chartPanel.getDemoPanel(net, ind));
        jPanel4.repaint();
    }
}
