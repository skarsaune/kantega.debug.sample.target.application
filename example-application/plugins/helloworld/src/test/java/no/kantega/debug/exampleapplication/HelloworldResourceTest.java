package no.kantega.debug.exampleapplication;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class HelloworldResourceTest {

    @Test
    public void shouldReturnHelloworld() {
        assertThat(new HelloworldResource("Hello").hello().getMessage(), containsString("world"));
    }
}
