package window.createelection;

import java.util.EventObject;

public class FormPanelEvent extends EventObject {

    private String id;
    private String title;
    private Integer noOfCandidate;
    private String place;
    private String date;

    public FormPanelEvent(Object source) {
        super(source);
    }
    public FormPanelEvent(Object source,String id,String title,Integer noOfCandidate,String place,String date){
        super(source);
        this.id=id;
        this.title=title;
        this.noOfCandidate=noOfCandidate;
        this.place=place;
        this.date =date;

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getNoOfCandidate() {
        return noOfCandidate;
    }

    public String getPlace() {
        return place;
    }

    public String getDate() {
        return date;
    }
}

