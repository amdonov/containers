package eu.kielczewski.example.config;
import javax.validation.constraints.NotNull;
/**
 * MessagesConfiguration.java
 * This class accesses the hello in the yml and is called upon by ExampleServiceConfiguration
 */
public class MessagesConfiguration {

    @NotNull
    private String hello;
    public String getHello() {
        return hello;
    }
    public void setHello(String hello) {
        this.hello = hello;
    }

}