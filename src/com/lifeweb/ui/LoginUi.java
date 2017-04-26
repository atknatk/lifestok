package com.lifeweb.ui;

import com.jidesoft.plaf.LookAndFeelFactory;
import com.lifeweb.LifewebSession;
import com.lifeweb.MyHtmlFormatter;
import com.lifeweb.dao.pojo.Kullanici;
import com.lifeweb.ui.islemler.LoginIslemler;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author Atakan
 */
public class LoginUi extends javax.swing.JFrame {

    private final static Logger LOGGER = Logger.getLogger(LoginUi.class
            .getName());

    public LoginUi() {
        try {
            setupLogger();
        } catch (IOException ex) {
            Logger.getLogger(LoginUi.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/resources/img/logo16.png")).getImage());
        setContentPane(new JLabel(new javax.swing.ImageIcon(getClass().getResource("/resources/img/login_back.jpg"))));
        //   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        jProgressBar1.setVisible(false);

        LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.FINE);

        setSize(390, 270);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = getSize().width;
        int h = getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        setLocation(x, y);
        setTitle("Life Discount Application");

    }

    public static void setupLogger() throws IOException {
        Logger rootLogger = Logger.getLogger("");
        Handler htmlFileHandler = new FileHandler("log.html", true);
        Formatter htmlFormatter = new MyHtmlFormatter();
        rootLogger.addHandler(htmlFileHandler);
        htmlFileHandler.setFormatter(htmlFormatter);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Life Barkodlu Satış Programı");
        setResizable(false);
        setUndecorated(true);

        jLabel1.setText("Kullanıcı Adı:");

        jLabel2.setText("Şifre:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
        });

        jButton1.setText("Giriş");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/img/logo16.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Life Barkodlu Satış Programı");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addContainerGap(84, Short.MAX_VALUE))
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        final Kullanici name = LoginIslemler.login(jTextField1.getText(), jPasswordField1.getText());
        if (name != null) {
            this.dispose();

            LifewebSession.instance().setKullanici(name);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MainUI(name).setVisible(true);
                }
            });
        } else {
            LOGGER.logp(Level.INFO, LoginUi.class.toString(), "", jTextField1.getText() + " Hatali Giris");

            JOptionPane.showMessageDialog(null, "Hatalı Giriş!");
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        final Kullanici name = LoginIslemler.login(jTextField1.getText(), jPasswordField1.getText());
        if (name != null) {
            this.dispose();
            LifewebSession.instance().setKullanici(name);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MainUI(name).setVisible(true);
                }
            });
        } else {
            JOptionPane.showMessageDialog(null, "Hatalı Giriş!");
            LOGGER.logrb(Level.INFO, LoginUi.class.toString(), LOGGER.getName(), LOGGER.getResourceBundleName(), jTextField1.getText() + " Hatali Giris");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            final Kullanici name = LoginIslemler.login(jTextField1.getText(), jPasswordField1.getText());
            if (name != null) {
                this.dispose();

                LifewebSession.instance().setKullanici(name);
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new MainUI(name).setVisible(true);
                    }
                });
            } else {
                JOptionPane.showMessageDialog(null, "Hatalı Giriş!");
                LOGGER.logp(Level.INFO, LoginUi.class.toString(), "", jTextField1.getText() + " Hatali Giris");

            }
        }
    }//GEN-LAST:event_jPasswordField1KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
    }//GEN-LAST:event_jTextField1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // com.jidesoft.utils.Lm.verifyLicense("Gareth Pidgeon", "ZoeOS", "DJoqM6VZ5apzIiGYUqwaFfnAXmREFrm1");
        verifyJIDE();
        //    setLAF();
        Locale.setDefault(Locale.ENGLISH);
        String[] li = {
            "Licensee=Jose Rolando Mamani", "LicenseRegistrationNumber=NCJM100903", "Product=Synthetica", "LicenseType=Non Commercial", "ExpireDate=--.--.----", "MaxVersion=2.999.999"
        };
        UIManager.put("Synthetica.license.info", li);
        UIManager.put("Synthetica.license.key", "15CB5234-B38B207F-81C36EF5-D3CF2137-E653E410");

        String[] li2 = {
            "Licensee=Jose Rolando Mamani", "LicenseRegistrationNumber=NCJM100903", "Product=SyntheticaAddons", "LicenseType=Non Commercial", "ExpireDate=--.--.----", "MaxVersion=1.999.999"
        };
        UIManager.put("SyntheticaAddons.license.info", li2);
        UIManager.put("SyntheticaAddons.license.key", "706FC55F-821A72A1-F46D7D49-1076473F-C9336002");

        try {
            UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel()//   {  @Override   protected void loadCustomXML() throws ParseException  {  loadXMLConfig("/resources/custom.xml");  } }
            );
            //SyntheticaBlueMoonLookAndFeel()
            //SyntheticaBlueSteelLookAndFeel()
        } catch (ParseException | UnsupportedLookAndFeelException e) {
            LOGGER.logp(Level.SEVERE, LoginUi.class.toString(), "main", e.getMessage(), e);

        }
        //    String a = Config.getConfig("locale");

        /*    System.out.println(a);
         if (a.equals("tr_TR")) {
         Locale.setDefault(new Locale(a.split("_")[0], a.split("_")[1]));
         }*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginUi().setVisible(true);
            }
        });
    }

    public void writeLog() {
    }

    private static void verifyJIDE() {

        com.jidesoft.utils.Lm.verifyLicense("Marc Fiume", "Savant Genome Browser", "1BimsQGmP.vjmoMbfkPdyh0gs3bl3932");
        //  com.jidesoft.utils.Lm.verifyLicense("IPK Gatersleben", "BioTool","77io.eonTGaI67EPfVpOEn3jEtX6raR2");
        //  com.jidesoft.utils.Lm.verifyLicense("Canoo Engineering AG", "ULC", "buTdNOUdUoFq2a0qnm6RbO8YNw4gL9T");
        // com.jidesoft.utils.Lm.verifyLicense("Marios Skounakis", "JOverseer", "L1R4Nx7vEp0nMbsoaHdH7nkRrx5F.dO");
        //com.jidesoft.utils.Lm.verifyLicense("Patrick Gotthardt", "PgsLookAndFeel", "aW6dEcgCQMkW4e:OGYJCDdPATGYEiLo2");

        //   com.jidesoft.utils.Lm.verifyLicense("Bill Studer", "Gnusbin", "GUPxWo:0hpUtR3u94.K90:R7sPr.VCv2");
    }

    private static void setLAF() {
        try {

            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            LookAndFeelFactory.installJideExtension(LookAndFeelFactory.XERTO_STYLE_WITHOUT_MENU);
            UIManager.put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));

            //tooltips
            UIManager.put("ToolTip.background", new ColorUIResource(255, 255, 255));
            ToolTipManager.sharedInstance().setDismissDelay(8000);
            ToolTipManager.sharedInstance().setInitialDelay(500);

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException x) {
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
