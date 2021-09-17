package rest;

import javax.ws.rs.*;

@Path("/movie/all")
public class MovieResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}