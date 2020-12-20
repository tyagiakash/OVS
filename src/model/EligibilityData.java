package model;

public class EligibilityData {

    private String electionId;
    private Boolean allCandidates;
    private Integer startingYear;
    private Integer endingYear;
    private Boolean isMCAselected;
    private Boolean isBtechSelected;
    private Boolean isMtechSelected;
    private Boolean isArtsSelected;
    private String singleEligibilityString;

    public String getElectionId() {
        return electionId;
    }

    public Boolean getAllCandidates() {
        return allCandidates;
    }

    public Integer getStartingYear() {
        return startingYear;
    }

    public Integer getEndingYear() {
        return endingYear;
    }

    public Boolean getMCAselected() {
        return isMCAselected;
    }

    public Boolean getBtechSelected() {
        return isBtechSelected;
    }

    public Boolean getMtechSelected() {
        return isMtechSelected;
    }

    public Boolean getArtsSelected() {
        return isArtsSelected;
    }

    public String getSingleEligibilityString() {
        return singleEligibilityString;
    }

    public EligibilityData(String electionId, Boolean allCandidates, Integer startingYear, Integer endingYear, Boolean isMCAselected, Boolean isBtechSelected, Boolean isMtechSelected, Boolean isArtsSelected, String singleEligibilityString){
        this.electionId = electionId;
        this.allCandidates = allCandidates;
        this.startingYear = startingYear;
        this.endingYear = endingYear;
        this.isMCAselected = isMCAselected;
        this.isBtechSelected = isBtechSelected;
        this.isMtechSelected = isMtechSelected;
        this.isArtsSelected = isArtsSelected;
        this.singleEligibilityString = singleEligibilityString;
    }

    //Creating Getters for these Variables...


}
