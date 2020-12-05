package controller;

import model.CreateElectionDetails;
import model.Database;
import window.createelection.CandidateFormPanel;
import window.createelection.CandidateFormPanelEvent;
import window.createelection.FormPanelEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

//This Class Acts as A Controller Between Models And Other Classes......

public class Controller {

    //Creating Instance of @Database
    Database db = new Database();




    //Function For Getting Data From @CreateElection ->FormPanel
    public void addElectionDetails(FormPanelEvent ev) throws SQLException {
        String id = ev.getId();
        String title = ev.getTitle();
        Integer noOfCan = ev.getNoOfCandidate();
        String place = ev.getPlace();
        String date = ev.getDate();

        //Create connection using Database and add Data and then Close Connection
        db.createConnection();
        db.addElectionDetailsToDB(id,title,noOfCan,place,date);

    }

    //Function For Getting Data From @CreateElection ->CandidateFormPanel
    public void addCandidateDetails(CandidateFormPanelEvent ev) throws IOException {
        String elId = ev.getElectionId();
        Integer cId = ev.getCandidateId();
        String cName = ev.getCandidateName();
        String cDetails = ev.getCandidateDetails();
        String cPhtotoPath  = ev.getCandidatePhotoPath();
        String cSymbolPhotoPath = ev.getCandidateSymbolPhotoPath();

        //Create connection using Database and add Data and then Close Connection
        db.createConnection();
        db.addCandidateDetailsToDB(elId,cId,cName,cDetails,cDetails,cPhtotoPath,cSymbolPhotoPath);

    }
}
