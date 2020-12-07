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
                    "jdbc:mysql://sql12.freemysqlhosting.net/sql12380026","sql12380026","l4i2V9CQUr");
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
    public ArrayList<String> getElectionIdsFromDB() throws SQLException {

        //Creating array list to store fetched ID's from Database..
        ArrayList<String> electionIds = new ArrayList<String>();

        //Making  Query for Getting  all the ElectionID's......
        String query = "SELECT `ElectionId` FROM `ElectionDetails` WHERE 1";

        // Create statement object..
        Statement stmt = conn.createStatement();

        // execute the preparedstatement and save to ResultSet ob..
        ResultSet rs = stmt.executeQuery(query);

        //Adding all ElectionId's to the array List...
        while (rs.next()){
            electionIds.add(rs.getString("ElectionId"));
        }
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
        String query = "SELECT * FROM ElectionDetails INNER JOIN CandidateDetails ON ElectionDetails.ElectionId = CandidateDetails.ElectionId " +
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

              ImageIcon photoIcon = convertImage(cPhoto);
              ImageIcon symbolIcon = convertImage(cSymbol);

              //Creating a temporary object of ElectionDetailsPrint Data Model
              // and add this to the arrayList of same type for multiple rows
              ElectionDetailsPrintData temp = new ElectionDetailsPrintData(eID,eTitle,tCandidates,ePlace,eDate,cID,cName,cDetails,photoIcon,symbolIcon);
              arrayOfData.add(temp);
        }
        return arrayOfData;
    }

    //Functionn to convert A Blob object to Buffered Image and resize it
    private ImageIcon convertImage(Blob b) throws SQLException, IOException {
        BufferedImage bufferedImage;
        InputStream inputStream = b.getBinaryStream(1,b.length());
        bufferedImage = ImageIO.read(inputStream);
        Image tImage = (Image)bufferedImage;
        Image modifiedImgIcon = tImage.getScaledInstance(100,100,Image.SCALE_SMOOTH);
        return new ImageIcon(modifiedImgIcon);
    }

}
