/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.util;

/**
 *
 * @author Atakan
 */
public class LifeStok {

    public static String pkgver = "1.1";
    public static String pkgrel = "13";

    public static String getProductVersion() {
        return pkgver + "." + pkgrel;
    }
}
