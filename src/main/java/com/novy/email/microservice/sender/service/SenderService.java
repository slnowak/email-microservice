package com.novy.email.microservice.sender.service;

import com.novy.email.microservice.sender.EmailAddress;
import com.novy.email.microservice.sender.MailConfiguration;
import com.novy.email.microservice.sender.Message;
import com.novy.email.microservice.sender.Sender;
import com.novy.email.microservice.sender.factories.EmailFactory;
import com.novy.email.microservice.sender.factories.MailerFactory;
import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;

import java.util.Collection;

/**
 * Created by novy on 17.02.15.
 */
public class SenderService {

    private final Sender sender;
    private final EmailFactory emailFactory;
    private final MailerFactory mailerFactory;

    public SenderService(Sender sender, EmailFactory emailFactory, MailerFactory mailerFactory) {
        this.sender = sender;
        this.emailFactory = emailFactory;
        this.mailerFactory = mailerFactory;
    }

    public void send(Message message, MailConfiguration configuration) {
        final Mailer mailer = mailerFactory.fromConfiguration(configuration);
        final Email email = emailFactory.fromMessage(message);

        sender.send(mailer, email);
    }

    public void send(Collection<Message> messages, MailConfiguration configuration) {
        final Mailer mailer = mailerFactory.fromConfiguration(configuration);

        messages.forEach(
                message -> sender.send(
                        mailer,
                        emailFactory.fromMessage(message)
                )
        );

    }
}
