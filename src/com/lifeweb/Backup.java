package com.lifeweb;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Atakan
 */
public class Backup {

    private final int BUFFER = 10485760;
    private final String PATH = "C:\\Program Files\\MySQL\\MySQL Server 5.1\\bin\\";

    public static void main(String... args) {
        try {
            new Backup().metot();
        } catch (Exception ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getData(String host, String port, String user,
            String password, String db) throws Exception {
        Process run = Runtime.getRuntime().exec(PATH
                + "mysqldump --host=" + host + " --port=" + port
                + " --user=" + user + " --password=" + password
                + " --compact --complete-insert --extended-insert "
                + "--skip-comments --skip-triggers " + db);
        StringBuffer temp;
        try (InputStream in = run.getInputStream(); 
                BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            temp = new StringBuffer();
            int count;
            char[] cbuf = new char[BUFFER];
            while ((count = br.read(cbuf, 0, BUFFER)) != -1) {
                temp.append(cbuf, 0, count);
            }
        }

        return temp.toString();
    }

    private String getRoutine(String host, String port, String user,
            String password, String db) throws Exception {
        Process run = Runtime.getRuntime().exec(PATH
                + "mysqldump --host=" + host + " --port=" + port
                + " --user=" + user + " --password=" + password
                + " --compact --skip-comments --no-create-info "
                + "--no-data --routines " + db);
        StringBuffer temp;
        try (
            InputStream in = run.getInputStream(); 
            BufferedReader br = new BufferedReader(new InputStreamReader(in)))
        {
            temp = new StringBuffer();
            int count;
            char[] cbuf = new char[BUFFER];
            while ((count = br.read(cbuf, 0, BUFFER)) != -1) {
                temp.append(cbuf, 0, count);
            }
        }

        return temp.toString();
    }

    public void metot() throws Exception {

        byte[] data = getData("localhost", "3306", "root", "atikler", "lifev1").getBytes();
        byte[] routine = getRoutine("localhost", "3306", "root", "atikler", "lifev1").getBytes();
        if (!new File("yedek").exists()) {
            boolean is = new File("yedek").mkdirs();
            if (!is) {
                JOptionPane.showMessageDialog(null, "Dosya Oluşturulamadı");
                return;
            }
        }

        Locale.setDefault(new Locale("tr", "TR"));
        File filedst = new File("yedek/" + new SimpleDateFormat("dd-MMMM-yyyy").format(new Date()) + ".zip");
        Locale.setDefault(Locale.ENGLISH);
        try (FileOutputStream dest = new FileOutputStream(filedst); 
                ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(dest))) {
            zip.setMethod(ZipOutputStream.DEFLATED);
            zip.setLevel(Deflater.BEST_COMPRESSION);

            zip.putNextEntry(new ZipEntry("data.sql"));
            zip.write(data);

            zip.putNextEntry(new ZipEntry("routine.sql"));
            zip.write(routine);
        }
        JOptionPane.showMessageDialog(null, "Başarıyla yedek alındı");

    }
}
