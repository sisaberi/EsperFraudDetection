package esperServices;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class DailyPaymentLimitListener implements UpdateListener {

    public void update(EventBean[] newData, EventBean[] oldData) {

        System.out.println("User has surpassed his daily payment limit:" + newData[0].getUnderlying());
    }
}
