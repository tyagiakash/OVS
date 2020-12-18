import login.MainFrame;
import model.Database;
import window.searchvoter.SearchFrame;

import java.sql.SQLException;

// Main Class for Entering into the App
public class App {
    public static void main(String[] args) throws SQLException {
        //Creating  Instance of Login Frame
//        new MainFrame();
        new window.MainWindow();
//        new SearchFrame();
    }
}
