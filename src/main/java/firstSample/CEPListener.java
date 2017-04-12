package firstSample;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by sisaberi on 11/04/2017.
 */
public class CEPListener implements UpdateListener {
    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("Event received: "
                + newData[0].getUnderlying());
    }
}

