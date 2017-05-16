package events;

import java.util.Date;

/**
 * Created by sisaberi on 19/04/2017.
 */
public class LoginEvent {

    int id;
    String location;
    Date timestamp;
    int userId;

    public LoginEvent(int id, String location, long timestamp, int userId) {
        this.id = id;
        this.location = location;
        this.timestamp = new Date(timestamp);
        this.userId = userId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "LoginEvent{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", timestamp=" + timestamp +
                ", userId=" + userId +
                '}';
    }


}
