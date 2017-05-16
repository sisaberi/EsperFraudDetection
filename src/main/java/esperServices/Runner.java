package esperServices;

import com.espertech.esper.client.*;
import events.LoginEvent;
import events.PaymentEvent;
import util.EsperQueries;
import util.RandomEventGenerator;

/**
 * Created by sisaberi on 19/04/2017.
 */
public class Runner {
    public static void main(String[] args) {

        Configuration cepConfig = new Configuration();

        cepConfig.addEventType("PaymentEvent", PaymentEvent.class.getName());
        cepConfig.addEventType("LoginEvent", LoginEvent.class.getName());


        EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        EPRuntime cepRT = cep.getEPRuntime();

        runTooLocationFraudWithCompare(cepRT, cep);
        runTooFastPaymentFraud(cepRT, cep);

        //runLocationFraud(cepRT,cep);

        //runUnusualPaymentFraud(cepRT,cep);
    }


    public static void runLocationFraud(EPRuntime cepRT, EPServiceProvider cep) {
        EPAdministrator cepAdm = cep.getEPAdministrator();
        EPStatement cepStatement = cepAdm.createEPL(EsperQueries.SIMPLE_LOCATION_FRAUD);

        cepStatement.addListener(new LocationFraudListener());

        for (int i = 0; i < 100; i++) {
            RandomEventGenerator.GenerateRandomLocationAndPayment(cepRT);
        }
    }


    public static void runUnusualPaymentFraud(EPRuntime cepRT, EPServiceProvider cep) {
        EPAdministrator cepAdm = cep.getEPAdministrator();
        EPStatement cepStatement = cepAdm.createEPL(EsperQueries.UNUSUAL_PAYMENT_FRAUD);

        cepStatement.addListener(new UnusualPaymentsFraud());

        for (int i = 0; i < 100; i++) {
            RandomEventGenerator.GenerateRandomPayment(cepRT);
        }
    }

    public static void runTooFastPaymentFraud(EPRuntime cepRT, EPServiceProvider cep) {
        EPAdministrator cepAdm = cep.getEPAdministrator();
        EPStatement cepStatement = cepAdm.createEPL(EsperQueries.TOO_FAST_PAYMENT_FRAUD);

        cepStatement.addListener(new TooFastPaymentListener());

        for (int i = 0; i < 100; i++) {
            RandomEventGenerator.GenerateRandomTooFastPaymentlong(cepRT);
        }
    }

    public static void runTooLocationFraudWithCompare(EPRuntime cepRT, EPServiceProvider cep) {
        EPAdministrator cepAdm = cep.getEPAdministrator();
        EPStatement cepStatement = cepAdm.createEPL(EsperQueries.ADVANCED_LOCATION_FRAUD);

        cepStatement.addListener(new LocationFraudListenerWithCompare());

        for (int i = 0; i < 100; i++) {
            RandomEventGenerator.GenerateRandomLogins(cepRT);
        }
    }


}
