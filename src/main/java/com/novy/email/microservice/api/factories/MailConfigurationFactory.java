package com.novy.email.microservice.api.factories;

import com.novy.email.microservice.api.SendEmailRequest;
import com.novy.email.microservice.sender.configuration.MailConfiguration;
import com.novy.email.microservice.sender.message.EmailAddress;

/**
 * Created by novy on 18.02.15.
 */
public class MailConfigurationFactory {

    public MailConfiguration fromRequest(SendEmailRequest request) {
        return new MailConfiguration(
                EmailAddress.of(request.getSender()),
                request.getPassword()
        );
    }
}
