package controller;

import model.*;
import window.createelection.CandidateFormPanelEvent;
import window.createelection.FormPanelEvent;
import window.newvoter.NewVoterRegistrationPanelEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//This Class Acts as A Controller Between Models And Other Classes......

public class Controller {

    //Creating Instance of @Database
    private Database db = new Database();

    //Creating instance of UpdateVoter Model..
    private UpdateVoter temp;

    //Function For Getting Data From @CreateElection  <---  FormPanel
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
    public ArrayList<ElectionId> getElectionIdFromDB() throws SQLException {
        //Creating Connection With DB and getting Result through Database Class...
        db.createConnection();
        return  db.getElectionIdsFromDB();

    }


    //Method for getting data from ElectionDetails and CandidateDetails from
    //database and send  to ViewElection
     public  ArrayList<ElectionDetailsPrintData> getPrintableElectionDataFromDB(String searchEid) throws IOException, SQLException {
       return db.getPrintableElectionData(searchEid);
    }

    /*
    Function for Getting All Voters Data from VoterPanel <---  NewVoterRegistrationPanel...
     */
    public void addVoterDetails(NewVoterRegistrationPanelEvent ev) throws FileNotFoundException, SQLException {

        //Variables for Storing Data...
        String emailId = ev.getEmailId() ;
        Integer registrationNo = ev.getRegistrationNo();
        Integer yeraofAdm = ev.getYeraofAdm();
        String name = ev.getName();
        String fName = ev.getfName();
        String gender = ev.getGender();
        String course = ev.getCourse();
        String city = ev.getCity();
        String mobileNo = ev.getMobileNo();

        db.createConnection();
        db.addVoterDetailsToDB(emailId,registrationNo,yeraofAdm,name,fName,gender,course,city,mobileNo);
    }

    /*
    Function for searching a result in databse if it is availabe then we can update it
     */
    public UpdateVoter searchVoter(String id, String type) throws SQLException, IOException {
        db.createConnection();
        temp = db.searchVoterToDB(id,type);
        return  temp;
    }

    //Method for Updating Voter Data Back to Db
    public int updateVoterData() throws FileNotFoundException, SQLException {
       return db.UpdateVoterDataToDB(temp);
    }

    //Method for Inserting Data Into Eligiblity table from Eligiblity Panel..
    public int addEligibilityData(String electionId, Boolean allCandidates, Integer startingYear, Integer endingYear, Boolean isMCAselected, Boolean isBtechSelected, Boolean isMtechSelected, Boolean isArtsSelected) throws SQLException {
        EligibilityData dat = new EligibilityData(electionId,allCandidates,startingYear,endingYear,isMCAselected,isBtechSelected,isMtechSelected,isArtsSelected);
        db.createConnection();
        return db.addEligibilityDataToDB(dat);
    }

}
