package esperServices;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by sisaberi on 12/05/2017.
 */
public class UnusualPaymentsFraud implements UpdateListener {

    public void update(EventBean[] newData, EventBean[] oldData) {
        String s = newData[0].get("avg(amount)").toString();

        System.out.println("User has surpassed his avg payment: "
                + s);

    }

}
