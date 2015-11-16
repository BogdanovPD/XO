package ru.levelp.java.xo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SaveCurrentCondition implements Serializable, ActionListener {

    MyFrame myFrame;

    public SaveCurrentCondition(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public void serialize() {
        JFrame frame = new JFrame("");
        frame.setBounds(100, 100, 200, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        if (dialogWindow()) {
            JFileChooser saveFile = new JFileChooser();
            int saveOption = saveFile.showSaveDialog(frame);
            try {
                FileOutputStream fos = new FileOutputStream(saveFile.getSelectedFile().getPath());
                ObjectOutputStream os = new ObjectOutputStream(fos);

                os.writeObject(myFrame);

                os.flush();
                os.close();
                fos.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public boolean dialogWindow(){
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would You Like to Save your Current Game Condition?", "Warning", dialogButton);

        if(dialogResult == JOptionPane.YES_OPTION)
            return true;
        else
            return false;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        serialize();
    }
}
