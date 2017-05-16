package esperServices;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class LocationFraudListenerWithCompare implements UpdateListener {

    private int minDistanceTime = 10;


    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("***Location fraud detected***");

        System.out.println("***Previous Login***");
        System.out.println(newData[0].get("l1"));
        System.out.println("********************");
        System.out.println("***actual Login***");
        System.out.println(newData[0].get("l2"));
        System.out.println("");
        System.out.println("");






    }
}