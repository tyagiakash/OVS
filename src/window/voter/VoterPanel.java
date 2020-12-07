package window.voter;

import javax.swing.*;
import java.awt.*;

public class VoterPanel extends JPanel {

    //Creating object of MenuPanel..
    private MenuPanel menuPanel;
    private NewVoterRegistrationPanel newVoterRegistrationPanel;

    public VoterPanel(){
        setBackground(Color.GREEN);

        //Setting Layout to this panel @BorderLayout..
        setLayout(new BorderLayout());

        //Initialing panels/Components..
        menuPanel = new MenuPanel();
        newVoterRegistrationPanel = new NewVoterRegistrationPanel();

        //Adding Componennts to this panel...
        add(menuPanel,BorderLayout.NORTH);
        add(newVoterRegistrationPanel,BorderLayout.CENTER);

        //Getting which Button is clicked in MenuPanel through MennuPanelListner. ..
        menuPanel.setMenuPanelListner(new MenuPanelListner() {
            @Override
            public void setMenuPanelListnerBtn(String btn) {
                if (btn == "newVoter"){
                    System.out.println(btn);
                }
                else if (btn == "updateVoter"){
                    System.out.println(btn);
                }
                else if (btn == "close"){
                    System.out.println(btn);
                }
            }
        });
    }
}
