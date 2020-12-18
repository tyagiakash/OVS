package window.updatevoter;

import javax.swing.*;
import java.awt.*;

public class MenuPanelUpdate extends JPanel {

    private JButton updateBtn;
    private JButton closeBtn;
    private JLabel titleLabel;

    public MenuPanelUpdate(){

        //Setting Up Height of the panel and giving a border to it..
        Dimension dm = getPreferredSize();
        dm.height = 45;
        setPreferredSize(dm);
        setBorder(BorderFactory.createEtchedBorder());

        //Setting up layout to this panel @Relative Layout...
        setLayout(null);

        //initializing components...
        updateBtn = new JButton("Update");
        closeBtn = new JButton("Close");
        titleLabel = new JLabel("...Update Voter Data...");

        //Adding theses Buttons to Layout..
        add(titleLabel);
        add(updateBtn);
        add(closeBtn);

        //Setting Their  positions to the layout..
        updateBtn.setBounds(10,9,120,26);
        titleLabel.setBounds(255,9,130,26);
        closeBtn.setBounds(515,9,80,26);
    }
}
