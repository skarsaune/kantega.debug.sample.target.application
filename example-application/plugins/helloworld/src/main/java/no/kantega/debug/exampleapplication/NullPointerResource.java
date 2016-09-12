package no.kantega.debug.exampleapplication;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import no.kantega.debug.exampleapplication.mock.MaybeNullSimulator;
import no.kantega.debug.exampleapplication.mock.PotentialNull;

/**
 * Convenience resource to simulate arbitrary {@link #NullPointerException}
 */
@Path("maybenull")
public class NullPointerResource {

    @GET
    @Produces({"application/json", "application/xml" })
    public Object russianRoulette() {
    	try {
    		a().b().c().d().e().f().toString();//NullPointerException may occur at any point
    		return "Lucky you!";
    	}
    	catch(NullPointerException e) {
    		e.printStackTrace();
    		StringWriter buffer = new StringWriter();
			e.printStackTrace(new PrintWriter(buffer));
    		return buffer.toString();
    	}
    }

	private PotentialNull a() {
		return new MaybeNullSimulator().simulate().a();
	}
}
