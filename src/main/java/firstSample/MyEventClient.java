package firstSample;

import com.espertech.esper.client.*;
import esperServices.LocationFraudListener;
import events.LoginEvent;
import events.PaymentEvent;
import util.RandomEventGenerator;

import java.util.Random;

/**
 * Created by sisaberi on 11/04/2017.
 */
public class MyEventClient {

    private static Random generator = new Random();

    public static void GenerateRandomEvent(EPRuntime cepRT) {
        double price = (double) generator.nextInt(10);
        long timeStamp = System.currentTimeMillis();
        String symbol = "AAPL";
        MyEventPojo ev = new MyEventPojo(symbol, price, timeStamp);
        System.out.println("Sending tick:" + ev);
        cepRT.sendEvent(ev);
    }

    public static void main(String[] args) {
        System.out.println("im here");
        Configuration cepConfig = new Configuration();
        System.out.println(MyEventPojo.class.getName());


        cepConfig.addEventType("LoginEvent", LoginEvent.class.getName());
        cepConfig.addEventType("PaymentEvent", PaymentEvent.class.getName());


        EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        EPRuntime cepRT = cep.getEPRuntime();


        String sampleQ = "select * \n" +
                "from LoginEvent.win:time(10) as log, PaymentEvent.win:time(10) as pay\n" +
                "where log.ipAddress != pay.ipAddress AND log.userId=pay.userId";

        EPAdministrator cepAdm = cep.getEPAdministrator();
        EPStatement cepStatement = cepAdm.createEPL(sampleQ);

        cepStatement.addListener(new LocationFraudListener());

        for (int i = 0; i < 10; i++) {
            RandomEventGenerator.GenerateRandomLoginAndPayment(cepRT);
        }
    }
}
