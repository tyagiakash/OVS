package window.updatevoter;

import controller.Controller;
import model.UpdateVoter;
import window.newvoter.webcamFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;

/*
Class if for Update some Information of Voters...
this class constrctor takes 1 para. as class @UpdateVoter that
contains info. for that voter to be updated..
 */

public class ContentPanelUpdate extends JPanel implements ActionListener {

    private JButton updatePhotoBtn;
    private JButton updateRecordBtn;
    private JLabel photoLabel;
    private Boolean isPhotoUpdated = false;
    JTextField cityTextField;
    JTextField mobileTextField;
    ButtonGroup courseBtnGroup = new ButtonGroup();
    JRadioButton mcaRadio;
    JRadioButton btechRadio;
    JRadioButton mtechRadio;
    JRadioButton artsRadio;
    UpdateVoter voterData;
    ContentPanelListner listner;

 public ContentPanelUpdate(UpdateVoter voterData){
        this.voterData = voterData;

       setLayout(new GridBagLayout());

        //Setting Layout for UpdatePanel to be gridbagLayout..
        GridBagConstraints gc =new GridBagConstraints();

        //Initialing  Components for updatePanel..
        //Components for Update Panel..
        JLabel nameLabel = new JLabel("Name:");
        JLabel voterIdLabel = new JLabel("Voter ID:");
        JLabel cityLabel = new JLabel("City:");
        JLabel mobileLabel = new JLabel("Mobile No.:");
        JLabel courseLabel = new JLabel("Course:");
        photoLabel = new JLabel();
        JTextField nameTxtField = new JTextField(15);
        JTextField voterIdTextField = new JTextField(15);
        cityTextField = new JTextField(15);
        mobileTextField = new JTextField(15);
        courseBtnGroup = new ButtonGroup();
        mcaRadio = new JRadioButton("MCA");
        btechRadio = new JRadioButton("BTech");
        mtechRadio = new JRadioButton("MTech");
        artsRadio = new JRadioButton("Arts");
        updatePhotoBtn = new JButton("Capture");
        updateRecordBtn = new JButton("Update Record");

        //Adding Radio buttons to the courseButtonGroup..
        courseBtnGroup.add(mcaRadio);
        courseBtnGroup.add(btechRadio);
        courseBtnGroup.add(mtechRadio);
        courseBtnGroup.add(artsRadio);

        //Setting Values for these Radio Buttons..
        mcaRadio.setActionCommand("mca");
        btechRadio.setActionCommand("btech");
        mtechRadio.setActionCommand("mtech");
        artsRadio.setActionCommand("arts");

        //Removing text Focus from each Buttons..
        mcaRadio.setFocusPainted(false);
        btechRadio.setFocusPainted(false);
        mtechRadio.setFocusPainted(false);
        artsRadio.setFocusPainted(false);
        updatePhotoBtn.setFocusPainted(false);
        updateRecordBtn.setFocusPainted(false);

        //Adding Radio Buttons to a Box..
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(mcaRadio);
        horizontalBox.add(btechRadio);
        horizontalBox.add(mtechRadio);
        horizontalBox.add(artsRadio);
        horizontalBox.setBorder(BorderFactory.createEtchedBorder());

        //Setting up Border and width for Photo Label, used for displaying Photo..
        photoLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,2));
        photoLabel.setPreferredSize(new Dimension(150,150));
        photoLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Setting Up radio Buttons Action Command..
        mcaRadio.setActionCommand("mca");
        btechRadio.setActionCommand("btech");
        mtechRadio.setActionCommand("mtech");
        artsRadio.setActionCommand("arts");

        //Setting Up Action Listners on the Buttons..
        updatePhotoBtn.addActionListener(this);
        updateRecordBtn.addActionListener(this);


        //Setting Row 1
        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor =GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        add(nameLabel,gc);
        gc.gridx++;
        gc.anchor =GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(nameTxtField,gc);

        //Setting Row 1 , column 3
        gc.gridx = 2;
        gc.gridy = 0;
        gc.gridheight = 4;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor =GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,10);
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        add(photoLabel,gc);

        //Setting Row 2
        gc.gridx = 0;
        gc.gridy++;
        gc.gridheight = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor =GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        add(voterIdLabel,gc);
        gc.gridx++;
        gc.anchor =GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(voterIdTextField,gc);

        //Setting Row 3
        gc.gridx = 0;
        gc.gridy++;
        gc.gridheight = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor =GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        add(cityLabel,gc);
        gc.gridx++;
        gc.anchor =GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(cityTextField,gc);

        //Setting Row 4
        gc.gridx = 0;
        gc.gridy++;
        gc.gridheight = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor =GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        add(mobileLabel,gc);
        gc.gridx++;
        gc.gridwidth = 1;
        gc.anchor =GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(mobileTextField,gc);

        //Setting Row 4 column 3
        gc.gridx = 2;
        gc.gridheight = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor =GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,35,0,0);
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        add(updatePhotoBtn,gc);

        //Setting Row 5
        gc.gridx = 0;
        gc.gridy++;
        gc.gridheight = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor =GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        add(courseLabel,gc);
        gc.gridx++;
        gc.gridwidth = 2;
        gc.anchor =GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(horizontalBox,gc);

        //Row 6
        gc.gridx = 1;
        gc.gridy++;
        gc.gridwidth =1;
        gc.weighty = 2;
        gc.weightx = 1;
        gc.insets = new Insets(0,0,0,30);
        gc.anchor = GridBagConstraints.LINE_END;
        add(updateRecordBtn,gc);

        //Setting Up the data to the Fields.... that is came from DB..
        nameTxtField.setText(voterData.getVoterName());
        nameTxtField.setEditable(false);
        voterIdTextField.setText(voterData.getVoterId().toString());
        voterIdTextField.setEditable(false);
        mobileTextField.setText(voterData.getMobileNumber());
        cityTextField.setText(voterData.getCity());
        photoLabel.setIcon(voterData.getVoterPhoto());
        String courseName = voterData.getCourse();
        if (courseName.equals("mca")){
         mcaRadio.setSelected(true);
        }
        else if (courseName.equals("btech")){
         btechRadio.setSelected(true);
        }
        else if (courseName.equals("mtech")){
         mtechRadio.setSelected(true);
        }
        else if (courseName.equals("arts")){
         artsRadio.setSelected(true);
        }

    }

 @Override
 public void actionPerformed(ActionEvent e) {
       JButton btn = (JButton)e.getSource();
       if (btn.getText().equals("Capture")) {

        //Setting ImageIcon to null ie removing previous Photo..
        photoLabel.setIcon(null);

        //Creating Instance of webCamFrame for Capturing Photo... to Update that one..
        webcamFrame wf = new webcamFrame();

        //Changing BtnText to Update...
        btn.setText("Update");

       }
       else if (btn.getText().equals("Update")){

        //Setting new Icon...
        ImageIcon imageIcon = new ImageIcon("CapturePhoto/photo.jpg");

        //Convert it to an Image Object.. and  setting up width and height..

        Image img = imageIcon.getImage();

        Image mImg = img.getScaledInstance(120,120,Image.SCALE_SMOOTH);

        photoLabel.setIcon(new ImageIcon(mImg));

        photoLabel.update(photoLabel.getGraphics());

        //Changing Btn text to Updated and set enabled to false once a new photo has been updated..
        btn.setText("Updated");
        btn.setEnabled(false);
        isPhotoUpdated = true;
       }
       else if (btn.equals(updateRecordBtn)){
        /*
        Now Updating Current Record To UpdateVoterModel...
         */
          voterData.setCity(cityTextField.getText());
          voterData.setCourse(courseBtnGroup.getSelection().getActionCommand());
          voterData.setMobileNumber(mobileTextField.getText());
          voterData.setPhotoUpdated(isPhotoUpdated);
        try {
         listner.btnConfirmListner();
        } catch (FileNotFoundException fileNotFoundException) {
         fileNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
         throwables.printStackTrace();
        }

       }
 }
 public void setContentPanelListner(ContentPanelListner listner){
    this.listner = listner;
 }

}

