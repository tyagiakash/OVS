package login;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

     private  FormPanel formPanel;

    public MainFrame(){
        // Calling Constructor of Jframe for Setting Title
        super("Online Voting System");

        // Setting The Layout of The Frame as Border Layout
        setLayout(new BorderLayout());

        // Initializing Image Panel and Assigning Path of  the Image
        ImagePanel panel = new ImagePanel(new ImageIcon(getClass()
                .getResource("/images/start.jpg"))
                .getImage());

        // Creating Instance o f Form Panel
        formPanel = new FormPanel();

        //Adding Panel to the login.MainFrame Layout @WEST
        add(panel,BorderLayout.WEST);

        //Adding Form Panel to the login.MainFrame Layout @ EAST
        add(formPanel,BorderLayout.EAST);

        // Setting the Dimensions of Login Frame Layot
        setBounds(10,10,650,450);

        // Setting Resizable to false , we don't want to cutomize size further
        setResizable(false);

        //Set Visiblity of Login Frame
        setVisible(true);

        // Setting Close Button Behaviour
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        formPanel.setFormListener(e -> {
            String userId = e.getUserId();
            String password = e.getPassword();
            String userType = e.getUserType();
            System.out.println(userId + " , " +  password + " and " + userType);
        });

    }
}
