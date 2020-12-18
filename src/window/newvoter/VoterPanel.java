package window.newvoter;

import controller.Controller;
import window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class VoterPanel extends JPanel {

    //Creating object of MenuPanelNewVoter..
    private MenuPanelNewVoter menuPanelNewVoter;
    private NewVoterRegistrationPanel newVoterRegistrationPanel;


    //Creating Instance of Controller... to make connection with DB
    Controller controller;

    public VoterPanel(){
        setBackground(Color.GREEN);

        //Setting Layout to this panel @BorderLayout..
        setLayout(new BorderLayout());

        //Initialing panels/Components..
        menuPanelNewVoter = new MenuPanelNewVoter();
        newVoterRegistrationPanel = new NewVoterRegistrationPanel();
        controller = new Controller();

        //Adding Componennts to this panel...
        add(menuPanelNewVoter,BorderLayout.NORTH);

        //Getting which Button is clicked in MenuPanelNewVoter through MennuPanelListner. ..
        menuPanelNewVoter.setMenuPanelListner(new MenuPanelListner() {
            @Override
            public void setMenuPanelListnerBtn(String btn) {
                if (btn == "newVoter"){

                    //Opening adding @newVoterRegistrationPanel and revalidate the panel...
                    add(newVoterRegistrationPanel,BorderLayout.CENTER);
                    revalidate();
                }
                else if (btn == "updateVoter"){

                }
                else if (btn == "close"){
                    JFrame parent =(JFrame)getTopLevelAncestor();
                    parent.dispose();
                    new MainWindow();
                }
            }
        });

        //Setting Up Listner to the newVoterRegistrationPanel for getting up event so that we fetch the data throughit..
        newVoterRegistrationPanel.setVoterRegistrationPanelListner(new NewVoterRegistrationPanelListner() {
            @Override
            public void newRegistrtionPanelEventOccured(NewVoterRegistrationPanelEvent e) throws FileNotFoundException, SQLException {
                 controller.addVoterDetails(e);
            }
        });
    }
}
