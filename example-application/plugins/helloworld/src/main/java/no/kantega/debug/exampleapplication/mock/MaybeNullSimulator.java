package no.kantega.debug.exampleapplication.mock;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class MaybeNullSimulator implements InvocationHandler {
	
	public  PotentialNull simulate() {
		return (PotentialNull) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{PotentialNull.class}, this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if(method.getName().equals("toString")) {
			return "some string";
		} else if(lucky()) {
			return proxy;
		} else {
			System.err.println("Simulating null response for " + method.getName());
			return null;
		}
	}

	private boolean lucky() {
		return new Random().nextInt(6) > 0;
	}

}
