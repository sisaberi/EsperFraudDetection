package util;

import com.espertech.esper.client.EPRuntime;
import events.LoginEvent;
import events.PaymentEvent;
import firstSample.MyEventPojo;

import java.util.Random;

/**
 * Created by sisaberi on 22/04/2017.
 */
public class RandomEventGenerator {

    private static Random generator = new Random();

    private static String[] ipArray = {"111", "001", "111", "111"};

    public static void GenerateRandomLoginAndPayment(EPRuntime cepRT) {
        long timeStamp = System.currentTimeMillis();
        String ip = ipArray[generator.nextInt(4)];

        int userId = generator.nextInt(100);
        LoginEvent lg = new LoginEvent(1, ip, timeStamp, userId);
        cepRT.sendEvent(lg);



        //creating random payment
        double amount = (double) generator.nextInt(10);

        String ip2 = ipArray[generator.nextInt(4)];

        timeStamp = System.currentTimeMillis();

        PaymentEvent pm = new PaymentEvent(1, amount, ip2, timeStamp, userId);

        cepRT.sendEvent(pm);


    }
}
