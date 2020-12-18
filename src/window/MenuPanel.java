package window;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class MenuPanel extends JPanel implements ActionListener {


    //Declaring Buttons For Different Function in Menu
    private final JButton btn1;
    private final JButton btn2;
    private final JButton btn3;
    private final JButton btn4;
    private final JButton btn5;
    private final JButton btn6;
    private MenuListner menuListner;

    public MenuPanel(){

        //Set layout to Grid Layout
        setLayout(new GridLayout(0,1,0,15));

        //Setting Up Width of the MenuPanelNewVoter
        Dimension dim = getPreferredSize();
        dim.width = 190;
        setPreferredSize(dim);

        setBackground(Color.decode("#f2edf0"));

        //Creating Border
        Border inner = BorderFactory.createEmptyBorder(40,1,40,1);
        Border outer = BorderFactory.createEtchedBorder();
        setBorder(BorderFactory.createCompoundBorder(outer,inner));



        //Initialization of  the  Buttons
        btn1 = new JButton("Create Election");
        btn2 = new JButton("View Elections");
        btn3 = new JButton("New Voter");
        btn4 = new JButton("Update Voter");
        btn5 = new JButton("Five");
        btn6 = new JButton("Six");


        //Removing Focus Of Button Text
        btn1.setFocusPainted(false);
        btn2.setFocusPainted(false);
        btn3.setFocusPainted(false);
        btn4.setFocusPainted(false);
        btn5.setFocusPainted(false);
        btn6.setFocusPainted(false);




       //Adding all Buttons in the layout
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);

        //Adding Action Listner on Each Button
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);

        //Setting Background Colors For Buttons
        setButtonColor();

    }
    // Getting Event Listner on Button
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        if(clicked == btn1){
            if(menuListner!=null){
                setButtonColor();
                try {
                    menuListner.buttonClicked("btn1");
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
                btn1.setBackground(Color.MAGENTA);

            }
        }
        else if(clicked == btn2){
            if(menuListner!=null){
                setButtonColor();
                try {
                    menuListner.buttonClicked("btn2");
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
                btn2.setBackground(Color.MAGENTA);
            }
        }
        else if(clicked == btn3){
            if(menuListner!=null){
                try {
                    menuListner.buttonClicked("btn3");
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        else if(clicked == btn4){
            if(menuListner!=null){
                try {
                    menuListner.buttonClicked("btn4");
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        else if(clicked == btn5){
            if(menuListner!=null){
                try {
                    menuListner.buttonClicked("btn5");
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        else if(clicked == btn6){
            if(menuListner!=null){
                try {
                    menuListner.buttonClicked("btn6");
                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
    //Listner Method for transferring data
    public void setButtonListner(MenuListner listner){
        this.menuListner = listner;
    }

    //Setting Button Colors
    private void setButtonColor(){
        //Changing Background  and ForeGround Colors Of Buttons
        btn1.setBackground(Color.decode("#849fe3"));
        btn1.setForeground(Color.decode("#ffffff"));
        btn2.setBackground(Color.decode("#849fe3"));
        btn2.setForeground(Color.decode("#ffffff"));
        btn3.setBackground(Color.decode("#849fe3"));
        btn3.setForeground(Color.decode("#ffffff"));
        btn4.setBackground(Color.decode("#849fe3"));
        btn4.setForeground(Color.decode("#ffffff"));
        btn5.setBackground(Color.decode("#849fe3"));
        btn5.setForeground(Color.decode("#ffffff"));
        btn6.setBackground(Color.decode("#849fe3"));
        btn6.setForeground(Color.decode("#ffffff"));
    }
}
