package esperServices;

import events.LoginEvent;
import events.PaymentEvent;
import firstSample.CEPListener;

/**
 * Created by siriHome on 19/04/2017.
 */
public class Runner {

    public static void main(String[] args) {
        EventClient.registerEvent(LoginEvent.class);
        EventClient.registerEvent(PaymentEvent.class);

        CEPListener lis = new CEPListener();

        EventClient.createQueryAddListener("bla",lis);

    }


}
