package rest;

import esperServices.EsperEndpoints;
import org.json.simple.JSONArray;
import util.RandomEventGenerator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by sisaberi on 12/05/2017.
 */

@Path("/PaymentSimulation")
public class PaymentSimulation {


    @GET
    @Produces({MediaType.TEXT_PLAIN})
    public void getEvents() {
         EsperEndpoints.runUnusualPaymentFraud();
    }
}
