package window.voter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener {
    private final JButton newBtn;
    private final JButton updateBtn;
    private final JButton closeBtn;

    //Creating instance of MenuPanelLitner..
    MenuPanelListner listner;

    public MenuPanel(){

        //Setting Up Height of the panel and giving a border to it..
        Dimension dm = getPreferredSize();
        dm.height = 45;
        setPreferredSize(dm);
        setBorder(BorderFactory.createEtchedBorder());

        //Setting up layout to this panel @Relative Layout...
        setLayout(null);

        //Initializing  Componentts...
        newBtn = new  JButton("New Voter");
        updateBtn = new JButton("Update Voter");
        closeBtn = new JButton("Close");

        //Adding theses Buttons to Layout..
        add(newBtn);
        add(updateBtn);
        add(closeBtn);

        //Setting Their  positions to the layout..
        newBtn.setBounds(25,9,120,26);
        updateBtn.setBounds(270,9,130,26);
        closeBtn.setBounds(515,9,80,26);

        //Remove text Focus form Buttons...
        newBtn.setFocusPainted(false);
        updateBtn.setFocusPainted(false);
        closeBtn.setFocusPainted(false);

        //Setting ActionListner to the buttons...
        newBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        closeBtn.addActionListener(this);


    }

    //Handling  Actio  Lisner to the Buttons...
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       JButton clickedBtn = (JButton) actionEvent.getSource();
       if (clickedBtn.equals(newBtn)){
           listner.setMenuPanelListnerBtn("newVoter");
       }
       else if (clickedBtn.equals(updateBtn)){
           listner.setMenuPanelListnerBtn("updateVoter");
       }
       else if (clickedBtn.equals(closeBtn)){
          listner.setMenuPanelListnerBtn("close");
       }

    }

    //Setting MenuPanel Listner to this class as same as in VoterPanel Class...
    public void setMenuPanelListner(MenuPanelListner listner){
        this.listner = listner;
    }
}
