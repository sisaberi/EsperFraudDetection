package esperServices;

import com.espertech.esper.client.*;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;


/**
 * Created by sisaberi on 19/04/2017.
 */
public class EventClient {
    static Configuration cepConfig = new Configuration();
    static EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
    static EPRuntime cepRT = cep.getEPRuntime();
    static EPAdministrator cepAdm = cep.getEPAdministrator();


    public static void registerEvent(Class eventClass) {
        cepConfig.addEventType(eventClass.getName(), eventClass.getName());
    }

    public static void createQueryAddListener(String q, UpdateListener listener){
        EPStatement cepStatement = cepAdm.createEPL(q);

        cepStatement.addListener(listener);
    }



}

