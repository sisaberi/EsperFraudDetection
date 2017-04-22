package esperServices;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by sisaberi on 22/04/2017.
 */
public class LocationFraudListener implements UpdateListener {

    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("Location fraud detected: "
                + newData[0].getUnderlying());
    }
}



