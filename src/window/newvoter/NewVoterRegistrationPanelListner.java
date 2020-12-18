package window.newvoter;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.EventListener;

public interface NewVoterRegistrationPanelListner extends EventListener {
    public void newRegistrtionPanelEventOccured(NewVoterRegistrationPanelEvent e) throws FileNotFoundException, SQLException;
}
