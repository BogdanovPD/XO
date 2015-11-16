package ru.levelp.java.xo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class StepListener implements ActionListener, Serializable {

    private GUI gui;

    public StepListener(GUI gui) {
        this.gui = gui;
    }

       @Override
    public void actionPerformed(ActionEvent e) {
        MyButton b = (MyButton) e.getSource();
        if (b.getText().equals("")) {
            if (gui.isXStep()) {
                b.setText("X");
                gui.setIsXStep(false);
                gui.label.setText("\"0\" is next");
                gui.checkWinner();
            } else {
                b.setText("0");
                gui.setIsXStep(true);
                gui.label.setText("\"X\" is next");
                gui.checkWinner();
            }
        }
    }

}