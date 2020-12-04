package login;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel  extends JPanel {

    private JLabel userIdLabel;
    private JLabel passwordLabel;
    private JLabel userLabel;
    private JTextField userIdTextField;
    private JPasswordField passwordField;
    private JRadioButton ecAdmin;
    private JRadioButton eoAdmin;
    private ButtonGroup user;
    private JButton btnLogIn;
    private Formlistner  formlistner;

    public FormPanel(){

        // Setting Up Dimensions for Form Panel
        Dimension dim =getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        // Setting Up Background Color and inner and Outer Border
        setBackground(Color.decode("#ffffff"));
        Border inner = BorderFactory.createTitledBorder("Log In");
        Font font = new Font("Promesh", Font.BOLD, 18);
        Border thatBorder = new TitledBorder(inner, "Log In",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, font, Color.decode("#c76191"));
        Border outer = BorderFactory.createEmptyBorder(5,0,0,0);
        setBorder(BorderFactory.createCompoundBorder(outer,thatBorder));




        //Initializing variables
        userLabel = new JLabel("User :");
        userIdLabel = new JLabel("User Id: ");
        passwordLabel = new JLabel("Password: ");
        userIdTextField = new JTextField(10);
        passwordField = new JPasswordField(10);
        //Changing Echo char from dot to  star.
        passwordField.setEchoChar('*');
        ecAdmin = new JRadioButton("EC Admin");
        eoAdmin = new JRadioButton("EO Admin");
        user = new ButtonGroup();
        btnLogIn = new JButton("Login");

        //Setting Up Buttons Color
        btnLogIn.setBackground(Color.decode("#5975ba"));
        btnLogIn.setForeground(Color.WHITE);
        ecAdmin.setBackground(Color.decode("#ffffff"));
        eoAdmin.setBackground(Color.decode("#ffffff"));
        eoAdmin.setForeground(Color.decode("#5975ba"));
        ecAdmin.setForeground(Color.decode("#5975ba"));


        //Setting Up Font
        Font italicFont = new Font("Roboto", Font.BOLD, 15);
        userIdLabel.setFont(italicFont);
        passwordLabel.setFont(italicFont);
        userLabel.setFont(italicFont);

        //Removing Hover Focus From eo and ec Buttons
        eoAdmin.setFocusPainted(false);
        ecAdmin.setFocusPainted(false);



        //Setting a String on Button Which We can retrive Later
        eoAdmin.setActionCommand("eo");
        ecAdmin.setActionCommand("ec");

        // Adding Click Listner to the Button

        btnLogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userType = user.getSelection().getActionCommand();
                String userId = userIdTextField.getText();
                char [] passwordArray = passwordField.getPassword();
                String password = new String(passwordArray);
                FormEvent ev = new FormEvent(this,userId,password,userType);

                if(formlistner!=null){
                    formlistner.formEventOccured(ev);
                }
            }
        });

        // Adding Radio Button into a Group
        user.add(eoAdmin);
        user.add(ecAdmin);
        eoAdmin.setSelected(true);

        //Setting Up Layout Manager
        setLayout(new GridBagLayout());
        GridBagConstraints gc =new GridBagConstraints();

        // First Row
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weighty = 0.3;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.fill=GridBagConstraints.NONE;  // tells whether a cell takes whole space or not
        gc.insets = new Insets(0,0,0,5);
        add(userLabel,gc);

        gc.gridy = 0;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(eoAdmin,gc);

        gc.gridy = 1;
        gc.gridx = 1;
        gc.weighty = 0.05;
        gc.anchor = GridBagConstraints.LINE_START;
        add(ecAdmin,gc);

        // Second  Row

        gc.gridy = 2;
        gc.gridx = 0;
        gc.weighty = 0.5;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(userIdLabel,gc);

        gc.gridy = 2;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(userIdTextField,gc);


        // Third  Row

        gc.gridy = 3;
        gc.gridx = 0;
        gc.weighty = 0.01;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(passwordLabel,gc);

        gc.gridy = 3;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(passwordField,gc);

        //Fourth Row..

        gc.gridy = 4;
        gc.gridx = 1;
        gc.weighty = 3;
        gc.weightx = 1;
        gc.insets = new Insets(15,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(btnLogIn,gc);

    }

    //Setting Form Listner
    public void setFormListener(Formlistner listener){
        this.formlistner = listener;
    }
}
