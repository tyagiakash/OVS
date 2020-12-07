package window.viewelection;

import java.io.IOException;
import java.sql.SQLException;

public interface HeadPanelListner {
    public void ButtonClicked(String btn,String id) throws IOException, SQLException;
}
