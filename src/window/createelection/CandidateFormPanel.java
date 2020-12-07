package window.createelection;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.prefs.Preferences;

public class CandidateFormPanel extends JPanel implements ActionListener {

    //Creating Varibales for Varius Components.
    private JLabel candidateNameLabel;
    private JLabel electionIdLabel;
    private JLabel candidateIdLabel;
    private JLabel candidateDetailsLabel;
    private JLabel candidatePhotoLabel;
    private JLabel electionSymbolLabel;
    private JLabel filePath1;
    private JLabel filePath2;

    private JTextField candidateName;
    private JTextField electionIdField;
    private JTextField candidateIdField;
    private JTextField candidateDetail;

    private JButton browsePhoto;
    private JButton browseSymbol;
    private JButton saveBtn;
    private JButton addMoreBtn;
    private JFileChooser chooser;

    private String imgPath;
    private String symPath;

    //Variables for Storing Values getting from FormPanel through setElectionID()
    private Integer candidateCounter = 1;
    private String electionId;
    private Integer noOfCandidates;

    //Creating Instance of CandidateFormPanelListner
    private CandidateFormPanelListner listner;

    //Prefrences Object to help to Store Next Election Id...Counter Variable...
    private Preferences prefs;

    //Variable for Candidate Counter....(Store Integer Part of @CandidateId..)
    //and help in Generating Unique Id's Every time using @prefs..
    private Integer count;


    public CandidateFormPanel(){

        //Initialization of Components
        candidateNameLabel = new JLabel("Candidate Name: ");
        electionIdLabel = new  JLabel("Election Id: ");
        candidateIdLabel = new JLabel("Candidate Id:");
        candidateDetailsLabel = new JLabel("Candidate Details: ");
        candidatePhotoLabel = new JLabel("Candidate Photo: ");
        electionSymbolLabel = new JLabel("Election Symbol: ");
        filePath1 = new JLabel("No File Selected!");
        filePath2 = new JLabel("No File Selected!");

        candidateName = new JTextField(13);
        candidateDetail = new JTextField(13);
        electionIdField = new JTextField(13);
        candidateIdField = new JTextField(13);
        candidateIdField.setEditable(false);

        browsePhoto = new JButton("Browse Photo");
        browseSymbol= new JButton("Browse Symbol");
        saveBtn = new JButton("Save");
        addMoreBtn = new JButton("Add More");
        addMoreBtn.setEnabled(false);

        // create an object of JFileChooser class
        chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        //Setting Up New Dimension for browse Buttons equal to TextField
        browsePhoto.setPreferredSize(new Dimension(147,21));
        browseSymbol.setPreferredSize(new Dimension(147,21));

        // Removing Focus from Button Text
        browsePhoto.setFocusPainted(false);
        browseSymbol.setFocusPainted(false);
        saveBtn.setFocusPainted(false);
        addMoreBtn.setFocusPainted(false);

        //Setting Listner On Buttons..
        browsePhoto.addActionListener(this);
        browseSymbol.addActionListener(this);
        saveBtn.addActionListener(this);
        addMoreBtn.addActionListener(this);


        //Creating Prefrences Storage and assign node Name as ID...
        prefs = Preferences.userRoot().node("CandidateID");

        ////////////////////////  Generating Unique Id //////////////////
        if(prefs.getBoolean("first",false)){
            //Initializing Count for First and Only one through Out a Single Installation..
            count = 100;   //Candidate Id Starts With @101
            count++;
            prefs.putInt("id",count);
        }
        //If User already Generated Initial Election ID...
        else {
            count = prefs.getInt("id",101);
            count++;
            prefs.putInt("id",count);
        }
        //////////////////  Generating Unique Id End.... ///////////////

        //Setting Up @candidate ID
        candidateIdField.setText(count.toString());


        //Setting Layout for this Panel
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //Row 1
        gc.gridy = 0;
        gc.gridx = 0;
        gc.weightx =0.5;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(10,0,0,10);
        add(electionIdLabel,gc);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(electionIdField,gc);


        //Row 2
        gc.gridy = 1;
        gc.gridx = 0;
        gc.weightx =0.5;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,15);
        add(candidateIdLabel,gc);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(candidateIdField,gc);

        //Row 3
        gc.gridy = 2;
        gc.gridx = 0;
        gc.weightx =0.5;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(candidateNameLabel,gc);
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(candidateName,gc);

        //Row 4
        gc.gridy = 3;
        gc.gridx = 0;
        gc.weightx =0.5;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(candidateDetailsLabel,gc);
        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        add(candidateDetail,gc);


        //Row 5
        gc.gridy = 4;
        gc.gridx = 0;
        gc.weightx =0.5;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(candidatePhotoLabel,gc);
        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.LINE_START;
        add(browsePhoto,gc);

        //Row 6
        gc.gridy = 5;
        gc.gridx = 0;
        gc.weightx =0.5;
        gc.weighty = 0.5;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,10);
        add(electionSymbolLabel,gc);
        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        add(browseSymbol,gc);

        //Row 7
        gc.gridy = 6;
        gc.gridx = 0;
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.insets = new Insets(15,20,5,20);
        gc.anchor = GridBagConstraints.LINE_END;
        add(saveBtn,gc);

        gc.gridy = 6;
        gc.gridx = 1;
        gc.insets = new Insets(15,20,5,20);
        gc.anchor = GridBagConstraints.LINE_START;
        add(addMoreBtn,gc);



        //Row 8
        gc.gridy = 7;
        gc.gridx = 0;
        gc.weighty = 0;
        gc.weightx = 0;
        gc.gridwidth = 2;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(filePath1,gc);

        // Row 9
         gc.gridy =8;
         gc.weighty =0;
         gc.weightx = 0;
         gc.gridwidth = 2;
        gc.insets = new Insets(0,10,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx = 0;
        add(filePath2,gc);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedBtn = (JButton) e.getSource();

        if (clickedBtn == browsePhoto) {

            // resctrict the user to selec files of all types
            chooser.setAcceptAllFileFilterUsed(false);

            // set a title for the dialog
            chooser.setDialogTitle("Select Candidate Photo");

            // only allow files of .txt extension
            FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only Images(jpg,png,jpeg)", "jpg","png","jpeg");
            chooser.addChoosableFileFilter(restrict);

            // invoke the showsSaveDialog function to show the save dialog
            int r = chooser.showSaveDialog(null);

            // if the user selects a file
            if (r == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected file
                filePath1.setText(chooser.getSelectedFile().getName());
                imgPath = chooser.getSelectedFile().getAbsolutePath();

            }
        }
        else if (clickedBtn == browseSymbol) {

            // resctrict the user to selec files of all types
            chooser.setAcceptAllFileFilterUsed(false);

            // set a title for the dialog
            chooser.setDialogTitle("Select Election Symbol");

            // only allow files of .txt extension
            FileNameExtensionFilter rest = new FileNameExtensionFilter("Only Images(jpg,png,jpeg)", "jpg","jpeg","png");
            chooser.addChoosableFileFilter(rest);

            // invoke the showsSaveDialog function to show the save dialog
            int rx = chooser.showSaveDialog(null);

            // if the user selects a file
            if (rx == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected file
                filePath2.setText(chooser.getSelectedFile().getName());
                symPath = chooser.getSelectedFile().getAbsolutePath();

            }
        }
        else if(clickedBtn == saveBtn){

            //Creating Instance of Custom Confirm Dialog Class for Showing
            //Images and confirmation to save into database...
            ConfirmDialog dial = new ConfirmDialog(imgPath,symPath,candidateName.getText(),electionIdField.getText());

            //Creating a Joption Pane and Passing ConfirmDialog Panel to it..
            //In Joption pane we pass null instead of this , because this make
            //Joption Pane Independent , it comes from center
            int a = JOptionPane.showConfirmDialog(null,dial,"Confirm Data..",JOptionPane.INFORMATION_MESSAGE);

            //if user selected to Yes.. then save data to the DB..
            if(a==JOptionPane.YES_OPTION) {
                JOptionPane.getRootFrame().dispose();


                //Creating Variables for Storing Field Data, three Variable already Created we Need
                //We Just Need to Create for @detailsField and candidateID
                Integer canID = Integer.parseInt(candidateIdField.getText());
                String details = candidateDetail.getText();
                String Name = candidateName.getText();

                //Creating Object of CandidateFormPanelEvent
                CandidateFormPanelEvent ev = new CandidateFormPanelEvent(this, electionIdField.getText(), canID, Name, details, imgPath, symPath);

                //Passing the CandidateFormPanel Event if listner is not Empty
                if (listner != null) {
                    try {
                        listner.candidateFormEventOccured(ev);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

                //Canging Prefs Key @first to false if User used initial Election ID..
                prefs.putBoolean("first", false);

                //Enabling add More Button
                addMoreBtn.setEnabled(true);
            }
        }
        else if(clickedBtn == addMoreBtn){
            if(candidateCounter <noOfCandidates){

                /////Incresing Candidate Id////////
                count = prefs.getInt("id",101);
                count++;
                prefs.putInt("id",count);
                //Setting Up @candidate ID
                candidateIdField.setText(count.toString());
                ////////////////////////////////////

                candidateName.setText("");
                candidateDetail.setText("");
                filePath2.setText("No File Selected!");
                filePath1.setText("No File Selected!");
                candidateCounter++;
            }
            else{
                JOptionPane.showMessageDialog(null,"You Already Added Maximum Number Of Candidate!","Error",JOptionPane.ERROR_MESSAGE);
                addMoreBtn.setEnabled(false);
            }


        }
    };

    //Method for setElection id and no of Candidates , getting from formPanel
    //With the help of CreateElction Panel
    public void setElectionID(String electionId,Integer noOfCandidates){
        this.electionId=electionId;
        this.noOfCandidates=noOfCandidates;

        //Setting the text of the Election Id Field and Set Editable to False
        electionIdField.setText(electionId);
        electionIdField.setEditable(false);
    }

    //Setting Listner

    public void setCandidateFormPanelListner(CandidateFormPanelListner listner){
        this.listner = listner;
    }
}
