/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lifeweb.ui.report;

import com.lifeweb.enitity.helper.DaoHelper;
import com.lifeweb.ui.MainUI;
import java.io.File;
import java.io.InputStream;
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
 * @author Atakan Atik
 */
public class ReportCreator {
    
    public  void getReport(ReportType reportType,Map<String, Object> params,String ip){
        Locale.setDefault(new Locale("tr", "TR"));
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(ReportType.getReportFile(reportType));
        JasperPrint jp = null;
        try {
            jp = JasperFillManager.fillReport(is, params, ip==null?DaoHelper.instance().getConnection():DaoHelper.instance().getConnection());
        } catch (JRException ex) {
            Logger.getLogger(GunlukKar.class.getName()).log(Level.SEVERE, null, ex);
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
