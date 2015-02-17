package com.novy.email.microservice.sender.factories;

import com.novy.email.microservice.sender.configuration.MailConfiguration;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

/**
 * Created by novy on 17.02.15.
 */
public class MailerFactory {

    public Mailer fromConfiguration(MailConfiguration configuration) {

        return new Mailer(
                configuration.smtpServer(),
                configuration.tlsPort(),
                configuration.username(),
                configuration.password(),
                TransportStrategy.SMTP_TLS
        );

    }
}
