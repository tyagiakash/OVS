package window.createelection;

import java.sql.SQLException;
import java.util.EventListener;

public interface FormPanelListner extends EventListener {
    public void formPanelEventOccured(FormPanelEvent e) throws SQLException;
}
