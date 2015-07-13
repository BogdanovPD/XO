package ru.levelp.java.xo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {

    ArrayList<MyButton> arrayList = new ArrayList<MyButton>();

    public void build() {
        JFrame frame = new JFrame("XO");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 300);

        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        JMenuItem quitMenuItem = new JMenuItem("Quit");

        aboutMenuItem.addActionListener(new AboutListener());

        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!arrayList.get(i).equals(null))
                    arrayList.get(i).setText("");
                }
               // isXStep = true;
            }
        });

        quitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(3, 3));

        StepListener stepListener = new StepListener();

        for (int i = 0; i < 9; i++) {
            arrayList.add(new MyButton());
            arrayList.get(i).addActionListener(stepListener);
            panel.add(arrayList.get(i));
        }

        frame.setJMenuBar(bar);
        frame.add(BorderLayout.CENTER, panel);
        frame.setVisible(true);

    }

}
