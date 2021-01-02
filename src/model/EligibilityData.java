package model;

import java.util.ArrayList;

public class EligibilityData {

    private String electionId;
    private Boolean allCandidates;
    private String courseEligibility;
    private String yearEligibility;
    private String singleEligibilityString;

    public String getElectionId() {
        return electionId;
    }

    public Boolean getAllCandidates() {
        return allCandidates;
    }


    public String getCourseEligibility() {
        return courseEligibility;
    }

    public String getYearEligibility() {
        return yearEligibility;
    }

    public String getSingleEligibilityString() {
        return singleEligibilityString;
    }



    public EligibilityData(String electionId, Boolean allCandidates,String courseEligibility,String yearEligibility, String singleEligibilityString){
        this.electionId = electionId;
        this.allCandidates = allCandidates;
        this.courseEligibility = courseEligibility;
        this.yearEligibility = yearEligibility;
        this.singleEligibilityString = singleEligibilityString;
    }



}
