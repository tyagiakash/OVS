package window.createelection;


//This Class is Used to Handle All Data in CandidateFormPanel and save this ..

import java.util.EventObject;

public class CandidateFormPanelEvent extends EventObject {

    //Creating Variables for Storing Data..
    private String electionId;
    private String candidateDetails;
    private String candidatePhotoPath;
    private String candidateSymbolPhotoPath;
    private Integer candidateId;

    public CandidateFormPanelEvent(Object source) {
        super(source);
    }

    public CandidateFormPanelEvent(Object source,String electionId,Integer candidateId,String candidateDetails,String candidatePhotoPath,String candidateSymbolPhotoPath) {

        super(source);

        this.electionId = electionId;
        this.candidateId = candidateId;
        this.candidateDetails = candidateDetails;
        this.candidatePhotoPath = candidatePhotoPath;
        this.candidateSymbolPhotoPath = candidateSymbolPhotoPath;
    }
    //Setting Up Getters for These Variables.....


    public Integer getCandidateId() {
        return candidateId;
    }

    public String getElectionId() {
        return electionId;
    }

    public String getCandidateDetails() {
        return candidateDetails;
    }

    public String getCandidatePhotoPath() {
        return candidatePhotoPath;
    }

    public String getCandidateSymbolPhotoPath() {
        return candidateSymbolPhotoPath;
    }
}
