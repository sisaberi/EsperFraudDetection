package firstSample;

import com.espertech.esper.client.*;

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
        System.out.println("im here 2");

        cepConfig.addEventType("MyEvent", MyEventPojo.class.getName());

        EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        EPRuntime cepRT = cep.getEPRuntime();

        EPAdministrator cepAdm = cep.getEPAdministrator();
        EPStatement cepStatement = cepAdm.createEPL("select * from " +
                "MyEvent(symbol='AAPL').win:length(2) " +
                "having avg(price) > 6.0");

        cepStatement.addListener(new CEPListener());

        for (int i = 0; i < 5; i++) {
            GenerateRandomEvent(cepRT);
        }
    }
}
