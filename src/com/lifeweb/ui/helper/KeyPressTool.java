

package com.lifeweb.ui.helper;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Atakan
 */
public class KeyPressTool {

    private static int doublePressSpeed = 300; 
    private static long timeKeyDown = 0;       
    public static int lastKeyPressedCode;

    public static  boolean isDoublePress(KeyEvent ke) {
        if ((ke.getWhen() - timeKeyDown) < doublePressSpeed) {
            return true;
        } else {
            timeKeyDown = ke.getWhen();
        }
        lastKeyPressedCode = ke.getKeyCode();
        return false;
    }
    
    public static  boolean isDoublePress(ActionEvent ke,int keyEvent) {
        if ((ke.getWhen() - timeKeyDown) < doublePressSpeed) {
            return true;
        } else {
            timeKeyDown = ke.getWhen();
        }
        lastKeyPressedCode = keyEvent;
        return false;
    }
}