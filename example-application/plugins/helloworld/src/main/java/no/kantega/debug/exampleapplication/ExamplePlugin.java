package no.kantega.debug.exampleapplication;

import org.kantega.reststop.api.Config;
import org.kantega.reststop.jaxrsapi.DefaultJaxRsPlugin;

/**
 *
 */
public class ExamplePlugin extends DefaultJaxRsPlugin{

    @Config
    private String greeting;

    public ExamplePlugin() {
        addJaxRsSingletonResource(new HelloworldResource(greeting));
        addJaxRsSingletonResource(new NullPointerResource());
        addJaxRsSingletonResource(new LeakResource());
        addJaxRsSingletonResource(new DeadlockResource());
    }

}