package ru.levelp.java.xo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StepListener implements ActionListener {

    boolean isXStep = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        MyButton b = (MyButton) e.getSource();
        if (b.getText().equals("")) {
            if (isXStep) {
                b.setText("X");
                isXStep = false;
            } else {
                b.setText("O");
                isXStep = true;
            }
            //b[k].setEnabled(false);
        }
    }
}