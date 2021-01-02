package window.token;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.sql.Timestamp;
/*
This is class if  for Basic Structure of the Card that shows election and Token info
related to a particular election  of Voter...
 */

public class TokenCard extends JPanel {

    private JLabel electionTitileLabel;
    private JLabel electionIdTitlelabel;
    private JLabel electionIdLabel;
    private JLabel voterIdTitleLabel;
    private JLabel voterIdLabel;
    private JLabel voterNameTitleLabel;
    private JLabel voterNameLabel;
    private JLabel tokenTitleLabel;
    private JLabel tokenLabel;
    private JButton tokenGenBtn;
    private JLabel tokenDateTitle;
    private JLabel tokenDateLB;


    //Creating instnace of FinlaTokenGeneratot...
    private FinalTokenGenerate finalTokenGenerate;


    public TokenCard(String electionId, String voterName, String electionTitle, String electionStatus, Integer token, Timestamp tokenDate,Integer voterId){

        //Setting Up Height and Width for a Card...
        setPreferredSize(new Dimension(240,180));
        if (tokenDate == null) {
            setBackground(Color.decode("#a6f5b3"));
        }
        else {
            setBackground(Color.decode("#f26555"));
        }
        setBorder(BorderFactory.createEtchedBorder(Color.LIGHT_GRAY,Color.LIGHT_GRAY));

        //Setting Up Layout as a Absolut....
        setLayout(null);

        //Initializing Components...
        electionTitileLabel = new JLabel(electionTitle);
        electionIdTitlelabel = new JLabel("ElectionId : ");
        electionIdLabel = new JLabel(electionId);
        voterIdTitleLabel = new JLabel("VoterId     : ");
        voterIdLabel = new JLabel(voterId.toString());
        voterNameTitleLabel = new JLabel("Name        : ");
        voterNameLabel = new JLabel(voterName);
        tokenTitleLabel = new JLabel("Token       : ");
        tokenLabel = new JLabel(token.toString());
        tokenGenBtn = new JButton("Generate Token");
        tokenDateTitle = new JLabel("Date         : ");
        tokenDateLB = new JLabel("");


        if(tokenDate == null){
            tokenLabel.setText("Not Generated");
        }
        else {
            tokenLabel.setText(token.toString());
            tokenDateLB.setText(tokenDate.toString());
            tokenGenBtn.setText("Print Token Slip");
        }

        //Designing Btn
        tokenGenBtn.setFocusPainted(false);
        tokenGenBtn.setBackground(Color.decode("#849fe3"));
        tokenGenBtn.setForeground(Color.white);
        tokenGenBtn.setBorderPainted(false);
        tokenGenBtn.setFocusable(false);

        //Adding Components to the Layout..
        add(electionTitileLabel);
        add(electionIdTitlelabel);
        add(electionIdLabel);
        add(voterIdTitleLabel);
        add(voterIdLabel);
        add(voterNameTitleLabel);
        add(voterNameLabel);
        add(tokenTitleLabel);
        add(tokenLabel);
        add(tokenGenBtn);
        add(tokenDateTitle);
        add(tokenDateLB);

        //SetBounds ..
        electionTitileLabel.setBounds(20,20,230,20);
        electionIdTitlelabel.setBounds(20,40,85,20);
        electionIdLabel.setBounds(105,40,150,20);
        voterIdTitleLabel.setBounds(20,60,85,20);
        voterIdLabel.setBounds(105,60,150,20);
        voterNameTitleLabel.setBounds(20,80,85,20);
        voterNameLabel.setBounds(105,80,150,20);
        tokenTitleLabel.setBounds(20,100,85,20);
        tokenLabel.setBounds(105,100,150,20);
        tokenDateTitle.setBounds(20,120,85,20);
        tokenDateLB.setBounds(105,120,130,20);
        tokenGenBtn.setBounds(40,145,150,25);

        //Adding Listner to the Button..
        tokenGenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    finalTokenGenerate = new FinalTokenGenerate(electionId,voterName,electionTitle,electionStatus,token,tokenDate,voterId);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                setBackground(Color.decode("#f26555"));
                tokenGenBtn.setText("Print Token Slip");
                tokenDateLB.setText(timestamp.toString());
                revalidate();
                repaint();
            }
        });
    }

}
