package ru.levelp.java.xo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinnerWindow {

    public void open(String winner) {
        JFrame frame = new JFrame("About");
        frame.setBounds(100, 100, 200, 100);

        JLabel email = new JLabel(winner + " wins!");

        JButton okButton = new JButton("ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel panel = new JPanel();
        panel.add(okButton);

        frame.add(BorderLayout.CENTER, email);
        frame.add(BorderLayout.SOUTH, panel);

        frame.setVisible(true);
    }

}
