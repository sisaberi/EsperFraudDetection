package util;

/**
 * Created by sisaberi on 22/04/2017.
 */
public class EsperQueries {

    public static String locationFraudQuery = "select * \n" +
            "from LoginEvent.win:time(10) as log, PaymentEvent.win:time(10) as pay\n" +
            "where log.ipAddress != pay.ipAddress AND log.userId=pay.userId";
}
