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


        cepConfig.addEventType("LoginEvent", LoginEvent.class.getName());
        cepConfig.addEventType("PaymentEvent", PaymentEvent.class.getName());


        EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        EPRuntime cepRT = cep.getEPRuntime();


        EPAdministrator cepAdm = cep.getEPAdministrator();
        EPStatement cepStatement = cepAdm.createEPL(EsperQueries.locationFraudQuery);

        cepStatement.addListener(new LocationFraudListener());

        for (int i = 0; i < 10; i++) {
            RandomEventGenerator.GenerateRandomLoginAndPayment(cepRT);
        }
    }


}
