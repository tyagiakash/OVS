package splash;

import model.Database;

import javax.swing.*;
import java.awt.*;
/*
This class is only for Act as Splash duting starting og the screen...
 */

public class SplashScreen extends JFrame {

    private JLabel imgLabel;
    private JProgressBar pBar;

    public SplashScreen(){
        setSize(650,450);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting layout to absolute..
        setLayout(null);

        //Initializing Components...
        imgLabel = new JLabel();
        pBar = new JProgressBar(0,2000);
        imgLabel.setIcon(new ImageIcon("src/images/splsh.gif"));

        //Setting Initial o% to Progress Bar..
        pBar.setValue(0);
        pBar.setStringPainted(true);

        //Adding Compoents..
        add(imgLabel);
        add(pBar);

        //SetBounds...
        imgLabel.setBounds(0,0,650,425);
        pBar.setBounds(0,425,650,25);
        pBar.setBackground(Color.WHITE);
        pBar.setForeground(Color.decode("#BC3FFE"));
        pBar.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        setLocationRelativeTo(null);
        setUndecorated(true);
        pBar.setIndeterminate(true);
        pBar.setString("loading...");
    }

}
