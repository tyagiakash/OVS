package model;

/*
this class is for holding the data for Update Panel..
 */

import javax.swing.*;

public class UpdateVoter {

    private String voterName;
    private Integer voterId;
    private String city;
    private String mobileNumber;
    private String course;
    private ImageIcon voterPhoto;
    private Boolean isPhotoUpdated = false;


    public  UpdateVoter(String voterName, Integer voterId, String city, String mobileNumber, String course, ImageIcon voterPhoto){

        this.voterName = voterName;
        this.voterId = voterId;
        this.city = city;
        this.mobileNumber = mobileNumber;
        this.course = course;
        this.voterPhoto = voterPhoto;
    }

    //Setting Up Gttters for its varibales..


    public Boolean getPhotoUpdated() {
        return isPhotoUpdated;
    }

    public void setPhotoUpdated(Boolean photoUpdated) {
        isPhotoUpdated = photoUpdated;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    public String getVoterName() {
        return voterName;
    }

    public Integer getVoterId() {
        return voterId;
    }

    public String getCity() {
        return city;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getCourse() {
        return course;
    }

    public ImageIcon getVoterPhoto() {
        return voterPhoto;
    }
}
