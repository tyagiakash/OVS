package window.createelection;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class CreateElection extends JPanel {
    private JLabel label;
    private FormPanel formPanel;
    private CandidateFormPanel candidatePanel;

    //Creating Instance of Controller...
    private Controller controller;


    public CreateElection(){
        setLayout(new GridLayout(2,1));

        //Creating Panel for Form and No of Candidate Buttons
        formPanel = new FormPanel();
        candidatePanel = new CandidateFormPanel();

        //Setting Up Borders For formPanel and CandidatePanel
        Border innerFormPanel = BorderFactory.createTitledBorder("Enter Election Details");
        Border innerCandidatePanel = BorderFactory.createTitledBorder("Enter Candidate Details");
        Border outer = BorderFactory.createEmptyBorder(10,10,5,10);
        formPanel.setBorder(BorderFactory.createCompoundBorder(outer,innerFormPanel));
        candidatePanel.setBorder(BorderFactory.createCompoundBorder(outer,innerCandidatePanel));

        //Initializing Controller Object
        controller = new Controller();

        //Adding panels to mainPanel @CreateElectiony
        add(formPanel);
        add(candidatePanel);

        //Adding A listner on formPanel and Getting Data From It..witth the help of @FormPanelEvent
        //and @FormPanelListner
        formPanel.setFormPanelListner(new FormPanelListner() {
            @Override
            public void formPanelEventOccured(FormPanelEvent e) throws SQLException {

                //Setting Id to @electionId and noofCandidate  and pass both values to setElectionId Function
                String electionId=e.getId();
                Integer noOfCandidates=e.getNoOfCandidate();
                candidatePanel.setElectionID(electionId,noOfCandidates);

                //Seding Event to  Controller.......
                controller.addElectionDetails(e);
            }
        });

        //Adding A listner on formPanel and Getting Data From It..witth the help of @FormPanelEvent
        //and @FormPanelListner
        candidatePanel.setCandidateFormPanelListner(new CandidateFormPanelListner() {
            @Override
            public void candidateFormEventOccured(CandidateFormPanelEvent e) throws IOException {

                //Seding Event to  Controller.......
                controller.addCandidateDetails(e);
            }
        });
    }
}
