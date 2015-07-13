package ru.levelp.java.xo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StepListener implements ActionListener {

    private boolean isXStep = true;

    @Override
    public void actionPerformed(ActionEvent e) {
        MyButton b = (MyButton) e.getSource();
        if (b.getText().equals("")) {
            if (isXStep()) {
                b.setText("X");
                setIsXStep(false);
            } else {
                b.setText("0");
                setIsXStep(true);
            }
        }
    }


    public boolean isXStep() {
        return isXStep;
    }

    public void setIsXStep(boolean isXStep) {
        this.isXStep = isXStep;
    }
}