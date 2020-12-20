package model;

import window.createelection.CreateElection;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Database extends Component {

    //Create Varibale for Srtup Connection
    private Connection conn = null;

    //Function for create Connection between OVS and DB
    public  void createConnection(){
        if(conn != null) return;
        try{
            //Class Path for Java MYSQL Drivers.....
            Class.forName("com.mysql.jdbc.Driver");

            //Connecting to Db using credntials...
             conn= DriverManager.getConnection(
                    "jdbc:mysql://db4free.net/ovsdbms","ovsadmin","12345670");
             System.out.println("Connected Successfuly!!!!!!!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error Occured During Connectio..");
            e.printStackTrace();
        }
    }

    //Function for Disconnect DB connection
    public  void disconnectConnection(){
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Disconect Successfully..");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                System.out.println("Can't Disconnct Error Occured!!!");
            }
        }
    }


    //Function for Adding Election Details to the DataBase....
    public void addElectionDetailsToDB(String Id,String title,Integer noOfCand,String mplace,String mdate) {

       try {

           //Making  Query for Adding all the data......
           String query = " insert into ElectionDetails" + " values (?, ?, ?, ?, ?)";

           // create the mysql insert preparedstatement
           PreparedStatement preparedStmt = conn.prepareStatement(query);
           preparedStmt.setString(1, Id);
           preparedStmt.setString(2, title);
           preparedStmt.setInt(3, noOfCand);
           preparedStmt.setString(4, mplace);
           preparedStmt.setDate(5, Date.valueOf(mdate));

           // execute the preparedstatement
           preparedStmt.executeUpdate();

           //Show dailog for Successfully Update the data....
           JOptionPane.showMessageDialog(this, "Successfully Updated", "Alert", JOptionPane.INFORMATION_MESSAGE);
       }catch (Exception e){

           //Show dailog for  Showing an Error...
           JOptionPane.showMessageDialog(this, e, "Error Occured!!", JOptionPane.ERROR_MESSAGE);
       }
    }

    //Function for Adding Candidate  Details to the DataBase....
    public void addCandidateDetailsToDB(String mEId, Integer mCId,String cName,String cDetails, String mCDetails, String mCPhotoPath, String mCSymPhoPath) throws IOException {

        //Converting Images to byte..
        InputStream iPhoto = new FileInputStream(new File(mCPhotoPath));
        InputStream iSymbol = new FileInputStream(new File(mCSymPhoPath));

        try {

            //Making  Query for Adding all the data......
            String query = " insert into CandidateDetails(ElectionId,CandidateId,CandidateName,Details,Photo,Symbol)" + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1,mEId);
            preparedStmt.setInt(2, mCId);
            preparedStmt.setString(3,cName);
            preparedStmt.setString(4, cDetails);
            preparedStmt.setBlob(5,iPhoto);
            preparedStmt.setBlob(6,iSymbol);


            // execute the preparedstatement
            preparedStmt.execute();

            //Show dailog for  Showing an Successfully...
            JOptionPane.showMessageDialog(this, "Data Inserted Successfullly!!!", "Data Inserted", JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e, "Error Occured!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Function for Getting all Election Id's from Database...
    public ArrayList<ElectionId> getElectionIdsFromDB() throws SQLException {

        //Creating array list to store fetched ID's from Database..
        ArrayList<ElectionId> electionIds = new ArrayList<ElectionId>();

        //Making  Query for Getting  all the ElectionID's......
        String query = "SELECT `ElectionId`,`ElectionTitle` FROM `ElectionDetails` WHERE 1";

        // Create statement object..
        Statement stmt = conn.createStatement();

        // execute the preparedstatement and save to ResultSet ob..
        ResultSet rs = stmt.executeQuery(query);

        //Adding all ElectionId's to the array List...
        while (rs.next()){
            String id = rs.getString("ElectionId");
            String title = rs.getString("ElectionTitle");

            ElectionId temp = new ElectionId(id,title);
            electionIds.add(temp);
        }
        rs.close();
        //Returning the array list of containing all electionId's
        return electionIds;
    }

    //Method for Generating all election id's Whose eligiblity equals to none.. for ElectionDetails..
    //Function for Getting all Election Id's from Database...
    public ArrayList<ElectionId> getElectionIdsForNonEligiblityFromDB() throws SQLException {

        //Creating array list to store fetched ID's from Database..
        ArrayList<ElectionId> electionIds = new ArrayList<ElectionId>();

        //Making  Query for Getting  all the ElectionID's......
        String query = "SELECT `ElectionId` , 'ElectionTitle' FROM ElectionDetails WHERE eligibilityElection = 'none'";

        // Create statement object..
        Statement stmt = conn.createStatement();

        // execute the preparedstatement and save to ResultSet ob..
        ResultSet rs = stmt.executeQuery(query);

        //Adding all ElectionId's to the array List...
        while (rs.next()){
            String id = rs.getString("ElectionId");
            String title = rs.getString("ElectionTitle");

            ElectionId temp = new ElectionId(id,title);
            electionIds.add(temp);
        }
        rs.close();
        //Returning the array list of containing all electionId's
        return electionIds;
    }

    //Create Function for Getting all details from Election Details and
    //Candidate Detls Tables form Database... and it return araayList of ElectionDetailsPrintData
    public  ArrayList<ElectionDetailsPrintData> getPrintableElectionData(String searchEid) throws SQLException, IOException {

        //Creating a Array of ElectionDetailsPrintData Model for Storing the
        //Different number of Rows...
         ArrayList<ElectionDetailsPrintData> arrayOfData;
         arrayOfData = new ArrayList<ElectionDetailsPrintData>();

        //Making  Query for Getting  all the Columns of ElectionDetails
        // and Candidate table Columns's...... of specific ElectionId...
        String query = "SELECT * FROM ElectionDetails INNER JOIN CandidateDetails ON ElectionDetails.ElectionId = CandidateDetails.ElectionId  " +
                "WHERE ElectionDetails.ElectionId ="+ "'" + searchEid +"'";

        // Create statement object..
        Statement stmt = conn.createStatement();

        // execute the preparedstatement and save to ResultSet ob..
        ResultSet rs = stmt.executeQuery(query);

        //Iterate rs to the for each row...

        while (rs.next()){

              //Variables for Storing Fetched data from db..
              String eID = rs.getString("ElectionId");
              String eTitle = rs.getString("ElectionTitle");
              Integer tCandidates = rs.getInt("TotalCandidates");
              String ePlace = rs.getString("Place");
              String eDate = rs.getDate("Date").toString();
              Integer cID = rs.getInt("CandidateId");
              String cName = rs.getString("CandidateName");
              String cDetails = rs.getString("Details");
              Blob cPhoto = rs.getBlob("Photo");
              Blob cSymbol = rs.getBlob("Symbol");
              String ele = rs.getString("eligibilityElection");

              ImageIcon photoIcon = convertImage(cPhoto);
              ImageIcon symbolIcon = convertImage(cSymbol);

              //Creating a temporary object of ElectionDetailsPrint Data Model
              // and add this to the arrayList of same type for multiple rows
              ElectionDetailsPrintData temp = new ElectionDetailsPrintData(eID,eTitle,tCandidates,ePlace,eDate,cID,cName,cDetails,photoIcon,symbolIcon,ele);
              arrayOfData.add(temp);
        }
        return arrayOfData;
    }

    /*
    Function for Gettting all the data from NewVoterRegsitrationPanel through VoterPanel and Controller
    and add this to DB and return voterId from the Db...
     */

    public void addVoterDetailsToDB(String emailId,Integer registrationNO,Integer yOADM,String name, String fName,String gender,String course,String city,String mobile) throws SQLException, FileNotFoundException {

        try {
            //Variablle for Storring VotersID return by Database...
            String voterId = null;

            //Converting Images to byte..
            InputStream iPhoto = new FileInputStream(new File("CapturePhoto/photo.jpg"));

            //Making  Query for Adding all the data......
            String query = "insert into Voters(EmailId,EnrollmentNo,AdmissionYear,Name,FName,Gender,Course,City,Mobile,Photo)" + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, emailId);
            preparedStmt.setInt(2, registrationNO);
            preparedStmt.setInt(3, yOADM);
            preparedStmt.setString(4, name);
            preparedStmt.setString(5, fName);
            preparedStmt.setString(6, gender);
            preparedStmt.setString(7, course);
            preparedStmt.setString(8,city);
            preparedStmt.setString(9, mobile);
            preparedStmt.setBlob(10, iPhoto);


            // execute the preparedstatement
            preparedStmt.execute();

            //Creating instamce of ResultSet to get VoterId from User...
            ResultSet rs = preparedStmt.getGeneratedKeys();
            while (rs.next()) {
                voterId = "OVS" + rs.getInt(1);
            }
            rs.close();

            //Generating Pop Up for Successfully Update data And Print returning Voter Id ...
            JOptionPane.showMessageDialog(null, "Voter ID:" + voterId, "Successfully Saved!!", JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,e,"Error Occured!",JOptionPane.ERROR_MESSAGE);
        }
    }

    //Function for Searching a record of voter and return deatails for the same...
    public UpdateVoter searchVoterToDB(String id,String type) throws SQLException, IOException {

        String query = "Select * FROM Voters WHERE "+type+" = "+id;
        UpdateVoter temp = null;

        // Create statement object..
        Statement stmt = conn.createStatement();

        // execute the preparedstatement and save to ResultSet ob..
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String voterName = rs.getString("Name");
            Integer voterId = rs.getInt("VoterId");
            String city = rs.getString("City");
            String mobileNumber = rs.getString("Mobile");
            String course = rs.getString("Course");
            Blob voterPhoto = rs.getBlob("Photo");

            ImageIcon photoIcon = convertImage(voterPhoto);

            temp = new UpdateVoter(voterName,voterId,city,mobileNumber,course,photoIcon);
        }
        return temp;
    }
    /*
    Function to Update Voter Data Back to DB...
     */

    public int UpdateVoterDataToDB(UpdateVoter voterData) throws FileNotFoundException, SQLException {

        if (voterData.getPhotoUpdated()){

            //Converting Images to byte..
            InputStream iPhoto = new FileInputStream(new File("CapturePhoto/photo.jpg"));

            PreparedStatement update = conn.prepareStatement
                    ("UPDATE Voters SET City = ?, Course = ?, Mobile = ?, Photo = ? WHERE VoterId = ?");

            update.setString(1, voterData.getCity());
            update.setString(2, voterData.getCourse());
            update.setString(3, voterData.getMobileNumber());
            update.setBlob(4,iPhoto);
            update.setInt(5,voterData.getVoterId());
            update.executeUpdate();
            return 1;
        }
        else {
            PreparedStatement update = conn.prepareStatement
                    ("UPDATE Voters SET City = ?, Course = ?, Mobile = ? WHERE VoterId = ?");

            update.setString(1, voterData.getCity());
            update.setString(2, voterData.getCourse());
            update.setString(3, voterData.getMobileNumber());
            update.setInt(4,voterData.getVoterId());
            update.executeUpdate();
            return 1;
        }
    }

    /*
    Method for inserting data into Eligibility Table from Eligibility Panel..
     */

    public int addEligibilityDataToDB(EligibilityData data) throws SQLException {


        if (data.getAllCandidates()){
            String querry = "INSERT INTO Eligibility(ElectionId,AllCandidates)" + " values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(querry);
            preparedStatement.setString(1,data.getElectionId());
            preparedStatement.setBoolean(2,true);
            preparedStatement.execute();
        }
        else {
            String querry = "INSERT INTO Eligibility(ElectionId,AllCandidates,StartingYear,EndingYear,MCA,BTech,MTech,Arts)" + " values (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(querry);
            stmt.setString(1,data.getElectionId());
            stmt.setBoolean(2,false);
            stmt.setInt(3,data.getStartingYear());
            stmt.setInt(4,data.getEndingYear());
            stmt.setBoolean(5,data.getMCAselected());
            stmt.setBoolean(6,data.getBtechSelected());
            stmt.setBoolean(7,data.getMtechSelected());
            stmt.setBoolean(8,data.getArtsSelected());
            stmt.execute();
        }

        //Also inserting Eligibility to the Election Details table...
        PreparedStatement update = conn.prepareStatement
                ("UPDATE ElectionDetails SET eligibilityElection = ? WHERE ElectionId = ?");

        update.setString(1, data.getSingleEligibilityString());
        update.setString(2,data.getElectionId());
        update.executeUpdate();

        return 1;
    }

    //Functionn to convert A Blob object to Buffered Image and resize it
    private ImageIcon convertImage(Blob b) throws SQLException, IOException {
        BufferedImage bufferedImage;
        InputStream inputStream = b.getBinaryStream(1,b.length());
        bufferedImage = ImageIO.read(inputStream);
        Image tImage = (Image)bufferedImage;
        Image modifiedImgIcon = tImage.getScaledInstance(120,120,Image.SCALE_SMOOTH);
        return new ImageIcon(modifiedImgIcon);
    }
}
