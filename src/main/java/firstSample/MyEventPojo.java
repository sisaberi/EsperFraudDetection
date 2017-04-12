package firstSample;

import java.util.Date;

/**
 * Created by sisaberi on 11/04/2017.
 */
public class MyEventPojo {

    String symbol;
    double price;
    Date timeStamp;

    public MyEventPojo(String s, double p, long t) {
        symbol = s;
        price = p;
        timeStamp = new Date(t);
    }

    public double getPrice() {
        return price;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public String getSymbol() {
        return symbol;
    }

    public String toString() {
        return "Price: " + price + " time: " + timeStamp.toString();
    }
}
