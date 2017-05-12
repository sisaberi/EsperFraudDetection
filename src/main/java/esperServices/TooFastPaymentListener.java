package esperServices;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by sisaberi on 12/05/2017.
 */
public class TooFastPaymentListener implements UpdateListener {

    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("ToFastPayment fraud detected: "
                + newData[0].getUnderlying());
    }
}