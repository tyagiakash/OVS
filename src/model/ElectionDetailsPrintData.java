package model;

import javax.swing.*;

//Creating Class for Storing Data of CandidateDetails Table and ElectionDetails Table..
//This class acts as a Model..

public class ElectionDetailsPrintData {
    private String electionId;
    private String electionTitle;
    private Integer totalCandidates;
    private String place;
    private String date;
    private Integer candidateId;
    private String candidateName;
    private String candidateDetails;
    private ImageIcon candidatePhoto;
    private ImageIcon electionSymbolPhoto;
    private String eligibility;


    public ElectionDetailsPrintData(String electionId ,String electionTitle , Integer totalCandidates,String place,String date ,Integer candidateId ,String candidateName , String candidateDetails,ImageIcon photo,ImageIcon symbol,String eligibility){
        this.electionId = electionId;
        this.electionTitle = electionTitle;
        this.totalCandidates = totalCandidates;
        this.place = place;
        this.date = date;
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.candidateDetails = candidateDetails;
        this.candidatePhoto = photo;
        this.electionSymbolPhoto = symbol;
        this.eligibility = eligibility;

    }

    //Getters and Setters  for all the Variables...


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

    public Integer getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(Integer totalCandidates) {
        this.totalCandidates = totalCandidates;
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

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateDetails() {
        return candidateDetails;
    }

    public void setCandidateDetails(String candidateDetails) {
        this.candidateDetails = candidateDetails;
    }

    public ImageIcon getCandidatePhoto() {
        return candidatePhoto;
    }

    public void setCandidatePhoto(ImageIcon candidatePhoto) {
        this.candidatePhoto = candidatePhoto;
    }

    public ImageIcon getElectionSymbolPhoto() {
        return electionSymbolPhoto;
    }

    public void setElectionSymbolPhoto(ImageIcon electionSymbolPhoto) {
        this.electionSymbolPhoto = electionSymbolPhoto;
    }

    public String getEligibility() {
        return eligibility;
    }
}