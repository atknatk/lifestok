
package com.lifeweb.ui.report;


public enum ReportType {
    SATIS_DOKUMU;
    
    public static String getReportFile(ReportType reportType){
        if (reportType==SATIS_DOKUMU) {
            return "com/lifeweb/ui/report/fis/SatisDokumu.jasper";
        }
        return null;
    }
}
