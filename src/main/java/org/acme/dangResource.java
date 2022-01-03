package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/dang")
public class dangResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String dang() {
        return "dang!!! Reactive";
    }
}