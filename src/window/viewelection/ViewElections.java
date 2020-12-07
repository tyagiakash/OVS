package window.viewelection;

import controller.Controller;
import window.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.sql.SQLException;

public class ViewElections extends JPanel {

    private HeadPanel headPanel;
    private JPanel contentPanel;
    private PrintableForm printableForm;

    //Creating Object of Controller...
    Controller controller = new Controller();

    public ViewElections() throws SQLException, IOException {

        //Initializing Components
        contentPanel = new JPanel();
        contentPanel.setBackground(Color.PINK);

        //At Starting of this Panel we need to fetch the Election's Id's from Database..
        //And pass These Id's to the Head Panel...
        //Here Initializing HeadPanel Object Here......
        headPanel = new HeadPanel(controller.getElectionIdFromDB());

        BorderLayout bl = new BorderLayout();

        //Setting Layout To Bordered Layout
        setLayout(bl);


        //Adding Components to ViewElection Panel
        add(headPanel,BorderLayout.NORTH);

        //Getting Button Clicked listner from HeadPanel
        headPanel.setButtonClicked(new HeadPanelListner() {
            @Override
            public void ButtonClicked(String btn,String id) throws IOException, SQLException {

                if(btn.equals("closeBtn")){
                    JFrame parent =(JFrame)getTopLevelAncestor();
                    parent.dispose();
                    new MainWindow();
                }
                else if (btn.equals("viewBtn")){

                    if (id.equals("Select")){
                        JOptionPane.showMessageDialog(null,"Please Select an Id.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        //Adding Panel Dynamically....
                        printableForm = new PrintableForm(controller.getPrintableElectionDataFromDB(id));
                        add(new JScrollPane(printableForm, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
                        revalidate();
                    }
                }
                else if(btn.equals("printBtn")){
                    printRecord(printableForm);
                }
            }
        });

    }

    //Function for Printing JPanel
    private void printRecord(JPanel panel){
        //Create Object of PrinterJob Class
        PrinterJob printerJob = PrinterJob.getPrinterJob();

        //Setting Job Name
        printerJob.setJobName("Printing Election Details");

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
                graphics2D.translate(70,70);
                graphics2D.scale(0.75,0.75);

                //Now Paint panel to Graphics 2D
                panel.paint(graphics2D);

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
