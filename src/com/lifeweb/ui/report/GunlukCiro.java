package com.lifeweb.ui.report;

import com.lifeweb.enitity.helper.DaoHelper;
import com.lifeweb.ui.MainUI;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRSaveContributor;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Life
 */
public class GunlukCiro {

    public GunlukCiro() {
        Locale.setDefault(new Locale("tr", "TR"));
        Map<String, Object> params = new HashMap<>();
        Date date = new Date();
        params.put("bugun", date);
        params.put("baslik", date.toLocaleString().split(" ")[0] + " Günlü Ciro Raporu");
        String reportName = "com/lifeweb/ui/report/ciro/GunlukCiro.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);

        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(is, params, DaoHelper.instance().getConnection());
        } catch (JRException ex) {
            Logger.getLogger(GunlukCiro.class.getName()).log(Level.SEVERE, null, ex);
        }
        JRViewer viewer1 = new JRViewer(jp);
        List<JRSaveContributor> newSaveContributors = new LinkedList<>();
        JRSaveContributor[] saveContributors = viewer1.getSaveContributors();
        for (JRSaveContributor saveContributor : saveContributors) {
            if (saveContributor.getDescription().equals("PDF (*.pdf)") || saveContributor.getDescription().equals("HTML (*.htm, *.html)") || saveContributor.getDescription().equals("Single sheet XLS (*.xls)") || saveContributor.getDescription().equals("Multiple sheets XLS (*.xls)") || saveContributor.getDescription().equals("CSV (*.csv)") || saveContributor.getDescription().equals("DOCX (*.docx)")) {
                newSaveContributors.add(saveContributor);
            }
        }
        viewer1.setSaveContributors(newSaveContributors.toArray(new JRSaveContributor[0]));
        MainUI.getAnaPanel().removeAll();
        MainUI.getAnaPanel().add(viewer1);
        Locale.setDefault(Locale.ENGLISH);

    }

    public GunlukCiro(String ip) {
        Locale.setDefault(new Locale("tr", "TR"));
        File f = new File("");
        String reportName = "com/lifeweb/ui/report/ciro/GunlukCiro.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
        Map<String, Object> params = new HashMap<>();
        Date date = new Date();
        params.put("bugun", date);
        params.put("baslik", date.toLocaleString().split(" ")[0] + " Günlü Ciro Raporu");
        Connection con = null;
        JasperPrint jp = null;
        try {
            con = DaoHelper.instance().getConnection();
            jp = JasperFillManager.fillReport(is, params, con);
        } catch (JRException ex) {
            Logger.getLogger(GunlukCiro.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                }
            }

        }
        JRViewer viewer1 = new JRViewer(jp);
        List<JRSaveContributor> newSaveContributors = new LinkedList<>();
        JRSaveContributor[] saveContributors = viewer1.getSaveContributors();
        for (JRSaveContributor saveContributor : saveContributors) {
            if (saveContributor.getDescription().equals("PDF (*.pdf)") || saveContributor.getDescription().equals("HTML (*.htm, *.html)") || saveContributor.getDescription().equals("Single sheet XLS (*.xls)") || saveContributor.getDescription().equals("Multiple sheets XLS (*.xls)") || saveContributor.getDescription().equals("CSV (*.csv)") || saveContributor.getDescription().equals("DOCX (*.docx)")) {
                newSaveContributors.add(saveContributor);
            }
        }
        viewer1.setSaveContributors(newSaveContributors.toArray(new JRSaveContributor[0]));
        MainUI.getAnaPanel().removeAll();
        MainUI.getAnaPanel().add(viewer1);
        Locale.setDefault(Locale.ENGLISH);

    }
}
