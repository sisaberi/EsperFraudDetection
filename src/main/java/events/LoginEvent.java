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

    public LoginEvent(int id, String ipAddress, long timestamp, int userId) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.timestamp = new Date(timestamp);
        this.userId = userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "LoginEvent{" +
                "id=" + id +
                ", ipAddress='" + ipAddress + '\'' +
                ", timestamp=" + timestamp +
                ", userId=" + userId +
                '}';
    }



}
