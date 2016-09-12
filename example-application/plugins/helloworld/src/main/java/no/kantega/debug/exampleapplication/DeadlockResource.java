package no.kantega.debug.exampleapplication;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Convenience resource to provoke a deadlock
 */
@Path("deadlock")
public class DeadlockResource {
	private Object monitor1=new Object();
	private Object monitor2=new Object();
	
	private void mutualLock1() {
		synchronized (monitor1) {
			sleep();
			synchronized (monitor2) {
				System.out.println("Required second lock");
			}
		}
	}
	
//	private void lock1()  {
//		synchronized (monitor1) {
//			sleep();
//		}
//	}

	private void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
	}

//	private void lock2()  {
//		synchronized (monitor2) {
//			sleep();
//		}
//	}
	
	private void mutualLock2() {
		synchronized (monitor2) {
			sleep();
			synchronized (monitor1) {
				System.out.println("Retrieved second lock");
			}
		}

	}
	
	@GET
    @Produces({"application/json", "application/xml" })
    public String hello()  {
        final StringBuilder log=new StringBuilder();
        log.append(new Date() +  " Entering deadlock method");
//        mutualLock1();
        ForkJoinPool.commonPool().execute(new Runnable(){

			@Override
			public void run() {
				mutualLock2();
			}});
        ForkJoinPool.commonPool().execute(new Runnable(){

			@Override
			public void run() {
				mutualLock1();
			}});
        
        log.append(new Date() + " phew! left deadlock method");
        return log.toString();
    }
	
	
	

    
}
