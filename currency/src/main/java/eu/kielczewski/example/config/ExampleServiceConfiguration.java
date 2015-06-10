package eu.kielczewski.example.config;

import com.yammer.dropwizard.config.Configuration;

import javax.validation.Valid;

public class ExampleServiceConfiguration extends Configuration {

    @Valid
    private MessagesConfiguration messages;

    public MessagesConfiguration getMessages() {
        return messages;
    }

    public void setMessages(MessagesConfiguration messages) {
        this.messages = messages;
    }
}