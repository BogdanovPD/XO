package ru.levelp.java.xo;

import javax.swing.*;
import java.io.Serializable;

public class MyFrame extends JFrame implements Serializable {

    String frameStyle = "blue";

    public MyFrame(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
    }

    public MyFrame(String s){
        super(s);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
    }

}
