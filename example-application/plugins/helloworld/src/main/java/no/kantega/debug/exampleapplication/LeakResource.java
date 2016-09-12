package no.kantega.debug.exampleapplication;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import no.kantega.debug.exampleapplication.leak.LeakClassA;

/**
 * Convenience resource to simulate arbitrary {@link #NullPointerException}
 */
@Path("leak")
public class LeakResource {
	
	static List<LeakClassA> cache=new LinkedList<>(Arrays.asList(new LeakClassA()));

    @GET
    @Produces({"application/json", "application/xml" })
    @Path("push")
    public Integer push() {
    	cache.add(new LeakClassA());
    	return cache.size();
    }
    
    @GET
    @Produces({"application/json", "application/xml" })
    @Path("pop")
    public Integer pop() {
    	if(!cache.isEmpty())
    	{
    		cache.remove(cache.get(0));
    	}    	
    	return cache.size();
    }
    
}
