package esperServices;

import com.espertech.esper.client.*;
import events.PaymentEvent;
import org.json.simple.JSONArray;
import util.EsperQueries;
import util.RandomEventGenerator;

/**
 * Created by sisaberi on 12/05/2017.
 */
public class EsperEndpoints {

    public static Configuration cepConfig = new Configuration();


    public static EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
    public static EPRuntime cepRT = cep.getEPRuntime();

    public static EPAdministrator cepAdm = cep.getEPAdministrator();
    public static EPStatement cepStatement = cepAdm.createEPL(EsperQueries.unusualPaymentFraudQuery);


    public static void runUnusualPaymentFraud() {
        cepConfig.addEventType("PaymentEvent", PaymentEvent.class.getName());
        cepStatement.addListener(new UnusualPaymentsFraud());
    }

    public static void shootPaymentEvent(PaymentEvent e) {
        cepRT.sendEvent(e);
    }

}
