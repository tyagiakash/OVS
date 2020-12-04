package window.viewelection;

import javax.swing.*;
import java.awt.*;

//Class for Creating A TableHeading Link ToolBar Having three Headings
//@Candidate Name , @CandidatePhoto and @Candidate Election Symbol

public class CandidateDetailsHeadingsPanel extends JPanel {

    //Creating Variables for Three Headings
    private JLabel nameLabel;
    private JLabel photoLabel;
    private JLabel symbolLabel;

    public CandidateDetailsHeadingsPanel(){

        //Setting Border,Background,and Layout for Panel
        setBorder(BorderFactory.createEtchedBorder());
        Dimension dm = getPreferredSize();
        dm.height = 20;
        setPreferredSize(dm);
        setBackground(Color.GRAY);
        GridLayout layout =new GridLayout(1,3);
        setLayout(layout);

        //initializing Components
        nameLabel = new JLabel("Candidate Name");
        photoLabel = new JLabel("Candidate Photo");
        symbolLabel = new JLabel("Election Symbol");

        //Adding Label Texts To The Cemter of the Layout
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        photoLabel.setHorizontalAlignment(JLabel.CENTER);
        symbolLabel.setHorizontalAlignment(JLabel.CENTER);

        //Setting Colors for Label Text
        nameLabel.setForeground(Color.WHITE);
        photoLabel.setForeground(Color.WHITE);
        symbolLabel.setForeground(Color.WHITE);

        nameLabel.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.darkGray));
        photoLabel.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.darkGray));
        symbolLabel.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.darkGray));


        //Adding Components to the Layout
        add(nameLabel);
        add(photoLabel);
        add(symbolLabel);

    }
}
