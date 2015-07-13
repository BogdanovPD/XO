package ru.levelp.java.xo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new About().open();
    }
}