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
public class GunlereGoreKar {

    public GunlereGoreKar(Date date, String ip) {
        Locale.setDefault(new Locale("tr", "TR"));
        File f = new File("");

        Map<String, Object> params = new HashMap<>();
        System.out.println(date.toString());
        params.put("tarih", date);
 String reportName = "com/lifeweb/ui/report/kar/KarRapor.jasper";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);

        Connection con = null;
        JasperPrint jp = null;
        try {
//            if (ip == null) {
                jp = JasperFillManager.fillReport(is, params, DaoHelper.instance().getConnection());
//            } else {
//                con=DaoHelper.instance().getConnection(ip);
//                jp = JasperFillManager.fillReport(is, params,con);
//            }
        } catch (JRException ex) {
            Logger.getLogger(GunlereGoreKar.class.getName()).log(Level.SEVERE, null, ex);
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
        for (int i = 0; i < saveContributors.length; i++) {
            if (saveContributors[i].getDescription().equals("PDF (*.pdf)")
                    || saveContributors[i].getDescription().equals("HTML (*.htm, *.html)")
                    || saveContributors[i].getDescription().equals("Single sheet XLS (*.xls)")
                    || saveContributors[i].getDescription().equals("Multiple sheets XLS (*.xls)")
                    || saveContributors[i].getDescription().equals("CSV (*.csv)")
                    || saveContributors[i].getDescription().equals("DOCX (*.docx)")) {
                newSaveContributors.add(saveContributors[i]);
            }
        }
        viewer1.setSaveContributors(newSaveContributors.toArray(new JRSaveContributor[0]));
        MainUI.getAnaPanel().removeAll();
        MainUI.getAnaPanel().add(viewer1);
        Locale.setDefault(Locale.ENGLISH);

    }
}
