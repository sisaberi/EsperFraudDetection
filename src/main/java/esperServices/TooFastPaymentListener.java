package esperServices;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by sisaberi on 12/05/2017.
 */
public class TooFastPaymentListener implements UpdateListener {

    public void update(EventBean[] newData, EventBean[] oldData) {

        System.out.println("**********************************");
        System.out.println("***ToFastPayment fraud detected***");
        System.out.println("*************Login****************");
        System.out.println("***"+newData[0].get("l")+"***");
        System.out.println("*************Payment**************");
        System.out.println("***"+newData[0].get("p")+"***");
        System.out.println("**********************************");





    }
}