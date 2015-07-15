package ru.levelp.java.xo;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;


public class About {

    private String frameStyle;

    public About(String frameStyle){
        this.frameStyle = frameStyle;
    }

    public void open() {
        JFrame frame = new JFrame("About");
        frame.setBounds(100, 100, 200, 100);

        JLabel email = new JLabel("bogdanovpd@gmail.com");

        MyButton okButton = new MyButton("ok");
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

        if (frameStyle.equals("blue")){
            email.setForeground(Color.DARK_GRAY);
            panel.setBackground(Color.CYAN);
            okButton.setStyle(new Font("Arial", Font.BOLD, 15), Color.WHITE, Color.BLUE);

        }
        else{
            email.setForeground(Color.DARK_GRAY);
            panel.setBackground(Color.RED);
            okButton.setStyle(new Font("Arial", Font.BOLD, 15), Color.WHITE, Color.PINK);
        }

        frame.setVisible(true);
    }
}