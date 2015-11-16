package ru.levelp.java.xo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchGUI_Listener implements ActionListener {

    private GUI gui;

    public SwitchGUI_Listener(GUI gui){
        this.gui= gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        refresh();
    }

    public void refresh(){
        if (gui.frame.frameStyle.equals("blue")) {
            gui.gridLayout.setHgap(10);
            gui.gridLayout.setVgap(10);
            gui.panel.setBackground(Color.RED);
            for (int i = 0; i < gui.arrayList.size(); i++) {
                gui.arrayList.get(i).setStyle(new Font("Arial", Font.BOLD, 30), Color.WHITE, Color.PINK);
            }
            gui.frame.setVisible(true);
            gui.view.setText("Blue style");
            gui.frame.frameStyle = "red";
        }
        else{
            gui.gridLayout.setHgap(10);
            gui.gridLayout.setVgap(10);
            gui.panel.setBackground(Color.CYAN);
            for (int i = 0; i < gui.arrayList.size(); i++) {
                gui.arrayList.get(i).setStyle(new Font("Arial", Font.BOLD, 30), Color.WHITE, Color.BLUE);
            }
            gui.frame.setVisible(true);
            gui.view.setText("Red style");
            gui.frame.frameStyle = "blue";
        }
    }

}
