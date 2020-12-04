package window.createelection;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConfirmDialog extends JDialog {

    private JButton btnOk;
    private JLabel imgLabel1;
    private JLabel imgLabel2;
    private JLabel nameLabel;
    private JLabel electionIdLabel;

    public ConfirmDialog(String mImgPath,String mSymPath,String mName,String mElectionId){
        super();

        setTitle("Data Saved Successfully !!");
        setSize(450,300);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(getParent());

        //Initialization Objects
        imgLabel1 = new JLabel();
        imgLabel2 = new JLabel();
        nameLabel = new JLabel("Name: "+mName+":");
        electionIdLabel =new JLabel("Election Id: "+mElectionId+":");
        btnOk = new JButton("OK");
        btnOk.setFocusPainted(false);

        //Setting Listner On @btnOk
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        //Resizing Images @Candidate Image
        ImageIcon imgIcon1 = new ImageIcon(mImgPath);

        Image imgTemp = imgIcon1.getImage();

        Image modifiedImgIcon = imgTemp.getScaledInstance(90,90,Image.SCALE_SMOOTH);

        imgIcon1 = new ImageIcon(modifiedImgIcon);

        //Resizing Images@Election Symbol
        ImageIcon imgIcon2 = new ImageIcon(mSymPath);
        imgTemp = imgIcon2.getImage();
        modifiedImgIcon = imgTemp.getScaledInstance(90,90,Image.SCALE_SMOOTH);
        imgIcon2 = new ImageIcon(modifiedImgIcon);


        //Setting Images on Jlabels
        imgLabel1.setIcon(imgIcon1);
        imgLabel2.setIcon(imgIcon2);


        //Making UI uisng Grid Bag layout
        GridBagConstraints gc =new GridBagConstraints();

        //Row 1:
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx =1;
        gc.weighty =1;
        gc.insets = new Insets(0,0,0,20);
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        add(nameLabel,gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(imgLabel1,gc);

        //Row 2:
        gc.gridy = 1;
        gc.gridx = 0;
        gc.weightx =1;
        gc.weighty =1;
        gc.insets = new Insets(0,0,0,20);
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        add(electionIdLabel,gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(10,0,0,10);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(imgLabel2,gc);

        //Row 3
        gc.gridy = 2;
        gc.gridx = 1;
        gc.weighty = 1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(btnOk,gc);

    }

}
