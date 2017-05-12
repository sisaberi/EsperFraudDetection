package util;

/**
 * Created by sisaberi on 22/04/2017.
 */
public class EsperQueries {


    public static String userHomeTown = "Konstanz";

    public static String userSecondLocation = "Singen";

    public static String userThirdLocation = "Keurzlingen";

    public static int minMilisAfterLogin = 10000;

    public static double allTimePaymentAmountAverage = 500;

    public static int maxPaymentsInTimefFrame = 10;


    public static String locationFraudQuery = "select * \n" +
            "from PaymentEvent as pay\n" +
            "where pay.location not in ('Konstanz','Singen')";

    public static String unusualPaymentFraudQuery = "select avg(amount)" +
            "from PaymentEvent.win:length(5)" +
            "group by userId \n" +
            "having avg(amount)>" + allTimePaymentAmountAverage;

    public static String tooFastPaymentFraudQuery = "select * from \n" +
            "    pattern [every l=LoginEvent ->" +
            " p=PaymentEvent(l.userId=p.userId AND (p.timestamp.toMillisec()-l.timestamp.toMillisec())<=" + minMilisAfterLogin + ")]";

    public static String tooManyPaymentsFraudQuery = "select count(id)" +
            "from PaymentEvent.win:time(10)" +
            "group by userId \n" +
            "having count(id)>=" + maxPaymentsInTimefFrame;
}
