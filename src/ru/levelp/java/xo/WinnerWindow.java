package ru.levelp.java.xo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinnerWindow {

    public void open(String winner, String frameStyle) {
        JFrame frame = new JFrame("");
        frame.setBounds(100, 100, 200, 100);

        JLabel winnerLabel = new JLabel(winner + " wins!");

        MyButton okButton = new MyButton("ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(okButton);

        frame.add(BorderLayout.CENTER, winnerLabel);
        frame.add(BorderLayout.SOUTH, panel);

        if (frameStyle.equals("blue")){
            winnerLabel.setForeground(Color.DARK_GRAY);
            panel.setBackground(Color.CYAN);
            okButton.setStyle(new Font("Arial", Font.BOLD, 15), Color.WHITE, Color.BLUE);

        }
        else{
            winnerLabel.setForeground(Color.DARK_GRAY);
            panel.setBackground(Color.RED);
            okButton.setStyle(new Font("Arial", Font.BOLD, 15), Color.WHITE, Color.PINK);
        }

        frame.setVisible(true);
    }

}
