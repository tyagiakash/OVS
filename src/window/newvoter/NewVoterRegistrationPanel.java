package window.newvoter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;


/*
  Class for having GUI of New Voter Registration....
 */

public class NewVoterRegistrationPanel extends JPanel implements ActionListener {

    //Creating Objects for Various Components Used...
    private JLabel panleTitle;
    private JLabel voterEmailJLabel;
    private JLabel studentRegistrationNoJLabel;
    private JLabel voterNameJlabel;
    private JLabel voterFNameJLabel;
    private JLabel voterGenderJlabel;
    private JLabel voterCourseJlabel;
    private JLabel studentYearOfAdmissionJlabel;
    private JLabel voterCityJlabel;
    private JLabel voterMobilNumberJlabel;
    private JLabel voterPhotoJLabel;

    private JTextField voterEmailJTextField;
    private JTextField studentRegistrationNoJTextField;
    private JTextField voterNameJTextField;
    private JTextField voterFNameJTextField;
    private JTextField studentYearOfAdmtextField;
    private ButtonGroup genderBtnGroup;
    private JRadioButton maleGenderBtn;
    private JRadioButton femelGenderBtn;
    private JRadioButton otherGenderBtn;
    private ButtonGroup courseBtnGroup;
    private JRadioButton mcaCourseBtn;
    private JRadioButton btechCourseBtn;
    private JRadioButton mtechCourseBtn;
    private JRadioButton artsCourseBtn;
    private JTextField cityTextField;
    private JTextField mobileTextField;

    private JButton saveBtn;
    private JButton captureButton;
    private JButton viewPhotoBtn;

    //Creating Instance of ImageIcon for getting Capture Image...
    private ImageIcon imgIcon;

    //creatin Instance of @NewVoterRegistrationPanelListner
    private NewVoterRegistrationPanelListner listner;

    public NewVoterRegistrationPanel(){

        //Initializing Components..
        panleTitle = new JLabel("New Voter Registration");
        voterEmailJLabel = new JLabel("Email Id:");
        studentRegistrationNoJLabel = new JLabel("University Enrollment No:");
        voterNameJlabel = new JLabel("Name:");
        voterFNameJLabel = new JLabel("Father Name:");
        voterGenderJlabel = new JLabel("Gender:");
        voterCourseJlabel = new JLabel("Course:");
        studentYearOfAdmissionJlabel = new JLabel("University Year Of Adm.:");
        voterCityJlabel = new JLabel("City:");
        voterMobilNumberJlabel = new JLabel("Mobile No.:");
        voterPhotoJLabel = new JLabel("Upload Photo:");

        voterEmailJTextField = new JTextField(15);
        studentRegistrationNoJTextField = new JTextField(15);
        studentYearOfAdmtextField = new JTextField(15);
        voterNameJTextField = new JTextField(15);
        voterFNameJTextField = new JTextField(15);
        genderBtnGroup = new ButtonGroup();
        maleGenderBtn = new JRadioButton("Male");
        femelGenderBtn = new JRadioButton("Female");
        otherGenderBtn = new JRadioButton("Other");
        courseBtnGroup = new ButtonGroup();
        mcaCourseBtn = new JRadioButton("MCA");
        btechCourseBtn = new JRadioButton("B Tech");
        mtechCourseBtn = new JRadioButton("M Tech");
        artsCourseBtn = new JRadioButton("Arts");
        cityTextField = new JTextField(15);
        mobileTextField  = new JTextField(15);

        saveBtn = new JButton("Save");
        captureButton = new JButton("Capture");
        viewPhotoBtn = new JButton("View");

        //Setup Buttons adding Into Button Groups..
        genderBtnGroup.add(maleGenderBtn);
        genderBtnGroup.add(femelGenderBtn);
        genderBtnGroup.add(otherGenderBtn);

        courseBtnGroup.add(mcaCourseBtn);
        courseBtnGroup.add(btechCourseBtn);
        courseBtnGroup.add(mtechCourseBtn);
        courseBtnGroup.add(artsCourseBtn);

        //Setting Defualt JRadioButton for for genderButtonGroup
        maleGenderBtn.setSelected(true);
        mcaCourseBtn.setSelected(true);

        //Setting Values for Jradio Buttons which helps in retrive values..
        maleGenderBtn.setActionCommand("male");
        femelGenderBtn.setActionCommand("female");
        otherGenderBtn.setActionCommand("other");
        mcaCourseBtn.setActionCommand("mca");
        btechCourseBtn.setActionCommand("btech");
        mtechCourseBtn.setActionCommand("mtech");
        artsCourseBtn.setActionCommand("arts");

        //Removing Focus Painted from texts of all Buttons
        maleGenderBtn.setFocusPainted(false);
        femelGenderBtn.setFocusPainted(false);
        otherGenderBtn.setFocusPainted(false);
        mcaCourseBtn.setFocusPainted(false);
        btechCourseBtn.setFocusPainted(false);
        mtechCourseBtn.setFocusPainted(false);
        artsCourseBtn.setFocusPainted(false);
        captureButton.setFocusPainted(false);
        viewPhotoBtn.setFocusPainted(false);
        saveBtn.setFocusPainted(false);

        viewPhotoBtn.setBackground(null);
        viewPhotoBtn.setBorder(BorderFactory.createEmptyBorder());


        //Adding all Radio Buttons to their respective Boxes so that they are nearer
        //to each other....
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(maleGenderBtn);
        horizontalBox.add(femelGenderBtn);
        horizontalBox.add(otherGenderBtn);
        horizontalBox.setBorder(BorderFactory.createEtchedBorder());

        Box horizontalBox2 = Box.createHorizontalBox();
        horizontalBox2.add(mcaCourseBtn);
        horizontalBox2.add(btechCourseBtn);
        horizontalBox2.add(mtechCourseBtn);
        horizontalBox2.add(artsCourseBtn);
        horizontalBox2.setBorder(BorderFactory.createEtchedBorder());

        Box horizontalBox3 = Box.createHorizontalBox();
        horizontalBox3.add(captureButton);
        horizontalBox3.add(Box.createHorizontalStrut(7));
        horizontalBox3.add(viewPhotoBtn);

        //Temporary... Adding Colors...
        Font italicFont = new Font("Roboto", Font.BOLD, 23);
        panleTitle.setFont(italicFont);
        panleTitle.setForeground(Color.PINK);

        //Adding Listner to Buttons..
        captureButton.addActionListener(this);
        viewPhotoBtn.addActionListener(this);
        saveBtn.addActionListener(this);


        //Setting Up Layout for Adding all the components..
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //Setting Up lock viewButton @ Starting..
        viewPhotoBtn.setEnabled(false);

        //Desiginign ROW 1
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 2.5;
        gc.gridwidth = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0,20,0,0);
        add(panleTitle,gc);

        //Desiginign ROW 2
        gc.gridx = 0;
        gc.gridy++;
        gc.gridwidth = 1;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(voterEmailJLabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(voterEmailJTextField,gc);

        //Desiginign ROW 3
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(studentRegistrationNoJLabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(studentRegistrationNoJTextField,gc);

        //Desiginign ROW 4
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(studentYearOfAdmissionJlabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(studentYearOfAdmtextField,gc);

        //Desiginign ROW 5
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(voterNameJlabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(voterNameJTextField,gc);

        //Desiginign ROW 5
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(voterFNameJLabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(voterFNameJTextField,gc);

        //Desiginign ROW 6
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(voterGenderJlabel,gc);

        gc.gridx++;
        gc.weightx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(horizontalBox,gc);

        //Desiginign ROW 7
        gc.gridx = 0;
        gc.gridy++;
        gc.gridwidth = 1;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(voterCourseJlabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(horizontalBox2,gc);


        //Desiginign ROW 8
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(voterCityJlabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(cityTextField,gc);

        //Desiginign ROW 9
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(voterMobilNumberJlabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(mobileTextField,gc);

        //Desiginign ROW 9
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(voterMobilNumberJlabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(mobileTextField,gc);

        //Desiginign ROW 10
        gc.gridx = 0;
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.5;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(voterPhotoJLabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(horizontalBox3,gc);


        //Desiginign ROW 11
        gc.gridx = 1;
        gc.gridy++;
        gc.weightx = 1;
        gc.gridwidth = 3;
        gc.weighty = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(saveBtn,gc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          JButton clickedBtn = (JButton)e.getSource();
          if (clickedBtn.equals(captureButton)){

              //Creating Instance of webCamFrame for Capturing Photo...
               webcamFrame wf = new webcamFrame();

               //Now Enabling the viewButton
               viewPhotoBtn.setEnabled(true);
          }
          else if (clickedBtn.equals(viewPhotoBtn)){

              //Creating a JLabel for Holding Image on it...
              JLabel photoLabel = new JLabel();

              //Setting new Icon...
              imgIcon = new ImageIcon("CapturePhoto/photo.jpg");

              //Setting imgIcon on photoLabel..
              photoLabel.setIcon(imgIcon);

              //Now Show JoptioPain Having Photo...
              JOptionPane.showMessageDialog(null,photoLabel,"Photo",JOptionPane.INFORMATION_MESSAGE);
          }
          else if (clickedBtn.equals(saveBtn)){

              if (saveBtn.getText().equals("Add More")){

                  saveBtn.setText("Save");

                  //Clearing the Field...
                  refreshFields();

              }
              else {
                  saveBtn.setText("Add More");

                  //Setting Local Variables for getting values of TextFeelds..
                  String emailId = voterEmailJTextField.getText();
                  Integer registrationNo =Integer.parseInt(studentRegistrationNoJTextField.getText());
                  Integer yeraofAdm = Integer.parseInt(studentYearOfAdmtextField.getText());
                  String name = voterNameJTextField.getText();
                  String fName = voterFNameJTextField.getText();
                  String gender = genderBtnGroup.getSelection().getActionCommand();
                  String course = courseBtnGroup.getSelection().getActionCommand();
                  String city = cityTextField.getText();
                  String mobileNo =mobileTextField.getText();

                  /*
                  Creating object of @NewVoterRegistrationPanel and pass all this above variables
                  including Event Listner....
                  */

                  NewVoterRegistrationPanelEvent ev = new NewVoterRegistrationPanelEvent(this,emailId,registrationNo,yeraofAdm,name,fName,gender,course,city,mobileNo);

                  //Calling NewVoterRegistrationPanleListner method and pass this Event on it..
                  if (listner != null){
                      try {
                          listner.newRegistrtionPanelEventOccured(ev);
                      } catch (FileNotFoundException fileNotFoundException) {
                          fileNotFoundException.printStackTrace();
                      } catch (SQLException throwables) {
                          throwables.printStackTrace();
                      }
                  }

              }

          }
    }

    //Function for Refreshing Data...
    private void refreshFields(){

        voterEmailJTextField.setText("");
        studentRegistrationNoJTextField.setText("");
        studentYearOfAdmtextField.setText("");
        voterNameJTextField.setText("");
        voterFNameJTextField.setText("");
        cityTextField.setText("");
        mobileTextField.setText("");
        viewPhotoBtn.setEnabled(false);
    }


    //Setting up NewVoterRegistrationPanelListner as same as pass in VoterPanel..
    public void setVoterRegistrationPanelListner(NewVoterRegistrationPanelListner listner){
        this.listner = listner;
    }
}
