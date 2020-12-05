package window.createelection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.EventListener;

public interface CandidateFormPanelListner extends EventListener {
    public void candidateFormEventOccured(CandidateFormPanelEvent e) throws IOException;
}
