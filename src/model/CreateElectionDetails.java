package model;

//This Model Is ONly form Storring Information of Craete Election Panel Excluding CAndidates Information..

public class CreateElectionDetails {

    private String electionId;
    private String electionTitle;
    private Integer noOfCandidates;
    private String place;
    private String date;

    public CreateElectionDetails(String electionId,String electionTitle,Integer noOfCandidates,String place,String date){
        this.electionId = electionId;
        this.electionTitle = electionTitle;
        this.noOfCandidates = noOfCandidates;
        this.place = place;
        this.date = date;
    }

    //Creating Getters And Setters for these....

    public String getElectionId() {
        return electionId;
    }

    public void setElectionId(String electionId) {
        this.electionId = electionId;
    }

    public String getElectionTitle() {
        return electionTitle;
    }

    public void setElectionTitle(String electionTitle) {
        this.electionTitle = electionTitle;
    }

    public Integer getNoOfCandidates() {
        return noOfCandidates;
    }

    public void setNoOfCandidates(Integer noOfCandidates) {
        this.noOfCandidates = noOfCandidates;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
