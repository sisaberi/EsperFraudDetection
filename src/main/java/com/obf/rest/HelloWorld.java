package com.obf.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by siriHome on 09/05/2017.
 */

@Path("/hello")
public class HelloWorld {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getMessage() {

        String output = "Esper Rocks!";

        return Response.status(200).entity(output).build();
    }
}