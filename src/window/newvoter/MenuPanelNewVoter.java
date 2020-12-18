package window.newvoter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanelNewVoter extends JPanel implements ActionListener {
    private final JButton newBtn;
    private final JButton searchBtn;
    private final JButton closeBtn;

    //Creating instance of MenuPanelLitner..
    MenuPanelListner listner;

    public MenuPanelNewVoter(){

        //Setting Up Height of the panel and giving a border to it..
        Dimension dm = getPreferredSize();
        dm.height = 45;
        setPreferredSize(dm);
        setBorder(BorderFactory.createEtchedBorder());

        //Setting up layout to this panel @Relative Layout...
        setLayout(null);

        //Initializing  Componentts...
        newBtn = new  JButton("New Voter");
        searchBtn = new JButton("Search Voter");
        closeBtn = new JButton("Close");

        //Adding theses Buttons to Layout..
        add(newBtn);
        add(searchBtn);
        add(closeBtn);

        //Setting Their  positions to the layout..
        searchBtn.setBounds(10,9,130,26);
        newBtn.setBounds(255,9,130,26);
        closeBtn.setBounds(515,9,80,26);

        //Remove text Focus form Buttons...
        newBtn.setFocusPainted(false);
        searchBtn.setFocusPainted(false);
        closeBtn.setFocusPainted(false);

        //Setting ActionListner to the buttons...
        newBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        closeBtn.addActionListener(this);


    }

    //Handling  Actio  Lisner to the Buttons...
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       JButton clickedBtn = (JButton) actionEvent.getSource();
       if (clickedBtn.equals(newBtn)){
           listner.setMenuPanelListnerBtn("newVoter");
       }
       else if (clickedBtn.equals(searchBtn)){
           listner.setMenuPanelListnerBtn("updateVoter");
       }
       else if (clickedBtn.equals(closeBtn)){
          listner.setMenuPanelListnerBtn("close");
       }

    }

    //Setting MenuPanelNewVoter Listner to this class as same as in VoterPanel Class...
    public void setMenuPanelListner(MenuPanelListner listner){
        this.listner = listner;
    }
}
