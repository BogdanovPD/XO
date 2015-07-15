package ru.levelp.java.xo;

import javax.swing.*;
import java.awt.*;


public class MyButton extends JButton {

    public MyButton() {
        super();
    }

    public MyButton(String s) {
        super(s);
    }

    public void setStyle(Font font, Color foreGround, Color backGround){
        setFont(font);
        setForeground(foreGround);
        setBackground(backGround);
    }

}