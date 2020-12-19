package window.eligiblity;

import controller.Controller;
import model.ElectionId;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class EligibilityPanel extends JPanel implements ItemListener, ActionListener {

    private JComboBox<String> electionsComboBox;
    private JLabel electionsCbJLabel;
    private JPanel headPanel;
    private JPanel contentPanel;
    private JLabel electionTitleJlabel;
    private JButton closeBtn;

    //Components for content Panel..
    private JRadioButton allRadioBtn;
    private JRadioButton filterRadioBtn;
    private ButtonGroup btnGroup;
    private JLabel allLabel;
    private JLabel yearofAdmLabel;
    private JComboBox<Integer> startingYearCBox;
    private JComboBox<Integer> endingYearCBox;
    private JLabel courselabel;
    private JCheckBox mcaCB,btechCB,mtechCB,artsCB;
    private JButton saveBtn;

    //Creating Instance  of Controller...
    private Controller controller = new Controller();

    //Creating a Array List of ElectionID's
    private ArrayList<ElectionId> electionIDs;

    //Variables for Storing Info as per Selected..
    private Integer startingYear = 2017;
    private Integer endingYear = 2019;
    private Boolean isMCAChecked = false;
    private Boolean isBtechChecked = false;
    private Boolean isMtechChecked = false;
    private Boolean isArtsChecked = false;
    private String currentElectionId;

    public EligibilityPanel() throws SQLException {

        //Setting Up Layout for this Panel..
        setLayout(new BorderLayout());

        //Getting Election Ids Frorm Db via Controller..
        electionIDs = controller.getElectionIdFromDB();

        //Initializing Jpanel Components
        headPanel = new JPanel();
        contentPanel = new JPanel();
        electionsComboBox = new JComboBox();
        electionsCbJLabel = new JLabel("Select Election:");
        electionTitleJlabel = new JLabel("Election Title");
        closeBtn = new JButton("Close");

        //Components for Content Panel..
        allRadioBtn = new JRadioButton("All Candidates");
        allLabel = new JLabel("* Allowing all Candidates...");
        filterRadioBtn = new JRadioButton("Filter Candidates");
        btnGroup = new ButtonGroup();
        yearofAdmLabel = new JLabel("* Based On Year of Adm.:");
        startingYearCBox = new JComboBox<>();
        startingYearCBox.addItem(2017);
        startingYearCBox.addItem(2018);
        startingYearCBox.addItem(2019);
        startingYearCBox.addItem(2020);
        startingYearCBox.addItem(2021);
        startingYearCBox.addItem(2022);
        endingYearCBox = new JComboBox<>();
        endingYearCBox.addItem(2019);
        endingYearCBox.addItem(2020);
        endingYearCBox.addItem(2021);
        endingYearCBox.addItem(2022);
        endingYearCBox.addItem(2023);
        endingYearCBox.addItem(2024);
        endingYearCBox.addItem(2025);
        courselabel = new JLabel("* Based On Courses:");
        mcaCB = new JCheckBox("MCA");
        btechCB = new JCheckBox("Btech");
        mtechCB = new JCheckBox("MTech");
        artsCB = new JCheckBox("Arts");
        saveBtn = new JButton("Save Prefrences");

        //Adding Radio Buttons to Btn Group...
        btnGroup.add(allRadioBtn);
        btnGroup.add(filterRadioBtn);


        //Removing Focus Painted From Buttons..
        closeBtn.setFocusPainted(false);
        saveBtn.setFocusPainted(false);
        filterRadioBtn.setFocusPainted(false);
        allRadioBtn.setFocusPainted(false);
        mcaCB.setFocusPainted(false);
        btechCB.setFocusPainted(false);
        mtechCB.setFocusPainted(false);
        artsCB.setFocusPainted(false);

        //Selection By Default AllCAndidates selected and filter components disabled..
        allRadioBtn.setSelected(true);
        EnableDisable(false);

        //Adding action Listners on All Radio Button....
        allRadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnableDisable(false);
            }
        });

        //Adding action Listners on Filter Radio button...
        filterRadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EnableDisable(true);
            }
        });


        //Adding Listener To Buttons
        closeBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        allRadioBtn.setActionCommand("All");
        filterRadioBtn.setActionCommand("Filter");

    //Adding Items To Combo Box
        electionsComboBox.addItem("Select");
        for(int i =0;i<electionIDs.size();i++){
            electionsComboBox.addItem(electionIDs.get(i).getElectionId());
        }

        //Listner to @electionComboBox..
        electionsComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                String currentId = (String) itemEvent.getItem();
                if (currentId != "Select") {
                    contentPanel.setVisible(true);
                    currentElectionId = currentId;
                }
                else {
                    contentPanel.setVisible(false);
                }
            }
        });

        //Adding Item Listner to Combo Box

        //@electioComboBox
        electionsComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               String currentId = (String) e.getItem();
                for (int i=0;i<electionIDs.size();i++){
                    if (currentId.equals(electionIDs.get(i).getElectionId())){
                        electionTitleJlabel.setText(electionIDs.get(i).getElectionTitle());
                        break;
                    }
                }
            }
        });

        //@Starting Year ComboBox implementing Through Lambda
        startingYearCBox.addItemListener(e -> startingYear = (Integer) e.getItem());

        //@Ending Year ComboBox.. implementing using Lambda Funcation
        endingYearCBox.addItemListener(e -> endingYear =(Integer) e.getItem());

        //Adding Event Listner on CheckBoxes..
        mcaCB.addItemListener(this);
        btechCB.addItemListener(this);
        mtechCB.addItemListener(this);
        artsCB.addItemListener(this);


        headPanel.setPreferredSize(new Dimension(0,90));

        //Adding Components to the Main Panel..
        add(headPanel,BorderLayout.NORTH);
        add(contentPanel,BorderLayout.CENTER);

        //Setting Up Titled Border for content panel...
        Border inner = BorderFactory.createTitledBorder("Setting Eligibility Criteria For Election");
        Border outer = BorderFactory.createEmptyBorder(5,5,5,5);
        contentPanel.setBorder(BorderFactory.createCompoundBorder(outer,inner));

        /*
        Working on HeadPanel ie. placing Jcombobox and a Close Button on it..
         */
        headPanel.setLayout(null);

        //adding Components to the HeadPanel..
        headPanel.add(electionsCbJLabel);
        headPanel.add(electionsComboBox);
        headPanel.add(closeBtn);
        headPanel.add(electionTitleJlabel);

        //Setting Bounds to the Components...
        electionsCbJLabel.setBounds(20,15,110,25);
        electionsComboBox.setBounds(140,15,100,25);
        closeBtn.setBounds(515,15,75,25);
        electionTitleJlabel.setBounds(20,50,480,25);

        /*
        Working On Content Panel
         */

        //Adding all Check Boxes  to a single  Boxes so that they are nearer to each other..
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(mcaCB);
        horizontalBox.add(btechCB);
        horizontalBox.add(mtechCB);
        horizontalBox.add(artsCB);

        //Adding all Check Boxes  to a single  Boxes so that they are nearer to each other..
        Box horizontalBox2 = Box.createHorizontalBox();
        horizontalBox2.add(startingYearCBox);
        horizontalBox2.add(Box.createHorizontalStrut(10));
        horizontalBox2.add(endingYearCBox);

        //Setting Layout to the GridBag layout..
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        contentPanel.setVisible(false);

        //Desiginign ROW 1
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridwidth = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(30,20,0,0);
        contentPanel.add(allRadioBtn,gc);

        //Desiginign ROW 1.1
        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridwidth = 2;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,60,0,0);
        contentPanel.add(allLabel,gc);

        //Desiginign ROW 2
        gc.gridx = 0;
        gc.gridy++;
        gc.gridwidth = 2;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,20,0,0);
        contentPanel.add(filterRadioBtn,gc);

        //Row 3
        gc.gridx = 0;
        gc.gridy++;
        gc.gridwidth = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,60,0,0);
        contentPanel.add(yearofAdmLabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        contentPanel.add(horizontalBox2,gc);

        //Row 4
        gc.gridx = 0;
        gc.gridy++;
        gc.gridwidth = 1;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,60,0,0);
        contentPanel.add(courselabel,gc);

        gc.gridx++;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        contentPanel.add(horizontalBox,gc);

        //Row 5
        gc.gridx = 0;
        gc.gridy++;
        gc.gridwidth = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0,0,0,0);
        contentPanel.add(saveBtn,gc);

    }

    //Event Handler For Check Boxes..
    @Override
    public void itemStateChanged(ItemEvent e) {
        isMCAChecked = mcaCB.isSelected();
        isBtechChecked = btechCB.isSelected();
        isMtechChecked = mtechCB.isSelected();
        isArtsChecked = artsCB.isSelected();
    }

    //Event Handler For Save Btn...
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn.equals(saveBtn)){
            //First Check Whether Criteria is All or Filtered and then send data to controller..
            if (filterRadioBtn.isSelected()){
                Integer check = null;
                try {
                    check = controller.addEligibilityData(currentElectionId,false,startingYear,endingYear,isMCAChecked,isBtechChecked,isMtechChecked,isArtsChecked);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (check == 1){
                    JOptionPane.showMessageDialog(null,currentElectionId+" :Inserted","Inserted!!",JOptionPane.INFORMATION_MESSAGE);
                }

            }
            else if (allRadioBtn.isSelected()){
                System.out.println("All");
                Integer check = null;
                try {
                    check = controller.addEligibilityData(currentElectionId,true,null,null,false,false,false,false);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                if (check == 1){
                    JOptionPane.showMessageDialog(null,currentElectionId+" :Inserted","Inserted!!",JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }

    //Function for Enabling and disabling the filter Data Components...
    public void EnableDisable(Boolean b){
        startingYearCBox.setEnabled(b);
        endingYearCBox.setEnabled(b);
        mcaCB.setEnabled(b);
        btechCB.setEnabled(b);
        mtechCB.setEnabled(b);
        artsCB.setEnabled(b);
    }
}
