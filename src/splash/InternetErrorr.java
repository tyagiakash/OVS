package splash;

import javax.swing.*;
import java.awt.*;
/*
This is class for Showing an Error for NO Internet...
 */

public class InternetErrorr extends JFrame {

    private JLabel imgLabel = new JLabel();

    public InternetErrorr(){

        super(" (OVS) Internet Connection Error!!");
        setSize(500,380);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imgLabel.setIcon(new ImageIcon("src/images/internetError.gif"));
        add(imgLabel,BorderLayout.CENTER);
        setVisible(true);
    }
}
