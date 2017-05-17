package util;

/**
 * Created by sisaberi on 22/04/2017.
 */
public class EsperQueries {


    public static String USER_HOME_TOWN = "Konstanz";

    public static String USER_SECOND_LOCATION = "Singen";

    public static String USER_THIRD_LOCATION = "Kreuzlingen";

    public static int MIN_MILLIS_AFTER_LOGIN = 5000;

    public static int MIN_MILLIS_AFTER_LOCATION_CHANGE=5000;

    public static double ALL_TIME_PAYMENT_AVG = 500;

    public static double DAILY_PAYMENT_LIMIT = 2000;


    public static int MAX_PAYMENTS_IN_TIME_FRAME = 10;


    public static String SIMPLE_LOCATION_FRAUD = "select * \n" +
            "from PaymentEvent as pay\n" +
            "where pay.location not in ('Konstanz','Singen')";




    public static String ADVANCED_LOCATION_FRAUD = "select *" +
            "from pattern [every (l1=LoginEvent->l2=LoginEvent" +
            "(l1.userId=l2.userId AND l1.location != l2.location " +
            "AND l2.timestamp.toMillisec()-l1.timestamp.toMillisec()<="
            +MIN_MILLIS_AFTER_LOCATION_CHANGE+ "))]";



    public static String UNUSUAL_PAYMENT_FRAUD = "select avg(amount)" +
            "from PaymentEvent.win:length(5)" +
            "group by userId \n" +
            "having avg(amount)>" + ALL_TIME_PAYMENT_AVG;




    public static String DAILY_LIMIT_EXCEEDED = "select userId,SUM(amount) " +
            "from PaymentEvent.win:time(1 day) " +
            "GROUP BY userId,timestamp.toDate() " +
            "having SUM(amount)>"+DAILY_PAYMENT_LIMIT;



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

