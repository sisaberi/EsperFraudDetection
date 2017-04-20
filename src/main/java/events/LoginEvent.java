package events;

import java.util.Date;

/**
 * Created by sisaberi on 19/04/2017.
 */
public class LoginEvent {

    int id;
    String ipAddress;
    Date timestamp;
    int userId;

    public LoginEvent(int id, String ipAddress, Date timestamp, int userId){
        this.id=id;
        this.ipAddress=ipAddress;
        this.timestamp=timestamp;
        this.userId = userId;
    }
}
