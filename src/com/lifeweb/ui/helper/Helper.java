/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author Atakan
 */
public class Helper {

    private static final Map<String,String> CONFIGS = new HashMap<>();
    public static Helper helper;

    private Helper() {
    loadProperty();
    }

    public static Map<String, String> getConfigs() {
        return CONFIGS;
    }
    

    public static Helper instance() {
        if (helper == null) {
            helper = new Helper();
            return helper;
        }
        return helper;
    }

    private String loadProperty() {
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream("config.properties"));
            for (Map.Entry<Object, Object> entry : prop.entrySet()) {
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();
                CONFIGS.put(key, value);
            }
            return prop.getProperty("sql_ip");
        } catch (IOException ex) {
        }
        return "";
    }

}