package splash;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
/*
This class is to make a frame that appear's as a loading screen
 */

public class LodingScreen extends JPanel {
    private JLabel loaderLabel;

    public LodingScreen(){


        setLayout(new BorderLayout());


        loaderLabel = new JLabel();
        loaderLabel.setIcon(new ImageIcon("src/images/loading.gif"));
        loaderLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(loaderLabel,BorderLayout.CENTER);

        setVisible(true);

    }
}
