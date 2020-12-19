package model;

/*
This classs only contains Infor of election id and title that is On DB..
 */

public class ElectionId {
    private String electionId;
    private String electionTitle;

    public ElectionId(String electionId,String electionTitle){
        this.electionId = electionId;
        this.electionTitle = electionTitle;
    }

    //Creating Getters for these Variables..


    public String getElectionId() {
        return electionId;
    }

    public String getElectionTitle() {
        return electionTitle;
    }
}
