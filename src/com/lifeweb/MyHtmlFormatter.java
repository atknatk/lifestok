/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

//This custom formatter formats parts of a log record to a single line
public class MyHtmlFormatter extends Formatter {
    // This method is called for every log records

    public String format(LogRecord rec) {
        StringBuffer buf = new StringBuffer(1000);
        // Bold any levels >= WARNING
        buf.append("<tr>");


        if (rec.getLevel().intValue() >= Level.WARNING.intValue()) {
            buf.append("<td style='color:red'>");
            buf.append("<b>");
            buf.append(rec.getLevel());
            buf.append("</b>");
        } else {
            buf.append("<td>");

            buf.append(rec.getLevel());
        }
        buf.append("</td>");
        
        buf.append("<td>");
        buf.append(calcDate(rec.getMillis()));
        buf.append('\n');
        buf.append("</td>");

        buf.append("<td>");
        buf.append(rec.getLoggerName());
        buf.append('\n');
        buf.append("</td>");


        buf.append("<td>");
        buf.append(rec.getMessage());
        buf.append('\n');
        buf.append("</td>");
        
         buf.append("<td>");
        buf.append(rec.getSourceMethodName());
        buf.append('\n');
        buf.append("</td>");
        
        buf.append("<td>");
        buf.append(rec.getThrown());
        buf.append('\n');
        buf.append("</td>");

        buf.append("</tr>\n");
        return buf.toString();
    }

    private String calcDate(long millisecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(millisecs);
        return date_format.format(resultdate);
    }

    public String getHead(Handler h) {
        return "<HTML>\n<HEAD>\n" + (new Date())
                + "\n</HEAD>\n<BODY>\n<PRE>\n"
                + "<table width=\"100%\" border>\n  "
                + "<tr><th>Level</th>"
                + "<th>Time</th>"
                + "<th>Class</th>"
                + "<th>Log Message</th>"
                  + "<th>Method Name</th>"
                + "<th>ex</th>"
                + "</tr>\n";
    }

    // This method is called just after the handler using this
    // formatter is closed
    public String getTail(Handler h) {
        return "</table>\n  </PRE></BODY>\n</HTML>\n";
    }
}
