package window;

import controller.Controller;
import window.createelection.CreateElection;
import window.viewelection.ViewElections;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    MenuPanel menuPanel;
    CreateElection createElection;
    ViewElections viewElections;
    JPanel contentPanel;




    public MainWindow(){
        super("Online Voting System(OVS)");
        setBounds(0,0,800,600);
        setResizable(false);
        setLayout(new BorderLayout());


        //Makes Window to Start form Center not from the Corner
        setLocationRelativeTo(null);

        //Setting On Close OPeration to Exist the Application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create Instances of Components
        menuPanel = new MenuPanel();
        contentPanel = new JPanel();

        //Setting Up Content Panel Layout and Border
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBorder(BorderFactory.createEtchedBorder());

        //Adding Panels to the Frame
        add(menuPanel,BorderLayout.WEST);
        add(contentPanel,BorderLayout.CENTER);

        //Setting Visiblity of Frame
        setVisible(true);

        //Getting Data(Button Name) From MenuPanel Event Listner
        menuPanel.setButtonListner(new MenuListner() {
            @Override
            public void buttonClicked(String btn) {
                //Checking Which Panel is to Open
                if(btn.equals("btn1")){
                    //Creating New Instance each time so that Data may be Refreshed..
                    createElection =new CreateElection();
                    changePanel(createElection);
                }
                else if(btn.equals("btn2")){
                    viewElections = new ViewElections();
                    changePanel(viewElections);
                }

            }
        });

    }

    //Function for Changing Dynamically Jpanels
    private void changePanel(JPanel panel){
        contentPanel.removeAll();      // Remove Current Panel if any
        contentPanel.add(panel);       // Adding a new Panel
        contentPanel.repaint();        // After Adding repaint the Panel
        contentPanel.revalidate();     // Revalidate the order hierarchy
    }

}
