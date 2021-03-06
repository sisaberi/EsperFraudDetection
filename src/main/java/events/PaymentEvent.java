package events;

import java.util.Date;

/**
 * Created by sisaberi on 14/04/2017.
 */
public class PaymentEvent {

    int id;



    double amount;
    String location;
    Date timestamp;
    int userId;

    public PaymentEvent(int id, double amount, String location, long timestamp, int userId) {
        this.id = id;
        this.amount = amount;
        this.location = location;
        this.timestamp = new Date(timestamp);
        this.userId = userId;
    }


    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "PaymentEvent{" +
                "id=" + id +
                ", amount=" + amount +
                ", location='" + location + '\'' +
                ", timestamp=" + timestamp +
                ", userId=" + userId +
                '}';
    }
}
