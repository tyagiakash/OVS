package model;

public class CreateElectionCandidateDetails {

    private String electionId;
    private String candidatesDetail;
    private String photoPath;
    private String symbolPath;
    private String noOfCandidates;
    private Integer candidateId;

    public CreateElectionCandidateDetails(String electionId,Integer candidateId,String candidatesDetail,String photoPath,String symbolPath,String noOfCandidates){
        this.electionId = electionId;
        this.candidatesDetail = candidatesDetail;
        this.photoPath = photoPath;
        this.symbolPath = symbolPath;
        this.noOfCandidates = noOfCandidates;
        this.candidateId = candidateId;
    }

    //Creating Getters and Setters for these...


    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String getElectionId() {
        return electionId;
    }

    public void setElectionId(String electionId) {
        this.electionId = electionId;
    }

    public String getCandidatesDetail() {
        return candidatesDetail;
    }

    public void setCandidatesDetail(String candidatesDetail) {
        this.candidatesDetail = candidatesDetail;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getSymbolPath() {
        return symbolPath;
    }

    public void setSymbolPath(String symbolPath) {
        this.symbolPath = symbolPath;
    }

    public String getNoOfCandidates() {
        return noOfCandidates;
    }

    public void setNoOfCandidates(String noOfCandidates) {
        this.noOfCandidates = noOfCandidates;
    }
}
