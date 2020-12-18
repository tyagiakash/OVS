package window.searchvoter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.SQLException;

/*
This class is for giving a frame that is used to search a record in
 database..
 */


public class SearchFrame extends JFrame implements ActionListener, ItemListener {

    //Components for searchPanel...
    private JLabel searchByLabel;
    private JComboBox<String> comboBox;
    private JTextField jTextField;
    private JButton searchBtn;
    private String currentItemonCombobox;
    private SearchFrameListner listner;
    private String type = "EnrollmentNo";


    public SearchFrame() {
        setTitle("Search voter");
        setBackground(Color.white);
        setSize(450,300);
        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon("src/images/search.jpg");
        Image img = imageIcon.getImage();

        Image modified = img.getScaledInstance(450,300,Image.SCALE_SMOOTH);

        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon(modified)));

        //Initialzing serachPanel Components..
        comboBox = new JComboBox<String>();
        jTextField = new JTextField(20);
        searchByLabel = new JLabel("Search By:");
        searchBtn = new JButton("Search");

        //Setting Up Layout for searchPanel
        setLayout(null);

        //Adding Components to  the  search panel
        add(searchByLabel);
        add(comboBox);
        add(jTextField);
        add(searchBtn);

        //Setting Up Bounds for search panel Components..
        searchByLabel.setBounds(30,15,130,25);
        comboBox.setBounds(160,15,115,25);
        jTextField.setBounds(290,15,150,25);
        searchBtn.setBounds(160,60,115,25);

        //Removing text Focus from searchBtn..
        searchBtn.setFocusPainted(false);

        /*
        Adding data to Jcombobox i.e type to be searched for..
          ex: by voterId, by Enrollment , by email id..
         */
        comboBox.addItem("  Enrollment");
        comboBox.addItem("  Voter ID");
        comboBox.addItem("  Email ID");

        //Increase font size of JLabel.
        Font italicFont = new Font("Tahoma", Font.BOLD, 18);
        searchByLabel.setFont(italicFont);
        comboBox.setForeground(Color.red);

        searchByLabel.setForeground(Color.decode("#5d2dd6"));
        jTextField.setForeground(Color.decode("#5d2dd6"));
        jTextField.setBorder(BorderFactory.createLineBorder(Color.decode("#f09424"),2));
        searchBtn.setBackground(Color.decode("#f5c364"));
        searchBtn.setForeground(Color.decode("#5d2dd6"));

        setVisible(true);

         //Setting Listners on Buttons
        searchBtn.addActionListener(this);
        comboBox.addItemListener(this);


    }
    //Function for Setting Up Listner...
    public void setSearchFrameListner(SearchFrameListner listner){
        this.listner = listner;
    }

    //Setting Up listner on Jbuttons....
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedBtn = (JButton)e.getSource();
        if (clickedBtn.equals(searchBtn)){
            try {
                listner.framelistnerActivate(jTextField.getText(),type);
            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();

            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
      String s = (String) e.getItem();
      if (s.equals("  Enrollment")){
          type = "EnrollmentNo";
      }
      else if (s.equals("  Voter ID")){
          type = "VoterId";
      }
      else if (s.equals("  Email ID")){
          type = "EmailId";
      }
    }
}
