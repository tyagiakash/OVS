package window.newvoter;

import java.util.EventObject;

public class NewVoterRegistrationPanelEvent extends EventObject {

    //Variables for Storing Data...
    private String emailId;
    private Integer registrationNo;
    private Integer yeraofAdm;
    private String name;
    private String fName;
    private String gender;
    private String course;
    private String city;
    private String mobileNo;


    //Default constructor...
    public NewVoterRegistrationPanelEvent(Object source) {
        super(source);
    }

    //Custom Constructor for taking all values as a  parameter from createNewVoterPanel..
    public NewVoterRegistrationPanelEvent(Object source,String emailId,Integer registrationNo,Integer yeraofAdm,String name,String fName,String gender,String course,String city,String mobileNo) {
        super(source);
        this.emailId = emailId;
        this.registrationNo = registrationNo;
        this.yeraofAdm = yeraofAdm;
        this.name = name;
        this.fName = fName;
        this.gender = gender;
        this.course = course;
        this.city = city;
        this.mobileNo = mobileNo;
    }

    //Setting Up Getter's and Setter's for the same..

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Integer getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(Integer registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Integer getYeraofAdm() {
        return yeraofAdm;
    }

    public void setYeraofAdm(Integer yeraofAdm) {
        this.yeraofAdm = yeraofAdm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
