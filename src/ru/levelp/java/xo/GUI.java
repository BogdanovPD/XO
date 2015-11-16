package ru.levelp.java.xo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;

public class GUI implements Serializable {

    protected ArrayList<MyButton> arrayList = new ArrayList<MyButton>();
    protected StepListener stepListener = new StepListener(this);
    protected JLabel label = new JLabel();
    protected boolean isXStep = true;
    protected MyFrame frame = new MyFrame("X0");
    protected JMenuBar bar;
    protected JPanel panel;
    protected GridLayout gridLayout = new GridLayout(3, 3);
    JMenuItem view = new JMenuItem("Red style");

    //protected Font buttonFont;
    //protected Color backgroundButtonColor;
    //protected Color foregroundButtonColor;

    public void build() {

        bar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu viewMenu = new JMenu("View");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        JMenuItem quitMenuItem = new JMenuItem("Quit");
        //JMenuItem redView = new JMenuItem("Red style");
        JMenuItem bigView = new JMenuItem("Big window");
        JMenuItem normalView = new JMenuItem("Normal window");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem openItem = new JMenuItem("Open");
        normalView.setEnabled(false);

        aboutMenuItem.addActionListener(new AboutListener(this));

        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });

        quitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        bigView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setBounds(100, 100, 600, 600);
                for (int i = 0; i < arrayList.size(); i++) {
                    Font oldFont = arrayList.get(i).getFont();
                    arrayList.get(i).setFont(new Font(oldFont.getFontName(), oldFont.getStyle(), oldFont.getSize() + 20));
                }
                bigView.setEnabled(false);
                normalView.setEnabled(true);
            }
        });

        normalView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setBounds(100, 100, 300, 300);
                for (int i = 0; i < arrayList.size(); i++) {
                    Font oldFont = arrayList.get(i).getFont();
                    arrayList.get(i).setFont(new Font(oldFont.getFontName(), oldFont.getStyle(), oldFont.getSize() - 20));
                }
                bigView.setEnabled(true);
                normalView.setEnabled(false);
            }
        });

        view.addActionListener(new SwitchGUI_Listener(this));
        saveItem.addActionListener(new SaveCurrentCondition(this));
        openItem.addActionListener(new OpenCondition(this));

        fileMenu.add(newGameMenuItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(quitMenuItem);
        //viewMenu.add(redView);
        viewMenu.add(view);
        viewMenu.add(bigView);
        viewMenu.add(normalView);
        bar.add(fileMenu);
        bar.add(viewMenu);
        bar.add(aboutMenuItem);

        panel = new JPanel();
        frame.add(panel);

        panel.setLayout(gridLayout);

        for (int i = 0; i < 9; i++) {
            arrayList.add(new MyButton());
            arrayList.get(i).addActionListener(stepListener);
            panel.add(arrayList.get(i));
        }

        gridLayout.setHgap(10);
        gridLayout.setVgap(10);
        panel.setBackground(Color.CYAN);
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList.get(i).setStyle(new Font("Arial", Font.BOLD, 30), Color.WHITE, Color.BLUE);
        }


        frame.setJMenuBar(bar);
        frame.add(BorderLayout.NORTH, label);
        frame.add(BorderLayout.CENTER, panel);

        frame.setVisible(true);

    }

    public void checkWinner() {
        //1 5 9
        if ((arrayList.get(0).getText().equals("X")) && (arrayList.get(4).getText().equals("X")) && (arrayList.get(8).getText().equals("X"))) {
            new WinnerWindow().open("X", frame.frameStyle);
            newGame();
        }
        if ((arrayList.get(0).getText().equals("0")) && (arrayList.get(4).getText().equals("0")) && (arrayList.get(8).getText().equals("0"))) {
            new WinnerWindow().open("0", frame.frameStyle);
            newGame();
        }
        //3 5 7
        if ((arrayList.get(2).getText().equals("X")) && (arrayList.get(4).getText().equals("X")) && (arrayList.get(6).getText().equals("X"))) {
            new WinnerWindow().open("X", frame.frameStyle);
            newGame();
        }
        if ((arrayList.get(2).getText().equals("0")) && (arrayList.get(4).getText().equals("0")) && (arrayList.get(6).getText().equals("0"))) {
            new WinnerWindow().open("0", frame.frameStyle);
            newGame();
        }
        //1 2 3
        if ((arrayList.get(0).getText().equals("X")) && (arrayList.get(1).getText().equals("X")) && (arrayList.get(2).getText().equals("X"))) {
            new WinnerWindow().open("X", frame.frameStyle);
            newGame();
        }
        if ((arrayList.get(0).getText().equals("0")) && (arrayList.get(1).getText().equals("0")) && (arrayList.get(2).getText().equals("0"))) {
            new WinnerWindow().open("0", frame.frameStyle);
            newGame();
        }
        //4 5 6
        if ((arrayList.get(3).getText().equals("X")) && (arrayList.get(4).getText().equals("X")) && (arrayList.get(5).getText().equals("X"))) {
            new WinnerWindow().open("X", frame.frameStyle);
            newGame();
        }
        if ((arrayList.get(3).getText().equals("0")) && (arrayList.get(4).getText().equals("0")) && (arrayList.get(5).getText().equals("0"))) {
            new WinnerWindow().open("0", frame.frameStyle);
            newGame();
        }
        //7 8 9
        if ((arrayList.get(6).getText().equals("X")) && (arrayList.get(7).getText().equals("X")) && (arrayList.get(8).getText().equals("X"))) {
            new WinnerWindow().open("X", frame.frameStyle);
            newGame();
        }
        if ((arrayList.get(6).getText().equals("0")) && (arrayList.get(7).getText().equals("0")) && (arrayList.get(8).getText().equals("0"))) {
            new WinnerWindow().open("0", frame.frameStyle);
            newGame();
        }
        //1 4 7
        if ((arrayList.get(0).getText().equals("X")) && (arrayList.get(3).getText().equals("X")) && (arrayList.get(6).getText().equals("X"))) {
            new WinnerWindow().open("X", frame.frameStyle);
            newGame();
        }
        if ((arrayList.get(0).getText().equals("0")) && (arrayList.get(3).getText().equals("0")) && (arrayList.get(6).getText().equals("0"))) {
            new WinnerWindow().open("0", frame.frameStyle);
            newGame();
        }
        //2 5 8
        if ((arrayList.get(1).getText().equals("X")) && (arrayList.get(4).getText().equals("X")) && (arrayList.get(7).getText().equals("X"))) {
            new WinnerWindow().open("X", frame.frameStyle);
            newGame();
        }
        if ((arrayList.get(1).getText().equals("0")) && (arrayList.get(4).getText().equals("0")) && (arrayList.get(7).getText().equals("0"))) {
            new WinnerWindow().open("0", frame.frameStyle);
            newGame();
        }
        //7 8 9
        if ((arrayList.get(6).getText().equals("X")) && (arrayList.get(7).getText().equals("X")) && (arrayList.get(8).getText().equals("X"))) {
            new WinnerWindow().open("X", frame.frameStyle);
            newGame();
        }
        if ((arrayList.get(6).getText().equals("0")) && (arrayList.get(7).getText().equals("0")) && (arrayList.get(8).getText().equals("0"))) {
            new WinnerWindow().open("0", frame.frameStyle);
            newGame();
        }
    }

    public void newGame() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) != null)
                arrayList.get(i).setText("");
            label.setText("\"X\" is next");
            setIsXStep(true);
        }
    }

    public boolean isXStep() {
        return isXStep;
    }

    public void setIsXStep(boolean isXStep) {
        this.isXStep = isXStep;
    }
}
