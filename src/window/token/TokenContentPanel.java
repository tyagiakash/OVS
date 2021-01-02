package window.token;

import model.TokenData;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/*
this class if for storing all Election Info  that a Voter is Eligible and Generating Token for the same..
 */

public class TokenContentPanel extends JPanel {

    //Creating a Array List for Token Card Panels each panle is represented a single election..
    private ArrayList<TokenCard> tokenCards = new ArrayList<>();
    private ArrayList<TokenData> tokenData;




    public TokenContentPanel(ArrayList<TokenData> tokenData,Integer voterId){

        setPreferredSize(new Dimension(600,0));

        this.tokenData = tokenData;

        //Setting Up layout to Grid Layout....
        setLayout(new FlowLayout(FlowLayout.CENTER,25,25));

        //Setting Background Color to Whilt
        setBackground(Color.decode("#ffffff"));


        //Initialing Token Cards...
        for (int i = 0;i<tokenData.size();i++){
            if (tokenData.get(i).getElectionStatus().equals("upcoming")) {
                TokenCard tokenCard = new TokenCard(tokenData.get(i).getElectionId(), tokenData.get(i).getVoterName(), tokenData.get(i).getElectionTitle(), tokenData.get(i).getElectionStatus(), tokenData.get(i).getToken(), tokenData.get(i).getTokenDate(), voterId);
                tokenCards.add(tokenCard);
            }
        }

        //Adding Cards to the layout...
        for (int i = 0;i<tokenData.size();i++){
            add(tokenCards.get(i));
        }



    }
}
