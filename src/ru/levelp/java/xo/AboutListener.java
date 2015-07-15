package ru.levelp.java.xo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutListener implements ActionListener {

    GUI gui;
    public AboutListener(GUI gui){
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new About(gui.frame.frameStyle).open();
    }
}