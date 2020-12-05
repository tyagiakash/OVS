package window.createelection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.prefs.Preferences;

public class FormPanel extends JPanel implements ActionListener {

    private JLabel  electionIdLabel;
    private JLabel  electionTitleLabel;
    private JLabel  noOfCandidatesLabel;
    private JLabel  placeLabel;
    private JLabel  dateLabel;
    private JTextField elctionIdField;
    private JTextField elctionTitleField;
    private JTextField noOfCandidateField;
    private JTextField placeField;
    private JTextField dateField;
    private JButton saveBtn;
    private JButton resetBtn;

    //Creating instance of formPanel Listner
    private FormPanelListner listner;

    //Prefrences Object to help to Store Next Election Id...Counter Variable...
    private Preferences prefs;

    //Variable for Election Counter....(Store Integer Part of @electionId..)
    //and help in Generating Unique Id's Every time using @prefs..
    private Integer count;

    //Variable to Store Current Election ID(Consisting of 'E+count')
    private String uniqueID;

    //Variable for Checking Save Button Pressed or Not
    private Boolean saveBtnState = false;

    //Constructor...
    public FormPanel(){

        //Initializing Component variable
         electionIdLabel = new JLabel("Election Id: ");
         electionTitleLabel = new JLabel("Election Title: ");
         noOfCandidatesLabel = new JLabel("No of Candidates: ");
         placeLabel = new JLabel("Place: ");
         dateLabel = new JLabel("Date: ");

         elctionIdField = new JTextField(12);
         elctionIdField.setEditable(false);
         elctionTitleField = new JTextField(12);
         noOfCandidateField = new JTextField(12);
         placeField = new JTextField(12);
         dateField = new JTextField(12);

        //Setting Default Value  to NoOfCandidates @3 and date Field@dd/mm/yyyy
        noOfCandidateField.setText("3");
        dateField.setText("yyyy-mm-dd");

         saveBtn = new JButton("Save");
         resetBtn = new JButton("Reset");


         //Creating Prefrences Storage and assign node Name as ID...
         prefs = Preferences.userRoot().node("ID");

         ////////////////////////  Generating Unique Id //////////////////
         if(prefs.getBoolean("first",false)){
             //Initializing Count for First and Only one through Out a Single Installation..
              count = 12345;
              uniqueID = 'E'+count.toString();
              count++;
              prefs.putInt("id",count);
         }
           //If User already Generated Initial Election ID...
         else {
              count = prefs.getInt("id",12345);
              uniqueID = 'E'+count.toString();
              count++;
              prefs.putInt("id",count);
         }
         //////////////////  Generating Unique Id End.... ///////////////

        //Setting Election Id Field Value....
        elctionIdField.setText(uniqueID);


         //Adding Action Listner On Butttons
        saveBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        //Remove Focus Painted from Buttons
        saveBtn.setFocusPainted(false);
        resetBtn.setFocusPainted(false);

         //Creating Layout for Form panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //Designing Row 1
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx =1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(electionIdLabel,gc);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(elctionIdField,gc);

        //Designing Row 2
        gc.gridy = 1;
        gc.gridx = 0;
        gc.weightx =1;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(electionTitleLabel,gc);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(elctionTitleField,gc);

        //Designing Row 3
        gc.gridy = 2;
        gc.gridx = 0;
        gc.weightx =1;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(noOfCandidatesLabel,gc);
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(noOfCandidateField,gc);

        //Designing Row 4
        gc.gridy = 4;
        gc.gridx = 0;
        gc.weightx =1;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(placeLabel,gc);
        gc.gridy = 4;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(placeField,gc);

        //Designing Row 5
        gc.gridy = 5;
        gc.gridx = 0;
        gc.weightx =1;
        gc.weighty = 1;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(dateLabel,gc);
        gc.gridy = 5;
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(dateField,gc);

        //Desiginign Row 6
        gc.gridy = 6;
        gc.gridx = 0;
        gc.weighty = 1;
        gc.weightx = 1;
        gc.insets = new Insets(15,20,5,20);
        gc.anchor = GridBagConstraints.LINE_END;
        add(saveBtn,gc);
        gc.gridx = 1;
        gc.gridy = 6;
        gc.insets = new Insets(15,20,5,20);
        gc.anchor = GridBagConstraints.LINE_START;
        add(resetBtn,gc);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if(clicked.equals(resetBtn) && saveBtnState ==false){
            elctionTitleField.setText("");
            placeField.setText("");
            dateField.setText("");
        }
        else if(clicked.equals(saveBtn)){

            //Variables for Getting Values from Fields
            String id = elctionIdField.getText();
            String title = elctionTitleField.getText();
            Integer noOfCandidate =Integer.parseInt(noOfCandidateField.getText());
            String place = placeField.getText();
            String date = dateField.getText();

            //Creating Instance of FormPanelEvent and Pass all the Variables to it.
            FormPanelEvent ev = new FormPanelEvent(this,id,title,noOfCandidate,place,date);

            if (listner!=null){
                try {
                    listner.formPanelEventOccured(ev);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            //Setting All Field Lock once user Entered All Details
            //also Changin @saveBtnState so that @resetBtn not Works once Fields Locked
            onSavingLockfields();
            saveBtnState = true;

            //Canging Prefs Key @first to false if User used initial Election ID..
            prefs.putBoolean("first",false);

        }
    }
    //Function for Locking Fields after save Button Pressed
    public void onSavingLockfields(){
            elctionTitleField.setEditable(false);
            noOfCandidateField.setEditable(false);
            placeField.setEditable(false);
            dateField.setEditable(false);

    }

    //Setting FormPanel Listner
    public void setFormPanelListner(FormPanelListner listner){
        this.listner=listner;
    }


}
