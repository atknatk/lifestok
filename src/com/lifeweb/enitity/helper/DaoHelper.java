package com.lifeweb.enitity.helper;

import com.lifeweb.ui.helper.Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;

public class DaoHelper {

    private static final String IP_KEY = "sql_ip";
    private static String url;
    private static final String id = "root";
    private static final String pw = "atikler";
    private static final String db = "lifev1";
    private Connection con = null;
    private static DaoHelper daoHelper;
    private static final Object LOCK = new Object();

    private DaoHelper() {
        if(Helper.getConfigs().containsKey(IP_KEY) && !StringUtils.isBlank(Helper.getConfigs().get(IP_KEY))){
            url = "jdbc:mysql://"+ Helper.getConfigs().get(IP_KEY) +":3306/";
        }else{
            url = "jdbc:mysql://localhost:3306/";
        }
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

//    public Connection getConnection(String ip) {
//        Connection conIP = null;
//        String urll = "jdbc:mysql://" + ip + ":3306/";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conIP = DriverManager.getConnection(urll + db, id, pw);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            LOGGER.logp(Level.SEVERE, DaoHelper.class.getName(), "getConnection", "Sql Bağlanti Hatasi", e.fillInStackTrace());
//            JOptionPane.showMessageDialog(null, "Bağlantı Zaman Aşımı", "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Bağlantı Zaman Aşımı", "Bağlantı Hatası", JOptionPane.ERROR_MESSAGE);
//
//            LOGGER.logp(Level.SEVERE, DaoHelper.class.getName(), "getConnection", "Sql Bağlanti Hatasi", e.fillInStackTrace());
//
//        }
//        return conIP;
//    }
}
