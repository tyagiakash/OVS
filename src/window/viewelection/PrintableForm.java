package window.viewelection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.*;
import java.util.ArrayList;

public class PrintableForm extends JPanel {

    //Creating Array of type @CandidatePrintablePhotosPanel
    private CandidatePrintablePhotosPanel[] jpanel = new CandidatePrintablePhotosPanel[10];
    private CandidateDetailsHeadingsPanel cHeadingPanel;

    private JLabel headingLabel;
    private JLabel electionDetailsLabelH;
    private JLabel electionIdLabelH;
    private JLabel electionTitleLabelH;
    private JLabel placeLabelH;
    private JLabel dateLabelH;
    private JLabel eligiblityLabelH;
    private JLabel candidateDetailsH;

    private JLabel electionIdLabel;
    private JLabel electionTitleLabel;
    private JLabel placeLabel;
    private JLabel dateLabel;
    private JLabel eligiblityLabel;

    //Variable for Storing No of Candidates
    private Integer noOfCandidates = 3;


    public PrintableForm(){

        Dimension dm = getPreferredSize();
        Integer tempHeight = 470+ 120*(noOfCandidates-1);
        dm.height = tempHeight;
        setPreferredSize(dm);


        //Initializing Components
        electionDetailsLabelH = new JLabel("Election Details: ");
        headingLabel = new JLabel("Online Voting System(OVS)");
        electionIdLabelH = new JLabel("Election ID:");
        electionTitleLabelH = new JLabel("Election Title: ");
        placeLabelH = new JLabel("Place :");
        dateLabelH = new JLabel("Date: ");
        eligiblityLabelH =new JLabel("Eligiblity: ");
        candidateDetailsH = new JLabel("Candidate Details: ");
        cHeadingPanel = new CandidateDetailsHeadingsPanel();


        electionIdLabel = new JLabel("E12523");
        electionTitleLabel = new JLabel("Presedent Election at GKV");
        placeLabel = new JLabel("GKV");
        dateLabel = new JLabel("05/01/2021");
        eligiblityLabel =new JLabel("All Students");


        setLayout(new GridBagLayout());
        setBackground(Color.decode("#ffffff"));
        GridBagConstraints gc = new GridBagConstraints();

        /////////////////////Temporary///////////////////

        //Resizing Images @Candidate Image
        ImageIcon imgIcon1 = new ImageIcon("/home/akash/Downloads/start.jpg");

        Image imgTemp = imgIcon1.getImage();

        Image modifiedImgIcon = imgTemp.getScaledInstance(90,90,Image.SCALE_SMOOTH);

        imgIcon1 = new ImageIcon(modifiedImgIcon);
//
//        cPanel1 = new CandidatePrintablePhotosPanel(imgIcon1,imgIcon1,"Lalit Tyagi");
//        cPanel3 = new CandidatePrintablePhotosPanel(imgIcon1,imgIcon1,"Akash Tyagi");
//        cPanel2 = new CandidatePrintablePhotosPanel(imgIcon1,imgIcon1,"Rishab Tyagi");
        jpanel[0] = new CandidatePrintablePhotosPanel(imgIcon1,imgIcon1,"Lalit Tyagi");
        jpanel[1]=  new CandidatePrintablePhotosPanel(imgIcon1,imgIcon1,"Akash Tyagi");
        jpanel[2] = new CandidatePrintablePhotosPanel(imgIcon1,imgIcon1,"Rishab Tyagi");

     //////////////Temporary Ends?????????????


        //Adding Row 1
        gc.gridy=0;
        gc.gridx=0;
        gc.weightx=1;
        gc.weighty=1;
        gc.gridwidth=2;
        gc.fill = GridBagConstraints.CENTER;

        add(headingLabel,gc);

        //Adding Row 2
        gc.gridy++;
        gc.gridx=0;
        gc.weightx=0.5;
        gc.weighty=0.5;
        gc.gridwidth=1;
        gc.gridwidth =2;
        gc.insets = new Insets(0,20,0,0);
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(electionDetailsLabelH,gc);

        //Adding Row 3
        gc.gridy++;
        gc.gridx=0;
        gc.weightx=0.1;
        gc.weighty=0.1;
        gc.gridwidth =1;
        gc.insets = new Insets(0,0,0,30);
        gc.anchor =GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        add(electionIdLabelH,gc);

        gc.gridx++;
        gc.anchor =GridBagConstraints.LINE_START;
        add(electionIdLabel,gc);

        //Adding Row 4
        gc.gridy++;
        gc.gridx=0;
        gc.weightx=0.1;
        gc.weighty=0.1;
        gc.insets = new Insets(0,0,0,30);
        gc.anchor =GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        add(electionTitleLabelH,gc);

        gc.gridx++;
        gc.anchor =GridBagConstraints.LINE_START;
        add(electionTitleLabel,gc);


        //Adding Row 5
        gc.gridy++;
        gc.gridx=0;
        gc.weightx=0.1;
        gc.weighty=0.1;
        gc.insets = new Insets(0,0,0,30);
        gc.anchor =GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        add(eligiblityLabelH,gc);

        gc.gridx++;
        gc.anchor =GridBagConstraints.LINE_START;
        add(eligiblityLabel,gc);

        //Adding Row 6
        gc.gridy++;
        gc.gridx=0;
        gc.weightx=0.1;
        gc.weighty=0.1;
        gc.insets = new Insets(0,0,0,30);
        gc.anchor =GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        add(dateLabelH,gc);

        gc.gridx++;
        gc.anchor =GridBagConstraints.LINE_START;
        add(dateLabel,gc);

        //Adding Row 7
        gc.gridy++;
        gc.gridx=0;
        gc.weightx=0.1;
        gc.weighty=0.1;
        gc.insets = new Insets(0,0,0,30);
        gc.anchor =GridBagConstraints.LINE_END;
        gc.fill = GridBagConstraints.NONE;
        add(placeLabelH,gc);

        gc.gridx++;
        gc.anchor =GridBagConstraints.LINE_START;
        add(placeLabel,gc);

        //Adding Row 7
        gc.gridy++;
        gc.gridx=0;
        gc.weightx=1;
        gc.weighty=0.5;
        gc.gridwidth = 2;
        gc.insets = new Insets(0,20,0,0);
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(candidateDetailsH,gc);

        //Adding Row 8
        gc.gridy++;
        gc.gridx=0;
        gc.weightx=1;
        gc.weighty=0.1;
        gc.gridwidth = 2;
        gc.insets = new Insets(0,10,0,10);
        gc.fill = GridBagConstraints.HORIZONTAL;
        add(cHeadingPanel,gc);

        //Dyanmically Added Further Rows Based Upon No. of Candidates.

        for(int i=0;i<noOfCandidates;i++) {

            gc.gridy++;
            gc.gridx = 0;
            gc.weightx = 1;
            gc.weighty = 0;
            gc.gridwidth = 2;
            gc.fill = GridBagConstraints.HORIZONTAL;
            add(jpanel[i], gc);
        }

    }
}
