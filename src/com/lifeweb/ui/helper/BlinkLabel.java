/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lifeweb.ui.helper;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
 
public class BlinkLabel extends JLabel {
  private static final long serialVersionUID = 1L;
  
  private static final int BLINKING_RATE = 1000; // in ms

  private boolean blinkingOn = true;
  
  public BlinkLabel(String text) {
    super(text);
    Timer timer = new Timer( BLINKING_RATE , new TimerListener(this));
    timer.setInitialDelay(0);
    timer.start();
  }
  
  public void setBlinking(boolean flag) {
    this.blinkingOn = flag;
  }
  public boolean getBlinking(boolean flag) {
    return this.blinkingOn;
  }

  
  private class TimerListener implements ActionListener {
    private final BlinkLabel bl;
    private final Color bg;
    private final Color fg;
    private boolean isForeground = true;
    
    public TimerListener(BlinkLabel bl) {
      this.bl = bl;
      fg = Color.RED;
      bg = bl.getBackground();
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
      if (bl.blinkingOn) {
        if (isForeground) {
          bl.setForeground(fg);
        }
        else {
          bl.setForeground(bg);
        }
        isForeground = !isForeground;
      }
      else {
        // here we want to make sure that the label is visible
        // if the blinking is off.
        if (isForeground) {
          bl.setForeground(fg);
          isForeground = false;
        }
      }
    }
    
  }
}
 