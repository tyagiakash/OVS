package window.token;

import controller.Controller;
import model.TokenData;
import window.searchvoter.SearchFrame;
import window.searchvoter.SearchFrameListner;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class TokenGeneratorPanel extends JPanel {



    private TokenContentPanel tokenContentPanel;
    private String voterId;
    private JPanel notEligiblePanel;

    //Making Instance for Controller...
    private Controller controller;

    public TokenGeneratorPanel() throws IOException, SQLException {

        JScrollBar j = new JScrollBar();

        //Set initial layout to absolute...
        setLayout(new BorderLayout());

        //Initializing Components...
        controller = new Controller();


        //Set Initially Visiblity To False...

        setVisible(false);

        //Poping Up a Input Field to input voterId From User..
        voterId = JOptionPane.showInputDialog(this,"Enter Voter Id");
        //Getting Data Regarding to electionId..
        ArrayList<TokenData> tokenData = controller.getTokenData(Integer.parseInt(voterId));

        if (tokenData.isEmpty()){

            //If data is  empty then showing a panel that data not found..
            notEligiblePanel = new JPanel();
            notEligiblePanel.setBackground(Color.decode("#ffffff"));

            notEligiblePanel.setLayout(null);
            JLabel lb = new JLabel("Voter Not Eligible For Any Upcoming Election");
            JLabel im = new  JLabel(new ImageIcon("src/images/notEligible.gif"));
            lb.setHorizontalAlignment(SwingConstants.CENTER);
            lb.setFont(new Font("Arial",Font.ITALIC,20));
            lb.setForeground(Color.magenta);

            notEligiblePanel.add(im);
            notEligiblePanel.add(lb);
            im.setBounds(80,0,450,450);
            lb.setBounds(50,400,500,30);
            add(notEligiblePanel,BorderLayout.CENTER);
            setVisible(true);

        }
        else {

            //Passing Voters Data to the Content Panel...
            tokenContentPanel = new TokenContentPanel(tokenData,Integer.parseInt(voterId));
            add(new JScrollPane(tokenContentPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),BorderLayout.CENTER);
            setVisible(true);

        }


    }
}
