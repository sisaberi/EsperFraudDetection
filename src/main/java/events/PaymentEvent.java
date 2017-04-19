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

    public PaymentEvent(int id,double amount,String ipAddres, Date timestamp){
        this.id=id;
        this.amount=amount;
        this.ipAddress=ipAddres;
        this.timestamp=timestamp;
    }


}
