package ru.levelp.java.xo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {

    public void build() {
        JFrame frame = new JFrame("XO");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(3, 3));

        ArrayList<JButton> arrayList = new ArrayList<JButton>();

        for (int i = 0; i < 9; i++) {
            arrayList.add(new JButton());
            panel.add(arrayList.get(i));
        }

        for (int i = 0; i < arrayList.size(); i++) {
            final int finalI = i;
            arrayList.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                        arrayList.get(finalI).setText("X");
                }
            });
        }


        frame.setVisible(true);

    }

}
