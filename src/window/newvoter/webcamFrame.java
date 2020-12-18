package window.newvoter;

import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/*
Here in this class we using external library @sarsox from gitHub used to capture Photo at Real Time...
 */

public class webcamFrame extends JFrame {

    private JLabel imageViewLabel;
    private JButton captureBtn;
    private JButton closeBtn;
    private Webcam webcam;


    public webcamFrame(){

       setSize(330,317);
       setTitle("Capture Photo");
       setResizable(false);
       setLayout(null);
       setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

       //Creating a New Panel for Showing capture Image on that..
       JPanel panel = new JPanel(new BorderLayout());
       panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY,10));

       //Initializing Components..
       captureBtn = new JButton("Capture");
       imageViewLabel = new JLabel();
       closeBtn = new JButton("Close");

       //Adding Image Label to the panel...
       panel.add(imageViewLabel,BorderLayout.CENTER);
       panel.setBackground(Color.LIGHT_GRAY);

       //Removing Focus form JButton Text's
        captureBtn.setFocusPainted(false);
        closeBtn.setFocusPainted(false);

       //Adding panel and Buttons to the JFrame....
       add(panel);
       add(captureBtn);
       add(closeBtn);
       panel.setBounds(5,5,320,240);
       captureBtn.setBounds(50,250,95,25);
       closeBtn.setBounds(200,250,80,25);

       //Webcam ..

        //Initializing Web Cam...
       webcam = Webcam.getDefault();

       //Setting Image Dimension...
       webcam.setViewSize(new Dimension(320,240));

       //Now Open Camera for Capturing image....
       webcam.open();


       //Set Loction for frame where to come from at the time of starting...
        setLocationRelativeTo(null);
        setVisible(true);

        //Setting Action Listner to the Capture Btn...
       captureBtn.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {

               //Getting Image...
               Image image = webcam.getImage();
               imageViewLabel.setIcon(new ImageIcon(image));
               try {
                   //Reading Image and givinf name and file path...
                   ImageIO.write(webcam.getImage(), "JPG", new File("CapturePhoto/photo.jpg"));
               } catch (IOException ioException) {
                   ioException.printStackTrace();

               }
           }
       });

       //Setting Action Listner to the Close Button...
        closeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                webcam.close();
                dispose();
            }
        });
    }
}
