package util;

import com.espertech.esper.client.EPRuntime;
import events.LoginEvent;
import events.PaymentEvent;

import java.util.Random;

/**
 * Created by sisaberi on 22/04/2017.
 */
public class RandomEventGenerator {

    private static Random generator = new Random();

    private static String[]
            locArray = {EsperQueries.USER_HOME_TOWN, "Hamburg","Köln","Zürich","Stuttgart"};

    public static void GenerateRandomLocationAndPayment(EPRuntime cepRT) {
        long timeStamp = System.currentTimeMillis();
        int userId = 22;
        //creating random payment
        double amount = (double) generator.nextInt(10);

        String ip2 = locArray[generator.nextInt(2)];

        timeStamp = System.currentTimeMillis();

        PaymentEvent pm = new PaymentEvent(1, amount, ip2, timeStamp, userId);

        cepRT.sendEvent(pm);

    }

    public static void GenerateRandomPayment(EPRuntime cepRT) {
        long timeStamp = System.currentTimeMillis();

        int userId = generator.nextInt(100);
        //creating random payment
        double amount = (double) generator.nextInt(1000);

        String ip2 = locArray[generator.nextInt(2)];

        timeStamp = System.currentTimeMillis();

        PaymentEvent pm = new PaymentEvent(1, amount, ip2, timeStamp, userId);

        cepRT.sendEvent(pm);
    }


    public static void GenerateRandomTooFastPaymentlong(EPRuntime cepRT) {
        long timeStamp = System.currentTimeMillis();
        int userId = generator.nextInt(100);
        LoginEvent lg = new LoginEvent(1, "bla", timeStamp, userId);
        cepRT.sendEvent(lg);

        System.out.println(lg.toString());
        //delay some time

        int wait = generator.nextInt(50000);

        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            System.out.println("This will never happen...");
        }

        //creating random payment
        double amount = (double) generator.nextInt(10);
        timeStamp = System.currentTimeMillis();
        PaymentEvent pm = new PaymentEvent(1, amount, "bla2", timeStamp, userId);

        System.out.println(pm.toString());

        cepRT.sendEvent(pm);

    }

    public static void GenerateRandomLogins(EPRuntime cepRT) {
        long timeStamp = System.currentTimeMillis();
        int userId = generator.nextInt(100);
        String ip2 = locArray[generator.nextInt(2)];

        LoginEvent lg = new LoginEvent(1, ip2, timeStamp, userId);
        cepRT.sendEvent(lg);
        //delay some time

        int wait = generator.nextInt(4000);

        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            System.out.println("This will never happen...");
        }

        long timeStamp1 = System.currentTimeMillis();
        String ip3 = locArray[generator.nextInt(5)];
        LoginEvent lg1 = new LoginEvent(1, ip3, timeStamp1, userId);
        cepRT.sendEvent(lg1);
    }

}