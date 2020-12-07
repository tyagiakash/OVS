package window;

import java.io.IOException;
import java.sql.SQLException;

public interface MenuListner {
    public void  buttonClicked(String btn) throws SQLException, IOException;
}
