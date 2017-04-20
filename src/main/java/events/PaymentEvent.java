package events;

import java.util.Date;

/**
 * Created by sisaberi on 14/04/2017.
 */
public class PaymentEvent {

    int id;
    double amount;
    String ipAddress;
    Date timestamp;
    int userId;

    public PaymentEvent(int id,double amount,String ipAddres, Date timestamp, int userId){
        this.id=id;
        this.amount=amount;
        this.ipAddress=ipAddres;
        this.timestamp=timestamp;
        this.userId=userId;
    }


}
