package window.token;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.sql.Timestamp;

/*
 This Frame is for Printing the Token Slip of the user...
 */

public class FinalTokenGenerate extends JFrame implements ActionListener {

    private JButton closeBtn;
    private JButton printBtn;
    private JTextArea textArea;
    private Controller controller;

    public FinalTokenGenerate(String electionId, String voterName, String electionTitle, String electionStatus, Integer token, Timestamp tokenDate, Integer voterId) throws SQLException {

        //Setting Up Controller object and Update Token Date... to the DB...
        controller = new Controller();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp timeStFromDB=controller.setTokenDate(timestamp,voterId,electionId);

        setSize(318,290);
        setResizable(false);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //Initialzing the objects..
        closeBtn = new JButton("Close");
        printBtn = new JButton("Print");
        textArea = new JTextArea(10,6);

        //SetLayout to null..
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Adding Coponents to  the panel...
        add(textArea);
        add(printBtn);
        add(closeBtn);

        //Setting up  Border to textArea...
        textArea.setBorder(BorderFactory.createEtchedBorder());
        textArea.setEditable(false);

        //Set Bounds for the Components..
        textArea.setBounds(5,5,308,250);
        printBtn.setBounds(5,260,80,25);
        closeBtn.setBounds(233,260,80,25);

        //Adding Liistner to the Buttons...
        printBtn.addActionListener(this);
        closeBtn.addActionListener(this);

        setVisible(true);
        setTokenMessage(electionTitle,electionId,voterName,voterId,"00/00/00",timeStFromDB,token);

        textArea.setFont(new Font("Arial",Font.BOLD,11));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn.equals(closeBtn)){
            dispose();
        }
        else if (btn.equals(printBtn)){
            printRecord(textArea);
        }

    }

    private void setTokenMessage(String title,String eleId,String name,Integer voterID,String eleDate,Timestamp tokenDate,Integer tokenNo){

        String s = "   ##### Online Voting System Token #####  " +"\n\n"+
                "   " + title + "  \n\n"+
                "   ELECTION ID       :  " + eleId + "  \n\n"+
                "   VOTER NAME      :  " + name + "  \n\n"+
                "   VOTER ID            :  " + voterID + "  \n\n"+
                "   ELECTION DATE  :  " + eleDate + "  \n\n"+
                "   TOKEN DATE       :  " + tokenDate + "  \n\n"+
                "   TOKEN NUMBER  : " + tokenNo + "  \n\n"+
                "   ######### HAPPY  VOTING ########  ";
        textArea.setText(s);
    }

    //Function for Printing JPanel
    private void printRecord(JTextArea area){
        //Create Object of PrinterJob Class
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        //Setting Job Name
        printerJob.setJobName("Printing Token");

        //Set Printable
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int i) throws PrinterException {
                //Checking Page Index
                if (i > 0){
                    return Printable.NO_SUCH_PAGE;
                }

                //Make 2D Graphics to Map Content
                Graphics2D graphics2D = (Graphics2D)graphics;

                //Translate and Scaleing
                graphics2D.translate(200,80);
                graphics2D.scale(0.75,0.75);

                //Now Paint panel to Graphics 2D
                area.paint(graphics2D);

                //return if page Exists
                return Printable.PAGE_EXISTS;
            }

        });
        //Store Printer Dialog as Boolean
        boolean returningResult = printerJob.printDialog();


        //Check if Dialog is Shown
        if (returningResult){
            try {
                printerJob.print();
            }
            catch (PrinterException e){
                JOptionPane.showMessageDialog(this,"Print Error"+e);
            }
        }
    }

}
