package login;

import java.util.EventObject;

public class FormEvent extends EventObject {

    private String userId;
    private String password;
    private String userType;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source,String mUserId,String mPassword,String mUserType ) {
        super(source);
        this.userType = mUserType;
        this.userId = mUserId;
        this.password = mPassword;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }




}
