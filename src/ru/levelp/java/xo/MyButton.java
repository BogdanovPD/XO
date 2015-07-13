package ru.levelp.java.xo;

import javax.swing.*;
import java.awt.*;


public class MyButton extends JButton {

    public MyButton(String title) {
        super(title); //new JButton("")
        setFont(new Font("Arial", Font.BOLD, 30));
        setForeground(Color.BLUE);
        setBackground(Color.ORANGE);
    }

    public MyButton() {
        super(); //new JButton("")
        setFont(new Font("Arial", Font.BOLD, 30));
        setForeground(Color.BLUE);
        setBackground(Color.ORANGE);
    }

}