package controller;

import model.Database;
import model.ElectionDetailsPrintData;
import window.createelection.CandidateFormPanelEvent;
import window.createelection.FormPanelEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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

    //Method for Getting Election Id's form the Database...
    public ArrayList<String> getElectionIdFromDB() throws SQLException {
        //Creating Connection With DB and getting Result through Database Class...
        db.createConnection();
        return  db.getElectionIdsFromDB();

    }


    //Method for getting data from ElectionDetails and CandidateDetails from
    //database and send  to ViewElection
     public  ArrayList<ElectionDetailsPrintData> getPrintableElectionDataFromDB(String searchEid) throws IOException, SQLException {
       return db.getPrintableElectionData(searchEid);
    }
}
