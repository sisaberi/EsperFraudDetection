package util;

/**
 * Created by sisaberi on 22/04/2017.
 */
public class EsperQueries {


    public static String USER_HOME_TOWN = "Konstanz";

    public static String USER_SECOND_LOCATION = "Singen";

    public static String USER_THIRD_LOCATION = "Kreuzlingen";

    public static int MIN_MILLIS_AFTER_LOGIN = 10000;

    public static double ALL_TIME_PAYMENT_AVG = 500;

    public static int MAX_PAYMENTS_IN_TIME_FRAME = 10;


    public static String SIMPLE_LOCATION_FRAUD = "select * \n" +
            "from PaymentEvent as pay\n" +
            "where pay.location not in ('Konstanz','Singen')";




    public static String ADVANCED_LOCATION_FRAUD = "select *" +
            "from pattern [every (l1=LoginEvent->l2=LoginEvent" +
            "(l1.userId=l2.userId AND l1.location != l2.location " +
            "AND l2.timestamp.toMillisec()-l1.timestamp.toMillisec()<"
            +TravelTimeCalculator.getMinTravelTimeBetweenLocations()+ ")]";



    public static String UNUSUAL_PAYMENT_FRAUD = "select avg(amount)" +
            "from PaymentEvent.win:length(5)" +
            "group by userId \n" +
            "having avg(amount)>" + ALL_TIME_PAYMENT_AVG;



    public static String TOO_FAST_PAYMENT_FRAUD = "select * from \n" +
            "    pattern [every l=LoginEvent ->" +
            " p=PaymentEvent(l.userId=p.userId AND " +
            "(p.timestamp.toMillisec()-l.timestamp.toMillisec())<=" + MIN_MILLIS_AFTER_LOGIN + ")]";



    public static String TOO_MANY_PAYMENTS_FRAUD = "select count(id)" +
            "from PaymentEvent.win:time(10 min)" +
            "group by userId \n" +
            "having count(id)>=" + MAX_PAYMENTS_IN_TIME_FRAME;








    String bla = TOO_MANY_PAYMENTS_FRAUD+"a";
}

