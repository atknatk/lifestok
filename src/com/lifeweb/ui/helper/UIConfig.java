/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lifeweb.ui.helper;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class UIConfig {

    public static Point getLocation(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;
        frame.setIconImage(new javax.swing.ImageIcon(frame.getClass().getResource("/resources/img/logo16.png")).getImage());
        return new Point(x, y);
         
    }
    public static void getLocationFull(JFrame frame) {
        frame.setIconImage(new javax.swing.ImageIcon(frame.getClass().getResource("/resources/img/logo16.png")).getImage());
         GraphicsEnvironment env =GraphicsEnvironment.getLocalGraphicsEnvironment();
        frame.setMaximizedBounds(env.getMaximumWindowBounds());
        frame.setExtendedState(frame.getExtendedState() | frame.MAXIMIZED_BOTH);
         
    }
}
