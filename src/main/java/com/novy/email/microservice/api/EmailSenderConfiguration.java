package com.novy.email.microservice.api;

import com.novy.email.microservice.api.factories.MailConfigurationFactory;
import com.novy.email.microservice.api.factories.MessageFactory;
import com.novy.email.microservice.sender.Sender;
import com.novy.email.microservice.sender.factories.EmailFactory;
import com.novy.email.microservice.sender.factories.MailerFactory;
import com.novy.email.microservice.sender.service.SenderService;
import io.dropwizard.Configuration;

/**
 * Created by novy on 17.02.15.
 */
public class EmailSenderConfiguration extends Configuration {

    public EmailFactory emailFactory() {
        return new EmailFactory();
    }

    public MailerFactory mailerFactory() {
        return new MailerFactory();
    }

    public Sender sender() {
        return new Sender();
    }

    public SenderService senderService() {
        return new SenderService(
                sender(), emailFactory(), mailerFactory()
        );
    }

    public EmailSenderController emailSenderController() {
        return new EmailSenderController(
                senderService(),
                messageFactory(),
                mailConfigurationFactory()
        );
    }

    private MailConfigurationFactory mailConfigurationFactory() {
        return new MailConfigurationFactory();
    }

    private MessageFactory messageFactory() {
        return new MessageFactory();
    }


}
