package com.lifeweb.enitity.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DaoHelper {

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String id = "root";
    private static final String pw = "atikler";
    private static final String db = "lifev1";
    private Connection con = null;
    private static DaoHelper daoHelper;
    private static final Object LOCK = new Object();

    private DaoHelper() {

    }

    public static DaoHelper instance() {
        if (daoHelper == null) {
            synchronized (LOCK) {
                daoHelper = new DaoHelper();
            }
            return daoHelper;
        }
        return daoHelper;
    }

    public Connection getConnection() {
        if (con != null) {
            try {
                if (con.isClosed()) {
                    synchronized (LOCK) {
                        return getCon();
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(DaoHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return con;
        }
        synchronized (LOCK) {
            return getCon();
        }
    }
    
    private final static Logger LOGGER = Logger.getLogger(DaoHelper.class
            .getName());

    private Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url + db, id, pw);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Bağlantı Zaman Aşımı", "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            LOGGER.logp(Level.SEVERE, DaoHelper.class.getName(), "getConnection", "Sql Bağlanti Hatasi", e.fillInStackTrace());
        } catch (SQLException e) {
            e.printStackTrace();
            LOGGER.logp(Level.SEVERE, DaoHelper.class.getName(), "getConnection", "Sql Bağlanti Hatasi", e.fillInStackTrace());
            JOptionPane.showMessageDialog(null, "Bağlantı Zaman Aşımı", "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);

        }
        return con;
    }

    public Connection getConnection(String ip) {
        Connection conIP = null;
        String urll = "jdbc:mysql://" + ip + ":3306/";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conIP = DriverManager.getConnection(urll + db, id, pw);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            LOGGER.logp(Level.SEVERE, DaoHelper.class.getName(), "getConnection", "Sql Bağlanti Hatasi", e.fillInStackTrace());
            JOptionPane.showMessageDialog(null, "Bağlantı Zaman Aşımı", "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Bağlantı Zaman Aşımı", "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);

            LOGGER.logp(Level.SEVERE, DaoHelper.class.getName(), "getConnection", "Sql Bağlanti Hatasi", e.fillInStackTrace());

        }
        return conIP;
    }
}
