package ru.levelp.java.xo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {

    ArrayList<MyButton> arrayList = new ArrayList<MyButton>();
    StepListener stepListener = new StepListener();
    JLabel label = new JLabel();

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
                newGame();
               // isXStep = true;
            }
        });

        quitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        fileMenu.add(newGameMenuItem);
        fileMenu.add(quitMenuItem);
        bar.add(fileMenu);
        bar.add(aboutMenuItem);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new GridLayout(3, 3));


        for (int i = 0; i < 9; i++) {
            arrayList.add(new MyButton());
            arrayList.get(i).addActionListener(stepListener);
            panel.add(arrayList.get(i));
        }

        frame.setJMenuBar(bar);
        frame.add(BorderLayout.NORTH, label);
        frame.add(BorderLayout.CENTER, panel);
        frame.setVisible(true);

        while(true){
            checkWinner();
            checkNext(stepListener);
        }

    }

    public void checkWinner() {
        //1 5 9
        if ((arrayList.get(0).getText()=="X") && (arrayList.get(4).getText()=="X") && (arrayList.get(8).getText()=="X")) {
            new WinnerWindow().open("X");
            newGame();
        }
        if ((arrayList.get(0).getText()=="0") && (arrayList.get(4).getText()=="0") && (arrayList.get(8).getText()=="0")) {
            new WinnerWindow().open("0");
            newGame();
        }
        //3 5 7
        if ((arrayList.get(2).getText()=="X") && (arrayList.get(4).getText()=="X") && (arrayList.get(6).getText()=="X")) {
            new WinnerWindow().open("X");
            newGame();
        }
        if ((arrayList.get(2).getText()=="0") && (arrayList.get(4).getText()=="0") && (arrayList.get(6).getText()=="0")) {
            new WinnerWindow().open("0");
            newGame();
        }
        //1 2 3
        if ((arrayList.get(0).getText()=="X") && (arrayList.get(1).getText()=="X") && (arrayList.get(2).getText()=="X")) {
            new WinnerWindow().open("X");
            newGame();
        }
        if ((arrayList.get(0).getText()=="0") && (arrayList.get(1).getText()=="0") && (arrayList.get(2).getText()=="0")) {
            new WinnerWindow().open("0");
            newGame();
        }
        //4 5 6
        if ((arrayList.get(3).getText()=="X") && (arrayList.get(4).getText()=="X") && (arrayList.get(5).getText()=="X")) {
            new WinnerWindow().open("X");
            newGame();
        }
        if ((arrayList.get(3).getText()=="0") && (arrayList.get(4).getText()=="0") && (arrayList.get(5).getText()=="0")) {
            new WinnerWindow().open("0");
            newGame();
        }
        //7 8 9
        if ((arrayList.get(6).getText()=="X") && (arrayList.get(7).getText()=="X") && (arrayList.get(8).getText()=="X")) {
            new WinnerWindow().open("X");
            newGame();
        }
        if ((arrayList.get(6).getText()=="0") && (arrayList.get(7).getText()=="0") && (arrayList.get(8).getText()=="0")) {
            new WinnerWindow().open("0");
            newGame();
        }
        //1 4 7
        if ((arrayList.get(0).getText()=="X") && (arrayList.get(3).getText()=="X") && (arrayList.get(6).getText()=="X")) {
            new WinnerWindow().open("X");
            newGame();
        }
        if ((arrayList.get(0).getText()=="0") && (arrayList.get(3).getText()=="0") && (arrayList.get(6).getText()=="0")) {
            new WinnerWindow().open("0");
            newGame();
        }
        //2 5 8
        if ((arrayList.get(1).getText()=="X") && (arrayList.get(4).getText()=="X") && (arrayList.get(7).getText()=="X")) {
            new WinnerWindow().open("X");
            newGame();
        }
        if ((arrayList.get(1).getText()=="0") && (arrayList.get(4).getText()=="0") && (arrayList.get(7).getText()=="0")) {
            new WinnerWindow().open("0");
            newGame();
        }
        //7 8 9
        if ((arrayList.get(6).getText()=="X") && (arrayList.get(7).getText()=="X") && (arrayList.get(8).getText()=="X")) {
            new WinnerWindow().open("X");
            newGame();
        }
        if ((arrayList.get(6).getText()=="0") && (arrayList.get(7).getText()=="0") && (arrayList.get(8).getText()=="0")) {
            new WinnerWindow().open("0");
            newGame();
        }
    }

    public void checkNext(StepListener stepListener){
        if (stepListener.isXStep())
            label.setText("\"X\" is next");
        else
            label.setText("\"0\" is next");
    }

    public void newGame() {
        for (int i = 0; i < arrayList.size(); i++) {
            MyButton button = arrayList.get(i);
            if (!button.equals(null))
                button.setText("");
            if (!stepListener.equals(null))
                stepListener.setIsXStep(true);
        }
    }

}
