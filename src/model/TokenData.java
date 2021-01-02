package model;

import java.sql.Timestamp;

public class TokenData {

    private String electionId;
    private String voterName;
    private String electionTitle;
    private String electionStatus;
    private Integer token;
    private Timestamp tokenDate;

    public TokenData(String electionId,String voterName,String electionTitle,String electionStatus,Integer token,Timestamp tokenDate){
        this.electionId = electionId;
        this.voterName= voterName;
        this.electionTitle = electionTitle;
        this.electionStatus = electionStatus;
        this.token = token;
        this.tokenDate = tokenDate;
    }

    public String getElectionId() {
        return electionId;
    }

    public String getVoterName() {
        return voterName;
    }

    public String getElectionTitle() {
        return electionTitle;
    }

    public String getElectionStatus() {
        return electionStatus;
    }

    public Integer getToken() {
        return token;
    }

    public Timestamp getTokenDate() {
        return tokenDate;
    }
}
