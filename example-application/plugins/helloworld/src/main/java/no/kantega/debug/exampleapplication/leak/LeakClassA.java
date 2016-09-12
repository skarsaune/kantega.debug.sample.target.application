package no.kantega.debug.exampleapplication.leak;

public class LeakClassA {
	private final LeakClassB b1=new LeakClassB();
	private final LeakClassB b2=new LeakClassB();
	private final LeakClassC c1=new LeakClassC();
	private final LeakClassC c2=new LeakClassC();
	private final LeakClassC c3=new LeakClassC();
	
	@Override
	public String toString() {
		return "b1:" + b1 + ",b2:" + b2 + ",c1:" + c1 + ",c2:" + c2 + ",c3:" + c3;
	}
}
