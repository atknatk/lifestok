/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Atakan
 */
public class Helper {

    public static Helper helper;

    private Helper() {
    }

    public static Helper instance() {
        if (helper == null) {
            helper = new Helper();
            return helper;
        }
        return helper;
    }

    public String loadProperty() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("config.properties"));
            return prop.getProperty("diger_sube_ip");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }

}
