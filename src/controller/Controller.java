package controller;

import model.CreateElectionDetails;
import model.Database;
import window.createelection.FormPanelEvent;

//This Class Acts as A Controller Between Models And Other Classes......

public class Controller {

    //Creating Instance of @Database
    Database db = new Database();


    public void addElectionDetails(FormPanelEvent ev) {
        String id = ev.getId();
        String title = ev.getTitle();
        Integer noOfCan = ev.getNoOfCandidate();
        String place = ev.getPlace();
        String date = ev.getDate();

        db.addElectionDetailsToDB(id,title,noOfCan,place,date);

    }
}
