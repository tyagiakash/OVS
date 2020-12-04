package model;

import window.createelection.CreateElection;

import javax.print.attribute.standard.JobKOctetsProcessed;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Database extends Component {

    //Creating Variables for Storing Data...
    private String electionId;
    private String electionTitle;
    private Integer noOfCandidates;
    private String place;
    private String date;

    public Database() {

    }

    //Function for Adding Election Details to the DataBase....
    public void addElectionDetailsToDB(String Id,String title,Integer noOfCand,String place,String date){
       this.electionId = Id;
       this.electionTitle =title;
       this.noOfCandidates = noOfCand;
       this.place = place;
       this.date = date;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://sql12.freemysqlhosting.net/sql12380026","sql12380026","l4i2V9CQUr");
            Statement stmt=(Statement) con.createStatement();
//            ResultSet rs=stmt.executeQuery("select * from ElectionDetails");

          String query = " insert into ElectionDetails" + " values (?, ?, ?, ?, ?)";

          // create the mysql insert preparedstatement
          PreparedStatement preparedStmt = con.prepareStatement(query);
          preparedStmt.setString (1, electionId);
          preparedStmt.setString (2, electionTitle);
          preparedStmt.setInt   (3, noOfCandidates);
          preparedStmt.setString(4, place);
          preparedStmt.setDate  (5, Date.valueOf(date));

            // execute the preparedstatement
            preparedStmt.execute();
            System.out.println("Helloooo");

            con.close();

            JOptionPane.showMessageDialog(this,"Successfully Updated","Alert",JOptionPane.WARNING_MESSAGE);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,e,"Error...",JOptionPane.ERROR_MESSAGE);

        }
    }


}
