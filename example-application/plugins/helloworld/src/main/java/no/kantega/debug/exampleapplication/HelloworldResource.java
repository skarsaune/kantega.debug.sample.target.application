package no.kantega.debug.exampleapplication;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 */
@Path("helloworld")
public class HelloworldResource {

    private final String greeting;

    public HelloworldResource(String greeting) {

        this.greeting = greeting;
    }

    @GET
    @Produces({"application/json", "application/xml" })
    public Hello hello() {
        return new Hello(greeting + " world");
    }
}
