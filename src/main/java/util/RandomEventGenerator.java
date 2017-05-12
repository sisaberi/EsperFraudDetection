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
            locArray = {EsperQueries.userHomeTown, "FraudCity"};

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

        int wait = generator.nextInt(1000000);

        for (int i = 0; i < wait; i++) {
            int x = i*2;
        }

        //creating random payment
        double amount = (double) generator.nextInt(10);
        timeStamp = System.currentTimeMillis();
        PaymentEvent pm = new PaymentEvent(1, amount, "bla2", timeStamp, userId);

        System.out.println(pm.toString());

        cepRT.sendEvent(pm);

    }


}