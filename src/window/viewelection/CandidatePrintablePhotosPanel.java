package window.viewelection;

import javax.swing.*;
import java.awt.*;

public class CandidatePrintablePhotosPanel extends JPanel {


    //Creating Instance Of JLabel for Name
    private JLabel nameLabel;
    private JLabel photoLabel;
    private JLabel symbolLabel;

    public CandidatePrintablePhotosPanel(ImageIcon mPhotoIcon,ImageIcon mSymbolPhotoIcon,String mName){


        setBorder(BorderFactory.createMatteBorder(0,1,1,1,Color.LIGHT_GRAY));
        setBackground(Color.decode("#ffffff"));
        Dimension dm = getPreferredSize();
        dm.height = 120;
        setPreferredSize(dm);
        GridLayout layout =new GridLayout(1,3);
        setLayout(layout);

        //Initializing Compoonents

        nameLabel = new JLabel(mName);
        photoLabel = new JLabel(mPhotoIcon);
        symbolLabel = new JLabel(mSymbolPhotoIcon);

        nameLabel.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.lightGray));
        photoLabel.setBorder(BorderFactory.createMatteBorder(0,0,0,1,Color.lightGray));

        nameLabel.setHorizontalAlignment(JLabel.CENTER);

        add(nameLabel);
        add(photoLabel);
        add(symbolLabel);

    }
}
