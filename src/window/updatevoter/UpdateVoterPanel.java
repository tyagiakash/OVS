package window.updatevoter;

import controller.Controller;
import model.UpdateVoter;
import window.searchvoter.SearchFrame;
import window.searchvoter.SearchFrameListner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateVoterPanel extends JPanel {

    //Creating Components objects...
    private MenuPanelUpdate menuPanelUpdate;
    private ContentPanelUpdate contentPanelUpdate;
    private SearchFrame searchFrame;
    private Controller controller;
    private UpdateVoter updateVoterDataFromDB;


    public UpdateVoterPanel(){

        setLayout(new BorderLayout());
        setBackground(Color.red);

        //Initializing Components..
        menuPanelUpdate = new MenuPanelUpdate();
        searchFrame = new SearchFrame();
        controller = new Controller();

        //Adding panels to the main Layout i.e UpdateVoterPanel
        add(menuPanelUpdate,BorderLayout.NORTH);

        //Setting Up default Visible for frame to false..
        setVisible(false);

         //Implementing a method on serach frame to pass A listner on it and getting the data.
         searchFrame.setSearchFrameListner(new SearchFrameListner() {
             @Override
             public void framelistnerActivate(String textField, String type) throws SQLException, IOException {

                 if (type.equals("EmailId")){
                     textField ='"'+textField+'"';
                 }
                 updateVoterDataFromDB = controller.searchVoter(textField,type);

                 /*
                 Checking @updateVoterDataFromDb wheteher it is null or not if it is , then
                 Voter not found else display info of voters.. to do so we add contentpanleUpdate panel
                 to this panel... and setVisible true for this panel..
                  */
                 if (updateVoterDataFromDB != null){
                     searchFrame.setVisible(false);
                     contentPanelUpdate = new ContentPanelUpdate(updateVoterDataFromDB);
                     add(contentPanelUpdate,BorderLayout.CENTER);
                     revalidate();
                     repaint();
                     setVisible(true);

                     //Getting Confirmation from ContentPanel Update fro Update Button Pressed via Listner
                     contentPanelUpdate.setContentPanelListner(new ContentPanelListner() {
                         @Override
                         public void btnConfirmListner() throws FileNotFoundException, SQLException {
                             //Calling UpdateVoterData Method from Controller To Update Records Back to Db.
                             int confirm = controller.updateVoterData();

                             //The above Calling Return 1 for Successfully Update--> setVisible this frame to false..
                             if (confirm == 1){
                                 JOptionPane.showMessageDialog(null,"Update Successfully!!","Updated",JOptionPane.INFORMATION_MESSAGE);
                                 setVisible(false);
                             }
                         }
                     });

                 }
                 // Else showingg a pop up for showing record not found...
                 else {
                     JOptionPane pane = new JOptionPane("Voter Not Found!!!!",
                             JOptionPane.INFORMATION_MESSAGE);
                     JDialog dialog = pane.createDialog(null, "Error");
                     dialog.setModal(false);
                     dialog.setVisible(true);

                     //Automatically close the dialog after 1 sec...
                     new Timer(1000, new ActionListener() {
                         @Override
                         public void actionPerformed(ActionEvent e) {
                             dialog.setVisible(false);
                         }
                     }).start();
                 }

             }
         });


    }
}
