import login.MainFrame;
import model.Database;
import splash.InternetErrorr;
import splash.SplashScreen;
import window.MainWindow;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.Timer;


// Main Class for Entering into the App
public class App {

    public static void main(String[] args) throws SQLException {

        SplashScreen sp = new SplashScreen();


        //Use multithreading fro Concurrently loading the jdbc driver and splash screen...

        new Thread(new Runnable() {
            @Override
            public void run() {

                //First Check Whether Internet is Connected or not...

                try {

                    URL url = new URL("http://www.google.com");
                    URLConnection connection = url.openConnection();
                    connection.connect();



                    //Starting Another Thread to Load a new Splash Screen...
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            sp.setVisible(true);
                        }
                    }).start();

                    //Loading JDBC Driver and create Connection and after this Close Window....
                    Database db = new Database();
                    db.createConnection();
                    new MainFrame();
                    sp.dispose();

                } catch (IOException e) {
                    new InternetErrorr();
                }
            }
        }).start();

    }
}
