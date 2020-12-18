package window.searchvoter;

import java.io.IOException;
import java.sql.SQLException;

public interface SearchFrameListner {
     public void framelistnerActivate(String textField,String type) throws SQLException, IOException;
}
