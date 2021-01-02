package window;

import splash.LodingScreen;
import window.createelection.CreateElection;
import window.eligiblity.EligibilityPanel;
import window.token.TokenGeneratorPanel;
import window.updatevoter.UpdateVoterPanel;
import window.viewelection.ViewElections;
import window.newvoter.VoterPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class MainWindow extends JFrame {

    private MenuPanel menuPanel;
    private CreateElection createElection;
    private ViewElections viewElections;
    private VoterPanel voterPanel;
    private UpdateVoterPanel updateVoterPanel;
    private EligibilityPanel eligibilityPanel;
    private TokenGeneratorPanel tokenGeneratorPanel;
    private JPanel contentPanel;




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


        //Setting Up Content Panel Layout
        contentPanel.setLayout(null);

        //Designing DashBoard adding Images and Text to it...
        //Adding An Image to img Label for dashBoard Image and align it to centre of the Label..
        JLabel imgLabel = new JLabel(new ImageIcon("src/images/mai.png"));
        imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel logoText = new JLabel("OVS");
        JLabel logoCap = new JLabel("Change the Way of Voting...");
        logoText.setFont(new Font("Ubuntu",Font.BOLD,30));
        logoText.setForeground(Color.decode("#b3445a"));
        logoCap.setFont(new Font("Arial",Font.ITALIC,9));
        logoCap.setForeground(Color.decode("#849fe3"));

        //Adding Image to content Panel...
        contentPanel.add(imgLabel);
        contentPanel.add(logoText);
        contentPanel.add(logoCap);
        imgLabel.setBounds(0,20,610,580);
        logoText.setBounds(15,15,100,50);
        logoCap.setBounds(62,54,300,15);

        contentPanel.setLayout(new BorderLayout());

        /////Dashboard Design Ends....../////

        //Adding Panels to the Frame
        add(menuPanel,BorderLayout.WEST);
        add(contentPanel,BorderLayout.CENTER);


        //Setting Visiblity of Frame
        setVisible(true);

        //Getting Data(Button Name) From MenuPanelNewVoter Event Listner
        menuPanel.setButtonListner(new MenuListner() {
            @Override
            public void buttonClicked(String btn) throws SQLException, IOException {
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
                else if (btn.equals("btn3")){
                    voterPanel =new VoterPanel();
                    changePanel(voterPanel);
                }
                else if (btn.equals("btn4")){
                    updateVoterPanel = new UpdateVoterPanel();
                    changePanel(updateVoterPanel);
                }
                else if (btn.equals("btn5")){
                    eligibilityPanel = new EligibilityPanel();
                    changePanel(eligibilityPanel);
                }
                else if (btn.equals("btn6")){
                    tokenGeneratorPanel = new TokenGeneratorPanel();
                    changePanel(tokenGeneratorPanel);
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
